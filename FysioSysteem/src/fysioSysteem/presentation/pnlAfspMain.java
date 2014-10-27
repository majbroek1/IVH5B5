package fysioSysteem.presentation;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlAfspMain extends JPanel{
	final static String AFSPRAKEN_OVERZICHT = "Afspraken Overzicht";
	final static String AFSPRAKEN_TOEVOEGEN_WIJZIGEN = "Afspraken Toevoegen/ Wijzigen";
	
	public pnlAfspMain()
	{
		setLayout(null);
		
		CardLayout cl = new CardLayout();
		
		JPanel pnlAfspOvz = new pnlAfspOvz();
		pnlAfspOvz.setBounds(0, 0, 876, 600);
		pnlAfspOvz.setBackground(Color.BLUE);
		
		JPanel pnlAfspToeWzg = new pnlAfspToeWzg();
		pnlAfspToeWzg.setBounds(0, 0, 876, 600);
		pnlAfspToeWzg.setBackground(Color.RED);
		
		JPanel pnlContent = new JPanel();
		pnlContent.setLayout(cl);
		pnlContent.setBounds(0, 0, 876, 600);
		pnlContent.add(pnlAfspOvz, AFSPRAKEN_OVERZICHT);
		pnlContent.add(pnlAfspToeWzg, AFSPRAKEN_TOEVOEGEN_WIJZIGEN);
		
		add(pnlContent);
		
		JButton btnAfspOvzToevoegen = new JButton("Afspraak Toevoegen");
		btnAfspOvzToevoegen.setBounds(107, 620, 172, 29);
		add(btnAfspOvzToevoegen);
		
		JButton btnAfspraakAanpassen = new JButton("Afspraak Aanpassen");
		btnAfspraakAanpassen.setBounds(358, 620, 172, 29);
		add(btnAfspraakAanpassen);
		
		JButton btnAfspraakVerwijderen = new JButton("Afspraak Verwijderen");
		btnAfspraakVerwijderen.setBounds(614, 620, 172, 29);
		add(btnAfspraakVerwijderen);
		
		btnAfspOvzToevoegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnAfspOvzToevoegen.getText() == "Afspraak Toevoegen")
				{	
					cl.show(pnlContent, AFSPRAKEN_TOEVOEGEN_WIJZIGEN);
					btnAfspOvzToevoegen.setText("Afspraak Annuleren");
				}
				else
				{
					cl.show(pnlContent, AFSPRAKEN_OVERZICHT);
					btnAfspOvzToevoegen.setText("Afspraak Toevoegen");
				}
			}
		});
		
		btnAfspraakAanpassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		
		btnAfspraakVerwijderen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
	}
}
