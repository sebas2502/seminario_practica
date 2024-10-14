/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionPedidos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sebac
 */
public class GestionPedidos {
    
    
    
    public static void main(String[] args) throws PedidoExcepcion, ParseException{
        
        //Realizamos una instancia de deposito, la cual se encarga de verificar la disponibilidad de materias primas, entre otras funciones
        Deposito deposito = new Deposito("Quintero Julian");
        
        
           
        List<Pedido> pedidos = null; 
        //En esta seccion traer desde BD los pedidos existentes
        Produccion produccion = new Produccion("Martinez Diego",pedidos);
        boolean flag = true;
        
        Scanner scanner = new Scanner(System.in);
        System.out.flush();
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
                     char decision = 's';
                    //Para agregar un producto a un pedido, primero debemos comprobar si existen las materias primas
                    //necesarias para su elaboracion
                    
                    List<Producto> productos = new ArrayList(); 
                        System.out.println("Ingrese tipo de entrega sucursal / domicilio");
                        String tipoEntrega = scanner.nextLine();
                        
                    
                        
                         while(decision == 's'){
                         System.out.println("Ingrese codigo de producto a agregar al pedido");
                         int codProd = scanner.nextInt();
                          System.out.println("Ingrese cantidad del producto solicitado");
                         int cantProd = scanner.nextInt();
                         
                         boolean materiaPrimaDisponible = deposito.verificarMateriaPrima(codProd);
                         
                         System.out.println("Ingrese precio del producto");
                         double precioProd = scanner.nextDouble();
                         
                         if(materiaPrimaDisponible){
                          Producto p = new Producto(codProd,"producto con codigo "+codProd,precioProd,cantProd);   
                          productos.add(p);
                          System.out.println("Materias primas disponibles para elaborar el producto, producto agregado a pedido con exito");
                          
                         }else{
                         System.out.println("Materias primas no disponibles para elaborar el producto");
                        }
                        

                         
                      System.out.println("Desea continuar cargando productos al pedido? (s/n)");
                      decision = scanner.next().charAt(0);
                      
                     }
                         
                    
                       
                      System.out.println("Ingrese apellido y nombre del cliente");
                      String apenomCli = scanner.nextLine();
                      
                      System.out.println("Ingrese DNI del cliente");
                      int dniCli = scanner.nextInt();
                      
                      System.out.println("Ingrese descripcion");
                      String desc = scanner.nextLine();
                      
                      System.out.println("Ingrese un numero de pedido");
                      int nroPedido = scanner.nextInt();
                      
                     if(tipoEntrega == "sucrsal"){
                         System.out.println("Ingrese numero de sucursal");
                         int nroSucursal = scanner.nextInt(); 
                         
                         System.out.println("Ingrese direccion de sucursal");
                         String dirSucursal = scanner.nextLine(); 
                         
                         System.out.println("Ingrese porcentaje de descuento");
                         double descuento = scanner.nextDouble(); 
                         
                          SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");    
                        System.out.println("ingrese fecha de entrega del producto (dd/mm/aaaa)");
                       String fechaInput = scanner.nextLine();
                     
                       try {
                         Date fecha = dateFormat.parse(fechaInput);
                         Pedido pedido = new PedidoEnSucursal(desc,dniCli,apenomCli,nroPedido,"pendiente",tipoEntrega,fecha,nroSucursal,dirSucursal);
                         produccion.agregarPedidos(pedido);
                       } catch (ParseException e) {
                              System.out.println("Formato de fecha incorrecto. Por favor, usa el formato dd/MM/yyyy.");
                         }
                         
                         
                     }
                      
                 
                      
                      
                      
    }
                     
                         
                   
                     
                    
                                          
                }
            }
            
        }
        
    
}
