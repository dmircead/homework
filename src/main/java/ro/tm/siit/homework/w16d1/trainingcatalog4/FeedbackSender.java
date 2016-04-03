package ro.tm.siit.homework.w16d1.trainingcatalog4;

import ro.tm.siit.homework.w16d1.trainingcatalog4.person.Person;

/**
 * FeedbackSender interface designed to be used by the persons to send messages
 * between them
 * 
 * @author Mircea
 *
 */
public interface FeedbackSender {
	/**
	 * sends a message from the person who call the method to the person from
	 * the parameter
	 * 
	 * @param person
	 *            the person to which sent a message
	 */
	void sendFeedback(Person trainer);

}