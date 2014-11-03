package fysioSysteem.presentation;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class pnlFysOvz extends JPanel {
	
	public pnlFysOvz() {
		setLayout(null);
		
	    // Create a table with 10 rows and 5 columns
	    Object rowData[][] = {
    		{ "Row1-Column1", "Row1-Column2", "Row1-Column3" },
            { "Row2-Column1", "Row2-Column2", "Row2-Column3" }
		};
	    
        Object columnNames[] = { "Column One", "Column Two", "Column Three" };
        JTable table = new JTable(rowData, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 867, 590);
		add(scrollPane);
	}
	
}
