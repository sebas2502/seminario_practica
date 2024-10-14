/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionPedidos;

import java.util.List;
import java.util.Random;

/**
 *
 * @author sebac
 */
public class Deposito {
    private String encargado;
    private List<Producto> productos;
    

    public Deposito(String encargado, List<Producto> productos) {
        this.encargado = encargado;
        this.productos = productos;
    }
    
    
    public String getEncargado() {
        return encargado;
    }
    
     
    public List<Producto> getProductos() {
        return productos;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

 
    
  
   //Simulamos un proceso de verificacion de materias primas existentes mediante una funcion random  
   public boolean verificarMateriaPrima(int codProd){
       Random random = new Random();
   
       return random.nextBoolean();
   }

    public Deposito(String encargado) {
        this.encargado = encargado;
    }

    public void despachar(){
        System.out.println("Pedido despachado...");
    }
    
}
