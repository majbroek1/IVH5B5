package fysioSysteem.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import com.google.inject.Guice;
import com.google.inject.Injector;

import fysioSysteem.dataStorage.MedewerkerDAO;
import fysioSysteem.domain.Fysiotherapeut;
import general.AppInjector;

public class pnlFysOvz extends JPanel {
	private JButton btnFysioToevoegen;
	private JTable table;
	
	public pnlFysOvz() {
		setLayout(null);

		ArrayList<Fysiotherapeut> therapeuten = MedewerkerDAO.getFysiotherapeuten();

		// Create a table with 10 rows and 5 columns
		Object rijData[][] = new Object[therapeuten.size()][4];
		for (int i = 0; i < therapeuten.size(); i++) {
			Fysiotherapeut therapeut = therapeuten.get(i);
			rijData[i][0] = therapeut.getId();
			rijData[i][1] = therapeut.getNaam();
			rijData[i][2] = therapeut.getPraktijk().getNaam();
			rijData[i][3] = therapeut.getStatus();
		}

		Object kolomNamen[] = { "Id", "Naam", "Praktijk", "Status" };

		table = new JTable(rijData, kolomNamen);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 867, 590);
		add(scrollPane);

		renderControls();
	}

	public void renderControls() {
		btnFysioToevoegen = new JButton("Toevoegen");
		btnFysioToevoegen.setBounds(107, 620, 172, 29);
		
		add(btnFysioToevoegen);

		JButton btnFysioAanpassen = new JButton("Aanpassen");
		btnFysioAanpassen.setBounds(358, 620, 172, 29);
		add(btnFysioAanpassen);

		JButton btnFysioVerwijderen = new JButton("Verwijderen");
		btnFysioVerwijderen.setBounds(614, 620, 172, 29);
		add(btnFysioVerwijderen);
		
		btnFysioToevoegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMain parent = (frmMain)getParentFrame();
				parent.setPanel(new pnlFysToeWzg());
			}
		});
		
		btnFysioAanpassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMain parent = (frmMain)getParentFrame();
				int medewerkerId = (int)table.getValueAt(table.getSelectedRow(), 0); 
				parent.setPanel(new pnlFysToeWzg(medewerkerId));
			}
		});
	}
	
	private JFrame getParentFrame(){
		return (JFrame)SwingUtilities.getRoot(this);
	}
}
