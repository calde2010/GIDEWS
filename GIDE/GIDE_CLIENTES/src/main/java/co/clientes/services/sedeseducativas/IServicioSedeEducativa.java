
package co.clientes.services.sedeseducativas;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IServicioSedeEducativa", targetNamespace = "http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IServicioSedeEducativa {


    /**
     * 
     * @param codSedeEducativa
     * @return
     *     returns co.clientes.services.sedeseducativas.SedeEducativa
     */
    @WebMethod(action = "http://www.mineducacion.gov.co/ServiciosSineb/obtenerSedeEducativa")
    @WebResult(name = "sedeEducativa", targetNamespace = "")
    @RequestWrapper(localName = "obtenerSedeEducativa", targetNamespace = "http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", className = "co.clientes.services.sedeseducativas.ObtenerSedeEducativa")
    @ResponseWrapper(localName = "obtenerSedeEducativaResponse", targetNamespace = "http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", className = "co.clientes.services.sedeseducativas.ObtenerSedeEducativaResponse")
    @Action(input = "http://www.mineducacion.gov.co/ServiciosSineb/obtenerSedeEducativa", output = "http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/IServicioSedeEducativa/obtenerSedeEducativaResponse")
    public SedeEducativa obtenerSedeEducativa(
        @WebParam(name = "codSedeEducativa", targetNamespace = "")
        String codSedeEducativa);

    /**
     * 
     * @param codEstablecimientoEducativo
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod(action = "http://www.mineducacion.gov.co/ServiciosSineb/obtenerSedesEducativas")
    @WebResult(name = "sedesEducativas", targetNamespace = "")
    @RequestWrapper(localName = "obtenerSedesEducativas", targetNamespace = "http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", className = "co.clientes.services.sedeseducativas.ObtenerSedesEducativas")
    @ResponseWrapper(localName = "obtenerSedesEducativasResponse", targetNamespace = "http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/", className = "co.clientes.services.sedeseducativas.ObtenerSedesEducativasResponse")
    @Action(input = "http://www.mineducacion.gov.co/ServiciosSineb/obtenerSedesEducativas", output = "http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/IServicioSedeEducativa/obtenerSedesEducativasResponse")
    public List<String> obtenerSedesEducativas(
        @WebParam(name = "codEstablecimientoEducativo", targetNamespace = "")
        String codEstablecimientoEducativo);

}
