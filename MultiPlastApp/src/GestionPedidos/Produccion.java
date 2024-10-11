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
    
    public Produccion(String encargado, List<Pedido> pedidos){
        this.encargado = encargado;
        this.pedidos = pedidos; 
    }
    
    public void agregarPedidos(Pedido pedido){
        pedidos.add(pedido);
    }
    
    public void iniciarPedido(int codPedido) throws PedidoExcepcion{
        if(codPedido >=1 && codPedido <= pedidos.size()){
            pedidos.get(codPedido - 1).iniciarPedido();
        }else{
            System.out.println("Numero de pedido incorrecto...");
        }
    }
    
    public void finalizarPedido(int codPedido) throws PedidoExcepcion{
        if(codPedido >=1 && codPedido <= pedidos.size()){
            pedidos.get(codPedido - 1).finalizarPedido();
        }else{
            System.out.println("Numero de pedido incorrecto...");
        
        }
       
    }
    
    public void cancelarPedido(int codPedido) throws PedidoExcepcion{
        if(codPedido >=1 && codPedido <= pedidos.size()){
            pedidos.get(codPedido - 1).cancelarPedido();
        }else{
            System.out.println("Numero de pedido incorrecto...");
      }
    }
    
    public List<Pedido> listarPedidos(){
        return pedidos;
    }

    public String getEncargado() {
        return encargado;
    }

   

    public List<Pedido> getPedidos() {
        return pedidos;
    }
    
    
    
}
