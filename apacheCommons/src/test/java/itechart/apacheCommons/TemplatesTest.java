package itechart.apacheCommons;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupDir;
import org.stringtemplate.v4.STGroupFile;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TemplatesTest extends TestCase {

	
	public void testCreateFile()
    {
        ST hello = new ST("Hello, <name>");
        hello.add("name", "World");
        System.out.println(hello.render());
    }
    
	
    public void testLoadFromFile()
    {
        STGroup group2 = new STGroupFile("group2.stg");

        ST t1 = group2.getInstanceOf("t1");
        t1.add("arg1", "This is template 1");
        t1.add("arg2", 222);
        System.out.println(t1.render());

        ST t2 = group2.getInstanceOf("t2");
        t2.add("arg1", "This is template 2");
        System.out.println(t2.render());

        ST t3 = group2.getInstanceOf("t3");
        t3.add("arg1", "This is template 3");
        System.out.println(t3.render());
    }
	
    public void testLoadFromDirectory()
    {
        STGroup group1 = new STGroupDir("group1", '$','$');
        
        ST address = group1.getInstanceOf("address");
        address.add("city", "Minsk");
        address.add("street", "Masherov ave.");
        address.add("house", "115-23");
        System.out.println(address.render());
    }
	
    public void testVelocity() throws IOException
    {
    	VelocityEngine ve = new VelocityEngine();
        ve.init();

        VelocityContext vc = new VelocityContext();
        vc.put("fio", "John Smith");

        Template t = ve.getTemplate("./src/main/resources/velo.vm");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t.merge(vc, bw);
        bw.flush();
        bw.close();    
    }
	
	
	public TemplatesTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( TemplatesTest.class );
    }
}
