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
public class PedidoEnSucursal extends Pedido{
    private int nroSucursal;
    private double porcentajeDescuento;
    private String direccion;
    
    public PedidoEnSucursal(String descripcion, int dniCliente, String apenomCli, int nroPedido, String estado, String tipoEntrega, Date fechaEntrega, int nroSucursal, String direccion) {
        super(descripcion,dniCliente,apenomCli,nroPedido,estado,tipoEntrega,fechaEntrega);
        this.nroSucursal = nroSucursal;
        this.direccion = direccion;
    }

    public int getNroSucursal() {
        return nroSucursal;
    }

    public void setNroSucursal(int nroSucursal) {
        this.nroSucursal = nroSucursal;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    
    @Override
    public double generarImporte() {
       if(estado.equals("en proceso")){  //Una vez que el pedido se encuentra en produccion, se procede a generar el importeFinal
            double importeCalculado = 0.0;
            
            for(Producto producto : productos){
                importeCalculado += producto.getPrecio();
            }
            
            importeCalculado = importeCalculado - ((importeCalculado*porcentajeDescuento)/100);
            
            return importeCalculado;
        }else{
            System.out.println("El pedido" + nroPedido + "aun no ha sido iniciado");
            return 0.0;
        }  
    }

    @Override
    public void procesarPedido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

        
    
}
