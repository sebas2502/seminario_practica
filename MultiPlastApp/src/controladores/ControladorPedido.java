/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import GestionPedidos.Pedido;
import GestionPedidos.Producto;
import conexion.PedidoDB;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import modelos.ModeloPedido;
import vistas.VistaPedido;

/**
 *
 * @author sebac
 */
public class ControladorPedido {
        
       private VistaPedido vista;
       private ModeloPedido modelo;
       
       public ControladorPedido(Connection conexion){
           this.vista = new VistaPedido();
           this.modelo = new ModeloPedido(conexion);
       }
       
       public void registrarPedido(Pedido pedido) throws SQLException{
           modelo.insertarPedido(pedido.getDniCli(),pedido.getFecha(), pedido.getDescripcion(), pedido.getEstado(), pedido.getTipoEntrega(), (float) pedido.getImporte());
           System.out.println("Pedido registrado en base de datos...!");
       }
       
       public void iniciarPedido()throws SQLException{
           int nroPedido =vista.solicitarNroPedido();
           
           modelo.iniciarPedido(nroPedido);
          
       }
       
       
       public void cancelarPedido() throws SQLException{
           int nroPedido = vista.solicitarNroPedido();
           modelo.cancelarPedido(nroPedido);
       }
       
       
       public void finalizarPedido() throws SQLException{
           int nroPedido = vista.solicitarNroPedido();
           modelo.finalizarPedido(nroPedido);
       }
       
       
       public void despacharPedido() throws SQLException{
           int nroPedido = vista.solicitarNroPedido();
           modelo.despacharPedido(nroPedido);
       }
       
       public List<PedidoDB> listarPedidos() throws SQLException{   
        
         return modelo.listarPedidos();
          
         
       }



       public PedidoDB buscarPedido(int nroPedido) throws SQLException{
          return modelo.consultarPedido(nroPedido);
           
       }
       
      public void eliminarPedido(int nroPedido)throws SQLException{
          modelo.eliminarPedido(nroPedido);
      } 
}
