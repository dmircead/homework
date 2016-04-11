package ro.tm.siit.homework.w17d1.trainingcatalog5.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ViewGradesGui extends JPanel{
	private JLabel traineeNameGradeLabel;
	private JTextField traineeNameGrade;
	private JButton viewGrades;
	
	public ViewGradesGui(){
		traineeNameGradeLabel = new JLabel("Trainee Name: ");
		traineeNameGrade = new JTextField();
		viewGrades = new JButton("View Grades");
		Border inner = BorderFactory.createTitledBorder("Trainee Grades");
		Border outer = BorderFactory.createBevelBorder(1);
		setBorder(BorderFactory.createCompoundBorder(inner, outer));
		setLayout(new BorderLayout(8,8));
		traineeNameGrade.setPreferredSize(new Dimension(150,10));
		viewGrades.setPreferredSize(new Dimension(110,25));
		add(traineeNameGradeLabel, BorderLayout.PAGE_START);
		add(traineeNameGrade, BorderLayout.LINE_START);
		add(viewGrades,  BorderLayout.AFTER_LINE_ENDS);
	}
}
