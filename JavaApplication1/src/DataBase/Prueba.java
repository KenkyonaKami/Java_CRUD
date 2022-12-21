/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;
import java.sql.*;
import java.util.Scanner;
import listProductos.ListaGenerica;
import producto.ProductoEmpresa;
import socio.Socio;
/**
 *
 * @author humbleg0d
 */
public class Prueba {
    public static void main(String[] args) {
     
        ProductoEmpresa a = new ProductoEmpresa();
        a.setPrecio(20);
        ProductoEmpresa b = new ProductoEmpresa();
        
        //ProductoEmpresa c = new ProductoEmpresa();
         b = a;
        
        if(a.equals(b)){
            System.out.println("Igaules");
            System.out.println(b.getPrecio());
        }
        else{
            System.out.println("No Igaules");
            System.out.println(b.getPrecio());
        }
    }
}
