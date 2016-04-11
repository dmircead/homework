package ro.tm.siit.homework.w17d1.trainingcatalog5.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ro.tm.siit.homework.w17d1.trainingcatalog5.catalog.Catalog;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.Trainee;

public class MainFrame extends JFrame {

	private AddTraineeGui addTraineeGui;
	private StartTrainingGui startTrainingGui;
	private ViewGradesGui viewGradesGui;
	private CatalogGui catalogGui;
	private Catalog catalog;
	private JFileChooser fileChooser;
	private HashMap<Trainee, List<Integer>> fileObj;
	public MainFrame(Catalog catalog) {
		super("Training Catalog");

		setSize(700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container cp = this.getContentPane();
		this.catalog = catalog;
		cp.setLayout(new GridBagLayout());

		addTraineeGui = new AddTraineeGui();
		startTrainingGui = new StartTrainingGui();
		viewGradesGui = new ViewGradesGui();
		catalogGui = new CatalogGui(catalog);
		fileChooser = new JFileChooser();
		fileObj = (HashMap<Trainee, List<Integer>>) catalog.getTrainees();
		setJMenuBar(createMenuBar());

		GridBagConstraints gc = new GridBagConstraints();

		/////////////// FIRST ROW///////////////////////////
		gc.weightx = 0.1;
		gc.weighty = 0.4;

		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(16, 8, 0, 8);
		cp.add(addTraineeGui, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(startTrainingGui, gc);

		/////////////// SECOND ROW///////////////////////////

		gc.weightx = 0.1;
		gc.weighty = 4;

		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(catalogGui, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(viewGradesGui, gc);
		//////////////////// end /////////////////////////////

		setVisible(true);

	}

	private JMenuBar createMenuBar() {
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
				if(fileChooser.showOpenDialog(MainFrame.this)== JFileChooser.APPROVE_OPTION)
					try {
						catalog.loadFile(fileChooser.getSelectedFile());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, "Could not load file", "Error", JOptionPane.ERROR_MESSAGE);
					}

			}
		});
		
		
		saveData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showSaveDialog(MainFrame.this)== JFileChooser.APPROVE_OPTION)
					try {
						catalog.saveToFile(fileChooser.getSelectedFile());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, "Could not save file", "Error", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		return menuBar;
	}
	public void saveToFile(File file) throws IOException{
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(fileObj);
		oos.close();
	}
}
