package fysioSysteem.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import fysioSysteem.businessLogic.planning.IRoosterManager;
import fysioSysteem.businessLogic.planning.RoosterManager;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Rooster;

public class pnlFysRooOvz extends JPanel {
	
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
		
		btnFysRooOvzTerug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMain parent = (frmMain)getParentFrame();
				parent.setPanel(new pnlFysOvz());
			}
		});
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
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM");
		
		for(Rooster r : roosters) {
			mdl.addRow(new Object[]{
				dateFormat.format(r.getStart()),
				dateFormat.format(r.getEind())
			});
		}
		
		tableFysRooOvzRooster.setModel(mdl);
	}
	
	private JFrame getParentFrame(){
		return (JFrame)SwingUtilities.getRoot(this);
	}
	
}
