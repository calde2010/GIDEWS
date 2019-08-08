package co.gide.tx.persistence;

import java.util.Date;


import co.gide.tx.entities.GnAmbienteW;
import co.gide.tx.entities.TbClientes;
import co.gide.tx.entities.TbFirmaDigital;
import co.gide.tx.entities.TbParametros;
import co.gide.tx.entities.TbRangoFacturacion;
import co.gide.tx.entities.TbResolucionFacturacion;
import co.gide.tx.entities.TbSoftware;
import co.gide.tx.entities.TbSwResolCliente;


public interface DocumentoManagenador {

	String insertarEstado(Integer UID_DOEL, Integer UID_EMPR, String NOM_TABL, Date FEC_DOEL, String PRE_DOEL,
			Integer NUM_DOEL, Integer TIP_DOEL, String COD_CUFE, Date FEC_RECI, Integer EST_RECI, Date FEC_PROC,
			Integer EST_PROC, Date FEC_FIRM, Integer EST_FIRM, Date FEC_TXDI, Integer EST_TXDI

	);


	
	boolean crearCliente(TbClientes cliente);
	boolean crearSoftware(TbSoftware  software);
	boolean crearParametros(TbParametros  parametro);
	boolean crearRango(TbRangoFacturacion  rangoFacturacion );
	boolean crearFirmaDigital(TbFirmaDigital  firmaDigital);
	boolean crearResolucion(TbResolucionFacturacion resolucionFacturacion);
	boolean crearRelacion(TbSwResolCliente tbSwResolCliente);
	GnAmbienteW getAmbiente(String usuario, String password, String num_ident, String TipoDoc, String prefijo, int consecutivo);

}
