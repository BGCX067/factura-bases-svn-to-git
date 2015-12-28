package negocio;

import datos.CiudadDB;
import datos.ClienteBD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ciudad {
    private int idCiudad;
    private String nombre;

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList listar(){
        try{
            CiudadDB ciudades=new CiudadDB();
            return ciudades.listar();
        }catch(SQLException ex){
            Logger.getLogger(Ciudad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Ciudad buscar(String nombre){
        try {
            Ciudad aux;
            CiudadDB ciudad=new CiudadDB();
            aux=ciudad.buscar(nombre);
            return aux;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return null;
    }
}
