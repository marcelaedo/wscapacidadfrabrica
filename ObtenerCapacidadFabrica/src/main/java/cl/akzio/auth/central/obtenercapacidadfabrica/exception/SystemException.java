/* Propiedad de Akzio Fabrica Temuco. Todos los derechos reservados */
package cl.akzio.auth.central.obtenercapacidadfabrica.exception;
/**
 * @author Marcel Aedo (Akzio Consultores S.A.) en nombre de Daniela Cruz(Akzio Consultores S.A.)
 * @since 10-01-2018
 * @version 1.0
 */
public class SystemException extends Exception{
	/**
	 * Atributo serialVersionUID long
	 */
	private static final long serialVersionUID = -3856585441718520945L;
	/**
     * Atributo codigo String
     */
    private String codigo;
    /**
     * Atributo mensaje String
     */
    private String mensaje;
    /**
     * Constructor de la Clase SystemException
     */
    public SystemException() {
        super();
    }
    /**
     * Constructor de la Clase SystemException
     * @param codigo String
     * @param mensaje String
     */
    public SystemException(String codigo, String mensaje) {
        super();
        this.codigo = codigo;
        this.mensaje = mensaje;
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
     * toString
     */
    @Override
    public String toString() {
        StringBuffer salida = new StringBuffer();
        salida.append("SystemException[");
        salida.append("codigo=[").append(getCodigo()).append("]");
        salida.append("mensaje=[").append(getMensaje()).append("]");
        salida.append("]");
        return salida.toString();
    }	
}
