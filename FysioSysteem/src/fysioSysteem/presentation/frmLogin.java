package fysioSysteem.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.google.inject.Inject;

import fysioSysteem.businessLogic.login.ILoginManager;

public class frmLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6124993491429127842L;
	private JPanel contentPane;
	private JTextField txtMedewerkerID;
	private JPasswordField txtMedewerkerPass;
	private ILoginManager lgn;

	/**
	 * Create the frame.
	 */
	@Inject
	public frmLogin(ILoginManager lgn) {
		this.lgn = lgn;
		setResizable(false);
		setTitle("Inloggen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMedewerkerid = new JLabel("MedewerkerID");
		lblMedewerkerid.setBounds(10, 11, 414, 14);
		contentPane.add(lblMedewerkerid);
		
		txtMedewerkerID = new JTextField();
		txtMedewerkerID.setBounds(10, 36, 414, 20);
		contentPane.add(txtMedewerkerID);
		txtMedewerkerID.setColumns(10);
		
		JLabel lblWachtwoord = new JLabel("Wachtwoord");
		lblWachtwoord.setBounds(10, 67, 414, 14);
		contentPane.add(lblWachtwoord);
		
		txtMedewerkerPass = new JPasswordField();
		txtMedewerkerPass.setBounds(10, 92, 414, 20);
		contentPane.add(txtMedewerkerPass);
		
		JButton btnInloggen = new JButton("Inloggen");
		btnInloggen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int medewerkerId = Integer.parseInt(txtMedewerkerID.getText());
					String medewerkerPass = new String(txtMedewerkerPass.getPassword());
					
					if(lgn.valideer(medewerkerId, medewerkerPass)) {
						frmLogin.this.dispose();
						new frmMain().setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(frmLogin.this,
							    "Ongeldige gebruikersnaam of wachtwoord",
							    "Validatie error",
							    JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnInloggen.setBounds(299, 123, 125, 23);
		contentPane.add(btnInloggen);
		
		JButton btnAnnuleren = new JButton("Annuleren");
		btnAnnuleren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnAnnuleren.setBounds(10, 123, 125, 23);
		contentPane.add(btnAnnuleren);
	}
}
