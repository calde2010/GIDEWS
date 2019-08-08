package co.gide.traslate;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.growupit.gideesquema.ArchivoElectronicoTipo;
import com.growupit.gideesquema.TipoImpuestoTotal;
import com.growupit.gideesquema.TipoSubtotalImpuesto;

import co.gide.traslate.complementos.negocio.Calculos;
import co.gide.traslate.complementos.negocio.Complementos;
import co.gide.traslate.entity.Empresa;
import co.gov.dian.contratos.facturaelectronica.v1.CreditNoteType;
import co.gov.dian.contratos.facturaelectronica.v1.DebitNoteType;
import co.gov.dian.contratos.facturaelectronica.v1.InvoiceLineType;
import co.gov.dian.contratos.facturaelectronica.v1.InvoiceType;

public class Traslate {
	private NumberFormat formatDecimal = new DecimalFormat("#.00");
	private InvoiceType factura;
	private DebitNoteType notaDebito;
	private CreditNoteType notaCredito;
	private Empresa ambienteEmpresa;
	private ArchivoElectronicoTipo objArchElec;

	public String getDocElec(ArchivoElectronicoTipo objArchElec) throws ParseException {
		this.objArchElec = objArchElec;
		ambienteEmpresa = getDatosEmpresa();
		// <!-- 1 Factura - 2 Nota Debito - 3 Nota Credito-->

		EstructurasPadre estructura = new EstructurasPadre(objArchElec, ambienteEmpresa);

		if (objArchElec.getDatosDeControl().getTipoDocumentoElectronico() == 1) {
			factura = new InvoiceType();
			factura = estructura.getFactura();
		}
		if (objArchElec.getDatosDeControl().getTipoDocumentoElectronico() == 2) {
			notaDebito = new DebitNoteType();
			notaDebito = estructura.getNotaDebito();
		}
		if (objArchElec.getDatosDeControl().getTipoDocumentoElectronico() == 3) {
			notaCredito = new CreditNoteType();
			notaCredito = estructura.getNotaCredito();

		}

		return null;
	}

	private Empresa getDatosEmpresa() {
		return ambienteEmpresa = new Empresa();

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
		String NumAdq = (objArchElec.getTerceroCliente().getTercero().getIdentificacionTercero().get(0).getIdEsquema())
				.trim();

		// Clave tecnica de control, de Base de datos
		String ClTec = ambienteEmpresa.getClaTecn(); // objEmpresa.getClavetecnicadecontrol().trim();

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
		// TODO Auto-generated method stub
		return null;
	}

}
