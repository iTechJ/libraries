package itechart.apacheCommons;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestMail  extends TestCase {

	public void testSendMail() {
        String to = "novik.test74@gmail.com";

        // Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                                protected PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication(
                                                        "novik.test76@gmail.com", "Gena1212");
                                }
                        });

        try {
                MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress("novik.test76@gmail.com"));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("Science news");
                message.setText("Millions of tons of plastic end up in oceans each year");

                // send message
                Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
                
	}
	
	public void testReceiveMail() throws Throwable {

        try {
	
            Properties props = new Properties();
            props.setProperty("mail.store.protocol", "imaps");

            Session session = Session.getInstance(props);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", "novik.test76@gmail.com", "Gena1212");

            Folder folder = store.getFolder("inbox");
            folder.open(Folder.READ_ONLY);

            Message[] messages = folder.getMessages(1,5);
            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());
            }

            folder.close(false);
            store.close();
            
    	} catch (Throwable e) {
	    	// TODO Auto-generated catch block
		    e.printStackTrace();
    	}
	}

	
	public TestMail( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( TestMail.class );
    }	
}
