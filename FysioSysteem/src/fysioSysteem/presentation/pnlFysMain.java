package fysioSysteem.presentation;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class pnlFysMain extends JPanel{
	
	final static String FYSIOTHEROPEUTEN_OVERZICHT = "Fysiotheropeuten Overzicht";
	final static String FYSIOTHEROPEUTEN_TOEVOEGEN_WIJZIGEN = "Fysiotheropeuten Toevoegen/ Wijzigen";
	final static String FYSIOTHEROPEUTEN_ROOSTER_OVERZICHT = "Fysiotheropeuten Rooster Overzicht";
	final static String FYSIOTHEROPEUTEN_ROOSTER_TOEVOEGEN_WIJZIGEN = "Fysiotheropeuten Rooster Toevoegen/ Wijzigen";
	
	public pnlFysMain(){
		setLayout(null);
		
		CardLayout cl = new CardLayout();
		
		JPanel pnlFysOvz = new pnlFysOvz();
		pnlFysOvz.setBounds(0, 0, 876, 600);
		
		JPanel pnlFysToeWzg = new pnlFysToeWzg();
		pnlFysToeWzg.setBounds(0, 0, 876, 600);
		
		JPanel pnlFysRooOvz = new pnlFysRooOvz();
		pnlFysRooOvz.setBounds(0, 0, 876, 600);
		
		JPanel pnlFysRooToeWzg = new pnlFysRooToeWzg();
		pnlFysRooToeWzg.setBounds(0, 0, 876, 600);
		
		JPanel pnlContent = new JPanel();
		pnlContent.setLayout(cl);
		pnlContent.setBounds(0, 0, 876, 600);
		pnlContent.add(pnlFysOvz, FYSIOTHEROPEUTEN_OVERZICHT);
		pnlContent.add(pnlFysToeWzg ,FYSIOTHEROPEUTEN_TOEVOEGEN_WIJZIGEN);
		pnlContent.add(pnlFysRooOvz ,FYSIOTHEROPEUTEN_ROOSTER_OVERZICHT);
		pnlContent.add(pnlFysRooToeWzg ,FYSIOTHEROPEUTEN_ROOSTER_TOEVOEGEN_WIJZIGEN);
		add(pnlContent);
		
		//TODO
	}
}
