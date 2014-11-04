package fysioSysteem.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fysioSysteem.businessLogic.planning.IAfspraakManager;
import fysioSysteem.dataStorage.AfspraakDAO;
import fysioSysteem.domain.Afspraak;
import fysioSysteem.domain.Fysiotherapeut;


public class pnlAfspOvz extends JPanel {
	
	private JTable tblAfspOvzTable;
	private ArrayList<Afspraak> afspraken;
	
	public pnlAfspOvz(){
		afspraken = AfspraakDAO.getAfspraken();
		
		renderControls();
		setTable();
	}
	
	private void renderControls() {
		setLayout(null);
	
		tblAfspOvzTable = new JTable();
		JScrollPane scrollPane = new JScrollPane(tblAfspOvzTable);
		scrollPane.setBounds(10, 10, 867, 590);
		add(scrollPane);
	}
	
	private void setTable() {
		DefaultTableModel mdl = new DefaultTableModel(
			new Object[]{"Afspraak #", "Patient", "Datum" , "Tijd", "Behandeling"}, 0){
		
			// Tabel Bewerken uit
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		Date today = new Date();
		
		for(Afspraak a : afspraken) {
			if(dateFormat.format(a.getDatumTijd()).equals(dateFormat.format(today)) && today.before(a.getDatumTijd())) {
				mdl.addRow(new Object[]{
					a.getId(), 
					a.getBehandeling().getKlant().getNaam(),
					dateFormat.format(a.getDatumTijd()), 
					timeFormat.format(a.getDatumTijd()),
					a.getBehandeling().getBehandelCode().getBehandelingNaam()
				});
			}
		}
		
		tblAfspOvzTable.setModel(mdl);
	}
	
}
