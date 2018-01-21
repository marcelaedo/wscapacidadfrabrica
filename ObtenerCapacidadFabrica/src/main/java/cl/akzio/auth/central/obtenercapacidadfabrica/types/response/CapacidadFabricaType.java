/* Propiedad de Akzio Fabrica Temuco. Todos los derechos reservados */
package cl.akzio.auth.central.obtenercapacidadfabrica.types.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for capacidadFabricaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="capacidadFabricaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hhTotales" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hhReservadas" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaInicioConsulta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaEntrega" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "capacidadFabricaType", propOrder = {
    "hhTotales",
    "hhReservadas",
    "fechaInicioConsulta",
    "fechaEntrega"
})
public class CapacidadFabricaType implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -783331462518430106L;

	/**
	 * Atributo serialVersionUID long
	 */
	public CapacidadFabricaType() {
		super();
	}

	/**
	 * @param hhTotales
	 * @param hhReservadas
	 * @param fechaInicioConsulta
	 * @param fechaEntrega
	 */
	public CapacidadFabricaType(String hhTotales, String hhReservadas,
			String fechaInicioConsulta, String fechaEntrega) {
		super();
		this.hhTotales = hhTotales;
		this.hhReservadas = hhReservadas;
		this.fechaInicioConsulta = fechaInicioConsulta;
		this.fechaEntrega = fechaEntrega;
	}

	@XmlElement(required = true)
    protected String hhTotales;
    @XmlElement(required = true)
    protected String hhReservadas;
    @XmlElement(required = true)
    protected String fechaInicioConsulta;
    @XmlElement(required = true)
    protected String fechaEntrega;

    /**
     * Gets the value of the hhTotales property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHhTotales() {
        return hhTotales;
    }

    /**
     * Sets the value of the hhTotales property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHhTotales(String value) {
        this.hhTotales = value;
    }

    /**
     * Gets the value of the hhReservadas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHhReservadas() {
        return hhReservadas;
    }

    /**
     * Sets the value of the hhReservadas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHhReservadas(String value) {
        this.hhReservadas = value;
    }

    /**
     * Gets the value of the fechaInicioConsulta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaInicioConsulta() {
        return fechaInicioConsulta;
    }

    /**
     * Sets the value of the fechaInicioConsulta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaInicioConsulta(String value) {
        this.fechaInicioConsulta = value;
    }

    /**
     * Gets the value of the fechaEntrega property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Sets the value of the fechaEntrega property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaEntrega(String value) {
        this.fechaEntrega = value;
    }

}
