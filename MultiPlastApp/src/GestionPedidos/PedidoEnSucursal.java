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
    
    public PedidoEnSucursal(String descripcion, int dniCliente, String apenomCli, String estado, String tipoEntrega, String fechaEntrega, int nroSucursal, String direccion) {
        super(descripcion,dniCliente,apenomCli,estado,tipoEntrega,fechaEntrega);
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
    public double generarImporte(double descuento) {
       
            double importeCalculado = 0.0;
            
            for(Producto producto : productos){
                importeCalculado += (producto.getPrecio()) * producto.getCantidad();
            }
            
            importeCalculado = importeCalculado - ((importeCalculado*descuento)/100);
            
            return importeCalculado;
       
    }

   

        
    
}
