package ro.tm.siit.homework.w17d1.trainingcatalog5.gui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;

import ro.tm.siit.homework.w17d1.trainingcatalog5.catalog.Catalog;

public class CatalogGui extends JPanel {
	private JTable table;
	private Catalog cat;
	public CatalogGui(Catalog cat) {
		this.cat = cat;
		
		table = new JTable(new CatalogModel());
		setLayout(new BorderLayout());
		Border inner = BorderFactory.createTitledBorder("Catalog");
		Border outer = BorderFactory.createEtchedBorder(1);
		setBorder(BorderFactory.createCompoundBorder(inner, outer));
		add(table, BorderLayout.CENTER);
	}

	class CatalogModel extends AbstractTableModel{

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 3;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return cat.traineesForGui().size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch(columnIndex){
			case 0:
				return cat.traineesForGui().get(rowIndex);
				
			case 1:
				return cat.getAvgGrade(cat.traineesForGui().get(rowIndex));
			case 2:
				return cat.getTrainer();
			}
			return null;
		}
		
	}
		
	
}
