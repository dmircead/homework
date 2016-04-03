package ro.tm.siit.homework.w16d1.trainingcatalog4.person;

import ro.tm.siit.homework.w16d1.trainingcatalog4.FeedbackSender;
import ro.tm.siit.homework.w16d1.trainingcatalog4.Messenger;
/**
 * Class Person who implements the FeedbackSender interface that models a person
 * with a name , a email address and a messenger
 * 
 * @author Mircea
 *
 */
public abstract class Person implements FeedbackSender, Comparable<Person> {

	protected String name;
	
	protected String email;

	protected Messenger messenger;

    /**
     * Constructor for the person
     * 
     * @param name
     *            the name of the person
     * @param email
     *            the email address of the person
     * @param messenger
     *            the messenger
     */
	public Person(String name, String email, Messenger messenger) {
		this.name = name;
		this.email = email;
		this.messenger = messenger;
	}

	/**
	 * @return the name of the trainee
	 */
	public String getName() {
		return name;
	}
	 /**
     * gets the email address of the person
     * 
     * @return the email of the person
     */
	public String getEmail() {
		return email;
	}

	/* (non-Javadoc)
	 * @see ro.tm.siit.homework.w11d2.trainingcatalog.person.FeedbackSender#sendFeedback(ro.tm.siit.homework.w11d2.trainingcatalog.person.Person)
	 */
	@Override
	public void sendFeedback(Person to) throws IllegalArgumentException {
		if (this != to) {
			messenger.sendMessage(to.getEmail(), "my feed", "...");
		} else {
			throw new IllegalArgumentException("cannot send feedback to self");
		}
	}
	 /**
     * gets the name of the person
     * 
     * @return the name of the person
     */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
	/**
	 * 
	 */
	@Override
	public int compareTo(Person o) {
		return name.compareTo(o.name);
	}
}