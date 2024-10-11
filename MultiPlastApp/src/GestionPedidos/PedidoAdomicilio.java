/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionPedidos;

import java.util.Date;
import java.util.List;

/**
 *
 * @author sebac
 */
public class PedidoAdomicilio extends Pedido{
    private double importe;
    private double adicionalEnvio; 

    public PedidoAdomicilio(String descripcion, int dniCliente, String apenomCli, List<Producto> productos, int nroPedido, String estado, boolean materiaPrimaDisponible, String tipoEntrega, Date fechaEntrega,double adicionalEnvio) {
        super(descripcion,dniCliente,apenomCli,productos,nroPedido,estado,materiaPrimaDisponible,tipoEntrega,fechaEntrega);
        this.adicionalEnvio = adicionalEnvio;
        this.importe = importe;
        
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getAdicionalEnvio() {
        return adicionalEnvio;
    }

    public void setAdicionalenvio(double adicionalEnvio) {
        this.adicionalEnvio = adicionalEnvio;
    }
    
    
    
 
    @Override
    public double generarImporte() {
        if(estado.equals("en proceso")){  //Una vez que el pedido se encuentra en produccion, se procede a generar el importeFinal
            double importeCalculado = 0.0;
            
            for(Producto producto : productos){
                importeCalculado += producto.getPrecio();
            }
            
            importeCalculado = importeCalculado + adicionalEnvio;
            
            return importeCalculado;
        }else        {
            System.out.println("El pedido" + nroPedido + "aun no ha sido iniciado");
            return 0.0;
        }
        
        
    }

    @Override
    public void procesarPedido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
 
    
}
