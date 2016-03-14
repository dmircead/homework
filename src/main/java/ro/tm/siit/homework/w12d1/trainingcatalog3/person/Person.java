package ro.tm.siit.homework.w12d1.trainingcatalog3.person;

import ro.tm.siit.homework.w12d1.trainingcatalog3.FeedbackSender;
import ro.tm.siit.homework.w12d1.trainingcatalog3.Messenger;

/**
 * Class Person used to model a person type object implements with a name , a
 * email address and a messenger
 * 
 * @author mircea
 *
 */
public abstract class Person implements FeedbackSender {

	protected String name;

	protected String email;

	protected Messenger messenger;

	boolean sendIt = false;

	/**
	 * Constructor for the person
	 * 
	 * @param name
	 *            the name of the person
	 * @param emailAddress
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
	 * @return the name of the person
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the email of the person
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @return sendIt being set in sendFeedback();
	 */
	public boolean isSendIt() {
		return sendIt;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.tm.siit.homework.w11d2.trainingcatalog.person.FeedbackSender#
	 * sendFeedback(ro.tm.siit.homework.w11d2.trainingcatalog.person.Person)
	 */
	@Override
	public void sendFeedback(Person to){
		if (checkPersonType(to)) {
			sendIt = true;
		} else {
			System.out.println("Can't send from  " + this.getClass().getSimpleName() + " to another "
					+ to.getClass().getSimpleName());
		}
	}

	/**
	 * checks wether person class equals the other person class
	 * 
	 * @param toBecheck
	 * @return
	 */
	public boolean checkPersonType(Person toBecheck) {
		try {
			return !(this.getClass().equals(toBecheck.getClass()));
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
}
