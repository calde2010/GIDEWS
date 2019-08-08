
package co.clientes.services.sedeseducativas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para obtenerSedeEducativa complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="obtenerSedeEducativa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codSedeEducativa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerSedeEducativa", propOrder = {
    "codSedeEducativa"
})
public class ObtenerSedeEducativa {

    @XmlElement(required = true)
    protected String codSedeEducativa;

    /**
     * Obtiene el valor de la propiedad codSedeEducativa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSedeEducativa() {
        return codSedeEducativa;
    }

    /**
     * Define el valor de la propiedad codSedeEducativa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSedeEducativa(String value) {
        this.codSedeEducativa = value;
    }

}
