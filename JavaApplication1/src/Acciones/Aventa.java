
package Acciones;


import persona.Persona;
import producto.Producto;


public class Aventa {
    private int id;
    private int id_socio;
    private int id_producto;
    private int id_consumidor;
    private String fecha;
    private int cantidad;
    private double precioVenta;
    public Aventa(){
        
    }
    
    public Aventa(String fecha , int cantidad){
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
    
    public int getID_consumidor(){
        return id_consumidor;
    }
    public void setID_consumidor(int id_consumidor){
        this.id_consumidor = id_consumidor;
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
    
    public double getPrecioVenta(){
        return precioVenta;
    }
    public void setPrecioVenta( double precioVenta){
        this.precioVenta = precioVenta;
    }
    
    /*public double realizarVenta(Persona p , Producto pr){
        int cantidad;
        double venta = 0;
        if(pr.getStock() >= this.getCantidad()){
            cantidad = pr.getStock() - this.getCantidad();
            pr.setStock(this.getCantidad());
            pr.setPrecio(this.getPrecioVenta());
            venta = p.accionVenta(pr);
            pr.setStock(cantidad);
        }
        return venta;
    }*/
}
