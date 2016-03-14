package ro.tm.siit.homework.w12d1.trainingcatalog3;

/**
 * The messenger interface is designed to send an email to a person with a
 * subject and a message
 * 
 * @author mircea
 *
 */
public interface Messenger {
	/**
	 * the method send message to the email with the subject and message from
	 * the parameters and return true if the message has been sent
	 * 
	 * @param email
	 *            the email
	 * @param subject
	 *            the subject
	 * @param message
	 *            the message
	 * @return true if the message has been sent and false otherwise
	 */
	boolean sendMessage(String email, String subject, String text);

}
