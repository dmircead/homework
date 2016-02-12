package ro.tm.siit.homework.w9d19.training;

import java.util.Arrays;

/**
 * 
 * @author mircea
 *
 */
public class Catalog implements SiteManagerInterface {

	private static Participant[] participants = new Participant[4];

	/**
	 * method to create new participants
	 */
	public void createParticipants() {
		for (int i = 0; i < getParticipants().length; i++) {
			participants[i] = new Participant("Participant " + String.valueOf(i + 1));
		}
	}

	/**
	 * 
	 * @return participants
	 */
	public Participant[] getParticipants() {
		return participants;
	}

	/**
	 * method to display grades
	 */
	@Override
	public void printGrades() {
		for (int i = 0; i < getParticipants().length; i++) {
			System.out.println("Grades for " + getParticipants()[i]);
			System.out.println(Arrays.toString(getParticipants()[i].getGrades()));
		}

	}

	/**
	 * method to display total participants
	 */
	@Override
	public void printParticipants() {
		System.out.println("Number of participants is: " + getParticipants().length);
		System.out.println(Arrays.toString(getParticipants()));

	}

	/**
	 * method to display Participant name based on @param name
	 */

	@Override
	public void printParticipantGrade(String name) {
		for (int i = 0; i < getParticipants().length; i++) {
			if (getParticipants()[i].getName().equals(name)) {
				System.out.println("Grades for " + getParticipants()[i] + " are: ");
				getParticipants()[i].printNotes();
				// System.out.println(Arrays.toString(getParticipants()[i].getGrades()));
			}
		}

	}

	/**
	 * method to display media for participants
	 */
	@Override
	public void printMedia() {
		int total = 0;
		for (int i = 0; i < getParticipants().length; i++) {
			total = getParticipants()[i].sumMedia();
			int average = total / getParticipants().length;
			System.out.println("Meidia for " + getParticipants()[i] + " is " + average);

		}
	}

}
