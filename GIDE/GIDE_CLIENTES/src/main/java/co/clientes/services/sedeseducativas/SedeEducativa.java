
package co.clientes.services.sedeseducativas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SedeEducativa complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SedeEducativa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codDane" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codDepartamento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codMunicipio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="barrio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numTelefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codZona" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codDaneEstablecimientoEducativo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="esSedePrincipal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="codEstado" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="coordenadaGeografica" type="{http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/}LatLng"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SedeEducativa", propOrder = {
    "codDane",
    "nombre",
    "codDepartamento",
    "codMunicipio",
    "direccion",
    "barrio",
    "numTelefono",
    "codZona",
    "codDaneEstablecimientoEducativo",
    "esSedePrincipal",
    "codEstado",
    "coordenadaGeografica"
})
public class SedeEducativa {

    @XmlElement(required = true)
    protected String codDane;
    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String codDepartamento;
    @XmlElement(required = true)
    protected String codMunicipio;
    @XmlElement(required = true)
    protected String direccion;
    protected String barrio;
    protected String numTelefono;
    @XmlElement(required = true)
    protected String codZona;
    @XmlElement(required = true)
    protected String codDaneEstablecimientoEducativo;
    protected boolean esSedePrincipal;
    protected int codEstado;
    @XmlElement(required = true)
    protected LatLng coordenadaGeografica;

    /**
     * Obtiene el valor de la propiedad codDane.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDane() {
        return codDane;
    }

    /**
     * Define el valor de la propiedad codDane.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDane(String value) {
        this.codDane = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad codDepartamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDepartamento() {
        return codDepartamento;
    }

    /**
     * Define el valor de la propiedad codDepartamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDepartamento(String value) {
        this.codDepartamento = value;
    }

    /**
     * Obtiene el valor de la propiedad codMunicipio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMunicipio() {
        return codMunicipio;
    }

    /**
     * Define el valor de la propiedad codMunicipio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMunicipio(String value) {
        this.codMunicipio = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Obtiene el valor de la propiedad barrio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBarrio() {
        return barrio;
    }

    /**
     * Define el valor de la propiedad barrio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBarrio(String value) {
        this.barrio = value;
    }

    /**
     * Obtiene el valor de la propiedad numTelefono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumTelefono() {
        return numTelefono;
    }

    /**
     * Define el valor de la propiedad numTelefono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumTelefono(String value) {
        this.numTelefono = value;
    }

    /**
     * Obtiene el valor de la propiedad codZona.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodZona() {
        return codZona;
    }

    /**
     * Define el valor de la propiedad codZona.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodZona(String value) {
        this.codZona = value;
    }

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

    /**
     * Obtiene el valor de la propiedad esSedePrincipal.
     * 
     */
    public boolean isEsSedePrincipal() {
        return esSedePrincipal;
    }

    /**
     * Define el valor de la propiedad esSedePrincipal.
     * 
     */
    public void setEsSedePrincipal(boolean value) {
        this.esSedePrincipal = value;
    }

    /**
     * Obtiene el valor de la propiedad codEstado.
     * 
     */
    public int getCodEstado() {
        return codEstado;
    }

    /**
     * Define el valor de la propiedad codEstado.
     * 
     */
    public void setCodEstado(int value) {
        this.codEstado = value;
    }

    /**
     * Obtiene el valor de la propiedad coordenadaGeografica.
     * 
     * @return
     *     possible object is
     *     {@link LatLng }
     *     
     */
    public LatLng getCoordenadaGeografica() {
        return coordenadaGeografica;
    }

    /**
     * Define el valor de la propiedad coordenadaGeografica.
     * 
     * @param value
     *     allowed object is
     *     {@link LatLng }
     *     
     */
    public void setCoordenadaGeografica(LatLng value) {
        this.coordenadaGeografica = value;
    }

}
