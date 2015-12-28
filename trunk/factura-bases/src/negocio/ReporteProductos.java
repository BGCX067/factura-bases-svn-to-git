/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.ReporteProductoBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/*import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.view.save.JRPdfSaveContributor.*;
import net.sf.jasperreports.view.JRViewer.*;
import net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor.*;

public class ReporteProductos {
    public static Connection CONEXION;
    
    
    public void generar() throws JRException{
            ReporteProductoBD reporte=new ReporteProductoBD();
            CONEXION = reporte.conectar();
            
            String template="Reporte.jasper";
            JasperReport r=null;
            r=(JasperReport) JRLoader.loadObject(template);
            

            Map param=new HashMap();
            param.put("id", 3);

            JasperPrint jasperprint= JasperFillManager.fillReport(r,null,CONEXION);
            JasperViewer visor=new JasperViewer(jasperprint,false);
            visor.setTitle("Geniz Reportes - GSF");
            visor.setVisible(true);
    }
}*/
