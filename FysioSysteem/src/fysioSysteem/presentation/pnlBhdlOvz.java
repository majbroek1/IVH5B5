package fysioSysteem.presentation;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class pnlBhdlOvz extends JPanel{
	public pnlBhdlOvz(){
		setLayout(null);
		
		JLabel lblBhdlOvzTitel = new JLabel("Behandeling Overzicht");
		lblBhdlOvzTitel.setBounds(74, 11, 120, 16);
		add(lblBhdlOvzTitel);
	}
}
