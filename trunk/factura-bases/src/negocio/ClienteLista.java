/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.ClienteBD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MASS
 */
public class ClienteLista {
    private ArrayList clientes=new ArrayList();
    public void listar(){
        try {
            ClienteBD clienteBD = new ClienteBD();
            setClientes(clienteBD.listar());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteLista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList clientes) {
        this.clientes = clientes;
    }

}
