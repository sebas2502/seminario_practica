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
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha1 = null;
        Date fecha2 = null;
        Date fecha3 = null;
        Date fecha4 = null;
       try{
          fecha1 = formatoFecha.parse("30/10/2024");
          fecha2 = formatoFecha.parse("01/11/2024");
          fecha3 = formatoFecha.parse("16/11/2024");
          fecha4 = formatoFecha.parse("22/11/2024");
          
          
       }catch(ParseException e){e.printStackTrace();}
        
         //En este apartado, creamos unos pedidos para almacenar en una lista simulando una base de datos 
         Pedido p1 = new PedidoEnSucursal("banios quimicos para evento",40263304,"Contreras Ricardo",1,"en proceso","en sucursal",fecha1,1,"Avenida 9 De Julio 1234");
         Pedido p2 = new PedidoEnSucursal("Containers de basuras industrial, tachos de basuras",12263304,"Gomez Ramon",2,"pendiente","en sucursal",fecha2,2,"Avenida Independencia 34");
         Pedido p3 = new PedidoAdomicilio("bolsones de plastico x 40 unidades",11263304,"Duarte Manuel",3,"pendiente","a domicilio",fecha3,5000);
         Pedido p4 = new PedidoAdomicilio("Tubos PVC 10mm de diametro x 3m x 100 unidades",43263304,"Correa Maira",4,"En proceso","a domicilio",fecha4,4200);
        
        
       
        
        //Agregamos a la lista de pedidos, los pedidos creados anteriormente
        
        Produccion produccion = new Produccion("Correa Diego"); //Instancia de la clase produccion con su constructor que recibe como valor el "encargado" de produccion
        
        produccion.agregarPedido(p1);
        produccion.agregarPedido(p2);
        produccion.agregarPedido(p3);
        produccion.agregarPedido(p4);
        
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
                    scanner.nextLine();
                    
                        System.out.println("Ingrese tipo de entrega: 1 - sucursal / 2 - domicilio");
                    
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
                          p.setNombre("Producto con codigo "+codProd);
                          productos.add(p);
                          System.out.println("Materias primas disponibles para elaborar el producto, producto agregado a pedido con exito");
                          
                         }else{
                         System.out.println("Materias primas no disponibles para elaborar el producto");
                        }
                        

                         scanner.nextLine();
                         System.out.println("Desea continuar cargando productos al pedido? (s/n)");
                         decision = scanner.next().charAt(0);
                      
                     }
                         
                    
                      scanner.nextLine();
                      System.out.println("Ingrese apellido y nombre del cliente");
                      String apenomCli = scanner.nextLine();
                      
                      System.out.println("Ingrese DNI del cliente");
                      int dniCli = scanner.nextInt();
                      
                      scanner.nextLine();
                      System.out.println("Ingrese descripcion");
                      String desc = scanner.nextLine();
                      
                      System.out.println("Ingrese un numero de pedido");
                      int nroPedido = scanner.nextInt();
                      scanner.nextLine();
                      
                      
                    
                      if(tipoEntrega.equals("1")){
                         System.out.println("Ingrese numero de sucursal");
                         int nroSucursal = scanner.nextInt(); 
                      
                         scanner.nextLine();
                         System.out.println("Ingrese direccion de sucursal");
                         String dirSucursal = scanner.nextLine(); 
                         
                         System.out.println("Ingrese porcentaje de descuento");
                         double descuento = scanner.nextDouble(); 
                         
                         scanner.nextLine();
                          SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");    
                        System.out.println("ingrese fecha de entrega del pedido (dd/mm/aaaa)");
                       String fechaInput = scanner.nextLine();
                     
                       try {
                         Date fecha = dateFormat.parse(fechaInput);
                         Pedido pedido = new PedidoEnSucursal(desc,dniCli,apenomCli,nroPedido,"pendiente",tipoEntrega,fecha,nroSucursal,dirSucursal);
                         produccion.agregarPedido(pedido);
                         System.out.println("Pedido registrado con exito...");
                         
                         
                         
                       } catch (ParseException e) {
                              System.out.println("Formato de fecha incorrecto. Por favor, usa el formato dd/MM/yyyy.");
                         }
                         
                         
                     }else{
                          
                          if(tipoEntrega.equals("2")){
                              System.out.println("Ingrese domicilio del cliente");
                              String domCli = scanner.nextLine();
                          
                              System.out.println("Ingrese costo adicional de envio");
                              double costoEnvio = scanner.nextDouble();
                              
                              scanner.nextLine();
                              SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");    
                              System.out.println("ingrese fecha de entrega del pedido (dd/mm/aaaa)");
                              String fechaInput = scanner.nextLine();
                              
                              try {
                             Date fecha = dateFormat.parse(fechaInput);
                             Pedido pedido = new PedidoAdomicilio(desc,dniCli,apenomCli,nroPedido,"pendiente",tipoEntrega,fecha,costoEnvio);
                             produccion.agregarPedido(pedido);
                             System.out.println("Pedido registrado con exito...");
                             System.out.println("Lista de productos agregados al pedido");
                             System.out.println("=======================================");
                             
                       } catch (ParseException e) {
                              System.out.println("Formato de fecha incorrecto. Por favor, usa el formato dd/MM/yyyy.");
                         }
                              
                              
                          }else{
                          System.out.println("Opcion no disponible...");
                          }
                          
                      }
                      
                 
                      
                      
                      
    }
                
          case 4 -> {
              System.out.flush();
              System.out.println("       Lista de pedidos");
              System.out.println("=========================================================");
              produccion.listarPedidos();
              
          }           
                         
                   
                     
                    
                                          
                }
            }
            
        }
        
    
}
