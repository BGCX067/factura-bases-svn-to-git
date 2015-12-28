/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.TelefonoBD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MASS
 */
public class TelefonoLista {
    private ArrayList telefonos=new ArrayList();

    public ArrayList getTelefonos() {
        return telefonos;
    }
    public void setTelefonos(ArrayList telefonos) {
        this.telefonos = telefonos;
    }
    public void listar(){
        try {
            TelefonoBD telefonoBD = new TelefonoBD();
            setTelefonos(telefonoBD.listar());
        } catch (SQLException ex) {
            Logger.getLogger(TelefonoLista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
