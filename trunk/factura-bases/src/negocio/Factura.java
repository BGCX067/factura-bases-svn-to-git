/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.ClienteBD;
import datos.FacturaDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author F35
 */
public class Factura {
    
    private String idFactura;
    private String fecha;
    private String cedula;

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void grabar(){
        try {
            FacturaDB facturaBD = new FacturaDB();
            facturaBD.grabar(this);
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
        try {
            Factura aux;
            FacturaDB facturaBD = new FacturaDB();
            aux = facturaBD.buscar(this.idFactura);
            setIdFactura(aux.getIdFactura());
            setFecha(aux.getFecha());
            setCedula(aux.getCedula());
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
