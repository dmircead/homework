package ro.tm.siit.homework.w8d13.HappyFamily;

/**
 * 
 * @author mircea
 *
 */
public class ManHF extends PersonHF {
	/**
	 * Constructor of ManHF
	 * 
	 * @param name
	 * @param lastName
	 * @param age
	 */
	public ManHF(String name, String lastName, int age) {
		super(name, lastName, age);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Overrides the method setHappiness() from superclass is happy if he has
	 * good grades and a play station (when age under 18), when he has a
	 * girlfriend or married and coolest gadgets (when over 18).
	 */
	@Override
	public void setHappiness() {
		boolean manHappy = true;
		if (this.age < 18) {
			boolean playStation = true;
			if (goodGrades || playStation) {
				setHappy(manHappy);
			}
		}
		if (getAge() > 18) {
			boolean girlfriend = true;
			setSingle(!girlfriend);
			boolean gadgets = true;
			if (!isSingle() && gadgets) {
				setHappy(manHappy);
			}
		}
	}

}
