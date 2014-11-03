package fysioSysteem.presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import fysioSysteem.businessLogic.planning.AfspraakManager;
import fysioSysteem.businessLogic.planning.IAfspraakManager;
import fysioSysteem.domain.Afspraak;

public class pnlAfspToeWzg extends JPanel {
	
	private JTextField txtAfsprToeWzgNaam;
	private JTextField txtAfsprToeWzgDatum;
	private JTextField txtAfsprToeWzgTijdstip;
	private JComboBox comboAfsprToeWzgBehNaam;
	
	private Afspraak afspraak = null;
	
	public pnlAfspToeWzg() {
		setLayout(null);
		
		IAfspraakManager afsprManager = new AfspraakManager();
		afspraak = afsprManager.getAfspraak(1);
		renderControls();
		
		if(afspraak != null)
			vulVelden();
	}
	
	private void renderControls() {
		JLabel lblAfsprToeWzgNaam = new JLabel("Naam");
		lblAfsprToeWzgNaam.setBounds(60, 54, 46, 14);
		add(lblAfsprToeWzgNaam);
		
		JLabel lblAfsprToeWzgBehandelingsnaam = new JLabel("Behandelingsnaam");
		lblAfsprToeWzgBehandelingsnaam.setBounds(60, 97, 113, 14);
		add(lblAfsprToeWzgBehandelingsnaam);
		
		JLabel lblAfsprToeWzgDatum = new JLabel("Datum");
		lblAfsprToeWzgDatum.setBounds(60, 140, 46, 14);
		add(lblAfsprToeWzgDatum);
				
		JLabel lblAfsprToeWzgTijdstip = new JLabel("Tijdstip");
		lblAfsprToeWzgTijdstip.setBounds(60, 182, 46, 14);
		add(lblAfsprToeWzgTijdstip);
		
		// TextFields & ComboBox
		txtAfsprToeWzgNaam = new JTextField();
		txtAfsprToeWzgNaam.setBounds(216, 46, 153, 31);
		add(txtAfsprToeWzgNaam);
		txtAfsprToeWzgNaam.setColumns(10);
		
		JComboBox comboAfsprToeWzgBehNaam = new JComboBox();
		comboAfsprToeWzgBehNaam.setBounds(216, 88, 153, 33);
		add(comboAfsprToeWzgBehNaam);
		
		txtAfsprToeWzgDatum = new JTextField();
		txtAfsprToeWzgDatum.setBounds(216, 132, 153, 31);
		add(txtAfsprToeWzgDatum);
		txtAfsprToeWzgDatum.setColumns(10);
		
		txtAfsprToeWzgTijdstip = new JTextField();
		txtAfsprToeWzgTijdstip.setBounds(216, 174, 153, 31);
		add(txtAfsprToeWzgTijdstip);
		txtAfsprToeWzgTijdstip.setColumns(10);
		
		JButton btnAfsprToeWzgNaamOpslaan = new JButton("Opslaan");
		btnAfsprToeWzgNaamOpslaan.setBounds(60, 236, 117, 29);
		add(btnAfsprToeWzgNaamOpslaan);
		
		JLabel lblAfspToeWzgTitel = new JLabel();
		lblAfspToeWzgTitel.setBounds(74, 11, 120, 16);
		add(lblAfspToeWzgTitel);
		
		// Panel titel
		if (afspraak != null) {			
			lblAfspToeWzgTitel.setText("Afspraak Wijzigen");
		}
		else {
			lblAfspToeWzgTitel.setText("Afspraak Toevoegen");
		}
		
		// Button Handling
		btnAfsprToeWzgNaamOpslaan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				ArrayList<String> errorMessages = new ArrayList<String>();
				Border redBorder = BorderFactory.createLineBorder(Color.red);
				
				if (txtAfsprToeWzgNaam.getText().equals("")) {
					txtAfsprToeWzgNaam.setBorder(redBorder);
					errorMessages.add("Er is geen naam ingevuld!");
				}
				
				if (txtAfsprToeWzgDatum.getText().equals("")
					|| PanelValidatie.valideerDatum(txtAfsprToeWzgDatum.getText())) {
					txtAfsprToeWzgDatum.setBorder(redBorder);
					errorMessages.add("De datum klopt niet! vul in: dd-MM-yyyy");
				}
				
				if (comboAfsprToeWzgBehNaam.getSelectedItem().toString().equals("")) {
					comboAfsprToeWzgBehNaam.setBorder(redBorder);
					errorMessages.add("Er is geen behandeling gekozen!");					
				}
				
				if (txtAfsprToeWzgTijdstip.getText().equals("")
					|| PanelValidatie.valideerTijd(txtAfsprToeWzgTijdstip.getText())) {
					txtAfsprToeWzgTijdstip.setBorder(redBorder);
					errorMessages.add("Het tijdstip klopt niet! vul in: hh:mm ");
				}
				
				if (errorMessages.size() < 1) {
					//Afspraak afspraak = new Afspraak( 0, txtAfsprToeWzgDatum.getText(), txtAfsprToeWzgNaam.getText(), comboAfsprToeWzgBehNaam.getSelectedItem());
					
					revalidate();
					repaint();
					JOptionPane.showMessageDialog(frame, "De afspraak is succesvol opgeslagen");
				}
			}
		});
	}
	
	private void vulVelden() {
		txtAfsprToeWzgNaam.setText(
			afspraak.getBehandeling().getKlant().getNaam());
		
		txtAfsprToeWzgDatum.setText(
			afspraak.getDatumTijd().toString());
		
		txtAfsprToeWzgTijdstip.setText(
			afspraak.getEindTijd().toString());	
		
		comboAfsprToeWzgBehNaam.setSelectedItem(
			afspraak.getBehandeling().getBehandelCode().getBehandelingNaam());
	}

}
