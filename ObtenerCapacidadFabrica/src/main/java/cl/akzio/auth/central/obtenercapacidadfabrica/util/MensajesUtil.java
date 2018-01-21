/* Propiedad de Akzio Fabrica Temuco. Todos los derechos reservados */
package cl.akzio.auth.central.obtenercapacidadfabrica.util;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cl.akzio.auth.central.obtenercapacidadfabrica.exception.ConfigurationException;
import cl.akzio.auth.central.obtenercapacidadfabrica.log4j.AkzioLogger;

/**
 * @author Marcel Aedo (Akzio Consultores S.A.) en nombre de Daniela Cruz(Akzio Consultores S.A.)
 * @since 10-01-2018
 * @version 1.0
 */
public class MensajesUtil implements Serializable {
	/**
	 * Atributo serialVersionUID long
	 */
	private static final long serialVersionUID = 5652548126367946844L;
	
	
	/**
	 * Atributo generarCargoACuentaPRProperties Properties
	 */
	private static Properties obtenerCapacidadFabricaProperties = new Properties();
	/**
	 * Atributo generarCargoACuentaPRLogger EntelLogger
	 */
	private static AkzioLogger obtenerCapacidadFabricaLogger = AkzioLogger.getLogger("MensajesUtil");
	/**
	 * Devuelve un mensaje contenido en el propertie consultado.
	 * 
	 * @param resource String
	 * @param key String
	 * @return String
	 * @throws ConfigurationException
	 */
	public static String getMensaje(String resource, String key) throws ConfigurationException {

		String mensaje = "";

		if(resource == null || "".equals(resource.trim())){
			/* Se setea el valor por defecto del nombre del archivo de configuracion */
			resource = "config";
		}
		if(obtenerCapacidadFabricaProperties == null || obtenerCapacidadFabricaProperties.isEmpty()){
			StringBuffer sbInputStream = new StringBuffer();
			InputStream is = null;
			obtenerCapacidadFabricaProperties = new Properties();
			try{
				sbInputStream = new StringBuffer();
				sbInputStream = sbInputStream
						.append("./aplsEPCS/ASI_OBTENERCAPACIDADFABRICA/config/")
						.append(resource.trim())
						.append(".properties");
				is = new FileInputStream(sbInputStream.toString());
				obtenerCapacidadFabricaProperties.load(is);
			}catch(FileNotFoundException e){
				/* Archivo config.properties no encontrado */
				getLogger().error("Ocurre FileNotFoundException: [" + Utils.quitarSaltoLinea(String.valueOf(e)) + "]");
				getLogger().error("Codigo [" + Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0100 + "] "
						+ "Archivo " + sbInputStream.toString() + " no encontrado");
				throw new ConfigurationException(Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0100,
						"Archivo " + resource + ".properties no encontrado");
			}catch(IOException e){
				/* Error al leer archivo config.properties */
				getLogger().error("Ocurre IOException: [" + Utils.quitarSaltoLinea(String.valueOf(e)) + "]");
				getLogger().error("Codigo [" + Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0100 + "] "
						+ "Error de lectura de archivo " + sbInputStream.toString());
				throw new ConfigurationException(Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0100,
						"Error al leer archivo " + resource + ".properties");
			}finally{
				if(is != null){
					try{
						is.close();
					}catch(IOException e){
						getLogger().info("No se ha podido cerrar la instancia del archivo " + resource + ".properties");
					}
				}
			}
		}
		mensaje = obtenerCapacidadFabricaProperties.getProperty(key);
		if(mensaje == null){
			/* Error en valores de configuracion */
			getLogger().error("Error al obtener el valor del propertie [" + key + "]");
			getLogger().error("Codigo [" + Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0103 + "] "
					+ "Error en valores de configuracion");
			throw new ConfigurationException(Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0103,
					"Error en valores de configuracion");
		}
		return mensaje.trim();
	}
	/**
	 * @return AkzioLoggerLogger
	 */
	public static AkzioLogger getLogger() {
		return obtenerCapacidadFabricaLogger;
	}
	/**
	 * @return the generarCargoACuentaPRProperties
	 */
	public static Properties getObtenerCapacidadFabricaProperties() {
		return obtenerCapacidadFabricaProperties;
	}
	/**
	 * @param generarCargoACuentaPRProperties the generarCargoACuentaPRProperties to set
	 */
	public static void setObtenerCapacidadFabricaProperties(
			Properties generarCargoACuentaPRProperties) {
		MensajesUtil.obtenerCapacidadFabricaProperties = obtenerCapacidadFabricaProperties;
	}

	
}
