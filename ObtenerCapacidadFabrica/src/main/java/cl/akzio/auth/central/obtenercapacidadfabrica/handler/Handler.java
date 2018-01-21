/* Propiedad de Akzio Fabrica Temuco. Todos los derechos reservados */
package cl.akzio.auth.central.obtenercapacidadfabrica.handler;

import java.io.Serializable;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cl.akzio.auth.central.obtenercapacidadfabrica.log4j.AkzioLogger;




/**
 * @author Marcel Aedo (Akzio Consultores S.A.) en nombre de Daniela Cruz(Akzio Consultores S.A.)
 * @since 10-01-2018
 * @version 1.0
 */
public class Handler implements SOAPHandler<SOAPMessageContext> , Serializable {
	/**
	 * Atributo serialVersionUID long
	 */
	private static final long serialVersionUID = -4415229211265942240L;
	
	
	public void setLogger(AkzioLogger logger) {
		this.logger = logger;
	}
	/**
	 * Atributo logger akzioLogger
	 */
	private AkzioLogger logger = AkzioLogger.getLogger("Handler");
	
	public Handler(AkzioLogger logger) {
		super();
		this.logger = logger;
	}

	public Handler() {
		super();
	}

	/**
	 * @see javax.xml.ws.handler.Handler#handleMessage(javax.xml.ws.handler.MessageContext)
	 */
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean esSalida = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if(esSalida){
			String prefijoEnvelope = "soapenv";
			String prefijoResponse = "res";

			try{
				SOAPMessage soapMsg = context.getMessage();
				//ASIGNA PREFIJO AL ENVELOPE
				SOAPEnvelope envelope = soapMsg.getSOAPPart().getEnvelope();
				envelope.removeNamespaceDeclaration(envelope.getPrefix());
				envelope.setPrefix(prefijoEnvelope);
				//ASIGNA PREFIJO AL HEADER
				SOAPHeader header = soapMsg.getSOAPHeader();
				header.setPrefix(prefijoEnvelope);
				//ASIGNA PREFIJO AL BODY
				SOAPBody body = soapMsg.getSOAPBody();
				body.setPrefix(prefijoEnvelope);
				//ASIGNA PREFIJO AL RESPONSE (BODY)
				Node responseNode = body.getFirstChild();
				remueveAtributos(responseNode);
				responseNode.setPrefix(prefijoResponse);
				//ASIGA EL PREFIJO A LOS HIJOS DEL RESPONSE
				actualizarNodosHijos(responseNode.getChildNodes(), prefijoResponse);
				context.setMessage(soapMsg);
			}catch(SOAPException e){
				getLogger().warn("Fallo al manejar el mensaje de respuesta");
				return false;
			}catch(Exception e){
				getLogger().warn("Fallo al manejar el mensaje de respuesta");
				return false;
			}
		}
		return true;
	}

	/**
	 * @see javax.xml.ws.handler.Handler#handleFault(javax.xml.ws.handler.MessageContext)
	 */
	@Override
	public boolean handleFault(SOAPMessageContext context) {
		Boolean esSalida = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if(esSalida){
			String prefijoEnvelope = "soapenv";
			String prefijoFault = "faul";
			try{
				SOAPMessage soapMsg = context.getMessage();
				//ASIGNA PREFIJO AL ENVELOPE
				SOAPEnvelope envelope = soapMsg.getSOAPPart().getEnvelope();
				envelope.removeNamespaceDeclaration(envelope.getPrefix());
				envelope.setPrefix(prefijoEnvelope);
				//ASIGNA PREFIJO AL HEADER
				SOAPHeader header = soapMsg.getSOAPHeader();
				header.setPrefix(prefijoEnvelope);
				//ASIGNA PREFIJO AL BODY
				SOAPBody body = soapMsg.getSOAPBody();
				body.setPrefix(prefijoEnvelope);
				//ASIGNA PREFIJO AL FAULT (BODY)
				Node faultNode = body.getFirstChild();
				remueveAtributos(faultNode);
				faultNode.setPrefix(prefijoEnvelope);
				//ASIGA EL PREFIJO A LOS HIJOS DEL FAULT

				for(int i = 0; i < faultNode.getChildNodes().getLength(); i++){
					Node nodo = faultNode.getChildNodes().item(i);
					//Reemplazo faultcode
					if("faultcode".equals(nodo.getNodeName())){
						nodo.getFirstChild().setNodeValue(prefijoEnvelope + ":Server");
					}
					//Reemplazo faulstring
					if("faultstring".equals(nodo.getNodeName())){
						nodo.getFirstChild().setNodeValue("Internal Server Error");
					}
					//SI TIENE HIJOS ASOCIADOS SE DEBE ACTUALIZAR LOS HIJOS
					if("detail".equals(nodo.getNodeName())){
						remueveAtributos(nodo.getFirstChild());
						nodo.getFirstChild().setPrefix(prefijoFault);
						actualizarNodosHijos(nodo.getFirstChild().getChildNodes(), prefijoFault);
						//Remueve el nodo exception
						if(!nodo.getFirstChild().equals(nodo.getLastChild())){
							nodo.removeChild(nodo.getLastChild());
						}
					}
				}
				context.setMessage(soapMsg);
			}catch(SOAPException e){
				getLogger().warn("Fallo al manejar el mensaje de fault");
				return false;
			}catch(Exception e){
				getLogger().warn("Fallo al manejar el mensaje de fault");
				return false;
			}
		}
		return true;
	}

	/**
	 * @see javax.xml.ws.handler.Handler#close(javax.xml.ws.handler.MessageContext)
	 */
	@Override
	public void close(MessageContext context) {
	}
	/**
	 * @see javax.xml.ws.handler.soap.SOAPHandler#getHeaders()
	 */
	@Override
	public Set<QName> getHeaders() {
		return null;
	}
	/**
	 * Metodo recursivo que asigna un prefijo a los elementos que sean nodos
	 * @param listaNodos NodeList
	 * @param prefijo String
	 */
	private void actualizarNodosHijos(NodeList listaNodos, String prefijo) {
		if(listaNodos != null){
			for(int i = 0; i < listaNodos.getLength(); i++){
				Node nodo = listaNodos.item(i);
				//SI TIENE HIJOS ASOCIADOS SE DEBE ACTUALIZAR LOS HIJOS
				if(nodo.getChildNodes() != null && nodo.getChildNodes().getLength() > 0){
					actualizarNodosHijos(nodo.getChildNodes(), prefijo);
				}
				//ASIGNAR EL PREFIJO CUANDO SEA UN NODO
				if(nodo.getNodeType() == Node.ELEMENT_NODE){
					nodo.setPrefix(prefijo);
				}
			}
		}
	}
	/**
	 * Metodo que permite remover los atributos de un nodo
	 * @param nodo Node
	 */
	private void remueveAtributos(Node nodo) {
		Integer totalAtributos = nodo.getAttributes().getLength();
		String[] nombresAtributos = new String[totalAtributos];
		for(int i = 0; i < totalAtributos; i++){
			if(nodo.getAttributes().item(i).getNodeType() == Node.ATTRIBUTE_NODE){
				nombresAtributos[i] = nodo.getAttributes().item(i).getNodeName();
			}
		}
		for(int j = 0; j < nombresAtributos.length; j++){
			nodo.getAttributes().removeNamedItem(nombresAtributos[j]);
		}
	}
	/**
	 * @return EntelLogger
	 */
	public AkzioLogger getLogger() {
		return logger;
	}
}
