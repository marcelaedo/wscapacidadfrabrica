/* Propiedad de Akzio Fabrica Temuco. Todos los derechos reservados */
package cl.akzio.auth.central.obtenercapacidadfabrica.provider;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import cl.akzio.auth.central.obtenercapacidadfabrica.exception.ConfigurationException;
import cl.akzio.auth.central.obtenercapacidadfabrica.exception.SystemException;
import cl.akzio.auth.central.obtenercapacidadfabrica.log4j.AkzioLogger;
import cl.akzio.auth.central.obtenercapacidadfabrica.util.Constantes;
import cl.akzio.auth.central.obtenercapacidadfabrica.util.MensajesUtil;
/**
 * @author Marcel Aedo (Akzio Consultores S.A.) en nombre de Daniela Cruz(Akzio Consultores S.A.)
 * @since 10-01-2018
 * @version 1.0
 */
public abstract class ConnectionOracle implements Serializable{
	/**
	 * Atributo serialVersionUID long
	 */
	private static final long serialVersionUID = -4705416368289119178L;
	/**
	 * Atributo logger EntelLogger
	 */
	private AkzioLogger logger = AkzioLogger.getLogger("ConnectionOracle");
	/**
	 * Atributo Connection objConnOracle.
	 */
	private Connection objConnOracle;
	/**
	 * Realiza la conexion sobre la base de datos.
	 * 
	 * @param autoCommit Boolean
	 * @throws ConfigurationException
	 * @throws SystemException
	 */
	public void conectar(Boolean autoCommit) throws ConfigurationException,SystemException {

		getLogger().info("Obteniendo conexion...");

		if(autoCommit == null){
			autoCommit = Boolean.FALSE;
		}

		DataSource dataSource = null;
		String jndi = "";
		try{
			Context context = new InitialContext();
			getLogger().info("Extrayendo DataSource del contexto del sistema");
			jndi = MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_KEY_JNDI);
			dataSource = (DataSource) context.lookup(jndi);
			getLogger().info("Estableciendo el objeto de conexion a BBDD");
			setObjConnOracle(dataSource.getConnection());
			if(getObjConnOracle() != null && !getObjConnOracle().isClosed()){
				getObjConnOracle().setAutoCommit(autoCommit);
				getLogger().info("Conexion exitosa a BBDD Oracle");
				getLogger().info("JNDI [" + jndi + "]");
			}else{
				getLogger().error("Conexion erronea a BBDD Oracle");
				getLogger().error("JNDI [" + jndi + "]");
				getLogger().error("Codigo [" + Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0203 + "] "
						+ MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0203));
				throw new SystemException(Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0200,
						 MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0203));
			}
		}catch(NamingException e){
			getLogger().error("El JNDI [" + jndi + "] no esta correctamente configurado");
			getLogger().error("Mensaje: " + e.getMessage());
			getLogger().error("Causa: " + e.getCause());
			getLogger().error("Codigo [" + Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0104+ "] "
					+ MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0104));
			throw new ConfigurationException(Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0100,
					 MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0104));
		}catch(SQLException e){
			getLogger().error("JNDI [" + jndi + "]");
			getLogger().error("Error SQL [" + e.getErrorCode() + "] al extraer el DataSource de los Origenes de Datos de Weblogic");
			getLogger().error("Mensaje: " + e.getMessage());
			getLogger().error("Causa: " + e.getCause());
			getLogger().error("Codigo [" + Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0203 + "] "
					+ MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0203));
			throw new SystemException(Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0200,
					MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0203));
		}catch(ConfigurationException e){
			throw e;
		}
	}
	public void desconectar() throws SQLException {
		if(getObjConnOracle() != null && !getObjConnOracle().isClosed()){
			getObjConnOracle().setAutoCommit(true);
			getObjConnOracle().close();
			setObjConnOracle(null);
		}
		getLogger().info("Desconexion exitosa de BBDD Oracle");
	}
	/**
	 * Realiza el commit sobre la base de datos.
	 * 
	 * @throws SQLException
	 */
	public void commit() throws SQLException {
		getLogger().info("Realizando COMMIT");
		if(getObjConnOracle() != null && !getObjConnOracle().isClosed()){
			getObjConnOracle().commit();
		}
	}
	/**
	 * Realiza rollback sobre la base de datos.
	 * 
	 * @throws SQLException
	 */
	public void rollback() throws SQLException {
		getLogger().info("Realizando ROLLBACK");
		if(getObjConnOracle() != null && !getObjConnOracle().isClosed()){
			getObjConnOracle().rollback();
		}
	}
	/**
	 * @return Connection
	 */
	public Connection getObjConnOracle() {
		return objConnOracle;
	}
	/**
	 * @param objConnOracle Connection
	 */
	public void setObjConnOracle(Connection objConnOracle) {
		this.objConnOracle = objConnOracle;
	}
	public AkzioLogger getLogger() {
		return logger;
	}
	public void setLogger(AkzioLogger logger) {
		this.logger = logger;
	}

}
