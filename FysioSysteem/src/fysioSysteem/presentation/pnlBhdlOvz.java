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
import general.AppInjector;

import javax.swing.JButton;

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
		
		renderControls();
	}
	
	private void renderControls()
	{
		setLayout(null);
	    		
		Object rijData[][] = getData();
	   
        Object kolomNamen[] = { "Klant BSN", "Behandelcode", "Status" };
        overzichtTabel = new JTable(rijData, kolomNamen);

        JScrollPane scrllPnOverzichtTabel = new JScrollPane(overzichtTabel);
        scrllPnOverzichtTabel.setBounds(10, 10, 867, 590);
		add(scrllPnOverzichtTabel);
		
		JButton btnBehandelingToevoegen = new JButton("Behandeling toevoegen");
		btnBehandelingToevoegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel pnlBhdlToeWzg = new pnlBhdlToeWzg(0);
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
	
	private Object[][] getData()
	{
		ArrayList<Behandeling> behandelingen = this.behandelingManager.getBehandelingen();
		
		Object rijData[][] = new Object [behandelingen.size()][3];
		for (int i = 0; i < behandelingen.size(); i++) {
			Behandeling behandeling = behandelingen.get(i);
			rijData[i][0] = behandeling.getKlant().getBsn();
			rijData[i][1] = behandeling.getBehandelCode().getCode();
			rijData[i][2] = behandeling.getStatus();
		}
		return rijData;
	}
	
	private JFrame getParentFrame(){
		return (JFrame)SwingUtilities.getRoot(this);
	}
}
