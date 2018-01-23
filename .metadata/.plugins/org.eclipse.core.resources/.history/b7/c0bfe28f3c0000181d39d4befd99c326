package cl.akzio.auth.central.obtenercapacidadfabrica.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cl.akzio.auth.central.obtenercapacidadfabrica.DTO.ArtefactoDTO;



public class ArtefectoMySqlDAO implements ArtefactoDAO {
private Connection conn=null;
	
	
	
	
	
	public void GenerarConexion() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String jdbc = "jdbc:mysql://localhost:3306/gestion_proyectos";
		conn = DriverManager.getConnection(jdbc,"gest_proys", "ges131Qft");
	
	}
	
	
public  void consulta() throws SQLException{
		
		Statement statement=conn.createStatement();
		ResultSet rs = statement.executeQuery("select artef.codi_artefacto, artef.codi_producto, artef.codi_solicitud, artef.codi_redmine, artef.nmro_hhsolicitadas, artef.fech_entrega, maeart.nomb_artefacto, maeprod.nomb_producto, maees.nomb_estado, sol.nomb_usuario, proy.nomb_proyecto from fab_neg_artefactos artef, fab_mae_artefacto maeart, fab_mae_producto maeprod, fab_mae_estadosolicitud maees, fab_neg_solicitud sol,  pro_neg_proyecto proy where artef.codi_artefacto=maeart.codi_artefacto and artef.codi_producto=maeprod.codi_producto and artef.codi_solicitud=sol.codi_solicitud and sol.codi_estado=maees.codi_estado and sol.codi_proyecto=proy.codi_proyecto and sol.codi_estado<>5 and artef.fech_entrega>=now()");
		while (rs.next()) {
			int codiArtefacto= rs.getInt("codi_artefacto");
			int codiProducto= rs.getInt("codi_producto");
			int codiSolicitud = rs.getInt("codi_solicitud");
			String c_redmine= rs.getString("codi_redmine");
			float nhhSolicitadas= rs.getFloat("nmro_hhsolicitadas");
			Date fechEntrega= rs.getDate("fech_entrega");
			String  nombArtefacto= rs.getString("nomb_artefacto");
			String  nombProducto= rs.getString("nomb_producto");
			String nombEstado= rs.getString("nomb_estado");
			String nombUsuario= rs.getString("nomb_usuario");
			String nombProyecto=rs.getString("nomb_proyecto");
			
			System.out.println( ""
					+ "codi artefacto: "+codiArtefacto+" "
					+ "codi producto: " +codiProducto+" "
					+ "codi solicitud: "+codiSolicitud +" "
					+ "codi redmine: "+c_redmine +" "
					+ "hh solicitadas: "+nhhSolicitadas +" "
					+ "fecha entrega: "+fechEntrega +" "
					+ "nombre artefacto: "+nombArtefacto +" "
					+ "nombre producto: "+nombProducto +" "
					+ "nombre estado: "+nombEstado +" "
					+ "nombre usuario: "+nombUsuario +" "
					+ "nombre proyecto: "+nombProyecto);
			
		}
			rs.close();
			statement.close();

		
	}
	
	
	@Override
	public List<ArtefactoDTO> getArtefacto() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
