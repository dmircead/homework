package ro.tm.siit.homework.w7d1.pairing;

public class Scool24 {

	public static void main(String[] args) {
		Classroom.initStudents();
		Classroom classrom =new Classroom();
		semester1();
		semester2();
		semester3();
		
	}
	public static void semester1(){
		Classroom c1=new Classroom(1);
		c1.examStudents();
		c1.media();
		c1.catalog();
		c1.printMediaSem();
		c1.rankTeacher();
		c1.pairing();
	}
	public static void semester2(){
		Classroom c2=new Classroom(2);
		c2.examStudents();
		c2.media();
		c2.catalog();
		c2.printMediaSem();
		c2.rankTeacher();
//		c2.pair();
		c2.pairing();
	}
	public static void semester3(){
		Classroom c3=new Classroom(3);
		c3.examStudents();
		c3.media();
		c3.catalog();
		c3.printMediaSem();
		c3.rankTeacher();
//		c2.pair();
		c3.pairing();
	}
}
