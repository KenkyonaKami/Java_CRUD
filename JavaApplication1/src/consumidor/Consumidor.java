
package consumidor;
import persona.Persona;
import producto.Producto;
import producto.ProductoEmpresa;

public class Consumidor extends Persona{
    
    private int id;
    private String direccion;
    
    
    public Consumidor(){
        super();
    }
    
    public Consumidor(String nombre , String apellidos){
        super(nombre , apellidos);
    }
    
    
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

     @Override
    public double accionVenta(Producto p , int stock) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public double accionCompra(ProductoEmpresa p , int stock) {
        return p.getPrecio()*p.getStock();
    }

}
