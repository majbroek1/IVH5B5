package fysioSysteem.presentation;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fysioSysteem.businessLogic.beheer.*;
import fysioSysteem.domain.*;

import javax.swing.JComboBox;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class pnlFysToeWzg extends JPanel{
	private JTextField txtFysToeWzgNaam;
	private JTextField txtFysToeWzgWachtwoord;
	private JTextField txtFysToeWzgWachtwoordHerhalen;
	private JTextField txtFysToeWzgCombobox;
	private JTextField textFieldNaam;
	private JTextField textFieldWacthwoord;
	private JTextField textFieldwachtwoordherhalen;
	
	public pnlFysToeWzg(int fysiotherapeutID){
		setLayout(null);
		
		IMedewerkerManager medeManager = new MedewerkerManager();
		
		//Medewerker medewerker = medeManager.getMedewerker(fysiotherapeutID);

		/* Label */
		JLabel lblFysToeWzgTitel = new JLabel("Fysiotherapeut Gegevens");
		lblFysToeWzgTitel.setBounds(74, 11, 163, 16);
		add(lblFysToeWzgTitel);
		
		JLabel lblFysToeWzgNaam = new JLabel("Fysiotherapeut Naam");
		lblFysToeWzgNaam.setBounds(74, 57, 138, 16);
		add(lblFysToeWzgNaam);
		
		JLabel lblFysToeWzgStatus = new JLabel("Status");
		lblFysToeWzgStatus.setBounds(435, 57, 145, 16);
		add(lblFysToeWzgStatus);
		
		JLabel lblFysToeWzgWachtwoord = new JLabel("Wachtwoord");
		lblFysToeWzgWachtwoord.setBounds(74, 118, 174, 16);
		add(lblFysToeWzgWachtwoord);
		
		JLabel lblFysToeWzgWachtwoordHer = new JLabel("Wachtwoord Herhalen");
		lblFysToeWzgWachtwoordHer.setBounds(438, 118, 145, 16);
		add(lblFysToeWzgWachtwoordHer);
		
		/* TextField */
		txtFysToeWzgNaam = new JTextField();
		txtFysToeWzgNaam.setBounds(250, 51, 134, 28);
		txtFysToeWzgNaam.setColumns(10);
		//txtFysToeWzgNaam.setText();
		add(txtFysToeWzgNaam);
		
		
		txtFysToeWzgWachtwoord = new JTextField();
		txtFysToeWzgWachtwoord.setBounds(250, 112, 134, 28);
		txtFysToeWzgWachtwoord.setColumns(10);
		add(txtFysToeWzgWachtwoord);
		
		
		txtFysToeWzgWachtwoordHerhalen = new JTextField();
		txtFysToeWzgWachtwoordHerhalen.setBounds(614, 112, 134, 28);
		txtFysToeWzgWachtwoordHerhalen.setColumns(10);
		add(txtFysToeWzgWachtwoordHerhalen);
		
		/* ComboBox */
		JComboBox cmbBoxstatus = new JComboBox(Status.values());
		cmbBoxstatus.setBounds(614, 53, 134, 27);
		add(cmbBoxstatus);
		
		/* Button */
		JButton btnFysToeWzgOpslaan = new JButton("Opslaan");
		btnFysToeWzgOpslaan.setBounds(69, 174, 117, 29);
		add(btnFysToeWzgOpslaan);
		
		/* Button handling */
		btnFysToeWzgOpslaan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				ArrayList<String> errorMessages = new ArrayList<String>();
				Border redBorder = BorderFactory.createLineBorder(Color.red);
				
				
				
				if (txtFysToeWzgNaam.getText().equals("")|| txtFysToeWzgNaam.getText().length() >= 50)
				{
					txtFysToeWzgNaam.setBorder(redBorder);
					errorMessages.add("- Fysiotherapeut Naam");
				}
				if (txtFysToeWzgWachtwoord.getText().equals("")|| txtFysToeWzgWachtwoord.getText().length() >= 50)
				{
					txtFysToeWzgWachtwoord.setBorder(redBorder);
					errorMessages.add("- Wachtwoord");
				}
				if (txtFysToeWzgWachtwoordHerhalen.getText().equals("") || txtFysToeWzgWachtwoord.getText() == txtFysToeWzgWachtwoordHerhalen.getText())
				{
					txtFysToeWzgWachtwoordHerhalen.setBorder(redBorder);
					errorMessages.add("- Wachtwoord Herhalen");
				}
				if (errorMessages.size() == 0)
				{
					Fysiotherapeut fysiotherapeut = new Fysiotherapeut(txtFysToeWzgNaam.getText(), txtFysToeWzgWachtwoord.getText(), Status.valueOf(cmbBoxstatus.getSelectedItem().toString()));
					
					medeManager.setMedewerker(fysiotherapeut);
					
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
}
