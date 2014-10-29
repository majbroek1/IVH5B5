package fysioSysteem.presentation;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;

import fysioSysteem.businessLogic.behanding.BehandelingManager;
import fysioSysteem.businessLogic.behanding.IBehandelingManager;
import fysioSysteem.domain.Behandeling;

public class pnlBhdlToeWzg extends JPanel {
	private JTextField txtFldBehandelCode;

	public pnlBhdlToeWzg(int behandelingId){
		//behandelingId = 2;
		
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
		
		JComboBox cmbBxKlantBSN = new JComboBox();
		cmbBxKlantBSN.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4"}));
		cmbBxKlantBSN.setBounds(125, 25, 133, 20);
		add(cmbBxKlantBSN);
		
		txtFldBehandelCode = new JTextField();
		txtFldBehandelCode.setBounds(125, 70, 133, 20);
		add(txtFldBehandelCode);
		txtFldBehandelCode.setColumns(10);
		
		JComboBox cmbBxStatus = new JComboBox();
		cmbBxStatus.setModel(new DefaultComboBoxModel(new String[] {"", "In onderzoek", "In behandeling", "Uitbehandeld"}));
		cmbBxStatus.setBounds(125, 117, 133, 20);
		add(cmbBxStatus);
		
		if(behandelingId != 0)
		{
			IBehandelingManager behandelingManager = new BehandelingManager();
			Behandeling behandeling = behandelingManager.getBehandeling(behandelingId);
			
			cmbBxKlantBSN.setSelectedItem(behandeling.getKlant().getBsn());
			txtFldBehandelCode.setText(Integer.toString(behandeling.getBehandelCode().getCode()));
			cmbBxStatus.setSelectedItem(behandeling.getStatus());
			
			JPanel pnlAfspOvz = new pnlAfspOvz();
			pnlAfspOvz.setBounds(10, 173, 866, 300);
			add(pnlAfspOvz);
		}

		JButton btnOpslaan = new JButton("Opslaan");
		btnOpslaan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOpslaan.setBounds(10, 502, 172, 29);
		add(btnOpslaan);
	}
	
	
}
