/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Cliente;
import negocio.Direccion;

/**
 *
 * @author xavier
 */
public class DireccioDB {
    public boolean grabar(Direccion direccion) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        System.out.println(direccion.getCalle());
        System.out.println(direccion.getNumeroC());
        System.out.println(direccion.getIdSector());
        System.out.println(direccion.getIdCiudad());
        String query = "INSERT INTO direccion ( calle, \"numeroC\", \"idSector\", \"idCiudad\") VALUES ('"+direccion.getCalle() +"',"+direccion.getNumeroC()+","+direccion.getIdSector()+","+direccion.getIdCiudad()+")";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }
    public int modificar(Direccion direccion) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="UPDATE direccion SET \"idDireccion\"="+direccion.getIdDireccion()+", calle='"+direccion.getCalle()+"', \"numeroC\"="+direccion.getNumeroC()
                +", \"idSector\"="+direccion.getIdSector()+", \"idCiudad\"="+direccion.getIdCiudad()
                + "WHERE \"idDireccion\"="+direccion.getIdDireccion()+"AND \"idSector\"="+direccion.getIdSector()+"AND \"idCiudad\"="+direccion.getIdCiudad();
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }
    public int eliminar(Direccion direccion) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="DELETE FROM direccion WHERE \"idDireccion\"="+direccion.getIdDireccion()+"AND \"idSector\"="+direccion.getIdSector()+"AND \"idCiudad\"="+direccion.getIdCiudad();
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }
    public Direccion buscar(int idDireccion,int idSector, int idCiudad) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "SELECT * FROM direccion WHERE \"idDireccion\"="+idDireccion+" AND \"idSector\"="+idSector+"AND \"idCiudad\"="+idCiudad;
        ResultSet resultado = db.seleccion(query);
        Direccion direccion = null;
        if (resultado.next()) {
            direccion = new Direccion();
            direccion.setIdDireccion(resultado.getInt(1));
            direccion.setCalle(resultado.getString(2));
            direccion.setNumeroC(resultado.getInt(3));
            direccion.setIdSector(resultado.getInt(4));
            direccion.setIdCiudad(resultado.getInt(5));
        }
        db.cerrarConexion();
        return direccion;
    }
    public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "SELECT * FROM direccion";
        ResultSet resultado = db.seleccion(query);
        Direccion direccion = null;
        ArrayList todos = new ArrayList();
        while (resultado.next()) {
            direccion = new Direccion();
            direccion.setIdDireccion(resultado.getInt(1));
            direccion.setCalle(resultado.getString(2));
            direccion.setNumeroC(resultado.getInt(3));
            direccion.setIdSector(resultado.getInt(4));
            direccion.setIdCiudad(resultado.getInt(5));
            todos.add(direccion);
        }
        db.cerrarConexion();
        return todos;
    }
}
