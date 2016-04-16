/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

import ro.tm.siit.homework.w17d1.trainingcatalog5.catalog.Catalog;
import ro.tm.siit.homework.w17d1.trainingcatalog5.messenger.SimpleMessenger;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.SiteManager;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.Trainer;

/**
 * @author mircea
 *
 */
public class TrainerApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Messenger messenger = SimpleMessenger.getInstance();
		Persistence storage = new Persistence();
		Catalog catalog = storage.loadCatalog();
		if (catalog == null) {
			System.out.println("no catalog available");
			return;
		}
		catalog.setMessenger(messenger);

		TrainerCatalogInterface trainerInterface = catalog;
		Trainer trainer = new Trainer("madalin", "madalin.cosma@gmail.com", trainerInterface, messenger);

		SiteManagerCatalogInterface siteManagerInterface = catalog;
		SiteManager siteManager = new SiteManager("diana", "diana@gmail.com", siteManagerInterface, messenger);

		// create the GUI and handle events in EDT
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				createGUI(catalog, messenger, trainer, siteManager);
			}
		});

	}

	private static void save(Catalog catalog) {
		Persistence storage = new Persistence();
		storage.saveCatalog(catalog);

	}

	/**
	 * constructs the GUI
	 * 
	 * @param messenger
	 * @param catalog
	 * @param siteManager
	 * @param trainer
	 */
	protected static void createGUI(Catalog catalog, Messenger messenger, Trainer trainer, SiteManager siteManager) {
		JFrame window = new JFrame("Trainee");
		window.setSize(600, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.getContentPane().setLayout(new BorderLayout());

		JPanel addGradePanel = createAddGradePanel(trainer);
		window.add(addGradePanel, BorderLayout.NORTH);

		// creates display catalog panel
		JPanel catalogPanel = createCatalogPanel(trainer);
		window.add(catalogPanel, BorderLayout.LINE_START);

		JPanel traineeGrades = createTraineeGradesPanel(trainer);
		window.add(traineeGrades, BorderLayout.LINE_END);
		// listeners that saves catalog on exit
		window.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				save(catalog);
			}

		});

		window.setVisible(true);
	}

	/**
	 * creates Panel to display grades for trainee
	 * 
	 * @param trainer
	 * @return
	 */
	private static JPanel createTraineeGradesPanel(Trainer trainer) {
		JPanel traineeGradesPanel = new JPanel();
		traineeGradesPanel.setLayout(new BorderLayout());

		Dimension dim = traineeGradesPanel.getPreferredSize();
		dim.width = 250;
		traineeGradesPanel.setPreferredSize(dim);

		Border innerBorder = BorderFactory.createTitledBorder("Trainee grades");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		traineeGradesPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new FlowLayout());
		JLabel traineeNameLabel = new JLabel("Name:");
		JTextField traineeNameText = new JTextField(15);
		JButton showGradesBtn = new JButton("Show Grades");

		JTable gradesTable = new JTable();
		JScrollPane scrollGradesList = new JScrollPane(gradesTable);

		upperPanel.add(traineeNameLabel);
		upperPanel.add(traineeNameText);
		upperPanel.add(showGradesBtn);

		Dimension dimu = upperPanel.getPreferredSize();
		dim.width = 250;
		dim.height = 70;
		upperPanel.setPreferredSize(dim);
		traineeGradesPanel.add(upperPanel, BorderLayout.PAGE_START);
		traineeGradesPanel.add(gradesTable, BorderLayout.CENTER);

		showGradesBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					trainer.gradesTableModel(traineeNameText.getText(), gradesTable);
				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(traineeGradesPanel, e1.getMessage());
				}
			}
		});

		return traineeGradesPanel;
	}

	/**
	 * creates Panel display catalog
	 * 
	 * @param trainer
	 * @return
	 */
	private static JPanel createCatalogPanel(Trainer trainer) {
		JPanel catalogPanel = new JPanel();
		catalogPanel.setLayout(new BorderLayout());

		Dimension dim = catalogPanel.getPreferredSize();
		dim.width = 295;
		catalogPanel.setPreferredSize(dim);

		Border innerBorder = BorderFactory.createTitledBorder("Catalog");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		catalogPanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		JButton nameBtn = new JButton("View catalog");
		catalogPanel.add(nameBtn, BorderLayout.PAGE_START);

		JTable catalogTable = new JTable();
		nameBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				trainer.displayCatalog(catalogTable);
			}
		});
		JScrollPane scrollPane = new JScrollPane(catalogTable);
		catalogTable.setFillsViewportHeight(true);
		catalogPanel.add(scrollPane);
		return catalogPanel;
	}

	/**
	 * creates Panel to add grades to trainee
	 * 
	 * @param trainer
	 * @return
	 */
	private static JPanel createAddGradePanel(Trainer trainer) {
		JPanel addGradePanel = new JPanel();
		addGradePanel.setLayout(new FlowLayout());
		Dimension dim = addGradePanel.getPreferredSize();
		dim.height = 80;
		addGradePanel.setPreferredSize(dim);

		Border innerBorder = BorderFactory.createTitledBorder("Add grade");
		Border outerBorder = BorderFactory.createEmptyBorder(10, 4, 8, 0);
		addGradePanel.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		JLabel nameLabel = new JLabel("Name ");
		addGradePanel.add(nameLabel);
		JTextField name = new JTextField(15);
		addGradePanel.add(name);
		JLabel gradeLabel = new JLabel("Grade ");
		addGradePanel.add(gradeLabel);
		JTextField grade = new JTextField(15);
		addGradePanel.add(grade);
		JButton nameBtn = new JButton("Add Grade");
		addGradePanel.add(nameBtn);

		nameBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					trainer.addGrade(name.getText(), Integer.parseInt(grade.getText()));
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(addGradePanel, e1.getMessage());
				} catch (IllegalArgumentException e2) {
					JOptionPane.showMessageDialog(addGradePanel, e2.getMessage());
				} catch (IllegalStateException e3) {
					JOptionPane.showMessageDialog(addGradePanel, e3.getMessage());
				}

			}
		});
		return addGradePanel;
	}

}
