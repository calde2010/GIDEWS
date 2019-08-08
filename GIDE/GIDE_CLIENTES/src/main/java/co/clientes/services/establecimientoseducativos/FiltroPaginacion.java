
package co.clientes.services.establecimientoseducativos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FiltroPaginacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FiltroPaginacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroPagina" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numeroColumnaOrden" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ordenAscendente" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FiltroPaginacion", propOrder = {
    "numeroPagina",
    "numeroColumnaOrden",
    "ordenAscendente"
})
public class FiltroPaginacion {

    protected Integer numeroPagina;
    protected Integer numeroColumnaOrden;
    protected Boolean ordenAscendente;

    /**
     * Obtiene el valor de la propiedad numeroPagina.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroPagina() {
        return numeroPagina;
    }

    /**
     * Define el valor de la propiedad numeroPagina.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroPagina(Integer value) {
        this.numeroPagina = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroColumnaOrden.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroColumnaOrden() {
        return numeroColumnaOrden;
    }

    /**
     * Define el valor de la propiedad numeroColumnaOrden.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroColumnaOrden(Integer value) {
        this.numeroColumnaOrden = value;
    }

    /**
     * Obtiene el valor de la propiedad ordenAscendente.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOrdenAscendente() {
        return ordenAscendente;
    }

    /**
     * Define el valor de la propiedad ordenAscendente.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOrdenAscendente(Boolean value) {
        this.ordenAscendente = value;
    }

}
