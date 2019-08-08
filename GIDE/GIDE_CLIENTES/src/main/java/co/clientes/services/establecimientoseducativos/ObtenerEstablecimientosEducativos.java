
package co.clientes.services.establecimientoseducativos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para obtenerEstablecimientosEducativos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="obtenerEstablecimientosEducativos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="filtroEstablecimientosEducativos" type="{http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/}FiltroEstablecimientosEducativos" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenerEstablecimientosEducativos", propOrder = {
    "filtroEstablecimientosEducativos"
})
public class ObtenerEstablecimientosEducativos {

    protected FiltroEstablecimientosEducativos filtroEstablecimientosEducativos;

    /**
     * Obtiene el valor de la propiedad filtroEstablecimientosEducativos.
     * 
     * @return
     *     possible object is
     *     {@link FiltroEstablecimientosEducativos }
     *     
     */
    public FiltroEstablecimientosEducativos getFiltroEstablecimientosEducativos() {
        return filtroEstablecimientosEducativos;
    }

    /**
     * Define el valor de la propiedad filtroEstablecimientosEducativos.
     * 
     * @param value
     *     allowed object is
     *     {@link FiltroEstablecimientosEducativos }
     *     
     */
    public void setFiltroEstablecimientosEducativos(FiltroEstablecimientosEducativos value) {
        this.filtroEstablecimientosEducativos = value;
    }

}
