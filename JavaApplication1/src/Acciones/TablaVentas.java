
package Acciones;


public class TablaVentas {
    private String nombreSocio;
    private String nombreProducto;
    private String nombreCliente;
    private int cantidad;
    private String fecha;
    
    public TablaVentas(){
        
    }
    
    public String getNombreSocio(){
        return nombreSocio;
    }
    public void setNombreSocio(String nombreSocio){
        this.nombreSocio = nombreSocio;
    }
    
    public String getNombreProducto(){
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto){
        this.nombreProducto = nombreProducto;
    }
    
    public String getNombreCliente(){
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public String getFecha(){
        return fecha;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    @Override
    public String toString(){
        return this.getNombreSocio() + "," + this.getNombreCliente() + "," + this.getNombreProducto() + "," + this.getCantidad() + "," 
                + this.getFecha();
    }
}
