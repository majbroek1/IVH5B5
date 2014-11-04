/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fysioSysteem.presentation;

import com.google.inject.Guice;
import com.google.inject.Injector;
import fysioSysteem.businessLogic.planning.AfspraakManager;
import fysioSysteem.businessLogic.planning.IAfspraakManager;
import fysioSysteem.domain.Afspraak;
import general.AppInjector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pascal
 */
public class AfsprakenOverzichtPanel extends javax.swing.JPanel {

    private ArrayList<Afspraak> afspraken;
    private AfspraakManager afspraakManager;
    /**
     * Creates new form AfsprakenOverzichtPanel
     */
    public AfsprakenOverzichtPanel() {
        //Injector injector = Guice.createInjector(new AppInjector());
        this.afspraakManager = new AfspraakManager(); //injector.getInstance(IAfspraakManager.class);
        
        initComponents();
        
        try
        {
            afspraken = afspraakManager.getAfspraken();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Afspraken ophalen is mislukt.");
        }
        setTable();
    }

    private void setTable() {
        DefaultTableModel tabelModel = new DefaultTableModel(
                new Object[]{"Afspraak #", "Patient", "Datum", "Tijd", "Behandeling"}, 0) {

                    // Tabel Bewerken uit
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date today = new Date();

        try {
            for (Afspraak a : afspraken) {
                if (dateFormat.format(a.getDatumTijd()).equals(dateFormat.format(today)) || today.before(a.getDatumTijd())) {
                    tabelModel.addRow(new Object[]{
                        a.getId(),
                        a.getBehandeling().getKlant().getNaam(),
                        dateFormat.format(a.getDatumTijd()),
                        timeFormat.format(a.getDatumTijd()),
                        a.getBehandeling().getBehandelCode().getBehandelingNaam()
                    });
                }
            }
        } catch (Exception e) {

        }
        jTable1.setModel(tabelModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonAfspraakToevoegen = new javax.swing.JButton();
        buttonAfspraakVerwijderen = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(638, 436));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        buttonAfspraakToevoegen.setText("Afspraak Toevoegen");
        buttonAfspraakToevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAfspraakToevoegenActionPerformed(evt);
            }
        });

        buttonAfspraakVerwijderen.setText("Afspraak Verwijderen");
        buttonAfspraakVerwijderen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAfspraakVerwijderenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAfspraakToevoegen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonAfspraakVerwijderen)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAfspraakToevoegen)
                    .addComponent(buttonAfspraakVerwijderen))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAfspraakToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAfspraakToevoegenActionPerformed
        HoofdVenster parent = (HoofdVenster) getParentFrame();
        parent.setPanel(new AfsprakenToevoegenPanel());
    }//GEN-LAST:event_buttonAfspraakToevoegenActionPerformed

    private void buttonAfspraakVerwijderenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAfspraakVerwijderenActionPerformed
        try {
            Afspraak a = afspraken.get(jTable1.convertRowIndexToModel(jTable1.getSelectedRow()));

            Object[] options = {"nee", "Ja"};

            JFrame frame = new JFrame();

            int n = JOptionPane.showOptionDialog(frame,
                    "Weet je zeker dat u afspraak: " + a.getId() + "  wilt verwijderd?",
                    "Verwijder afspraak: " + a.getId(),
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
 
                if (n == 1)
                {
                   afspraakManager.removeAfspraak(a);
                
                   HoofdVenster parent = (HoofdVenster)getParentFrame();
                   parent.setPanel(new AfsprakenOverzichtPanel());
                }
	}
	catch (Exception ex) {
		JOptionPane.showMessageDialog(null, "Selecteer een rij, alstublieft.");
	}
    }//GEN-LAST:event_buttonAfspraakVerwijderenActionPerformed

    private JFrame getParentFrame() {
        return (JFrame) SwingUtilities.getRoot(this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAfspraakToevoegen;
    private javax.swing.JButton buttonAfspraakVerwijderen;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
