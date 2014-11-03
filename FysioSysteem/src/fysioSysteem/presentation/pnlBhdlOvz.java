package fysioSysteem.presentation;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import fysioSysteem.businessLogic.behandeling.BehandelingManager;
import fysioSysteem.businessLogic.behandeling.IBehandelingManager;
import fysioSysteem.domain.Behandeling;
import fysioSysteem.domain.Fysiotherapeut;
import general.AppInjector;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlBhdlOvz extends JPanel{
	private JTable overzichtTabel;
	final static String BEHANDELINGEN_TOEVOEGEN_WIJZIGEN = "Behandelingen Toevoegen/ Wijzigen";
	
	private IBehandelingManager behandelingManager;
	
	public pnlBhdlOvz(){
		Injector injector = Guice.createInjector(new AppInjector());
		this.behandelingManager = injector.getInstance(IBehandelingManager.class);
		
		genereerLayout();
		vulVelden();
	}
	
	private void genereerLayout()
	{
		setLayout(null);
	    		
		overzichtTabel = new JTable();

        JScrollPane scrllPnOverzichtTabel = new JScrollPane(overzichtTabel);
        scrllPnOverzichtTabel.setBounds(10, 10, 867, 590);
		add(scrllPnOverzichtTabel);
		
		JButton btnBehandelingToevoegen = new JButton("Behandeling toevoegen");
		btnBehandelingToevoegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel pnlBhdlToeWzg = new pnlBhdlToeWzg();
				pnlBhdlToeWzg.setBounds(0, 0, 876, 600);
				frmMain parent = (frmMain)getParentFrame();
				parent.setPanel(pnlBhdlToeWzg);
			}
		});
		btnBehandelingToevoegen.setBounds(67, 617, 172, 29);
		add(btnBehandelingToevoegen);
		
		JButton btnBehandelingAanpassen = new JButton("Behandeling aanpassen");
		btnBehandelingAanpassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = (int)overzichtTabel.getValueAt(overzichtTabel.getSelectedRow(), 0);
				JPanel pnlBhdlToeWzg = new pnlBhdlToeWzg(selection);
				pnlBhdlToeWzg.setBounds(0, 0, 876, 600);
				frmMain parent = (frmMain)getParentFrame();
				parent.setPanel(pnlBhdlToeWzg);
			}
		});
		btnBehandelingAanpassen.setBounds(318, 617, 172, 29);
		add(btnBehandelingAanpassen);
		
		JButton btnBehandelingVerwijdering = new JButton("Behandeling verwijderen");
		btnBehandelingVerwijdering.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = (int)overzichtTabel.getValueAt(overzichtTabel.getSelectedRow(), 0);
				
			}
		});
		btnBehandelingVerwijdering.setBounds(574, 617, 172, 29);
		add(btnBehandelingVerwijdering);
	}
	
	private void vulVelden()
	{
		ArrayList<Behandeling> behandelingen = this.behandelingManager.getBehandelingen();
		
		DefaultTableModel mdl = new DefaultTableModel(
				new Object[]{"ID", "Klant BSN", "BehandelCode", "Status"}, 0){
			
			// Tabel Bewerken uit
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
			
			for(Behandeling b : behandelingen) {
				mdl.addRow(new Object[]{
					b.getId(), 
					b.getKlant().getBsn(),
					b.getBehandelCode().getCode(), 
					b.getStatus()
				});
			}
			
			overzichtTabel.setModel(mdl);
	}
	
	private JFrame getParentFrame(){
		return (JFrame)SwingUtilities.getRoot(this);
	}
}
