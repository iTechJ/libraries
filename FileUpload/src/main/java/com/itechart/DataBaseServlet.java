package com.itechart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class DataBaseServlet extends HttpServlet {

    private final String USER = "root";
    private final String PASSWORD = "101285";
    private final String URL = "jdbc:mysql://localhost:3306/Java";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sql = "SELECT u.user as EMAIL, d.data as DATA FROM data d INNER JOIN users u ON u.id = d.user_id ";
        
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        ResultSetMetaData rsm = null;
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Servlet Database Access</title></head><body>");
        out.println("<h1>Database info</h1>");
        out.println("<table border='1'><tr>");

        try {
            Class.forName(DRIVER);

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            
            rs = statement.executeQuery(sql);
            rsm = rs.getMetaData();
            
            int colCount = rsm.getColumnCount();
            for(int i = 1; i <= colCount; i++) {
                out.println("<th>" + rsm.getColumnLabel(i) + "</th>");
            }
            out.println("</tr>");

            while (rs.next()) {
                out.println("<tr>");
                for(int i = 1; i <= colCount; i++)
                    out.println("<td>" + rs.getString(i) + "</td>");
                out.println("</tr>");
            }

        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException sqle) { }
        }

        out.println("</table><br/><br/>");
        out.println("</body>");
        out.println("</html>");
    }
}
