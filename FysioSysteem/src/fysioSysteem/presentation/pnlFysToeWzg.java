package fysioSysteem.presentation;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fysioSysteem.businessLogic.beheer.*;
import fysioSysteem.domain.*;

import javax.swing.JComboBox;
import javax.swing.border.Border;

import com.google.inject.Inject;

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
	private IMedewerkerManager medeManager;
	private IPraktijkManager prakManager;
	
	@Inject
	public pnlFysToeWzg(IMedewerkerManager medeManager, IPraktijkManager prakManager){
		this.medeManager = medeManager;
		this.prakManager = prakManager;
		
		setLayout(null);

		/* update Fysio therapeut */
		
		
		int medewerkerId = 2;

		Fysiotherapeut fysiother = this.medeManager.getFysiotherapeut(medewerkerId);
		
		/* end update Fysio therapeut */
		
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
		lblFysToeWzgWachtwoord.setBounds(74, 178, 179, 16);
		add(lblFysToeWzgWachtwoord);
		
		JLabel lblFysToeWzgWachtwoordHer = new JLabel("Wachtwoord Herhalen");
		lblFysToeWzgWachtwoordHer.setBounds(443, 178, 145, 16);
		add(lblFysToeWzgWachtwoordHer);
		
		JLabel lblFysToeWzgPraktijk = new JLabel("Praktijk");
		lblFysToeWzgPraktijk.setBounds(74, 116, 138, 16);
		add(lblFysToeWzgPraktijk);
		
		/* TextField */
		txtFysToeWzgNaam = new JTextField();
		txtFysToeWzgNaam.setBounds(250, 51, 134, 28);
		txtFysToeWzgNaam.setColumns(10);
		if (medewerkerId != 0) txtFysToeWzgNaam.setText(fysiother.getNaam());
		add(txtFysToeWzgNaam);
		
		txtFysToeWzgWachtwoord = new JPasswordField();
		txtFysToeWzgWachtwoord.setBounds(250, 172, 134, 28);
		txtFysToeWzgWachtwoord.setColumns(10);
		if (medewerkerId != 0) txtFysToeWzgWachtwoord.setText(fysiother.getWachtwoord());
		add(txtFysToeWzgWachtwoord);
		
		txtFysToeWzgWachtwoordHerhalen = new JPasswordField();
		txtFysToeWzgWachtwoordHerhalen.setBounds(619, 172, 134, 28);
		txtFysToeWzgWachtwoordHerhalen.setColumns(10);
		if (medewerkerId != 0) txtFysToeWzgWachtwoordHerhalen.setText(fysiother.getWachtwoord());
		add(txtFysToeWzgWachtwoordHerhalen);
		
		/* ComboBox */
		JComboBox cmbStatus = new JComboBox(Status.values());
		cmbStatus.setBounds(614, 53, 134, 27);
		if (medewerkerId !=0) cmbStatus.setSelectedItem(fysiother.getStatus());
		add(cmbStatus);
		
		JComboBox cmbPraktijk = new JComboBox();
		cmbPraktijk.setBounds(250, 112, 134, 27);
		for (Praktijk praktijk : this.prakManager.getPraktijken()) {
			cmbPraktijk.addItem(praktijk);
		}
		if (medewerkerId !=0)cmbStatus.setSelectedItem(fysiother.getPraktijk().toString()); // TODO!!!!!!!!!!!!!!!!!!!
		add(cmbPraktijk);
		
		/* Button */
		JButton btnFysToeWzgOpslaan = new JButton("Opslaan");
		btnFysToeWzgOpslaan.setBounds(74, 234, 117, 29);
		add(btnFysToeWzgOpslaan);
		
		/* Button handling */
		btnFysToeWzgOpslaan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				ArrayList<String> errorMessages = new ArrayList<String>();
				Border redBorder = BorderFactory.createLineBorder(Color.red);
				
				if (txtFysToeWzgNaam.getText().equals("") && txtFysToeWzgNaam.getText().length() >= 50)
				{
					txtFysToeWzgNaam.setBorder(redBorder);
					errorMessages.add("- Fysiotherapeut Naam");
				}
				if (txtFysToeWzgWachtwoord.getText().equals("") && txtFysToeWzgWachtwoord.getText().length() >= 50)
				{
					txtFysToeWzgWachtwoord.setBorder(redBorder);
					errorMessages.add("- Wachtwoord");
				}
				if (txtFysToeWzgWachtwoordHerhalen.getText().equals("") && txtFysToeWzgWachtwoord.getText() == txtFysToeWzgWachtwoordHerhalen.getText())
				{
					txtFysToeWzgWachtwoordHerhalen.setBorder(redBorder);
					errorMessages.add("- Wachtwoord Herhalen");
				}
				if (errorMessages.size() == 0)
				{
					/* update Fysio therapeut */
					
					
					/* end update Fysio therapeut */
					
					/* new Fysio therapeut */
					/*Fysiotherapeut fysiotherapeut = new Fysiotherapeut(txtFysToeWzgNaam.getText(), txtFysToeWzgWachtwoord.getText(), 
							Status.valueOf(cmbStatus.getSelectedItem().toString()), (Praktijk)cmbPraktijk.getSelectedItem());
					
				 	  medeManager.addMedewerker(fysiotherapeut);*/
					/* end new  Fysio therapeut */
					
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
