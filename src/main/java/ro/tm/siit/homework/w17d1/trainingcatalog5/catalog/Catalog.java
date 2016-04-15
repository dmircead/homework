/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog5.catalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import ro.tm.siit.homework.w17d1.trainingcatalog5.Messenger;
import ro.tm.siit.homework.w17d1.trainingcatalog5.SiteManagerCatalogInterface;
import ro.tm.siit.homework.w17d1.trainingcatalog5.TraineeCatalogInterface;
import ro.tm.siit.homework.w17d1.trainingcatalog5.TrainerCatalogInterface;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.Trainee;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.Trainer;

/**
 * Catalog class implements TrainerCatalogInterface interface and model a grades
 * catalog for Scoala Informala de IT.
 * 
 * @author mcosma
 *
 */
public final class Catalog
		implements SiteManagerCatalogInterface, TrainerCatalogInterface, TraineeCatalogInterface, Serializable {

	private enum Status {
		CREATED, STARTED, FINISHED
	};

	private Map<Trainee, List<Integer>> trainees = new HashMap<Trainee, List<Integer>>();
	private String name;
	private transient Messenger messenger;
	private Trainer trainer;
	private Status status = Status.CREATED;

	/**
	 * @param name
	 *            the name of the training
	 * @param trainees
	 *            the trainees
	 */
	public Catalog(String name, Messenger messenger, Trainee... trainees) {
		super();
		this.name = name;
		for (Trainee t : trainees) {
			this.trainees.put(t, new ArrayList<Integer>());
		}
		this.messenger = messenger;
	}

	public void setMessenger(Messenger messenger) {
		this.messenger = messenger;
		for (Trainee t : trainees.keySet()) {
			t.setMessenger(messenger);
		}
	}

	/**
	 * adds a Trainee to catalog
	 * 
	 * @param t
	 *            the trainee
	 */
	public void addTrainee(Trainee t) {
		if (status != Status.CREATED) {
			throw new IllegalStateException("training already started");
		}
		if (this.trainees.containsKey(t)) {
			throw new IllegalArgumentException("trainee already exist...");
		}
		this.trainees.put(t, new ArrayList<Integer>());
	}

	public void checkDupllicateTrainee(String name) {
		for (Trainee t : trainees.keySet()) {
			if (t.getName().equals(name)) {
				throw new IllegalArgumentException("Trainee " + name + " already exist...");
			}

		}
	}

	@Override
	public void startTraining(Trainer trainer) {
		this.status = Status.STARTED;
		this.trainer = trainer;
		System.out.println("Trainig started...");
	}

	@Override
	public void stopTraining() {
		this.status = Status.FINISHED;
		System.out.println("Trainig stopped...");
	}

	@Override
	public void createTraining() {
		this.status = Status.CREATED;
		System.out.println("Trainig created...");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ro.tm.siit.homework.w10d2.trainingcatalog.TrainerCatalogInterface#
	 * addGrade(java.lang.String, int)
	 */
	public void addGrade(String name, int grade) {
		if (status != Status.STARTED) {
			throw new IllegalStateException("training not started");
		}
		if (grade < 0 || grade > 10) {
			throw new IllegalArgumentException("grade is not allowed: " + grade);
		}
		Trainee participant = find(name);
		List<Integer> list = trainees.get(participant);
		list.add(grade);
		messenger.sendMessage(participant.getEmail(), "New grade from " + trainer.getName(),
				"Your new grade is " + grade);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ro.tm.siit.homework.w10d2.trainingcatalog.SiteManagerCatalogInterface#
	 * printGrades(java.lang.String)
	 */
	public void printGrades(String name) {
		Trainee participant = find(name);
		System.out.println(getTraineeGrades(participant));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ro.tm.siit.homework.w10d2.trainingcatalog.SiteManagerCatalogInterface#
	 * printCatalog()
	 */
	public void printCatalog() {
		System.out.println("Catalog " + name + " has " + trainees.size() + " trainees");
		for (Trainee trainee : trainees.keySet()) {
			System.out.println(trainee.getName() + " " + getAvgGrade(trainee));
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ro.tm.siit.homework.w10d2.trainingcatalog.SiteManagerCatalogInterface#
	 * displayCatalog(JTable)
	 */
	public void displayCatalog(JTable catalog) {
		DefaultTableModel model = (DefaultTableModel) catalog.getModel();
		model.setColumnCount(0);
		model.setRowCount(0);
		model.addColumn("Name");
		model.addColumn("Avg Grade");
		// model.addColumn("Last Grade");
		// model.addColumn("Grades");
		int row = 0;
		for (Trainee trainee : trainees.keySet()) {
			Object[] rowData = new Object[] { trainee.getName(), getAvgGrade(trainee) };
			model.addRow(rowData);
			row++;
		}
		

	}

	public AbstractTableModel createTable() {
		AbstractTableModel tableAbstract = new AbstractTableModel() {
			private String[] colNames = { "Name", "Average" };

			@Override
			public String getColumnName(int column) {
				// TODO Auto-generated method stub
				return colNames[column];
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				List keys = new ArrayList(trainees.keySet());
				Trainee trainee = (Trainee) keys.get(rowIndex);

				switch (columnIndex) {
				case 0:
					return trainee.getName();

				case 1:
					return getAvgGrade(trainee);

				}
				return null;

			}

			@Override
			public int getRowCount() {
				return trainees.size();
			}

			@Override
			public int getColumnCount() {

				return 2;
			}
		};
		tableAbstract.fireTableDataChanged();
		return tableAbstract;
	}

	public void refresTable() {
		createTable().fireTableDataChanged();
		createTable().fireTableStructureChanged();
	}

	@Override
	public int getLastGrade(String name) {
		Trainee participant = find(name);
		List<Integer> list = trainees.get(participant);
		if (list.isEmpty()) {
			// throw new IllegalStateException("trainee has no grade: " + name);
			return 0;
		}
		return list.get(list.size() - 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Catalog " + name + " has " + trainees.size() + " trainees" + " and a hashcode of: " + hashCode()
				+ " and status: " + this.status;
	}

	/**
	 * searches for a Trainee with specified name
	 * 
	 * @param name
	 *            the name fo the trainee
	 * @return a Trainee object or null if not found
	 */
	public Trainee find(String name) {
		for (Trainee t : trainees.keySet()) {
			if (t.getName().equals(name)) {
				return t;
			}
		}
		throw new IllegalArgumentException("no Trainee found with name " + name);
	}

	/**
	 * @param trainee
	 *            the trainee for which to calculate avg grade
	 * @return a float as average of the grades
	 */
	public float getAvgGrade(Trainee trainee) {
		int sum = 0;
		List<Integer> list = trainees.get(trainee);
		for (Integer i : list) {
			sum += i;
		}
		return ((float) sum) / list.size();
	}

	/**
	 * returns a string with name and the grades of this trainee
	 * 
	 * @param trainee
	 * @param list
	 * @return
	 */
	public String getTraineeGrades(Trainee trainee) {
		List<Integer> list = trainees.get(trainee);
		String out = trainee.getName() + " : ";
		for (Integer i : list) {
			out += i + " ";
		}
		return out;
	}

	// public Status getStatus() {
	// return status;
	// }

}
