/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import negocio.Cliente;
/**
 *
 * @author MASS
 */
public class ClienteBD {
    public boolean grabar(Cliente cliente) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "INSERT INTO \"Cliente\" VALUES ('"+cliente.getCedula()+"','"+cliente.getNombre()+"','"+cliente.getApellido()+"','"+cliente.getTelefono()+"',"+cliente.getIdSector()+","+cliente.getIdCiudad()+")";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }
    public int modificar(Cliente cliente) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="update \"Cliente\" set nombre='" + cliente.getNombre() + "', apellido='" + cliente.getApellido() +"', telefono='"+cliente.getTelefono()+"',\"idSector\"= "+cliente.getIdSector()+",\"idCiudad\"= "+cliente.getIdCiudad()+ " where cedula='" + cliente.getCedula() + "'";
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }
    public int eliminar(String cedula) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="delete from \"Cliente\" where cedula='" + cedula + "'";
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }
    public Cliente buscar(String cedula) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from \"Cliente\" where cedula ='" + cedula + "'";
        ResultSet resultado = db.seleccion(query);
        Cliente cliente = null;
        if (resultado.next()) {
            cliente = new Cliente();
            cliente.setCedula(resultado.getString(1));
            cliente.setNombre(resultado.getString(2));
            cliente.setApellido(resultado.getString(3));
            cliente.setTelefono(resultado.getString(4));
            cliente.setIdSector(resultado.getInt(5));
            cliente.setIdCiudad(resultado.getInt(6));
            
        }
        db.cerrarConexion();
        return cliente;
    }
        public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from \"Cliente\"";
        ResultSet resultado = db.seleccion(query);
        Cliente cliente = null;
        ArrayList todos = new ArrayList();
        while (resultado.next()) {
            cliente = new Cliente();
            cliente.setCedula(resultado.getString(1));
            cliente.setNombre(resultado.getString(2));
            cliente.setApellido(resultado.getString(3));
            cliente.setTelefono(resultado.getString(4));
            cliente.setIdSector(resultado.getInt(5));
            cliente.setIdCiudad(resultado.getInt(6));
            todos.add(cliente);
        }
        db.cerrarConexion();
        return todos;
    }

    public ArrayList listar(String cedula, int valor) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "";
        if (valor==1)
            query="select * from \"Cliente\"";
        else
            query="select * from \"Cliente\" where cedula like '"+cedula+"%'";
        ResultSet resultado = db.seleccion(query);
        Cliente cliente = null;
        ArrayList todos = new ArrayList();
        while (resultado.next()) {
            cliente = new Cliente();
            cliente.setCedula(resultado.getString(1));
            cliente.setNombre(resultado.getString(2));
            cliente.setApellido(resultado.getString(3));
            cliente.setTelefono(resultado.getString(4));
            cliente.setIdSector(resultado.getInt(5));
            cliente.setIdCiudad(resultado.getInt(6));
            todos.add(cliente);
        }
        db.cerrarConexion();
        return todos;
    }
}