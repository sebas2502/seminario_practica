/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

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

/**
 *
 * @author sebac
 */
public class ModeloPedido {
    
    private Connection conexion;
    
    public ModeloPedido(Connection conexion){
        this.conexion = conexion;
    }
    
    //Metodo para insertar un pedido en base de datos
    public void insertarPedido(int dniCliente, String fechaEntrega, String descripcion, String estado,String tipoEntrega, float importe) throws SQLException{
        String query = "INSERT INTO pedido(dniCliente,fechaEntrega,descripcion,estado,tipoEntrega,importe)VALUES (?,?,?,?,?,?)";
        try(PreparedStatement sentencia = conexion.prepareStatement(query)){
            sentencia.setInt(1,dniCliente);
            sentencia.setString(2,fechaEntrega);
            sentencia.setString(3,descripcion);
            sentencia.setString(4,estado);
            sentencia.setString(5,tipoEntrega);
            sentencia.setFloat(6,importe);
            sentencia.executeUpdate();
        }
    }
    
    //Metodo para iniciar un pedido
    public void iniciarPedido(int nroPedido) throws SQLException{
        String query = "UPDATE pedido set estado = ? WHERE nroPedido = ? AND estado = 'pendiente' ";
         try(PreparedStatement sentencia = conexion.prepareStatement(query)){
            sentencia.setString(1,"en proceso");
            sentencia.setInt(2,nroPedido);            
            int filasActualizadas = sentencia.executeUpdate();
            
            if(filasActualizadas > 0){
                System.out.println("El pedido ha comenzado a elaborarse...");
            }else{
                System.out.println("No es posible iniciar el pedido, consulte el estado del mismo...");
            }
        }
    }
    
    //Metodo para finalizar un pedido
    public void finalizarPedido(int nroPedido) throws SQLException{
        String query = "UPDATE pedido set estado = ? WHERE nroPedido = ? AND estado = 'en proceso' ";
         try(PreparedStatement sentencia = conexion.prepareStatement(query)){
            sentencia.setString(1,"finalizado");
            sentencia.setInt(2,nroPedido);            
            int filasActualizadas = sentencia.executeUpdate();
            
            if(filasActualizadas > 0){
                System.out.println("El pedido ha finalzado con exito...");
            }else{
                System.out.println("No es posible finalizar el pedido, consulte el estado del mismo...");
            }
        }
    }

    //Metodo para cancelar un pedido
     public void cancelarPedido(int nroPedido) throws SQLException{
        String query = "UPDATE pedido set estado = ? WHERE nroPedido = ? AND estado = 'pendiente' ";
         try(PreparedStatement sentencia = conexion.prepareStatement(query)){
            sentencia.setString(1,"cancelado");
            sentencia.setInt(2,nroPedido);            
            int filasActualizadas = sentencia.executeUpdate();
            
            if(filasActualizadas > 0){
                System.out.println("El pedido se ha cancelado con exito...");
            }else{
                System.out.println("No es posible cancelar el pedido, consulte el estado del mismo...");
            }
        }
    }
     
    //Metodo para despachar un pedido
      public void despacharPedido(int nroPedido) throws SQLException{
        String query = "UPDATE pedido set estado = ? WHERE nroPedido = ? AND estado = 'finalizado' ";
         try(PreparedStatement sentencia = conexion.prepareStatement(query)){
            sentencia.setString(1,"despachado");
            sentencia.setInt(2,nroPedido);            
            int filasActualizadas = sentencia.executeUpdate();
            
            if(filasActualizadas > 0){
                System.out.println("El pedido se ha despachado con exito...");
            }else{
                System.out.println("No es posible despachar el pedido, consulte el estado del mismo...");
            }
        }
    }
    
      
    //Metodo para listar todos los pedidos
    public List<PedidoDB> listarPedidos() throws SQLException{
        List<PedidoDB> pedidos = new ArrayList<>();
       
        String query = "SELECT * FROM pedido";
         try(PreparedStatement sentencia = conexion.prepareStatement(query)){
           
             ResultSet rs = sentencia.executeQuery();
             
             while(rs.next()){
                 PedidoDB pedido = new PedidoDB(); 
                 pedido.setNroPedido(rs.getInt("nroPedido"));
                 pedido.setDniCliente(rs.getInt("dniCliente"));
                 pedido.setFechaEntrega(rs.getString("fechaEntrega"));
                 pedido.setDescripcion(rs.getString("descripcion"));
                 pedido.setEstado(rs.getString("estado"));
                 pedido.setTipoEntrega(rs.getString("tipoEntrega"));
                 pedido.setImporte(rs.getFloat("importe"));
                 
                 pedidos.add(pedido);
             }
           
                       
        }
    return pedidos;
    }  
    
    
    //Metodo para buscar un pedido
    public PedidoDB consultarPedido(int nroPedido) throws SQLException{
            
        String sql = "SELECT * FROM pedido WHERE nroPedido = ?";
      try(PreparedStatement stmt = conexion.prepareStatement(sql)){
        stmt.setInt(1, nroPedido); 
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) { 
            PedidoDB pedido = new PedidoDB();
            pedido.setNroPedido(rs.getInt("nroPedido"));
            pedido.setDniCliente(rs.getInt("dniCliente"));
            pedido.setFechaEntrega(rs.getString("fechaEntrega"));
            pedido.setDescripcion (rs.getString("descripcion"));
            pedido.setEstado(rs.getString("estado"));
            pedido.setTipoEntrega(rs.getString("tipoEntrega"));
            pedido.setImporte(rs.getFloat("importe"));
            
            return pedido;
            
        }
        
      }
         return null; 
    }
    
    
    public void eliminarPedido(int nroPedido)throws SQLException{
       String sql = "DELETE FROM pedido WHERE nroPedido = ?";
       try(PreparedStatement stmt = conexion.prepareStatement(sql)){
        stmt.setInt(1, nroPedido); 
       int filasCambiadas = stmt.executeUpdate();
       if(filasCambiadas > 0){
           System.out.println("Pedio eliminado con exito...");
       }else{
           System.out.println("No se encontro el pedido con el numero de pedido ingresado...");
       } 
        
      }
      
    }
    
    
    
}


