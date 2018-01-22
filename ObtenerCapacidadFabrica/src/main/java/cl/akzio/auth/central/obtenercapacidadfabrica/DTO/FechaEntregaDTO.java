package cl.akzio.auth.central.obtenercapacidadfabrica.DTO;

import java.sql.Date;

public class FechaEntregaDTO {

	private Date fech_entrega;

	/**
	 * 
	 */
	public FechaEntregaDTO() {
		super();
	}

	/**
	 * @param fech_entrega
	 */
	public FechaEntregaDTO(Date fech_entrega) {
		super();
		this.fech_entrega = fech_entrega;
	}

	/**
	 * @return the fech_entrega
	 */
	public Date getFech_entrega() {
		return fech_entrega;
	}

	/**
	 * @param fech_entrega the fech_entrega to set
	 */
	public void setFech_entrega(Date fech_entrega) {
		this.fech_entrega = fech_entrega;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FechaEntregaDTO [fech_entrega=" + fech_entrega + "]";
	}
	
	
	
}
