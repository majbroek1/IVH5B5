package fysioSysteem.presentation;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class pnlFysOvz extends JPanel{
	public pnlFysOvz(){
		setLayout(null);
		
		JLabel lblFysOvzTitel = new JLabel("Fysiotherapeuten Overzicht");
		lblFysOvzTitel.setBounds(74, 11, 120, 16);
		add(lblFysOvzTitel);
	}
}
