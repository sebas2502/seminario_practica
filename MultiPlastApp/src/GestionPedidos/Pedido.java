/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionPedidos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sebac
 */
public abstract class Pedido {
    
   protected int nroPedido;
   protected String descripcion;
   protected int dniCliente;
   protected String apenomCli;
   protected String estado = "pendiente";
   protected List<Producto> productos;
   protected String tipoEntrega = "";
   protected String fechaEntrega = "";
   protected Double importe;
 
   
   public Pedido(String descripcion, int dniCliente, String apenomCli, String estado, String tipoEntrega, String fechaEntrega){
     
       this.descripcion = descripcion;
       this.dniCliente = dniCliente;
       this.apenomCli = apenomCli;
       this.estado = estado;
       this.tipoEntrega = tipoEntrega;
       this.fechaEntrega = fechaEntrega;
       this.productos = new ArrayList<>();
    }
   
  
   
   //Metodos publicos
   
   
   public String getEstado(){
       return this.estado;
   }
   
   public String getDescripcion(){
       return descripcion;
   }
   
 

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getDniCli(){
     
        return dniCliente;
    }
    
    public String getTipoEntrega(){
      return tipoEntrega;
    }
    
    public double getImporte(){
        return importe;
    }
 
    public String getFecha(){
       
        return fechaEntrega;
   }
   
   public void agregarProductos(List<Producto> prods){
      
       productos.addAll(prods);
       
   }
   
   public void listarProductos(){
       for(Producto producto : this.productos){
        System.out.println("=> "+producto.getNombre() + " " + producto.getCantidad() + " unidad/es");
       }
   }
   
   public void iniciar() throws PedidoExcepcion{
       if( estado == "pendiente" ){
            estado = "en proceso";
            System.out.println("El pedido del cliente "+nroPedido+" comenzo a elaborarse");
       }else{
           if(estado == "cancelado"){
               throw new PedidoExcepcion("El pedido se ha cancelado");
           }else{
               if(estado == "finalizado"){
                   throw new PedidoExcepcion("El pedido se ha finalizado");
               }else{
                   throw new PedidoExcepcion("El pedido ya se finalizo y ha sido despachado");
               }
           }
       }
   }
   
   public void finalizar() throws PedidoExcepcion{
       if(estado == "en proceso"){
           estado  = "finalizado";
          System.out.println("Se finalizo el pedido con exito...");
       }else{
           if(estado == "pendiente"){
               throw new PedidoExcepcion("El pedido "+nroPedido+" aun no comenzo a elaborarse");
           }else{
               if(estado == "cancelado"){
                 throw new PedidoExcepcion("El pedido "+nroPedido+" se ha cancelado");
               }else{
                   throw new PedidoExcepcion("El pedido "+nroPedido+" ya se ha finalizado y despachado");
               }
           }
       }
   }
   
   public void cancelar() throws PedidoExcepcion{
       if(estado == "pendiente"){
           this.estado = "cancelado";
           System.out.println("El pedido "+nroPedido+" se ha cancelado");
       }else{
           if(estado == "en proceso"){
               throw new PedidoExcepcion("El pedido "+nroPedido+" ya esta en produccion");
           }else{
               if(estado == "finalizado"){
                   throw new PedidoExcepcion("El pedido "+nroPedido+" no puede cancelarse porque ya esta finalizado");
               }else{
                   throw new PedidoExcepcion("El pedido "+nroPedido+" ya se ha despachado");
               }
           }
               
       } 
   }
   
    public void despachar() throws PedidoExcepcion{
        if(estado == "pendiente"){
          throw new PedidoExcepcion("El pedido "+nroPedido+" no ha comenzado a elaborarse");
       }else{
           if(estado == "en proceso"){
               throw new PedidoExcepcion("El pedido "+nroPedido+" todavia esta en produccion");
           }else{
               
               if(estado == "cancelado"){
                 throw new PedidoExcepcion("El pedido "+nroPedido+" se ha cancelado");
               }else{
                   System.out.println("El pedido "+nroPedido+" se ha despachado con exito...");
                   estado = "despachado";
               }
           
               
           }
               
       } 
    }
   
  /* public void actualizarEstado() throws PedidoExcepcion{
       Scanner scanner = new Scanner(System.in);
       boolean flag = true;
       while (flag) {
            System.out.println("===============================================");
            System.out.println("1 - Iniciar Pedido");
            System.out.println("2 - Finalizar Pedido");
            System.out.println("3 - Cancelar Pedido");
            System.out.println("4 - Despachar");
            System.out.println("5 - Volver");
            System.out.println("===============================================");
            System.out.println("Ingrese una opcion: ");
            
            int opcion = scanner.nextInt();
            
            switch(opcion){
                case 1 : iniciarPedido();
                case 2 : finalizarPedido();
                case 3 : cancelarPedido();
                case 4 : Deposito deposito = new Deposito("Quintero Julian");
                         deposito.despachar();
                case 5 : flag = false;
            }
            
        }
   } */
   
   //Metodos abstractos
   public abstract double generarImporte(double porcentaje);
  
    
    
}