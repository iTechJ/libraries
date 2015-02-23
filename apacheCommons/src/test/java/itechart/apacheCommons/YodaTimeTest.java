package itechart.apacheCommons;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class YodaTimeTest extends TestCase
{
    public void testCreateDateTime()
    {
    	System.out.printf("\n\nDateTime for any time \n");

    	DateTime dateTime = new DateTime(2012, 8, 1, 3, 20, 12);
    	
    	System.out.printf("Date: %s \n", dateTime.toString("E yyyy-MM-dd HH:mm:ss"));
    }

	
    public void testReadLastDayForPrevMonth()
    {
    	System.out.printf("\n\nCalculate last day for previous month \n");

    	 LocalDate lastDayOfPreviousMonth = LocalDate.now().minusMonths(1).dayOfMonth().withMaximumValue();
    	
    	System.out.printf("Date: %s \n", lastDayOfPreviousMonth.toString("E yyyy-MM-dd"));
    }

    
    public void testChangeZone()
    {
    	System.out.printf("\n\nConvert to other timezone \n");
    	String input = "2014-08-08+02:00";
    	DateTimeFormatter formatter = DateTimeFormat.forPattern( "yyyy-MM-ddZ" ).withZone( DateTimeZone.UTC );
    	DateTime dateTimeUsingOffset = formatter.parseDateTime( input );    
    	
    	System.out.printf("Date %s \n", dateTimeUsingOffset);
    }
	
    
	
	public YodaTimeTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( YodaTimeTest.class );
    }

}
