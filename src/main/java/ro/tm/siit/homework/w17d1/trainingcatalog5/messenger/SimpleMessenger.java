package ro.tm.siit.homework.w17d1.trainingcatalog5.messenger;

import ro.tm.siit.homework.w17d1.trainingcatalog5.Messenger;

public class SimpleMessenger implements Messenger {
	
	private static SimpleMessenger instance;
	
	private SimpleMessenger() {}
	
	public static SimpleMessenger getInstance() {
		if (instance == null) {
			instance = new SimpleMessenger();
		}
		return instance;
	}

	@Override
	public boolean sendMessage(String email, String subject, String text) {
		System.out.println(email);
		System.out.println(subject);
		System.out.println(text);
		return true;
	}

}
