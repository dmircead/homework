package ro.tm.siit.homework.w10d2.trainingcatalog2;

public class Trainer extends Person implements IGetMsg {
/**
 * Constructor for subclass Trainer
 * @param name
 * @param email
 * @param emailpass
 */
	public Trainer(String name, String email, String emailpass) {
		super(name, email, emailpass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sendFeedback() {
		// TODO Auto-generated method stub
		return "Trainer received the message !";
	}

}
