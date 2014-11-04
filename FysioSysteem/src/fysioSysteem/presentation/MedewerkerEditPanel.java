/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fysioSysteem.presentation;

import com.google.inject.Guice;
import com.google.inject.Injector;
import fysioSysteem.businessLogic.beheer.IMedewerkerManager;
import fysioSysteem.businessLogic.beheer.IPraktijkManager;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Praktijk;
import fysioSysteem.domain.Status;
import general.AppInjector;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 *
 * @author Bob
 */
public class MedewerkerEditPanel extends javax.swing.JPanel {
    
    private IMedewerkerManager medewerkerManager;
    private IPraktijkManager praktijkManager;
    
    private Fysiotherapeut therapeut;

    /**
     * Creates new form MedewerkerEditPanel
     */
    public MedewerkerEditPanel() {
        Injector injector = Guice.createInjector(new AppInjector());
        medewerkerManager = injector.getInstance(IMedewerkerManager.class);
        praktijkManager = injector.getInstance(IPraktijkManager.class);
        
        initComponents();
        laadData();
    }
    
    public MedewerkerEditPanel(Fysiotherapeut f) {
        Injector injector = Guice.createInjector(new AppInjector());
        medewerkerManager = injector.getInstance(IMedewerkerManager.class);
        praktijkManager = injector.getInstance(IPraktijkManager.class);
        
        therapeut = f;
        
        initComponents();
        laadData();
    }
    
    private void laadData() {
        ArrayList<Praktijk> praktijken
                = praktijkManager.getPraktijken();
        
        DefaultComboBoxModel<Praktijk> praktijkModel
                = new DefaultComboBoxModel<>();
        
        Praktijk selPraktijk = null;
        for (Praktijk p : praktijken) {
            praktijkModel.addElement(p);

            if (therapeut != null) {
                if (p.getId() == therapeut.getPraktijk().getId()) {
                    selPraktijk = p;
                }
            }
        }
        
        if (therapeut != null) {
            txtNaam.setText(therapeut.getNaam());
            txtWachtwoord.setText(therapeut.getWachtwoord());
            txtWachtwoordHer.setText(therapeut.getWachtwoord());
            
            if (selPraktijk != null) {
                cbPraktijk.setSelectedItem(selPraktijk);
            }
        }

        cbPraktijk.setModel(praktijkModel);
        cbStatus.setModel(new DefaultComboBoxModel(Status.values()));
        cbStatus.getModel().setSelectedItem(therapeut.getStatus());
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
        txtWachtwoord = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox();
        btnAnnuleren = new javax.swing.JButton();
        btnOpslaan = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbPraktijk = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtWachtwoordHer = new javax.swing.JPasswordField();

        jLabel1.setText("Naam");

        jLabel2.setText("Wachtwoord");

        jLabel3.setText("Status");

        btnAnnuleren.setText("Annuleren");
        btnAnnuleren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerenActionPerformed(evt);
            }
        });

        btnOpslaan.setText("Opslaan");
        btnOpslaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpslaanActionPerformed(evt);
            }
        });

        jLabel4.setText("Praktijk");

        jLabel5.setText("Wachtwoord herhalen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNaam)
                    .addComponent(cbPraktijk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnnuleren)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOpslaan))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(103, 103, 103)
                                .addComponent(jLabel5)))
                        .addGap(0, 50, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtWachtwoord, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtWachtwoordHer)))
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
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWachtwoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWachtwoordHer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPraktijk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnnuleren)
                    .addComponent(btnOpslaan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnnulerenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerenActionPerformed
        HoofdVenster parent = (HoofdVenster) getParentFrame();
        Injector injector = Guice.createInjector(new AppInjector());
        parent.setPanel(injector.getInstance(MedewerkerOverzichtPanel.class));
    }//GEN-LAST:event_btnAnnulerenActionPerformed

    private void btnOpslaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpslaanActionPerformed
        ArrayList<String> errorMessages = new ArrayList<String>();
        Border redBorder = BorderFactory.createLineBorder(Color.red);

        if (txtNaam.getText().equals("")
                || txtNaam.getText().length() >= 50) {
            
            txtNaam.setBorder(redBorder);
            errorMessages.add("- Therapeut Naam");
        }

        if (txtWachtwoord.getPassword().length < 4
                || txtWachtwoord.getPassword().length >= 50) {

            txtWachtwoord.setBorder(redBorder);
            errorMessages.add("- Wachtwoord");
        }

        if (!Arrays.equals(txtWachtwoord.getPassword(),
                txtWachtwoordHer.getPassword())) {

            txtWachtwoordHer.setBorder(redBorder);
            errorMessages.add("- Wachtwoord Herhalen");
        }

        if (errorMessages.size() < 1) {
            String password = "";
            for (char c : txtWachtwoord.getPassword()) {
                password += c;
            }

            if (therapeut != null) {
                Fysiotherapeut Fysiotherapeut = new Fysiotherapeut(therapeut.getId(), txtNaam.getText(), password,
                        Status.valueOf(cbStatus.getSelectedItem().toString()), (Praktijk) cbPraktijk.getSelectedItem());

                medewerkerManager.setMedewerker(Fysiotherapeut);
            } else {
                Fysiotherapeut Fysiotherapeut = new Fysiotherapeut(txtNaam.getText(), password,
                        Status.valueOf(cbStatus.getSelectedItem().toString()), (Praktijk) cbPraktijk.getSelectedItem());

                medewerkerManager.addMedewerker(Fysiotherapeut);
            }

            JOptionPane.showMessageDialog(this, "De fysiotherapeut gegevens zijn succesvol opgeslagen.");

            HoofdVenster parent = (HoofdVenster) getParentFrame();
            Injector injector = Guice.createInjector(new AppInjector());
            parent.setPanel(injector.getInstance(MedewerkerOverzichtPanel.class));
        } else {
            int sizeStringBuilder = errorMessages.size() + 1;
            StringBuilder builder = new StringBuilder(sizeStringBuilder);
            builder.append("Controleer de volgende velden op volledigheid en correctheid:" + "\n");

            for (String s : errorMessages) {
                builder.append(s + "\n");
            }

            JOptionPane.showMessageDialog(null, builder.toString());
        }
    }//GEN-LAST:event_btnOpslaanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnnuleren;
    private javax.swing.JButton btnOpslaan;
    private javax.swing.JComboBox cbPraktijk;
    private javax.swing.JComboBox cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtNaam;
    private javax.swing.JPasswordField txtWachtwoord;
    private javax.swing.JPasswordField txtWachtwoordHer;
    // End of variables declaration//GEN-END:variables
}
