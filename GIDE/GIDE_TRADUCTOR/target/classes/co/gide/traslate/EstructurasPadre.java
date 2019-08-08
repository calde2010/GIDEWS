package co.gide.traslate;

import java.text.ParseException;

import com.growupit.gideesquema.ArchivoElectronicoTipo;
import com.growupit.gideesquema.TipoCargo;
import com.growupit.gideesquema.TipoCodigo;
import com.growupit.gideesquema.TipoDetalleFactura;
import com.growupit.gideesquema.TipoDocumentoReferencia;
import com.growupit.gideesquema.TipoEntrega;
import com.growupit.gideesquema.TipoIdentificador;
import com.growupit.gideesquema.TipoImpuestoTotal;
import com.growupit.gideesquema.TipoMedioPago;
import com.growupit.gideesquema.TipoPago;
import com.growupit.gideesquema.TipoReferenciaFactura;
import com.growupit.gideesquema.TipoReferenciaPedido;
import com.growupit.gideesquema.TipoTerminosPago;
import com.growupit.gideesquema.TipoTexto;
import com.growupit.validate.ValidatorUBL;

import co.gide.traslate.entity.Empresa;
import co.gide.tx.entities.GnAmbienteW;
import co.gov.dian.contratos.facturaelectronica.v1.CreditNoteType;
import co.gov.dian.contratos.facturaelectronica.v1.DebitNoteType;
import co.gov.dian.contratos.facturaelectronica.v1.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AccountingCostCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AccountingCostType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomizationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoiceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineCountNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProfileIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UBLVersionIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UUIDType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionsType;

public class EstructurasPadre {
	private ArchivoElectronicoTipo objArchElec;
	private EstructurasBasicas estBasicas;
	private EstructurasAvanzadas estAvanz;
	private ValidatorUBL valida;
	private GnAmbienteW datosEmpresa;
	String CUFE;

	public EstructurasPadre(ArchivoElectronicoTipo objArchElec, GnAmbienteW ambiente, String CUFE) {
		this.datosEmpresa = ambiente;
		this.objArchElec = new ArchivoElectronicoTipo();
		this.objArchElec=objArchElec;
		this.CUFE = CUFE;
		valida = new ValidatorUBL();
	}

