
package co.clientes.services.establecimientoseducativos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para obtenerEstablecimientoEducativo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="obtenerEstablecimientoEducativo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codDaneEstablecimientoEducativo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerEstablecimientoEducativo", propOrder = {
    "codDaneEstablecimientoEducativo"
})
public class ObtenerEstablecimientoEducativo {

    @XmlElement(required = true)
    protected String codDaneEstablecimientoEducativo;

    /**
     * Obtiene el valor de la propiedad codDaneEstablecimientoEducativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDaneEstablecimientoEducativo() {
        return codDaneEstablecimientoEducativo;
    }

    /**
     * Define el valor de la propiedad codDaneEstablecimientoEducativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDaneEstablecimientoEducativo(String value) {
        this.codDaneEstablecimientoEducativo = value;
    }

}
