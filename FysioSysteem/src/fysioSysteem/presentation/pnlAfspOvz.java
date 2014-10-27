package fysioSysteem.presentation;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class pnlAfspOvz extends JPanel{
	public pnlAfspOvz(){
		JLabel lblAfspOvzTitel = new JLabel("Afspraak Overzicht");
		lblAfspOvzTitel.setBounds(6, 6, 138, 33);
		add(lblAfspOvzTitel);
		
		JTable tblAfspOvzTable = new JTable();
		tblAfspOvzTable.setBounds(6, 582, 864, -543);
		add(tblAfspOvzTable);
		
		JButton btnAfspOvzToevoegen = new JButton("Afspraak Toevoegen");
		btnAfspOvzToevoegen.setBounds(0, 0, 117, 29);
		add(btnAfspOvzToevoegen);
	}
}
