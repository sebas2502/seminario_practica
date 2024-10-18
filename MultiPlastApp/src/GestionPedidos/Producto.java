/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionPedidos;

/**
 *
 * @author sebac
 */
public class Producto {
    private int codProd;
    private String nombre;
    private double precio;
    private int cantidad = 0;
   

    public Producto(int codProd, String nombre, double precio, int cantidad) {
        this.codProd = codProd;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    
    
    public String getNombre() {
        return nombre;
    }
    
    public void setCodProd(int codProd){
        this.codProd = codProd;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}

