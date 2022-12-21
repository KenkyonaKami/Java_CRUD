
package DataBase;

import Acciones.Acompra;
import Acciones.Aventa;
import Acciones.TablaVentas;
import Acciones.TableCompras;
import consumidor.Consumidor;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import listProductos.ListaGenerica;
import producto.ProductoEmpresa;
import socio.Socio;
import format.FormatDate;
import producto.Producto;

public class Consultas {
    public static void selectAll_PE(Connection conexion , ListaGenerica<ProductoEmpresa> list , String nameRelation ){
        String consulta = "SELECT*FROM " + nameRelation + ";";

        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(consulta);
            
            ResultSet rs = sentencia.executeQuery();
            
            while(rs.next()){
                ProductoEmpresa pe = new ProductoEmpresa();
                pe.setID(rs.getInt(1));
                pe.setNombre(rs.getString(2));
                pe.setPrecio(rs.getDouble(3));
                pe.setStock(rs.getInt(4));
                list.push(pe);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void selectAll_CO(Connection conexion , ListaGenerica<Acompra> list , String nameRelation ){
        String consulta = "SELECT*FROM " + nameRelation + ";";

        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(consulta);
            
            ResultSet rs = sentencia.executeQuery();
            
            while(rs.next()){
                Acompra ac = new Acompra();
                
                ac.setID(rs.getInt(1));
                ac.setID_socio(rs.getInt(2));
                ac.setID_producto(rs.getInt(3));
                ac.setCantidad(rs.getInt(4));
                ac.setFecha(rs.getDate(5).toString());
                list.push(ac);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void selectAll_VE(Connection conexion , ListaGenerica<Aventa> list , String nameRelation ){
        String consulta = "SELECT*FROM " + nameRelation + ";";

        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(consulta);
            
            ResultSet rs = sentencia.executeQuery();
            
            while(rs.next()){
                Aventa av = new Aventa();
                
                av.setID(rs.getInt(1));
                av.setID_socio(rs.getInt(2));
                av.setID_producto(rs.getInt(3));
                av.setID_consumidor(rs.getInt(4));
                av.setCantidad(rs.getInt(5));
                av.setFecha(rs.getDate(6).toString());
                list.push(av);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void selectAll_SO(Connection conexion , ListaGenerica<Socio> list , String nameRelation ){
        String consulta = "SELECT*FROM " + nameRelation + ";";

        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(consulta);
            
            ResultSet rs = sentencia.executeQuery();
            
            while(rs.next()){
                Socio s = new Socio();
                s.setID(rs.getInt(1));
                s.setNombre(rs.getString(2));
                s.setApellido(rs.getString(3));
                s.setTelefono(rs.getString(4));
                list.push(s);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void selectAll_Cosumidor(Connection conexion , ListaGenerica<Consumidor> lc , String nameRelation ){
        String consulta = "SELECT*FROM " + nameRelation + ";";

        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(consulta);
            
            ResultSet rs = sentencia.executeQuery();
            
            while(rs.next()){
                Consumidor c = new Consumidor();
                c.setID(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setTelefono(rs.getString(5));
                lc.push(c);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void selectAll_PO(Connection conexion , ListaGenerica<Producto> list , String nameRelation ){
   
        String consulta = "SELECT P.ID , P.NOMBRE , P.PRECIO , SUM(C.CANTIDAD) FROM " + nameRelation + " AS P INNER JOIN COMPRA AS C"
                + " ON P.ID = C.ID_PRODUCTO GROUP BY P.ID , P.NOMBRE , P.PRECIO;";

        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(consulta);
            
            ResultSet rs = sentencia.executeQuery();
            
            while(rs.next()){
                Producto p = new Producto();
                p.setID(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
               
                list.push(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void queryTable_Compras(Connection conexion , ListaGenerica<TableCompras> datos){
        String consulta = "SELECT P.NOMBRE , C.CANTIDAD , P.PRECIO  , C.FECHA FROM PRODUCTOSEMPRESA AS P INNER JOIN COMPRA AS C ON P.ID = C.ID_PRODUCTO ORDER BY C.FECHA;";
        
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.prepareStatement(consulta);
            ResultSet rs = sentencia.executeQuery();
            
            while(rs.next()){
                TableCompras tc = new TableCompras();
                tc.setNombre(rs.getString(1));
                tc.setCantidad(rs.getInt(2));
                tc.setPrecio(rs.getDouble(3));
                tc.setFecha(rs.getDate(4).toString());
                
                datos.push(tc);
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE , null , ex);
        }
    }
    
    
    public static void queryTable_Ventas(Connection conexion , ListaGenerica<TablaVentas> datos){
        String consulta = "SELECT S.NOMBRE , CONCAT(C.NOMBRE , ' ' , C.APELLIDOS) , P.NOMBRE , V.CANTIDAD , V.FECHA FROM VENTA AS V "
                + "INNER JOIN SOCIO AS S ON V.ID_SOCIO = S.ID INNER JOIN CONSUMIDOR AS C "
                + "ON C.ID = V.ID_CONSUMIDOR INNER JOIN PRODUCTOS AS P ON P.ID = V.ID_PRODUCTO;";
        
        PreparedStatement sentencia = null;
        
        try{
            sentencia = conexion.prepareStatement(consulta);
            ResultSet rs = sentencia.executeQuery();
            
            while(rs.next()){
                TablaVentas tv = new TablaVentas();
                
                tv.setNombreSocio(rs.getString(1));
                tv.setNombreCliente(rs.getString(2));
                tv.setNombreProducto(rs.getString(3));
                tv.setCantidad(rs.getInt(4));
                tv.setFecha(rs.getDate(5).toString());
                
                datos.push(tv);
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE , null , ex);
        }
    }
    
    public static void insertInto_SO(Connection conexion , ListaGenerica<Socio> list , String nameRelation){
       String consulta = "INSERT INTO " + nameRelation + " VALUES(?,?,?,?);";

        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(consulta);
            
            for(Socio s : list.getList()){
                sentencia.setInt(1, s.getID());
                sentencia.setString(2 ,s.getNombre());
                sentencia.setString(3, s.getApellido());
                sentencia.setString(4 , s.getTelefono());
            }
                
            list.push(list.pull());
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
   
    public static void insertInto_Consumidor(Connection conexion , ListaGenerica<Consumidor> lc , String nameRelation){
       String consulta = "INSERT INTO " + nameRelation + " VALUES(?,?,?,?,?);";

        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(consulta);
            
            for(Consumidor c : lc.getList()){
                sentencia.setInt(1, c.getID());
                sentencia.setString(2 ,c.getNombre());
                sentencia.setString(3, c.getApellido());
                sentencia.setString(4, c.getDireccion());
                sentencia.setString(5 , c.getTelefono());
                //sentencia.executeUpdate();
            }
                
            lc.push(lc.pull());
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
   
    public static void insertInto_PO(Connection conexion , ListaGenerica<Producto> list , String nameRelation){
        
       delete_PO(conexion , nameRelation);
       
       String consulta = "INSERT INTO " + nameRelation + " VALUES(?,?,?,?);";
        PreparedStatement sentencia = null;
        
        try {
            sentencia = conexion.prepareStatement(consulta);
                    
            for(Producto p : list.getList()){
                sentencia.setInt(1, p.getID());
                sentencia.setString(2 ,p.getNombre());
                sentencia.setDouble(3, p.getPrecio());
                sentencia.setInt(4 , p.getStock());
                sentencia.executeUpdate();
            }
                
            //list.push(list.pull());
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
   
   
   public static void insertInto_CO(Connection conexion , ListaGenerica<Acompra> list , String nameRelation){
       String consulta = "INSERT INTO " + nameRelation + " VALUES(?,?,?,?,?);";

        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(consulta);
            
            for(Acompra a : list.getList()){
                sentencia.setInt(1, a.getID());
                sentencia.setInt(2 ,a.getID_socio());
                sentencia.setInt(3, a.getID_producto());
                sentencia.setInt(4 , a.getCantidad());
                sentencia.setDate(5, FormatDate.formatDate(a.getFecha()));
            }
                
            list.push(list.pull());
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
   
   public static void insertInto_VE(Connection conexion , ListaGenerica<Aventa> list , String nameRelation){
       String consulta = "INSERT INTO " + nameRelation + " VALUES(?,?,?,?,?,?);";

        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(consulta);
            
            for(Aventa a : list.getList()){
                sentencia.setInt(1, a.getID());
                sentencia.setInt(2 ,a.getID_socio());
                sentencia.setInt(3, a.getID_producto());
                sentencia.setInt(4, a.getID_consumidor());
                sentencia.setInt(5 , a.getCantidad());
                sentencia.setDate(6, FormatDate.formatDate(a.getFecha()));
                //sentencia.executeUpdate();
            }
                
            list.push(list.pull());
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
   public static void update_PE(Connection conexion , ListaGenerica<ProductoEmpresa> le , String nameRelation , int n , int id){
       String consulta = "UPDATE " + nameRelation + " SET STOCK = " + n + " WHERE ID = ? ;";
       PreparedStatement sentencia = null;
       
       try{
           sentencia = conexion.prepareStatement(consulta);
           for(ProductoEmpresa p : le.getList()){
               if(id ==  p.getID()){
                   sentencia.setInt(1, p.getID());
                   break;
               }
           }
           sentencia.executeUpdate();
       }catch(SQLException ex){
           Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE , null , ex);
       }
   }
   
   public static void update_PO(Connection conexion , ListaGenerica<Producto> le , String nameRelation , int n , int id){
       String consulta = "UPDATE " + nameRelation + " SET STOCK = " + n + " WHERE ID = ? ;";
       PreparedStatement sentencia = null;
       
       try{
           sentencia = conexion.prepareStatement(consulta);
           for(Producto p : le.getList()){
               if(id ==  p.getID()){
                   sentencia.setInt(1, p.getID());
                   break;
               }
           }
           sentencia.executeUpdate();
       }catch(SQLException ex){
           Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE , null , ex);
       }
   }
   
   public static void delete_PO(Connection conexion , String nameRelation){
       String consulta = "DELETE FROM " + nameRelation + " WHERE ID IN(SELECT ID FROM PRODUCTOS);";
       PreparedStatement setencia = null;
       
       try{
           setencia = conexion.prepareStatement(consulta);
           setencia.executeUpdate();
       }catch(SQLException ex){
           Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE , null , ex);
       }
   }
}
