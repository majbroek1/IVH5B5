/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fysioSysteem.presentation;

import fysioSysteem.businessLogic.beheer.IMedewerkerManager;
import fysioSysteem.businessLogic.planning.IRoosterManager;
import fysioSysteem.businessLogic.planning.RoosterManager;
import fysioSysteem.dataStorage.RoosterDAO;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Rooster;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jorick
 */
public class RoosterEditPanel extends javax.swing.JPanel {

    private Rooster rooster;
    private IMedewerkerManager medewerkerManager;
    private IRoosterManager rm;

    /**
     * Creates new form RoosterWijzigPanel
     *
     * @param r
     * @param manager
     */
    public RoosterEditPanel(Rooster r, IMedewerkerManager manager) {
        rm = new RoosterManager();
        this.medewerkerManager = manager;
        this.rooster = r;
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

        startDateField = new javax.swing.JTextField();
        startTimeField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        endDateField = new javax.swing.JTextField();
        endTimeField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        terugButton = new javax.swing.JButton();

        jLabel2.setText("Begin");

        jLabel3.setText("Eind");

        saveButton.setText("Opslaan");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        terugButton.setText("Terug");
        terugButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terugButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 468, Short.MAX_VALUE)
                        .addComponent(terugButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(startDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                    .addComponent(endDateField))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(startTimeField, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                    .addComponent(endTimeField))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(terugButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void terugButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terugButtonActionPerformed
        HoofdVenster parent = (HoofdVenster) getParentFrame();
        parent.setPanel(new RoosterOverzichtPanel(rooster.getFysiotherapeut(), medewerkerManager));
    }//GEN-LAST:event_terugButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (validateVelden()) {
            String start = startDateField.getText() + startTimeField.getText() + ":00";
            String eind = endDateField.getText() + endTimeField.getText() + ":00";
            try {
                Date startDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(start);
                Date endDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(eind);

                rooster.setEind(endDate);
                rooster.setStart(startDate);
                
                rm.setRooster(rooster);
            } catch (ParseException ex) {
                System.out.println("Kan datum niet parsen");
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField endDateField;
    private javax.swing.JTextField endTimeField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField startDateField;
    private javax.swing.JTextField startTimeField;
    private javax.swing.JButton terugButton;
    // End of variables declaration//GEN-END:variables

    private void vulVelden() {
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm");

        startDateField.setText(date.format(rooster.getStart()));
        startTimeField.setText(time.format(rooster.getStart()));
        endDateField.setText(date.format(rooster.getEind()));
        endTimeField.setText(time.format(rooster.getEind()));
    }

    private boolean validateVelden() {
        return PanelValidatie.valideerDatum(startDateField.getText())
                && PanelValidatie.valideerTijd(startTimeField.getText())
                && PanelValidatie.valideerDatum(endDateField.getText())
                && PanelValidatie.valideerTijd(endTimeField.getText());
    }

    private JFrame getParentFrame() {
        return (JFrame) SwingUtilities.getRoot(this);
    }
}
