package fysioSysteem.presentation;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class pnlAfspToeWzg extends JPanel{
	public pnlAfspToeWzg(){
		setLayout(null);
		
		int afspraak = 1;
		
		if (afspraak == 1){
			JLabel lblAfspToeWzgTitel = new JLabel("Afspraak Toevoegen");
			lblAfspToeWzgTitel.setBounds(74, 11, 120, 16);
			add(lblAfspToeWzgTitel);
		}
		else {
			JLabel lblAfspToeWzgTitel = new JLabel("Afspraak Wijzigen");
			lblAfspToeWzgTitel.setBounds(74, 11, 120, 16);
			add(lblAfspToeWzgTitel);
		}
		
		
	}
}