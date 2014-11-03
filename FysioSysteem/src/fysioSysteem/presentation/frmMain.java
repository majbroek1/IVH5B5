package fysioSysteem.presentation;

import general.AppInjector;

import java.awt.CardLayout;
import java.awt.Color;
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

import com.google.inject.Guice;
import com.google.inject.Injector;

public class frmMain extends JFrame {
	private JPanel pnlContent;
	/**
	 * Create the frame.
	 */
	public frmMain() {
		setResizable(false);
		setTitle("FysioSysteem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1092, 696);
		getContentPane().setLayout(null);
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(new Color(204, 0, 0));
		pnlMenu.setBounds(0, 0, 200, 674);
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
		
		JButton btnFysiotherapeuten = new JButton("Fysiotherapeuten");
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
				Injector injector = Guice.createInjector(new AppInjector());
				injector.getInstance(frmLogin.class).setVisible(true);
			}
		});
		btnUitloggen.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnUitloggen = new GridBagConstraints();
		gbc_btnUitloggen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUitloggen.gridx = 0;
		gbc_btnUitloggen.gridy = 5;
		pnlMenu.add(btnUitloggen, gbc_btnUitloggen);
		
		Injector injector = Guice.createInjector(new AppInjector());

		pnlContent = new JPanel();
		pnlContent.setBounds(200, 0, 876, 656);
	
		getContentPane().add(pnlContent);

		
		btnAfspraken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(new pnlAfspOvz());
			}
		});
		
		btnFysiotherapeuten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(new pnlFysOvz());
			}
		});
		
		btnBehandelingen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(new pnlBhdlOvz());
			}
		});
		
		btnPraktijk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(injector.getInstance(pnlPraGeg.class));
			}
		});
	}
	
	public void setPanel(JPanel panel){
		pnlContent.removeAll();
		panel.setBounds(0, 0, 876, 656);
		pnlContent.add(panel);
		pnlContent.repaint();
	}
}