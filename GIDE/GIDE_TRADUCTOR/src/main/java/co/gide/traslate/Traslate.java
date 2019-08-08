package co.gide.traslate;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.growupit.gideesquema.TipoImpuestoTotal;
import com.growupit.gideesquema.TipoSubtotalImpuesto;
import co.gide.traslate.complementos.negocio.Calculos;
import co.gide.traslate.complementos.negocio.Complementos;
import co.gide.traslate.entity.Empresa;
import co.gide.tx.entities.GnAmbienteW;
import co.gov.dian.contratos.facturaelectronica.v1.CreditNoteType;
import co.gov.dian.contratos.facturaelectronica.v1.DebitNoteType;
import co.gov.dian.contratos.facturaelectronica.v1.InvoiceType;

public class Traslate {
	private NumberFormat formatDecimal = new DecimalFormat("#.00");
	private InvoiceType factura;
	private DebitNoteType notaDebito;
	private CreditNoteType notaCredito;
	private GnAmbienteW ambienteEmpresa;
	private com.growupit.gideesquema.ArchivoElectronicoTipo objArchElec;
	private Date FEC_RECI;
	private Integer EST_RECI;
	private Date FEC_PROC;
	private Integer EST_PROC;
	private Date FEC_FIRM;
	private Integer EST_FIRM;
	private Date FEC_TXDI;
	private Integer EST_TXDI;
	String CUFE = null;
	private Complementos objComplementos;
	private GenerarEsquemaDocElect genDocElect;

