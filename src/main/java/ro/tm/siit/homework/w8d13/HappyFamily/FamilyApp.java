package ro.tm.siit.homework.w8d13.HappyFamily;

import java.util.ArrayList;



public class FamilyApp {

	public static void main(String[] args) {
		ManHF mircea = new ManHF("Mircea", "Deznan", 37);
		WomanHF adina=	new WomanHF("Adina", "Deznan", 37);
		PersonHF alessia=	new PersonHF("Alessia", "Deznan", 3);
		
		FamilyHappy family = new FamilyHappy(mircea, adina);
		family.printFam();
		family.addKidsFam(alessia);
		mircea.setHappiness();
		adina.setHappiness();
		family.printFam();
	}

}
