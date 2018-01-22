package cl.akzio.auth.central.obtenercapacidadfabrica.DTO;

public class UsuarioDTO {

	private String nomUsuario;
	private String flagEstado;
	private String nombCargo;
	private String nomFabrica;
	/**
	 * 
	 */
	public UsuarioDTO() {
		super();
	}


	/**
	 * @param nomUsuario
	 * @param flagEstado
	 * @param nombCargo
	 * @param nomFabrica
	 */
	public UsuarioDTO(String nomUsuario, String flagEstado, String nombCargo,
			String nomFabrica) {
		super();
		this.nomUsuario = nomUsuario;
		this.flagEstado = flagEstado;
		this.nombCargo = nombCargo;
		this.nomFabrica = nomFabrica;
	}


	/**
	 * @return the nomUsuario
	 */
	public String getNomUsuario() {
		return nomUsuario;
	}


	/**
	 * @param nomUsuario the nomUsuario to set
	 */
	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}


	/**
	 * @return the flagEstado
	 */
	public String getFlagEstado() {
		return flagEstado;
	}


	/**
	 * @param flagEstado the flagEstado to set
	 */
	public void setFlagEstado(String flagEstado) {
		this.flagEstado = flagEstado;
	}


	/**
	 * @return the nombCargo
	 */
	public String getNombCargo() {
		return nombCargo;
	}


	/**
	 * @param nombCargo the nombCargo to set
	 */
	public void setNombCargo(String nombCargo) {
		this.nombCargo = nombCargo;
	}


	/**
	 * @return the nomFabrica
	 */
	public String getNomFabrica() {
		return nomFabrica;
	}


	/**
	 * @param nomFabrica the nomFabrica to set
	 */
	public void setNomFabrica(String nomFabrica) {
		this.nomFabrica = nomFabrica;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsuarioDTO [nomUsuario=" + nomUsuario + ", flagEstado="
				+ flagEstado + ", nombCargo=" + nombCargo + ", nomFabrica="
				+ nomFabrica + "]";
	}
	
	
	
}
