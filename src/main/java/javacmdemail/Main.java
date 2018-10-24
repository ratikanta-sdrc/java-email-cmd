package javacmdemail;
import java.io.FileReader;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Main {
	
	public static void main(String[] args) {
		
		
		String fromUsername = null;
		String password = null;
		String toEmailId = null;
		String subject = null;
		String body = null;
		try{
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(args[0]));

            JSONObject jsonObject = (JSONObject) obj;
			
			fromUsername = (String) jsonObject.get("fromUsername");
			password = (String) jsonObject.get("password");
			toEmailId = (String) jsonObject.get("toEmailId");
			subject = (String) jsonObject.get("subject");
			body = (String) jsonObject.get("body");
		
			Main main = new Main();
			main.sendMail(fromUsername, password, toEmailId, subject, body);
			
		}catch(Exception e){
			System.out.println("Invalid input " + e.getMessage());
		}	
		
	}
	
	void sendMail(String fromUsername, String fromUserPassword, String toEmailId, String subject, String body){
		
		try{
		final String username = fromUsername;
		final String password = fromUserPassword;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toEmailId));
			message.setSubject(subject);
			message.setText(body);
			Transport.send(message);
			System.out.println("Email sent");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		}catch(Exception e){
			System.out.println("Could not send email " + e.getMessage());
		}
	}

}
