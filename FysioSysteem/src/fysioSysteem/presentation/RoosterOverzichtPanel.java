/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fysioSysteem.presentation;

import fysioSysteem.businessLogic.beheer.IMedewerkerManager;
import fysioSysteem.businessLogic.planning.IRoosterManager;
import fysioSysteem.businessLogic.planning.RoosterManager;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Rooster;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorick
 */
public class RoosterOverzichtPanel extends javax.swing.JPanel {

    private ArrayList<Rooster> roosters;
    private IMedewerkerManager medewerkerManager;
    private Fysiotherapeut fysio;

    /**
     * Creates new form RoosterOverzichtPanel
     *
     * @param f
     */
    public RoosterOverzichtPanel(Fysiotherapeut f, IMedewerkerManager medewerkerManager) {
        IRoosterManager rm = new RoosterManager();
        this.medewerkerManager = medewerkerManager;
        roosters = rm.getWeekRooster(f);
        this.fysio = f;
        initComponents();
        vulVelden();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollTable = new javax.swing.JScrollPane();
        roosterTable = new javax.swing.JTable();
        terugButton = new javax.swing.JButton();
        bewerkButton = new javax.swing.JButton();
        nieuwButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(638, 465));

        roosterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Start", "Eind"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roosterTable.getTableHeader().setReorderingAllowed(false);
        scrollTable.setViewportView(roosterTable);

        terugButton.setText("Terug");
        terugButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terugButtonActionPerformed(evt);
            }
        });

        bewerkButton.setText("Bewerken");
        bewerkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bewerkButtonActionPerformed(evt);
            }
        });

        nieuwButton.setText("Nieuw");
        nieuwButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nieuwButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nieuwButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bewerkButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(terugButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bewerkButton)
                    .addComponent(nieuwButton)
                    .addComponent(terugButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void terugButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terugButtonActionPerformed
        HoofdVenster parent = (HoofdVenster) getParentFrame();
        parent.setPanel(new MedewerkerOverzichtPanel(medewerkerManager));
    }//GEN-LAST:event_terugButtonActionPerformed

    private void bewerkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bewerkButtonActionPerformed
        try {
            Rooster r = roosters.get(
                    roosterTable.convertRowIndexToModel(
                            roosterTable.getSelectedRow()));

            HoofdVenster parent = (HoofdVenster) getParentFrame();
            parent.setPanel(new RoosterEditPanel(r, medewerkerManager));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Selecteer een rij, alstublieft.");
        }
    }//GEN-LAST:event_bewerkButtonActionPerformed

    private void nieuwButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nieuwButtonActionPerformed
        HoofdVenster parent = (HoofdVenster) getParentFrame();
        parent.setPanel(new RoosterToevoegenPanel(fysio, medewerkerManager));
    }//GEN-LAST:event_nieuwButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bewerkButton;
    private javax.swing.JButton nieuwButton;
    private javax.swing.JTable roosterTable;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JButton terugButton;
    // End of variables declaration//GEN-END:variables

    private void vulVelden() {
        DefaultTableModel mdl = new DefaultTableModel(
                new Object[]{"Start", "Eind"}, 0) {

                    // Tabel Bewerken uit
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM HH:mm");

        for (Rooster r : roosters) {
            mdl.addRow(new Object[]{
                dateFormat.format(r.getStart()),
                dateFormat.format(r.getEind())
            });
        }
        roosterTable.setModel(mdl);
    }

    private JFrame getParentFrame() {
        return (JFrame) SwingUtilities.getRoot(this);
    }

}
