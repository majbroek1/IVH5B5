package fysioSysteem.presentation;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class pnlFysRooOvz extends JPanel{
	private JTable tableFysRooOvzRooster;
	
	public pnlFysRooOvz(){
		setLayout(null);
		
		JLabel lblFysRooOvzRooster = new JLabel("Rooster");
		lblFysRooOvzRooster.setBounds(10, 11, 46, 14);
		add(lblFysRooOvzRooster);
		
		JScrollPane spFysRooOvzTableRooster = new JScrollPane();
		spFysRooOvzTableRooster.setBounds(20, 36, 545, 317);
		add(spFysRooOvzTableRooster);
		
		tableFysRooOvzRooster = new JTable();
		spFysRooOvzTableRooster.setViewportView(tableFysRooOvzRooster);
		tableFysRooOvzRooster.setModel(new DefaultTableModel(
			new Object[][] {
				{"Maandag", null},
				{"Dinsdag", null},
				{"Woensdag", null},
				{"Donderdag", null},
				{"Vrijdag", null},
			},
			new String[] {
				"Dag", "Dagdeel"
			}
		));
		
		JButton btnFysRooOvzTerug = new JButton("Terug");
		btnFysRooOvzTerug.setBounds(30, 364, 89, 23);
		add(btnFysRooOvzTerug);
	}
}
