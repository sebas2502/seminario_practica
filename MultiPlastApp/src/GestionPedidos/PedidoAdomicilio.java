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
 
    private double adicionalEnvio; 
    private String direccion;
    
    public PedidoAdomicilio(String descripcion, int dniCliente, String apenomCli, String estado, String tipoEntrega, String fechaEntrega,double adicionalEnvio, String direccion) {
        super(descripcion,dniCliente,apenomCli,estado,tipoEntrega,fechaEntrega);
        this.adicionalEnvio = adicionalEnvio;
        this.direccion = direccion;
        
        
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
    public double generarImporte(double porcentajeEnvio) {
          
            double importeCalculado = 0.0;
            
            for(Producto producto : productos){
                
                importeCalculado += (producto.getPrecio()) * producto.getCantidad();
            }
            
            importeCalculado = importeCalculado + ((importeCalculado * porcentajeEnvio)/100);
           
            return importeCalculado;
              
        
    }

   

   
 
    
}
