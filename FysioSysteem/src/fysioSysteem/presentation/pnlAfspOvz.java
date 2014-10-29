package fysioSysteem.presentation;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class pnlAfspOvz extends JPanel{
	public pnlAfspOvz(){
		//IAfspraakManager afsp = AppInjector IAfspraakManager();
		//ILoginManager lgn = new ILoginManager();
		//IMedewerkerManager mdwrk = new IMedewerkerManager();
		
		setLayout(null);
		
		
		
		JLabel lblAfspOvzTitel = new JLabel("Afspraak Overzicht");
		lblAfspOvzTitel.setBounds(74, 11, 120, 16);
		add(lblAfspOvzTitel);
		
		/*
		String[] tabelKolomNamen = {"Afspraak #", "Patient", "Datum" , "Tijd", "Behandeling"};
		Object[][] data = { {new Integer(1), "Smith","23-10-2014", "14:12", "Knieblessure"}};*/
		
		/*
		JTable tblAfspOvzTable = new JTable();
		tblAfspOvzTable.setBounds(199, 19, 0, 0);
		add(tblAfspOvzTable);
		*/
		
		
		
		
	}
}
