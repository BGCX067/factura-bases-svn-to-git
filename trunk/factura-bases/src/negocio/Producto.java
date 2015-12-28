/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.CiudadDB;
import datos.ProductoDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class Producto {
  private int idproducto;   
  private String nombre;
  private double precio;
  private int cantidad;

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
   public void grabar() {
        try {
            ProductoDB productoDB = new ProductoDB ();
            productoDB.grabar(this);
        } catch (SQLException ex) {
            Logger.getLogger(Ciudad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar() {
        try {
        ProductoDB productoDB = new ProductoDB ();
            productoDB.modificar(this);
        } catch (SQLException ex) {
            Logger.getLogger(Ciudad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar() {
        try {
        ProductoDB productoDB = new ProductoDB ();
            productoDB.eliminar(this.idproducto);
        } catch (SQLException ex) {
            Logger.getLogger(Ciudad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscar() {
        try {
            Producto aux;
           ProductoDB productoDB = new ProductoDB ();
            aux = productoDB .buscar(this.idproducto);
        setNombre(aux.getNombre());
        } catch (SQLException ex) {
            Logger.getLogger(Ciudad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
