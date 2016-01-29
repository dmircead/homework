package ro.tm.siit.homework.w8d13.HappyFamily;

/**
 * Creates a family taking man of type person as husband and woman of type
 * person as wife It has method to add kids and chedk happines of husband and
 * wife using method isHappy from superclass of man and woman
 * 
 * @author mircea
 *
 */
public class FamilyHappy {
	PersonHF kids;
	ManHF husband;
	WomanHF wife;

	/**
	 * Constructor
	 * 
	 * @param husband
	 * @param wife
	 */
	public FamilyHappy(ManHF husband, WomanHF wife) {
		this.husband = husband;
		this.wife = wife;
	}

	/**
	 * method to add kids to family
	 * 
	 * @param pk
	 */
	public void addKidsFam(PersonHF pk) {
		wife.addKids(pk);
	}

	/**
	 * method to check if person is happy and displya the result
	 */
	public void checkHappiness() {
		System.out.println("The wife is happy: " + wife.isHappy());
		System.out.println("The husband is happy: " + husband.isHappy());
	}

	/**
	 * method to print members of family
	 */
	public void printFam() {
		husband.printSuper();
		wife.printSuper();
		wife.printKids();
	}
}
