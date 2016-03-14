package ro.tm.siit.homework.w12d1.trainingcatalog3.messenger;

import ro.tm.siit.homework.w12d1.trainingcatalog3.Messenger;
/**
 * 
 * @author mircea
 *
 */
public class SimpleMessenger implements Messenger {

	@Override
	public boolean sendMessage(String email, String subject, String text) {
		System.out.println(email);
		System.out.println(subject);
		System.out.println(text);
		return true;
	}

}
