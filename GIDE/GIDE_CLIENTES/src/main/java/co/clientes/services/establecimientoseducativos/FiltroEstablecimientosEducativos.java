
package co.clientes.services.establecimientoseducativos;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FiltroEstablecimientosEducativos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FiltroEstablecimientosEducativos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codDepartamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codMunicipio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codTipoEstablecimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codSectorEducativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codSecretaria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codResguardo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codPropiedadPlantaFisica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codPropiedadAdministrativa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codGeneroAtencion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codCaracterEducativo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codCalendarioEducativo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="paginacion" type="{http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/}FiltroPaginacion"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FiltroEstablecimientosEducativos", propOrder = {
    "codDepartamento",
    "codMunicipio",
    "codTipoEstablecimiento",
    "codSectorEducativo",
    "codSecretaria",
    "codResguardo",
    "codPropiedadPlantaFisica",
    "codPropiedadAdministrativa",
    "codGeneroAtencion",
    "codCaracterEducativo",
    "codCalendarioEducativo",
    "paginacion"
})
public class FiltroEstablecimientosEducativos {

    protected String codDepartamento;
    protected String codMunicipio;
    protected String codTipoEstablecimiento;
    protected String codSectorEducativo;
    protected String codSecretaria;
    protected Integer codResguardo;
    protected String codPropiedadPlantaFisica;
    protected String codPropiedadAdministrativa;
    protected Integer codGeneroAtencion;
    protected Integer codCaracterEducativo;
    protected Integer codCalendarioEducativo;
    @XmlElement(required = true)
    protected FiltroPaginacion paginacion;

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
     * Obtiene el valor de la propiedad codTipoEstablecimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTipoEstablecimiento() {
        return codTipoEstablecimiento;
    }

    /**
     * Define el valor de la propiedad codTipoEstablecimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTipoEstablecimiento(String value) {
        this.codTipoEstablecimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad codSectorEducativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSectorEducativo() {
        return codSectorEducativo;
    }

    /**
     * Define el valor de la propiedad codSectorEducativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSectorEducativo(String value) {
        this.codSectorEducativo = value;
    }

    /**
     * Obtiene el valor de la propiedad codSecretaria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSecretaria() {
        return codSecretaria;
    }

    /**
     * Define el valor de la propiedad codSecretaria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSecretaria(String value) {
        this.codSecretaria = value;
    }

    /**
     * Obtiene el valor de la propiedad codResguardo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodResguardo() {
        return codResguardo;
    }

    /**
     * Define el valor de la propiedad codResguardo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodResguardo(Integer value) {
        this.codResguardo = value;
    }

    /**
     * Obtiene el valor de la propiedad codPropiedadPlantaFisica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPropiedadPlantaFisica() {
        return codPropiedadPlantaFisica;
    }

    /**
     * Define el valor de la propiedad codPropiedadPlantaFisica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPropiedadPlantaFisica(String value) {
        this.codPropiedadPlantaFisica = value;
    }

    /**
     * Obtiene el valor de la propiedad codPropiedadAdministrativa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPropiedadAdministrativa() {
        return codPropiedadAdministrativa;
    }

    /**
     * Define el valor de la propiedad codPropiedadAdministrativa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPropiedadAdministrativa(String value) {
        this.codPropiedadAdministrativa = value;
    }

    /**
     * Obtiene el valor de la propiedad codGeneroAtencion.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodGeneroAtencion() {
        return codGeneroAtencion;
    }

    /**
     * Define el valor de la propiedad codGeneroAtencion.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodGeneroAtencion(Integer value) {
        this.codGeneroAtencion = value;
    }

    /**
     * Obtiene el valor de la propiedad codCaracterEducativo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodCaracterEducativo() {
        return codCaracterEducativo;
    }

    /**
     * Define el valor de la propiedad codCaracterEducativo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodCaracterEducativo(Integer value) {
        this.codCaracterEducativo = value;
    }

    /**
     * Obtiene el valor de la propiedad codCalendarioEducativo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodCalendarioEducativo() {
        return codCalendarioEducativo;
    }

    /**
     * Define el valor de la propiedad codCalendarioEducativo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodCalendarioEducativo(Integer value) {
        this.codCalendarioEducativo = value;
    }

    /**
     * Obtiene el valor de la propiedad paginacion.
     * 
     * @return
     *     possible object is
     *     {@link FiltroPaginacion }
     *     
     */
    public FiltroPaginacion getPaginacion() {
        return paginacion;
    }

    /**
     * Define el valor de la propiedad paginacion.
     * 
     * @param value
     *     allowed object is
     *     {@link FiltroPaginacion }
     *     
     */
    public void setPaginacion(FiltroPaginacion value) {
        this.paginacion = value;
    }

}
