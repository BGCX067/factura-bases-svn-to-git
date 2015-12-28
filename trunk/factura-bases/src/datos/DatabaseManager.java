/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//hola como estas
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 *
 * @author oza
 */
public class DatabaseManager {

	private Connection connection;
	private Savepoint svpt;

		//crea la conexion
	public DatabaseManager()
	{
		try {
                    String url = "jdbc:postgresql://127.0.0.1:5432/ventas?user=postgres&password=bases";
                    connection = DriverManager.getConnection(url);
                    //cominte permite guardar cambios
                    //rollback regresa al ultimo moneto 
                    connection.setAutoCommit(false);// cada sentecia se guarda en la base de datos  yo le digo en q momento guarda con el false
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void commit()
	{
		try
		{
			connection.commit();
			svpt = connection.setSavepoint();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public Connection getConnection()
	{
		return connection;
	}
   ///coneciones paralelas 
	public void openConnectionTo(String url)
	{

		try
		{			
			connection = DriverManager.getConnection(url, "postgres", "clave");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

	}
         //borreme todo lo que esta hecho
	public void rollBack()
	{
		try
		{
			if (svpt != null)
			{
				connection.rollback(svpt);
				connection.commit();
			}
		} catch (SQLException e)
		{
			// TODO Errors?
			e.printStackTrace();
		}
	}
    
}
