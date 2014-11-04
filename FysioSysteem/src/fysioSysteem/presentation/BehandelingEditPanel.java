/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fysioSysteem.presentation;

import com.google.inject.Guice;
import com.google.inject.Injector;
import fysioSysteem.businessLogic.behandeling.IBehandelCodeManager;
import fysioSysteem.businessLogic.behandeling.IBehandelingManager;
import fysioSysteem.businessLogic.behandeling.IKlantManager;
import fysioSysteem.dataStorage.BehandelCodeDAO;
import fysioSysteem.dataStorage.KlantDAO;
import fysioSysteem.domain.BehandelCode;
import fysioSysteem.domain.BehandelStatus;
import fysioSysteem.domain.Behandeling;
import fysioSysteem.domain.Klant;
import general.AppInjector;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 *
 * @author Bert
 */
public class BehandelingEditPanel extends javax.swing.JPanel {

    /**
     * Creates new form BehandelingEditPanle
     */
    private IBehandelingManager behandelingManager;
    private IBehandelCodeManager behandelCodeManager;
    private IKlantManager klantManager;
    private Behandeling behandeling;
    private Klant klant;
    private AfsprakenToevoegenPanel parentPanel;

    /**
     * Creates new form BehandelingEditPanel
     */
    public BehandelingEditPanel() {
        Injector injector = Guice.createInjector(new AppInjector());
        behandelingManager = injector.getInstance(IBehandelingManager.class);
        behandelCodeManager = injector.getInstance(IBehandelCodeManager.class);
        klantManager = injector.getInstance(IKlantManager.class);

        initComponents();
    }

    public BehandelingEditPanel(Behandeling behandeling) {
        Injector injector = Guice.createInjector(new AppInjector());
        behandelingManager = injector.getInstance(IBehandelingManager.class);
        behandelCodeManager = injector.getInstance(IBehandelCodeManager.class);
        klantManager = injector.getInstance(IKlantManager.class);

        this.behandeling = behandeling;
        this.klant = behandeling.getKlant();

        initComponents();
        laadData();
    }

    public BehandelingEditPanel(Klant klant, AfsprakenToevoegenPanel parentPanel) {
        Injector injector = Guice.createInjector(new AppInjector());
        behandelingManager = injector.getInstance(IBehandelingManager.class);
        behandelCodeManager = injector.getInstance(IBehandelCodeManager.class);
        klantManager = injector.getInstance(IKlantManager.class);

        this.klant = klant;
        this.parentPanel = parentPanel;

        initComponents();
        laadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblKlantBSN = new javax.swing.JLabel();
        cmbbxKlantBSN = new javax.swing.JComboBox();
        lblBehandelCode = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        cmbbxStatus = new javax.swing.JComboBox();
        btnAnnuleren = new javax.swing.JButton();
        btnOpslaan = new javax.swing.JButton();
        cmbBehandelCode = new javax.swing.JComboBox();

        lblKlantBSN.setText("Klant BSN");

        cmbbxKlantBSN.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblBehandelCode.setText("BehandelCode");

        lblStatus.setText("Status");

        cmbbxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        cmbBehandelCode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbbxKlantBSN, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbbxStatus, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnnuleren)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOpslaan))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKlantBSN)
                            .addComponent(lblBehandelCode)
                            .addComponent(lblStatus))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cmbBehandelCode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKlantBSN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbbxKlantBSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblBehandelCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbBehandelCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnnuleren)
                    .addComponent(btnOpslaan))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnnulerenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerenActionPerformed
        JFrame parent = (JFrame) getParentFrame();
        parent.dispose();
    }//GEN-LAST:event_btnAnnulerenActionPerformed

    private void btnOpslaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpslaanActionPerformed
        JFrame frame = new JFrame();
        ArrayList<String> errorMessages = new ArrayList<String>();
        Border redBorder = BorderFactory.createLineBorder(Color.red);

        if (cmbBehandelCode.getSelectedItem().toString().equals("")) {
            cmbBehandelCode.setBorder(redBorder);
            errorMessages.add("- Behandelcode is incorrect");
        }

        if (cmbbxKlantBSN.getSelectedItem().toString() == "") {
            cmbbxKlantBSN.setBorder(redBorder);
            errorMessages.add("- Behandelcode is incorrect");
        }

        if (cmbbxStatus.getSelectedItem().toString() == "") {
            cmbbxStatus.setBorder(redBorder);
            errorMessages.add("- Status is incorrect");
        }

        if (errorMessages.size() < 1) {
            Klant klant = klantManager.getKlant(cmbbxKlantBSN.getSelectedItem().toString());

            if (behandeling != null) {
                Behandeling newBehandeling = new Behandeling(behandeling.getId(), BehandelStatus.valueOf(cmbbxStatus.getSelectedItem().toString()), klant, (BehandelCode) cmbBehandelCode.getSelectedItem());
                behandelingManager.setBehandeling(newBehandeling);
            } else {
                Behandeling newBehandeling = new Behandeling(BehandelStatus.valueOf(cmbbxStatus.getSelectedItem().toString()), (Klant) cmbbxKlantBSN.getSelectedItem(), (BehandelCode) cmbBehandelCode.getSelectedItem());
                behandelingManager.addBehandeling(newBehandeling);
            }

            revalidate();
            repaint();

            JOptionPane.showMessageDialog(frame, "De behandelinggegevens zijn succesvol opgeslagen.");
        } else {
            int sizeStringBuilder = errorMessages.size() + 1;
            StringBuilder builder = new StringBuilder(sizeStringBuilder);
            builder.append("Controleer de volgende velden op volledigheid en correctheid:" + "\n");

            for (String s : errorMessages) {
                builder.append(s + "\n");
            }

            JOptionPane.showMessageDialog(null, builder.toString());
        }
        parentPanel.laadBehandelingCombobox();

        JFrame parent = (JFrame) getParentFrame();
        parent.dispose();
    }//GEN-LAST:event_btnOpslaanActionPerformed

    private void laadData() {
        DefaultComboBoxModel<Klant> klantModel = new DefaultComboBoxModel<>();
        for (Klant k : KlantDAO.getKlanten()) {
            klantModel.addElement(k);
            if (klant != null && k.getBsn().equals(klant.getBsn())) {
                klantModel.setSelectedItem(k);
            }
        }
        cmbbxKlantBSN.setModel(klantModel);

        DefaultComboBoxModel<BehandelCode> codeModel = new DefaultComboBoxModel<>();
        for (BehandelCode bc : BehandelCodeDAO.getBehandelCodes()) {
            codeModel.addElement(bc);
            if (behandeling != null && behandeling.getBehandelCode().getCode() == bc.getCode()) {
                codeModel.setSelectedItem(bc);
            }
        }
        cmbBehandelCode.setModel(codeModel);

        DefaultComboBoxModel<BehandelStatus> statusModel = new DefaultComboBoxModel<>();
        for (BehandelStatus s : BehandelStatus.values()) {
            statusModel.addElement(s);
            if (behandeling != null && behandeling.getStatus() == s) {
                statusModel.setSelectedItem(s);
            }
        }
        cmbbxStatus.setModel(statusModel);
    }

    private JFrame getParentFrame() {
        return (JFrame) SwingUtilities.getRoot(this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnnuleren;
    private javax.swing.JButton btnOpslaan;
    private javax.swing.JComboBox cmbBehandelCode;
    private javax.swing.JComboBox cmbbxKlantBSN;
    private javax.swing.JComboBox cmbbxStatus;
    private javax.swing.JLabel lblBehandelCode;
    private javax.swing.JLabel lblKlantBSN;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}
