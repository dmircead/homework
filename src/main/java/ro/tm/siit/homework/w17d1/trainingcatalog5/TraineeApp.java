/**
 * 
 */
package ro.tm.siit.homework.w17d1.trainingcatalog5;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ro.tm.siit.homework.w17d1.trainingcatalog5.catalog.Catalog;
import ro.tm.siit.homework.w17d1.trainingcatalog5.messenger.SimpleMessenger;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.SiteManager;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.Trainee;
import ro.tm.siit.homework.w17d1.trainingcatalog5.person.Trainer;

/**
 * @author mco
 *
 */
public class TraineeApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Messenger messenger = SimpleMessenger.getInstance();
		Persistence storage = new Persistence();
		Catalog catalog = storage.loadCatalog();
		if (catalog  == null) {
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

	/**
	 * constructs the GUI
	 * 
	 * @param messenger
	 * @param catalog
	 * @param siteManager
	 * @param trainer
	 */
	private static void createGUI(Catalog catalog, Messenger messenger, Trainer trainer, SiteManager siteManager) {
		JFrame window = new JFrame("Trainee");
		window.setSize(600, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.getContentPane().setLayout(new GridLayout(2, 3));

		JLabel nameLabel = new JLabel("Name ");
		window.add(nameLabel);
		JTextField name = new JTextField("");
		window.add(name);
		JButton nameBtn = new JButton("Validate");
		window.add(nameBtn);
		JLabel gradeLabel = new JLabel("Your last grade is ");
		window.add(gradeLabel);
		JLabel gradeLabel1 = new JLabel();
		window.add(gradeLabel1);
		JButton feedbackBtn = new JButton("Send Feedback");
		feedbackBtn.setEnabled(false);
		window.add(feedbackBtn);

		nameBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Trainee trainee = catalog.find(name.getText());
					gradeLabel1.setText(trainee.getLastGrade() + "");
					nameBtn.setEnabled(false);
					name.setEnabled(false);
					feedbackBtn.setEnabled(true);
				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(window, "The trainee does not exist.");
				}

			}
		});

		feedbackBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Trainee trainee = catalog.find(name.getText());
					trainee.sendFeedback(trainer);
					feedbackBtn.setEnabled(false);
					JOptionPane.showMessageDialog(window, "The feedback has been sent to " + trainer.getName());
				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(window, ex.getMessage());
				}

			}
		});

		window.setVisible(true);
	}

}
