/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Vive;

/**
 *
 * @author MASS
 */
public class ViveBD {
    public boolean grabar(Vive vive) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "INSERT INTO vive (cedula, \"idCiudad\", \"idDireccion\" ) VALUES ('"+vive.getCedula()+"',"+vive.getIdCiudad()+","+vive.getIdDireccion()+")";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    } 
    public int eliminar(String cedula) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="delete from vive where cedula='" + cedula + "'";
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }
    public Vive buscar(String cedula) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from vive where cedula ='" + cedula + "'";
        ResultSet resultado = db.seleccion(query);
        Vive vive = null;
        if (resultado != null) {
            resultado.next();
            vive = new Vive();
            vive.setCedula(resultado.getString("cedula"));
            vive.setIdCiudad(resultado.getInt("\"idCiudad\""));
            vive.setIdDireccion(resultado.getInt("\"idDireccion\""));
        }
        db.cerrarConexion();
        return vive;
    }    
    public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from vive";
        ResultSet resultado = db.seleccion(query);
        Vive vive = null;
        ArrayList todos = new ArrayList();
        while (resultado.next()) {
            vive = new Vive();
            vive.setCedula(resultado.getString(1));
            vive.setIdCiudad(resultado.getInt(2));
            vive.setIdDireccion(resultado.getInt(3));
            todos.add(vive);
        }
        db.cerrarConexion();
        return todos;
    }    
}
