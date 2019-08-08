
package co.clientes.services.establecimientoseducativos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para obtenerEstablecimientoEducativoResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="obtenerEstablecimientoEducativoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="establecimientoEducativo" type="{http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/}EstablecimientoEducativo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerEstablecimientoEducativoResponse", propOrder = {
    "establecimientoEducativo"
})
public class ObtenerEstablecimientoEducativoResponse {

    protected EstablecimientoEducativo establecimientoEducativo;

    /**
     * Obtiene el valor de la propiedad establecimientoEducativo.
     * 
     * @return
     *     possible object is
     *     {@link EstablecimientoEducativo }
     *     
     */
    public EstablecimientoEducativo getEstablecimientoEducativo() {
        return establecimientoEducativo;
    }

    /**
     * Define el valor de la propiedad establecimientoEducativo.
     * 
     * @param value
     *     allowed object is
     *     {@link EstablecimientoEducativo }
     *     
     */
    public void setEstablecimientoEducativo(EstablecimientoEducativo value) {
        this.establecimientoEducativo = value;
    }

}
