
package cl.akzio.auth.central.obtenercapacidadfabrica.service;
import java.io.Serializable;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.BindingType;


import cl.akzio.auth.central.obtenercapacidadfabrica.exception.BusinessException;
import cl.akzio.auth.central.obtenercapacidadfabrica.exception.ConfigurationException;
import cl.akzio.auth.central.obtenercapacidadfabrica.exception.DummyException;
import cl.akzio.auth.central.obtenercapacidadfabrica.exception.SystemException;
import cl.akzio.auth.central.obtenercapacidadfabrica.log4j.AkzioLogger;
import cl.akzio.auth.central.obtenercapacidadfabrica.types.fault.ObtenerCapacidadFabricaFaultType;
import cl.akzio.auth.central.obtenercapacidadfabrica.types.request.ObtenerCapacidadFabricaRequestType;
import cl.akzio.auth.central.obtenercapacidadfabrica.types.response.HeaderOutType;
import cl.akzio.auth.central.obtenercapacidadfabrica.types.response.ObtenerCapacidadFabricaResponseType;
import cl.akzio.auth.central.obtenercapacidadfabrica.types.response.ResponseType;
import cl.akzio.auth.central.obtenercapacidadfabrica.util.Constantes;
import cl.akzio.auth.central.obtenercapacidadfabrica.util.MensajesUtil;
import cl.akzio.auth.central.obtenercapacidadfabrica.util.Utils;
import cl.akzio.auth.central.obtenercapacidadfabrica.validador.Validador;

@WebService(portName = "ObtenerCapacidadFabricaPort",
serviceName = "ObtenerCapacidadFabrica",
targetNamespace = "http://www.akzio.cl/auth/central/t/obtenercapacidadfabrica/",
wsdlLocation = "WEB-INF/wsdl/ObtenerCapacidadFabrica.wsdl",
endpointInterface = "cl.akzio.auth.central.obtenercapacidadfabrica.service.ObtenerCapacidadFabricaPortType")
@BindingType("http://schemas.xmlsoap.org/wsdl/soap/http")
public class ObtenerCapacidadFabricaPortTypeImpl implements Serializable {
	/**
	 * Atributo serialVersionUID long
	 */
	private static final long serialVersionUID = -5615953217286260387L;
	/** Atributo logger akzio Logger. */
	private AkzioLogger logger = AkzioLogger.getLogger("ObtenerCapacidadFabricaPortTypeImpl");

	public ObtenerCapacidadFabricaPortTypeImpl() {
		super();
	}

	public ObtenerCapacidadFabricaPortTypeImpl(AkzioLogger logger) {
		super();
		this.logger = logger;
	}



	

	

	/**
	 * @return the logger
	 */
	public AkzioLogger getLogger() {
		return logger;
	}

	/**
	 * @param logger the logger to set
	 */
	public void setLogger(AkzioLogger logger) {
		this.logger = logger;
	}

	/**
	 * Tiempo ejecucion.
	 *
	 * @param inicio the inicio
	 * @return the long
	 */
	private long tiempoEjecucion(long inicio){
		long fin = Utils.getTime();
		return fin - inicio;
	}

	
	
	
}
