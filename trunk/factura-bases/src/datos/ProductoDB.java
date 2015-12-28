/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Ciudad;
import negocio.Producto;

/**
 *
 * @author pablo
 */
public class ProductoDB {

    public boolean grabar(Producto producto) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "INSERT INTO \"Producto\"(nombre, precio, \"cantidadP\") VALUES ('" + producto.getNombre() + "'," + producto.getPrecio() + "," + producto.getCantidad() + ")";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }

    public int modificar(Producto producto) throws SQLException {
        OperacionesBase db = new OperacionesBase();

        String query = "update \"Producto\" set nombre='" + producto.getNombre() + "', precio='" + producto.getPrecio() + "',\"cantidadP\"='" + producto.getCantidad() + "' where \"idProducto\" ='" + producto.getIdproducto() + "'";
        int resultado = db.modificacioneliminacion(query);
     
        db.cerrarConexion();
        return resultado;
    }

    public int eliminar(int idproducto) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "delete from \"Producto\" where \"idProducto\"=" + idproducto;
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }

    public Producto buscar(int idproducto) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from \"Producto\" where \"idProducto\"='" + idproducto+"'";
        ResultSet resultado = db.seleccion(query);
        Producto producto = null;
        if (resultado.next()) {
            ;
            producto = new Producto();
            producto.setIdproducto(resultado.getInt(1));
            producto.setNombre(resultado.getString(2));
            producto.setPrecio(resultado.getDouble(3));
            producto.setCantidad(resultado.getInt(4));
        }
        db.cerrarConexion();
        return producto;
    }

    public ArrayList listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from \"Producto\"";
        ResultSet resultado = db.seleccion(query);
        Producto producto = null;
        ArrayList todos = new ArrayList();
        while (resultado.next()) {
            producto = new Producto();
            producto.setIdproducto(resultado.getInt(1));
            producto.setNombre(resultado.getString(2));
            producto.setPrecio(resultado.getDouble(3));
            producto.setCantidad(resultado.getInt(4));
            todos.add(producto);
        }
        db.cerrarConexion();
        return todos;
    }
}
