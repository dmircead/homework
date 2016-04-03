/**
 * 
 */
package ro.tm.siit.homework.w16d1.trainingcatalog4.messenger;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ro.tm.siit.homework.w16d1.trainingcatalog4.Messenger;

/**
 * The EmailMessenger class implements Messenger interface and it send an e-mail
 * to a person with the subject and the text message .
 * 
 * @author Mircea
 *
 */
public class EmailMessenger implements Messenger {
	private static EmailMessenger messenger;
	private Session session;

	/**
	 * private Constructor for the EmailMessenger
	 */
	private EmailMessenger() {
		super();

		final String username = "user@gmail.com";
		final String password = "password";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	}

	/**
	 * return the same messenger whenever is called
	 * 
	 * @return the same messenger
	 */
	public static EmailMessenger getMessenger() {
		if (messenger == null) {
			messenger = new EmailMessenger();
		}
		return messenger;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ro.tm.siit.homework.w11d2.trainingcatalog.Messenger#sendMessage(String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean sendMessage(String emailAddress, String subject, String text) {
		try {
			Message email = new MimeMessage(session);
			email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddress));
			email.setSubject(subject);
			email.setText(text);
			Transport.send(email);
		} catch (MessagingException e) {
			return false;
		}
		return true;
	}

}
