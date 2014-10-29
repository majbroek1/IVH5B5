package fysioSysteem.presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.google.inject.Inject;

import fysioSysteem.businessLogic.beheer.IPraktijkManager;
import fysioSysteem.businessLogic.beheer.PraktijkManager;
import fysioSysteem.domain.Praktijk;

public class pnlPraGeg extends JPanel{
	private JTextField txtPraGegNaam;
	private JTextField txtPraGegAdres;
	private JTextField txtPraGegPlaats;
	private JTextField txtPraGegIBAN;
	private JTextField txtPraGegTelnr;
	private JTextField txtPraGegEmail;
	private JTextField txtPraGegWebsite;
	private JTextField txtPraGegPostcode;
	private IPraktijkManager prakManager;
	private int praktijkID = 1;
	
	@Inject
	public pnlPraGeg(IPraktijkManager prakManager){
		this.prakManager = prakManager;
		
		setLayout(null);		
		
		Praktijk p = prakManager.getPraktijk(praktijkID);
		
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
		
		JLabel lblPraktijkPostcode = new JLabel("Praktijk Postcode");
		lblPraktijkPostcode.setBounds(74, 118, 120, 16);
		add(lblPraktijkPostcode);
		
		JLabel lblPraktijkPlaats = new JLabel("Praktijk Plaats");
		lblPraktijkPlaats.setBounds(438, 118, 98, 16);
		add(lblPraktijkPlaats);
		
		JLabel lblPraktijkIban = new JLabel("Praktijk IBAN");
		lblPraktijkIban.setBounds(74, 177, 98, 16);
		add(lblPraktijkIban);
		
		JLabel lblPraktijkTellefoonnummer = new JLabel("Praktijk Telefoonnummer");
		lblPraktijkTellefoonnummer.setBounds(438, 177, 172, 16);
		add(lblPraktijkTellefoonnummer);
		
		JLabel lblPraktijkEmail = new JLabel("Praktijk Email");
		lblPraktijkEmail.setBounds(74, 231, 172, 16);
		add(lblPraktijkEmail);
		
		JLabel lblPraktijkWebsite = new JLabel("Praktijk Website");
		lblPraktijkWebsite.setBounds(438, 231, 172, 16);
		add(lblPraktijkWebsite);
		
		/* TextFields */
		txtPraGegNaam = new JTextField();
		txtPraGegNaam.setBounds(259, 51, 134, 28);
		txtPraGegNaam.setColumns(10);
		txtPraGegNaam.setText(p.getNaam());
		add(txtPraGegNaam);
		
		txtPraGegAdres = new JTextField();
		txtPraGegAdres.setColumns(10);
		txtPraGegAdres.setBounds(605, 51, 134, 28);
		txtPraGegAdres.setText(p.getAdres());
		add(txtPraGegAdres);
		
		txtPraGegPostcode = new JTextField();
		txtPraGegPostcode.setText(p.getPostcode());
		txtPraGegPostcode.setColumns(10);
		txtPraGegPostcode.setBounds(259, 112, 134, 28);
		add(txtPraGegPostcode);
		
		txtPraGegPlaats = new JTextField();
		txtPraGegPlaats.setColumns(10);
		txtPraGegPlaats.setBounds(605, 112, 134, 28);
		txtPraGegPlaats.setText(p.getPlaats());
		add(txtPraGegPlaats);
		
		txtPraGegIBAN = new JTextField();
		txtPraGegIBAN.setColumns(10);
		txtPraGegIBAN.setBounds(259, 171, 134, 28);
		txtPraGegIBAN.setText(p.getIban());
		add(txtPraGegIBAN);
		
		txtPraGegTelnr = new JTextField();
		txtPraGegTelnr.setColumns(10);
		txtPraGegTelnr.setBounds(605, 171, 134, 28);
		txtPraGegTelnr.setText(p.getTelNr());
		add(txtPraGegTelnr);
		
		txtPraGegEmail = new JTextField();
		txtPraGegEmail.setColumns(10);
		txtPraGegEmail.setBounds(258, 225, 134, 28);
		txtPraGegEmail.setText(p.getEmail());
		add(txtPraGegEmail);
		
		txtPraGegWebsite = new JTextField();
		txtPraGegWebsite.setColumns(10);
		txtPraGegWebsite.setBounds(605, 225, 134, 28);
		txtPraGegWebsite.setText(p.getWebsite());
		add(txtPraGegWebsite);
		
		/* Buttons */
		JButton btnPraGegOpslaan = new JButton("Opslaan");
		btnPraGegOpslaan.setBounds(74, 286, 117, 29);
		add(btnPraGegOpslaan);
		
		
		/* Button Handling */
		btnPraGegOpslaan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				ArrayList<String> errorMessages = new ArrayList<String>();
				Border redBorder = BorderFactory.createLineBorder(Color.red);
				
				if (txtPraGegNaam.getText().equals("") && txtPraGegNaam.getText().length() >= 30)
				{
					txtPraGegNaam.setBorder(redBorder);
					errorMessages.add("- Naam");
				}
				if (txtPraGegAdres.getText().equals("") && txtPraGegAdres.getText().length() >= 50)
				{
					txtPraGegAdres.setBorder(redBorder);
					errorMessages.add("- Adres");
				}
				if (txtPraGegPostcode.getText().equals("") && !validatePostcode(txtPraGegPostcode.getText()))
				{
					txtPraGegPostcode.setBorder(redBorder);
					errorMessages.add("- Postcode");
				}
				if (txtPraGegPlaats.getText().equals("") && txtPraGegPlaats.getText().length() >= 50)
				{
					txtPraGegPlaats.setBorder(redBorder);
					errorMessages.add("- Plaats");
				}
				if (txtPraGegIBAN.getText().equals("") && txtPraGegIBAN.getText().length() >= 35)
				{
					txtPraGegIBAN.setBorder(redBorder);
					errorMessages.add("- IBAN");
				}
				if (txtPraGegTelnr.getText().equals("") && txtPraGegTelnr.getText().length() >= 30)
				{
					txtPraGegTelnr.setBorder(redBorder);
					errorMessages.add("- Telefoonnummer");
				}
				if (txtPraGegEmail.getText().equals("") && txtPraGegEmail.getText().length() >= 50 || !validateEmail(txtPraGegEmail.getText()))
				{
					txtPraGegEmail.setBorder(redBorder);
					errorMessages.add("- Email");
				}
				if (txtPraGegWebsite.getText().equals("") && txtPraGegWebsite.getText().length() >= 50)
				{
					txtPraGegWebsite.setBorder(redBorder);
					errorMessages.add("- Website");
				}
				if (errorMessages.size() == 0)
				{
					Praktijk praktijk = new Praktijk(praktijkID, txtPraGegNaam.getText(), txtPraGegAdres.getText(), 
							txtPraGegPostcode.getText(), txtPraGegPlaats.getText(), txtPraGegIBAN.getText(), 
							txtPraGegTelnr.getText(), txtPraGegEmail.getText(), txtPraGegWebsite.getText());
				    prakManager.setPraktijk(praktijk);
				    
				    revalidate();
				    repaint();
				    
				    JOptionPane.showMessageDialog(frame, "De praktijk gegevens zijn succesvol opgeslagen.");
				}
				else
				{
					int sizeStringBuilder = errorMessages.size() + 1;
					StringBuilder builder = new StringBuilder(sizeStringBuilder);
					builder.append("Controleer de volgende velden op volledigheid en correctheid:" + "\n");
					for (String s: errorMessages)
				    {
						builder.append(s + "\n");
				    }
					JOptionPane.showMessageDialog(null, builder.toString());
				}
			}
		});
	}
	
	private boolean validatePostcode(String postcode)
	{
		String postcodeRegex = "^[1-9]{1}[0-9]{3} ?[A-Z]{2}$";
		
		boolean check = false;
		
		if(postcode.matches(postcodeRegex))
		{
			check = true;
		}
		
		return check;
	}
	
	private boolean validateEmail(String email)
	{
		String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		boolean check = false;
		
		if(email.matches(emailRegex))
		{
			check = true;
		}
		
		return check;
	}
}
