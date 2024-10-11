/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionPedidos;

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
   protected List<Producto> productos = new ArrayList<>();
   protected String tipoEntrega = "";
   protected Date fechaEntrega = new Date();
   protected boolean materiaPrimaDisponible = false;
   
   public Pedido(String descripcion, int dniCliente, String apenomCli, List<Producto> productos, int nroPedido, String estado, boolean materiaPrimaDisponible, String tipoEntrega, Date fechaEntrega){
       this.nroPedido = nroPedido;
       this.descripcion = descripcion;
       this.dniCliente = dniCliente;
       this.apenomCli = apenomCli;
       this.productos = productos;
       this.estado = estado;
       this.tipoEntrega = tipoEntrega;
       this.fechaEntrega = fechaEntrega;
    }
   
   Deposito deposito = new Deposito("Quintero Julian");
   
   //Metodos publicos
   
   
   
   public void agregarProductos(){
       Producto p1 = new Producto("Pileta embutida 5 x 10",600000,1);
       Producto p2 = new Producto("Baños quimicos",200000,4);
       productos.add(p1);
       productos.add(p2);
   }
   
   public void iniciarPedido() throws PedidoExcepcion{
       if( deposito.verificarMateriaPrima() ){
            estado = "en proceso";
            System.out.println("El pedido "+nroPedido+" comenzó a elaborarse");
       }else{
           throw new PedidoExcepcion("No hay materia prima disponible para comenzar a elaborar el pedido "+nroPedido);
       }
   }
   
   public void finalizarPedido() throws PedidoExcepcion{
       if(estado == "en proceso"){
           estado  = "finalizado";
           System.out.println("Se finalizó el pedido "+nroPedido);
       }else{
           if(estado == "pendiente"){
               throw new PedidoExcepcion("El pedido "+nroPedido+" aun no comenzó a elaborarse");
           }else{
               throw new PedidoExcepcion("El pedido "+nroPedido+" se ha finalizado con exito");
           }
       }
   }
   
   public void cancelarPedido() throws PedidoExcepcion{
       if(estado == "pendiente"){
           System.out.println("El pedido "+nroPedido+" se ha cancelado");
       }else{
           if(estado == "en proceso"){
               throw new PedidoExcepcion("El pedido "+nroPedido+" no puede cancelarse porque ya está en produccion");
           }else{
               throw new PedidoExcepcion("El pedido "+nroPedido+" no puede cancelarse porque ya está finalizado");
           }
               
       } 
   }
   
   public void actualizarEstado() throws PedidoExcepcion{
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
                case 4 : deposito.despachar();
                case 5 : flag = false;
            }
            
        }
   }
   
   //Metodos abstractos
   public abstract double generarImporte();
   public abstract void procesarPedido();
    
    
}