	public String getDocElec(com.growupit.gideesquema.ArchivoElectronicoTipo objArchElec, GnAmbienteW ambiente) throws ParseException {
		this.objArchElec = objArchElec;
		ambienteEmpresa = ambiente ;
		// <!-- 1 Factura - 2 Nota Debito - 3 Nota Credito-->

		/* Calculo del cufe */
		try {
			CUFE =calcularCufe() ;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		EstructurasPadre estructura = new EstructurasPadre(objArchElec, ambienteEmpresa,CUFE);

		if (objArchElec.getDatosDeControl().getTipoDocumentoElectronico() == 1) {
			factura = new InvoiceType();
			factura = estructura.getFactura();
			genDocElect = new GenerarEsquemaDocElect(factura, "factura.xml", "C:\\LEONARDO",objArchElec.getDatosDeControl().getTipoDocumentoElectronico());

		}
		if (objArchElec.getDatosDeControl().getTipoDocumentoElectronico() == 2) {
			notaDebito = new DebitNoteType();
			notaDebito = estructura.getNotaDebito();
			genDocElect = new GenerarEsquemaDocElect(notaDebito, "factura.xml", "C:\\LEONARDO",objArchElec.getDatosDeControl().getTipoDocumentoElectronico());

			
		}
		if (objArchElec.getDatosDeControl().getTipoDocumentoElectronico() == 3) {
			notaCredito = new CreditNoteType();
			notaCredito = estructura.getNotaCredito();
			// arma el xml con el formato predefinido seagun el tipo de docuemtno
			// electronico
			genDocElect = new GenerarEsquemaDocElect(notaCredito, "factura.xml", "C:\\LEONARDO",objArchElec.getDatosDeControl().getTipoDocumentoElectronico());

		}

		// setea el mandante si aplica la representacion grafica.

		// Firmar digitalmente el XML
		/*
		 * try { FirmarDocumentos.firmarDigitalmenteArchivo(cargarNombreDocElec(),
		 * ambienteEmpresa.getRutKeys().trim(), ambienteEmpresa.getPasKeys().trim(),
		 * ambienteEmpresa.getCerAlia().trim(), ambienteEmpresa.getPasCert().trim(),
		 * ambienteEmpresa.getSigPoli().trim(), ambienteEmpresa.getRutPoli().trim(),
		 * ambienteEmpresa.getRutFfir().trim(), ambienteEmpresa.getRutFfir().trim());
		 * 
		 * 
		 * 
		 * FEC_FIRM = cargarFechaActual(); EST_FIRM = new Integer(1); } catch (Exception
		 * e) { FEC_FIRM = cargarFechaActual(); EST_FIRM = new Integer(0);
		 * e.printStackTrace();
		 * 
		 * } // Zipear documento electronico para la transferencia a al DIAN
		 * 
		 * String rutaFacturaFirmada = ambienteEmpresa.getRutFfir().trim() +
		 * cargarNombreDocElec(); rutaFacturaFirmada = rutaFacturaFirmada.trim(); String
		 * rutaZipFirmado = ambienteEmpresa.getRutFfir().trim() + cargarNombreZip();
		 * rutaZipFirmado = rutaZipFirmado.trim(); try {
		 * objComplementos.crearZip(rutaFacturaFirmada, rutaZipFirmado,
		 * cargarNombreDocElec()); } catch (Exception e) { e.printStackTrace(); }
		 * 
		 * // transeferir factura a la DIAN transferenciaDianXml obj = new
		 * transferenciaDianXml();
		 */

		return "Echo";
	}

	private String cargarNombreZip() {
		// TODO Auto-generated method stub
		return null;
	}

	private Date cargarFechaActual() {
		// TODO Auto-generated method stub
		return null;
	}

	private String cargarNombreDocElec() {
		// TODO Auto-generated method stub
		return null;
	}

 

	public synchronized String calcularCufe() throws NoSuchAlgorithmException {

		// Todos los camos usados en este demo son de caracter obligatorio-
		Complementos objComplementos = new Complementos();

		String NumFac = "";
		// se obtiene el valor del prefijo del documento electronico
		if (objArchElec.getDatosDeControl().getPrefijo() != null) {
			NumFac = objArchElec.getDatosDeControl().getPrefijo().trim();
		}
		// Se obtiene el consecutivo de la fatura
		NumFac += objArchElec.getDatosDeControl().getNumeroDocumentoElectronico();
		// fecha d efacturacion
		String FecFac = cargarFechaTransaccion(objArchElec.getDatosDeControl().getFrechaFacturacion()).replace("-", "");
		FecFac = FecFac.replace(":", "");
		FecFac = FecFac.replace(" ", "");
		// Se obtiene el importe bruto de la factura = valor total sin
		// impuestos, cargos o descuentos
		String ValFacAux = String.valueOf(formatDecimal.format(objArchElec.getTotales().getMontoPagado()));
		// valor de la factura = valor bruto mas impuestos + crgos - descuentos
		String ValImpAux = String.valueOf(formatDecimal.format(objArchElec.getTotales().getMontoIncluyendoImpuesto()));

		String ValFac = objComplementos.completarDecimal(ValFacAux.replace(",", "."));
		// Impuestos
		String impuestos = cargarImpuestos(objArchElec.getTotalImpuestos());
		String ValImp = objComplementos.completarDecimal(ValImpAux.replace(",", "."));

		// Nit del proveedor
		String NitOFE = objArchElec.getTerceroProveedor().getTercero().getIdentificacionTercero().get(0).getValue();

		// Tipo de identificacion del cliente
		String TipAdqobjFactura = String
				.valueOf(
						objArchElec.getTerceroProveedor().getTercero().getIdentificacionTercero().get(0).getIdEsquema())
				.trim();

		// Numero de identificacion deL ADQUIRIENTE
		String NumAdq = (objArchElec.getTerceroCliente().getTercero().getIdentificacionTercero().get(0).getValue())
				.trim();

		// Clave tecnica de control, de Base de datos
		String ClTec = ambienteEmpresa.getCtc(); // objEmpresa.getClavetecnicadecontrol().trim();

		String cadena = NumFac + FecFac + ValFac + "" + impuestos + ValImp + "" + NitOFE + TipAdqobjFactura + NumAdq
				+ ClTec;

		// Calculos objCalculos = new Calculos();

		// se asigna el valor del cufe a una variable

		Calculos calc = new Calculos();
		return calc.sha1(cadena.trim());
	}

	public synchronized String cargarImpuestos(List<TipoImpuestoTotal> listTaxTotal) {
		String codigoImpuestoIva = "01";
		BigDecimal valorImpuestoIvaDefault = BigDecimal.ZERO;
		String codigoImpuestoConsumo = "02";
		BigDecimal valorImpuestoConsumoDefault = BigDecimal.ZERO;
		String codigoImpuestoIca = "03";
		BigDecimal valorImpuestoIcaDefault = BigDecimal.ZERO;

		if (listTaxTotal != null) {
			for (TipoImpuestoTotal totalimpuestos : listTaxTotal) {

				for (TipoSubtotalImpuesto sti : totalimpuestos.getSubtotalImpuesto()) {

					String codigoImpuesto = String.format("%02d",
							Integer.parseInt(sti.getImpuestoCategoria().getRegimenTriburario().getId().getValue()));
					BigDecimal impRetenido = sti.getMontoImpuesto();

					if (codigoImpuestoIva.equals(codigoImpuesto)) {
						valorImpuestoIvaDefault = valorImpuestoIvaDefault.add(impRetenido);
					} else if (codigoImpuestoConsumo.equals(codigoImpuesto)) {
						valorImpuestoConsumoDefault = valorImpuestoConsumoDefault.add(impRetenido);
					} else if (codigoImpuestoIca.equals(codigoImpuesto)) {
						valorImpuestoIcaDefault = valorImpuestoIcaDefault.add(impRetenido);
					}
				}
			}
		}

		Complementos objComplementos = new Complementos();

		String valorImpuestoIva = objComplementos
				.competarDecimal_2(String.valueOf(formatDecimal.format(valorImpuestoIvaDefault)).replace(",", "."));
		String valorImpuestoConsumo = objComplementos
				.competarDecimal_2(String.valueOf(formatDecimal.format(valorImpuestoConsumoDefault)).replace(",", "."));
		String valorImpuestoIca = objComplementos
				.competarDecimal_2(String.valueOf(formatDecimal.format(valorImpuestoIcaDefault)).replace(",", "."));

		String cadenaImpuestos = codigoImpuestoIva.concat(objComplementos.completarDecimal(valorImpuestoIva))
				.concat(codigoImpuestoConsumo).concat(objComplementos.completarDecimal(valorImpuestoConsumo))
				.concat(codigoImpuestoIca).concat(objComplementos.completarDecimal(valorImpuestoIca));
		return cadenaImpuestos;
	}

	private String cargarFechaTransaccion(Calendar frechaFacturacion) {
	 
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		System.out.println(frechaFacturacion.getTime());

		String fecha = format1.format(frechaFacturacion.getTime());
		System.out.println(fecha);

		return fecha;
	}

}
