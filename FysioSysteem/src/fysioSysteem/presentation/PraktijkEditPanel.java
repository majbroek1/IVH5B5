/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fysioSysteem.presentation;

import com.google.inject.Guice;
import com.google.inject.Injector;
import fysioSysteem.businessLogic.beheer.IPraktijkManager;
import fysioSysteem.domain.Praktijk;
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
public class PraktijkEditPanel extends javax.swing.JPanel {

    private IPraktijkManager praktijkManager;

    private Praktijk praktijk;

    /**
     * Creates new form PraktijkEditPanel
     */
    public PraktijkEditPanel() {
        Injector injector = Guice.createInjector(new AppInjector());
        praktijkManager = injector.getInstance(IPraktijkManager.class);

        praktijk = praktijkManager.getPraktijk(1);

        initComponents();
        laadData();
    }

    private void laadData() {
        txtNaam.setText(praktijk.getNaam());
        txtAdres.setText(praktijk.getAdres());
        txtPostcode.setText(praktijk.getPostcode());
        txtPlaats.setText(praktijk.getPlaats());
        txtIban.setText(praktijk.getIban());
        txtTelefoon.setText(praktijk.getTelNr());
        txtEmail.setText(praktijk.getEmail());
        txtWebsite.setText(praktijk.getWebsite());
    }

    private boolean controleerVelden() {
        ArrayList<String> errorMessages = new ArrayList<>();
        Border redBorder = BorderFactory.createLineBorder(Color.red);

        if (txtNaam.getText().isEmpty()) {
            txtNaam.setBorder(redBorder);
            errorMessages.add("- Naam");
        }

        if (txtAdres.getText().isEmpty()) {
            txtAdres.setBorder(redBorder);
            errorMessages.add("- Adres");
        }

        if (txtPostcode.getText().isEmpty()
                && PanelValidatie.valideerPostcode(txtPostcode.getText())) {
            txtPostcode.setBorder(redBorder);
            errorMessages.add("- Postcode");
        }

        if (txtPlaats.getText().isEmpty()) {
            txtPlaats.setBorder(redBorder);
            errorMessages.add("- Plaats");
        }

        if (txtIban.getText().isEmpty()) {
            txtIban.setBorder(redBorder);
            errorMessages.add("- IBAN");
        }

        if (txtTelefoon.getText().isEmpty()) {
            txtTelefoon.setBorder(redBorder);
            errorMessages.add("- Telefoon");
        }

        if (txtEmail.getText().isEmpty()) {
            if (!PanelValidatie.valideerEmail(txtEmail.getText())) {
                txtEmail.setBorder(redBorder);
                errorMessages.add("- Email");
            }
        }
        
        if (txtWebsite.getText().isEmpty()) {
            txtWebsite.setBorder(redBorder);
            errorMessages.add("- Website");
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
        txtNaam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAdres = new javax.swing.JTextField();
        txtPostcode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPlaats = new javax.swing.JTextField();
        txtIban = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTelefoon = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtWebsite = new javax.swing.JTextField();
        btnOpslaan = new javax.swing.JButton();

        jLabel1.setText("Praktijknaam");

        jLabel2.setText("Adres");

        jLabel3.setText("Postcode");

        jLabel4.setText("Plaats");

        jLabel5.setText("IBAN");

        jLabel6.setText("Telefoon");

        jLabel7.setText("E-mail");

        jLabel8.setText("Website");

        btnOpslaan.setText("Opslaan");
        btnOpslaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpslaanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIban)
                    .addComponent(txtNaam)
                    .addComponent(txtTelefoon)
                    .addComponent(txtEmail)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAdres, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtPostcode, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPlaats, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtWebsite)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOpslaan)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlaats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefoon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtWebsite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOpslaan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpslaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpslaanActionPerformed
        if (controleerVelden()) {
            praktijk.setNaam(txtNaam.getText());
            praktijk.setAdres(txtAdres.getText());
            praktijk.setPostcode(txtPostcode.getText());
            praktijk.setPlaats(txtPlaats.getText());
            praktijk.setIban(txtIban.getText());
            praktijk.setTelNr(txtTelefoon.getText());
            praktijk.setEmail(txtEmail.getText());
            praktijk.setWebsite(txtWebsite.getText());

            praktijkManager.setPraktijk(praktijk);

            JOptionPane.showMessageDialog(this,
                    "Opslaan van praktijk is succesvol", "Opslaan praktijk", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnOpslaanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOpslaan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtAdres;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIban;
    private javax.swing.JTextField txtNaam;
    private javax.swing.JTextField txtPlaats;
    private javax.swing.JTextField txtPostcode;
    private javax.swing.JTextField txtTelefoon;
    private javax.swing.JTextField txtWebsite;
    // End of variables declaration//GEN-END:variables
}
