package cl.akzio.auth.central.obtenercapacidadfabrica.dao;

import cl.akzio.auth.central.obtenercapacidadfabrica.provider.ConexionMySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import cl.akzio.auth.central.obtenercapacidadfabrica.DTO.UsuarioDTO;

public class UsuarioMySqlDAO implements UsuarioDAO {

	private Connection conn = null;

	public void consulta() throws SQLException, ClassNotFoundException {
		conn = ConexionMySql.GenerarConexion();
		Statement statement = conn.createStatement();
		ResultSet rs = statement
				.executeQuery("select usu.nomb_usuario,usu.flag_estado,cargo.nomb_cargo,fab.nomb_fabrica from sis_neg_usuario usu,fab_mae_fabrica fab, sis_mae_cargo cargo where usu.codi_fabrica=fab.codi_fabrica and usu.codi_cargo=cargo.codi_cargo and (usu.codi_cargo=5 or usu.codi_cargo=6 or usu.codi_cargo=7) and usu.codi_fabrica=1 and usu.flag_estado='a'");
		while (rs.next()) {
			String nombUsuario = rs.getString("nomb_usuario");
			String flagEstado = rs.getString("flag_estado");
			String nombCargo = rs.getString("nomb_cargo");
			String nombFabrica = rs.getString("nomb_fabrica");

			System.out.println("nombre usurio:" + nombUsuario
					+ "flag de estado:" + flagEstado + "nombre cargo: "
					+ nombCargo + "nombre de lal fabrica:" + nombFabrica);

		}
		rs.close();
		statement.close();
		conn.close();

	}

	@Override
	public List<UsuarioDTO> getUsuario() throws SQLException {
		// TODO Auto-generated method
		return null;
	}

}
