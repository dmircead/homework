package ro.tm.siit.homework.w17d1.trainingcatalog5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ro.tm.siit.homework.w17d1.trainingcatalog5.catalog.Catalog;
import ro.tm.siit.homework.w17d1.trainingcatalog5.messenger.SimpleMessenger;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.SiteManager;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.Trainee;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.Trainer;

/**
 * Constructs a graphic interface to be used by Site Manager
 * 
 * @author mircea
 *
 */
public class SiteManagerApp {

	public static void main(String[] args) {

		Messenger messenger = SimpleMessenger.getInstance();
		Persistence storage = new Persistence();

		Catalog catalog = loadCatalogGui(messenger, storage);

		TrainerCatalogInterface trainerInterface = catalog;
		Trainer trainer = new Trainer("madalin", "madalin.cosma@gmail.com", trainerInterface, messenger);

		SiteManagerCatalogInterface siteManagerInterface = catalog;
		SiteManager siteManager = new SiteManager("diana", "diana@gmail.com", siteManagerInterface, messenger);

		EmployeeCatalogInterface employeeCatalogInterface = catalog;

		// create the GUI and handle events in EDT
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				createGUI(catalog, messenger, trainer, siteManager, storage);
			}
		});

	}

	/**
	 * loads Catalog and creates new one if none
	 * 
	 * @param messenger
	 * @param persistence
	 * @return
	 */
	private static Catalog loadCatalogGui(Messenger messenger, Persistence persistence) {
		Catalog catalog = persistence.loadCatalog();
		if (catalog == null) {
			catalog = new Catalog("Java S2", messenger);
		} else {
			catalog.setMessenger(messenger);
		}
		return catalog;
	}

	private static void save(Catalog catalog) {
		Persistence storage = new Persistence();
		storage.saveCatalog(catalog);

	}

	/**
	 * creates GUI
	 * 
	 * @param catalog
	 * @param messenger
	 * @param trainer
	 * @param siteManager
	 * @param persistence
	 */
	public static void createGUI(Catalog catalog, Messenger messenger, Trainer trainer, SiteManager siteManager,
			Persistence persistence) {

		JFrame window = new JFrame("Trainee");
		window.setSize(600, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.getContentPane().setLayout(new BorderLayout());

		TraineeCatalogInterface traineeInterface = catalog;
		JPanel addTraineePanel = createAddTraineePanel(catalog, siteManager, messenger, traineeInterface);
		JPanel statusPanel = createStatusPanel(catalog, siteManager, trainer);

		JPanel shwoGradesPanel = createShowGradesPanel(catalog, siteManager);
		window.setJMenuBar(createMenuBar(catalog, messenger, persistence));

		window.add(statusPanel, BorderLayout.PAGE_START);
		window.add(shwoGradesPanel, BorderLayout.LINE_START);
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(2, 1));
		rightPanel.add(addTraineePanel);
		window.add(rightPanel, BorderLayout.LINE_END);
		// bottomPanel.setLayout(new GridLayout(2, 2));
		// bottomPanel.setPreferredSize(new Dimension(600, 50));
		window.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				save(catalog);
			}

		});

		window.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				if (catalog == null)
					loadCatalogGui(messenger, persistence);
			}

		});

		window.setVisible(true);

	}

	/**
	 * Creates Panel to display catalog and grades
	 * 
	 * @param catalog
	 * @param siteManager
	 * @return
	 */
	private static JPanel createShowGradesPanel(Catalog catalog, SiteManager siteManager) {

		JPanel traineeGrades = new JPanel();
		JTable tableGrades = new JTable(catalog.createTable());
		JButton viewGradesBtn = new JButton("View Catalog");
		JTextField gradesField = new JTextField();
		gradesField.setEditable(false);
		gradesField.setOpaque(false);
		JLabel nameGrades = new JLabel("Grades");
		nameGrades.setOpaque(true);
		viewGradesBtn.setPreferredSize(new Dimension(60, 20));

		traineeGrades.setLayout(new BorderLayout());
		Dimension dim = traineeGrades.getPreferredSize();
		dim.width = 250;
		dim.height = 100;
		traineeGrades.setPreferredSize(dim);

		traineeGrades.add(viewGradesBtn, BorderLayout.PAGE_START);
		traineeGrades.add(new JScrollPane(tableGrades), BorderLayout.CENTER);

		JPanel gradesBottom = new JPanel();
		gradesBottom.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black),
				gradesBottom.getBorder()));

		gradesBottom.setLayout(new BorderLayout());
		gradesBottom.add(nameGrades, BorderLayout.CENTER);
		gradesBottom.add(gradesField, BorderLayout.PAGE_END);
		gradesBottom.setBackground(Color.orange);

		traineeGrades.add(gradesBottom, BorderLayout.PAGE_END);

		tableGrades.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				Trainee trainee = catalog.find((String) tableGrades.getValueAt(tableGrades.getSelectedRow(), 0));
				gradesField.setText(siteManager.printGrades(trainee.getName()));

			}
		});

		viewGradesBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				catalog.refresTable();
				tableGrades.revalidate();
				tableGrades.repaint();

			}
		});

		return traineeGrades;
	}

	/**
	 * creates Panel to add trainee
	 * 
	 * @param catalog
	 * @param siteManager
	 * @param messenger
	 * @param traineeInterface
	 * @return
	 */
	private static JPanel createAddTraineePanel(Catalog catalog, SiteManager siteManager, Messenger messenger,
			TraineeCatalogInterface traineeInterface) {
		JPanel addTraineePanel = new JPanel();
		addTraineePanel.setLayout(new FlowLayout());
		Dimension dim = addTraineePanel.getPreferredSize();
		dim.height = 20;
		dim.width = 250;
		addTraineePanel.setPreferredSize(dim);

		Border inner = BorderFactory.createTitledBorder("Add Trainee");
		Border outer = BorderFactory.createEmptyBorder();
		addTraineePanel.setBorder(BorderFactory.createCompoundBorder(inner, outer));

		JLabel traineeNameLabel = new JLabel("Trainee Name:");
		JTextField traineeNameField = new JTextField();
		traineeNameField.setPreferredSize(new Dimension(130, 20));
		JButton addTrainee = new JButton("Add");
		addTraineePanel.add(traineeNameLabel, BorderLayout.LINE_START);
		addTraineePanel.add(traineeNameField, BorderLayout.LINE_END);
		addTraineePanel.add(addTrainee, BorderLayout.EAST);
		addTrainee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (traineeNameField.getText().equals(""))
						throw new IllegalArgumentException("Please provide a name !");
					catalog.checkDupllicateTrainee(traineeNameField.getText());
					Trainee trainee = new Trainee(traineeNameField.getText(), " ", messenger, traineeInterface);
					siteManager.addTrainee(trainee);
					traineeNameField.setText("");
				} catch (IllegalStateException e1) {
					JOptionPane.showMessageDialog(addTraineePanel, e1.getMessage());
				} catch (IllegalArgumentException e2) {
					JOptionPane.showMessageDialog(addTraineePanel, e2.getMessage());
				}
			}
		});
		return addTraineePanel;
	}

	/**
	 * creates Panel to change status of training
	 * 
	 * @param catalog
	 * @param siteManager
	 * @param trainer
	 * @return
	 */

	private static JPanel createStatusPanel(Catalog catalog, SiteManager siteManager, Trainer trainer) {
		JPanel statusPanel = new JPanel();
		statusPanel.setLayout(new FlowLayout());
		Dimension dim = statusPanel.getPreferredSize();
		dim.height = 50;
		dim.width = 300;
		statusPanel.setPreferredSize(dim);

		JButton startTrainingBtn = new JButton("Start Training");
		JButton stopTrainingBtn = new JButton("Stop Training");
		JButton createTrainingBtn = new JButton("Create Training");
		statusPanel.add(createTrainingBtn);
		statusPanel.add(startTrainingBtn);
		statusPanel.add(stopTrainingBtn);

		if (catalog.getStatus() != null)
			createTrainingBtn.setEnabled(false);

		createTrainingBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				siteManager.createTraining();
				createTrainingBtn.setEnabled(false);

			}
		});

		startTrainingBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				siteManager.startTraining(trainer);
				createTrainingBtn.setEnabled(false);
			}
		});

		stopTrainingBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				siteManager.stopTraining();
				createTrainingBtn.setEnabled(true);
			}
		});
		return statusPanel;
	}

	/**
	 * creates Menu Bar
	 * 
	 * @param catalog
	 * @param messenger
	 * @param persistence
	 * @return
	 */
	private static JMenuBar createMenuBar(Catalog catalog, Messenger messenger, Persistence persistence) {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		JMenuItem loginMenu = new JMenuItem("Login");
		JMenuItem saveData = new JMenuItem("Save Data...");
		JMenuItem loadData = new JMenuItem("Load Data...");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(loginMenu);

		fileMenu.add(exit);
		editMenu.add(saveData);
		editMenu.add(loadData);

		loadData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadCatalogGui(messenger, persistence);

			}

		});

		saveData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				save(catalog);
			}
		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				save(catalog);
				System.exit(0);

			}
		});

		loginMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TrainerApp trainerApp = new TrainerApp();
				// yet to be implemented....
			}
		});
		return menuBar;
	}

}
