/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import GestionPedidos.Producto;
import conexion.PedidoDB;
import java.util.InputMismatchException;
import java.util.List;
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
        System.out.println("Ingrese DNI del cliente");
        int dniCli = scanner.nextInt();
        scanner.nextLine();
        return dniCli;                   
    }
    
    
    public String solicitarApeNomCliente(){
        
        System.out.println("Ingrese apellido y nombre del cliente");
        String apeNomCli = scanner.next();
        scanner.nextLine();
        return apeNomCli;
    }
        
    public int solicitarCodProducto(){
    
        System.out.println("Ingrese codigo de producto");
        return scanner.nextInt();
    } 
     
    public String solicitarDescripcionPedido() {
        
        System.out.println("Ingrese descripcion");
        String descripcion = scanner.nextLine();
       
        return descripcion;
    } 
    
    public String solicitarFechaEntrega(){
       
        System.out.println("Ingrese fecha de entrega formato AAAA/MM/DD");
        String fechaEntrega = scanner.next();
        
        scanner.nextLine();
        return fechaEntrega;
    }
    
      public String solicitarTipoEntrega(){
      
        System.out.println("Ingrese tipo de entrega: 1 - Retiro en sucursal  2 - Envio a domicilio");
        String tipoEntrega = scanner.next();
        return tipoEntrega;
    }
      
    public String solicitarEstado(){
       
        System.out.println("Ingrese estado del pedido");
        String estado = scanner.next();
        
        return estado;
    }
    
      public double solicitarImporte(){
       
        System.out.println("Ingrese importe del pedido");
        double importe = scanner.nextDouble();
        
        return importe;
    }
     
     public int solicitarNroSucursal(){
        
         System.out.println("Ingrese numero de sucursal");
         int nroSuc = scanner.nextInt();
       
         return nroSuc;
     }   
     
       public String solicitarDireccionCliente(){
       
        System.out.println("Ingrese direccion del cliente");
        String direccionCli = scanner.nextLine();
        
        
        return direccionCli;
    }
    
     public String solicitarDireccionSucursal(){
        
         System.out.println("Ingrese direccion de la sucursal");
        String direccionSuc = scanner.next();
       
        return direccionSuc;
    }
    
     public double solicitarPorcentajeDescuento(){
         scanner.next();
         System.out.println("Ingrese porcentaje de descuento");
         double porcentajeDescuento = scanner.nextDouble();
         
         return porcentajeDescuento;
     }
    
     public double solicitarPorcentajeEnvio(){
        
         System.out.println("Ingrese porcentaje adicional de envio");
         double porcentajeEnvio = scanner.nextDouble();
         System.out.println(porcentajeEnvio);
      
         return porcentajeEnvio;
     }
    
     
     
     public int solicitarNroPedido(){
         System.out.println("Ingrese numero de pedido");
         int nroPedido = scanner.nextInt();
         return nroPedido;
     }
     
     
     public void listarPedidos(List<PedidoDB> pedidos){
         
         if(pedidos.isEmpty()){
             System.out.println("No hay pedidos disponibles...");
         }else{
             for(PedidoDB pedido : pedidos){
             System.out.println("Numero de pedido : "+pedido.getNroPedido());
             System.out.println("DNI del cliente : "+pedido.getDniCliente());
             System.out.println("Fecha de entrega : "+pedido.getFechaEntrega());
             System.out.println("Descripcion : "+pedido.getDescripcion());
             System.out.println("Estado : "+pedido.getEstado());
             System.out.println("Tipo De Entrega : "+pedido.getTipoEntrega());
             System.out.println("Importe : "+pedido.getImporte());
             System.out.println("=================================================");
         }
         }
         
     }
     
     public void mostrarPedido(PedidoDB pedido){
         if(pedido == null){
             System.out.println("El pedido no existe...");
         }else{
             System.out.println("Numero de pedido : "+pedido.getNroPedido());
             System.out.println("DNI del cliente : "+pedido.getDniCliente());
             System.out.println("Fecha de entrega : "+pedido.getFechaEntrega());
             System.out.println("Descripcion : "+pedido.getDescripcion());
             System.out.println("Estado : "+pedido.getEstado());
             System.out.println("Tipo De Entrega : "+pedido.getTipoEntrega());
             System.out.println("Importe : "+pedido.getImporte());
             System.out.println("=================================================");
         }
     }
}
