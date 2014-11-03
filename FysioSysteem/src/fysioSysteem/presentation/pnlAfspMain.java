package fysioSysteem.presentation;

import general.AppInjector;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlAfspMain extends JPanel{
	
	final static String AFSPRAKEN_OVERZICHT = "Afspraken Overzicht";
	final static String AFSPRAKEN_TOEVOEGEN_WIJZIGEN = "Afspraken Toevoegen/ Wijzigen";
	
	public pnlAfspMain() {
		setLayout(null);
		
		Injector injector = Guice.createInjector(new AppInjector());
		renderControls(injector);
	}
	
	private void renderControls(Injector inj) {
		CardLayout cl = new CardLayout();
		
		JPanel pnlAfspOvz = inj.getInstance(pnlAfspOvz.class);
		pnlAfspOvz.setBounds(0, 0, 876, 600);
		pnlAfspOvz.setBackground(Color.BLUE);
		
		JPanel pnlAfspToeWzg = inj.getInstance(pnlAfspToeWzg.class);
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
				if (btnAfspOvzToevoegen.getText() == "Afspraak Toevoegen") {	
					cl.show(pnlContent, AFSPRAKEN_TOEVOEGEN_WIJZIGEN);
					btnAfspOvzToevoegen.setText("Afspraak Annuleren");
				}
				else {
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
				JFrame frame = new JFrame();
				
				Object[] options = {"Annuleren", "Verwijderen"};
				
				int n = JOptionPane.showOptionDialog(frame, "Weet je zeker dat je het wilt verwijderen?", "Verwijder Waarschuwing", 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
				
				if (n == 1) {
					// verwijderen
					JOptionPane.showMessageDialog(frame, "verwijderen");
				}
			}
		});
	}
	
}
