/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Telefono;

/**
 *
 * @author MASS
 */
public class TelefonoBD {
    public boolean grabar(Telefono telefono) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "INSERT INTO \"Telefono\" (\"numeroT\") VALUES ('"+telefono.getNumeroT()+"')";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }
    public int modificar(Telefono telefono) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="update  \"Telefono\" set \"numeroT\"='" + telefono.getNumeroT() + "' where \"idTelefono\"=" + telefono.getIdTelefono();
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }
    public int eliminar(int idTelefono) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="delete from \"Telefono\" where \"idTelefono\"=" + idTelefono ;
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }
     public Telefono buscar(int idTelefono) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from \"Telefono\" where \"idTelefono\"=" + idTelefono ;
        ResultSet resultado = db.seleccion(query);
        Telefono telefono = null;
        if (resultado != null) {
            resultado.next();
            telefono = new Telefono();
            telefono.setIdTelefono(resultado.getInt("\"idTelefono\""));
            telefono.setNumeroT(resultado.getString("\"numeroT\""));
        }
        db.cerrarConexion();
        return telefono;
    }
        public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from \"Telefono\"";
        ResultSet resultado = db.seleccion(query);
        Telefono telefono = null;
        ArrayList todos = new ArrayList();
        while (resultado.next()) {
            telefono = new Telefono();
            telefono.setIdTelefono(resultado.getInt(1));
            telefono.setNumeroT(resultado.getString(2));
            todos.add(telefono);
        }
        db.cerrarConexion();
        return todos;
    }
}
