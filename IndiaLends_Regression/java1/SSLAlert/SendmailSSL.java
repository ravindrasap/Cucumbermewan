package SSLAlert;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Utility.Base;

public class SendmailSSL {

	public static void sendmail(String message) {
		
	//	String Emailconf = Base.loadPropertiesFile("CC_Data.properties", "Email");
		String Emailconf = Base.loadPropertiesFile("SSL.properties", "Email");
		final String fromEmail = "itreports@indialends.com";                  
		final String password =  "IT@reports@123";                  
		final String toEmail = Emailconf; // can be any email id
		//final String toEmail = "ravindrakumar@indialends.com"; 
		//System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
		props.put("mail.smtp.port", "587"); // TLS Port
		//props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

		// create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);

		EmailUtil.sendEmail(session, toEmail, "SSL Certificate Alert", message);
	}

	public static void setRepeating(long timeInMillis, int i) {
		// TODO Auto-generated method stub
		
	}

}
