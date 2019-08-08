/**
 * 
 */
package co.gide.tx.transaction;

import co.gide.tx.entities.GnAmbienteW;
import co.gide.tx.entities.TbClientes;
import co.gide.tx.entities.TbFirmaDigital;
import co.gide.tx.entities.TbRangoFacturacion;
import co.gide.tx.entities.TbResolucionFacturacion;
import co.gide.tx.entities.TbSoftware;
import co.gide.tx.entities.TbSwResolCliente;
import co.gide.tx.persistence.AdminiPersistencia;

public class TransaccionesGIGE extends AdminiPersistencia {

	public  boolean crearFirmaDigital(TbFirmaDigital firmaDigital) {

		AdminiPersistencia.iniciarPersistencia();

		boolean resultado = dm.crearFirmaDigital(firmaDigital);

		System.out.println(" Resultado  IO : " + resultado);

		AdminiPersistencia.closePersistencia();

		return resultado;
	}

	public  boolean crearRango(TbRangoFacturacion rangoFacturacion) {
		// TODO Auto-generated method stub crearRango

		AdminiPersistencia.iniciarPersistencia();

		boolean resultado = dm.crearRango(rangoFacturacion);

		System.out.println(" Resultado  IO : " + resultado);

		AdminiPersistencia.closePersistencia();

		return resultado;

	}

	public  boolean crearResolucion(TbResolucionFacturacion resolucionFacturacion) {
		AdminiPersistencia.iniciarPersistencia();

		boolean resultado = dm.crearResolucion(resolucionFacturacion);

		System.out.println(" Resultado  IO : " + resultado);

		AdminiPersistencia.closePersistencia();

		return resultado;

	}

	public  boolean crearSoftware(TbSoftware software) {

		AdminiPersistencia.iniciarPersistencia();

		boolean resultado = dm.crearSoftware(software);

		System.out.println(" Resultado  IO : " + resultado);

		AdminiPersistencia.closePersistencia();

		return resultado;
	}

	public  boolean crearTiporResolucion(TbClientes tipoRango) {

		AdminiPersistencia.iniciarPersistencia();

		boolean resultado = dm.crearCliente(tipoRango);

		System.out.println(" Resultado  IO : " + resultado);

		AdminiPersistencia.closePersistencia();

		return resultado;
	}

	public  boolean crearRelacion(TbSwResolCliente tbSwResolCliente) {

		AdminiPersistencia.iniciarPersistencia();

		boolean resultado = dm.crearRelacion(tbSwResolCliente);

		System.out.println(" Resultado  IO : " + resultado);

		AdminiPersistencia.closePersistencia();

		return resultado;
	}

	public   GnAmbienteW getAmbiente(String usuario, String password, String num_ident, String TipoDoc,
			String prefijo, int consecutivo) {

		AdminiPersistencia.iniciarPersistencia();

		GnAmbienteW resultado = dm.getAmbiente(usuario, password, num_ident, TipoDoc, prefijo, consecutivo);

		System.out.println(" Resultado  IO : " + resultado.getNombres());

		AdminiPersistencia.closePersistencia();

		return resultado;
	}

}
