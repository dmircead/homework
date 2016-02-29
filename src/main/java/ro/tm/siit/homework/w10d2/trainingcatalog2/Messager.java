package ro.tm.siit.homework.w10d2.trainingcatalog2;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Messager {
	
	private Trainer tm;
	private SiteManager sm;
	List<IGetMsg> igetmpersons;

	public Messager(Trainer tm, SiteManager sm) {
		this.tm = tm;
		this.sm = sm;
		igetmpersons = new ArrayList<IGetMsg>();
		igetmpersons.add(sm);
		igetmpersons.add(tm);
	}

	public boolean sendMessage(Person pfrom, Person pto, String msg) {
		
		if(sendMail(pfrom.getEmail(), pto.getEmail(), msg)){
		return true;
		}
		return false;
	}
	
	public void sendFeedB(){
		for (IGetMsg imt : igetmpersons) {
			imt.sendFeedback();
		}
	}
	public Trainer getTrainerm() {
		return  tm;
	}

	public SiteManager getSitemanagerm() {
		return  sm;
	}

	public boolean sendMail(String emailFrom, String emailTo, String mesaj) {
//		Scanner in = new Scanner(System.in);
//		System.out.println("Please provide a password: ");
//		String passw = in.nextLine();
		final String username = emailFrom;
		final String password = "p3*[@iCe";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

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
			return true;

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
