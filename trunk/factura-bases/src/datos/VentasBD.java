/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Cliente;
import negocio.Venta;

/**
 *
 * @author F35
 */
public class VentasBD {
 
    public boolean grabar(Venta venta) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "INSERT INTO contiene (\"idFactura\",\"idProducto\", cantidad) VALUES ('"+venta.getIdFactura()+"','"+venta.getIdProcduto()+"','"+venta.getCantidad()+"')";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }
    public int modificar(Cliente cliente) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="update \"Cliente\" set nombre='" + cliente.getNombre() + "', apellido='" + cliente.getApellido() + "' where cedula='" + cliente.getCedula() + "'";
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
        if (resultado != null) {
            resultado.next();
            cliente = new Cliente();
            cliente.setCedula(resultado.getString("cedula"));
            cliente.setNombre(resultado.getString("nombre"));
            cliente.setApellido(resultado.getString("apellido"));
        }
        db.cerrarConexion();
        return cliente;
    }
        public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from contiene";
        ResultSet resultado = db.seleccion(query);
        Venta venta = null;
        ArrayList<Venta> todos = new ArrayList();
        while (resultado.next()) {
            venta = new Venta();
            venta.setIdFactura(Integer.toString(resultado.getInt(1)));
            venta.setIdProcduto(Integer.toString(resultado.getInt(1)));
            venta.setCantidad(Integer.toString(resultado.getInt(1)));
          todos.add(venta);
        }
        db.cerrarConexion();
        return todos;
    }   
         public ArrayList listarFactura(String id) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from contiene where \"idFactura\"='"+id+"'";
        ResultSet resultado = db.seleccion(query);
        Venta venta = null;
        ArrayList<Venta> todos = new ArrayList();
        while (resultado.next()) {
            venta = new Venta();
            venta.setIdFactura(Integer.toString(resultado.getInt(1)));
            venta.setIdProcduto(Integer.toString(resultado.getInt(2)));
            venta.setCantidad(Integer.toString(resultado.getInt(3)));
          todos.add(venta);
        }
        db.cerrarConexion();
        return todos;
    }   
}
