
package co.clientes.services.establecimientoseducativos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.clientes.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ObtenerEstablecimientosEducativos_QNAME = new QName("http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", "obtenerEstablecimientosEducativos");
    private final static QName _ObtenerEstablecimientosEducativosResponse_QNAME = new QName("http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", "obtenerEstablecimientosEducativosResponse");
    private final static QName _ObtenerEstablecimientoEducativoResponse_QNAME = new QName("http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", "obtenerEstablecimientoEducativoResponse");
    private final static QName _ObtenerEstablecimientoEducativo_QNAME = new QName("http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", "obtenerEstablecimientoEducativo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.clientes.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerEstablecimientoEducativo }
     * 
     */
    public ObtenerEstablecimientoEducativo createObtenerEstablecimientoEducativo() {
        return new ObtenerEstablecimientoEducativo();
    }

    /**
     * Create an instance of {@link ObtenerEstablecimientosEducativos }
     * 
     */
    public ObtenerEstablecimientosEducativos createObtenerEstablecimientosEducativos() {
        return new ObtenerEstablecimientosEducativos();
    }

    /**
     * Create an instance of {@link ObtenerEstablecimientosEducativosResponse }
     * 
     */
    public ObtenerEstablecimientosEducativosResponse createObtenerEstablecimientosEducativosResponse() {
        return new ObtenerEstablecimientosEducativosResponse();
    }

    /**
     * Create an instance of {@link ObtenerEstablecimientoEducativoResponse }
     * 
     */
    public ObtenerEstablecimientoEducativoResponse createObtenerEstablecimientoEducativoResponse() {
        return new ObtenerEstablecimientoEducativoResponse();
    }

    /**
     * Create an instance of {@link IdentificacionPersonaPEP }
     * 
     */
    public IdentificacionPersonaPEP createIdentificacionPersonaPEP() {
        return new IdentificacionPersonaPEP();
    }

    /**
     * Create an instance of {@link IdentificacionPersonaTMF }
     * 
     */
    public IdentificacionPersonaTMF createIdentificacionPersonaTMF() {
        return new IdentificacionPersonaTMF();
    }

    /**
     * Create an instance of {@link Paginacion }
     * 
     */
    public Paginacion createPaginacion() {
        return new Paginacion();
    }

    /**
     * Create an instance of {@link IdentificacionPersonaRC }
     * 
     */
    public IdentificacionPersonaRC createIdentificacionPersonaRC() {
        return new IdentificacionPersonaRC();
    }

    /**
     * Create an instance of {@link FiltroPaginacion }
     * 
     */
    public FiltroPaginacion createFiltroPaginacion() {
        return new FiltroPaginacion();
    }

    /**
     * Create an instance of {@link Rector }
     * 
     */
    public Rector createRector() {
        return new Rector();
    }

    /**
     * Create an instance of {@link IdentificacionPersonaVISA }
     * 
     */
    public IdentificacionPersonaVISA createIdentificacionPersonaVISA() {
        return new IdentificacionPersonaVISA();
    }

    /**
     * Create an instance of {@link EstablecimientosEducativosPaginado }
     * 
     */
    public EstablecimientosEducativosPaginado createEstablecimientosEducativosPaginado() {
        return new EstablecimientosEducativosPaginado();
    }

    /**
     * Create an instance of {@link EstablecimientoEducativo }
     * 
     */
    public EstablecimientoEducativo createEstablecimientoEducativo() {
        return new EstablecimientoEducativo();
    }

    /**
     * Create an instance of {@link IdentificacionPersonaTI }
     * 
     */
    public IdentificacionPersonaTI createIdentificacionPersonaTI() {
        return new IdentificacionPersonaTI();
    }

    /**
     * Create an instance of {@link IdentificacionPersonaCC }
     * 
     */
    public IdentificacionPersonaCC createIdentificacionPersonaCC() {
        return new IdentificacionPersonaCC();
    }

    /**
     * Create an instance of {@link FiltroEstablecimientosEducativos }
     * 
     */
    public FiltroEstablecimientosEducativos createFiltroEstablecimientosEducativos() {
        return new FiltroEstablecimientosEducativos();
    }

    /**
     * Create an instance of {@link IdentificacionPersonaCE }
     * 
     */
    public IdentificacionPersonaCE createIdentificacionPersonaCE() {
        return new IdentificacionPersonaCE();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerEstablecimientosEducativos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", name = "obtenerEstablecimientosEducativos")
    public JAXBElement<ObtenerEstablecimientosEducativos> createObtenerEstablecimientosEducativos(ObtenerEstablecimientosEducativos value) {
        return new JAXBElement<ObtenerEstablecimientosEducativos>(_ObtenerEstablecimientosEducativos_QNAME, ObtenerEstablecimientosEducativos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerEstablecimientosEducativosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", name = "obtenerEstablecimientosEducativosResponse")
    public JAXBElement<ObtenerEstablecimientosEducativosResponse> createObtenerEstablecimientosEducativosResponse(ObtenerEstablecimientosEducativosResponse value) {
        return new JAXBElement<ObtenerEstablecimientosEducativosResponse>(_ObtenerEstablecimientosEducativosResponse_QNAME, ObtenerEstablecimientosEducativosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerEstablecimientoEducativoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", name = "obtenerEstablecimientoEducativoResponse")
    public JAXBElement<ObtenerEstablecimientoEducativoResponse> createObtenerEstablecimientoEducativoResponse(ObtenerEstablecimientoEducativoResponse value) {
        return new JAXBElement<ObtenerEstablecimientoEducativoResponse>(_ObtenerEstablecimientoEducativoResponse_QNAME, ObtenerEstablecimientoEducativoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerEstablecimientoEducativo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", name = "obtenerEstablecimientoEducativo")
    public JAXBElement<ObtenerEstablecimientoEducativo> createObtenerEstablecimientoEducativo(ObtenerEstablecimientoEducativo value) {
        return new JAXBElement<ObtenerEstablecimientoEducativo>(_ObtenerEstablecimientoEducativo_QNAME, ObtenerEstablecimientoEducativo.class, null, value);
    }

}
