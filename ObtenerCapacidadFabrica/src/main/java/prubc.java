import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.sun.corba.se.impl.oa.toa.TOA;

import cl.akzio.auth.central.obtenercapacidadfabrica.DTO.ArtefactoDTO;
import cl.akzio.auth.central.obtenercapacidadfabrica.DTO.ProyectoDTO;
import cl.akzio.auth.central.obtenercapacidadfabrica.DTO.UsuarioDTO;
import cl.akzio.auth.central.obtenercapacidadfabrica.dao.ArtefectoMySqlDAO;
import cl.akzio.auth.central.obtenercapacidadfabrica.dao.FechaEntregaDAO;
import cl.akzio.auth.central.obtenercapacidadfabrica.dao.FechaEntregaMySqlDAO;
import cl.akzio.auth.central.obtenercapacidadfabrica.dao.ProyectoDAO;
import cl.akzio.auth.central.obtenercapacidadfabrica.dao.ProyectoMySqlDAO;
import cl.akzio.auth.central.obtenercapacidadfabrica.dao.UsuarioMySqlDAO;

public class prubc {

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {

		// prueba de query para obtener fecha

		FechaEntregaMySqlDAO fechtermino = new FechaEntregaMySqlDAO();
		fechtermino.obtenerfechaEntrega();
		System.out.println("fin.-------");

		// prueba de query para obtener proyectos

		ProyectoMySqlDAO p2 = new ProyectoMySqlDAO();
		List<ProyectoDTO> proyectoss = p2.getProyecto();
		for (ProyectoDTO proyectoDTO : proyectoss) {
			System.out.println(proyectoDTO);
		}
		System.out.println("fin.-------");

		// prueba de query para artefactos
		ArtefectoMySqlDAO artef = new ArtefectoMySqlDAO();
		List<ArtefactoDTO> artefactos = artef.getArtefacto();
		for (ArtefactoDTO artefactoDTO : artefactos) {
			System.out.println(artefactoDTO);
		}
		System.out.println("fin.-------");

		// prueba de query de usuarios
		UsuarioMySqlDAO usu = new UsuarioMySqlDAO();
		List<UsuarioDTO> usuarios = usu.getUsuario();
		for (UsuarioDTO usuarioDTO : usuarios) {
			System.out.println(usuarioDTO);
		}

		System.out.println("fin.-------");
	}

}
