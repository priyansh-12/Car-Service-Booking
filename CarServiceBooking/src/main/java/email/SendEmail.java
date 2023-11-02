package email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public void sendMail(String message ,String to)
	{
		//String message = "Hello ! Thanks for Registering on the site ";
		String subject = "  Confirmation ";
		String from = "gamingpm1234@gmail.com";
		sendEmail(message, subject, to, from);
	}
	private  void sendEmail(String message, String subject, String to, String from) {
		// TODO Auto-generated method stub

		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();
		System.out.println("Properties " + properties);

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("gamingpm1234@gmail.com", "iuzb rarf gpsc voqi");
			}

		});

		session.setDebug(true);

		MimeMessage m = new MimeMessage(session);

		try {
			m.setFrom(host);

			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			m.setSubject(subject);

			m.setText(message);

			Transport.send(m);

			System.out.println(" Sent SuccessFully ");

		} catch (MessagingException e) {

			e.printStackTrace();
		}
	}

}
