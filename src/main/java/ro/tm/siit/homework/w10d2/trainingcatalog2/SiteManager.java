package ro.tm.siit.homework.w10d2.trainingcatalog2;

public class SiteManager extends Person implements IGetMsg {
	/**
	 * constructor for subclass SiteManager
	 * 
	 * @param name
	 * @param email
	 * @param emailpass
	 */

	public SiteManager(String name, String email, String emailpass) {
		super(name, email, emailpass);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sendFeedback() {
		// TODO Auto-generated method stub
		return "Site Manager received the message !";
	}

}
