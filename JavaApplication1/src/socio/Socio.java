
package socio;

import persona.Persona;
import producto.Producto;
import producto.ProductoEmpresa;


public class Socio extends Persona{
    private int id;
    
    public Socio(){
       super();
       
    }
    
    public Socio(String nombre , String apellidos){
       super(nombre , apellidos);
    }
    
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }

    @Override
    public double accionVenta(Producto p , int stock) {
        return p.getPrecio()*stock;
    }
    @Override
    public double accionCompra(ProductoEmpresa p , int stock) {
        return p.getPrecio()*stock;
    }
}
