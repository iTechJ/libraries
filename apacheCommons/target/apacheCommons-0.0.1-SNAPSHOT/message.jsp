<%@ page import="javax.servlet.http.HttpServletRequest" %>
<html>
<body>
<h2>Message</h2>

<div><%= request.getAttribute("message") %></div>
</body>
</html>
