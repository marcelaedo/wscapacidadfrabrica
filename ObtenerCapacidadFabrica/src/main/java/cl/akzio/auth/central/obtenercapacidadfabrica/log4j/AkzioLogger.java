
package cl.akzio.auth.central.obtenercapacidadfabrica.log4j;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class AkzioLogger implements Serializable {
	/**
	 * Atributo serialVersionUID long
	 */
	private static final long serialVersionUID = 5079542311826659639L;
	/**
	 * Atributo generarCargoACuentaPRTransactionId Map<String, String>
	 */
	private static Map<String, String> generarCargoACuentaPRTransactionId = new LinkedHashMap<String, String>();
	/**
	 * Atributo generarCargoACuentaPRLogger Map<String, EntelLogger>
	 */
	private static Map<String, AkzioLogger> generarCargoACuentaPRLogger = new LinkedHashMap<String, AkzioLogger>();
	/**
	 * Atributo name String
	 */
	private String name;
	/**
	 * Constructor de la Clase EntelLogger
	 */
	public AkzioLogger() {
		super();
	}
	/**
	 * Constructor de la Clase EntelLogger
	 * @param name String
	 */
	public AkzioLogger(String name) {
		this.name = name;
	}
	/**
	 * @param name String
	 * @return EntelLogger
	 */
	public static AkzioLogger getLogger(String name) {
		if(generarCargoACuentaPRLogger.containsKey(name)){
			return generarCargoACuentaPRLogger.get(name);
		}
		AkzioLogger newlog = new AkzioLogger(name);
		generarCargoACuentaPRLogger.put(name, newlog);
		return newlog;
	}
	/**
	 * @param classname Class<?>
	 * @return EntelLogger
	 */
	public static AkzioLogger getLogger(Class<?> classname) {
		return getLogger(classname.toString());
	}
	/**
	 * @param transId String
	 */
	public void setTransId(String transId) {
		generarCargoACuentaPRTransactionId.put(Thread.currentThread().getName(), transId.trim());
	}
	/**
	 * @return String
	 */
	public String getTransactionId() {
		return generarCargoACuentaPRTransactionId.get(Thread.currentThread().getName());
	}
	/**
	 * @return String
	 */
	private String getTransid() {
		String transid = generarCargoACuentaPRTransactionId.get(Thread.currentThread().getName());
		if(transid == null){
			transid = " ";
		}else{
			transid = "[" + transid + "] ";
		}
		return transid;
	}
	/**
	 * @param msg Object
	 */
	public void trace(Object msg) {
		String trazaLog = getTransid() + msg;
		Logger.getLogger(getName()).trace(trazaLog);
	}
	/**
	 * @param msg Object
	 */
	public void debug(Object msg) {
		String trazaLog = getTransid() + msg;
		Logger.getLogger(getName()).debug(trazaLog);
	}
	/**
	 * @param msg Object
	 */
	public void info(Object msg) {
		String trazaLog = getTransid() + msg;
		Logger.getLogger(getName()).info(trazaLog);
	}
	/**
	 * @param msg Object
	 */
	public void warn(Object msg) {
		String trazaLog = getTransid() + msg;
		Logger.getLogger(getName()).warn(trazaLog);
	}
	/**
	 * @param msg Object
	 */
	public void error(Object msg) {
		String trazaLog = getTransid() + msg;
		Logger.getLogger(getName()).error(trazaLog);
	}
	/**
	 * @param msg Object
	 * @param t Throwable
	 */
	public void error(Object msg, Throwable t) {
		String trazaLog = getTransid() + msg + " , " + t;
		Logger.getLogger(getName()).error(trazaLog);
	}
	/**
	 * @param msg Object
	 */
	public void fatal(Object msg) {
		String trazaLog = getTransid() + msg;
		Logger.getLogger(getName()).fatal(trazaLog);
	}
	/**
	 * @return name String
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Map<String, String>
	 */
	public static Map<String, String> getGenerarCargoACuentaPRTransactionId() {
		return generarCargoACuentaPRTransactionId;
	}
	/**
	 * @param generarCargoACuentaPRTransactionId Map<String, String>
	 */
	public static void setGenerarCargoACuentaPRTransactionId(
			Map<String, String> generarCargoACuentaPRTransactionId) {
		AkzioLogger.generarCargoACuentaPRTransactionId = generarCargoACuentaPRTransactionId;
	}
	/**
	 * @return Map<String, EntelLogger>
	 */
	public static Map<String, AkzioLogger> getGenerarCargoACuentaPRLogger() {
		return generarCargoACuentaPRLogger;
	}
	/**
	 * @param generarCargoACuentaPRLogger Map<String, EntelLogger>
	 */
	public static void setGenerarCargoACuentaPRLogger(
			Map<String, AkzioLogger> generarCargoACuentaPRLogger) {
		AkzioLogger.generarCargoACuentaPRLogger = generarCargoACuentaPRLogger;
	}
	
	
}
