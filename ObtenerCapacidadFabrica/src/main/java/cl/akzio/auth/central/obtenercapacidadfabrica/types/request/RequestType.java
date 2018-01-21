/* Propiedad de Akzio Fabrica Temuco. Todos los derechos reservados */
package cl.akzio.auth.central.obtenercapacidadfabrica.types.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for requestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="headerIn" type="{http://www.akzio.cl/auth/central/t/obtenercapacidadfabrica/request}headerInType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @author Marcel Aedo (Akzio Consultores S.A.) en nombre de Daniela Cruz(Akzio Consultores S.A.)
 * @since 10-01-2018
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestType", propOrder = {
    "headerIn"
})
public class RequestType implements Serializable{

    /**
	 * Atributo serialVersionUID long
	 */
	private static final long serialVersionUID = -6434844927513456855L;
	
	public RequestType() {
		super();
	}

	public RequestType(HeaderInType headerIn) {
		super();
		this.headerIn = headerIn;
	}

	@XmlElement(required = true)
    protected HeaderInType headerIn;

    /**
     * Gets the value of the headerIn property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderInType }
     *     
     */
    public HeaderInType getHeaderIn() {
        return headerIn;
    }

    /**
     * Sets the value of the headerIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderInType }
     *     
     */
    public void setHeaderIn(HeaderInType value) {
        this.headerIn = value;
    }

}
