/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.ViveBD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MASS
 */
public class ViveLista {
    private ArrayList viveLista=new ArrayList(); 

    public ArrayList getViveLista() {
        return viveLista;
    }

    public void setViveLista(ArrayList viveLista) {
        this.viveLista = viveLista;
    }
    public void listar(){
        try {
            ViveBD viveBD = new ViveBD();
            setViveLista(viveBD.listar());
        } catch (SQLException ex) {
            Logger.getLogger(ViveLista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
