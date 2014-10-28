package fysioSysteem.presentation;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlBhdlToeWzg extends JPanel {
	private JTextField txtFldBehandelingNaam;
	private JTextField txtFldBehandelCode;
	public pnlBhdlToeWzg(){
		setLayout(null);
		
		JLabel lblFysiotherapeut = new JLabel("Fysiotherapeut");
		lblFysiotherapeut.setBounds(10, 28, 139, 14);
		add(lblFysiotherapeut);
		
		JLabel lblBehandelingnaam = new JLabel("Behandelingnaam");
		lblBehandelingnaam.setBounds(10, 73, 125, 14);
		add(lblBehandelingnaam);
		
		JLabel lblBehandelcode = new JLabel("Behandelcode");
		lblBehandelcode.setBounds(10, 120, 106, 14);
		add(lblBehandelcode);
		
		JComboBox cmbBxFysiotherapeut = new JComboBox();
		cmbBxFysiotherapeut.setBounds(125, 25, 133, 20);
		add(cmbBxFysiotherapeut);
		
		txtFldBehandelingNaam = new JTextField();
		txtFldBehandelingNaam.setBounds(125, 70, 133, 20);
		add(txtFldBehandelingNaam);
		txtFldBehandelingNaam.setColumns(10);
		
		txtFldBehandelCode = new JTextField();
		txtFldBehandelCode.setColumns(10);
		txtFldBehandelCode.setBounds(125, 117, 133, 20);
		add(txtFldBehandelCode);
		
		JButton button = new JButton("Opslaan");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(10, 203, 172, 29);
		add(button);
	}
}
