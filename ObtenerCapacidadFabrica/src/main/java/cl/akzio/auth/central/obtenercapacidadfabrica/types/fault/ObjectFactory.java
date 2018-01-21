/* Propiedad de Akzio Fabrica Temuco. Todos los derechos reservados */
package cl.akzio.auth.central.obtenercapacidadfabrica.types.fault;

import java.io.Serializable;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cl.akzio.auth.central.t.obtenercapacidadfabrica.fault package. 
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
public class ObjectFactory implements Serializable {

    /**
	 *Atributo serialVersionUID long 
	 */
	private static final long serialVersionUID = 8533077523050413983L;
	
	private final static QName _ObtenerCapacidadFabricaFaultDocument_QNAME = new QName("http://www.akzio.cl/auth/central/t/obtenercapacidadfabrica/fault", "obtenerCapacidadFabricaFaultDocument");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cl.akzio.auth.central.t.obtenercapacidadfabrica.fault
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerCapacidadFabricaFaultType }
     * 
     */
    public ObtenerCapacidadFabricaFaultType createObtenerCapacidadFabricaFaultType() {
        return new ObtenerCapacidadFabricaFaultType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerCapacidadFabricaFaultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.akzio.cl/auth/central/t/obtenercapacidadfabrica/fault", name = "obtenerCapacidadFabricaFaultDocument")
    public JAXBElement<ObtenerCapacidadFabricaFaultType> createObtenerCapacidadFabricaFaultDocument(ObtenerCapacidadFabricaFaultType value) {
        return new JAXBElement<ObtenerCapacidadFabricaFaultType>(_ObtenerCapacidadFabricaFaultDocument_QNAME, ObtenerCapacidadFabricaFaultType.class, null, value);
    }

	/**
	 * @return the ObtenercapacidadfabricafaultdocumentQname
	 */
	public static QName getObtenercapacidadfabricafaultdocumentQname() {
		return _ObtenerCapacidadFabricaFaultDocument_QNAME;
	}

}
