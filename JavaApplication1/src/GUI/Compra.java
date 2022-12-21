
package GUI;

import Acciones.Acompra;
import DataBase.ConectionDB;
import DataBase.Consultas;
import java.sql.Connection;
import listProductos.ListaGenerica;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import producto.ProductoEmpresa;
import socio.Socio;
import format.Format;
import producto.Producto;
import validator.Validator;

public class Compra extends javax.swing.JFrame {

   
    private ListaGenerica<ProductoEmpresa> list  = new ListaGenerica<>();
    private  ListaGenerica<Socio> lg = new ListaGenerica<>();
    private ListaGenerica<Acompra> lc = new ListaGenerica<>();
    private ListaGenerica<Producto> lp = new ListaGenerica<>();
    Validator valid = new Validator();
    private Connection connection;
    
    public Compra() {
        initComponents();
        conectionDB_Interface();
        selectSocios();
        selectCompra();
        llenarComboBox(list);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        autocompletado();
    }

    private int cont = 0;
    
    private void conectionDB_Interface(){
        ConectionDB javaPostgreSQLBasic = new ConectionDB();
        connection = javaPostgreSQLBasic.connectDatabase("127.0.0.1", "5432", "omnilife","socio", "123");
        Consultas.selectAll_PE(connection , list , "PRODUCTOSEMPRESA");   
    }
    
    private void selectSocios(){
        Consultas.selectAll_SO(connection, lg, "SOCIO");
    }
    
    private void selectCompra(){
        Consultas.selectAll_CO(connection, lc, "COMPRA");
        cont = lc.size();
    }
    
    private void llenarComboBox(ListaGenerica<ProductoEmpresa> lg){
        for(ProductoEmpresa pe : lg.getList()){
            ComboProducts.addItem(pe.getNombre());
        }
        
    }
    private void autocompletado(){
        AutoCompleteDecorator.decorate(ComboProducts);
    }
    
    
    private boolean validator(){
        return valid.isPresent(TXTfecha, "Tiene que ser formato fecha") && valid.isInteger(TXTcantidad, "Tiene que ser un numero entero.") &&
                valid.isDouble(TXTprecio, "Tiene que ser un numero") && valid.isPresent(TXTnombreCL, "Escritura incorrecta.");
    }
    
    String nombre;
    
    private boolean getDatosCompras(){
        boolean bandera = true;
        cont ++;
        ProductoEmpresa p = new ProductoEmpresa();
        
        
        int stock = Integer.parseInt(TXTcantidad.getText());
        int id = 0;
        double precio = 0;
        int stock2;
        
        for(ProductoEmpresa pe : list.getList()){
            if(pe.getNombre().equals(nombre)){
                p = pe;
                id = pe.getID();
                precio = pe.getPrecio();
                stock2 = pe.getStock();
                if(stock <= stock2){
                    stock2 = stock2 - stock; 
                    pe.setStock(stock2);
                  
                    Consultas.update_PE(connection, list, "PRODUCTOSEMPRESA", stock2, id);
                }
                else{
                    
                    valid.showMessage(TXTcantidad, "NO HAY SUFICIENTES PRODUCTOS.");
                    bandera = false;
                }
                break;
            } 
        }
       
        String fecha = TXTfecha.getText();
        String nombrecl = TXTnombreCL.getText();
        int id_soci=0;
        double comprat = 0;
            
        for(Socio s : lg.getList()){
            if(s.getNombre().equals(nombrecl)){
                id_soci = s.getID();
                comprat =s.accionCompra(p , stock);
                break;
            }
        }
        
        Acompra compra = new Acompra();
        compra.setID(cont);
        compra.setID_producto(id);
        compra.setPrecioCompra(precio);
        compra.setFecha(fecha);
        compra.setID_socio(id_soci);
        compra.setCantidad(stock);
        lc.push(compra);
        
        TEXTtotal.setText(Format.formaterNumber(comprat));
        Consultas.insertInto_CO(connection, lc, "COMPRA");
        return bandera;
    }
    
    private void getProductos(){
        lp.clearList();
        Consultas.selectAll_PO(connection, lp, "PRODUCTOSEMPRESA");
        
        Consultas.insertInto_PO(connection, lp, "PRODUCTOS");
        
    }
    
    private void clear(){
        TXTcantidad.setText("");
        TXTprecio.setText("");
        TXTnombreCL.setText("");
        TXTfecha.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TXTprecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TXTcantidad = new javax.swing.JTextField();
        BotnCompras = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        TXTfecha = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TEXTtotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TXTnombreCL = new javax.swing.JTextField();
        ComboProducts = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(112, 48, 158));

        jPanel2.setBackground(new java.awt.Color(112, 48, 158));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(252, 192, 0), null));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Compras");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(19, 19, 19))
        );

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(236, 235, 227));
        jLabel2.setText("Producto");

        jLabel7.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 235, 227));
        jLabel7.setText("Precio :");

        TXTprecio.setEditable(false);
        TXTprecio.setBackground(new java.awt.Color(252, 192, 0));

        jLabel3.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(236, 235, 227));
        jLabel3.setText("Nombre :");

        jLabel4.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 235, 227));
        jLabel4.setText("Cantidad :");

        TXTcantidad.setBackground(new java.awt.Color(252, 192, 0));

        BotnCompras.setBackground(new java.awt.Color(252, 192, 0));
        BotnCompras.setFont(new java.awt.Font("Fira Code", 1, 18)); // NOI18N
        BotnCompras.setForeground(new java.awt.Color(255, 255, 255));
        BotnCompras.setText("Comprado");
        BotnCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotnComprasActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(236, 235, 227));
        jLabel12.setText("Fecha :");

        TXTfecha.setBackground(new java.awt.Color(252, 192, 0));

        jLabel13.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total :");

        TEXTtotal.setEditable(false);
        TEXTtotal.setBackground(new java.awt.Color(252, 192, 0));
        TEXTtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TEXTtotalActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cliente ");

        jLabel6.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre : ");

        TXTnombreCL.setBackground(new java.awt.Color(252, 192, 0));

        ComboProducts.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboProductsItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(TXTnombreCL, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TXTfecha, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TXTprecio, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TXTcantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                            .addComponent(ComboProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(433, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(BotnCompras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(33, 33, 33)
                .addComponent(TEXTtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(ComboProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TXTcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TXTprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TXTnombreCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(TXTfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(TEXTtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BotnCompras))
                .addGap(51, 51, 51))
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

    private void TEXTtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEXTtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TEXTtotalActionPerformed

    private void BotnComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotnComprasActionPerformed
        if(validator() && getDatosCompras()){
            getProductos();
            valid.showMessage2(TEXTtotal, "COMPRA EXITOSA.");
            clear();
        }
    }//GEN-LAST:event_BotnComprasActionPerformed

    private void ComboProductsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboProductsItemStateChanged
        nombre = (String)ComboProducts.getSelectedItem();
        for(ProductoEmpresa pe : list.getList()){
            if(nombre.equals(pe.getNombre())){
                TXTprecio.setText(Double.toString(pe.getPrecio()));
            }
        }
    }//GEN-LAST:event_ComboProductsItemStateChanged

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
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotnCompras;
    private javax.swing.JComboBox<String> ComboProducts;
    private javax.swing.JTextField TEXTtotal;
    private javax.swing.JTextField TXTcantidad;
    private javax.swing.JTextField TXTfecha;
    private javax.swing.JTextField TXTnombreCL;
    private javax.swing.JTextField TXTprecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
