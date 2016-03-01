package ro.tm.siit.homework.w10d2.trainingcatalog2;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Class used to send messages via email from Person Trainee to Person Trainer
 * and SiteManager
 * 
 * @author mircea
 *
 */
public class Messager {

	private Trainer tm;
	private SiteManager sm;

	/**
	 * Constructor for class Messager
	 * 
	 * @param tm
	 * @param sm
	 */
	public Messager(Trainer tm, SiteManager sm) {
		this.tm = tm;
		this.sm = sm;
	}

	/**
	 * method used to send messages via email
	 * 
	 * @param pfrom
	 * @param pto
	 * @param msg
	 * @return
	 */
	public boolean sendMessage(Person pfrom, Person pto, String msg) {

		sendMail(pfrom.getEmail(), pto.getEmail(), msg, pfrom.getEmailpass());
		return true;

	}

	/**
	 * it returns type Trainer to method sendMessage when called from catalog
	 * 
	 * @return Trainer tm
	 */
	public Trainer getTrainerm() {
		return tm;
	}

	/**
	 * it returns type SiteManager to method sendMessage when called from
	 * catalog
	 * 
	 * @return SiteManager sm
	 */
	public SiteManager getSitemanagerm() {
		return sm;
	}

	/**
	 * method used to handle javax.mail dependency to be used in method sendMessage
	 * 
	 * @param emailFrom
	 * @param emailTo
	 * @param mesaj
	 */
	public void sendMail(String emailFrom, String emailTo, String mesaj, String pass) {

		final String username = emailFrom;
		final String password = pass;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");

		props.put("mail.smtp.port", "587");
//		props.put("mail.smtp.host", "smtp.mail.yahoo.com");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			String to = emailTo;
			Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Feedback email");
			message.setText(mesaj);

			Transport.send(message);

			System.out.println("sent to " + to);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
