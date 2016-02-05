package ro.tm.siit.homework.w7d1.pairing;

import java.util.ArrayList;

public class Teacher {
	private String nameTeacher;
	private float[] noteTeacher;

	public Teacher(String nameTeacher) {
		this.nameTeacher = nameTeacher;
		this.noteTeacher = new float[2];
		System.out.println("Teacher "+nameTeacher+" has entered the class...");
	}

	public String getNameTeacher() {
		return nameTeacher;
	}

	public float[] getNoteTeacher() {
		return noteTeacher;
	}

}
