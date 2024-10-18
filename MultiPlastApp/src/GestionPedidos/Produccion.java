/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionPedidos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebac
 */
public class Produccion {
    private String encargado;
    private List<Pedido> pedidos; 
    
    public Produccion(String encargado){
        this.encargado = encargado;
        this.pedidos = new ArrayList<>();
        
    }
    
    public void agregarPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }
    
    public void iniciarPedido(Pedido pedido) throws PedidoExcepcion{
        pedido.iniciar();
    }
    
    public void finalizarPedido(Pedido pedido) throws PedidoExcepcion{
       pedido.finalizar();
       
    }
    
    public void cancelarPedido(Pedido pedido) throws PedidoExcepcion{
       pedido.cancelar();
    }
    

    
    public void listarPedidos(){
        for(Pedido pedido : pedidos){
            System.out.println("Numero de pedido: "+pedido.nroPedido);
            System.out.println("Cliente: "+pedido.apenomCli);
            System.out.println("Descripcion: "+pedido.descripcion);
            System.out.println("Estado: "+pedido.getEstado());
            System.out.println("Fecha de entrega: "+pedido.getFecha());
            System.out.println("==============================================================");
        }
    }

    public String getEncargado() {
        return encargado;
    }

   

    public List<Pedido> getPedidos() {
        return pedidos;
    }
    
    
    
}
