
package GUI;


import Acciones.Aventa;
import DataBase.ConectionDB;
import DataBase.Consultas;
import consumidor.Consumidor;
import listProductos.ListaGenerica;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.sql.Connection;
import format.Format;
import producto.Producto;
import producto.ProductoEmpresa;
import socio.Socio;
import validator.Validator;

public class Venta extends javax.swing.JFrame {

    
    private ListaGenerica<Producto> list  = new ListaGenerica<>();
    private ListaGenerica<Aventa> lv  = new ListaGenerica<>();
    private  ListaGenerica<Socio> lg = new ListaGenerica<>();
    private Connection connection;
    private ListaGenerica<Consumidor> lc = new ListaGenerica<>();
    Validator valid = new Validator();
    private int cont = 0;
    private int cont2 = 0;
    public Venta() {
        initComponents();
        conectionDB_Interface();
        llenarComboBox(list);
        selectVenta();
        selectSocios();
        selectConsumidor();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        autocompletado();
        
    }
    
    private boolean validator(){
        return valid.isPresent(TEXTfecha, "Tiene que ser formato fecha") && valid.isInteger(TEXTcantidad, "Tiene que ser un numero entero.") &&
                valid.isDouble(TEXTprecio, "Tiene que ser un numero") && valid.isPresent(TEXTnombreCl, "Escritura incorrecta.") &&
                valid.isPresent(TEXTapellidos, "Escritura incorrecta.") && valid.isPresent(TEXTcelular, "Escritura incorrecta.") &&
                valid.isPresent(TEXTnombreSO, "Escritura incorrecta.");
    }
    
    
    private void conectionDB_Interface(){
        ConectionDB javaPostgreSQLBasic = new ConectionDB();
        connection = javaPostgreSQLBasic.connectDatabase("127.0.0.1", "5432", "omnilife","socio", "123");
        Consultas.selectAll_PO(connection , list , "PRODUCTOS");
    }
    
    private void selectSocios(){
        Consultas.selectAll_SO(connection, lg, "SOCIO");
    }
    

    private void selectVenta(){
        Consultas.selectAll_VE(connection, lv, "VENTA");
        cont = lv.size();
    }
    
   
    private void selectConsumidor(){
        Consultas.selectAll_Cosumidor(connection, lc, "CONSUMIDOR");
        cont2 = lc.size();
        
    }
    
    private void llenarComboBox(ListaGenerica<Producto> lg){
        for(ProductoEmpresa pe : lg.getList()){
            ComboProductos.addItem(pe.getNombre());  
        }   
    }
    
    String nombrecl;
    private void getConsumidor(){
        cont2 = cont2 + 1;
        
        nombrecl = TEXTnombreCl.getText();
        String apellidos = TEXTapellidos.getText();
        String celular = TEXTcelular.getText();
        String direccion = TEXTdirec.getText();
        
        Consumidor c = new Consumidor();
        
        c.setID(cont2);
        c.setNombre(nombrecl);
        c.setApellido(apellidos);
        c.setTelefono(celular);
        c.setDireccion(direccion);
        
        
        
        lc.push(c);
        Consultas.insertInto_Consumidor(connection, lc, "CONSUMIDOR");
    }
    
