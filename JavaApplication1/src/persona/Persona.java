
package persona;

import interfaces.InterCompra;
import interfaces.InterVenta;


public abstract class Persona implements InterVenta , InterCompra{
    private String nombre;
    private String apellidos;
    private String telefono;
    
    public Persona(){
        
    }
    
    public Persona(String nombre , String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getApellido(){
        return apellidos;
    }
    public void setApellido(String apellidos){
        this.apellidos = apellidos;
    }
    
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
}
