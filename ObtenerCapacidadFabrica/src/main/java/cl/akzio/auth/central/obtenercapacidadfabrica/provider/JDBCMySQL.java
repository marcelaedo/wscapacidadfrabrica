package cl.akzio.auth.central.obtenercapacidadfabrica.provider;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMySQL {
	
	private Connection conn =null;

	
	public void GenerarConexion() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		String jdbc = "jdbc:mysql://localhost:3306/gestion_proyectos";
		conn = DriverManager.getConnection(jdbc,"gest_proys", "ges131Qft");
	
	}
	
	
	
	public  void consulta() throws SQLException{
		Statement statement=conn.createStatement();
		ResultSet rs = statement.executeQuery("select codi_redmine, nmro_hhsolicitadas, fech_entrega from fab_neg_artefactos");
		while (rs.next()) {
		String c_redmine= rs.getString("codi_redmine");
			String n_hh= rs.getString("nmro_hhsolicitadas");
			String f_entrege= rs.getString("fech_entrega");
			System.out.println("codi_redmine:" +c_redmine+"hh_solicitadas: "+n_hh +"entrega:"+f_entrege);
			
		}
			rs.close();
			statement.close();

		
	}

	public void close() throws SQLException{
		if (conn !=null){
			conn.close();
		}
	}
	
	
	
	
	
	
}
