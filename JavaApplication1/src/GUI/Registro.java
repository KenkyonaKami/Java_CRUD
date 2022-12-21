
package GUI;

public class Registro extends javax.swing.JFrame {


    
    public Registro() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFndo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Bvender = new javax.swing.JButton();
        Bcomprar = new javax.swing.JButton();
        BverVentas = new javax.swing.JButton();
        BverCompras = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelFndo.setBackground(new java.awt.Color(112, 48, 158));

        jPanel1.setBackground(new java.awt.Color(112, 48, 158));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(252, 192, 0), null));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/omilife.jpg"))); // NOI18N

        Bvender.setBackground(new java.awt.Color(252, 192, 0));
        Bvender.setFont(new java.awt.Font("Fira Code", 1, 18)); // NOI18N
        Bvender.setForeground(new java.awt.Color(255, 255, 255));
        Bvender.setText("Vendido");
        Bvender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BvenderActionPerformed(evt);
            }
        });

        Bcomprar.setBackground(new java.awt.Color(252, 192, 0));
        Bcomprar.setFont(new java.awt.Font("Fira Code", 1, 18)); // NOI18N
        Bcomprar.setForeground(new java.awt.Color(255, 255, 255));
        Bcomprar.setText("Comprado");
        Bcomprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcomprarActionPerformed(evt);
            }
        });

        BverVentas.setBackground(new java.awt.Color(252, 192, 0));
        BverVentas.setFont(new java.awt.Font("Fira Code", 1, 18)); // NOI18N
        BverVentas.setForeground(new java.awt.Color(255, 255, 255));
        BverVentas.setText("Ver Ventas");
        BverVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BverVentasActionPerformed(evt);
            }
        });

        BverCompras.setBackground(new java.awt.Color(252, 192, 0));
        BverCompras.setFont(new java.awt.Font("Fira Code", 1, 18)); // NOI18N
        BverCompras.setForeground(new java.awt.Color(255, 255, 255));
        BverCompras.setText("Ver Compras");
        BverCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BverComprasActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(252, 192, 0));
        jButton1.setFont(new java.awt.Font("Fira Code", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Registrar Usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelFndoLayout = new javax.swing.GroupLayout(PanelFndo);
        PanelFndo.setLayout(PanelFndoLayout);
        PanelFndoLayout.setHorizontalGroup(
            PanelFndoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFndoLayout.createSequentialGroup()
                .addContainerGap(236, Short.MAX_VALUE)
                .addGroup(PanelFndoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelFndoLayout.createSequentialGroup()
                        .addGroup(PanelFndoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelFndoLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFndoLayout.createSequentialGroup()
                                .addComponent(BverVentas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BverCompras)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFndoLayout.createSequentialGroup()
                        .addComponent(Bvender)
                        .addGap(171, 171, 171)
                        .addComponent(Bcomprar)
                        .addGap(266, 266, 266))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFndoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
        );
        PanelFndoLayout.setVerticalGroup(
            PanelFndoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFndoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(PanelFndoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bvender, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bcomprar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(PanelFndoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BverVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BverCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFndo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFndo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BvenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BvenderActionPerformed
        Venta v = new Venta();
    
        v.setVisible(true);
        
    }//GEN-LAST:event_BvenderActionPerformed

    private void BcomprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcomprarActionPerformed
       Compra c = new Compra();
        c.setVisible(true);
    }//GEN-LAST:event_BcomprarActionPerformed

    private void BverVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BverVentasActionPerformed
        VerVentas vv = new VerVentas();
        vv.setVisible(true);
    }//GEN-LAST:event_BverVentasActionPerformed

    private void BverComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BverComprasActionPerformed
        VerCompras vc = new VerCompras();
        vc.setVisible(true);
    }//GEN-LAST:event_BverComprasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UserRegister ur = new UserRegister();
        ur.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bcomprar;
    private javax.swing.JButton Bvender;
    private javax.swing.JButton BverCompras;
    private javax.swing.JButton BverVentas;
    private javax.swing.JPanel PanelFndo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private static class NewJPanle {

        public NewJPanle() {
        }
    }
}
