package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Ciudad;
import negocio.Cliente;
import negocio.Sector;

/**
 *
 * @author xavier
 */
public class SectorDB {

    public ArrayList listar(int idCiudad) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query="SELECT * FROM \"Sector\" WHERE \"idCiudad\"="+idCiudad;
        ResultSet resultado = db.seleccion(query);
        Sector sector=null;
        ArrayList todos=new ArrayList();
        while (resultado.next()) {
            sector = new Sector();
            sector.setIdSector(resultado.getInt(1));
            sector.setNombre(resultado.getString(2));
            sector.setIdCiudad(resultado.getInt(3));
            todos.add(sector);
        }
        db.cerrarConexion();
        return todos;
    }
    
    public Sector buscar(String nombre,int idCiudad) throws SQLException {
        OperacionesBase db = new OperacionesBase();
        String query = "SELECT * FROM \"Sector\" WHERE nombre='"+nombre+"' and \"idCiudad\"="+idCiudad;
        ResultSet resultado = db.seleccion(query);
        Sector sector = null;
        if (resultado != null) {
            resultado.next();
            sector = new Sector();
            sector.setIdSector(resultado.getInt(1));
            sector.setNombre(resultado.getString(2));
            sector.setIdCiudad(resultado.getInt(3));
        }
        db.cerrarConexion();
        return sector;
    }
}
