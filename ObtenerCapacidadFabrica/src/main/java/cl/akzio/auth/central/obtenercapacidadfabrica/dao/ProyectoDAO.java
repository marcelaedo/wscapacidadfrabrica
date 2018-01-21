package cl.akzio.auth.central.obtenercapacidadfabrica.dao;

import java.sql.SQLException;
import java.util.List;

import cl.akzio.auth.central.obtenercapacidadfabrica.DTO.ProyectoDTO;


public interface ProyectoDAO {

	public List<ProyectoDTO> getProyecto() throws SQLException;

}
