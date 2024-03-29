/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fysioSysteem.presentation;

import com.google.inject.Inject;

import fysioSysteem.businessLogic.behandeling.IBehandelCodeManager;
import fysioSysteem.domain.BehandelCode;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bob
 */
public class BehandelCodeOverzichtPanel extends javax.swing.JPanel {

    private IBehandelCodeManager behandelcodeManager;

    private ArrayList<BehandelCode> behandelcodes;

    /**
     * Creates new form BehandelCodeOverzichtPanel -commit!!
     */
    @Inject
    public BehandelCodeOverzichtPanel(IBehandelCodeManager behandelcodeManager) {
        this.behandelcodeManager = behandelcodeManager;

        behandelcodes = behandelcodeManager.getBehandelCodes();

        initComponents();
        laadData();
    }

    private void laadData() {
        DefaultTableModel behandelcodeModel = new DefaultTableModel(
                new Object[]{"Code", "Behandelingnaam", "Aantal Sessies", "Sessieduur", "Tarief"}, 0
        );

        for (BehandelCode b : behandelcodes) {
            behandelcodeModel.addRow(new Object[]{
                b.getCode(), b.getBehandelingNaam(), b.getAantalSessies(),
                b.getSessieDuur(), b.getTariefBehandeling()
            });
        }

        tblBehandelCodes.setModel(behandelcodeModel);

    }

    private JFrame getParentFrame() {
        return (JFrame) SwingUtilities.getRoot(this);
    }

    /**
     * Creates new form BehandelCodeEditPanel
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBehandelCodes = new javax.swing.JTable();
        btnWijzigen = new javax.swing.JButton();
        btnToevoegen = new javax.swing.JButton();

        tblBehandelCodes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblBehandelCodes);

        btnWijzigen.setText("Behandecode wijzigen");
        btnWijzigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWijzigenActionPerformed(evt);
            }
        });

        btnToevoegen.setText("Behandelcode Toevoegen");
        btnToevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToevoegenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnWijzigen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnToevoegen)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnToevoegen)
                    .addComponent(btnWijzigen))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnWijzigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWijzigenActionPerformed
        try {
            BehandelCode b = behandelcodes.get(
                    tblBehandelCodes.convertRowIndexToModel(tblBehandelCodes.getSelectedRow()));

            HoofdVenster parent = (HoofdVenster) getParentFrame();
            parent.setPanel(new BehandelCodeEditPanel(b));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Selecteer een rij, alstublieft.");
        }
    }//GEN-LAST:event_btnWijzigenActionPerformed

    private void btnToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToevoegenActionPerformed
        // Code toevoegen
        HoofdVenster parent = (HoofdVenster) getParentFrame();
        parent.setPanel(new BehandelCodeEditPanel());
    }//GEN-LAST:event_btnToevoegenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnToevoegen;
    private javax.swing.JButton btnWijzigen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBehandelCodes;
    // End of variables declaration//GEN-END:variables
}
