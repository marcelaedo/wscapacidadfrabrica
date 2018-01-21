/* Propiedad de Akzio Fabrica Temuco. Todos los derechos reservados */
package cl.akzio.auth.central.obtenercapacidadfabrica.types.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for responseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="responseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="headerOut" type="{http://www.akzio.cl/auth/central/t/obtenercapacidadfabrica/response}headerOutType"/>
 *         &lt;element name="capacidadFabrica" type="{http://www.akzio.cl/auth/central/t/obtenercapacidadfabrica/response}capacidadFabricaType"/>
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
@XmlType(name = "responseType", propOrder = {
    "headerOut",
    "capacidadFabrica"
})
public class ResponseType implements Serializable{

    /**
	 * Atributo serialVersionUID long
	 */
	private static final long serialVersionUID = -2814419888070339742L;
	/**
	 * 
	 */
	public ResponseType() {
		super();
	}

	/**
	 * @param headerOut
	 * @param capacidadFabrica
	 */
	public ResponseType(HeaderOutType headerOut,
			CapacidadFabricaType capacidadFabrica) {
		super();
		this.headerOut = headerOut;
		this.capacidadFabrica = capacidadFabrica;
	}

	@XmlElement(required = true)
    protected HeaderOutType headerOut;
    @XmlElement(required = true)
    protected CapacidadFabricaType capacidadFabrica;

    /**
     * Gets the value of the headerOut property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderOutType }
     *     
     */
    public HeaderOutType getHeaderOut() {
        return headerOut;
    }

    /**
     * Sets the value of the headerOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderOutType }
     *     
     */
    public void setHeaderOut(HeaderOutType value) {
        this.headerOut = value;
    }

    /**
     * Gets the value of the capacidadFabrica property.
     * 
     * @return
     *     possible object is
     *     {@link CapacidadFabricaType }
     *     
     */
    public CapacidadFabricaType getCapacidadFabrica() {
        return capacidadFabrica;
    }

    /**
     * Sets the value of the capacidadFabrica property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapacidadFabricaType }
     *     
     */
    public void setCapacidadFabrica(CapacidadFabricaType value) {
        this.capacidadFabrica = value;
    }

}
