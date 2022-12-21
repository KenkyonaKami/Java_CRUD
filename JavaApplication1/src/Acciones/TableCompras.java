
package Acciones;


public class TableCompras {
    private String nombre;
    private int cantidad;
    private double precio;
    private String fecha;
    
    public TableCompras(){
        
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public String getFecha(){
        return fecha;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    @Override
    public String toString(){
        return this.getNombre() + " " + this.getCantidad() + " " + this.getPrecio() + " " + this.getFecha();
    }
}
