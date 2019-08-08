
package co.clientes.services.sedeseducativas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para obtenerSedesEducativas complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="obtenerSedesEducativas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codEstablecimientoEducativo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerSedesEducativas", propOrder = {
    "codEstablecimientoEducativo"
})
public class ObtenerSedesEducativas {

    @XmlElement(required = true)
    protected String codEstablecimientoEducativo;

    /**
     * Obtiene el valor de la propiedad codEstablecimientoEducativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodEstablecimientoEducativo() {
        return codEstablecimientoEducativo;
    }

    /**
     * Define el valor de la propiedad codEstablecimientoEducativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodEstablecimientoEducativo(String value) {
        this.codEstablecimientoEducativo = value;
    }

}
