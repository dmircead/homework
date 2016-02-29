package ro.tm.siit.homework.w11d20.quiz;

import java.util.Random;

public class Company implements Succes {
	private Employee[] employees = new Employee[getNrEmp()];
	private int nrEmp;
	private int slariesPaid;
	private int expertise;
	private int index;
	private String nameCompany;
	private Random randS = new Random();
	private Random randE = new Random();
	private Random randNrEmp = new Random();

	public Company(String nameCompany) {
		this.nrEmp = randNrEmp.nextInt((20 - 1) + 1 + 1);
		this.nameCompany = nameCompany;
	}

	public int getExpertise() {
		return expertise;
	}

	public void setExpertise(int expertise) {
		this.expertise = expertise;
	}

	public int getSlariesPaid() {
		return slariesPaid;
	}

	public void setSlariesPaid(int slariesPaid) {
		this.slariesPaid = slariesPaid;
	}

	public  int getNrEmp() {
		return nrEmp;
	}

	public Employee[] getEmployees() {
		return employees;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void initEmployies() {
		for (int i = 0; i <  getNrEmp(); i++) {
			employees[i] = new Employee("Employee " + String.valueOf(i + 1), randS.nextInt((30000 - 800) + 1 + 800),
					randE.nextInt((100 - 1) + 1 + 1));
		}
	}

	public int sumPayments() {
		int sum = 0;
		for (int i = 0; i < employees.length; i++) {
			sum += employees[i].getSalary();
		}
		return sum;
	}

	public int sumExperience() {
		int sum = 0;
		for (int i = 0; i < employees.length; i++) {
			sum += employees[i].getExperience();
		}
		return sum;
	}

	@Override
	public int index() {
		int sumP = sumPayments();
		int sumEx = sumExperience();
		index = sumP / sumEx;
		if (employees.length > 3)
			index = (int) index * (10 / 100);
		return index;
	}
	
	public void printEmployess(){
		for (int i=0; i<getEmployees().length; i++){
			System.out.println(getEmployees()[i].getName()+" has an index of succes of: ");
			System.out.println(getEmployees()[i].getIndex());
		}
	}
}
