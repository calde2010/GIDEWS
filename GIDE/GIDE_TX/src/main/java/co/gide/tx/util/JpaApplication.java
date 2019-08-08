/**
 * 
 */
package co.gide.tx.util;

import java.util.Date;

import co.gide.tx.entities.GnAmbienteW;
import co.gide.tx.entities.TbClientes;
import co.gide.tx.entities.TbFirmaDigital;
import co.gide.tx.entities.TbParametros;
import co.gide.tx.entities.TbRangoFacturacion;
import co.gide.tx.entities.TbResolucionFacturacion;
import co.gide.tx.entities.TbSoftware;
import co.gide.tx.entities.TbSwResolCliente;
import co.gide.tx.persistence.AdminiPersistencia;

public class JpaApplication extends AdminiPersistencia {

//	public static void main(String[] args) {

	
		/*
		TbFirmaDigital  firmaDigital =  new TbFirmaDigital("Growupit", "Bogota18*", "D:\\firmaDigital\\server.crt",new Date("2/06/2019"),new Date("2/06/2020")) ;
		 crearFirmaDigital(firmaDigital);
		 
		 */
		/*
		TbSwResolCliente tbSwResolCliente = new TbSwResolCliente(1,1,1,1,"A");
		crearRelacion(tbSwResolCliente);*/
		// crearParametros(TbParametros  parametro);
		
		/*
		 TbResolucionFacturacion idResolFactura= new  TbResolucionFacturacion();
		 idResolFactura.setIdResolFactura(1);
		 
		TbRangoFacturacion  rangoFacturacion = new TbRangoFacturacion(new Date("2/05/2019"),new Date("2/05/2020"),1,10000,
				"PRU","P", idResolFactura);
		 crearRango(rangoFacturacion );
		 */
		// crearFirmaDigital(TbFirmaDigital  firmaDigital);
		/*
		TbResolucionFacturacion resolucionFacturacion= new  TbResolucionFacturacion("GideSOFT resolcion de pruebas","P");
		 crearResolucion(resolucionFacturacion);
		 */
		
		/*
		TbSoftware software = new TbSoftware("GideSOFT","1012122214543", "Bogota18", "120298343","www.dondesea.com.co");
		crearSoftware(software);
		*/
		
		//TbClientes tipoRango = new TbClientes();

		/*tipoRango.cargarClientes("CC", "Natural", "1051822275", "Growupit S A S", "Growupit S A S",
				new Date("2/06/2019"), new Date("2/06/2029"), "info@growupit.com.co", "1051822275", "Growupit#gide",
				"123456789");
		
		boolean resultado = crearTiporResolucion(tipoRango);

		System.out.println(" Resultado  : " + resultado);*/

		
	//}

	private   boolean crearFirmaDigital(TbFirmaDigital firmaDigital) {
		
		AdminiPersistencia.iniciarPersistencia();

		boolean resultado = dm.crearFirmaDigital(firmaDigital);

		System.out.println(" Resultado  IO : " + resultado);

		AdminiPersistencia.closePersistencia();

		return resultado;
	}

	private   boolean crearRango(TbRangoFacturacion rangoFacturacion) {
		// TODO Auto-generated method stub crearRango
		
		AdminiPersistencia.iniciarPersistencia();

		boolean resultado = dm.crearRango(rangoFacturacion);

		System.out.println(" Resultado  IO : " + resultado);

		AdminiPersistencia.closePersistencia();

		return resultado;
		
	}

	private   boolean crearResolucion(TbResolucionFacturacion resolucionFacturacion) {
		AdminiPersistencia.iniciarPersistencia();

		boolean resultado = dm.crearResolucion(resolucionFacturacion);

		System.out.println(" Resultado  IO : " + resultado);

		AdminiPersistencia.closePersistencia();

		return resultado;
		
	}

	private   boolean crearSoftware(TbSoftware software) {
		

		AdminiPersistencia.iniciarPersistencia();

		boolean resultado = dm.crearSoftware(software);

		System.out.println(" Resultado  IO : " + resultado);

		AdminiPersistencia.closePersistencia();

		return resultado;
	}

	private   boolean crearTiporResolucion(TbClientes tipoRango) {

		AdminiPersistencia.iniciarPersistencia();

		boolean resultado = dm.crearCliente(tipoRango);

		System.out.println(" Resultado  IO : " + resultado);

		AdminiPersistencia.closePersistencia();

		return resultado;
	}

	
	private   boolean crearRelacion(TbSwResolCliente tbSwResolCliente) {

		AdminiPersistencia.iniciarPersistencia();

		boolean resultado = dm.crearRelacion(tbSwResolCliente);

		System.out.println(" Resultado  IO : " + resultado);

		AdminiPersistencia.closePersistencia();

		return resultado;
	}
	private   GnAmbienteW getAmbiente(String usuario, String password, String num_ident, String TipoDoc,
			String prefijo, int consecutivo) {

		AdminiPersistencia.iniciarPersistencia();

		GnAmbienteW resultado = dm.getAmbiente(usuario, password, num_ident, TipoDoc, prefijo, consecutivo);

		System.out.println(" Resultado  IO : " + resultado.getNombres());

		AdminiPersistencia.closePersistencia();

		return resultado;
	}

 
	
	
	
}
