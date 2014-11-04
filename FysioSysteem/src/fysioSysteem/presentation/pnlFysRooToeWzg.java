package fysioSysteem.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fysioSysteem.businessLogic.beheer.IMedewerkerManager;
import fysioSysteem.businessLogic.beheer.MedewerkerManager;
import fysioSysteem.businessLogic.planning.IRoosterManager;
import fysioSysteem.businessLogic.planning.RoosterManager;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Rooster;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;

public class pnlFysRooToeWzg extends JPanel {
	private JComboBox cbFysio;
	
	private IRoosterManager roosterManager;
	private Rooster rooster;
	private Fysiotherapeut fysio;
	
	/**
	 * @wbp.parser.constructor
	 */
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
		lblFysRooToeWzgStarttijd.setBounds(10, 117, 46, 14);
		add(lblFysRooToeWzgStarttijd);
		
		JLabel lblFysRooToeWzgEindtijd = new JLabel("Eindtijd");
		lblFysRooToeWzgEindtijd.setBounds(10, 156, 46, 14);
		add(lblFysRooToeWzgEindtijd);
		
		JLabel lblDatum = new JLabel("Datum");
		lblDatum.setBounds(10, 77, 46, 14);
		add(lblDatum);
		
		//Buttons
		JButton btnFysRooToeWzgOpslaan = new JButton("Opslaan");
		btnFysRooToeWzgOpslaan.setBounds(221, 193, 89, 23);
		add(btnFysRooToeWzgOpslaan);
		
		JButton btnFysRooToeWzgTerug = new JButton("Terug");
		btnFysRooToeWzgTerug.setBounds(10, 193, 89, 23);
		add(btnFysRooToeWzgTerug);
		
		cbFysio = new JComboBox();
		cbFysio.setBounds(114, 36, 174, 20);
		add(cbFysio);
		
		JLabel lblFysiotherapeut = new JLabel("Fysiotherapeut");
		lblFysiotherapeut.setBounds(10, 39, 89, 14);
		add(lblFysiotherapeut);
		
		JSpinner spnStartUur = new JSpinner();
		spnStartUur.setBounds(114, 114, 78, 20);
		add(spnStartUur);
		
		JSpinner spnStartMinuten = new JSpinner();
		spnStartMinuten.setBounds(222, 114, 66, 20);
		add(spnStartMinuten);
		
		JLabel label = new JLabel(":");
		label.setBounds(202, 117, 4, 14);
		add(label);
		
		JSpinner spnEindUur = new JSpinner();
		spnEindUur.setBounds(114, 156, 78, 20);
		add(spnEindUur);
		
		JLabel label_1 = new JLabel(":");
		label_1.setBounds(202, 159, 4, 14);
		add(label_1);
		
		JSpinner spnEindMinuten = new JSpinner();
		spnEindMinuten.setBounds(222, 156, 66, 20);
		add(spnEindMinuten);
		
		JDateChooser dcDatum = new JDateChooser();
		dcDatum.setBounds(114, 67, 89, 20);
		add(dcDatum);
		
		btnFysRooToeWzgOpslaan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(dcDatum.getDate().toString());
				
				/*
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
				*/
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
