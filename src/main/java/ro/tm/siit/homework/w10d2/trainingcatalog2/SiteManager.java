package ro.tm.siit.homework.w10d2.trainingcatalog2;

public class SiteManager extends Person implements IGetMsg {

	public SiteManager(String name, String email) {
		super(name, email);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sendFeedback() {
		// TODO Auto-generated method stub
		return "Site Manager received the message !";
	}

}
