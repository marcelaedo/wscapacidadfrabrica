package cl.akzio.auth.central.obtenercapacidadfabrica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import cl.akzio.auth.central.obtenercapacidadfabrica.DTO.ProyectoDTO;
import cl.akzio.auth.central.obtenercapacidadfabrica.provider.ConexionMySql;


public class ProyectoMySqlDAO  implements ProyectoDAO{
	
	private Connection conn=null;
	

	


//	final String GETPRO=""
//			+ "select "
//					+ "pro.codi_proyecto,"
//					+ "pro.codi_redmine,"
//					+ "pro.nomb_proyecto,"
//					+ "sol.codi_solicitud"
//			+ "from"
//					+ "fab_neg_solicitud sol,"
//					+ "pro_neg_proyecto pro,"
//					+ "fab_mae_fabrica fab,"
//					+ "pro_mae_estadoproyecto epro,"
//					+ "fab_mae_estadosolicitud esol"
//			+ "where"
//					+ "pro.codi_proyecto=sol.codi_proyecto"
//					+ "and pro.codi_estado=epro.codi_estado"
//					+ "and sol.codi_estado=esol.codi_estado"
//					+ "and sol.codi_fabrica= fab.codi_fabrica"
//					+ "and fab.codi_fabrica=1"
//					+ "and epro.codi_estado=2"
//					+ "and esol.codi_estado<>5"
//					+ "and pro.corr_seq=(select max(pro2.corr_seq) from pro_neg_proyecto pro2 where pro.codi_proyecto=pro2.codi_proyecto)";
//			
//	


//	public  void consulta() throws SQLException, ClassNotFoundException{
//		conn = ConexionMySql.GenerarConexion();
//		Statement statement=conn.createStatement();
//		ResultSet rs = statement.executeQuery("select pro.codi_proyecto,pro.codi_redmine,pro.nomb_proyecto,sol.codi_solicitud from  fab_neg_solicitud sol,pro_neg_proyecto pro,fab_mae_fabrica fab,pro_mae_estadoproyecto epro,fab_mae_estadosolicitud esol where pro.codi_proyecto=sol.codi_proyecto and pro.codi_estado=epro.codi_estado and sol.codi_estado=esol.codi_estado and sol.codi_fabrica= fab.codi_fabrica  and fab.codi_fabrica=1 and epro.codi_estado=2 and esol.codi_estado<>5       and pro.corr_seq=(select max(pro2.corr_seq) from pro_neg_proyecto pro2 where pro.codi_proyecto=pro2.codi_proyecto)");
//		while (rs.next()) {
//			int codiProyecto = rs.getInt("codi_proyecto");
//			String c_redmine= rs.getString("codi_redmine");
//			String nombProyecto= rs.getString("nomb_proyecto");
//			int codiSolicitud= rs.getInt("codi_solicitud");
//			
//			
//			System.out.println( "codi_proyecto:"+codiProyecto+"codi_redmine:" +c_redmine+"nombproeycto: "+nombProyecto +"entrega:"+codiSolicitud);
//			
//		}
//			rs.close();
//			statement.close();
//
//		
//	}




	@Override
	public List<ProyectoDTO> getProyecto() throws SQLException, ClassNotFoundException {
		
		conn = ConexionMySql.GenerarConexion();
		List<ProyectoDTO>proyectos= new ArrayList<>();
		Statement statement=conn.createStatement();
		ResultSet rs = statement.executeQuery("select pro.codi_proyecto,pro.codi_redmine,pro.nomb_proyecto,sol.codi_solicitud from  fab_neg_solicitud sol,pro_neg_proyecto pro,fab_mae_fabrica fab,pro_mae_estadoproyecto epro,fab_mae_estadosolicitud esol where pro.codi_proyecto=sol.codi_proyecto and pro.codi_estado=epro.codi_estado and sol.codi_estado=esol.codi_estado and sol.codi_fabrica= fab.codi_fabrica  and fab.codi_fabrica=1 and epro.codi_estado=2 and esol.codi_estado<>5       and pro.corr_seq=(select max(pro2.corr_seq) from pro_neg_proyecto pro2 where pro.codi_proyecto=pro2.codi_proyecto)");
		while (rs.next()) {
			int codiProyecto = rs.getInt("codi_proyecto");
			String c_redmine= rs.getString("codi_redmine");
			String nombProyecto= rs.getString("nomb_proyecto");
			int codiSolicitud= rs.getInt("codi_solicitud");
			ProyectoDTO proyecto = new ProyectoDTO(codiProyecto, c_redmine, nombProyecto, codiSolicitud);
			proyectos.add(proyecto);
			
			//System.out.println( "codi_proyecto:"+codiProyecto+"codi_redmine:" +c_redmine+"nombproeycto: "+nombProyecto +"entrega:"+codiSolicitud);
			
		}
			rs.close();
			statement.close();
			conn.close();

		return proyectos;
	}


	


}
