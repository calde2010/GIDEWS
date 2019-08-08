
package co.clientes.services.establecimientoseducativos;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para identificacionPersonaTMF complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="identificacionPersonaTMF">
 *   &lt;complexContent>
 *     &lt;extension base="{http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/}identificacionPersona">
 *       &lt;sequence>
 *         &lt;element name="numDocumento" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "identificacionPersonaTMF", propOrder = {
    "numDocumento"
})
public class IdentificacionPersonaTMF
    extends IdentificacionPersona
{

    @XmlElement(required = true)
    protected BigInteger numDocumento;

    /**
     * Obtiene el valor de la propiedad numDocumento.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumDocumento() {
        return numDocumento;
    }

    /**
     * Define el valor de la propiedad numDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumDocumento(BigInteger value) {
        this.numDocumento = value;
    }

}
