
package co.clientes.services.establecimientoseducativos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para obtenerEstablecimientosEducativosResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="obtenerEstablecimientosEducativosResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="establecimientosEducativosPaginado" type="{http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/}EstablecimientosEducativosPaginado" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerEstablecimientosEducativosResponse", propOrder = {
    "establecimientosEducativosPaginado"
})
public class ObtenerEstablecimientosEducativosResponse {

    protected EstablecimientosEducativosPaginado establecimientosEducativosPaginado;

    /**
     * Obtiene el valor de la propiedad establecimientosEducativosPaginado.
     * 
     * @return
     *     possible object is
     *     {@link EstablecimientosEducativosPaginado }
     *     
     */
    public EstablecimientosEducativosPaginado getEstablecimientosEducativosPaginado() {
        return establecimientosEducativosPaginado;
    }

    /**
     * Define el valor de la propiedad establecimientosEducativosPaginado.
     * 
     * @param value
     *     allowed object is
     *     {@link EstablecimientosEducativosPaginado }
     *     
     */
    public void setEstablecimientosEducativosPaginado(EstablecimientosEducativosPaginado value) {
        this.establecimientosEducativosPaginado = value;
    }

}
