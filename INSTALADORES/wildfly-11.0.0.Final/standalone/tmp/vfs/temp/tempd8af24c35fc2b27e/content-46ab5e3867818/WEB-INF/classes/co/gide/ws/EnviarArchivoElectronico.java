package co.gide.ws;

import java.text.ParseException;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import co.gide.traslate.Traslate;
import co.gide.tx.entities.GnAmbienteW;
import co.gide.tx.transaction.TransaccionesGIGE;

@WebService(name = "GIDEServiceOperation", serviceName = "GIDEService", targetNamespace = "http://www.growupit.com.co/GIDEService", portName = "GIDEServicePort")
public class EnviarArchivoElectronico {

	@WebMethod(operationName = "EnviarArchivoElectronicoRequest")
	@WebResult(name = "EnviarArchivoElectronicoResponse")
	public String EnviarArchivoElectronico(com.growupit.gideesquema.ArchivoElectronicoTipo objArchivoElectronico) {

		TransaccionesGIGE gt = new TransaccionesGIGE();

		GnAmbienteW ambiente = new GnAmbienteW();
	
	ambiente= gt.getAmbiente(objArchivoElectronico.getDatosDeControl().getUsuario(),
				objArchivoElectronico.getDatosDeControl().getContrasenia(),
				objArchivoElectronico.getDatosDeControl().getNumeroIdentificacion(),
				objArchivoElectronico.getDatosDeControl().getTipoDocIdentificacion(),
				objArchivoElectronico.getDatosDeControl().getPrefijo(),
				objArchivoElectronico.getDatosDeControl().getNumeroDocumentoElectronico());
	
	
	if (ambiente != null) {
		
		
	}
		Traslate traductor = new Traslate();
		try {
			String resultado =	traductor.getDocElec(objArchivoElectronico,ambiente);
			
			return resultado;
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return null;

	}

}
