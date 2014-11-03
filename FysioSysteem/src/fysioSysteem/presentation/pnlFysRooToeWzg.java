package fysioSysteem.presentation;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fysioSysteem.businessLogic.planning.*;
import fysioSysteem.domain.Rooster;

import fysioSysteem.businessLogic.planning.IRoosterManager;

public class pnlFysRooToeWzg extends JPanel {
	
	private JTextField txtFysRooToeWzgNaam;
	private JTextField txtFysRooToeWzgStart;
	private JTextField txtFysRooToeWzgEind;
	
	private Rooster rooster;
	
	public pnlFysRooToeWzg(){		
		IRoosterManager roosManager = new RoosterManager();
		rooster = roosManager.getRooster(0);
		
		genereerLayout();
	}
	
	private void genereerLayout() {
		setLayout(null);
		
		// Labels
		JLabel lblRooster = new JLabel("Voeg Rooster toe/Wijzig rooster");
		lblRooster.setBounds(10, 11, 154, 14);
		add(lblRooster);
		
		JLabel lblFysRooToeWzgNaam = new JLabel("Naam");
		lblFysRooToeWzgNaam.setBounds(32, 36, 46, 14);
		add(lblFysRooToeWzgNaam);
		
		JLabel lblFysRooToeWzgStarttijd = new JLabel("Starttijd");
		lblFysRooToeWzgStarttijd.setBounds(32, 71, 46, 14);
		add(lblFysRooToeWzgStarttijd);
		
		JLabel lblFysRooToeWzgEindtijd = new JLabel("Eindtijd:");
		lblFysRooToeWzgEindtijd.setBounds(32, 110, 46, 14);
		add(lblFysRooToeWzgEindtijd);
		
		//Buttons
		JButton btnFysRooToeWzgOpslaan = new JButton("Opslaan");
		btnFysRooToeWzgOpslaan.setBounds(32, 250, 89, 23);
		add(btnFysRooToeWzgOpslaan);
		
		JButton btnFysRooToeWzgTerug = new JButton("Terug");
		btnFysRooToeWzgTerug.setBounds(32, 315, 89, 23);
		add(btnFysRooToeWzgTerug);
		
		//TextField
		txtFysRooToeWzgNaam = new JTextField();
		txtFysRooToeWzgNaam.setEditable(false);
		txtFysRooToeWzgNaam.setBounds(136, 33, 174, 20);
		add(txtFysRooToeWzgNaam);
		txtFysRooToeWzgNaam.setColumns(10);
		
		txtFysRooToeWzgStart = new JTextField();
		txtFysRooToeWzgStart.setBounds(136, 68, 86, 20);
		add(txtFysRooToeWzgStart);
		txtFysRooToeWzgStart.setColumns(10);
		
		txtFysRooToeWzgEind = new JTextField();
		txtFysRooToeWzgEind.setBounds(136, 107, 86, 20);
		add(txtFysRooToeWzgEind);
		txtFysRooToeWzgEind.setColumns(10);
	}
}
