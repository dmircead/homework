package ro.tm.siit.homework.w9d19.training;

import java.util.Arrays;

/**
 * Class to model Participant
 * 
 * @author mircea
 *
 */
public class Participant {
	private String name;
	private int[] Grades;
	int count = 0;

	/**
	 * constructor for Partticipant
	 * 
	 * @param name
	 */
	public Participant(String name) {
		this.name = name;
		Grades = new int[3];
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return Grades
	 */
	public int[] getGrades() {
		return Grades;
	}

	/**
	 * method to print grades from this Participant
	 */
	public void printNotes() {
		for (int i = 0; i < getGrades().length; i++) {
			if (!(getGrades()[i] == 0))
				System.out.printf("%d\t", getGrades()[i]);
			
		}
		System.out.println();
	}

	/**
	 * method to calculate total media from participant
	 * 
	 * @return sum
	 */
	public int sumMedia() {
		int sum = 0;
		for (int i = 0; i < getGrades().length; i++) {
			sum += getGrades()[i];
		}
		return sum;
	}

	@Override
	public String toString() {
		return getName();
	}

}
