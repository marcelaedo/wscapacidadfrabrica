/* Propiedad de Akzio Fabrica Temuco. Todos los derechos reservados */

package cl.akzio.auth.central.obtenercapacidadfabrica.exception;

import java.io.Serializable;

import cl.akzio.auth.central.obtenercapacidadfabrica.types.response.ResponseType;



/**
 * @author Marcel Aedo (Akzio Consultores S.A.) en nombre de Daniela Cruz(Akzio Consultores S.A.)
 * @since 10-01-2018
 * @version 1.0
 */
public class DummyException extends Exception implements Serializable{
	
	
	
	public DummyException() {
		super();
	}
	public DummyException(String codigo, String mensaje, Boolean esResponse,
			ResponseType response) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.esResponse = esResponse;
		this.response = response;
	}
	/**
	 * Atributo serialVersionUID long
	 */
	private static final long serialVersionUID = 1621105678207283874L;

	/**
     * Atributo codigo String
     */
    private String codigo;
    /**
     * Atributo mensaje String
     */
    private String mensaje;
    /**
     * Atributo esResponse Boolean
     */
    private Boolean esResponse;
    /**
     * Atributo response ResponseType
     */
    private ResponseType response;
    /**
     * Constructor de la Clase DummyException
     * @param codigo String
     * @param mensaje String
     */
    public DummyException(String codigo, String mensaje) {
        super();
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.esResponse = Boolean.TRUE;
    }
    /**
     * Constructor de la Clase DummyException
     * @param codigo String
     * @param mensaje String
     * @param valores ResponseType
     * @param esResponse Boolean
     */
    public DummyException(String codigo, String mensaje, ResponseType response, Boolean esResponse) {
        super();
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.response = response;
        this.esResponse = esResponse;
    }
    /**
     * @return String
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * @param codigo String
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * @return String
     */
    public String getMensaje() {
        return mensaje;
    }
    /**
     * @param mensaje String
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    /**
	 * @return ResponseType
	 */
	public ResponseType getResponse() {
		return response;
	}
	/**
	 * @param response ResponseType
	 */
	public void setResponse(ResponseType response) {
		this.response = response;
	}
	/**
     * @return Boolean
     */
    public Boolean getEsResponse() {
        return esResponse;
    }

    /**
     * @param esResponse Boolean
     */
    public void setEsResponse(Boolean esResponse) {
        this.esResponse = esResponse;
    }
    /**
     * toString
     */
    @Override
    public String toString() {
        StringBuffer salida = new StringBuffer();
        salida.append("DummyException[");
        salida.append("codigo=[").append(getCodigo()).append("]");
        salida.append("mensaje=[").append(getMensaje()).append("]");
        salida.append("response=[").append(getResponse()).append("]");
        salida.append("esResponse=[").append(getEsResponse()).append("]");
        salida.append("]");
        return salida.toString();
    }
}