    String nombre;
    private boolean getDatosCompras(){
        boolean bandera = true;
        cont ++;
        Producto p = new Producto();
        
        
        int stock = Integer.parseInt(TEXTcantidad.getText());
        int id = 0;
        double precio = 0;
        int stock2;
        
        for(Producto pe : list.getList()){
            if(pe.getNombre().equals(nombre)){
                p = pe;
                id = pe.getID();
                precio = pe.getPrecio();
                stock2 = pe.getStock();
                if(stock <= stock2){
                    stock2 = stock2 - stock; 
                    pe.setStock(stock2);
                  
                    Consultas.update_PO(connection, list, "PRODUCTOS", stock2, id);
                }
                else{
                    
                    valid.showMessage(TEXTcantidad, "NO HAY SUFICIENTES PRODUCTOS.");
                    bandera = false;
                }
                break;
            } 
        }
        
        String fecha = TEXTfecha.getText();
        String nombreso = TEXTnombreSO.getText();
        int id_soci=0;
        double comprat = 0;
            
        for(Socio s : lg.getList()){
            if(s.getNombre().equals(nombreso)){
                id_soci = s.getID();
                comprat =s.accionVenta(p , stock);
                break;
            }
        }
        
        int id_cons = 0;
        for(Consumidor c : lc.getList()){
            if(c.getNombre().equals(nombrecl)){
                id_cons = c.getID();
                break;
            }
        }
        
        
        Aventa venta = new Aventa();
        venta.setID(cont);
        venta.setID_producto(id);
        venta.setPrecioVenta(precio);
        venta.setFecha(fecha);
        venta.setID_socio(id_soci);
        venta.setCantidad(stock);
        venta.setID_consumidor(id_cons);
        lv.push(venta);
        
        TEXTtotal.setText(Format.formaterNumber(comprat));
        Consultas.insertInto_VE(connection, lv, "VENTA");
       
        
        return bandera;
    }
    
    private void autocompletado(){
        AutoCompleteDecorator.decorate(ComboProductos);
    }
    
