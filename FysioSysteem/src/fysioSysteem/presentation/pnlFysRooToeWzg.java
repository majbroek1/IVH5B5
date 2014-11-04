package fysioSysteem.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fysioSysteem.businessLogic.beheer.IMedewerkerManager;
import fysioSysteem.businessLogic.beheer.MedewerkerManager;
import fysioSysteem.businessLogic.planning.IRoosterManager;
import fysioSysteem.businessLogic.planning.RoosterManager;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Praktijk;
import fysioSysteem.domain.Rooster;

public class pnlFysRooToeWzg extends JPanel {
	
	private JTextField txtFysRooToeWzgNaam;
	private JTextField txtFysRooToeWzgStart;
	private JTextField txtFysRooToeWzgEind;
	private JTextField txtFysRooToeWzgDatum;
	
	private IRoosterManager roosterManager;
	private Rooster rooster;
	private Fysiotherapeut fysio;
	
	/**
	 * @wbp.parser.constructor
	 */
	public pnlFysRooToeWzg(Fysiotherapeut f) {
		this.fysio = f;
		
		roosterManager = new RoosterManager();
		rooster = roosterManager.getRooster(f.getId());
		
		genereerLayout();
		vulVelden();
	}
	
	public pnlFysRooToeWzg(Rooster r) {
		rooster = r;
		
		roosterManager = new RoosterManager();
		
		genereerLayout();
		vulVelden();
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
		
		JLabel lblFysRooToeWzgEindtijd = new JLabel("Eindtijd");
		lblFysRooToeWzgEindtijd.setBounds(32, 154, 46, 14);
		add(lblFysRooToeWzgEindtijd);
		
		JLabel lblDatum = new JLabel("Datum");
		lblDatum.setBounds(32, 76, 46, 14);
		add(lblDatum);
		
		//Buttons
		JButton btnFysRooToeWzgOpslaan = new JButton("Opslaan");
		btnFysRooToeWzgOpslaan.setBounds(131, 195, 89, 23);
		add(btnFysRooToeWzgOpslaan);
		
		JButton btnFysRooToeWzgTerug = new JButton("Terug");
		btnFysRooToeWzgTerug.setBounds(32, 195, 89, 23);
		add(btnFysRooToeWzgTerug);
		
		//TextField
		txtFysRooToeWzgNaam = new JTextField();
		txtFysRooToeWzgNaam.setText(fysio.getNaam());
		txtFysRooToeWzgNaam.setEditable(false);
		txtFysRooToeWzgNaam.setBounds(136, 33, 174, 20);
		add(txtFysRooToeWzgNaam);
		txtFysRooToeWzgNaam.setColumns(10);
		
		txtFysRooToeWzgStart = new JTextField();
		txtFysRooToeWzgStart.setBounds(136, 112, 174, 20);
		add(txtFysRooToeWzgStart);
		txtFysRooToeWzgStart.setColumns(10);
		
		txtFysRooToeWzgEind = new JTextField();
		txtFysRooToeWzgEind.setBounds(136, 151, 174, 20);
		add(txtFysRooToeWzgEind);
		txtFysRooToeWzgEind.setColumns(10);
		
		txtFysRooToeWzgDatum = new JTextField();
		txtFysRooToeWzgDatum.setBounds(136, 73, 174, 20);
		add(txtFysRooToeWzgDatum);
		txtFysRooToeWzgDatum.setColumns(10);
		
		btnFysRooToeWzgOpslaan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(PanelValidatie.valideerDatum(txtFysRooToeWzgStart.getText())
					&& PanelValidatie.valideerDatum(txtFysRooToeWzgEind.getText())) {
					
					Date startRooster = null;
					Date eindRooster = null;
					
					try {
						startRooster.parse(txtFysRooToeWzgStart.getText());
						eindRooster.parse(txtFysRooToeWzgEind.getText());
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				
					Rooster newRooster = new Rooster(startRooster, eindRooster, fysio);
					roosterManager.addRooster(newRooster);
				}
			}
		});
	}
	
	private void vulVelden() {
		
		IMedewerkerManager medewerkerManager = new MedewerkerManager();
		
		ArrayList<Fysiotherapeut> fysiotherapeuten =
			medewerkerManager.getFysiotherapeuten();
		
		DefaultComboBoxModel<Fysiotherapeut> fModel =
			new DefaultComboBoxModel<>();
		
		Fysiotherapeut selFysio = null;
		for(Fysiotherapeut f : fysiotherapeuten) {
			fModel.addElement(f);
			
			if(f.getId() == fysio.getId())
				selFysio = f;
		}
		
		
		
	}
}
