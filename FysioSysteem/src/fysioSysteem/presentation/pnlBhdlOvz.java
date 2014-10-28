package fysioSysteem.presentation;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;

import fysioSysteem.businessLogic.behanding.BehandelingManager;
import fysioSysteem.businessLogic.behanding.IBehandelingManager;
import fysioSysteem.domain.Behandeling;

public class pnlBhdlOvz extends JPanel{
	private JTable table;
	public pnlBhdlOvz(){
		setLayout(null);
		
	    IBehandelingManager behandelingManager = new BehandelingManager();
	    
		ArrayList<Behandeling> behandelingen = behandelingManager.getBehandelingen();
		
		Object rijData[][] = new Object [behandelingen.size()][3];
		for (int i = 0; i < behandelingen.size(); i++) {
			Behandeling behandeling = behandelingen.get(i);
			rijData[i][0] = behandeling.getKlant().getBsn();
			rijData[i][1] = behandeling.getBehandelCode().getCode();
			rijData[i][2] = behandeling.getStatus();
		}
	    
	   /* Object rijData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
	    		{ "Row2-Column1", "Row1-Column2", "Row1-Column3" },
	            { "Row3-Column1", "Row2-Column2", "Row2-Column3" } };*/
	        Object kolomNamen[] = { "Klant BSN", "Behandelcode", "Status" };
        JTable overzichtTabel = new JTable(rijData, kolomNamen);

        JScrollPane scrllPnOverzichtTabel = new JScrollPane(overzichtTabel);
        scrllPnOverzichtTabel.setBounds(10, 10, 867, 590);
		add(scrllPnOverzichtTabel);
	}
}
