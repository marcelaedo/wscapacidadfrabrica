package cl.akzio.auth.central.obtenercapacidadfabrica.dao;

import java.sql.SQLException;
import java.util.List;

import cl.akzio.auth.central.obtenercapacidadfabrica.DTO.ArtefactoDTO;

public interface ArtefactoDAO {
	
	public List<ArtefactoDTO> getArtefacto() throws SQLException;

}
