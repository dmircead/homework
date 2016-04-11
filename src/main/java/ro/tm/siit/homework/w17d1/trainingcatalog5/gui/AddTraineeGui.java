package ro.tm.siit.homework.w17d1.trainingcatalog5.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AddTraineeGui extends JPanel {
	private JLabel addTraineeLabel;
	private JTextField addTraineeField;
	private JButton addTraineeBtn;
	
	public AddTraineeGui(){
		addTraineeLabel = new JLabel("Trainee Name");
		addTraineeField = new JTextField();
		addTraineeBtn = new JButton("Add");
		setLayout(new BorderLayout(8,8));
//		Dimension dimension = getPreferredSize();
//		dimension.width=250;
		Border inner = BorderFactory.createTitledBorder("Add Trainee");
		Border outer = BorderFactory.createBevelBorder(1);
		setBorder(BorderFactory.createCompoundBorder(inner, outer));
		addTraineeField.setPreferredSize(new Dimension(200 , 10));
		addTraineeBtn.setPreferredSize(new Dimension(60,30));
		add(addTraineeLabel, BorderLayout.PAGE_START);
		add(addTraineeField, BorderLayout.LINE_START);
		add(addTraineeBtn, BorderLayout.LINE_END);
	
	}
}
