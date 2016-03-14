package ro.tm.siit.homework.w12d1.trainingcatalog3.person;

import ro.tm.siit.homework.w12d1.trainingcatalog3.FeedbackSender;
import ro.tm.siit.homework.w12d1.trainingcatalog3.Messenger;

public abstract class Person implements FeedbackSender {

	protected String name;

	protected String email;

	protected Messenger messenger;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.tm.siit.homework.w11d2.trainingcatalog.person.FeedbackSender#
	 * sendFeedback(ro.tm.siit.homework.w11d2.trainingcatalog.person.Person)
	 */
	@Override
	public abstract void sendFeedback(Person to);

	public boolean checkPersonType(Person toBecheck) {
		boolean checkPersonType = false;
			if (!(this.getClass().equals(toBecheck.getClass()))) 
				return checkPersonType = true;
			return checkPersonType;	

			
	}
}
