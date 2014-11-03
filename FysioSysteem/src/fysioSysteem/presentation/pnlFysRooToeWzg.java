package fysioSysteem.presentation;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fysioSysteem.businessLogic.planning.*;
import fysioSysteem.domain.Rooster;
import fysioSysteem.domain.Fysiotherapeut;

import fysioSysteem.businessLogic.planning.IRoosterManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlFysRooToeWzg extends JPanel {
	
	private JTextField txtFysRooToeWzgNaam;
	private JTextField txtFysRooToeWzgStart;
	private JTextField txtFysRooToeWzgEind;
	private JTextField txtFysRooToeWzgDatum;
	
	private Rooster rooster;
	private Fysiotherapeut fysio;
	
	public pnlFysRooToeWzg(Fysiotherapeut f){
		this.fysio = f;
		
		IRoosterManager roosManager = new RoosterManager();
		rooster = roosManager.getRooster(f.getId());
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
		lblFysRooToeWzgStarttijd.setBounds(32, 115, 46, 14);
		add(lblFysRooToeWzgStarttijd);
		
		JLabel lblFysRooToeWzgEindtijd = new JLabel("Eindtijd:");
		lblFysRooToeWzgEindtijd.setBounds(32, 154, 46, 14);
		add(lblFysRooToeWzgEindtijd);
		
		JLabel lblDatum = new JLabel("Datum:");
		lblDatum.setBounds(32, 76, 46, 14);
		add(lblDatum);
		
		//Buttons
		JButton btnFysRooToeWzgOpslaan = new JButton("Opslaan");
		btnFysRooToeWzgOpslaan.setBounds(32, 250, 89, 23);
		add(btnFysRooToeWzgOpslaan);
		
		JButton btnFysRooToeWzgTerug = new JButton("Terug");
		btnFysRooToeWzgTerug.setBounds(32, 315, 89, 23);
		add(btnFysRooToeWzgTerug);
		
		//TextField
		txtFysRooToeWzgNaam = new JTextField();
		txtFysRooToeWzgNaam.setText(fysio.getNaam());
		txtFysRooToeWzgNaam.setEditable(false);
		txtFysRooToeWzgNaam.setBounds(136, 33, 174, 20);
		add(txtFysRooToeWzgNaam);
		txtFysRooToeWzgNaam.setColumns(10);
		
		txtFysRooToeWzgStart = new JTextField();
		txtFysRooToeWzgStart.setBounds(136, 112, 86, 20);
		add(txtFysRooToeWzgStart);
		txtFysRooToeWzgStart.setColumns(10);
		
		txtFysRooToeWzgEind = new JTextField();
		txtFysRooToeWzgEind.setBounds(136, 151, 86, 20);
		add(txtFysRooToeWzgEind);
		txtFysRooToeWzgEind.setColumns(10);
		
		txtFysRooToeWzgDatum = new JTextField();
		txtFysRooToeWzgDatum.setBounds(136, 73, 86, 20);
		add(txtFysRooToeWzgDatum);
		txtFysRooToeWzgDatum.setColumns(10);
		

		

		
		btnFysRooToeWzgOpslaan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Rooster newRooster = new Rooster(0,null/*lblFysRooToeWzgStarttijd.getText()*/,null/*lblFysRooToeWzgEindtijd.getText()*/,fysio);
				
			}
		});
		
	}
}
