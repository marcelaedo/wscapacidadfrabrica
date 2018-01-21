package cl.akzio.auth.central.obtenercapacidadfabrica.dao;

import java.sql.SQLException;
import java.util.List;

import cl.akzio.auth.central.obtenercapacidadfabrica.DTO.UsuarioDTO;

public interface UsuarioDAO {
	
	public List<UsuarioDTO> getUsuario() throws SQLException;

}
