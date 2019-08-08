package co.test.clientes;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import co.clientes.services.establecimientoseducativos.EstablecimientoEducativo;
import co.clientes.services.establecimientoseducativos.EstablecimientosEducativosPaginado;
import co.clientes.services.establecimientoseducativos.IServicioEstablecimientoEducativo;
import co.clientes.services.establecimientoseducativos.ObjectFactory;
import co.clientes.services.establecimientoseducativos.ServicioEstablecimientoEducativoService;
import co.clientes.services.sedeseducativas.SedeEducativa;

public class Ejecutar {

	public static void main(String[] args) {
		obtenerEstablecimientoEducativo("1");
	}

	private static EstablecimientoEducativo obtenerEstablecimientoEducativo(String codDaneEstablecimientoEducativo) {
		ObjectFactory factory = new ObjectFactory();
		EstablecimientoEducativo eu = new EstablecimientoEducativo();
		try {
			String urlAmbiente = "http://localhost:8080/wsstandardsineb/EstablecimientoEducativo?WSDL";
			URL url = new URL(urlAmbiente);

			ServicioEstablecimientoEducativoService portNameService = new ServicioEstablecimientoEducativoService(url,
					new QName("http://serviciosImpl.wsstandardsineb.mineducacion.gov.co/",
							"IServicioEstablecimientoEducativoPort"));

			// HeaderHandlerResolver handlerResolver=new
			// HeaderHandlerResolver(userNameHeader, passwordHeader);

			// portNameService.setHandlerResolver(handlerResolver);

			IServicioEstablecimientoEducativo resolucionesPortName = portNameService
					.getIServicioEstablecimientoEducativoPort();

			BindingProvider bindingProvider = (BindingProvider) resolucionesPortName;

			bindingProvider.getRequestContext().put("javax.xml.ws.service.endpoint.address", urlAmbiente);

			eu = resolucionesPortName.obtenerEstablecimientoEducativo(codDaneEstablecimientoEducativo);
			System.out.print("mensaje de pruebas" + eu.getCodMunicipio());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return eu;

		// return port.obtenerEstablecimientoEducativo(codDaneEstablecimientoEducativo);
	}

	private static EstablecimientosEducativosPaginado obtenerEstablecimientosEducativos(

			co.clientes.services.establecimientoseducativos.FiltroEstablecimientosEducativos filtroEstablecimientosEducativos) {
		co.clientes.services.establecimientoseducativos.ServicioEstablecimientoEducativoService service = new co.clientes.services.establecimientoseducativos.ServicioEstablecimientoEducativoService();
		co.clientes.services.establecimientoseducativos.IServicioEstablecimientoEducativo port = service
				.getIServicioEstablecimientoEducativoPort();
		return port.obtenerEstablecimientosEducativos(filtroEstablecimientosEducativos);
	}

	private static SedeEducativa obtenerSedeEducativa(java.lang.String codSedeEducativa) {
		co.clientes.services.sedeseducativas.ServicioSedeEducativaService service = new co.clientes.services.sedeseducativas.ServicioSedeEducativaService();
		co.clientes.services.sedeseducativas.IServicioSedeEducativa port = service.getIServicioSedeEducativaPort();
		return port.obtenerSedeEducativa(codSedeEducativa);
	}

	private static java.util.List<java.lang.String> obtenerSedesEducativas(
			java.lang.String codEstablecimientoEducativo) {
		co.clientes.services.sedeseducativas.ServicioSedeEducativaService service = new co.clientes.services.sedeseducativas.ServicioSedeEducativaService();
		co.clientes.services.sedeseducativas.IServicioSedeEducativa port = service.getIServicioSedeEducativaPort();
		return port.obtenerSedesEducativas(codEstablecimientoEducativo);
	}

}
