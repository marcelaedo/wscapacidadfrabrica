/* Propiedad de Akzio Fabrica Temuco. Todos los derechos reservados */
package cl.akzio.auth.central.obtenercapacidadfabrica.types.response;

import java.io.Serializable;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cl.akzio.auth.central.t.obtenercapacidadfabrica.response package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * @author Marcel Aedo (Akzio Consultores S.A.) en nombre de Daniela Cruz(Akzio Consultores S.A.)
 * @since 10-01-2018
 * @version 1.0
 */
@XmlRegistry
public class ObjectFactory  implements Serializable{

    /**
	 * Atributo serialVersionUID long
	 */
	private static final long serialVersionUID = 7934499952582055667L;
	private final static QName _ObtenerCapacidadFabricaResponseDocument_QNAME = new QName("http://www.akzio.cl/auth/central/t/obtenercapacidadfabrica/response", "obtenerCapacidadFabricaResponseDocument");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cl.akzio.auth.central.t.obtenercapacidadfabrica.response
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CapacidadFabricaType }
     * 
     */
    public CapacidadFabricaType createCapacidadFabricaType() {
        return new CapacidadFabricaType();
    }

    /**
     * Create an instance of {@link ResponseType }
     * 
     */
    public ResponseType createResponseType() {
        return new ResponseType();
    }

    /**
     * Create an instance of {@link ObtenerCapacidadFabricaResponseType }
     * 
     */
    public ObtenerCapacidadFabricaResponseType createObtenerCapacidadFabricaResponseType() {
        return new ObtenerCapacidadFabricaResponseType();
    }

    /**
     * Create an instance of {@link HeaderOutType }
     * 
     */
    public HeaderOutType createHeaderOutType() {
        return new HeaderOutType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerCapacidadFabricaResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.akzio.cl/auth/central/t/obtenercapacidadfabrica/response", name = "obtenerCapacidadFabricaResponseDocument")
    public JAXBElement<ObtenerCapacidadFabricaResponseType> createObtenerCapacidadFabricaResponseDocument(ObtenerCapacidadFabricaResponseType value) {
        return new JAXBElement<ObtenerCapacidadFabricaResponseType>(_ObtenerCapacidadFabricaResponseDocument_QNAME, ObtenerCapacidadFabricaResponseType.class, null, value);
    }

	/**
	 * @return the ObtenercapacidadfabricaresponsedocumentQname
	 */
	public static QName getObtenercapacidadfabricaresponsedocumentQname() {
		return _ObtenerCapacidadFabricaResponseDocument_QNAME;
	}

}