	public InvoiceType getFactura() throws ParseException {

		InvoiceType invoice = new InvoiceType();

		Extensiones objArmarExtensiones = new Extensiones(objArchElec, datosEmpresa, CUFE);
		UBLExtensionsType objUBLExtensionsType = new UBLExtensionsType();
		UBLExtensionType objUBLExtensionTypeDian = new UBLExtensionType();
		objUBLExtensionTypeDian.setExtensionContent(objArmarExtensiones.dianExtensions());
		objUBLExtensionsType.getUBLExtension().add(objUBLExtensionTypeDian);

		invoice.setUBLExtensions(objUBLExtensionsType);

		// UBLVersionID

		if (objArchElec.getIdVersion() != null) {

			UBLVersionIDType version = new UBLVersionIDType();
			estBasicas.getIdentificador(objArchElec.getIdVersion(), version);
			invoice.setUBLVersionID(version);
		}

		if (objArchElec.getIdPerfil() != null) {
			ProfileIDType perfilID = new ProfileIDType();
			estBasicas.getIdentificador(objArchElec.getIdPerfil(), perfilID);
			invoice.setProfileID(perfilID);

		}

		if (objArchElec.getID() != null) {
			IDType iD = new IDType();
			estBasicas.getIdentificador(objArchElec.getID(), iD);
			invoice.setID(iD);

		}

		if (objArchElec.getUUID() != null) {

			UUIDType codigoCUFE = new UUIDType();
			estBasicas.getIdentificador(objArchElec.getUUID(), codigoCUFE);
			invoice.setUUID(codigoCUFE);
		}

		if (valida.validateDate(objArchElec.getFechaEmision())) {

			IssueDateType fechaEmision = new IssueDateType();
			fechaEmision.setValue(objArchElec.getFechaEmision());
			invoice.setIssueDate(fechaEmision);
		}

		if (valida.validateDateHora(objArchElec.getHoraEmision())) {

			IssueTimeType horaEmision = new IssueTimeType();
			horaEmision.setValue(objArchElec.getHoraEmision());
			invoice.setIssueTime(horaEmision);
		}

		if (objArchElec.getTipoCodigoFactura() != null) {

			InvoiceTypeCodeType tipoCodigoFactura = new InvoiceTypeCodeType();
			estBasicas.getCodigo(objArchElec.getTipoCodigoFactura(), tipoCodigoFactura);
			invoice.setInvoiceTypeCode(tipoCodigoFactura);
		}

		if ( objArchElec.getNota().get(0).getValue() != null) {
			
			for ( TipoTexto nota : objArchElec.getNota()) {
				NoteType notas = new NoteType();
				try {
					
					
					if (valida.validateDate(nota.getIdIdioma())) {
						notas.setLanguageID(nota.getIdIdioma());
					}

					if ( valida.validateDate(nota.getValue())) {
						notas.setValue(nota.getValue());

					}
					//estBasicas.getTexto(nota, notas);
					invoice.getNote().add(notas);
				} catch (Exception e) {


					e.printStackTrace();
				}
			

		
			}

		}

		if (objArchElec.getCodigoMoneda() != null) {
			TipoCodigo codigo_mon = objArchElec.getCodigoMoneda();
			DocumentCurrencyCodeType codigoMoneda = new DocumentCurrencyCodeType();
			estBasicas.getCodigo(objArchElec.getCodigoMoneda(), codigoMoneda);
			invoice.setDocumentCurrencyCode(codigoMoneda);

		}

		if (objArchElec.getCodigoCentroDeCosto() != null) {
			AccountingCostCodeType CodigoCentroDeCosto = new AccountingCostCodeType();
			estBasicas.getCodigo(objArchElec.getCodigoCentroDeCosto(), CodigoCentroDeCosto);
			invoice.setAccountingCostCode(CodigoCentroDeCosto);

		}

		if (objArchElec.getCentroDeCosto() != null) {
			AccountingCostType CentroDeCosto = new AccountingCostType();
			estBasicas.getTexto(objArchElec.getCentroDeCosto(), CentroDeCosto);
			invoice.setAccountingCost(CentroDeCosto);

		}

		if (objArchElec.getNumeroLineas() != null) {

			LineCountNumericType numeroDeLineas = new LineCountNumericType();
			numeroDeLineas.setValue(objArchElec.getNumeroLineas());
			invoice.setLineCountNumeric(numeroDeLineas);
		}

		if (objArchElec.getPeriodoFactura() != null) {
			PeriodType periodoFactura = new PeriodType();
			estBasicas.getPeriodo(objArchElec.getPeriodoFactura(), periodoFactura);
			invoice.setInvoicePeriod(periodoFactura);

		}

		String codigoCUFE = getCUFE();/// se debe crear una funcion para calcular el cufe
		TipoIdentificador CUFE = new TipoIdentificador();
		if (codigoCUFE != null || codigoCUFE.equals("")) {

			CUFE.setValue(codigoCUFE);

		}

		if (!objArchElec.getReferenciaPedido().isEmpty() || objArchElec.getReferenciaPedido() != null) {
			for (TipoReferenciaPedido ReferenciaPedido : objArchElec.getReferenciaPedido()) {

				invoice.getOrderReference().add(estAvanz.getReferenciaPedidos(ReferenciaPedido, CUFE));// se debe neviar
																										// el
																										// cufe
			}

		}

		if (!objArchElec.getReferenciaFactura().isEmpty() || objArchElec.getReferenciaFactura() != null) {

			for (TipoReferenciaFactura ReferenciaFactura : objArchElec.getReferenciaFactura()) {
				invoice.getBillingReference().add(estBasicas.getReferenciaFactura(ReferenciaFactura));
			}
		}

		if (!objArchElec.getDocumentoReferenciaDespacho().isEmpty()
				|| objArchElec.getDocumentoReferenciaDespacho() != null) {
			for (TipoDocumentoReferencia DocumentoReferenciaDespacho : objArchElec.getDocumentoReferenciaDespacho()) {

				invoice.getDespatchDocumentReference()
						.add(estBasicas.getDocumentoReferencia(DocumentoReferenciaDespacho));
			}

		}

		if (!objArchElec.getDocumentoRefernciaRecepcion().isEmpty()
				|| objArchElec.getDocumentoRefernciaRecepcion() != null) {
			for (TipoDocumentoReferencia DocumentoRefernciaRecepcion : objArchElec.getDocumentoRefernciaRecepcion()) {

				invoice.getReceiptDocumentReference()
						.add(estBasicas.getDocumentoReferencia(DocumentoRefernciaRecepcion));
			}
		}

		if (!objArchElec.getDocumentoReferenciaCreador().isEmpty()
				|| objArchElec.getDocumentoReferenciaCreador() != null) {

			for (TipoDocumentoReferencia DocumentoReferenciaCreador : objArchElec.getDocumentoReferenciaCreador()) {

				invoice.getOriginatorDocumentReference()
						.add(estBasicas.getDocumentoReferencia(DocumentoReferenciaCreador));
			}
		}

		if (!objArchElec.getDocumentoReferenciaContrato().isEmpty()
				|| objArchElec.getDocumentoReferenciaContrato() != null) {

			for (TipoDocumentoReferencia DocumentoReferenciaContrato : objArchElec.getDocumentoReferenciaContrato()) {

				invoice.getContractDocumentReference()
						.add(estBasicas.getDocumentoReferencia(DocumentoReferenciaContrato));
			}
		}

		if (!objArchElec.getDocumentoReferenciaAdicional().isEmpty()
				|| objArchElec.getDocumentoReferenciaAdicional() != null) {

			for (TipoDocumentoReferencia DocumentoReferenciaAdicional : objArchElec.getDocumentoReferenciaAdicional()) {

				invoice.getAdditionalDocumentReference()
						.add(estBasicas.getDocumentoReferencia(DocumentoReferenciaAdicional));
			}
		}

		// zona clientes - vendedores
		if (objArchElec.getTerceroProveedor() != null) {

			invoice.setAccountingSupplierParty(estAvanz.getTerceroProveedor(objArchElec.getTerceroProveedor()));

		}
		if (objArchElec.getTerceroCliente() != null) {

			invoice.setAccountingCustomerParty(estAvanz.getTerceroCliente(objArchElec.getTerceroCliente()));

		}
		if (objArchElec.getTerceroBeneficiario() != null) {
			invoice.setPayeeParty(estBasicas.getTercero(objArchElec.getTerceroBeneficiario()));

		}
		if (objArchElec.getTerceroComprador() != null) {
			invoice.setBuyerCustomerParty(estAvanz.getTerceroComprador(objArchElec.getTerceroComprador()));

		}
		if (objArchElec.getTerceroProveedorVendedor() != null) {

			invoice.setSellerSupplierParty(
					estAvanz.getTerceroProveedorVendedor(objArchElec.getTerceroProveedorVendedor()));

		}
		if (objArchElec.getTerceroRepresentanteFiscal() != null) {

			invoice.setTaxRepresentativeParty(estBasicas.getTercero(objArchElec.getTerceroRepresentanteFiscal()));

		}

		// Terminos y condiciones de entrega

		if (!objArchElec.getEntrega().isEmpty() || objArchElec.getEntrega() != null) {

			for (TipoEntrega entrega : objArchElec.getEntrega()) {
				invoice.getDelivery().add(estAvanz.getCondicionesDeEntrega(entrega));

			}
		}

		if (objArchElec.getTerminosEntrega() != null) {
			invoice.setDeliveryTerms(estAvanz.getTerminosEntrega(objArchElec.getTerminosEntrega()));

		}

		if (!objArchElec.getMedioPago().isEmpty() || objArchElec.getMedioPago() != null) {

			for (TipoMedioPago medioDePago : objArchElec.getMedioPago()) {
				invoice.getPaymentMeans().add(estAvanz.getMedioDePago(medioDePago));
			}
		}

		if (!objArchElec.getTerminosPago().isEmpty() || objArchElec.getTerminosPago() != null) {

			for (TipoTerminosPago TerminoDePago : objArchElec.getTerminosPago()) {
				invoice.getPaymentTerms().add(estAvanz.getTerminoDePago(TerminoDePago));

			}
		}

		if (!objArchElec.getPagosAnticipados().isEmpty() || objArchElec.getPagosAnticipados() != null) {

			for (TipoPago PagoAnticipado : objArchElec.getPagosAnticipados()) {
				invoice.getPrepaidPayment().add(estAvanz.getPagoAnticipado(PagoAnticipado));

			}

		}

		if (!objArchElec.getCargo().isEmpty() || objArchElec.getCargo() != null) {

			for (TipoCargo Cargo : objArchElec.getCargo()) {
				invoice.getAllowanceCharge().add(estAvanz.getCargo(Cargo));
			}
		}

		if (objArchElec.getTasaCambioPago() != null) {

			invoice.setPaymentExchangeRate(estAvanz.getTasaCambioPago(objArchElec.getTasaCambioPago()));

		}
		if (objArchElec.getTasaCambioAlternativoPago() != null) {

			invoice.setPaymentAlternativeExchangeRate(
					estAvanz.getTasaCambioPago(objArchElec.getTasaCambioAlternativoPago()));
		}

		if (!objArchElec.getTotalImpuestos().isEmpty() || objArchElec.getTotalImpuestos() != null) {

			for (TipoImpuestoTotal TotalImpuesto : objArchElec.getTotalImpuestos()) {
				invoice.getTaxTotal().add(estAvanz.getTotalImpuesto(TotalImpuesto));
			}

		}
		if (objArchElec.getTotales() != null) {
			invoice.setLegalMonetaryTotal(estAvanz.getTotales(objArchElec.getTotales()));

		}
		if (!objArchElec.getDetalleFactura().isEmpty() || objArchElec.getDetalleFactura() != null) {

			for (TipoDetalleFactura DetalleFactura : objArchElec.getDetalleFactura()) {
				invoice.getInvoiceLine().add(estAvanz.getDetalleFactura(DetalleFactura));
			}
		}

		return invoice;
	}

	public DebitNoteType getNotaDebito() {

		return null;
	}

	public CreditNoteType getNotaCredito() {

		return null;
	}

	// Metodos varios para validaciones, calculos y demas.
	private String getCUFE() {
		// TODO Auto-generated method stub
		return null;
	}
}
