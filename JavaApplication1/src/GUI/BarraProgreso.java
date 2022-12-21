
package GUI;

import javax.swing.JOptionPane;

public class BarraProgreso extends javax.swing.JFrame {

    
    public BarraProgreso() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        Loading = new javax.swing.JLabel();
        LabelL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(112, 48, 158));

        jProgressBar1.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar1.setForeground(new java.awt.Color(252, 192, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/humbleg0d/Descargas/unnamed-1-2-768x432.jpg")); // NOI18N

        Loading.setBackground(new java.awt.Color(252, 192, 0));
        Loading.setFont(new java.awt.Font("Fira Code", 1, 18)); // NOI18N
        Loading.setForeground(new java.awt.Color(252, 192, 0));
        Loading.setText("0%");

        LabelL.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        LabelL.setForeground(new java.awt.Color(252, 192, 0));
        LabelL.setText("Cargando ...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Loading)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Loading)
                    .addComponent(LabelL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        BarraProgreso bp = new BarraProgreso();
         try{
            for(int i = 0 ; i <= 100 ; i++){
                Thread.sleep(100);
                bp.setVisible(true);
                bp.Loading.setText(i + "%");
                bp.jProgressBar1.setValue(i);
                if(i == 0){
                    bp.LabelL.setText("Cargando ...");
                }
                if( i == 10){
                    bp.LabelL.setText("Cargando paquetes...");
                }
                if( i == 30){
                    bp.LabelL.setText("Verificando recuros...");
                }
                if(i == 50){
                    bp.LabelL.setText("Verficando la Base de datos..");
                }
                if( i == 90){
                    bp.LabelL.setText("Todo listo...");
                }
                if(i == 100){
                    bp.setVisible(false);
                    
                    Registro r = new Registro();
                    r.setVisible(true);
                }
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null , e);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarraProgreso().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelL;
    private javax.swing.JLabel Loading;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