    private void clear(){
        TEXTcantidad.setText("");
        TEXTprecio.setText("");
        TEXTnombreCl.setText("");
        TEXTfecha.setText("");
        TEXTnombreSO.setText("");
        TEXTdirec.setText("");
        TEXTcelular.setText("");
        TEXTapellidos.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloPanel = new javax.swing.JPanel();
        FondoPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ComboProductos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TEXTcantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TEXTnombreCl = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TEXTapellidos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TEXTprecio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TEXTcelular = new javax.swing.JTextField();
        BOTONvender = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        TEXTdirec = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TEXTfecha = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        TEXTtotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        TEXTnombreSO = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TituloPanel.setBackground(new java.awt.Color(112, 48, 158));

        FondoPanel.setBackground(new java.awt.Color(112, 48, 158));
        FondoPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(252, 192, 0), null));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ventas");

        javax.swing.GroupLayout FondoPanelLayout = new javax.swing.GroupLayout(FondoPanel);
        FondoPanel.setLayout(FondoPanelLayout);
        FondoPanelLayout.setHorizontalGroup(
            FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(385, 385, 385))
        );
        FondoPanelLayout.setVerticalGroup(
            FondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoPanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(17, 17, 17))
        );

        ComboProductos.setBackground(new java.awt.Color(252, 192, 0));
        ComboProductos.setEditable(true);
        ComboProductos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboProductosItemStateChanged(evt);
            }
        });
        ComboProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboProductosMouseClicked(evt);
            }
        });
        ComboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboProductosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(236, 235, 227));
        jLabel1.setText("Nombre :");

        jLabel3.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(236, 235, 227));
        jLabel3.setText("Cantidad :");

        TEXTcantidad.setBackground(new java.awt.Color(252, 192, 0));

        jLabel4.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 235, 227));
        jLabel4.setText("Nombre :");

        TEXTnombreCl.setBackground(new java.awt.Color(252, 192, 0));
        TEXTnombreCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TEXTnombreClActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 235, 227));
        jLabel5.setText("Apellidos :");

        TEXTapellidos.setBackground(new java.awt.Color(252, 192, 0));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 235, 227));
        jLabel6.setText("Producto");

        jLabel7.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 235, 227));
        jLabel7.setText("Precio :");

        TEXTprecio.setBackground(new java.awt.Color(252, 192, 0));

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 235, 227));
        jLabel8.setText("Socio:");

        jLabel9.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 235, 227));
        jLabel9.setText("Celular :");

        TEXTcelular.setBackground(new java.awt.Color(252, 192, 0));

        BOTONvender.setBackground(new java.awt.Color(252, 192, 0));
        BOTONvender.setFont(new java.awt.Font("Fira Code", 1, 18)); // NOI18N
        BOTONvender.setForeground(new java.awt.Color(255, 255, 255));
        BOTONvender.setText("Vender");
        BOTONvender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BOTONvenderActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(236, 235, 227));
        jLabel11.setText("Direccion :");

        TEXTdirec.setBackground(new java.awt.Color(252, 192, 0));
        TEXTdirec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TEXTdirecActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(236, 235, 227));
        jLabel12.setText("Fecha :");

        TEXTfecha.setBackground(new java.awt.Color(252, 192, 0));

        jLabel13.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total :");

        TEXTtotal.setBackground(new java.awt.Color(252, 192, 0));
        TEXTtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TEXTtotalActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 235, 227));
        jLabel10.setText("Cliente");

        jLabel14.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(236, 235, 227));
        jLabel14.setText("Nombre :");

        TEXTnombreSO.setBackground(new java.awt.Color(252, 192, 0));
        TEXTnombreSO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TEXTnombreSOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TituloPanelLayout = new javax.swing.GroupLayout(TituloPanel);
        TituloPanel.setLayout(TituloPanelLayout);
        TituloPanelLayout.setHorizontalGroup(
            TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(TituloPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TituloPanelLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TEXTnombreSO, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(585, 585, 585))
                    .addGroup(TituloPanelLayout.createSequentialGroup()
                        .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addGroup(TituloPanelLayout.createSequentialGroup()
                                .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(26, 26, 26)
                                .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(TEXTcelular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                        .addComponent(TEXTapellidos, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TEXTnombreCl, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(TEXTdirec, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(TEXTfecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                        .addComponent(TEXTprecio, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TEXTcantidad, javax.swing.GroupLayout.Alignment.LEADING)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(TituloPanelLayout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(BOTONvender)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(33, 33, 33)
                        .addComponent(TEXTtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
            .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TituloPanelLayout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(jLabel10)
                    .addContainerGap(781, Short.MAX_VALUE)))
        );
        TituloPanelLayout.setVerticalGroup(
            TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TituloPanelLayout.createSequentialGroup()
                .addComponent(FondoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addGap(38, 38, 38)
                .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TEXTcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TEXTprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(TEXTfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TEXTnombreCl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TEXTapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TEXTcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(TEXTdirec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(TEXTnombreSO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BOTONvender)
                    .addComponent(jLabel13)
                    .addComponent(TEXTtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
            .addGroup(TituloPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TituloPanelLayout.createSequentialGroup()
                    .addGap(398, 398, 398)
                    .addComponent(jLabel10)
                    .addContainerGap(438, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TituloPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TituloPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboProductosActionPerformed

    private void TEXTnombreClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEXTnombreClActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TEXTnombreClActionPerformed

    private void TEXTdirecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEXTdirecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TEXTdirecActionPerformed

    private void TEXTtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEXTtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TEXTtotalActionPerformed

    private void BOTONvenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BOTONvenderActionPerformed
       if(validator()){
           getConsumidor();
           if(getDatosCompras()){
               valid.showMessage2(TEXTtotal, "COMPRA EXITOSA.");
           }
           clear();
       }
    }//GEN-LAST:event_BOTONvenderActionPerformed

    private void ComboProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboProductosMouseClicked
        
    }//GEN-LAST:event_ComboProductosMouseClicked

    private void ComboProductosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboProductosItemStateChanged
        nombre = (String)ComboProductos.getSelectedItem();
        for(Producto pe : list.getList()){
            if(nombre.equals(pe.getNombre())){
                TEXTprecio.setText(Double.toString(pe.getPrecio()));
            }
        }
    }//GEN-LAST:event_ComboProductosItemStateChanged

    private void TEXTnombreSOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEXTnombreSOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TEXTnombreSOActionPerformed

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
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BOTONvender;
    private javax.swing.JComboBox<String> ComboProductos;
    private javax.swing.JPanel FondoPanel;
    private javax.swing.JTextField TEXTapellidos;
    private javax.swing.JTextField TEXTcantidad;
    private javax.swing.JTextField TEXTcelular;
    private javax.swing.JTextField TEXTdirec;
    private javax.swing.JTextField TEXTfecha;
    private javax.swing.JTextField TEXTnombreCl;
    private javax.swing.JTextField TEXTnombreSO;
    private javax.swing.JTextField TEXTprecio;
    private javax.swing.JTextField TEXTtotal;
    private javax.swing.JPanel TituloPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
