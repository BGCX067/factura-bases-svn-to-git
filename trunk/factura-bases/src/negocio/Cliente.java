/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.ClienteBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MASS
 */
public class Cliente {

    private String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private int idSector;
    private int idCiudad;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public void grabar() {
        try {
            ClienteBD clienteBD = new ClienteBD();
            clienteBD.grabar(this);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar() {
        try {
            ClienteBD clienteBD = new ClienteBD();
            clienteBD.modificar(this);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar() {
        try {
            ClienteBD clienteBD = new ClienteBD();
            clienteBD.eliminar(this.cedula);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int buscar() {
        try {
            Cliente aux;
            ClienteBD clienteBD = new ClienteBD();
            aux = clienteBD.buscar(this.cedula);
            if (aux != null) {
                setNombre(aux.getNombre());
                setApellido(aux.getApellido());
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
        public int buscarh() {
        try {
            Cliente aux;
            ClienteBD clienteBD = new ClienteBD();
            aux = clienteBD.buscar(this.cedula);
            if (aux == null) 
                return 0;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
        

}
