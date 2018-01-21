/* Propiedad de Akzio Fabrica Temuco. Todos los derechos reservados */
package cl.akzio.auth.central.obtenercapacidadfabrica.validador;


import java.io.Serializable;

import cl.akzio.auth.central.obtenercapacidadfabrica.exception.BusinessException;
import cl.akzio.auth.central.obtenercapacidadfabrica.exception.ConfigurationException;
import cl.akzio.auth.central.obtenercapacidadfabrica.exception.DummyException;
import cl.akzio.auth.central.obtenercapacidadfabrica.exception.SystemException;
import cl.akzio.auth.central.obtenercapacidadfabrica.log4j.AkzioLogger;
import cl.akzio.auth.central.obtenercapacidadfabrica.types.request.ObtenerCapacidadFabricaRequestType;
import cl.akzio.auth.central.obtenercapacidadfabrica.types.request.RequestType;
import cl.akzio.auth.central.obtenercapacidadfabrica.types.response.HeaderOutType;
import cl.akzio.auth.central.obtenercapacidadfabrica.types.response.ResponseType;
import cl.akzio.auth.central.obtenercapacidadfabrica.util.Constantes;
import cl.akzio.auth.central.obtenercapacidadfabrica.util.MensajesUtil;
/**
 * @author Marcel Aedo (Akzio Consultores S.A.) en nombre de Daniela Cruz(Akzio Consultores S.A.)
 * @since 10-01-2018
 * @version 1.0
 */
public class Validador implements Serializable{
	/**
	 * Atributo serialVersionUID long
	 */
	private static final long serialVersionUID = 7511086572756952098L;
	
	
	/**
	 * 
	 */
	public Validador() {
		super();
	}
	/**
	 * @param logger
	 */
	public Validador(AkzioLogger logger) {
		super();
		this.logger = logger;
	}
	/**
	 * Atributo logger EntelLogger
	 */
	private AkzioLogger logger = AkzioLogger.getLogger("Validador");
	/**
	 * Constructor de la Clase Validador
	 */

	/**
	 * Realiza la validacion de los campos de entrada.<br />
	 * 
	 * @param request RequestType
	 * @throws BusinessException
	 * @throws ConfigurationException
	 */
	public void validarCamposEntradas(ObtenerCapacidadFabricaRequestType parametros)throws BusinessException, ConfigurationException {
		RequestType request = null;
		getLogger().info("validacion de datos de entrada...");
		if(parametros == null){
			getLogger().error("Parametros no informados");
			/* Envio el error del primer parametro no informado */
			String mensaje = MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0300);
			getLogger().error("Codigo [" + Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0300 + "] " + mensaje);
			getLogger().info("fin Validando campos de entrada...");
			throw new BusinessException(Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0300, mensaje);
		}else{
			request = parametros.getRequest();
		}
		if(request == null){
			getLogger().error("Request no informado");
			getLogger().error("Codigo [" + Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0300 + "] " 
					+ MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0300));
			getLogger().info("fin Validando campos de entrada...");
			throw new BusinessException(Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0300, 
					MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0300));
		}else{
			String codH = MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODLINEASUSCRIPCIONVALIDACION_H);
			String codM = MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODLINEASUSCRIPCIONVALIDACION_M);
			getLogger().info("Parametros de entrada: " + request.toString());
		}
	}
	/**
	 * Verifica el modo de ejecucion del servicio.<br/>
	 * <p>modos:
	 *    <ul>
	 *    <li>Normal (valor por defecto)</li>
	 *    <li>Fuera de Servicio</li>
	 *    <li>Dummy</li>
	 *    </ul>
	 * </p>
	 * @throws ConfigurationException
	 * @throws SystemException
	 * @throws DummyException
	 */
	public void modo() throws ConfigurationException, SystemException,DummyException {
		//getLogger().info("Validando modo de ejecucion del servicio...");
		String sEstadoWS = MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_KEY_ESTADOWS);
		if(Constantes.OBTENERCAPACIDADFABRICA_ESTADOWS_FUERADESERVICIO.equals(sEstadoWS)){
			getLogger().info("... Entrando en modo Fuera de Servicio");
			String mensaje = MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0202);
			getLogger().error("Codigo [" + Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0202 + "] " + mensaje);
			throw new SystemException(Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0202, mensaje);
		}else if(Constantes.OBTENERCAPACIDADFABRICA_ESTADOWS_DUMMY.equals(sEstadoWS)){
			getLogger().info("... Entrando en modo Dummy");
			/* Obtengo valores dummy de salida desde propertie */
			getLogger().info("Obteniendo los valores desde archivo de configuracion...");
			String tipoRespuesta = MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_KEY_RESPDUMMY);
			if(Constantes.OBTENERCAPACIDADFABRICA_RESPDUMMY_FAULT.equals(tipoRespuesta)){
				String mensaje = MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0301);
				getLogger().warn("Codigo [" + Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0301 + "] " + mensaje);
				throw new DummyException(Constantes.OBTENERCAPACIDADFABRICA_CODIGO_0301, mensaje, null, Boolean.FALSE);
			}else{
				String codigo = MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_DUMMY_CODIGO);
				String descripcion = MensajesUtil.getMensaje(Constantes.OBTENERCAPACIDADFABRICA_RESOURCE_CONFIG, Constantes.OBTENERCAPACIDADFABRICA_DUMMY_DESCRIPCION);
				ResponseType response = new ResponseType();
				response.setHeaderOut(new HeaderOutType());
				response.getHeaderOut().setCode(codigo);
				response.getHeaderOut().setDescription(descripcion);
				throw new DummyException(codigo, descripcion, response ,Boolean.TRUE);
			}
		}
		//getLogger().info("... Entrando en modo Normal");
	}
	/**
	 * Valida si el codigo retornado por el servicio web WSQPS-FU corresponde a una ejecucion correcta
	 * @param codigo String
	 * @param codigos String
	 * @return Boolean
	 */
	public Boolean validadorCodigo(String codigo, String codigos) {
		getLogger().info("  Comparando codigo [" + codigo + "]");
		getLogger().info("  con lista de codigos de exito alternativo [" + codigos + "]");
		String[] listCodigos = codigos.split(",");
		codigo = codigo.trim();
		Boolean esCorrecto = false;
		int max = listCodigos.length;
		int iter = 0;
		while(iter < max){
			if(listCodigos[iter].trim().equals(codigo)){
				esCorrecto = true;
				break;
			}
			iter++;
		}
		return esCorrecto;
	}
	public AkzioLogger getLogger() {
		return logger;
	}
	public void setLogger(AkzioLogger logger) {
		this.logger = logger;
	}


}
