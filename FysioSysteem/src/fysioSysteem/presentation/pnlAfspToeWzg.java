package fysioSysteem.presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.Border;

import fysioSysteem.businessLogic.planning.*;
import fysioSysteem.domain.Afspraak;

public class pnlAfspToeWzg extends JPanel{
	private JTextField txtAfsprToeWzgNaam;
	private JTextField txtAfsprToeWzgDatum;
	private JTextField txtAfsprToeWzgTijdstip;
	public pnlAfspToeWzg(){
		setLayout(null);
		
		IAfspraakManager afsprManager = new AfspraakManager();
		
		Afspraak a = afsprManager.getAfspraak(1);
		
		
		
		JLabel lblAfsprToeWzgNaam = new JLabel("Naam:");
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
		
		/* TextFields en ComboBox*/
		
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
		
		// Gegevens
		
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
			
			//in geval van wijzigen, is er data ingevuld.
			
			txtAfsprToeWzgNaam.setText(a.getBehandeling().getKlant().getNaam());
			txtAfsprToeWzgDatum.setText(a.getDatumTijd().toString());
			txtAfsprToeWzgTijdstip.setText(a.getEindTijd().toString());	
			comboAfsprToeWzgBehNaam.setSelectedItem(a.getBehandeling().getBehandelCode().getBehandelingNaam());
		}
		
		// Button Handling
		
		btnAfsprToeWzgNaamOpslaan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				ArrayList<String> errorMessages = new ArrayList<String>();
				Border redBorder = BorderFactory.createLineBorder(Color.red);
				
				if (txtAfsprToeWzgNaam.getText().equals("")){
					txtAfsprToeWzgNaam.setBorder(redBorder);
					errorMessages.add("Er is geen naam ingevuld!");
				}
				
				if (txtAfsprToeWzgDatum.getText().equals("") || !validateDatum(txtAfsprToeWzgDatum.getText())){
					txtAfsprToeWzgDatum.setBorder(redBorder);
					errorMessages.add("De datum klopt niet! vul in: dd-MM-yyyy");
				}
				
				if (comboAfsprToeWzgBehNaam.getSelectedItem().toString().equals("")){
					comboAfsprToeWzgBehNaam.setBorder(redBorder);
					errorMessages.add("Er is geen behandeling gekozen!");					
				}
				
				if (txtAfsprToeWzgTijdstip.getText().equals("") || !validateTijd(txtAfsprToeWzgTijdstip.getText())){
					txtAfsprToeWzgTijdstip.setBorder(redBorder);
					errorMessages.add("Het tijdstip klopt niet! vul in: hh:mm ");
				}
				
				if (errorMessages.size() == 0){
					//Afspraak afspraak = new Afspraak( 0, txtAfsprToeWzgDatum.getText(), txtAfsprToeWzgNaam.getText(), comboAfsprToeWzgBehNaam.getSelectedItem());
					
					revalidate();
					repaint();
					JOptionPane.showMessageDialog(frame, "De afspraak is succesvol opgeslagen");
				}
				
			}
		});
		
	}
	
	private boolean validateDatum(String datum){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			sdf.parse(datum);
			return true;
		}
		catch (ParseException e) {
			return false;
		}
	}
	
	private boolean validateTijd(String tijd){
		String tijdRegex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
		
		boolean check = false;
		
		if (tijd.matches(tijdRegex)){
			check = true;
		}
		
		return check;
	}

	
}