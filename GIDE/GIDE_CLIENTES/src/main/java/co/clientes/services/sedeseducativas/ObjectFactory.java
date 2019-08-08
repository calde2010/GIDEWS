
package co.clientes.services.sedeseducativas;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.clientes.services.sedeseducativas package. 
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

    private final static QName _ObtenerSedeEducativa_QNAME = new QName("http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", "obtenerSedeEducativa");
    private final static QName _ObtenerSedeEducativaResponse_QNAME = new QName("http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", "obtenerSedeEducativaResponse");
    private final static QName _ObtenerSedesEducativasResponse_QNAME = new QName("http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", "obtenerSedesEducativasResponse");
    private final static QName _ObtenerSedesEducativas_QNAME = new QName("http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", "obtenerSedesEducativas");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.clientes.services.sedeseducativas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerSedesEducativas }
     * 
     */
    public ObtenerSedesEducativas createObtenerSedesEducativas() {
        return new ObtenerSedesEducativas();
    }

    /**
     * Create an instance of {@link ObtenerSedeEducativa }
     * 
     */
    public ObtenerSedeEducativa createObtenerSedeEducativa() {
        return new ObtenerSedeEducativa();
    }

    /**
     * Create an instance of {@link ObtenerSedeEducativaResponse }
     * 
     */
    public ObtenerSedeEducativaResponse createObtenerSedeEducativaResponse() {
        return new ObtenerSedeEducativaResponse();
    }

    /**
     * Create an instance of {@link ObtenerSedesEducativasResponse }
     * 
     */
    public ObtenerSedesEducativasResponse createObtenerSedesEducativasResponse() {
        return new ObtenerSedesEducativasResponse();
    }

    /**
     * Create an instance of {@link LatLng }
     * 
     */
    public LatLng createLatLng() {
        return new LatLng();
    }

    /**
     * Create an instance of {@link SedeEducativa }
     * 
     */
    public SedeEducativa createSedeEducativa() {
        return new SedeEducativa();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerSedeEducativa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", name = "obtenerSedeEducativa")
    public JAXBElement<ObtenerSedeEducativa> createObtenerSedeEducativa(ObtenerSedeEducativa value) {
        return new JAXBElement<ObtenerSedeEducativa>(_ObtenerSedeEducativa_QNAME, ObtenerSedeEducativa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerSedeEducativaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", name = "obtenerSedeEducativaResponse")
    public JAXBElement<ObtenerSedeEducativaResponse> createObtenerSedeEducativaResponse(ObtenerSedeEducativaResponse value) {
        return new JAXBElement<ObtenerSedeEducativaResponse>(_ObtenerSedeEducativaResponse_QNAME, ObtenerSedeEducativaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerSedesEducativasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", name = "obtenerSedesEducativasResponse")
    public JAXBElement<ObtenerSedesEducativasResponse> createObtenerSedesEducativasResponse(ObtenerSedesEducativasResponse value) {
        return new JAXBElement<ObtenerSedesEducativasResponse>(_ObtenerSedesEducativasResponse_QNAME, ObtenerSedesEducativasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerSedesEducativas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", name = "obtenerSedesEducativas")
    public JAXBElement<ObtenerSedesEducativas> createObtenerSedesEducativas(ObtenerSedesEducativas value) {
        return new JAXBElement<ObtenerSedesEducativas>(_ObtenerSedesEducativas_QNAME, ObtenerSedesEducativas.class, null, value);
    }

}
