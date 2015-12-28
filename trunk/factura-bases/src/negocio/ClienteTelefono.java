/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.ClienteTelefonoBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MASS
 */
public class ClienteTelefono {
    private String cedula;
    private int idTelefono;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }
    public void grabar(){
        try {
            ClienteTelefonoBD clienteTelefonoBD = new ClienteTelefonoBD();
            clienteTelefonoBD.grabar(this);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteTelefono.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*public void modificar(){
        try {
            ClienteTelefonoBD clienteTelefonoBD = new ClienteTelefonoBD();
            clienteTelefonoBD.modificar(this);        
        } catch (SQLException ex) {
            Logger.getLogger(ClienteTelefono.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    public void eliminar(){
        try {
            ClienteTelefonoBD clienteTelefonoBD = new ClienteTelefonoBD();
            clienteTelefonoBD.eliminar(this.cedula, this.idTelefono);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteTelefono.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public void buscar(){
        try {
            ClienteTelefono aux;
            ClienteTelefonoBD clienteTelefonoBD = new ClienteTelefonoBD();
            aux = clienteTelefonoBD.buscar(this.cedula,this.idTelefono);
            setCedula(aux.getCedula());
            setIdTelefono(aux.getIdTelefono());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteTelefono.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}
