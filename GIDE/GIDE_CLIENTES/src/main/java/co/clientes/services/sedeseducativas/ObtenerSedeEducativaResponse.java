
package co.clientes.services.sedeseducativas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para obtenerSedeEducativaResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="obtenerSedeEducativaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sedeEducativa" type="{http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/}SedeEducativa" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerSedeEducativaResponse", propOrder = {
    "sedeEducativa"
})
public class ObtenerSedeEducativaResponse {

    protected SedeEducativa sedeEducativa;

    /**
     * Obtiene el valor de la propiedad sedeEducativa.
     * 
     * @return
     *     possible object is
     *     {@link SedeEducativa }
     *     
     */
    public SedeEducativa getSedeEducativa() {
        return sedeEducativa;
    }

    /**
     * Define el valor de la propiedad sedeEducativa.
     * 
     * @param value
     *     allowed object is
     *     {@link SedeEducativa }
     *     
     */
    public void setSedeEducativa(SedeEducativa value) {
        this.sedeEducativa = value;
    }

}
