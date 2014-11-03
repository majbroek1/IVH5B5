package fysioSysteem.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import fysioSysteem.dataStorage.MedewerkerDAO;
import fysioSysteem.domain.Fysiotherapeut;

public class pnlFysOvz extends JPanel {
	
	private JButton btnFysioToevoegen;
	private JTable table;
	
	private ArrayList<Fysiotherapeut> therapeuten;
	
	public pnlFysOvz() {
		setLayout(null);

		therapeuten = MedewerkerDAO.getFysiotherapeuten();
		
		genereerLayout();
		vulVelden();
	}

	public void genereerLayout() {
		btnFysioToevoegen = new JButton("Toevoegen");
		btnFysioToevoegen.setBounds(107, 620, 172, 29);
		
		add(btnFysioToevoegen);

		JButton btnFysioAanpassen = new JButton("Aanpassen");
		btnFysioAanpassen.setBounds(358, 620, 172, 29);
		add(btnFysioAanpassen);
		
		table = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 867, 590);
		add(scrollPane);
		
		btnFysioToevoegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMain parent = (frmMain)getParentFrame();
				parent.setPanel(new pnlFysToeWzg());
			}
		});
		
		btnFysioAanpassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					frmMain parent = (frmMain)getParentFrame();
					Fysiotherapeut t = therapeuten.get(
							table.convertRowIndexToModel(table.getSelectedRow()));
					parent.setPanel(new pnlFysToeWzg(t));
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Selecteer een rij, alstublieft.");
				}
			}
		});
	}
	
	private void vulVelden() {
		DefaultTableModel mdl = new DefaultTableModel(
			new Object[]{"ID", "Naam", "Praktijk", "Status"}, 0){
			
			// Tabel Bewerken uit
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
		for(Fysiotherapeut f : therapeuten) {
			mdl.addRow(new Object[]{
				f.getId(), f.getNaam(),
				f.getPraktijk().getNaam(), f.getStatus()
			});
		}

		table.setModel(mdl);
	}
	
	private JFrame getParentFrame(){
		return (JFrame)SwingUtilities.getRoot(this);
	}
}
