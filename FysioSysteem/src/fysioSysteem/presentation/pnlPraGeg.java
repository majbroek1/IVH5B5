package fysioSysteem.presentation;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import fysioSysteem.businessLogic.beheer.*;
import fysioSysteem.domain.Praktijk;

public class pnlPraGeg extends JPanel{
	private JTextField txtPraGegNaam;
	private JTextField txtPraGegAdres;
	private JTextField txtPraGegPlaats;
	private JTextField txtPraGegIBAN;
	private JTextField txtPraGegTelnr;
	private JTextField txtPraGegEmail;
	private JTextField txtPraGegWebsite;
	
	public pnlPraGeg(){
		setLayout(null);		
		
		IPraktijkManager prakManager = new PraktijkManager();
		
		Praktijk p = prakManager.getPraktijk(1);
		
		/* Labels */
		JLabel lblPraGegTitel = new JLabel("Praktijk Gegevens");
		lblPraGegTitel.setBounds(74, 11, 120, 16);
		add(lblPraGegTitel);
		
		JLabel lblPraGegAdres = new JLabel("Praktijk Adres");
		lblPraGegAdres.setBounds(438, 57, 98, 16);
		add(lblPraGegAdres);
		
		JLabel lblPraGegNaam = new JLabel("Praktijk Naam");
		lblPraGegNaam.setBounds(74, 57, 98, 16);
		add(lblPraGegNaam);
		
		JLabel lblPraktijkPlaats = new JLabel("Praktijk Plaats");
		lblPraktijkPlaats.setBounds(74, 118, 98, 16);
		add(lblPraktijkPlaats);
		
		JLabel lblPraktijkIban = new JLabel("Praktijk IBAN");
		lblPraktijkIban.setBounds(438, 118, 98, 16);
		add(lblPraktijkIban);
		
		JLabel lblPraktijkTellefoonnummer = new JLabel("Praktijk Telefoonnummer");
		lblPraktijkTellefoonnummer.setBounds(74, 177, 172, 16);
		add(lblPraktijkTellefoonnummer);
		
		JLabel lblPraktijkEmail = new JLabel("Praktijk Email");
		lblPraktijkEmail.setBounds(438, 177, 172, 16);
		add(lblPraktijkEmail);
		
		JLabel lblPraktijkWebsite = new JLabel("Praktijk Website");
		lblPraktijkWebsite.setBounds(74, 237, 172, 16);
		add(lblPraktijkWebsite);
		
		/* TextFields */
		txtPraGegNaam = new JTextField();
		txtPraGegNaam.setBounds(259, 51, 134, 28);
		txtPraGegNaam.setColumns(10);
		txtPraGegNaam.setText(p.getNaam());
		add(txtPraGegNaam);
		
		txtPraGegAdres = new JTextField();
		txtPraGegAdres.setColumns(10);
		txtPraGegAdres.setBounds(568, 51, 134, 28);
		txtPraGegAdres.setText(p.getAdres());
		add(txtPraGegAdres);
		
		txtPraGegPlaats = new JTextField();
		txtPraGegPlaats.setColumns(10);
		txtPraGegPlaats.setBounds(259, 112, 134, 28);
		txtPraGegPlaats.setText(p.getPlaats());
		add(txtPraGegPlaats);
		
		txtPraGegIBAN = new JTextField();
		txtPraGegIBAN.setColumns(10);
		txtPraGegIBAN.setBounds(568, 112, 134, 28);
		txtPraGegIBAN.setText(p.getIban());
		add(txtPraGegIBAN);
		
		txtPraGegTelnr = new JTextField();
		txtPraGegTelnr.setColumns(10);
		txtPraGegTelnr.setBounds(259, 171, 134, 28);
		txtPraGegTelnr.setText(p.getTelNr());
		add(txtPraGegTelnr);
		
		txtPraGegEmail = new JTextField();
		txtPraGegEmail.setColumns(10);
		txtPraGegEmail.setBounds(568, 171, 134, 28);
		txtPraGegEmail.setText(p.getEmail());
		add(txtPraGegEmail);
		
		txtPraGegWebsite = new JTextField();
		txtPraGegWebsite.setColumns(10);
		txtPraGegWebsite.setBounds(259, 231, 134, 28);
		txtPraGegWebsite.setText(p.getWebsite());
		add(txtPraGegWebsite);
		
		/* Buttons */
		JButton btnPraGegOpslaan = new JButton("Opslaan");
		btnPraGegOpslaan.setBounds(74, 286, 117, 29);
		add(btnPraGegOpslaan);
		
		/* Button Handling */
		btnPraGegOpslaan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
