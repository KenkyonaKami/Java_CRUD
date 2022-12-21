/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producto;

/**
 *
 * @author humbleg0d
 */
public class ProductoEmpresa {
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    
    public ProductoEmpresa(){
        
    }
    
    public ProductoEmpresa(String nombre , double precio){
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
}
