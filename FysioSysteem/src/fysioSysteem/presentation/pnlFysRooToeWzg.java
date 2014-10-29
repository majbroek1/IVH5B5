package fysioSysteem.presentation;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fysioSysteem.businessLogic.planning.*;
import fysioSysteem.domain.Rooster;

import fysioSysteem.businessLogic.planning.IRoosterManager;

public class pnlFysRooToeWzg extends JPanel{
	private JTextField textFieldFysRooToeWzgNaam;
	private int roosterID = 0;
	
	public pnlFysRooToeWzg(){
		setLayout(null);
		
		IRoosterManager roosManager = new RoosterManager();
		
		Rooster r = roosManager.getRooster(roosterID);
		
		
		// Labels
		
		JLabel lblRooster = new JLabel("Voeg Rooster toe/Wijzig rooster");
		lblRooster.setBounds(10, 11, 154, 14);
		add(lblRooster);
		
		JLabel lblFysRooToeWzgNaam = new JLabel("Naam");
		lblFysRooToeWzgNaam.setBounds(32, 36, 46, 14);
		add(lblFysRooToeWzgNaam);
		
		JLabel lblFysRooToeWzgMaandag = new JLabel("Maandag");
		lblFysRooToeWzgMaandag.setBounds(32, 71, 46, 14);
		add(lblFysRooToeWzgMaandag);
		
		JLabel lblFysRooToeWzgDinsdag = new JLabel("Dinsdag");
		lblFysRooToeWzgDinsdag.setBounds(32, 110, 46, 14);
		add(lblFysRooToeWzgDinsdag);
		
		JLabel lblFysRooToeWzgWoensdag = new JLabel("Woensdag");
		lblFysRooToeWzgWoensdag.setBounds(32, 154, 60, 14);
		add(lblFysRooToeWzgWoensdag);
		
		JLabel lblFysRooToeWzgDonderdag = new JLabel("Donderdag");
		lblFysRooToeWzgDonderdag.setBounds(289, 71, 53, 14);
		add(lblFysRooToeWzgDonderdag);
		
		JLabel lblFysRooToeWzgVrijdag = new JLabel("Vrijdag");
		lblFysRooToeWzgVrijdag.setBounds(289, 110, 46, 14);
		add(lblFysRooToeWzgVrijdag);
		
		//ComboBoxes
		
		JComboBox comboBoxFysRooToeWzgMaandag = new JComboBox();
		comboBoxFysRooToeWzgMaandag.setBounds(136, 68, 105, 20);
		add(comboBoxFysRooToeWzgMaandag);
		
		JComboBox comboBoxFysRooToeWzgDinsdag = new JComboBox();
		comboBoxFysRooToeWzgDinsdag.setBounds(136, 107, 105, 20);
		add(comboBoxFysRooToeWzgDinsdag);
		
		JComboBox comboBoxFysRooToeWzgWoensdag = new JComboBox();
		comboBoxFysRooToeWzgWoensdag.setBounds(136, 151, 105, 20);
		add(comboBoxFysRooToeWzgWoensdag);
		
		JComboBox comboBoxFysRooToeWzgDonderdag = new JComboBox();
		comboBoxFysRooToeWzgDonderdag.setBounds(368, 68, 105, 20);
		add(comboBoxFysRooToeWzgDonderdag);
		
		JComboBox comboBoxFysRooToeWzgVrijdag = new JComboBox();
		comboBoxFysRooToeWzgVrijdag.setBounds(368, 107, 105, 20);
		add(comboBoxFysRooToeWzgVrijdag);
		
		//Buttons
		
		JButton btnFysRooToeWzgOpslaan = new JButton("Opslaan");
		btnFysRooToeWzgOpslaan.setBounds(32, 250, 89, 23);
		add(btnFysRooToeWzgOpslaan);
		
		JButton btnFysRooToeWzgTerug = new JButton("Terug");
		btnFysRooToeWzgTerug.setBounds(32, 315, 89, 23);
		add(btnFysRooToeWzgTerug);
		
		//TextField
		
		textFieldFysRooToeWzgNaam = new JTextField();
		textFieldFysRooToeWzgNaam.setEditable(false);
		textFieldFysRooToeWzgNaam.setBounds(136, 33, 174, 20);
		add(textFieldFysRooToeWzgNaam);
		textFieldFysRooToeWzgNaam.setColumns(10);
		

	}
}
