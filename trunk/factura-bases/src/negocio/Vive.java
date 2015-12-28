/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.ViveBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MASS
 */
public class Vive {
  private String cedula;
  private int idCiudad;
  private int idDireccion;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }
    public void grabar(){
      try {
          ViveBD viveBD = new ViveBD();
          viveBD.grabar(this);
      } catch (SQLException ex) {
          Logger.getLogger(Vive.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    public void eliminar(){
      try {
          ViveBD viveBD = new ViveBD();
          viveBD.eliminar(this.cedula);
      } catch (SQLException ex) {
          Logger.getLogger(Vive.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    public void buscar(){
      try {
          Vive aux;
          ViveBD viveBD = new ViveBD();
          aux = viveBD.buscar(cedula);
          setIdCiudad(aux.getIdCiudad());
          setIdDireccion(aux.getIdDireccion());
      } catch (SQLException ex) {
          Logger.getLogger(Vive.class.getName()).log(Level.SEVERE, null, ex);
      }
    }   
}
