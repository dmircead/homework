package ro.tm.siit.homework.w12d1.trainingcatalog3;

import ro.tm.siit.homework.w12d1.trainingcatalog3.person.Person;
/**
 * FeedbackSender interface is designed to be used by the objects of type person
 * to send messages between them
 * 
 * @author mircea
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
	void sendFeedback(Person to);

}