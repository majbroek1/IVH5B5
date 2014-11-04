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
import javax.swing.JComboBox;

public class pnlFysRooToeWzg extends JPanel {
	
	private JTextField txtFysRooToeWzgStart;
	private JTextField txtFysRooToeWzgEind;
	private JTextField txtFysRooToeWzgDatum;
	private JComboBox cbFysio;
	
	private IRoosterManager roosterManager;
	private Rooster rooster;
	private Fysiotherapeut fysio;
	
	public pnlFysRooToeWzg(Fysiotherapeut f) {
		roosterManager = new RoosterManager();
		
		fysio = f;
		rooster = roosterManager.getRooster(f.getId());
		
		genereerLayout();
		vulVelden();
	}
	
	public pnlFysRooToeWzg(Rooster r) {
		roosterManager = new RoosterManager();
		
		rooster = r;
		
		genereerLayout();
		vulVelden();
	}
	
	private void genereerLayout() {
		setLayout(null);
		
		// Labels
		JLabel lblRooster = new JLabel("Voeg Rooster toe/Wijzig rooster");
		lblRooster.setBounds(10, 11, 154, 14);
		add(lblRooster);
		
		JLabel lblFysRooToeWzgStarttijd = new JLabel("Starttijd");
		lblFysRooToeWzgStarttijd.setBounds(10, 116, 46, 14);
		add(lblFysRooToeWzgStarttijd);
		
		JLabel lblFysRooToeWzgEindtijd = new JLabel("Eindtijd");
		lblFysRooToeWzgEindtijd.setBounds(10, 155, 46, 14);
		add(lblFysRooToeWzgEindtijd);
		
		JLabel lblDatum = new JLabel("Datum");
		lblDatum.setBounds(10, 77, 46, 14);
		add(lblDatum);
		
		//Buttons
		JButton btnFysRooToeWzgOpslaan = new JButton("Opslaan");
		btnFysRooToeWzgOpslaan.setBounds(221, 192, 89, 23);
		add(btnFysRooToeWzgOpslaan);
		
		JButton btnFysRooToeWzgTerug = new JButton("Terug");
		btnFysRooToeWzgTerug.setBounds(10, 192, 89, 23);
		add(btnFysRooToeWzgTerug);
		
		txtFysRooToeWzgStart = new JTextField();
		txtFysRooToeWzgStart.setBounds(114, 113, 174, 20);
		add(txtFysRooToeWzgStart);
		txtFysRooToeWzgStart.setColumns(10);
		
		txtFysRooToeWzgEind = new JTextField();
		txtFysRooToeWzgEind.setBounds(114, 152, 174, 20);
		add(txtFysRooToeWzgEind);
		txtFysRooToeWzgEind.setColumns(10);
		
		txtFysRooToeWzgDatum = new JTextField();
		txtFysRooToeWzgDatum.setBounds(114, 74, 174, 20);
		add(txtFysRooToeWzgDatum);
		txtFysRooToeWzgDatum.setColumns(10);
		
		cbFysio = new JComboBox();
		cbFysio.setBounds(114, 36, 174, 20);
		add(cbFysio);
		
		JLabel lblFysiotherapeut = new JLabel("Fysiotherapeut");
		lblFysiotherapeut.setBounds(10, 39, 89, 14);
		add(lblFysiotherapeut);
		
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
			
			if(f.getId() == rooster.getFysiotherapeut().getId())
				selFysio = f;
		}
		
		cbFysio.setModel(fModel);
		
	}
}
