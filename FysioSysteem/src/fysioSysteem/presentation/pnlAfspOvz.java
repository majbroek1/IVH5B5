package fysioSysteem.presentation;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import fysioSysteem.businessLogic.planning.*;
import fysioSysteem.businessLogic.login.*;
import fysioSysteem.businessLogic.beheer.*;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class pnlAfspOvz extends JPanel{
	public pnlAfspOvz(){
		//IAfspraakManager afsp = new AfspraakManager();
		//ILoginManager lgn = new LoginManager();
		//IMedewerkerManager mdwrk = new MedewerkerManager();
		
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
