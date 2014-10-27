package fysioSysteem.presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class frmMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -724883528804552733L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain frame = new frmMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmMain() {
		setResizable(false);
		setTitle("FysioSysteem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1092, 695);
		getContentPane().setLayout(null);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(new Color(204, 0, 0));
		pnlMenu.setBounds(0, 0, 200, 666);
		getContentPane().add(pnlMenu);
		GridBagLayout gbl_pnlMenu = new GridBagLayout();
		gbl_pnlMenu.columnWidths = new int[]{0, 0};
		gbl_pnlMenu.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_pnlMenu.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlMenu.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlMenu.setLayout(gbl_pnlMenu);
		
		JButton btnAfspraken = new JButton("Afspraken");
		btnAfspraken.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnAfspraken = new GridBagConstraints();
		gbc_btnAfspraken.insets = new Insets(0, 0, 5, 0);
		gbc_btnAfspraken.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAfspraken.gridx = 0;
		gbc_btnAfspraken.gridy = 0;
		pnlMenu.add(btnAfspraken, gbc_btnAfspraken);
		
		JButton btnFysiotherapeuten = new JButton("Fsyiotherapeuten");
		btnFysiotherapeuten.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnFysiotherapeuten = new GridBagConstraints();
		gbc_btnFysiotherapeuten.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFysiotherapeuten.insets = new Insets(0, 0, 5, 0);
		gbc_btnFysiotherapeuten.gridx = 0;
		gbc_btnFysiotherapeuten.gridy = 1;
		pnlMenu.add(btnFysiotherapeuten, gbc_btnFysiotherapeuten);
		
		JButton btnBehandelingen = new JButton("Behandelingen");
		btnBehandelingen.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnBehandelingen = new GridBagConstraints();
		gbc_btnBehandelingen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBehandelingen.insets = new Insets(0, 0, 5, 0);
		gbc_btnBehandelingen.gridx = 0;
		gbc_btnBehandelingen.gridy = 2;
		pnlMenu.add(btnBehandelingen, gbc_btnBehandelingen);
		
		JButton btnPraktijk = new JButton("Praktijk");
		btnPraktijk.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnPraktijk = new GridBagConstraints();
		gbc_btnPraktijk.insets = new Insets(0, 0, 5, 0);
		gbc_btnPraktijk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPraktijk.gridx = 0;
		gbc_btnPraktijk.gridy = 3;
		pnlMenu.add(btnPraktijk, gbc_btnPraktijk);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 0, 0));
		separator.setBackground(new Color(153, 0, 0));
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 4;
		pnlMenu.add(separator, gbc_separator);
		
		JButton btnUitloggen = new JButton("Uitloggen");
		btnUitloggen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMain.this.dispose();
				new frmLogin().setVisible(true);				
			}
		});
		btnUitloggen.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnUitloggen = new GridBagConstraints();
		gbc_btnUitloggen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUitloggen.gridx = 0;
		gbc_btnUitloggen.gridy = 5;
		pnlMenu.add(btnUitloggen, gbc_btnUitloggen);
		
		JPanel pnlContent = new JPanel();
		pnlContent.setBackground(Color.WHITE);
		pnlContent.setBounds(200, 0, 886, 666);
		getContentPane().add(pnlContent);
		pnlContent.setLayout(null);
	}
}
