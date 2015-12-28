/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Stack;
import negocio.Ciudad;
import negocio.Factura;

/**
 *
 * @author F35
 */
public class FacturaDB {

    public boolean grabar(Factura factura) throws SQLException {
        OperacionesBase db = new OperacionesBase();

        String query = "INSERT INTO \"Factura\"(\"idFactura\", fecha, cedula) VALUES ('" + factura.getIdFactura() + "','" + factura.getFecha() + "','" + factura.getCedula() + "')";
        Boolean resultado = db.ingreso(query);
        db.cerrarConexion();
        return resultado;
    }

    public int modificar(Ciudad ciudad) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "UPDATE \"Ciudad\" SET \"idCiudad\"=" + ciudad.getIdCiudad() + ", nombre='" + ciudad.getNombre() + "'WHERE idciudad=" + ciudad.getIdCiudad();
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }

    public int eliminar(int idciudad) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "delete from ciudad where idciudad=" + idciudad;
        int resultado = db.modificacioneliminacion(query);
        db.cerrarConexion();
        return resultado;
    }

    public Factura buscar(String idFactura) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from ciudad where idciudad =" + idFactura;
        ResultSet resultado = db.seleccion(query);
        Factura factura = null;
        if (resultado != null) {
            resultado.next();
            factura = new Factura();
            factura.setIdFactura(resultado.getString("idFactura"));
            factura.setFecha(resultado.getString("idFactura"));
            factura.setCedula(resultado.getString("cedula"));

        }
        db.cerrarConexion();
        return factura;
    }

    public ArrayList<Factura> listar() throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "select * from \"Factura\" ";
        ResultSet resultado = db.seleccion(query);
        Factura factura = null;
        ArrayList<Factura> todos = new ArrayList();
        while (resultado.next()==true) {
            
            factura = new Factura();
            
            factura.setIdFactura(Integer.toString(resultado.getInt(1)));
            factura.setFecha(resultado.getString(2));
            factura.setCedula(resultado.getString(3));
            todos.add(factura);
        }
        db.cerrarConexion();
        return todos;
    }

    public String DameId() throws SQLException {

        OperacionesBase db = new OperacionesBase();
        String query = "select * from \"Factura\"";
        ResultSet resultado = db.seleccion(query);
        Factura factur = null;
        Stack<Integer> todos = new Stack();
        while (resultado.next()) {
            todos.add(resultado.getInt(1));
        }
        db.cerrarConexion();
        return Integer.toString(todos.peek() + 1);
    }
}
