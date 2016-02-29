package ro.tm.siit.homework.w11d20.quiz;

import java.util.Arrays;

public class ContentApp {

	public static void main(String[] args) {
		Company[] companies = new Company[4];
		initComp(companies);
		printCompanies(companies);
	}

	public static void initComp(Company[] c) {
		for (int i = 0; i < c.length; i++) {
			c[i] = new Company("Company "+String.valueOf(i + 1));
			c[i].initEmployies();
		}
	}
	public static void printCompanies(Company[] c){
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i].getNameCompany());
			System.out.println(c[i].getNrEmp());
			c[i].printEmployess();
		}
	}
}
