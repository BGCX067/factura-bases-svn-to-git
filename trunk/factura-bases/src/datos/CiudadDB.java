package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import negocio.Ciudad;

public class CiudadDB {

    public Ciudad buscar(String nombre) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "SELECT \"idCiudad\", nombre  FROM \"Ciudad\" WHERE nombre='"+nombre+"'";
        ResultSet resultado = db.seleccion(query);
        Ciudad ciudad = null;
        if (resultado != null) {
            resultado.next();
            ciudad = new Ciudad();
            ciudad.setIdCiudad(resultado.getInt(1));
            ciudad.setNombre(resultado.getString(2));
        }
        db.cerrarConexion();
        return ciudad;
    }
    
    public ArrayList listar() throws SQLException {
       OperacionesBase db = new OperacionesBase();
        String query="SELECT * FROM\"Ciudad\" ";
        ResultSet resultado = db.seleccion(query);
        Ciudad ciudad=null;
        ArrayList todos=new ArrayList();
        while (resultado.next()) {
            ciudad = new Ciudad();
            ciudad.setIdCiudad(resultado.getInt(1));
            ciudad.setNombre(resultado.getString(2));
            todos.add(ciudad);
        }
        db.cerrarConexion();
        return todos;
    }

}
