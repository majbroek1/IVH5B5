/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fysioSysteem.presentation;

import com.google.inject.Guice;
import com.google.inject.Injector;
import fysioSysteem.businessLogic.behandeling.IBehandelingManager;
import fysioSysteem.businessLogic.behandeling.IKlantManager;
import fysioSysteem.businessLogic.beheer.IMedewerkerManager;
import fysioSysteem.businessLogic.planning.IAfspraakManager;
import fysioSysteem.domain.Afspraak;
import fysioSysteem.domain.Behandeling;
import fysioSysteem.domain.Fysiotherapeut;
import fysioSysteem.domain.Klant;
import general.AppInjector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Pascal
 */
public class AfsprakenToevoegenPanel extends javax.swing.JPanel {

    private IAfspraakManager afspraakManager;
    private IMedewerkerManager medewerkerManger;
    private IBehandelingManager behandelingManager;
    private IKlantManager klantManager;

    private ArrayList<Fysiotherapeut> actievefysiotherapeuten;
    private ArrayList<Behandeling> behandelingen;
    private ArrayList<Klant> klanten;

    /**
     * Creates new form AfsprakenToevoegenPanel
     */
    public AfsprakenToevoegenPanel() {
        Injector injector = Guice.createInjector(new AppInjector());
        this.afspraakManager = injector.getInstance(IAfspraakManager.class);
        this.medewerkerManger = injector.getInstance(IMedewerkerManager.class);
        this.behandelingManager = injector.getInstance(IBehandelingManager.class);
        this.klantManager = injector.getInstance(IKlantManager.class);

        actievefysiotherapeuten = medewerkerManger.getActieveFysiotherapeuten();
        klanten = klantManager.getKlanten();
        behandelingen = behandelingManager.getBehandelingen(klanten.get(0));

        initComponents();
        laadData();
    }

    private void laadData() {
        Date today = new Date();
        jDateChooser1.setMinSelectableDate(today);

        DefaultComboBoxModel<Klant> klantModel
                = new DefaultComboBoxModel<>();

        for (Klant k : klanten) {
            klantModel.addElement(k);
        }
        cmbKlant.setModel(klantModel);

        DefaultComboBoxModel<Fysiotherapeut> fysiotherapeutModel
                = new DefaultComboBoxModel<>();

        for (Fysiotherapeut f : actievefysiotherapeuten) {
            fysiotherapeutModel.addElement(f);
        }
        cmbFysiotherapeut.setModel(fysiotherapeutModel);

        DefaultComboBoxModel<Behandeling> behandelingModel
                = new DefaultComboBoxModel<>();

        for (Behandeling b : behandelingen) {
            behandelingModel.addElement(b);
        }
        cmbBehandeling.setModel(behandelingModel);
    }

    public void laadBehandelingCombobox() {
        behandelingen = behandelingManager.getBehandelingen((Klant) cmbKlant.getSelectedItem());

        DefaultComboBoxModel<Behandeling> behandelingModel
                = new DefaultComboBoxModel<>();

        for (Behandeling b : behandelingen) {
            behandelingModel.addElement(b);
        }
        cmbBehandeling.setModel(behandelingModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jSpinField1 = new com.toedter.components.JSpinField();
        jSpinField2 = new com.toedter.components.JSpinField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbFysiotherapeut = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cmbBehandeling = new javax.swing.JComboBox();
        buttonAfspraakOpslaan = new javax.swing.JButton();
        buttonAfspraakAnnuleren = new javax.swing.JButton();
        cmbKlant = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        buttonNieuwBehandeling = new javax.swing.JButton();

        jSpinField1.setMaximum(23);
        jSpinField1.setMinimum(0);

        jSpinField2.setMaximum(59);
        jSpinField2.setMinimum(0);

        jLabel1.setText("Datum");

        jLabel2.setText("Tijd");

        jLabel3.setText("Fysiotherapeut");

        cmbFysiotherapeut.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Behandeling");

        cmbBehandeling.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonAfspraakOpslaan.setText("Opslaan");
        buttonAfspraakOpslaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAfspraakOpslaanActionPerformed(evt);
            }
        });

        buttonAfspraakAnnuleren.setText("Annuleren");
        buttonAfspraakAnnuleren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAfspraakAnnulerenActionPerformed(evt);
            }
        });

        cmbKlant.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbKlant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKlantActionPerformed(evt);
            }
        });

        jLabel5.setText("Klant");

        buttonNieuwBehandeling.setText("Nieuwe behandeling");
        buttonNieuwBehandeling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNieuwBehandelingActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSpinField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)))
                    .addComponent(cmbFysiotherapeut, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbBehandeling, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbKlant, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAfspraakAnnuleren)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonAfspraakOpslaan))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(buttonNieuwBehandeling))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSpinField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFysiotherapeut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbKlant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbBehandeling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonNieuwBehandeling)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAfspraakAnnuleren)
                    .addComponent(buttonAfspraakOpslaan))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAfspraakOpslaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAfspraakOpslaanActionPerformed

        jDateChooser1.getDate();

        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm");

        JOptionPane.showMessageDialog(null, jDateChooser1.getDate());

        Date datumAfspraak = new Date();

        Afspraak afspraak = new Afspraak(null, (Fysiotherapeut) cmbFysiotherapeut.getSelectedItem(), (Behandeling) cmbBehandeling.getSelectedItem());

        afspraakManager.setAfspraak(afspraak);
    }//GEN-LAST:event_buttonAfspraakOpslaanActionPerformed

    private void buttonAfspraakAnnulerenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAfspraakAnnulerenActionPerformed
        HoofdVenster parent = (HoofdVenster) getParentFrame();
        parent.setPanel(new AfsprakenOverzichtPanel());
    }//GEN-LAST:event_buttonAfspraakAnnulerenActionPerformed

    private void buttonNieuwBehandelingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNieuwBehandelingActionPerformed

        BehandelingEditPanel panel = new BehandelingEditPanel((Klant) cmbKlant.getSelectedItem(),this);

        JFrame frame = new JFrame();
        frame.setTitle("Nieuwe Behandeling");
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);
    }//GEN-LAST:event_buttonNieuwBehandelingActionPerformed

    private void cmbKlantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKlantActionPerformed
        laadBehandelingCombobox();
    }//GEN-LAST:event_cmbKlantActionPerformed

    private JFrame getParentFrame() {
        return (JFrame) SwingUtilities.getRoot(this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAfspraakAnnuleren;
    private javax.swing.JButton buttonAfspraakOpslaan;
    private javax.swing.JButton buttonNieuwBehandeling;
    private javax.swing.JComboBox cmbBehandeling;
    private javax.swing.JComboBox cmbFysiotherapeut;
    private javax.swing.JComboBox cmbKlant;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.toedter.components.JSpinField jSpinField1;
    private com.toedter.components.JSpinField jSpinField2;
    // End of variables declaration//GEN-END:variables
}
