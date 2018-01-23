package cl.akzio.auth.central.obtenercapacidadfabrica.DTO;

import java.sql.Date;

public class ArtefactoDTO {

	private int codiArtefacto;
	private int codiProducto;
	private int codiSolicitud;
	private String codiRedmine;
	private float nhhSolicitaads;
	private Date fechEntrega;
	private String nombArtefacto;
	private String nombProducto;
	private String nombEstado;
	private String nombUsuario;
	private String nombProyecto;
	/**
	 * @param codiArtefacto
	 * @param codiProducto
	 * @param codiSolicitud
	 * @param codiRedmine
	 * @param nhhSolicitaads
	 * @param fechEntrega
	 * @param nombArtefacto
	 * @param nombProducto
	 * @param nombEstado
	 * @param nombUsuario
	 * @param nombProyecto
	 */
	public ArtefactoDTO(int codiArtefacto, int codiProducto, int codiSolicitud,
			String codiRedmine, float nhhSolicitaads, Date fechEntrega,
			String nombArtefacto, String nombProducto, String nombEstado,
			String nombUsuario, String nombProyecto) {
		super();
		this.codiArtefacto = codiArtefacto;
		this.codiProducto = codiProducto;
		this.codiSolicitud = codiSolicitud;
		this.codiRedmine = codiRedmine;
		this.nhhSolicitaads = nhhSolicitaads;
		this.fechEntrega = fechEntrega;
		this.nombArtefacto = nombArtefacto;
		this.nombProducto = nombProducto;
		this.nombEstado = nombEstado;
		this.nombUsuario = nombUsuario;
		this.nombProyecto = nombProyecto;
	}
	/**
	 * 
	 */
	public ArtefactoDTO() {
		super();
	}
	/**
	 * @return the codiArtefacto
	 */
	public int getCodiArtefacto() {
		return codiArtefacto;
	}
	/**
	 * @param codiArtefacto the codiArtefacto to set
	 */
	public void setCodiArtefacto(int codiArtefacto) {
		this.codiArtefacto = codiArtefacto;
	}
	/**
	 * @return the codiProducto
	 */
	public int getCodiProducto() {
		return codiProducto;
	}
	/**
	 * @param codiProducto the codiProducto to set
	 */
	public void setCodiProducto(int codiProducto) {
		this.codiProducto = codiProducto;
	}
	/**
	 * @return the codiSolicitud
	 */
	public int getCodiSolicitud() {
		return codiSolicitud;
	}
	/**
	 * @param codiSolicitud the codiSolicitud to set
	 */
	public void setCodiSolicitud(int codiSolicitud) {
		this.codiSolicitud = codiSolicitud;
	}
	/**
	 * @return the codiRedmine
	 */
	public String getCodiRedmine() {
		return codiRedmine;
	}
	/**
	 * @param codiRedmine the codiRedmine to set
	 */
	public void setCodiRedmine(String codiRedmine) {
		this.codiRedmine = codiRedmine;
	}
	/**
	 * @return the nhhSolicitaads
	 */
	public float getNhhSolicitaads() {
		return nhhSolicitaads;
	}
	/**
	 * @param nhhSolicitaads the nhhSolicitaads to set
	 */
	public void setNhhSolicitaads(float nhhSolicitaads) {
		this.nhhSolicitaads = nhhSolicitaads;
	}
	/**
	 * @return the fechEntrega
	 */
	public Date getFechEntrega() {
		return fechEntrega;
	}
	/**
	 * @param fechEntrega the fechEntrega to set
	 */
	public void setFechEntrega(Date fechEntrega) {
		this.fechEntrega = fechEntrega;
	}
	/**
	 * @return the nombArtefacto
	 */
	public String getNombArtefacto() {
		return nombArtefacto;
	}
	/**
	 * @param nombArtefacto the nombArtefacto to set
	 */
	public void setNombArtefacto(String nombArtefacto) {
		this.nombArtefacto = nombArtefacto;
	}
	/**
	 * @return the nombProducto
	 */
	public String getNombProducto() {
		return nombProducto;
	}
	/**
	 * @param nombProducto the nombProducto to set
	 */
	public void setNombProducto(String nombProducto) {
		this.nombProducto = nombProducto;
	}
	/**
	 * @return the nombEstado
	 */
	public String getNombEstado() {
		return nombEstado;
	}
	/**
	 * @param nombEstado the nombEstado to set
	 */
	public void setNombEstado(String nombEstado) {
		this.nombEstado = nombEstado;
	}
	/**
	 * @return the nombUsuario
	 */
	public String getNombUsuario() {
		return nombUsuario;
	}
	/**
	 * @param nombUsuario the nombUsuario to set
	 */
	public void setNombUsuario(String nombUsuario) {
		this.nombUsuario = nombUsuario;
	}
	/**
	 * @return the nombProyecto
	 */
	public String getNombProyecto() {
		return nombProyecto;
	}
	/**
	 * @param nombProyecto the nombProyecto to set
	 */
	public void setNombProyecto(String nombProyecto) {
		this.nombProyecto = nombProyecto;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ArtefactoDTO [codiArtefacto=" + codiArtefacto
				+ ", codiProducto=" + codiProducto + ", codiSolicitud="
				+ codiSolicitud + ", codiRedmine=" + codiRedmine
				+ ", nhhSolicitaads=" + nhhSolicitaads + ", fechEntrega="
				+ fechEntrega + ", nombArtefacto=" + nombArtefacto
				+ ", nombProducto=" + nombProducto + ", nombEstado="
				+ nombEstado + ", nombUsuario=" + nombUsuario
				+ ", nombProyecto=" + nombProyecto + "]";
	}
	
		
	
}
