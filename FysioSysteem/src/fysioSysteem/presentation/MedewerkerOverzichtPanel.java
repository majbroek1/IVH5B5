/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fysioSysteem.presentation;

import com.google.inject.Inject;
import fysioSysteem.businessLogic.beheer.IMedewerkerManager;
import fysioSysteem.domain.Fysiotherapeut;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bob
 */
public class MedewerkerOverzichtPanel extends javax.swing.JPanel {

    private IMedewerkerManager medewerkerManager;

    private ArrayList<Fysiotherapeut> fysiotherapeuten;

    /**
     * Creates new form MedewerkerOverzichtPanel
     */
    @Inject
    public MedewerkerOverzichtPanel(IMedewerkerManager medewerkerManager) {
        this.medewerkerManager = medewerkerManager;

        fysiotherapeuten = medewerkerManager.getFysiotherapeuten();

        initComponents();
        laadData();
    }

    private void laadData() {
        DefaultTableModel medewerkerModel = new DefaultTableModel(
                new Object[]{"MedewerkerID", "Naam", "Praktijk", "Status"}, 0
        ) {

            // Tabel Bewerken uit
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Fysiotherapeut f : fysiotherapeuten) {
            medewerkerModel.addRow(new Object[]{
                f.getId(), f.getNaam(),
                f.getPraktijk().getNaam(), f.getStatus()
            });
        }

        tblMedewerkers.setModel(medewerkerModel);
    }

    private JFrame getParentFrame() {
        return (JFrame) SwingUtilities.getRoot(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedewerkers = new javax.swing.JTable();
        btnToevoegen = new javax.swing.JButton();
        btnWijzigen = new javax.swing.JButton();
        btnRooster = new javax.swing.JButton();

        tblMedewerkers.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMedewerkers);

        btnToevoegen.setText("Medewerker Toevoegen");
        btnToevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToevoegenActionPerformed(evt);
            }
        });

        btnWijzigen.setText("Medewerker Wijzigen");
        btnWijzigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWijzigenActionPerformed(evt);
            }
        });

        btnRooster.setText("Bekijk rooster");
        btnRooster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoosterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRooster)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnWijzigen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnToevoegen)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnToevoegen)
                    .addComponent(btnWijzigen)
                    .addComponent(btnRooster))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToevoegenActionPerformed
        HoofdVenster parent = (HoofdVenster) getParentFrame();
        parent.setPanel(new MedewerkerEditPanel());
    }//GEN-LAST:event_btnToevoegenActionPerformed

    private void btnWijzigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWijzigenActionPerformed
        try {
            Fysiotherapeut t = fysiotherapeuten.get(
                    tblMedewerkers.convertRowIndexToModel(tblMedewerkers.getSelectedRow()));

            HoofdVenster parent = (HoofdVenster) getParentFrame();
            parent.setPanel(new MedewerkerEditPanel(t));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Selecteer een rij, alstublieft.");
        }
    }//GEN-LAST:event_btnWijzigenActionPerformed

    private void btnRoosterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoosterActionPerformed
        try {
            Fysiotherapeut t = fysiotherapeuten.get(
                    tblMedewerkers.convertRowIndexToModel(tblMedewerkers.getSelectedRow()));

            HoofdVenster parent = (HoofdVenster) getParentFrame();
            parent.setPanel(new RoosterOverzichtPanel(t));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Selecteer een rij, alstublieft.");
        }
    }//GEN-LAST:event_btnRoosterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRooster;
    private javax.swing.JButton btnToevoegen;
    private javax.swing.JButton btnWijzigen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMedewerkers;
    // End of variables declaration//GEN-END:variables
}
