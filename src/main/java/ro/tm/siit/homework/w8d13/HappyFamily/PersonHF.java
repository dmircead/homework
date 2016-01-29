package ro.tm.siit.homework.w8d13.HappyFamily;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author mircea
 *
 */
public class PersonHF implements PersonType {
	String name;
	String lastName;
	int age;
	Ident identity;
	boolean happy;
	Gender gender;
	boolean single;
	boolean goodGrades;
	PersonHF[] kidsarr = new PersonHF[20];

	/**
	 * Constructor for PersonHF it sets by default single to true and gender to
	 * male
	 * 
	 * @param name
	 * @param lastName
	 * @param age
	 */
	public PersonHF(String name, String lastName, int age) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.single = true;
		this.gender = gender.Male;
		this.happy = false;
		if (this.age < 18)
			this.identity = identity.Kid;
		else
			this.identity = identity.Adult;
		if (identity == identity.Kid)
			this.gender = setGender();

	}

	/**
	 * Getters annd setters for age and gender
	 * 
	 * @return
	 */
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return this.gender;
	}

	/**
	 * Method to set the gender it is used by parameter gender in constructor
	 * 
	 * @return
	 */
	public Gender setGender() {
		boolean ps = true;
		Gender gen = null;
		Scanner in = new Scanner(System.in);
		while (ps) {
			System.out.println("Please select a gender for " + this.name + " (M/F): ");
			String answer = in.nextLine();
			switch (answer) {
			case "M":
				ps = false;
				gen = gender.Male;
				break;
			case "F":
				ps = false;
				gen = gender.Female;
				break;
			default:
				System.out.println("Please enter M or F !");
			}
		}
		return gen;

	}

	/**
	 * used to check for happiness of PersonHF
	 * 
	 * @return
	 */
	public boolean isHappy() {
		return happy;
	}

	/**
	 * 
	 * @param happy
	 */
	public void setHappy(boolean happy) {
		this.happy = happy;
	}

	/**
	 * method to be implemented by subclasses of PersonHF
	 */
	public void setHappiness() {

	}

	/**
	 * 
	 * @return
	 */
	public boolean isSingle() {
		return single;
	}

	/**
	 * 
	 * @param single
	 */
	public void setSingle(boolean single) {
		this.single = single;
	}

	/**
	 * method to add kids to PersonHF
	 * 
	 * @param personKid
	 */
	public void addKids(PersonHF personKid) {
		int index = 0;

		if (personKid.getAge() < 18) {
			kidsarr[index++] = personKid;
			return;
		} else {
			System.out.println("this person is an adult already...");
		}

	}

	@Override
	public String toString() {
		return this.name + " " + this.lastName + " " + getAge() + " " + getGender() + " " + this.identity
				+ " is single: " + this.single + " is happy: " + isHappy();
	}

	/**
	 * Prints out the toString
	 */
	public void printSuper() {
		System.out.println(toString());
	}

	/**
	 * print array kidsarr if not null
	 */
	public void printKids() {
		for (PersonHF crtP : kidsarr) {
			if (crtP != null) {
				System.out.println("Copiii: " + crtP);
			}

		}

	}
}
