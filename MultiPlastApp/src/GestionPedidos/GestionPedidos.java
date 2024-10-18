/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionPedidos;

import java.io.IOException;
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
         Pedido pedido1 = new PedidoEnSucursal("pedido de banios quimicos para evento",40263304,"Contreras Ricardo",1,"en proceso","en sucursal",fecha1,1,"Avenida 9 De Julio 1234");
         Pedido pedido2 = new PedidoEnSucursal("containers de basura para minera de salta, tachos de basuras",12263304,"Gomez Ramon",2,"pendiente","en sucursal",fecha2,2,"Avenida Independencia 34");
         Pedido pedido3 = new PedidoAdomicilio("bolsones para utencilios varios",11263304,"Duarte Manuel",3,"pendiente","a domicilio",fecha3,5000,"Rolon 1234");
         Pedido pedido4 = new PedidoAdomicilio("tuberia plastica para instalacion de cloaca",43263304,"Correa Maira",4,"en proceso","a domicilio",fecha4,4200,"Madariaga 1822");
        
        //Aqui creamos unos productos que luego seran agreagdos a las listas de productos
        Producto prd1 = new Producto(1,"banios quimicos",600000,6);
        Producto prd2 = new Producto(2,"container de basura industrial",1000000,2);
        Producto prd3 = new Producto(3,"bolsones de plastico 1mt x 0,5mt",600,600);
        Producto prd4 = new Producto(4,"Tubos PVC 10mm de diametro x 3m",5000,100);
        Producto prd5 = new Producto(5,"tachos de basura chico",1500,10);
        Producto prd6 = new Producto(6,"bujes de grilon 9mm x 10cm",7000,10);
        
        //Aqui creamos la lista de cada pedido
        List<Producto> lista1 = new ArrayList<>();
        List<Producto> lista2 = new ArrayList<>();
        List<Producto> lista3 = new ArrayList<>();
        List<Producto> lista4 = new ArrayList<>();
        
        //Aqui agreagmos los productos a cada lista
        
        //A la lista 1 agreamos los productos prd1 y prd2
        lista1.add(prd1);
        lista1.add(prd5);
        
               
        
        //A la lista 2 agreamos el producto prd2
        lista2.add(prd2);
        
        //A la lista 3 agreamos el producto prd3
        lista3.add(prd3);
        
        //A la lista 4 agreamos los productos prd4 y prd6
        lista4.add(prd4);
        lista4.add(prd6);
        
        
        
        /*Aqui agreagamos cada lista de productos a su pedido correspondiente y generamos el importe
          dandole como parametro el porcentaje de costo de envio que se suma al importe final del pedido
          si el mismo es despachado al domicilio del cliente
          o en su defecto un porcentaje de descuento si el pedido es retirado por sucursal
        */        
        pedido1.agregarProductos(lista1); pedido1.importe = pedido1.generarImporte(10);
        pedido2.agregarProductos(lista2); pedido2.importe = pedido2.generarImporte(5);
        pedido3.agregarProductos(lista3); pedido3.importe = pedido3.generarImporte(10);
        pedido4.agregarProductos(lista4); pedido4.importe = pedido4.generarImporte(2);
        
        
        
   
        
        
        
        Produccion produccion = new Produccion("Correa Diego"); //Instancia de la clase produccion con su constructor que recibe como valor el "encargado" de produccion
        
        //Agregamos a la lista de pedidos, los pedidos creados anteriormente
        produccion.agregarPedido(pedido1);
        produccion.agregarPedido(pedido2);
        produccion.agregarPedido(pedido3);
        produccion.agregarPedido(pedido4);
        
        boolean flag = true;
        
        Scanner scanner = new Scanner(System.in);
        
        while (flag) {
            System.out.println("===============================================");
            System.out.println("********Bienvenido a MultiPlast System*********");
            System.out.println("===============================================");
            System.out.println("(1) Agregar Pedido");
            System.out.println("(2) Iniciar Pedido");
            System.out.println("(3) Finalizar Pedido");
            System.out.println("(4) Listar pedidos");
            System.out.println("(5) Buscar Pedido");
            System.out.println("(6) Despachar Pedido");
            System.out.println("(7) Cancelar Pedido");
            System.out.println("(8) Salir");
            System.out.println("===============================================");
            System.out.println("Ingrese una opcion: ");
            
            int opcion = scanner.nextInt();
             
            
            switch(opcion){
                case 1 -> {
                     char decision = 's';
                    //Para agregar un producto a un pedido, primero debemos comprobar si existen las materias primas
                    //necesarias para su elaboracion
                    boolean seAgregaronProductos = false;
                    
                    List<Producto> productos = new ArrayList(); 
                    scanner.nextLine();
                        
                        //Se solicita la modalidad de entrega del pedido
                        System.out.println("Ingrese tipo de entrega: 1 - sucursal / 2 - domicilio");
                    
                        String tipoEntrega = scanner.nextLine();
                    
                    
                        
                         while(decision == 's'){
                         System.out.println("Ingrese codigo de producto a agregar al pedido");
                         int codProd = scanner.nextInt();
                         scanner.nextLine();
                         System.out.println("Ingrese nombre del producto");
                         String nomProd = scanner.nextLine();
                         
                         System.out.println("Ingrese cantidad del producto solicitado");
                         int cantProd = scanner.nextInt();
                         
                         /* Desde la clase deposito mediante el metodo verificarMateriaPrima  simulamos la disponibilidad
                            de materias primas de los productos para la elaboracion de un pedido */
                         boolean materiaPrimaDisponible = deposito.verificarMateriaPrima(codProd);
                         
                         System.out.println("Ingrese precio del producto");
                         double precioProd = scanner.nextDouble();
                         
                         
                         if(materiaPrimaDisponible){
                          Producto p = new Producto(codProd,nomProd,precioProd,cantProd);
                          
                          productos.add(p);
                          System.out.println("Materias primas disponibles para elaborar el producto, producto agregado a pedido con exito");
                          
                          seAgregaronProductos = true;
                          
                         }else{
                         System.out.println("Materias primas no disponibles para elaborar el producto");
                        }
                        

                         
                         System.out.println("Desea continuar cargando productos al pedido? (s/n)");
                         
                         decision = scanner.next().charAt(0);
                         
                      
                     }
                         
                         
                      if(seAgregaronProductos == false){
                          break;
                      }else{
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
                         pedido.agregarProductos(productos);
                         
                         pedido.importe = pedido.generarImporte(descuento);
                         produccion.agregarPedido(pedido);
                         
                         System.out.println("Pedido registrado con exito...");
                         
                         
                         
                       } catch (ParseException e) {
                              System.out.println("Formato de fecha incorrecto. Por favor, usa el formato dd/MM/yyyy.");
                         }
                         
                         
                     }else{
                          
                          if(tipoEntrega.equals("2")){
                              System.out.println("Ingrese domicilio del cliente");
                              String domCli = scanner.nextLine();
                          
                              System.out.println("Ingrese porcentaje adicional de envio");
                              double costoEnvio = scanner.nextDouble();
                              
                              scanner.nextLine();
                              SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");    
                              System.out.println("ingrese fecha de entrega del pedido (dd/mm/aaaa)");
                              String fechaInput = scanner.nextLine();
                              
                              try {
                             Date fecha = dateFormat.parse(fechaInput);
                             Pedido pedido = new PedidoAdomicilio(desc,dniCli,apenomCli,nroPedido,"pendiente",tipoEntrega,fecha,costoEnvio,domCli);
                             pedido.agregarProductos(productos);
                             pedido.importe = pedido.generarImporte(costoEnvio);
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
                      
                 
                      
                      
                      
    }
                
                case 2 -> {
              
              System.out.println("Ingrese numero de pedido");
              int nroPedido  = scanner.nextInt();
              
            
        
              boolean pedidoEncontrado = false;
              for(Pedido pedido : produccion.getPedidos()){
                   if (pedido.getNro() == nroPedido) {
                       pedidoEncontrado = true;
                      
                       try{
                           //Iniciamos un pedido manejando los errores con excepciones
                           produccion.iniciarPedido(pedido);
                       }catch(PedidoExcepcion e){
                          System.out.println("Error al iniciar el pedido");
                          System.out.println("Error: "+e.getMessage());
                       }
                       
                      
              }}
              
              
               if(pedidoEncontrado == false){
                 System.out.println("El pedido no existe...");
              }
              
           
          }      
                          
                case 3 -> {
            
              System.out.println("Ingrese numero de pedido");
              int nroPedido  = scanner.nextInt();
              
            
             boolean pedidoEncontrado = false;
              
              for(Pedido pedido : produccion.getPedidos()){
                   if (pedido.getNro() == nroPedido) {
                       
                      try{
                          produccion.finalizarPedido(pedido);
                      }catch(PedidoExcepcion e){
                          System.out.println("Error al finalizar el pedido");
                          System.out.println("Error: " + e.getMessage());
                      }
                      
                      pedidoEncontrado = true;
                    }
              
              }
              if(pedidoEncontrado == false){
                 System.out.println("El pedido no existe...");
              }
          }
                          
                case 4 -> {
                    System.out.flush();
                    System.out.println("       Lista de pedidos");
                    System.out.println("=========================================================");
                    produccion.listarPedidos();
              
                 }   
                                
                case 5 -> {
                  System.out.println("Ingrese numero de pedido");
                  int nroPedido  = scanner.nextInt();
              
              
            
                    boolean pedidoEncontrado = false;
                    List<Pedido> pedidos = produccion.getPedidos();
                    for(Pedido pedido : pedidos){
                         if (pedido.nroPedido == nroPedido) {
                           pedidoEncontrado = true;
                           System.out.println("========================================");
                           System.out.println("Pedido numero: " + nroPedido);
                           System.out.println("Cliente:  "+pedido.apenomCli);
                           System.out.println("Estado: "+pedido.estado);
                           System.out.println("Fecha de entrega: "+pedido.getFecha());
                           System.out.println("Productos:");
                           pedido.listarProductos();
                           System.out.println("Importe: "+pedido.importe);
                           
                           System.out.println("========================================");
                           break;
                    }

                    }

                    if(!pedidoEncontrado){
                        System.out.println("El pedido no existe, vuelva al menu principal e ingrese nuevamente el numero de pedidos");
                    }
          }
                               
                case 6 -> {
              
                    System.out.println("Ingrese numero de pedido");
                   int nroPedido  = scanner.nextInt();



                   boolean pedidoEncontrado = false;
                   for(Pedido pedido : produccion.getPedidos()){
                        if (pedido.getNro() == nroPedido) {
                            pedidoEncontrado = true;
                            
                            try{
                              deposito.despacharPedido(pedido);
                            }catch(PedidoExcepcion e){
                                System.out.println("Error al despachar el pedido");
                                System.out.println("Error: "+e.getMessage());
                            }


                   }}


                    if(pedidoEncontrado == false){
                      System.out.println("El pedido no existe...");
                   }

               }
                                
                case 7 -> {
                     System.out.println("Ingrese numero de pedido");
                     int nroPedido  = scanner.nextInt();



                   boolean pedidoEncontrado = false;
                   for(Pedido pedido : produccion.getPedidos()){
                        if (pedido.getNro() == nroPedido) {
                            pedidoEncontrado = true;
                            
                            try{
                              produccion.cancelarPedido(pedido);
                            }catch(PedidoExcepcion e){
                                System.out.println("Error al cancelar el pedido");
                                System.out.println("Error: "+e.getMessage());
                            }


                   }
                 }
                }
                
                case 8 ->{
                    

                      System.out.println("Hasta luego!...");
                      flag  = false;
                }    
                
                default -> {
                      System.out.println("Opcion no disponible...");
                }

                    
                                          
                }
            }
            
        }
        
    
}
