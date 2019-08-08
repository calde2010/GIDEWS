package co.gide.traslate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import co.gide.traslate.entity.Empresa;
import co.gide.tx.entities.GnAmbienteW;
import co.gov.dian.contratos.facturaelectronica.v1.structures.AuthrorizedInvoices;
import co.gov.dian.contratos.facturaelectronica.v1.structures.DianExtensionsType;
import co.gov.dian.contratos.facturaelectronica.v1.structures.InvoiceControl;
import co.gov.dian.contratos.facturaelectronica.v1.structures.SoftwareProvider;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CountryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EndDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IdentificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StartDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TextType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.ExtensionContentType;
import un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.IdentifierType;
import com.growupit.gideesquema.ArchivoElectronicoTipo;
import com.growupit.validate.ValidatorUBL;

public class Extensiones {
	private ArchivoElectronicoTipo lEDoc;
	private GnAmbienteW ambienteEmpresa;
	String CUFE;
	static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Extensiones.class.getName());

	public Extensiones(ArchivoElectronicoTipo eDoc,  GnAmbienteW ambiente,String CUFE) {
		this.lEDoc = eDoc;
		this.ambienteEmpresa = ambiente;
		this.CUFE=CUFE;
	}

	public ExtensionContentType dianExtensions() throws ParseException {
		ExtensionContentType objExtensionContentType = new ExtensionContentType();
		objExtensionContentType.setDianExtensions(cargarDianExtensions());
		return objExtensionContentType;
	}

	public DianExtensionsType cargarDianExtensions() throws ParseException {

		DianExtensionsType objDianExtensionsType = new DianExtensionsType();
		if (lEDoc.getDatosDeControl().getTipoDocumentoElectronico() == 1) { // .getEncabezado().getTipoDocElectronico().equals("1"))
																			// {
			objDianExtensionsType.setInvoiceControl(cargarInvoiceControl());
		}

		objDianExtensionsType.setInvoiceSource(cargarCountryType());
		objDianExtensionsType.setSoftwareProvider(cargarSoftwareProvider());
		objDianExtensionsType.setSoftwareSecurityCode(cargarIdentifierType());
		return objDianExtensionsType;
	}

	public IdentifierType cargarIdentifierType() {
		String securityCode = ambienteEmpresa.getCtc() + "" + ambienteEmpresa.getPin();
		securityCode = securityCode.trim();
		return cargarIdentifierType("195", "CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)",
				sha384Resumen(securityCode));

	}

	// Se carga la identificacion del software.
	public SoftwareProvider cargarSoftwareProvider() {
		SoftwareProvider objSoftwareProvider = new SoftwareProvider();
		objSoftwareProvider.setProviderID(cargarIdentifierType("195",
				"CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)", ambienteEmpresa.getNumIdentificacion())); // el numero
																											// de
																											// identificacion
																											// corresponde
																											// al nit,
																											// cedula,
																											// etc
		objSoftwareProvider
				.setSoftwareID(cargarIdentifierType("195", "CO, DIAN (Direccion de Impuestos y Aduanas Nacionales)",
						String.valueOf(ambienteEmpresa.getCtc())));// identificado del software
		return objSoftwareProvider;
	}

	public IdentifierType cargarIdentifierType(String schemeAgencyID, String schemeAgencyName, String value) {

		IdentifierType objProviderID = new IdentifierType();
		objProviderID.setSchemeAgencyID(schemeAgencyID);
		objProviderID.setSchemeAgencyName(schemeAgencyName);
		objProviderID.setValue(value);
		return objProviderID;
	}

	// Se cargan los datos de control de la factura
	public InvoiceControl cargarInvoiceControl() throws ParseException {

		Calendar cal;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		InvoiceControl objInvoiceControl = new InvoiceControl();
		// StartDateType
		// objStartDateType=cargarStartDateType(objResolucion.getInvoiceControl_AuthorizationPeriod_StartDate());
		// EndDateType
		// objEndDateType=cargarEndDateType(objResolucion.getInvoiceControl_AuthorizationPeriod_EndDate());
		objInvoiceControl.setInvoiceAuthorization(new BigDecimal(ambienteEmpresa.getCodigoResolucionFacturacion())); // numero de la
																									// resolucion de
		ValidatorUBL validate = new ValidatorUBL(); // facturacion
		Calendar fecha_inicio = validate.cargarCalendar(ambienteEmpresa.getFechaInicial());
		Calendar fecha_fin = validate.cargarCalendar(ambienteEmpresa.getFechaFinal());

		objInvoiceControl.setAuthorizationPeriod(cargarPeriodType(fecha_inicio, fecha_fin));

		// Se carga el prefijo, rangos y numero de la factura
		objInvoiceControl.setAuthorizedInvoices(cargarAuthrorizedInvoices((int) ambienteEmpresa.getNumeroInicial(),
				(int) ambienteEmpresa.getNumeroFinal(), cargarTextType(ambienteEmpresa.getPrefijo().trim())));
		return objInvoiceControl;
	}

	public CountryType cargarCountryType() {
		CountryType objCountryType = new CountryType();
		IdentificationCodeType objIdentificationCodeType = new IdentificationCodeType();
		objIdentificationCodeType.setListAgencyID("6");
		objIdentificationCodeType.setListAgencyName("United Nations Economic Commission for Europe");
		objIdentificationCodeType
				.setListSchemeURI("urn:oasis:names:specification:ubl:codelist:gc:CountryIdentificationCode-2.0");
		objIdentificationCodeType.setValue("CO");
		objCountryType.setIdentificationCode(objIdentificationCodeType);
		return objCountryType;
	}

	public StartDateType cargarStartDateType(Calendar objStartDate) throws ParseException {
		StartDateType objStartDateType = new StartDateType();
		objStartDateType.setValue(objStartDate);
		return objStartDateType;
	}

	public EndDateType cargarEndDateType(Calendar objEndtDate) throws ParseException {
		EndDateType objEndDateType = new EndDateType();
		objEndDateType.setValue(objEndtDate);
		return objEndDateType;
	}

	public Date convertStringToDate(String date) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(date);
	}

	public PeriodType cargarPeriodType(Calendar fecha_inicio, Calendar fecha_fin) {

		PeriodType objPeriodType = new PeriodType();
		StartDateType startDate = new StartDateType();
		startDate.setValue(fecha_inicio);
		objPeriodType.setStartDate(startDate);
		EndDateType endDate = new EndDateType();
		endDate.setValue(fecha_fin);
		objPeriodType.setEndDate(endDate);
		return objPeriodType;
	}

	public AuthrorizedInvoices cargarAuthrorizedInvoices(int from, int to, TextType objTextType) {

		AuthrorizedInvoices objAuthrorizedInvoices = new AuthrorizedInvoices();
		objAuthrorizedInvoices.setFrom(from);
		objAuthrorizedInvoices.setTo(to);
		objAuthrorizedInvoices.setPrefix(objTextType);
		return objAuthrorizedInvoices;
	}

	public TextType cargarTextType(String value) {

		TextType objTextType = new TextType();
		objTextType.setValue(value);
		return objTextType;
	}

	public XMLGregorianCalendar fechaGregorian(Date objDateInicial) {
		XMLGregorianCalendar date = null;
		GregorianCalendar calencarioInicial = new GregorianCalendar();
		calencarioInicial.setTime(objDateInicial);
		try {
			date = DatatypeFactory.newInstance().newXMLGregorianCalendar(calencarioInicial);

		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	private String sha384Resumen(String encriptar) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-384");

			byte[] hash = digest.digest(encriptar.getBytes());
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < hash.length; ++i) {
				String hex = Integer.toHexString(0xFF & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			// LOG.error("Error en HeaderHandler - sha384Resumen", e);
		}
		return null;
	}

}