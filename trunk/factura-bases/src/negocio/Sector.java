/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.DireccioDB;
import datos.SectorDB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xavier
 */
public class Sector {
    private int idSector;
    private String nombre;
    private int idCiudad;

    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSerial) {
        this.idSector = idSerial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
    
    public ArrayList listar(int idCiudad){
        try{
            SectorDB sectores=new SectorDB();
            return sectores.listar(idCiudad);
        }catch(SQLException ex){
            Logger.getLogger(Ciudad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void buscar(String nombre,int idCiudad){
        try {
            Sector aux;
            SectorDB direccionBD = new SectorDB();
            aux = direccionBD.buscar(nombre,idCiudad);
        } catch (SQLException ex) {
            Logger.getLogger(Direccion.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
