package itechart.apacheCommons;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestStringUtils extends TestCase {
	
    public void testEmptyString()
    {
    	String[] texts = {"text1", "    ", "", null};
    	
    	for (String text: texts) {
    	
    		System.out.printf("\nChecking text '%s' \n", text);
    		if (text != null && !"".equals(text.trim())) {
            	System.out.printf("Text is not empty %s \n", text);
    		}
    		else {
        	   System.out.printf("Text is empty %s \n", text);
    		}
        
    		if (StringUtils.isNotEmpty(text)) {
        	   System.out.printf("Text is not empty %s \n", text);
    		}
    		else {
        	   System.out.printf("Text is empty %s \n", text);
    		}
    	}
    }
	
    public void testCollectionUtils()
    {
    	System.out.printf("\n\nArray Utils \n");
    	
    	ArrayList<Integer> emptyList = null;
    	
    	if (emptyList == null || emptyList.size() > 0) {
    		System.out.printf("List is empty \n");
    	}
        
    	if (CollectionUtils.isEmpty(emptyList)) {
    		System.out.printf("List is empty \n");
    	}
        
    }
	
    public void testAddDays()
    {
    	System.out.printf("\n\nDate Utils \n");

    	Date date = new Date(System.currentTimeMillis());
    	System.out.printf("Current date is %s \n", date);
        
     	Date newDate = DateUtils.addMonths(date, -1);  // IllegalArgumentException
    	System.out.printf("Month before %s \n", date);
    }
	
    public void testDateFormat()
    {
    	System.out.printf("\n\nDate Format \n");

    	Date date = new Date(System.currentTimeMillis());
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	System.out.printf("Current date is %s \n", sdf.format(date));
        
    	System.out.printf("Other formatter %s \n", DateFormatUtils.format(date, "yyyy-MM-dd"));
    }
    
	public TestStringUtils( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( TestStringUtils.class );
    }


}
