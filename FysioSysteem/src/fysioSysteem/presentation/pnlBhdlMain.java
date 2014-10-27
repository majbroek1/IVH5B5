package fysioSysteem.presentation;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class pnlBhdlMain extends JPanel{
	
	final static String BEHANDELINGEN_OVERZICHT = "Behandelingen Overzicht";
	final static String BEHANDELINGEN_TOEVOEGEN_WIJZIGEN = "Behandelingen Toevoegen/ Wijzigen";
	
	public pnlBhdlMain()
	{
		setLayout(null);
		
		CardLayout cl = new CardLayout();
		
		JPanel pnlBhdlOvz = new pnlBhdlOvz();
		pnlBhdlOvz.setBounds(0, 0, 876, 600);
		
		JPanel pnlBhdlToeWzg = new pnlBhdlToeWzg();
		pnlBhdlToeWzg.setBounds(0, 0, 876, 600);
		
		JPanel pnlContent = new JPanel();
		pnlContent.setLayout(cl);
		pnlContent.setBounds(0, 0, 876, 600);
		pnlContent.add(pnlBhdlOvz, BEHANDELINGEN_OVERZICHT);
		pnlContent.add(pnlBhdlToeWzg, BEHANDELINGEN_TOEVOEGEN_WIJZIGEN);
		
		add(pnlContent);
		
		//TODO
	}
}
