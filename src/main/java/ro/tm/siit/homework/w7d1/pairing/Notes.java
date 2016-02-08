package ro.tm.siit.homework.w7d1.pairing;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Notes {

	private Teacher teachNotes;
	private Course courseNotes;
	private Student studNotes;
	private float[] note = null;
	Random random=new Random();

	public Notes(Teacher teachNotes, Course courseNotes) {
		this.teachNotes = teachNotes;
		this.courseNotes = courseNotes;
		this.studNotes = studNotes;
		this.note = new float[teachNotes.getNoteTeacher().length];
//		note = NoteGen(note);
		note=randomNotes(note);
	}

	public float[] getNote() {
		return this.note;
	}

	public float setMedia() {
		return calculMedia(getNote());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Arrays.toString(getNote());

	}

	//////////////////////////////////////////////////////////////////////////////
	public float[] randomNotes(float[] rnote){
		double temp=0;
		double temp2=0;
		for (int i = 0; i < rnote.length; i++) {
			temp2= (Math.random()*9)+1;
			 temp = Math.round(temp2*100.0)/100.0;
			 DecimalFormat df = new DecimalFormat("###.##");
			 df.format(temp);
			rnote[i]=(float) temp;
		}
		
		return rnote;
		
	}
	/**
	 * used as the formula to calculate media for students
	 * 
	 * @param xmedia
	 * @return the media
	 */
	public float calculMedia(float[] xmedia) {
		float media = 0;
		for (float not : xmedia) {
			media += not;
		}
		return media = media / xmedia.length;
	}

	/**
	 * Used to input notes from console it uses method valid to validate the
	 * input
	 * 
	 * @param xnote
	 * @return notetemp[] containing notes from input
	 */
	public float[] NoteGen(float[] xnote) {
		int notemp = 1;
		Scanner in = new Scanner(System.in);
		// float[] notetemp = new float[xnote.length];
		for (int i = 0; i < xnote.length; i++) {
			System.out.println("Note: " + (notemp));
			String input = in.nextLine();
			if (valid(input)) {
				xnote[i] = Integer.parseInt(input);
				notemp++;
			} else {
				System.err.println("You don't want to do that again....notes between 0 and 10 !!");
				i--; // avoid setting the current note[i] to 0.
			}
		}
		Arrays.sort(xnote);
		return xnote;
	}

	/**
	 * it validates the input to be a float between 0 an 10;
	 *
	 * @param nota
	 * @return true if @param nota is a float between 0 and 10;
	 */
	public boolean valid(String nota) {
		try {
			return (Float.parseFloat(nota) >= 0 && Float.parseFloat(nota) <= 10);
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
