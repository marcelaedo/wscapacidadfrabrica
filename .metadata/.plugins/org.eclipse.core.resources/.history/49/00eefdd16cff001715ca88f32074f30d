/* Propiedad de Akzio Fabrica Temuco. Todos los derechos reservados */
package cl.akzio.auth.central.obtenercapacidadfabrica.provider;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

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
public abstract class ConnectionMySql implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2961591761512308636L;
	/**
	 * Atributo logger akzioLogger
	 */
	private AkzioLogger logger = AkzioLogger.getLogger("ConnectionMySQL");
	/**
	 * Atributo Connection objConnOracle.
	 */
	private Connection objConnMySQL;
	/**
	 * Atributo conexiones Map<String,Connection>
	 */
	protected static Map<String , Connection> conexiones;
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
			if(getObjConnMySQL() != null && !getObjConnMySQL().isClosed()){
				getObjConnMySQL().setAutoCommit(autoCommit);
				getLogger().info("Conexion exitosa a BBDD MySQL");
				getLogger().error("JNDI [" + jndi + "] ");
			}else{
				getLogger().error("Conexion erronea a BBDD MySQL");
				getLogger().error("JNDI [" + jndi + "] ");
				getLogger().error("Codigo [" + Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0203 + "] "
						+ MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0203));
				throw new SystemException(Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0200,
						 MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0203) );
			}
		}catch(NamingException e){
			getLogger().error("El JNDI [" + jndi + "] no esta correctamente configurado");
			getLogger().error("Mensaje: " + e.getMessage());
			getLogger().error("Causa: " + e.getCause());
			getLogger().error("Codigo [" + Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0104 + "] "
					+ MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0104));
			throw new ConfigurationException(Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0100,
					 MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0104) + "]");
		}catch(SQLException e){
			getLogger().error("JNDI [" + jndi + "] ");
			getLogger().error("Error SQL [" + e.getErrorCode() + "] al extraer el DataSource de los Origenes de Datos de Weblogic");
			getLogger().error("Mensaje: " + e.getMessage());
			getLogger().error("Causa: " + e.getCause());
			getLogger().error("Codigo [" + Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0203 + "] "
					+ MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0203));
			throw new SystemException(Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0200,
					MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0203) );
		}catch(ConfigurationException e){
			throw e;
		}
	}
	public void desconectar() throws SQLException {
		if(getObjConnMySQL() != null && !getObjConnMySQL().isClosed()){
			getObjConnMySQL().setAutoCommit(true);
			getObjConnMySQL().close();
			setObjConnOracle(null);
		}
		getLogger().info("Desconexion exitosa de BBDD MySQL");
	}
	/**
	 * Realiza el commit sobre la base de datos.
	 * 
	 * @throws SQLException
	 */
	public void commit() throws SQLException {
		getLogger().info("Realizando COMMIT");
		if(getObjConnMySQL() != null && !getObjConnMySQL().isClosed()){
			getObjConnMySQL().commit();
		}
	}
	/**
	 * Realiza rollback sobre la base de datos.
	 * 
	 * @throws SQLException
	 */
	public void rollback() throws SQLException {
		getLogger().info("Realizando ROLLBACK");
		if(getObjConnMySQL() != null && !getObjConnMySQL().isClosed()){
			getObjConnMySQL().rollback();
		}
	}
	/**
	 * @return Connection
	 */
	public Connection getObjConnMySQL() {
		return objConnMySQL;
	}
	/**
	 * @param objConnMySQL Connection
	 */
	public void setObjConnOracle(Connection objConnMySQL) {
		this.objConnMySQL = objConnMySQL;
	}
	/**
	 * @return AkzioLogger
	 */
	public AkzioLogger getLogger() {
		return logger;
	}

}
