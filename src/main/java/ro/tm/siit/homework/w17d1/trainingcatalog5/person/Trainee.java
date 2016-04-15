/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog5.person;

import ro.tm.siit.homework.w17d1.trainingcatalog5.Messenger;
import ro.tm.siit.homework.w17d1.trainingcatalog5.TraineeCatalogInterface;

/**
 * @author mcosma
 *
 */
public class Trainee extends Person {
	private TraineeCatalogInterface traineeInterface;

	/**
	 * Constructor for class Trainee that allows settign a name
	 * 
	 * @param name
	 *            the name of the trainee
	 * @param messenger
	 * @param traineeInterface
	 */
	public Trainee(String name, String email, Messenger messenger, TraineeCatalogInterface traineeInterface) {
		super(name, email, messenger);
		this.traineeInterface = traineeInterface;
	}

	@Override
	public void sendFeedback(Person to) throws IllegalArgumentException {
		if (this == to) {
			throw new IllegalArgumentException("cannot send feedback to self");
		}
		if (to instanceof Trainee) {
			throw new IllegalArgumentException("cannot send feedback to another trainee");
		}
		int grade = traineeInterface.getLastGrade(this.getName());
		FeedbackType feedback = FeedbackType.valueOfGrade(grade);
		String subject = "Feedback from " + name;
		String text = feedback.getMessage();
		messenger.sendMessage(to.getEmail(), subject, text);
	}
	
	public int getLastGrade() {
		return traineeInterface.getLastGrade(this.getName());
	}

	public void setMessenger(Messenger messenger) {
		this.messenger = messenger;
	}
}
