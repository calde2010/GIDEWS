
package co.clientes.services.establecimientoseducativos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import co.clientes.services.establecimientoseducativos.EstablecimientoEducativo;

/**
 * <p>Clase Java para EstablecimientosEducativosPaginado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EstablecimientosEducativosPaginado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="establecimientosEducativos" type="{http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/}EstablecimientoEducativo" maxOccurs="unbounded"/>
 *         &lt;element name="paginacion" type="{http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/}Paginacion"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EstablecimientosEducativosPaginado", propOrder = {
    "establecimientosEducativos",
    "paginacion"
})
public class EstablecimientosEducativosPaginado {

    @XmlElement(required = true)
    protected List<EstablecimientoEducativo> establecimientosEducativos;
    @XmlElement(required = true)
    protected Paginacion paginacion;

    /**
     * Gets the value of the establecimientosEducativos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the establecimientosEducativos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEstablecimientosEducativos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EstablecimientoEducativo }
     * 
     * 
     */
    public List<EstablecimientoEducativo> getEstablecimientosEducativos() {
        if (establecimientosEducativos == null) {
            establecimientosEducativos = new ArrayList<EstablecimientoEducativo>();
        }
        return this.establecimientosEducativos;
    }

    /**
     * Obtiene el valor de la propiedad paginacion.
     * 
     * @return
     *     possible object is
     *     {@link Paginacion }
     *     
     */
    public Paginacion getPaginacion() {
        return paginacion;
    }

    /**
     * Define el valor de la propiedad paginacion.
     * 
     * @param value
     *     allowed object is
     *     {@link Paginacion }
     *     
     */
    public void setPaginacion(Paginacion value) {
        this.paginacion = value;
    }

}
