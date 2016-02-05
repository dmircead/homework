package ro.tm.siit.homework.w7d1.pairing;

public class Course {
String nameCourse;

public Course(String nameCourse) {
	this.nameCourse = nameCourse;
	System.out.println("Course "+nameCourse+" is being taught...");
}

public String getNameCourse() {
	return nameCourse;
}


}
