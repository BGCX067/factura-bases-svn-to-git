/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.ClienteBD;
import datos.DireccioDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xavier
 */
public class Direccion {
    private int idDireccion;
    private String calle;
    private int numeroC;
    private int idSector;
    private int idCiudad;

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumeroC() {
        return numeroC;
    }

    public void setNumeroC(int numeroC) {
        this.numeroC = numeroC;
    }

    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
    
    public void grabar(){
        try {
            DireccioDB direccionBD = new DireccioDB();
            direccionBD.grabar(this);
        } catch (SQLException ex) {
            Logger.getLogger(Direccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void modificar(){
        try {
            DireccioDB direccionBD = new DireccioDB();
            direccionBD.modificar(this);
        } catch (SQLException ex) {
            Logger.getLogger(Direccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminar(){
        try {
            DireccioDB direccionBD = new DireccioDB();
            direccionBD.eliminar(this);
        } catch (SQLException ex) {
            Logger.getLogger(Direccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void buscar(int idDireccion,int idSector,int idCiudad){
        try {
            Direccion aux;
            DireccioDB direccionBD = new DireccioDB();
            aux = direccionBD.buscar(idDireccion,idSector,idCiudad);
        } catch (SQLException ex) {
            Logger.getLogger(Direccion.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
