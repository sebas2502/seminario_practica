/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import java.util.Scanner;

/**
 *
 * @author sebac
 */
public class VistaPedido {
    
    private Scanner scanner;
    
    public VistaPedido(){
        this.scanner = new Scanner(System.in);
    }
    
    public int solicitarDniCliente(){
        System.out.print("Ingrese dni del cliente");
        return scanner.nextInt();
    }
    
        
    public int solicitarCodProducto(){
        System.out.print("Ingrese codigo de producto");
        return scanner.nextInt();
    } 
     
    public String solicitarDescripcionPedido() {
        System.out.print("Ingrese descripcion");
        String descripcion = scanner.next();
        return descripcion;
    } 
    
    public Float montoPedido(){
        System.out.print("Ingrese monto del pedido");
        float monto = scanner.nextFloat();
        return monto;
    }
    
    
     
}
