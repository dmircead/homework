package ro.tm.siit.homework.w9d19.training;

import java.util.Arrays;

/**
 * 
 * @author mircea
 *
 */
public class Catalog implements SiteManagerInterface {
	private String participant;
	private int[] grades = new int[3];
	private String[] participants = new String[4];
	int count = 0;

	/**
	 * Constructor for class sets up 4 participants with name from 1 to 4
	 */
	public Catalog() {
		for (int i = 0; i < getParticipants().length; i++) {
			getParticipants()[i] = "Participant " + String.valueOf(i + 1);
		}

	}

	/**
	 * 
	 * @return participant
	 */
	public String getParticipant() {
		return participant;
	}

	/**
	 * 
	 * @return participants array
	 */
	public String[] getParticipants() {
		return participants;
	}

	/**
	 * 
	 * @return grades
	 */
	public int[] getGrades() {
		return grades;
	}

	/**
	 * method implemented from SiteManagerInterface
	 */
	@Override
	public void printGrades() {
		System.out.println(Arrays.toString(getGrades()));

	}

	/**
	 * method implemented from SiteManagerInterface
	 */
	@Override
	public void printParticipants() {
		System.out.println("There are " + Arrays.toString(getParticipants()) + " participants enrolled...");

	}
}
