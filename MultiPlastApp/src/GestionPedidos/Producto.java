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
        this.nombre = nombre;
        this.precio = precio;
        this.codProd = codProd;
        this.cantidad = cantidad;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
}

