package fysioSysteem.presentation;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fysioSysteem.businessLogic.planning.IRoosterManager;
import fysioSysteem.businessLogic.planning.RoosterManager;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Rooster;

public class pnlFysRooOvz extends JPanel{
	
	private JTable tableFysRooOvzRooster;
	
	private ArrayList<Rooster> roosters;
	
	public pnlFysRooOvz(Fysiotherapeut f) {		
		IRoosterManager rm = new RoosterManager();
		roosters = rm.getWeekRooster(f);
		
		genereerLayout();
		vulVelden();
	}
	
	private void genereerLayout() {
		setLayout(null);
		
		tableFysRooOvzRooster = new JTable();
		
		JLabel lblFysRooOvzRooster = new JLabel("Rooster");
		lblFysRooOvzRooster.setBounds(10, 11, 46, 14);
		add(lblFysRooOvzRooster);
		
		JScrollPane spFysRooOvzTableRooster = new JScrollPane();
		spFysRooOvzTableRooster.setBounds(20, 36, 545, 317);
		add(spFysRooOvzTableRooster);
		
		JButton btnFysRooOvzTerug = new JButton("Terug");
		btnFysRooOvzTerug.setBounds(30, 364, 89, 23);
		add(btnFysRooOvzTerug);
	}
	
	private void vulVelden() {
		DefaultTableModel mdl = new DefaultTableModel(
			new Object[]{"Start", "Eind"}, 0) {
			
			// Tabel Bewerken uit
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
		for(Rooster r : roosters) {
			mdl.addRow(new Object[]{
				r.getStart().toString(),
				r.getEind().toString()
			});
		}
		
		tableFysRooOvzRooster.setModel(mdl);
	}
	
}
