package ro.tm.siit.homework.w17d1.trainingcatalog5.person;

import java.io.Serializable;

import ro.tm.siit.homework.w17d1.trainingcatalog5.FeedbackSender;
import ro.tm.siit.homework.w17d1.trainingcatalog5.Messenger;

public abstract class Person implements FeedbackSender, Serializable {

	

	protected String name;
	
	protected String email;

	protected Messenger messenger;

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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

}