package ro.tm.siit.homework.w17d1.trainingcatalog5.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import ro.tm.siit.homework.w17d1.trainingcatalog5.catalog.Catalog;

public class StartTrainingGui extends JPanel {
	private JButton startTraining;
	private Catalog cat;

	public StartTrainingGui() {
		this.cat = cat;
		startTraining = new JButton("Start Training");
		setLayout(new BorderLayout());
		Border inner = BorderFactory.createTitledBorder("Start Training");
		Border outer = BorderFactory.createBevelBorder(1);
		setBorder(BorderFactory.createCompoundBorder(inner, outer));
		startTraining.setPreferredSize(new Dimension(150, 30));
		add(startTraining, BorderLayout.CENTER);
//		startTraining.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				cat.startTraining(trainer);
//			}
//
//		});
	}

}
