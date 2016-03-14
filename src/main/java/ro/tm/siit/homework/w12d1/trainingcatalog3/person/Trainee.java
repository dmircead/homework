/**
 * 
 */
package ro.tm.siit.homework.w12d1.trainingcatalog3.person;

import ro.tm.siit.homework.w12d1.trainingcatalog3.FeedbackType;
import ro.tm.siit.homework.w12d1.trainingcatalog3.Messenger;
import ro.tm.siit.homework.w12d1.trainingcatalog3.TraineeCatalogInterface;

/**
 * @author mircea
 *
 */
public class Trainee extends Person {
	private TraineeCatalogInterface traineeTci;

	/**
	 * Constructor for class Trainee that allows setting a name
	 * 
	 * @param name
	 *            the name of the trainee
	 * @param messenger
	 */
	public Trainee(String name, String email, Messenger messenger, TraineeCatalogInterface traineeTci) {
		super(name, email, messenger);
		this.traineeTci = traineeTci;
	}

	@Override
	public void sendFeedback(Person to){
		super.sendFeedback(to);
		if(isSendIt()){
			 messenger.sendMessage(to.getEmail(), "my feed", "super");
			int lastGrade = traineeTci.getLastGrade(this.getName());
			String message = FeedbackType.valueOfgrade(lastGrade);
			messenger.sendMessage(to.getEmail(), "my feed", message);
		}
	}
}
