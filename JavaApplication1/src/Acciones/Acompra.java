
package Acciones;

//import persona.Persona;
//import producto.ProductoEmpresa;


public class Acompra {
    private int id;
    private int id_socio;
    private int id_producto;
    private String fecha;
    private int cantidad;
    private double precioCompra;
    
    public Acompra(){
        
    }
    
    public Acompra(String fecha , int cantidad){
        this.fecha = fecha;
        this.cantidad = cantidad;
    }
    
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    
    public int getID_socio(){
        return id_socio;
    }
    public void setID_socio(int id_socio){
        this.id_socio = id_socio;
    }
    
    public int getID_producto(){
        return id_producto;
    }
    public void setID_producto(int id_producto){
        this.id_producto = id_producto;
    }
     
    public String getFecha(){
        return fecha;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public double getPrecioCompra(){
        return precioCompra;
    }
    public void setPrecioCompra( double precioCompra){
        this.precioCompra = precioCompra;
    }
}
