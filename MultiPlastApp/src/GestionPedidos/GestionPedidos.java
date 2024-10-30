/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionPedidos;

import controladores.ControladorPedido;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import vistas.VistaPedido;


/**
 *
 * @author sebac
 */
public class GestionPedidos {
    

  
    
    public static void main(String[] args) throws PedidoExcepcion, ParseException{
        
        //Realizamos una instancia de deposito, la cual se encarga de verificar la disponibilidad de materias primas, entre otras funciones
        Deposito deposito = new Deposito("Quintero Julian");
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
     
        
        Produccion produccion = new Produccion("Correa Diego");
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
            System.out.println("(8) Eliminar pedido");
            System.out.println("(9) Salir");
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
                    
                        
                        VistaPedido vista = new VistaPedido();
                    
                        //Se solicita la modalidad de entrega del pedido
                                          
                        String tipoEntrega = vista.solicitarTipoEntrega();
                    
                        
                        
                         while(decision == 's'){
                         
                         
                         System.out.println("Ingrese nombre del producto");
                         scanner.next();
                         String nomProd = scanner.nextLine();
                         
                         System.out.println("Ingrese codigo del producto");
                         int codProd = scanner.nextInt();
                         
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
                      
                      
                      String apenomCli = vista.solicitarApeNomCliente();                     
                      int dniCliente = vista.solicitarDniCliente();
                      String descripcion = vista.solicitarDescripcionPedido();
                      
                                        
                      
                    
                      if(tipoEntrega.equals("1")){
                       
                         int nroSucursal = vista.solicitarNroSucursal(); 
                         String dirSucursal = vista.solicitarDireccionSucursal();
                         double descuento = vista.solicitarPorcentajeDescuento();
                         String fechaEntrega = vista.solicitarFechaEntrega();
                         
                         
                                            
                         
                         Pedido pedido = new PedidoEnSucursal(descripcion,dniCliente,apenomCli,"pendiente",tipoEntrega,fechaEntrega,nroSucursal,dirSucursal);
                         pedido.agregarProductos(productos);
                         
                         pedido.importe = pedido.generarImporte(descuento);
                         produccion.agregarPedido(pedido);
                        try(Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiplastpedidos","root","")){
                                 
                                 ControladorPedido controlador = new ControladorPedido(conexion);
                                 controlador.registrarPedido(pedido);
                                 
                             }catch(SQLException e){
                                  System.err.println("Error de conexión a la base de datos: " + e.getMessage());
                             }
                             
                         
                         
                         System.out.println("Pedido registrado con exito...");
                         
                         
                      
                     
                         
                         
                     }else{
                          
                          if(tipoEntrega.equals("2")){
                              
                              String domCli = vista.solicitarDireccionCliente();
                          
                              double porcentajeEnvio = vista.solicitarPorcentajeEnvio();
                                    
                                     
                              String fechaEntrega = vista.solicitarFechaEntrega();                            
                             
                             
                             Pedido pedido = new PedidoAdomicilio(descripcion,dniCliente,apenomCli,"pendiente",tipoEntrega,fechaEntrega,porcentajeEnvio,domCli);
                             pedido.agregarProductos(productos);
                             pedido.importe = pedido.generarImporte(porcentajeEnvio);
                             System.out.println(pedido.importe);
                             produccion.agregarPedido(pedido);
                             
                             try(Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiplastpedidos","root","")){
                                 
                                 ControladorPedido controlador = new ControladorPedido(conexion);
                                 controlador.registrarPedido(pedido);
                                 
                             }catch(SQLException e){
                                  System.err.println("Error de conexión a la base de datos: " + e.getMessage());
                             }
                             
                             System.out.println("Pedido registrado con exito...");
                             System.out.println("Lista de productos agregados al pedido");
                             System.out.println("=======================================");
                             
                     
                              
                              
                          }else{
                          System.out.println("Opcion no disponible...");
                          }
                          
                      
                      }
                         
                     
                      }
                      
                 
                      
                      
                      
    }
                
                case 2 -> {
                    
                     
                             try(Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiplastpedidos","root","")){
                                 
                                 ControladorPedido controlador = new ControladorPedido(conexion);
                                 controlador.iniciarPedido();
                                 
                             }catch(SQLException e){
                                  System.err.println("Error de conexión a la base de datos: " + e.getMessage());
                             }
                    
                }
                
                case 3 -> {
                            try(Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiplastpedidos","root","")){
                                 
                                 ControladorPedido controlador = new ControladorPedido(conexion);
                                 controlador.finalizarPedido();
                                 
                             }catch(SQLException e){
                                  System.err.println("Error de conexión a la base de datos: " + e.getMessage());
                             }
                }
                
                case 4 -> {
                     try(Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiplastpedidos","root","")){
                                 
                                 ControladorPedido controlador = new ControladorPedido(conexion);
                                                                  
                                 VistaPedido vista = new VistaPedido();
                                 vista.listarPedidos(controlador.listarPedidos());
                             }catch(SQLException e){
                                  System.err.println("Error de conexión a la base de datos: " + e.getMessage());
                             }
                }
                
                case 5 -> {
                     try(Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiplastpedidos","root","")){
                                 
                                 ControladorPedido controlador = new ControladorPedido(conexion);
                                 VistaPedido vista = new VistaPedido();
                                 int nroPedido = vista.solicitarNroPedido();
                                 vista.mostrarPedido(controlador.buscarPedido(nroPedido));
                                
                             }catch(SQLException e){
                                  System.err.println("Error de conexión a la base de datos: " + e.getMessage());
                             }
                }
                
                case 6 -> {
                    try(Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiplastpedidos","root","")){
                                 
                              ControladorPedido controlador = new ControladorPedido(conexion);
                              controlador.despacharPedido();
                                 
                             }catch(SQLException e){
                                  System.err.println("Error de conexión a la base de datos: " + e.getMessage());
                             }
                }
                
                case 7 -> {
                    try(Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiplastpedidos","root","")){
                                 
                                 
                                 ControladorPedido controlador = new ControladorPedido(conexion);
                                 controlador.cancelarPedido();
                                 
                             }catch(SQLException e){
                                  System.err.println("Error de conexión a la base de datos: " + e.getMessage());
                             }
                }
                
                case 8 -> {
                     try(Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/multiplastpedidos","root","")){
                                  VistaPedido vista = new VistaPedido();
                                  ControladorPedido controlador = new ControladorPedido(conexion);
                                  controlador.eliminarPedido(vista.solicitarNroPedido());
                             }catch(SQLException e){
                                  System.err.println("Error de conexión a la base de datos: " + e.getMessage());
                             }
                }
                
                
                case 9 ->{
                    

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
