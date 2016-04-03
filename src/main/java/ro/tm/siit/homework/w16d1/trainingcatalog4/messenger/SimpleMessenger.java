package ro.tm.siit.homework.w16d1.trainingcatalog4.messenger;

import ro.tm.siit.homework.w16d1.trainingcatalog4.Messenger;

/**
 * The SimpleMessenger class implements Messenger interface and it displays the
 * person that will send an email, the subject and the message of the email.
 * 
 * @author Mircea
 *
 */
public class SimpleMessenger implements Messenger {

	private static SimpleMessenger simpleMessenger;

	/**
	 * Constructor for the simple messenger
	 */
	private SimpleMessenger() {
	}

	/**
	 *
	 * return the same messenger whenever is called
	 * 
	 * @return the same messenger
	 */
	public static SimpleMessenger getInstance() {
		if (simpleMessenger == null) {
			simpleMessenger = new SimpleMessenger();
		}
		return simpleMessenger;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ro.tm.siit.w16.trainingcatalog4.Messenger#sendMessage(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean sendMessage(String email, String subject, String text) {
		System.out.println(email);
		System.out.println(subject);
		System.out.println(text);
		return true;
	}

}
