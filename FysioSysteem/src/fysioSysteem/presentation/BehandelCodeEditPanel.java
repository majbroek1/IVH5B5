/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fysioSysteem.presentation;

import com.google.inject.Guice;
import com.google.inject.Injector;

import fysioSysteem.businessLogic.behandeling.IBehandelCodeManager;
import fysioSysteem.domain.BehandelCode;
import general.AppInjector;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 *
 * @author Bob
 */
public class BehandelCodeEditPanel extends javax.swing.JPanel {

    private IBehandelCodeManager behandelCodeManager;

    private BehandelCode behandelCode = null;

    /**
     * Creates new form BehandelCodeEditPanel
     */
    public BehandelCodeEditPanel() {
        Injector injector = Guice.createInjector(new AppInjector());
        behandelCodeManager = injector.getInstance(IBehandelCodeManager.class);

        initComponents();
    }

    public BehandelCodeEditPanel(BehandelCode bc) {
        Injector injector = Guice.createInjector(new AppInjector());
        behandelCodeManager = injector.getInstance(IBehandelCodeManager.class);

        behandelCode = behandelCodeManager.getBehandelCode(bc.getCode());

        initComponents();
        laadData();
    }

    private void laadData() {
        txtCode.setText(Integer.toString(behandelCode.getCode()));
        txtNaam.setText(behandelCode.getBehandelingNaam());
        txtTarief.setText(Double.toString(behandelCode.getTariefBehandeling()));

        spnAantalSessies.setValue(behandelCode.getAantalSessies());
        spnDuratieSessie.setValue(behandelCode.getSessieDuur());
    }

    private boolean controleerVelden() {
        ArrayList<String> errorMessages = new ArrayList<>();
        Border redBorder = BorderFactory.createLineBorder(Color.red);

        if (txtCode.getText().isEmpty()
                || txtCode.getText().length() >= 15) {

            txtCode.setBorder(redBorder);
            errorMessages.add("- Codeveld");
        }

        if (txtNaam.getText().isEmpty()) {
            txtNaam.setBorder(redBorder);
            errorMessages.add("- Naamveld");
        }

        if ((int) spnAantalSessies.getValue() < 1) {
            spnAantalSessies.setBorder(redBorder);
            errorMessages.add("- Aantal Sessies");
        }

        if ((int) spnDuratieSessie.getValue() < 1) {
            spnDuratieSessie.setBorder(redBorder);
            errorMessages.add("- Aantal Sessies");
        }

        if (txtTarief.getText().isEmpty()) {
            txtTarief.setBorder(redBorder);
            errorMessages.add("- Tarief");
        }

        if (errorMessages.size() > 0) {
            int sizeStringBuilder = errorMessages.size() + 1;
            StringBuilder builder = new StringBuilder(sizeStringBuilder);
            builder.append("Controleer de volgende velden:" + "\n");

            for (String s : errorMessages) {
                builder.append(s + "\n");
            }

            JOptionPane.showMessageDialog(this, builder.toString(),
                    "Controleer gegevens", JOptionPane.WARNING_MESSAGE);
        }

        return errorMessages.size() < 1;
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

        jLabel1 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNaam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        spnAantalSessies = new javax.swing.JSpinner();
        spnDuratieSessie = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnOpslaan = new javax.swing.JButton();
        btnAnnuleren = new javax.swing.JButton();
        txtTarief = new javax.swing.JTextField();

        jLabel1.setText("Behandelcode");

        jLabel2.setText("Behandelingnaam");

        jLabel3.setText("Aantal sessies");

        jLabel4.setText("Duratie sessie");

        jLabel5.setText("Tarief");

        btnOpslaan.setText("Opslaan");
        btnOpslaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpslaanActionPerformed(evt);
            }
        });

        btnAnnuleren.setText("Annuleren");
        btnAnnuleren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTarief)
                    .addComponent(txtCode)
                    .addComponent(txtNaam)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAnnuleren)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOpslaan))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnAantalSessies, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(spnDuratieSessie, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnAantalSessies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnDuratieSessie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTarief, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpslaan)
                    .addComponent(btnAnnuleren))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnnulerenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerenActionPerformed
        HoofdVenster parent = (HoofdVenster) getParentFrame();
        Injector injector = Guice.createInjector(new AppInjector());
        parent.setPanel(injector.getInstance(BehandelCodeOverzichtPanel.class));
    }//GEN-LAST:event_btnAnnulerenActionPerformed

    private void btnOpslaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpslaanActionPerformed
        if (controleerVelden()) {
            if (behandelCode != null) {
                behandelCode.setCode(Integer.parseInt(txtCode.getText()));
                behandelCode.setBehandelingNaam(txtNaam.getText());
                behandelCode.setAantalSessies((int) spnAantalSessies.getValue());
                behandelCode.setSessieDuur((int) spnDuratieSessie.getValue());
                behandelCode.setTariefBehandeling(Double.parseDouble(txtTarief.getText()));

                behandelCodeManager.setBehandelCode(behandelCode);

                JOptionPane.showMessageDialog(this, "De behandelcode is succesvol opgeslagen.");
            } else {
                BehandelCode bc = new BehandelCode(
                        Integer.parseInt(txtCode.getText()),
                        (int) spnAantalSessies.getValue(),
                        txtNaam.getText(),
                        (int) spnDuratieSessie.getValue(),
                        Double.parseDouble(txtTarief.getText())
                );

                behandelCodeManager.addBehandelCode(bc);

                JOptionPane.showMessageDialog(this, "De behandelcode is succesvol opgeslagen.");

                HoofdVenster parent = (HoofdVenster) getParentFrame();
                Injector injector = Guice.createInjector(new AppInjector());
                parent.setPanel(injector.getInstance(BehandelCodeOverzichtPanel.class));
            }
        }
    }//GEN-LAST:event_btnOpslaanActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnnuleren;
    private javax.swing.JButton btnOpslaan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSpinner spnAantalSessies;
    private javax.swing.JSpinner spnDuratieSessie;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtNaam;
    private javax.swing.JTextField txtTarief;
    // End of variables declaration//GEN-END:variables
}
