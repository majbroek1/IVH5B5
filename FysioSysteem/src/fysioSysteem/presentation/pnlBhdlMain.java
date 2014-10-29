package fysioSysteem.presentation;

import general.AppInjector;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pnlBhdlMain extends JPanel{
	
	final static String BEHANDELINGEN_OVERZICHT = "Behandelingen Overzicht";
	final static String BEHANDELINGEN_TOEVOEGEN_WIJZIGEN = "Behandelingen Toevoegen/ Wijzigen";
	
	public pnlBhdlMain()
	{
		setLayout(null);
		
		CardLayout cl = new CardLayout();
		
		Injector injector = Guice.createInjector(new AppInjector());
		
		JPanel pnlBhdlOvz = injector.getInstance(pnlBhdlOvz.class);
		pnlBhdlOvz.setBounds(0, 0, 876, 600);
		
		JPanel pnlBhdlToeWzg = injector.getInstance(pnlBhdlToeWzg.class);
		pnlBhdlToeWzg.setBounds(0, 0, 876, 600);
		
		JPanel pnlContent = new JPanel();
		
		pnlContent.setLayout(cl);
		pnlContent.setBounds(0, 0, 876, 600);
		pnlContent.add(pnlBhdlOvz, BEHANDELINGEN_OVERZICHT);
		pnlContent.add(pnlBhdlToeWzg, BEHANDELINGEN_TOEVOEGEN_WIJZIGEN);
		
		add(pnlContent);
		
		JButton btnBehandelingToevoegen = new JButton("Behandeling toevoegen");
		btnBehandelingToevoegen.setBounds(107, 620, 172, 29);
		add(btnBehandelingToevoegen);
		
		JButton btnBehandelingAanpassen = new JButton("Behandeling aanpassen");
		btnBehandelingAanpassen.setBounds(358, 620, 172, 29);
		add(btnBehandelingAanpassen);
		
		JButton btnBehandelingVerwijderen = new JButton("Behandeling verwijderen");
		btnBehandelingVerwijderen.setBounds(614, 620, 172, 29);
		add(btnBehandelingVerwijderen);
		
		btnBehandelingToevoegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnBehandelingToevoegen.getText() == "Behandeling toevoegen")
				{	
					cl.show(pnlContent, BEHANDELINGEN_TOEVOEGEN_WIJZIGEN);
					btnBehandelingToevoegen.setText("Terug naar het overzicht");
				}
				else
				{
					cl.show(pnlContent, BEHANDELINGEN_OVERZICHT);
					btnBehandelingToevoegen.setText("Behandeling toevoegen");
				}
			}
		});
		//TODO
	}
}
