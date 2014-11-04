/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fysioSysteem.presentation;

import com.google.inject.Guice;
import com.google.inject.Injector;
import general.AppInjector;
import javax.swing.JPanel;

/**
 *
 * @author Bob
 */
public class HoofdVenster extends javax.swing.JFrame {

    /**
     * Creates new form HoofdVenster
     */
    public HoofdVenster() {
        initComponents();
    }
    
    public void setPanel(JPanel panel) {
        pnlContent.removeAll();
        pnlContent.add(panel);
        
        panel.setBounds(0, 0, pnlContent.getWidth(), pnlContent.getHeight());
        panel.setVisible(true);
        
        pnlContent.revalidate();
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        btnAfspraken = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnTherapeuten = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnBehandelingen = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnPraktijk = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnUitloggen = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FysioSysteem");

        pnlMenu.setBackground(new java.awt.Color(0, 153, 153));

        btnAfspraken.setBackground(new java.awt.Color(0, 137, 137));
        btnAfspraken.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAfspraken.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAfsprakenMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Afspraken");

        javax.swing.GroupLayout btnAfsprakenLayout = new javax.swing.GroupLayout(btnAfspraken);
        btnAfspraken.setLayout(btnAfsprakenLayout);
        btnAfsprakenLayout.setHorizontalGroup(
            btnAfsprakenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAfsprakenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnAfsprakenLayout.setVerticalGroup(
            btnAfsprakenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAfsprakenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnTherapeuten.setBackground(new java.awt.Color(0, 137, 137));
        btnTherapeuten.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTherapeuten.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTherapeutenMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fysiotherapeuten");

        javax.swing.GroupLayout btnTherapeutenLayout = new javax.swing.GroupLayout(btnTherapeuten);
        btnTherapeuten.setLayout(btnTherapeutenLayout);
        btnTherapeutenLayout.setHorizontalGroup(
            btnTherapeutenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTherapeutenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnTherapeutenLayout.setVerticalGroup(
            btnTherapeutenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTherapeutenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnBehandelingen.setBackground(new java.awt.Color(0, 137, 137));
        btnBehandelingen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBehandelingen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBehandelingenMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Behandelingen");

        javax.swing.GroupLayout btnBehandelingenLayout = new javax.swing.GroupLayout(btnBehandelingen);
        btnBehandelingen.setLayout(btnBehandelingenLayout);
        btnBehandelingenLayout.setHorizontalGroup(
            btnBehandelingenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBehandelingenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnBehandelingenLayout.setVerticalGroup(
            btnBehandelingenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBehandelingenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnPraktijk.setBackground(new java.awt.Color(0, 137, 137));
        btnPraktijk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Praktijk");

        javax.swing.GroupLayout btnPraktijkLayout = new javax.swing.GroupLayout(btnPraktijk);
        btnPraktijk.setLayout(btnPraktijkLayout);
        btnPraktijkLayout.setHorizontalGroup(
            btnPraktijkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPraktijkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnPraktijkLayout.setVerticalGroup(
            btnPraktijkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPraktijkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnUitloggen.setBackground(new java.awt.Color(0, 137, 137));
        btnUitloggen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUitloggen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUitloggenMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Uitloggen");

        javax.swing.GroupLayout btnUitloggenLayout = new javax.swing.GroupLayout(btnUitloggen);
        btnUitloggen.setLayout(btnUitloggenLayout);
        btnUitloggenLayout.setHorizontalGroup(
            btnUitloggenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnUitloggenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnUitloggenLayout.setVerticalGroup(
            btnUitloggenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnUitloggenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAfspraken, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTherapeuten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBehandelingen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPraktijk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUitloggen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAfspraken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTherapeuten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBehandelingen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPraktijk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 297, Short.MAX_VALUE)
                .addComponent(btnUitloggen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUitloggenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUitloggenMouseClicked
        HoofdVenster.this.dispose();
        Injector injector = Guice.createInjector(new AppInjector());
        injector.getInstance(frmLogin.class).setVisible(true);
    }//GEN-LAST:event_btnUitloggenMouseClicked

    private void btnAfsprakenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAfsprakenMouseClicked
        setPanel(new AfsprakenOverzichtPanel());
    }//GEN-LAST:event_btnAfsprakenMouseClicked

    private void btnTherapeutenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTherapeutenMouseClicked
        Injector injector = Guice.createInjector(new AppInjector());
        setPanel(injector.getInstance(MedewerkerOverzichtPanel.class));
    }//GEN-LAST:event_btnTherapeutenMouseClicked

    private void btnBehandelingenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBehandelingenMouseClicked
        Injector injector = Guice.createInjector(new AppInjector());
        setPanel(injector.getInstance(BehandelingOverzichtPanel.class));
    }//GEN-LAST:event_btnBehandelingenMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAfspraken;
    private javax.swing.JPanel btnBehandelingen;
    private javax.swing.JPanel btnPraktijk;
    private javax.swing.JPanel btnTherapeuten;
    private javax.swing.JPanel btnUitloggen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
