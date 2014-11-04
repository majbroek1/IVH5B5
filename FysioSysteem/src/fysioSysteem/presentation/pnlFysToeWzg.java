package fysioSysteem.presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import com.google.inject.Guice;
import com.google.inject.Injector;

import fysioSysteem.businessLogic.beheer.IMedewerkerManager;
import fysioSysteem.businessLogic.beheer.IPraktijkManager;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Praktijk;
import fysioSysteem.domain.Status;
import general.AppInjector;

public class pnlFysToeWzg extends JPanel {
	
	private JTextField txtFysToeWzgNaam;
	private JTextField txtFysToeWzgWachtwoord;
	private JTextField txtFysToeWzgWachtwoordHerhalen;
	private JTextField txtFysToeWzgCombobox;
	private JTextField txtFieldNaam;
	private JTextField txtFieldWacthwoord;
	private JTextField txtFieldwachtwoordherhalen;
	private JComboBox cbStatus;
	private JComboBox cbPraktijk;
	
	private IMedewerkerManager medeManager;
	private IPraktijkManager prakManager;
	private Fysiotherapeut therapeut;
	
	public pnlFysToeWzg() {
		Injector injector = Guice.createInjector(new AppInjector());
		this.medeManager = injector.getInstance(IMedewerkerManager.class);
		this.prakManager = injector.getInstance(IPraktijkManager.class);
		
		genereerLayout();
		vulVelden();
	}
	
	public pnlFysToeWzg(Fysiotherapeut f) {
		Injector injector = Guice.createInjector(new AppInjector());
		this.medeManager = injector.getInstance(IMedewerkerManager.class);
		this.prakManager = injector.getInstance(IPraktijkManager.class);
		
		therapeut = f;
		
		genereerLayout();
		vulVelden();
	}
	

	public void genereerLayout() {
		setLayout(null);
		
		/* Label */
		JLabel lblFysToeWzgTitel = new JLabel("Therapeut Gegevens");
		lblFysToeWzgTitel.setBounds(74, 11, 163, 16);
		add(lblFysToeWzgTitel);
		
		JLabel lblFysToeWzgNaam = new JLabel("Therapeut Naam");
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
		add(txtFysToeWzgNaam);
		
		txtFysToeWzgWachtwoord = new JPasswordField();
		txtFysToeWzgWachtwoord.setBounds(250, 172, 134, 28);
		txtFysToeWzgWachtwoord.setColumns(10);
		add(txtFysToeWzgWachtwoord);
		
		txtFysToeWzgWachtwoordHerhalen = new JPasswordField();
		txtFysToeWzgWachtwoordHerhalen.setBounds(619, 172, 134, 28);
		txtFysToeWzgWachtwoordHerhalen.setColumns(10);
		add(txtFysToeWzgWachtwoordHerhalen);
		
		/* ComboBox */
		cbStatus = new JComboBox(Status.values());
		cbStatus.setBounds(614, 53, 134, 27);
		add(cbStatus);
		
		cbPraktijk = new JComboBox();
		cbPraktijk.setBounds(250, 112, 134, 27);		
		add(cbPraktijk);
		
		/* Button */
		JButton btnFysToeWzgOpslaan = new JButton("Opslaan");
		btnFysToeWzgOpslaan.setBounds(74, 234, 117, 29);
		add(btnFysToeWzgOpslaan);
		
		JButton btnFysToeWzgAnnuleren = new JButton("Annuleren");
		btnFysToeWzgAnnuleren.setBounds(213, 234, 117, 29);
		add(btnFysToeWzgAnnuleren);
		
	    Injector injector = Guice.createInjector(new AppInjector());
	    
		/* Button handling */
		btnFysToeWzgOpslaan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				ArrayList<String> errorMessages = new ArrayList<String>();
				Border redBorder = BorderFactory.createLineBorder(Color.red);
				
				if (txtFysToeWzgNaam.getText().equals("")
					|| txtFysToeWzgNaam.getText().length() >= 50) {
					
					txtFysToeWzgNaam.setBorder(redBorder);
					errorMessages.add("- Therapeut Naam");
				}
				
				if (txtFysToeWzgWachtwoord.getText().equals("")
					|| txtFysToeWzgWachtwoord.getText().length() >= 50) {
					
					txtFysToeWzgWachtwoord.setBorder(redBorder);
					errorMessages.add("- Wachtwoord");
				}
				
				if (txtFysToeWzgWachtwoordHerhalen.getText().equals("")
					|| txtFysToeWzgWachtwoord.getText() == txtFysToeWzgWachtwoordHerhalen.getText()) {
					
					txtFysToeWzgWachtwoordHerhalen.setBorder(redBorder);
					errorMessages.add("- Wachtwoord Herhalen");
				}
				
				if (errorMessages.size() < 1) {
					if (therapeut == null) {
						Fysiotherapeut Fysiotherapeut = new Fysiotherapeut(txtFysToeWzgNaam.getText(), txtFysToeWzgWachtwoord.getText(), 
							Status.valueOf(cbStatus.getSelectedItem().toString()), (Praktijk)cbPraktijk.getSelectedItem());
						
						medeManager.addMedewerker(Fysiotherapeut);
					}
					else {
						Fysiotherapeut Fysiotherapeut = new Fysiotherapeut(therapeut.getId(),txtFysToeWzgNaam.getText(), txtFysToeWzgWachtwoord.getText(), 
							Status.valueOf(cbStatus.getSelectedItem().toString()), (Praktijk)cbPraktijk.getSelectedItem());
						
						medeManager.setMedewerker(Fysiotherapeut);
					}
				    
				    JOptionPane.showMessageDialog(frame, "De fysiotherapeut gegevens zijn succesvol opgeslagen.");
				    
				    frmMain parent = (frmMain)getParentFrame();
				    parent.setPanel(injector.getInstance(pnlFysOvz.class));
				}
				else {
					int sizeStringBuilder = errorMessages.size() + 1;
					StringBuilder builder = new StringBuilder(sizeStringBuilder);
					builder.append("Controleer de volgende velden op volledigheid en correctheid:" + "\n");
					
					for (String s: errorMessages)
						builder.append(s + "\n");
					
					JOptionPane.showMessageDialog(null, builder.toString());
				}
			}
		});
		
		btnFysToeWzgAnnuleren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMain parent = (frmMain)getParentFrame();
				parent.setPanel(injector.getInstance(pnlFysOvz.class));
			}
		});
	}
	
	private void vulVelden() {
		ArrayList<Praktijk> praktijken =
			prakManager.getPraktijken();
		
		DefaultComboBoxModel<Praktijk> pModel =
			new DefaultComboBoxModel<Praktijk>();
		
		Praktijk selPraktijk = null;
		for(Praktijk p : praktijken) {
			pModel.addElement(p);
			
			if (therapeut != null) {
				if(p.getId() == therapeut.getPraktijk().getId())
					selPraktijk = p;
			}
		}

		cbPraktijk.setModel(pModel);
		
		if (therapeut != null) {
			txtFysToeWzgNaam.setText(therapeut.getNaam());
			txtFysToeWzgWachtwoord.setText(therapeut.getWachtwoord());
			txtFysToeWzgWachtwoordHerhalen.setText(therapeut.getWachtwoord());
			cbStatus.setSelectedItem(therapeut.getStatus());
			
			if(selPraktijk != null)
				cbPraktijk.setSelectedItem(selPraktijk);
		}
	}
	
	private JFrame getParentFrame(){
		return (JFrame)SwingUtilities.getRoot(this);
	}
}
