/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.ClienteTelefono;

/**
 *
 * @author MASS
 */
public class ClienteTelefonoBD {
    public boolean grabar(ClienteTelefono clienteTelefono) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "INSERT INTO \"clienteTelefono\" (cedula, \"idTelefono\") VALUES ('"+clienteTelefono.getCedula()+"',"+clienteTelefono.getIdTelefono()+")";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }
    /*
    public int modificar(ClienteTelefono clienteTelefono) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="update \"clienteTelefono\" set \"idTelefono\"=" + clienteTelefono.getIdTelefono() + " where cedula='" + clienteTelefono.getCedula() + "',";
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }*/ 
    public int eliminar(String cedula, int idTelefono) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="delete from \"clienteTelefono\" where cedula='" + cedula + "' AND "+ "\"idTelefono\" = "+idTelefono;
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }
    public ClienteTelefono buscar(String cedula, int idTelefono) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from \"clienteTelefono\" where cedula ='" + cedula + "' AND "+ "\"idTelefono\" = "+idTelefono;
        ResultSet resultado = db.seleccion(query);
        ClienteTelefono clienteTelefono = null;
        if (resultado != null) {
            resultado.next();
            clienteTelefono = new ClienteTelefono();
            clienteTelefono.setCedula(resultado.getString("cedula"));
            clienteTelefono.setIdTelefono(resultado.getInt("\"idTelefono\""));
        }
        db.cerrarConexion();
        return clienteTelefono;
    }
    public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from \"clienteTelefono\"";
        ResultSet resultado = db.seleccion(query);
        ClienteTelefono clienteTelefono = null;
        ArrayList todos = new ArrayList();
        while (resultado.next()) {
            clienteTelefono = new ClienteTelefono();
            clienteTelefono.setCedula(resultado.getString(1));
            clienteTelefono.setIdTelefono(resultado.getInt(2));
            todos.add(clienteTelefono);
        }
        db.cerrarConexion();
        return todos;
    }
}
