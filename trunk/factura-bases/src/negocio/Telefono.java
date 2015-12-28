/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.TelefonoBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MASS
 */
public class Telefono {
    private int idTelefono;
    private String numeroT;

    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getNumeroT() {
        return numeroT;
    }

    public void setNumeroT(String numeroT) {
        this.numeroT = numeroT;
    }
    public void grabar(){
        try {
            TelefonoBD telefonoBD = new TelefonoBD();
            telefonoBD.grabar(this);
        } catch (SQLException ex) {
            Logger.getLogger(Telefono.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modificar(){
        try {
            TelefonoBD telefonoBD = new TelefonoBD();
            telefonoBD.modificar(this);
        } catch (SQLException ex) {
            Logger.getLogger(Telefono.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminar(){
        try {
            TelefonoBD telefonoBD = new TelefonoBD();
            telefonoBD.eliminar(this.idTelefono);
        } catch (SQLException ex) {
            Logger.getLogger(Telefono.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void buscar(){
        try {
            Telefono aux;
            TelefonoBD telefonoBD = new TelefonoBD();
            aux = telefonoBD.buscar(this.idTelefono);
            setNumeroT(aux.getNumeroT());
        } catch (SQLException ex) {
            Logger.getLogger(Telefono.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
