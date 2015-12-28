/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;

public class ReporteProductoBD {
    OperacionesBase db=new OperacionesBase();
        public Connection conectar(){
            return db.reporte();
       }
}
