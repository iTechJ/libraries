package itechart.apacheCommons;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestLoggers extends TestCase {

    public void testLog4j()
    {
    	Logger log = LogManager.getLogger(TestLoggers.class);
    	
    	log.log(Level.INFO, "Test Log4J");
    }
	
    public void testLogBack()
    {
    	org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());
    	
    	log.debug("Test LogBack");
    }
	
	
	public TestLoggers( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( TestLoggers.class );
    }


}
