package ro.tm.siit.homework.w8d13.HappyFamily;

import java.util.Arrays;

/**
 * 
 * @author mircea
 *
 */
public class WomanHF extends ManHF {
	ManHF manf;

	/**
	 * Constructor for WomanHF
	 * 
	 * @gender to set the gender based on enum Gender to Female
	 * @param name
	 * @param lastName
	 * @param age
	 */
	public WomanHF(String name, String lastName, int age) {
		super(name, lastName, age);
		this.gender = gender.Female;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Overrides the method setHappiness() from superclass is happy if she has
	 * good grades and girlfriends (under age 18), has boyfriend and a career
	 * (age 18-30), if she is married and has kid/s (over age 30).
	 */
	@Override
	public void setHappiness() {
		boolean womenHappy = true;
		boolean girlFriends = true;
		if (getAge() < 18) {
			if (goodGrades && girlFriends) {
				setHappy(womenHappy);
			}
		}
		if (getAge() > 18 && getAge() < 30) {
			boolean boyfriend = true;
			boolean career = true;
			if (boyfriend) {
				setSingle(!boyfriend);
			}
			if (career && !isSingle()) {
				setHappy(womenHappy);
			}
		}
		if (getAge() > 30) {
			boolean kidsW = false;
			for (PersonHF crtP : kidsarr) {
				if (crtP != null) {
					kidsW = true;
				}

			}
			boolean husband = true;
			if (husband) {
				setSingle(husband);
			}
			if (kidsW && isSingle()) {
				setHappy(womenHappy);
			}
		}
	}

}