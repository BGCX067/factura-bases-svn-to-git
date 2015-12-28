/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.ClienteTelefonoBD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MASS
 */
public class ClienteTelefonoLista {
    private ArrayList clienteTelefonos=new ArrayList();

    public ArrayList getClienteTelefonos() {
        return clienteTelefonos;
    }

    public void setClienteTelefonos(ArrayList clienteTelefonos) {
        this.clienteTelefonos = clienteTelefonos;
    }
    public void listar(){
        try {
            ClienteTelefonoBD clienteTelefonoBD = new ClienteTelefonoBD();
            setClienteTelefonos(clienteTelefonoBD.listar());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteTelefonoLista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
