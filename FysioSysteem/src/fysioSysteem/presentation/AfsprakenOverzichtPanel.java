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

    private AfspraakManager afspraakManager;
    
    private ArrayList<Afspraak> afspraken;
    private ArrayList<Afspraak> valideAfspraken;

    /**
     * Creates new form AfsprakenOverzichtPanel
     */
    public AfsprakenOverzichtPanel() {
        //Injector injector = Guice.createInjector(new AppInjector());
        this.afspraakManager = new AfspraakManager(); //injector.getInstance(IAfspraakManager.class);

        try {
            afspraken = afspraakManager.getAfspraken();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Afspraken ophalen is mislukt.");
        }

        initComponents();
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
        
        valideAfspraken = new ArrayList<>();
        
        for (Afspraak a : afspraken) {
            if (today.before(a.getDatumTijd())) {
                valideAfspraken.add(a);
            }
        }

        try {
            for (Afspraak a : valideAfspraken) {
                tabelModel.addRow(new Object[]{
                    a.getId(),
                    a.getBehandeling().getKlant().getNaam(),
                    dateFormat.format(a.getDatumTijd()),
                    timeFormat.format(a.getDatumTijd()),
                    a.getBehandeling().getBehandelCode().getBehandelingNaam()
                });
            }
        } catch (Exception e) {

        }

        tblAfspraken.setModel(tabelModel);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tblAfspraken = new javax.swing.JTable();
        buttonAfspraakToevoegen = new javax.swing.JButton();
        buttonAfspraakVerwijderen = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(638, 436));

        tblAfspraken.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblAfspraken);

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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonAfspraakVerwijderen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAfspraakToevoegen)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAfspraakToevoegen)
                    .addComponent(buttonAfspraakVerwijderen))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAfspraakToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAfspraakToevoegenActionPerformed
        HoofdVenster parent = (HoofdVenster) getParentFrame();
        parent.setPanel(new AfsprakenToevoegenPanel());
    }//GEN-LAST:event_buttonAfspraakToevoegenActionPerformed

    private void buttonAfspraakVerwijderenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAfspraakVerwijderenActionPerformed
        try {
            Afspraak a = valideAfspraken.get(
                    tblAfspraken.convertRowIndexToModel(tblAfspraken.getSelectedRow()));

            Object[] options = {"Ja", "Nee"};

            JFrame frame = new JFrame();

            int n = JOptionPane.showOptionDialog(frame,
                    "Weet u zeker dat u afspraak #" + a.getId() + " wilt verwijderen?",
                    "Verwijderen afspraak #" + a.getId(),
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (n == 0) {
                afspraakManager.removeAfspraak(a);

                HoofdVenster parent = (HoofdVenster) getParentFrame();
                parent.setPanel(new AfsprakenOverzichtPanel());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Selecteer een rij, alstublieft.");
        }
    }//GEN-LAST:event_buttonAfspraakVerwijderenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAfspraakToevoegen;
    private javax.swing.JButton buttonAfspraakVerwijderen;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAfspraken;
    // End of variables declaration//GEN-END:variables
}
