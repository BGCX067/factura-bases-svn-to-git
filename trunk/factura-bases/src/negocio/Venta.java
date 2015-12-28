/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.ClienteBD;
import datos.VentasBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author F35
 */
public class Venta {
 
    private String idFactura;
    private String idProcduto;
    private String cantidad;

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getIdProcduto() {
        return idProcduto;
    }

    public void setIdProcduto(String idProcduto) {
        this.idProcduto = idProcduto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void grabar(){
        try {
            VentasBD ventaBD = new VentasBD();
            ventaBD.grabar(this);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificar(){
        /*try {
            ClienteBD clienteBD = new ClienteBD();
            clienteBD.modificar(this);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    public void eliminar(){
        try {
            ClienteBD clienteBD = new ClienteBD();
            clienteBD.eliminar(this.idFactura);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void buscar(){
        /*try {
            Cliente aux;
            ClienteBD clienteBD = new ClienteBD();
            aux = clienteBD.buscar(this.idFactura);
            setNombre(aux.getNombre());
            setApellido(aux.getApellido());
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }*/    
    }   
}
