/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionPedidos;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sebac
 */
public class GestionPedidos {
    
    
    
    public static void main(String[] args) throws PedidoExcepcion{
        List<Pedido> pedidos = null; 
        //En esta seccion traer desde BD los pedidos existentes
        Produccion produccion = new Produccion("Martinez Diego",pedidos);
        boolean flag = true;
        
        Scanner scanner = new Scanner(System.in);
        
        while (flag) {
            System.out.println("===============================================");
            System.out.println("1 - Agregar Pedido");
            System.out.println("2 - Iniciar Pedido");
            System.out.println("3 - Finalizar Pedido");
            System.out.println("4 - Listar pedidos");
            System.out.println("5 - Salir");
            System.out.println("===============================================");
            System.out.println("Ingrese una opcion: ");
            
            int opcion = scanner.nextInt();
            
            switch(opcion){
                case 1 -> {
                     System.out.println("Ingrese codigo de producto a agregar al pedido");
                     int codProd = scanner.nextInt();
                     
                     
                }
            }
            
        }
        
    }
}
