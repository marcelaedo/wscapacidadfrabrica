package cl.akzio.auth.central.obtenercapacidadfabrica.provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySql {

	public static Connection conn = null;
	
	public static Connection GenerarConexion() throws SQLException,
			ClassNotFoundException {

		
		String jdbc = "jdbc:mysql://localhost:3306/gestion_proyectos";
		conn = DriverManager.getConnection(jdbc, "gest_proys", "ges131Qft");

		return conn;
	}
	
	public void close() throws SQLException{
		if (conn !=null){
			conn.close();
		}
	}

}
