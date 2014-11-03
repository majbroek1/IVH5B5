package fysioSysteem.presentation;

import fysioSysteem.businessLogic.behandeling.BehandelingManager;
import fysioSysteem.businessLogic.behandeling.IBehandelCodeManager;
import fysioSysteem.businessLogic.behandeling.IBehandelingManager;
import fysioSysteem.businessLogic.behandeling.IKlantManager;
import fysioSysteem.businessLogic.beheer.IPraktijkManager;
import fysioSysteem.domain.BehandelCode;
import fysioSysteem.domain.BehandelStatus;
import fysioSysteem.domain.Behandeling;
import fysioSysteem.domain.Klant;
import fysioSysteem.domain.Status;
import general.AppInjector;

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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class pnlBhdlToeWzg extends JPanel {
	private JTextField txtFldBehandelCode;
	private JComboBox<Object> cmbBxKlantBSN, cmbBxStatus;
	
	private IBehandelingManager behandelingManager;
	private IBehandelCodeManager behandelCodeManager;
	private IKlantManager klantManager;
	private Behandeling behandeling;
	
	public pnlBhdlToeWzg() {
		Injector injector = Guice.createInjector(new AppInjector());
		behandelingManager = injector.getInstance(IBehandelingManager.class);
		behandelCodeManager = injector.getInstance(IBehandelCodeManager.class);
		klantManager = injector.getInstance(IKlantManager.class);
		genereerLayout();
	}

	public pnlBhdlToeWzg(int behandelingId){
		Injector injector = Guice.createInjector(new AppInjector());
		behandelingManager = injector.getInstance(IBehandelingManager.class);
		behandelCodeManager = injector.getInstance(IBehandelCodeManager.class);
		klantManager =  injector.getInstance(IKlantManager.class);
		this.behandeling = behandelingManager.getBehandeling(behandelingId);
		genereerLayout();
		vulVelden();
	}	
	
	private void genereerLayout() {
		setLayout(null);
		
		JLabel lblKlant = new JLabel("Klant");
		lblKlant.setBounds(10, 28, 139, 14);
		add(lblKlant);
		
		JLabel lblBehandelingnaam = new JLabel("Status");
		lblBehandelingnaam.setBounds(10, 120, 125, 14);
		add(lblBehandelingnaam);
		
		JLabel lblBehandelcode = new JLabel("Behandelcode");
		lblBehandelcode.setBounds(10, 73, 106, 14);
		add(lblBehandelcode);
		
		cmbBxKlantBSN = new JComboBox();
		cmbBxKlantBSN.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		cmbBxKlantBSN.setBounds(125, 25, 133, 20);
		add(cmbBxKlantBSN);
		
		txtFldBehandelCode = new JTextField();
		txtFldBehandelCode.setBounds(125, 70, 133, 20);
		add(txtFldBehandelCode);
		txtFldBehandelCode.setColumns(10);
		
		cmbBxStatus = new JComboBox();
		cmbBxStatus.setModel(new DefaultComboBoxModel(BehandelStatus.values()));
		cmbBxStatus.setBounds(125, 117, 133, 20);
		add(cmbBxStatus);
		
		JButton btnOpslaan = new JButton("Opslaan");
		btnOpslaan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new JFrame();
				ArrayList<String> errorMessages = new ArrayList<String>();
				Border redBorder = BorderFactory.createLineBorder(Color.red);
				
				if (txtFldBehandelCode.getText().equals("") && txtFldBehandelCode.getText().length() >= 10)
				{
					txtFldBehandelCode.setBorder(redBorder);
					errorMessages.add("- Behandelcode is incorrect");
				}
				
				if(cmbBxKlantBSN.getSelectedItem().toString() == "")
				{
					txtFldBehandelCode.setBorder(redBorder);
					errorMessages.add("- Behandelcode is incorrect");
				}
				
				if (errorMessages.size() == 0)
				{
					BehandelCode behandelCode = behandelCodeManager.getBehandelCode(Integer.parseInt(txtFldBehandelCode.getText()));
					Klant klant = klantManager.getKlant(cmbBxKlantBSN.getSelectedItem().toString());
					if(behandeling != null)
					{
						Behandeling newBehandeling = new Behandeling(behandeling.getId(), BehandelStatus.valueOf(cmbBxStatus.getSelectedItem().toString()), klant, behandelCode);
						behandelingManager.setBehandeling(newBehandeling);
					}
					else
					{
						Behandeling newBehandeling = new Behandeling(BehandelStatus.valueOf(cmbBxStatus.getSelectedItem().toString()), klant, behandelCode);
						behandelingManager.addBehandeling(newBehandeling);
					}				
					revalidate();
				    repaint();
				    
				    JOptionPane.showMessageDialog(frame, "De behandelinggegevens zijn succesvol opgeslagen.");
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
		btnOpslaan.setBounds(10, 502, 172, 29);
		add(btnOpslaan);
		
		JButton btnAnnuleren = new JButton("Annuleren");
		btnAnnuleren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMain parent = (frmMain)getParentFrame();
				parent.setPanel(new pnlBhdlOvz());
			}
		});
		btnAnnuleren.setBounds(248, 502, 172, 29);
		add(btnAnnuleren);
	}
	
	private void vulVelden()
	{
		cmbBxKlantBSN.setSelectedItem(behandeling.getKlant().getBsn());
		txtFldBehandelCode.setText(Integer.toString(behandeling.getBehandelCode().getCode()));
		cmbBxStatus.setSelectedItem(behandeling.getStatus());
	}
	
	private JFrame getParentFrame(){
		return (JFrame)SwingUtilities.getRoot(this);
	}
}
