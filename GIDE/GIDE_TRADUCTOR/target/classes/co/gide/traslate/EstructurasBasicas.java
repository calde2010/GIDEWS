package co.gide.traslate;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.growupit.gideesquema.TipoArchivoAdjunto;
import com.growupit.gideesquema.TipoArticuloPeligroso;
import com.growupit.gideesquema.TipoAtriburoFisico;
import com.growupit.gideesquema.TipoCargo;
import com.growupit.gideesquema.TipoClasificacionMercancia;
import com.growupit.gideesquema.TipoCodigo;
import com.growupit.gideesquema.TipoComunicacion;
import com.growupit.gideesquema.TipoCondicionesTransaccion;
import com.growupit.gideesquema.TipoContacto;
import com.growupit.gideesquema.TipoCoordenadasUbicacion;
import com.growupit.gideesquema.TipoCuentaFinanciera;
import com.growupit.gideesquema.TipoCuentaTarjeta;
import com.growupit.gideesquema.TipoDimension;
import com.growupit.gideesquema.TipoDireccion;
import com.growupit.gideesquema.TipoDocumentoReferencia;
import com.growupit.gideesquema.TipoEntidadLegalTercero;
import com.growupit.gideesquema.TipoEnvio;
import com.growupit.gideesquema.TipoEsquemaImpuestosTercero;
import com.growupit.gideesquema.TipoEsquemaRegistroCorporativo;
import com.growupit.gideesquema.TipoExternalReference;
import com.growupit.gideesquema.TipoGrupoPropiedadesArticulo;
import com.growupit.gideesquema.TipoIdentificacionArticulos;
import com.growupit.gideesquema.TipoIdentificacionLote;
import com.growupit.gideesquema.TipoIdentificador;
import com.growupit.gideesquema.TipoImpuestoCategoria;
import com.growupit.gideesquema.TipoImpuestoTotal;
import com.growupit.gideesquema.TipoInstanciaArticulo;
import com.growupit.gideesquema.TipoLineaReferencia;
import com.growupit.gideesquema.TipoListaPrecios;
import com.growupit.gideesquema.TipoMedioPago;
import com.growupit.gideesquema.TipoObjetoBinario;
import com.growupit.gideesquema.TipoPais;
import com.growupit.gideesquema.TipoPeriodo;
import com.growupit.gideesquema.TipoPersona;
import com.growupit.gideesquema.TipoPrecio;
import com.growupit.gideesquema.TipoPropiedadArticulo;
import com.growupit.gideesquema.TipoReferenciaFactura;
import com.growupit.gideesquema.TipoReferenciaLineaFactura;
import com.growupit.gideesquema.TipoReferenciaLineaPedido;
import com.growupit.gideesquema.TipoReferenciaPedido;
import com.growupit.gideesquema.TipoReferenciaPrecios;
import com.growupit.gideesquema.TipoRegimenTriburario;
import com.growupit.gideesquema.TipoRiesgoSecundario;
import com.growupit.gideesquema.TipoSubtotalImpuesto;
import com.growupit.gideesquema.TipoSucursal;
import com.growupit.gideesquema.TipoTemperatura;
import com.growupit.gideesquema.TipoTercero;
import com.growupit.gideesquema.TipoTexto;
import com.growupit.gideesquema.TipoTransitoBienArriesgado;
import com.growupit.gideesquema.TipoUbicacion;
import com.growupit.gideesquema.TipoUbicacionCantidadArticulo;
import com.growupit.gideesquema.TipoUnidadEntrega;
import com.growupit.validate.ValidatorUBL;

import co.gov.dian.contratos.facturaelectronica.v1.DespatchType;
import co.gov.dian.contratos.facturaelectronica.v1.LocationType;
import co.gov.dian.contratos.facturaelectronica.v1.PartyLegalEntityType;
import co.gov.dian.contratos.facturaelectronica.v1.PartyTaxSchemeType;
import co.gov.dian.contratos.facturaelectronica.v1.PersonType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AttachmentType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.BillingReferenceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.BillingReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.BranchType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CardAccountType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CommodityClassificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CommunicationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ContactType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CorporateRegistrationSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CountryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CreditAccountType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryUnitType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DimensionType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ExternalReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.FinancialAccountType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.FinancialInstitutionType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.HazardousGoodsTransitType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.HazardousItemType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemInstanceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemLocationQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemPropertyGroupType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemPropertyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.LineReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.LocationCoordinateType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.LotIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderLineReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyNameType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMeansType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PhysicalAttributeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PriceListType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PriceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PricingReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SecondaryHazardType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSubtotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TemperatureType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TransactionConditionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.*;
import oasis.names.specification.ubl.schema.xsd.qualifieddatatypes_2.LongitudeDirectionCodeType;
import un.unece.uncefact.codelist.specification.ianamimemediatype._2003.BinaryObjectMimeCodeContentType;
import un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.BinaryObjectType;
import un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.CodeType;

 

public class EstructurasBasicas {

	private ValidatorUBL valida;

	public EstructurasBasicas() {

		valida = new ValidatorUBL();
	}

	// generico para identificador
	public void getIdentificador(TipoIdentificador identificador,
			un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.IdentifierType id) {

		if (valida.validateDate(identificador.getNombreEsquema())) {
			id.setSchemeName(identificador.getNombreEsquema());
		}
		if (valida.validateDate(identificador.getURIEsquema())) {
			id.setSchemeURI(identificador.getURIEsquema());
		}
		if (valida.validateDate(identificador.getVersionEsquemaId())) {
			id.setSchemeVersionID(identificador.getVersionEsquemaId());
		}
		if (valida.validateDate(identificador.getValue())) {
			id.setValue(identificador.getValue());
		}
		if (valida.validateDate(identificador.getAgenciaEsquemaId())) {
			id.setSchemeAgencyID(identificador.getAgenciaEsquemaId());
		}
		if (valida.validateDate(identificador.getNombreAgenciaEsquema())) {
			id.setSchemeAgencyName(identificador.getNombreAgenciaEsquema());
		}
		if (valida.validateDate(identificador.getEsquemaDatosURI())) {
			id.setSchemeDataURI(identificador.getEsquemaDatosURI());
		}
		if (valida.validateDate(identificador.getIdEsquema())) {
			id.setSchemeID(identificador.getIdEsquema());
		}

	}

	public void getIdentificadorTercero(TipoIdentificador identificador, PartyIdentificationType id) {

		if (identificador != null) {
			IDType Identificador = new IDType();
			getIdentificador(identificador, Identificador);
			id.setID(Identificador);
		}
	}

	// Generico para codigo
	public void getCodigo(TipoCodigo codigo,
			un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.CodeType code) {

		if (valida.validateDate(codigo.getIdIdioma())) {
			code.setLanguageID(codigo.getIdIdioma());
		}

		if (valida.validateDate(codigo.getIdListaAgencia())) {
			code.setListAgencyID(codigo.getIdListaAgencia());

		}
		if (valida.validateDate(codigo.getNombreListaAgencia())) {
			code.setListAgencyName(codigo.getNombreListaAgencia());

		}
		if (valida.validateDate(codigo.getIdLista())) {
			code.setListID(codigo.getIdLista());

		}
		if (valida.validateDate(codigo.getNombreLista())) {
			code.setListName(codigo.getNombreLista());

		}
		if (valida.validateDate(codigo.getURIEsquemaLista())) {
			code.setListSchemeURI(codigo.getURIEsquemaLista());

		}
		if (valida.validateDate(codigo.getURILista())) {
			code.setListURI(codigo.getURILista());

		}
		if (valida.validateDate(codigo.getIdVersionLista())) {
			code.setListVersionID(codigo.getIdVersionLista());

		}
		if (valida.validateDate(codigo.getNombe())) {
			code.setName(codigo.getNombe());

		}
		if (valida.validateDate(codigo.getValue())) {
			code.setValue(codigo.getValue());

		}

	}

	// generico para, los tipos texto
	public void getTexto(TipoTexto texto,
			un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.TextType text) {
		if (texto.getIdIdioma().equals(null)) {
			text.setLanguageID(texto.getIdIdioma());
		}

		if ( valida.validateDate(texto.getValue())) {
			text.setValue(texto.getValue());

		}

	}

	public void getLineaDireccion(TipoTexto direccion, AddressLineType lineaDireccion) {
		LineType texto = new LineType();
		if (valida.validateDate(direccion.getValue())) {
			texto.setValue(direccion.getValue());
		}
		if (valida.validateDate(direccion.getIdIdioma())) {
			texto.setLanguageID(direccion.getIdIdioma());
		}

		lineaDireccion.setLine(texto);
	}

	public void getPeriodo(TipoPeriodo periodo,
			oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType period) {

		if (valida.validateDate(periodo.getMedidaDuracion())) {
			DurationMeasureType medida = new DurationMeasureType();
			getMedida(periodo.getMedidaDuracion(), medida);
			period.setDurationMeasure(medida);
		}
		if (valida.validateDate(periodo.getFechaFin())) {
			EndDateType diaFin = new EndDateType();
			diaFin.setValue(periodo.getFechaFin());
			period.setEndDate(diaFin);
		}

		if (valida.validateDateHora(periodo.getHoraFin())) {
			EndTimeType horaFin = new EndTimeType();
			horaFin.setValue(periodo.getHoraFin());
			period.setEndTime(horaFin);
		}

		if (valida.validateDate(periodo.getFechaInicio())) {
			StartDateType diaInicio = new StartDateType();
			diaInicio.setValue(periodo.getFechaInicio());
			period.setStartDate(diaInicio);
		}

		if (valida.validateDateHora(periodo.getHoraInicio())) {
			StartTimeType horaInicio = new StartTimeType();
			horaInicio.setValue(periodo.getHoraInicio());
			period.setStartTime(horaInicio);
		}

		if (!periodo.getDescripcion().isEmpty() && periodo.getDescripcion() != null) {
			for (TipoTexto descripcion : periodo.getDescripcion()) {
				DescriptionType descriptionType = new DescriptionType();
				getTexto(descripcion, descriptionType);
				period.getDescription().add(descriptionType);
			}
		}

		if (!periodo.getCodigoDescripcion().isEmpty() && periodo.getCodigoDescripcion() != null) {
			for (TipoCodigo codigoDescripcion : periodo.getCodigoDescripcion()) {

				DescriptionCodeType descriptionCodeType = new DescriptionCodeType();
				getCodigo(codigoDescripcion, descriptionCodeType);

				period.getDescriptionCode().add(descriptionCodeType);
			}
		}

	}

	public void getMedida(BigDecimal duracion, DurationMeasureType medida) {
		if (duracion != null) {
			medida.setValue(duracion);
		}

	}

	public void getMedida(BigDecimal duracion, LongitudeMinutesMeasureType medidaLongitudMinutos) {
		if (duracion != null) {
			medidaLongitudMinutos.setValue(duracion);
		}

	}

	public void getMedida(TipoCodigo tipoCodigo, LongitudeDirectionCodeType codigoLongitudDireccion) {
		if (tipoCodigo != null) {
			getCodigo(tipoCodigo, codigoLongitudDireccion);

		}
	}

	public void getMedida(BigDecimal duracion, LongitudeDegreesMeasureType medidaLongitudGrados) {
		if (duracion != null) {
			medidaLongitudGrados.setValue(duracion);

		}

	}

	public void getMedida(BigDecimal duracion, LatitudeDegreesMeasureType medidaGradosLatitud) {
		if (duracion != null) {
			medidaGradosLatitud.setValue(duracion);
		}

	}

	public void getMedida(BigDecimal duracion, LatitudeMinutesMeasureType medidaMinutosLatitud) {
		if (duracion != null) {
			medidaMinutosLatitud.setValue(duracion);

		}

	}

	public void getMonto(BigDecimal monto,
			un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.AmountType Amount) {
		if (monto != null) {
			Amount.setValue(monto);

		}

	}

	@SuppressWarnings("static-access")
	public void getObjetobinario(TipoObjetoBinario objetoBinario, BinaryObjectType objBinario) {

		BinaryObjectMimeCodeContentType codigoMime = null;

		if (valida.validateDate(objetoBinario.getGrupoCaracteresCodigo())) {
			objBinario.setCharacterSetCode(objetoBinario.getGrupoCaracteresCodigo());
		}
		if (valida.validateDate(objetoBinario.getCodigoCodigicado())) {
			objBinario.setEncodingCode(objetoBinario.getCodigoCodigicado());
		}
		if (valida.validateDate(objetoBinario.getNombreArchivo())) {
			objBinario.setFilename(objetoBinario.getNombreArchivo());
		}
		if (valida.validateDate(objetoBinario.getFormato())) {
			objBinario.setFormat(objetoBinario.getFormato());
		}
		if (valida.validateDate(objetoBinario.getMimeCode())) {
			objBinario.setMimeCode(codigoMime.valueOf(objetoBinario.getMimeCode()));

		}
		if (valida.validateDate(objetoBinario.getUri())) {
			objBinario.setUri(objetoBinario.getUri());
		}

		if (objetoBinario.getValue() != null) {
			objBinario.setValue(objetoBinario.getValue());
		}

	}

	public ContactType getContacto(TipoContacto contactoContable) {

		ContactType contacto = new ContactType();
		if (contactoContable.getID() != null) {
			IDType id = new IDType();
			getIdentificador(contactoContable.getID(), id);
			contacto.setID(id);
		}

		if (valida.validateDate(contactoContable.getNombre())) {
			NameType nombre = new NameType();
			getNombre(contactoContable.getNombre(), nombre);
			contacto.setName(nombre);
		}

		if (contactoContable.getFax() != null) {
			TelefaxType teleFax = new TelefaxType();
			getTexto(contactoContable.getFax(), teleFax);
			contacto.setTelefax(teleFax);
		}

		if (contactoContable.getTelefono() != null) {
			TelephoneType telefono = new TelephoneType();
			getTexto(contactoContable.getTelefono(), telefono);
			contacto.setTelephone(telefono);
		}

		if (contactoContable.getCorreoElectronico() != null) {
			ElectronicMailType email = new ElectronicMailType();
			getTexto(contactoContable.getCorreoElectronico(), email);
			contacto.setElectronicMail(email);
		}

		if (valida.validateDate(contactoContable.getNota().getValue())) {
			NoteType nota = new NoteType();
			nota.setValue(contactoContable.getNota().getValue());
			contacto.setNote(nota);
		}

		if (!contactoContable.getComunicacion().isEmpty() && contactoContable.getComunicacion() != null) {
			for (TipoComunicacion comunicacion : contactoContable.getComunicacion()) {
				contacto.getOtherCommunication().add(getComunicacion(comunicacion));
			}
		}

		return contacto;
	}

	private CommunicationType getComunicacion(TipoComunicacion tipoComunicacion) {

		CommunicationType comunicacion = new CommunicationType();
		if (tipoComunicacion.getCanal() != null) {
			ChannelType canal = new ChannelType();
			getTexto(tipoComunicacion.getCanal(), canal);
			comunicacion.setChannel(canal);
		}

		if (tipoComunicacion.getCodigoCanal() != null) {
			ChannelCodeType codigoCanal = new ChannelCodeType();
			getCodigo(tipoComunicacion.getCodigoCanal(), codigoCanal);
			comunicacion.setChannelCode(codigoCanal);
		}

		if (tipoComunicacion.getValor() != null) {
			ValueType valor = new ValueType();
			getTexto(tipoComunicacion.getValor(), valor);
			comunicacion.setValue(valor);
		}

		return comunicacion;
	}

	public LocationType getUbicacionFisica(TipoUbicacion ubicacion) {
		LocationType localizacion = new LocationType();
		if (ubicacion.getDireccion() != null) {
			localizacion.setAddress(getDireccion2(ubicacion.getDireccion()));
		}

		if (ubicacion.getCondiciones() != null) {
			ConditionsType condiciones = new ConditionsType();
			getTexto(ubicacion.getCondiciones(), condiciones);
			localizacion.setConditions(condiciones);
		}

		if (ubicacion.getSubentidadPais() != null) {
			CountrySubentityType subentidadPais = new CountrySubentityType();
			getTexto(ubicacion.getSubentidadPais(), subentidadPais);
			localizacion.setCountrySubentity(subentidadPais);
		}

		if (ubicacion.getCodigoSubentidadPais() != null) {
			CountrySubentityCodeType codigoSubentidadPais = new CountrySubentityCodeType();
			getCodigo(ubicacion.getCodigoSubentidadPais(), codigoSubentidadPais);
			localizacion.setCountrySubentityCode(codigoSubentidadPais);
		}

		if (ubicacion.getDescripcion() != null) {
			DescriptionType descripcion = new DescriptionType();
			getTexto(ubicacion.getDescripcion(), descripcion);
			localizacion.setDescription(descripcion);
		}

		if (ubicacion.getID() != null) {
			IDType id = new IDType();
			getIdentificador(ubicacion.getID(), id);
			localizacion.setID(id);
		}

		if (!ubicacion.getPeriodoValidez().isEmpty() && ubicacion.getPeriodoValidez() != null) {
			for (TipoPeriodo periodos : ubicacion.getPeriodoValidez()) {
				PeriodType PeriodoValidez = new PeriodType();
				getPeriodo(periodos, PeriodoValidez);
				localizacion.getValidityPeriod().add(PeriodoValidez);
			}
		}

		return localizacion;
	}

	public oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.LocationType getUbicacionFisica2(
			TipoUbicacion ubicacion) {

		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.LocationType localizacion = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.LocationType();

		if (ubicacion.getDireccion() != null) {
			localizacion.setAddress(getDireccion(ubicacion.getDireccion()));

		}
		if (ubicacion.getCondiciones() != null) {
			ConditionsType condiciones = new ConditionsType();
			getTexto(ubicacion.getCondiciones(), condiciones);
			localizacion.setConditions(condiciones);
		}

		if (ubicacion.getSubentidadPais() != null) {
			CountrySubentityType subentidadPais = new CountrySubentityType();
			getTexto(ubicacion.getSubentidadPais(), subentidadPais);
			localizacion.setCountrySubentity(subentidadPais);
		}

		if (ubicacion.getCodigoSubentidadPais() != null) {
			CountrySubentityCodeType codigoSubentidadPais = new CountrySubentityCodeType();
			getCodigo(ubicacion.getCodigoSubentidadPais(), codigoSubentidadPais);
			localizacion.setCountrySubentityCode(codigoSubentidadPais);
		}

		if (ubicacion.getDescripcion() != null) {
			DescriptionType descripcion = new DescriptionType();
			getTexto(ubicacion.getDescripcion(), descripcion);
			localizacion.setDescription(descripcion);
		}

		if (ubicacion.getID() != null) {
			IDType id = new IDType();
			getIdentificador(ubicacion.getID(), id);
			localizacion.setID(id);
		}

		if (!ubicacion.getPeriodoValidez().isEmpty() && ubicacion.getPeriodoValidez() != null) {
			for (TipoPeriodo periodos : ubicacion.getPeriodoValidez()) {
				PeriodType PeriodoValidez = new PeriodType();
				getPeriodo(periodos, PeriodoValidez);
				localizacion.getValidityPeriod().add(PeriodoValidez);
			}
		}

		return localizacion;
	}

	public AddressType getDireccion(TipoDireccion direccionPostal) {

		AddressType direccion = new AddressType();
		if (direccionPostal.getID() != null) {
			IDType id = new IDType();
			getIdentificador(direccionPostal.getID(), id);
			direccion.setID(id);
		}

		if (direccionPostal.getTipoCodigoDireccion() != null) {
			AddressTypeCodeType tipoCodigoDireccion = new AddressTypeCodeType();
			getCodigo(direccionPostal.getTipoCodigoDireccion(), tipoCodigoDireccion);
			direccion.setAddressTypeCode(tipoCodigoDireccion);
		}

		if (direccionPostal.getFormatoCodigoDireccion() != null) {
			AddressFormatCodeType formatoCodigoDireccion = new AddressFormatCodeType();
			getCodigo(direccionPostal.getFormatoCodigoDireccion(), formatoCodigoDireccion);
			direccion.setAddressFormatCode(formatoCodigoDireccion);
		}

		if (direccionPostal.getBuzon() != null) {
			PostboxType buzon = new PostboxType();
			getTexto(direccionPostal.getBuzon(), buzon);
			direccion.setPostbox(buzon);
		}

		if (direccionPostal.getPiso() != null) {
			FloorType piso = new FloorType();
			getTexto(direccionPostal.getPiso(), piso);
			direccion.setFloor(piso);
		}

		if (direccionPostal.getCuarto() != null) {
			RoomType cuarto = new RoomType();
			getTexto(direccionPostal.getCuarto(), cuarto);
			direccion.setRoom(cuarto);
		}

		if (direccionPostal.getNombreCalle() != null) {
			StreetNameType nombreCalle = new StreetNameType();
			getNombre(direccionPostal.getNombreCalle(), nombreCalle);
			direccion.setStreetName(nombreCalle);
		}

		if (direccionPostal.getNombreCalleAdicional() != null) {
			AdditionalStreetNameType nombreCalleAdicional = new AdditionalStreetNameType();
			getNombre(direccionPostal.getNombreCalleAdicional(), nombreCalleAdicional);
			direccion.setAdditionalStreetName(nombreCalleAdicional);
		}

		if (direccionPostal.getNombreBloque() != null) {
			BlockNameType nombreBloque = new BlockNameType();
			getNombre(direccionPostal.getNombreBloque(), nombreBloque);
			direccion.setBlockName(nombreBloque);
		}

		if (direccionPostal.getNombreEdificio() != null) {
			BuildingNameType nombreEdificio = new BuildingNameType();
			getNombre(direccionPostal.getNombreEdificio(), nombreEdificio);
			direccion.setBuildingName(nombreEdificio);
		}

		if (direccionPostal.getNumeroEdificio() != null) {
			BuildingNumberType numeroEdificio = new BuildingNumberType();
			getTexto(direccionPostal.getNumeroEdificio(), numeroEdificio);
			direccion.setBuildingNumber(numeroEdificio);
		}

		if (direccionPostal.getCorreoInterno() != null) {
			InhouseMailType correoInterno = new InhouseMailType();
			getTexto(direccionPostal.getCorreoInterno(), correoInterno);
			direccion.setInhouseMail(correoInterno);
		}

		if (direccionPostal.getDepartamento() != null) {
			DepartmentType departamento = new DepartmentType();
			getTexto(direccionPostal.getDepartamento(), departamento);
			direccion.setDepartment(departamento);
		}

		if (direccionPostal.getMarcaAtencion() != null) {
			MarkAttentionType marcaAtencion = new MarkAttentionType();
			getTexto(direccionPostal.getMarcaAtencion(), marcaAtencion);
			direccion.setMarkAttention(marcaAtencion);
		}

		if (direccionPostal.getMarcaCuidado() != null) {
			MarkCareType marcaCuidado = new MarkCareType();
			getTexto(direccionPostal.getMarcaCuidado(), marcaCuidado);
			direccion.setMarkCare(marcaCuidado);
		}

		if (direccionPostal.getIdentificacionParcela() != null) {
			PlotIdentificationType identificacionParcela = new PlotIdentificationType();
			getTexto(direccionPostal.getIdentificacionParcela(), identificacionParcela);
			direccion.setPlotIdentification(identificacionParcela);
		}

		if (direccionPostal.getNombreSubdivisionCiudad() != null) {
			CitySubdivisionNameType nombreSubdivisionCiudad = new CitySubdivisionNameType();
			getNombre(direccionPostal.getNombreSubdivisionCiudad(), nombreSubdivisionCiudad);
			direccion.setCitySubdivisionName(nombreSubdivisionCiudad);
		}

		if (direccionPostal.getNombreCiudad() != null) {
			CityNameType nombreCiudad = new CityNameType();
			getNombre(direccionPostal.getNombreCiudad(), nombreCiudad);
			direccion.setCityName(nombreCiudad);
		}

		if (direccionPostal.getZonaPostal() != null) {
			PostalZoneType zonaPostal = new PostalZoneType();
			getTexto(direccionPostal.getZonaPostal(), zonaPostal);
			direccion.setPostalZone(zonaPostal);
		}

		if (direccionPostal.getSubentidadPais() != null) {
			CountrySubentityType subentidadPais = new CountrySubentityType();
			getTexto(direccionPostal.getSubentidadPais(), subentidadPais);
			direccion.setCountrySubentity(subentidadPais);
		}

		if (direccionPostal.getCodigoSubentidadesPais() != null) {
			CountrySubentityCodeType codigoSubentidadesPais = new CountrySubentityCodeType();
			getCodigo(direccionPostal.getCodigoSubentidadesPais(), codigoSubentidadesPais);
			direccion.setCountrySubentityCode(codigoSubentidadesPais);
		}

		if (direccionPostal.getRegion() != null) {
			RegionType region = new RegionType();
			getTexto(direccionPostal.getRegion(), region);
			direccion.setRegion(region);
		}

		if (direccionPostal.getDistrito() != null) {
			DistrictType distrito = new DistrictType();
			getTexto(direccionPostal.getDistrito(), distrito);
			direccion.setDistrict(distrito);
		}

		if (direccionPostal.getZonaHorariaOffset() != null) {
			TimezoneOffsetType zonaHorariaOffset = new TimezoneOffsetType();
			getTexto(direccionPostal.getZonaHorariaOffset(), zonaHorariaOffset);
			direccion.setTimezoneOffset(zonaHorariaOffset);
		}

		if (!direccionPostal.getLineaDireccion().isEmpty() && direccionPostal.getLineaDireccion() != null) {
			for (TipoTexto Dir : direccionPostal.getLineaDireccion()) {
				AddressLineType lineaDireccion = new AddressLineType();
				LineType lineaDir = new LineType();
				lineaDir.setLanguageID(Dir.getIdIdioma());
				lineaDir.setValue(Dir.getValue());
				lineaDireccion.setLine(lineaDir);
				direccion.getAddressLine().add(lineaDireccion);
			}
		}

		if (direccionPostal.getPais() != null) {
			direccion.setCountry(getPais(direccionPostal.getPais()));
		}
		if (direccionPostal.getCoordenadasUbicacion() != null) {
			direccion.setLocationCoordinate(getCoordenadasUbicacion(direccionPostal.getCoordenadasUbicacion()));
		}

		return direccion;
	}

	public LocationCoordinateType getCoordenadasUbicacion(TipoCoordenadasUbicacion coordenadasUbicacion) {

		LocationCoordinateType coordenadas = new LocationCoordinateType();
		if (coordenadasUbicacion.getCodigoSistemaCoordenadas() != null) {
			CoordinateSystemCodeType codigoSistemaCoordenadas = new CoordinateSystemCodeType();
			getCodigo(coordenadasUbicacion.getCodigoSistemaCoordenadas(), codigoSistemaCoordenadas);
			coordenadas.setCoordinateSystemCode(codigoSistemaCoordenadas);
		}

		if (coordenadasUbicacion.getMedidaGradosLatitud() != null) {
			LatitudeDegreesMeasureType medidaGradosLatitud = new LatitudeDegreesMeasureType();
			getMedida(coordenadasUbicacion.getMedidaGradosLatitud(), medidaGradosLatitud);
			coordenadas.setLatitudeDegreesMeasure(medidaGradosLatitud);
		}

		if (coordenadasUbicacion.getCodigoDireccionLatitud() != null) {
			LatitudeDirectionCodeType codigoDireccionLatitud = new LatitudeDirectionCodeType();
			getCodigo(coordenadasUbicacion.getCodigoDireccionLatitud(), codigoDireccionLatitud);
			coordenadas.setLatitudeDirectionCode(codigoDireccionLatitud);
		}

		if (coordenadasUbicacion.getMedidaMinutosLatitud() != null) {
			LatitudeMinutesMeasureType medidaMinutosLatitud = new LatitudeMinutesMeasureType();
			getMedida(coordenadasUbicacion.getMedidaMinutosLatitud(), medidaMinutosLatitud);
			coordenadas.setLatitudeMinutesMeasure(medidaMinutosLatitud);
		}

		if (coordenadasUbicacion.getMedidaLongitudGrados() != null) {
			LongitudeDegreesMeasureType medidaLongitudGrados = new LongitudeDegreesMeasureType();
			getMedida(coordenadasUbicacion.getMedidaLongitudGrados(), medidaLongitudGrados);
			coordenadas.setLongitudeDegreesMeasure(medidaLongitudGrados);
		}

		if (coordenadasUbicacion.getCodigoLongitudDireccion() != null) {
			oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LongitudeDirectionCodeType codigoLongitudDireccion = new oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LongitudeDirectionCodeType();
			getMedida(coordenadasUbicacion.getCodigoLongitudDireccion(), codigoLongitudDireccion);
			coordenadas.setLongitudeDirectionCode(codigoLongitudDireccion);
		}

		if (coordenadasUbicacion.getMedidaLongitudMinutos() != null) {
			LongitudeMinutesMeasureType medidaLongitudMinutos = new LongitudeMinutesMeasureType();
			getMedida(coordenadasUbicacion.getMedidaLongitudMinutos(), medidaLongitudMinutos);
			coordenadas.setLongitudeMinutesMeasure(medidaLongitudMinutos);
		}

		return coordenadas;
	}

	public CountryType getPais(TipoPais pais) {

		CountryType p = new CountryType();
		if (pais.getCodigoIdentificacion() != null) {
			IdentificationCodeType codigo = new IdentificationCodeType();
			getIdentificacion(pais.getCodigoIdentificacion(), codigo);
			p.setIdentificationCode(codigo);
		}

		if (pais.getNombre() != null) {
			NameType nombre = new NameType();
			getNombre(pais.getNombre(), nombre);
			p.setName(nombre);
		}

		return p;
	}

	public co.gov.dian.contratos.facturaelectronica.v1.AddressType getDireccion2(TipoDireccion direccionPostal) {

		co.gov.dian.contratos.facturaelectronica.v1.AddressType direccion = new co.gov.dian.contratos.facturaelectronica.v1.AddressType();
		if (direccionPostal.getID() != null) {
			IDType id = new IDType();
			getIdentificador(direccionPostal.getID(), id);
			direccion.setID(id);
		}

		if (direccionPostal.getTipoCodigoDireccion() != null) {
			AddressTypeCodeType tipoCodigoDireccion = new AddressTypeCodeType();
			getCodigo(direccionPostal.getTipoCodigoDireccion(), tipoCodigoDireccion);
			direccion.setAddressTypeCode(tipoCodigoDireccion);
		}

		if (direccionPostal.getFormatoCodigoDireccion() != null) {
			AddressFormatCodeType formatoCodigoDireccion = new AddressFormatCodeType();
			getCodigo(direccionPostal.getFormatoCodigoDireccion(), formatoCodigoDireccion);
			direccion.setAddressFormatCode(formatoCodigoDireccion);
		}

		if (direccionPostal.getBuzon() != null) {
			PostboxType buzon = new PostboxType();
			getTexto(direccionPostal.getBuzon(), buzon);
			direccion.setPostbox(buzon);
		}

		if (direccionPostal.getPiso() != null) {
			FloorType piso = new FloorType();
			getTexto(direccionPostal.getPiso(), piso);
			direccion.setFloor(piso);
		}

		if (direccionPostal.getCuarto() != null) {
			RoomType cuarto = new RoomType();
			getTexto(direccionPostal.getCuarto(), cuarto);
			direccion.setRoom(cuarto);
		}

		if (direccionPostal.getNombreCalle() != null) {
			StreetNameType nombreCalle = new StreetNameType();
			getNombre(direccionPostal.getNombreCalle(), nombreCalle);
			direccion.setStreetName(nombreCalle);
		}

		if (direccionPostal.getNombreCalleAdicional() != null) {
			AdditionalStreetNameType nombreCalleAdicional = new AdditionalStreetNameType();
			getNombre(direccionPostal.getNombreCalleAdicional(), nombreCalleAdicional);
			direccion.setAdditionalStreetName(nombreCalleAdicional);
		}

		if (direccionPostal.getNombreBloque() != null) {
			BlockNameType nombreBloque = new BlockNameType();
			getNombre(direccionPostal.getNombreBloque(), nombreBloque);
			direccion.setBlockName(nombreBloque);
		}

		if (direccionPostal.getNombreEdificio() != null) {
			BuildingNameType nombreEdificio = new BuildingNameType();
			getNombre(direccionPostal.getNombreEdificio(), nombreEdificio);
			direccion.setBuildingName(nombreEdificio);
		}

		if (direccionPostal.getNumeroEdificio() != null) {
			BuildingNumberType numeroEdificio = new BuildingNumberType();
			getTexto(direccionPostal.getNumeroEdificio(), numeroEdificio);
			direccion.setBuildingNumber(numeroEdificio);
		}

		if (direccionPostal.getCorreoInterno() != null) {
			InhouseMailType correoInterno = new InhouseMailType();
			getTexto(direccionPostal.getCorreoInterno(), correoInterno);
			direccion.setInhouseMail(correoInterno);
		}

		if (direccionPostal.getDepartamento() != null) {
			DepartmentType departamento = new DepartmentType();
			getTexto(direccionPostal.getDepartamento(), departamento);
			direccion.setDepartment(departamento);
		}

		if (direccionPostal.getMarcaAtencion() != null) {
			MarkAttentionType marcaAtencion = new MarkAttentionType();
			getTexto(direccionPostal.getMarcaAtencion(), marcaAtencion);
			direccion.setMarkAttention(marcaAtencion);
		}

		if (direccionPostal.getMarcaCuidado() != null) {
			MarkCareType marcaCuidado = new MarkCareType();
			getTexto(direccionPostal.getMarcaCuidado(), marcaCuidado);
			direccion.setMarkCare(marcaCuidado);
		}

		if (direccionPostal.getIdentificacionParcela() != null) {
			PlotIdentificationType identificacionParcela = new PlotIdentificationType();
			getTexto(direccionPostal.getIdentificacionParcela(), identificacionParcela);
			direccion.setPlotIdentification(identificacionParcela);
		}

		if (direccionPostal.getNombreSubdivisionCiudad() != null) {
			CitySubdivisionNameType nombreSubdivisionCiudad = new CitySubdivisionNameType();
			getNombre(direccionPostal.getNombreSubdivisionCiudad(), nombreSubdivisionCiudad);
			direccion.setCitySubdivisionName(nombreSubdivisionCiudad);
		}

		if (direccionPostal.getNombreCiudad() != null) {
			CityNameType nombreCiudad = new CityNameType();
			getNombre(direccionPostal.getNombreCiudad(), nombreCiudad);
			direccion.setCityName(nombreCiudad);
		}

		if (direccionPostal.getZonaPostal() != null) {
			PostalZoneType zonaPostal = new PostalZoneType();
			getTexto(direccionPostal.getZonaPostal(), zonaPostal);
			direccion.setPostalZone(zonaPostal);
		}

		if (direccionPostal.getSubentidadPais() != null) {
			CountrySubentityType subentidadPais = new CountrySubentityType();
			getTexto(direccionPostal.getSubentidadPais(), subentidadPais);
			direccion.setCountrySubentity(subentidadPais);
		}

		if (direccionPostal.getCodigoSubentidadesPais() != null) {
			CountrySubentityCodeType codigoSubentidadesPais = new CountrySubentityCodeType();
			getCodigo(direccionPostal.getCodigoSubentidadesPais(), codigoSubentidadesPais);
			direccion.setCountrySubentityCode(codigoSubentidadesPais);
		}

		if (direccionPostal.getRegion() != null) {
			RegionType region = new RegionType();
			getTexto(direccionPostal.getRegion(), region);
			direccion.setRegion(region);
		}

		if (direccionPostal.getDistrito() != null) {
			DistrictType distrito = new DistrictType();
			getTexto(direccionPostal.getDistrito(), distrito);
			direccion.setDistrict(distrito);
		}

		if (direccionPostal.getZonaHorariaOffset() != null) {
			TimezoneOffsetType zonaHorariaOffset = new TimezoneOffsetType();
			getTexto(direccionPostal.getZonaHorariaOffset(), zonaHorariaOffset);
			direccion.setTimezoneOffset(zonaHorariaOffset);
		}

		if (!direccionPostal.getLineaDireccion().isEmpty() && direccionPostal.getLineaDireccion() != null) {
			for (TipoTexto Dir : direccionPostal.getLineaDireccion()) {
				AddressLineType lineaDireccion = new AddressLineType();
				LineType lineaDir = new LineType();
				lineaDir.setLanguageID(Dir.getIdIdioma());
				lineaDir.setValue(Dir.getValue());
				lineaDireccion.setLine(lineaDir);
				direccion.getAddressLine().add(lineaDireccion);
			}
		}

		if (direccionPostal.getPais() != null) {
			direccion.setCountry(getPais(direccionPostal.getPais()));

		}
		if (direccionPostal.getCoordenadasUbicacion() != null) {
			direccion.setLocationCoordinate(getCoordenadasUbicacion(direccionPostal.getCoordenadasUbicacion()));

		}

		return direccion;
	}

	public void getNombres(String nombre, PartyNameType nombreTercero) {
		if (valida.validateDate(nombre)) {
			NameType nombres = new NameType();
			getNombre(nombre, nombres);
			nombreTercero.setName(nombres);
		}

	}

	public void getNombre(String nombre,
			un.unece.uncefact.data.specification.unqualifieddatatypesschemamodule._2.NameType nombreTercero) {
		if (valida.validateDate(nombre)) {
			nombreTercero.setValue(nombre);
		}

	}

	public void getIdentificacion(TipoCodigo codigoIdentificacion, IdentificationCodeType codigo) {
		if (codigoIdentificacion != null) {
			getIdentificacion(codigoIdentificacion, codigo);
		}

	}

	public void getCantidad(BigDecimal cantidad, QuantityType cantidades) {
		if (valida.validateDate(cantidad)) {
			cantidades.setValue(cantidad);

		}

	}

	public void getCantidad(BigDecimal cantidad, MaximumQuantityType cantidades) {
		if (valida.validateDate(cantidad)) {
			cantidades.setValue(cantidad);

		}
	}

	public void getCantidad(BigDecimal cantidad, MinimumQuantityType cantidades) {
		if (valida.validateDate(cantidad)) {
			cantidades.setValue(cantidad);
		}
	}

	public DespatchType getDespacho(TipoEnvio tipoEnvio) {

		DespatchType despacho = new DespatchType();

		if (tipoEnvio.getID() != null) {
			IDType id = new IDType();
			getIdentificador(tipoEnvio.getID(), id);
			despacho.setID(id);
		}

		if (valida.validateDate(tipoEnvio.getFechaEnvioSolicitado())) {
			RequestedDespatchDateType fechaEnvioSolicitud = new RequestedDespatchDateType();
			fechaEnvioSolicitud.setValue(tipoEnvio.getFechaEnvioSolicitado());
			despacho.setRequestedDespatchDate(fechaEnvioSolicitud);
		}

		if (valida.validateDateHora(tipoEnvio.getHoraEnvioSolicitado() )) {
			RequestedDespatchTimeType horaEnvioSolicitud = new RequestedDespatchTimeType();
			horaEnvioSolicitud.setValue(tipoEnvio.getHoraEnvioSolicitado());
			despacho.setRequestedDespatchTime(horaEnvioSolicitud);
		}

		if (valida.validateDate(tipoEnvio.getFechaEstimadaEnvio())) {
			EstimatedDespatchDateType fechaEstimadaEnvio = new EstimatedDespatchDateType();
			fechaEstimadaEnvio.setValue(tipoEnvio.getFechaEstimadaEnvio());
			despacho.setEstimatedDespatchDate(fechaEstimadaEnvio);
		}

		if (valida.validateDateHora(tipoEnvio.getHoraEstimadaEnvio())) {
			EstimatedDespatchTimeType horaEstimadaEnvio = new EstimatedDespatchTimeType();
			horaEstimadaEnvio.setValue(tipoEnvio.getHoraEstimadaEnvio());
			despacho.setEstimatedDespatchTime(horaEstimadaEnvio);
		}

		if (valida.validateDate(tipoEnvio.getFechaActualEnvio())) {
			ActualDespatchDateType fechaActualEnvio = new ActualDespatchDateType();
			fechaActualEnvio.setValue(tipoEnvio.getFechaActualEnvio());
			despacho.setActualDespatchDate(fechaActualEnvio);
		}

		if (valida.validateDateHora(tipoEnvio.getHoraActualEnvio())) {
			ActualDespatchTimeType horaActualEnvio = new ActualDespatchTimeType();
			horaActualEnvio.setValue(tipoEnvio.getHoraActualEnvio());
			despacho.setActualDespatchTime(horaActualEnvio);
		}

		if (tipoEnvio.getDireccion() != null) {
			despacho.setDespatchAddress(getDireccion2(tipoEnvio.getDireccion()));

		}
		if (tipoEnvio.getTercero() != null) {
			despacho.setDespatchParty(getTerceroDIAN(tipoEnvio.getTercero()));

		}
		if (tipoEnvio.getContacto() != null) {
			despacho.setContact(getContacto(tipoEnvio.getContacto()));

		}

		return despacho;
	}

	public PartyType getTercero(TipoTercero terceroTipo) {

		PartyType tercero = new PartyType();

		if (terceroTipo.getTerceroAgencia() != null) {
			tercero.setAgentParty(getTercero(terceroTipo.getTerceroAgencia()));

		}
		if (terceroTipo.getContacto() != null) {
			tercero.setContact(getContacto(terceroTipo.getContacto()));

		}
		if (terceroTipo.getPuntoFinalID() != null) {
			EndpointIDType puntoFinalID = new EndpointIDType();
			getIdentificador(terceroTipo.getPuntoFinalID(), puntoFinalID);
			tercero.setEndpointID(puntoFinalID);
		}

		if (terceroTipo.getReferenciaLogotipoID() != null) {
			LogoReferenceIDType referenciaLogotipoID = new LogoReferenceIDType();
			getIdentificador(terceroTipo.getReferenciaLogotipoID(), referenciaLogotipoID);
			tercero.setLogoReferenceID(referenciaLogotipoID);
		}

		if (terceroTipo.isIndicadorMarcaAtencion() != null) {
			MarkAttentionIndicatorType indicadorMarcaAtencion = new MarkAttentionIndicatorType();
			indicadorMarcaAtencion.setValue(terceroTipo.isIndicadorMarcaAtencion());
			tercero.setMarkAttentionIndicator(indicadorMarcaAtencion);
		}

		if (terceroTipo.isIndicadorMarcaCuidado() != null) {
			MarkCareIndicatorType indicadorMarcaCuidado = new MarkCareIndicatorType();
			indicadorMarcaCuidado.setValue(terceroTipo.isIndicadorMarcaCuidado());
			tercero.setMarkCareIndicator(indicadorMarcaCuidado);

		}
		if (terceroTipo.getUbicacion() != null) {
			tercero.setPhysicalLocation(getUbicacionFisica2(terceroTipo.getUbicacion()));

		}
		if (terceroTipo.getDireccionPostal() != null) {
			tercero.setPostalAddress(getDireccion(terceroTipo.getDireccionPostal()));
		}
		if (terceroTipo.getSitioWebURI() != null) {
			WebsiteURIType sitioWeb = new WebsiteURIType();
			getIdentificador(terceroTipo.getSitioWebURI(), sitioWeb);
			tercero.setWebsiteURI(sitioWeb);
		}

		if (!terceroTipo.getEntidadLegalTercero().isEmpty() && terceroTipo.getEntidadLegalTercero() != null) {
			for (TipoEntidadLegalTercero entidad : terceroTipo.getEntidadLegalTercero()) {
				tercero.getPartyLegalEntity().add(getEntidadlegal2(entidad));
			}
		}

		if (!terceroTipo.getIdentificacionTercero().isEmpty() && terceroTipo.getIdentificacionTercero() != null) {
			for (TipoIdentificador identificacion : terceroTipo.getIdentificacionTercero()) {
				PartyIdentificationType id = new PartyIdentificationType();
				getIdentificadorTercero(identificacion, id);
				tercero.getPartyIdentification().add(id);
			}
		}

		if (!terceroTipo.getNombreTercero().isEmpty() && terceroTipo.getNombreTercero() != null) {
			for (String nombre : terceroTipo.getNombreTercero()) {
				PartyNameType nombreTercero = new PartyNameType();
				getNombres(nombre, nombreTercero);
				tercero.getPartyName().add(nombreTercero);
			}
		}

		if (!terceroTipo.getEsquemaImpuestosTercero().isEmpty() && terceroTipo.getEsquemaImpuestosTercero() != null) {
			for (TipoEsquemaImpuestosTercero esquemaImpuestos : terceroTipo.getEsquemaImpuestosTercero()) {
				tercero.getPartyTaxScheme().add(getEsquemaImpuestosTercero2(esquemaImpuestos));
			}
		}

		if (!terceroTipo.getPersona().isEmpty() && terceroTipo.getPersona() != null) {
			for (TipoPersona persona : terceroTipo.getPersona()) {
				tercero.setPerson(getPersona2(persona));
			}
		}

		return tercero;
	}

	private oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PersonType getPersona2(
			TipoPersona personas) {

		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PersonType persona = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PersonType();

		if (personas.getApellido() != null) {
			FamilyNameType apellidos = new FamilyNameType();
			getNombre(personas.getApellido(), apellidos);
			persona.setFamilyName(apellidos);
		}

		if (personas.getPrimerNombre() != null) {
			FirstNameType primerNombre = new FirstNameType();
			getNombre(personas.getPrimerNombre(), primerNombre);
			persona.setFirstName(primerNombre);
		}

		if (personas.getTituloProfesional() != null) {
			JobTitleType tituloProfesional = new JobTitleType();
			getTexto(personas.getTituloProfesional(), tituloProfesional);
			persona.setJobTitle(tituloProfesional);
		}

		if (personas.getSegundoNombre() != null) {
			MiddleNameType segundoNombre = new MiddleNameType();
			getNombre(personas.getSegundoNombre(), segundoNombre);
			persona.setMiddleName(segundoNombre);
		}

		if (personas.getSufijoNombre() != null) {
			NameSuffixType sufijoNombre = new NameSuffixType();
			getTexto(personas.getSufijoNombre(), sufijoNombre);
			persona.setNameSuffix(sufijoNombre);
		}

		if (personas.getDepartamentoOrganizacion() != null) {
			OrganizationDepartmentType departamentoOrganizacion = new OrganizationDepartmentType();
			getTexto(personas.getDepartamentoOrganizacion(), departamentoOrganizacion);
			persona.setOrganizationDepartment(departamentoOrganizacion);
		}

		if (personas.getTitulo() != null) {
			TitleType titulo = new TitleType();
			getTexto(personas.getTitulo(), titulo);
			persona.setTitle(titulo);
		}
		return persona;
	}

	private oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyTaxSchemeType getEsquemaImpuestosTercero2(
			TipoEsquemaImpuestosTercero esquemaImpuestos) {

		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyTaxSchemeType esquImpu = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyTaxSchemeType();
		if (esquemaImpuestos.getIDEmpresa() != null) {
			CompanyIDType IDEmpresa = new CompanyIDType();
			getIdentificador(esquemaImpuestos.getIDEmpresa(), IDEmpresa);
			esquImpu.setCompanyID(IDEmpresa);
		}

		if (esquemaImpuestos.getRazonExencion() != null) {
			ExemptionReasonType RazonExencion = new ExemptionReasonType();
			getTexto(esquemaImpuestos.getRazonExencion(), RazonExencion);
			esquImpu.setExemptionReason(RazonExencion);
		}

		if (esquemaImpuestos.getCodigoRazonExencion() != null) {
			ExemptionReasonCodeType CodigoRazonExencion = new ExemptionReasonCodeType();
			getCodigo(esquemaImpuestos.getCodigoRazonExencion(), CodigoRazonExencion);
			esquImpu.setExemptionReasonCode(CodigoRazonExencion);
		}

		if (esquemaImpuestos.getDireccionRegistro() != null) {
			esquImpu.setRegistrationAddress(getDireccion(esquemaImpuestos.getDireccionRegistro()));

		}
		if (esquemaImpuestos.getNombreRegistro() != null) {
			RegistrationNameType NombreRegistro = new RegistrationNameType();
			getNombre(esquemaImpuestos.getNombreRegistro(), NombreRegistro);
			esquImpu.setRegistrationName(NombreRegistro);
		}

		if (esquemaImpuestos.getCodigoNivelImpuestos() != null) {
			TaxLevelCodeType CodigoNivelImpuestos = new TaxLevelCodeType();
			getCodigo(esquemaImpuestos.getCodigoNivelImpuestos(), CodigoNivelImpuestos);
			esquImpu.setTaxLevelCode(CodigoNivelImpuestos);
		}

		if (esquemaImpuestos.getEsquemaImpuestos() != null) {
			esquImpu.setTaxScheme(getEsquemaImpuestos(esquemaImpuestos.getEsquemaImpuestos()));

		}

		return esquImpu;
	}

	private TaxSchemeType getEsquemaImpuestos(TipoRegimenTriburario esquemaImpuestos) {

		TaxSchemeType esquImpu = new TaxSchemeType();
		if (esquemaImpuestos.getCodigoDivisa() != null) {
			CurrencyCodeType codigoDivisa = new CurrencyCodeType();
			getCodigo(esquemaImpuestos.getCodigoDivisa(), codigoDivisa);
			esquImpu.setCurrencyCode(codigoDivisa);
		}

		if (esquemaImpuestos.getId() != null) {
			IDType id = new IDType();
			getIdentificador(esquemaImpuestos.getId(), id);
			esquImpu.setID(id);
		}

		if (esquemaImpuestos.getNombre() != null) {
			NameType nombre = new NameType();
			getNombre(esquemaImpuestos.getNombre(), nombre);
			esquImpu.setName(nombre);
		}

		if (esquemaImpuestos.getTipoCodigoImpuesto() != null) {
			TaxTypeCodeType tipoCodigoImpuesto = new TaxTypeCodeType();
			getCodigo(esquemaImpuestos.getTipoCodigoImpuesto(), tipoCodigoImpuesto);
			esquImpu.setTaxTypeCode(tipoCodigoImpuesto);
		}

		if (!esquemaImpuestos.getDireccionJurisdiccionRegional().isEmpty()
				&& esquemaImpuestos.getDireccionJurisdiccionRegional() != null) {
			for (TipoDireccion tipoDireccion : esquemaImpuestos.getDireccionJurisdiccionRegional()) {
				esquImpu.getJurisdictionRegionAddress().add(getDireccion(tipoDireccion));
			}
		}

		return esquImpu;
	}

	private oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyLegalEntityType getEntidadlegal2(
			TipoEntidadLegalTercero entidad) {

		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyLegalEntityType entidadLegal = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyLegalEntityType();
		if (entidad.getEsquemaRegistroCorporativo() != null) {
			entidadLegal.setCorporateRegistrationScheme(getschemaRegistrado(entidad.getEsquemaRegistroCorporativo()));

		}
		if (entidad.getDireccionRegistro() != null) {
			entidadLegal.setRegistrationAddress(getDireccion(entidad.getDireccionRegistro()));

		}
		if (entidad.getNombreRegistro() != null) {
			RegistrationNameType nombreRegistrado = new RegistrationNameType();
			getNombre(entidad.getNombreRegistro(), nombreRegistrado);
			entidadLegal.setRegistrationName(nombreRegistrado);
		}

		return entidadLegal;
	}

	private CorporateRegistrationSchemeType getschemaRegistrado(
			TipoEsquemaRegistroCorporativo esquemaRegistroCorporativo) {

		CorporateRegistrationSchemeType corporacion = new CorporateRegistrationSchemeType();
		if (esquemaRegistroCorporativo.getTipoCodigoRegistroCorporativo() != null) {
			CorporateRegistrationTypeCodeType tipoCodigoRegistroCorporativo = new CorporateRegistrationTypeCodeType();
			getCodigo(esquemaRegistroCorporativo.getTipoCodigoRegistroCorporativo(), tipoCodigoRegistroCorporativo);
			corporacion.setCorporateRegistrationTypeCode(tipoCodigoRegistroCorporativo);
		}

		if (esquemaRegistroCorporativo.getID() != null) {
			IDType id = new IDType();
			getIdentificador(esquemaRegistroCorporativo.getID(), id);
			corporacion.setID(id);
		}

		if (esquemaRegistroCorporativo.getNombre() != null) {
			NameType nombre = new NameType();
			getNombre(esquemaRegistroCorporativo.getNombre(), nombre);
			corporacion.setName(nombre);
		}

		if (!esquemaRegistroCorporativo.getDireccionRegionJurisdiccion().isEmpty()
				&& esquemaRegistroCorporativo.getDireccionRegionJurisdiccion() != null) {
			for (TipoDireccion direccion : esquemaRegistroCorporativo.getDireccionRegionJurisdiccion()) {
				corporacion.getJurisdictionRegionAddress().add(getDireccion(direccion));
			}
		}

		return corporacion;
	}

	public co.gov.dian.contratos.facturaelectronica.v1.PartyType getTerceroDIAN(TipoTercero terceroTipo) {

		co.gov.dian.contratos.facturaelectronica.v1.PartyType tercero = new co.gov.dian.contratos.facturaelectronica.v1.PartyType();

		if (terceroTipo.getTerceroAgencia() != null) {
			tercero.setAgentParty(getTercero(terceroTipo.getTerceroAgencia()));

		}

		if (terceroTipo.getContacto() != null) {
			tercero.setContact(getContacto(terceroTipo.getContacto()));

		}

		if (terceroTipo.getPuntoFinalID() != null) {
			EndpointIDType puntoFinalID = new EndpointIDType();
			getIdentificador(terceroTipo.getPuntoFinalID(), puntoFinalID);
			tercero.setEndpointID(puntoFinalID);
		}

		if (terceroTipo.getReferenciaLogotipoID() != null) {
			LogoReferenceIDType referenciaLogotipoID = new LogoReferenceIDType();
			getIdentificador(terceroTipo.getReferenciaLogotipoID(), referenciaLogotipoID);
			tercero.setLogoReferenceID(referenciaLogotipoID);
		}

		if (terceroTipo.isIndicadorMarcaAtencion() != null) {
			MarkAttentionIndicatorType indicadorMarcaAtencion = new MarkAttentionIndicatorType();
			indicadorMarcaAtencion.setValue(terceroTipo.isIndicadorMarcaAtencion());
			tercero.setMarkAttentionIndicator(indicadorMarcaAtencion);
		}

		if (terceroTipo.isIndicadorMarcaCuidado() != null) {
			MarkCareIndicatorType indicadorMarcaCuidado = new MarkCareIndicatorType();
			indicadorMarcaCuidado.setValue(terceroTipo.isIndicadorMarcaCuidado());
			tercero.setMarkCareIndicator(indicadorMarcaCuidado);
		}

		if (terceroTipo.getUbicacion() != null) {
			tercero.setPhysicalLocation(getUbicacionFisica(terceroTipo.getUbicacion()));

		}

		if (terceroTipo.getDireccionPostal() != null) {
			tercero.setPostalAddress(getDireccion(terceroTipo.getDireccionPostal()));

		}

		if (terceroTipo.getSitioWebURI() != null) {
			WebsiteURIType sitioWeb = new WebsiteURIType();
			getIdentificador(terceroTipo.getSitioWebURI(), sitioWeb);
			tercero.setWebsiteURI(sitioWeb);
		}

		if (!terceroTipo.getEntidadLegalTercero().isEmpty() && terceroTipo.getEntidadLegalTercero() != null) {
			for (TipoEntidadLegalTercero entidad : terceroTipo.getEntidadLegalTercero()) {
				tercero.getPartyLegalEntity().add(getEntidadlegal(entidad));
			}
		}

		if (!terceroTipo.getIdentificacionTercero().isEmpty() && terceroTipo.getIdentificacionTercero() != null) {
			for (TipoIdentificador identificacion : terceroTipo.getIdentificacionTercero()) {
				PartyIdentificationType id = new PartyIdentificationType();
				getIdentificadorTercero(identificacion, id);
				tercero.getPartyIdentification().add(id);
			}
		}

		if (!terceroTipo.getNombreTercero().isEmpty() && terceroTipo.getNombreTercero() != null) {
			for (String nombre : terceroTipo.getNombreTercero()) {

				PartyNameType nombreTercero = new PartyNameType();
				getNombres(nombre, nombreTercero);
				tercero.getPartyName().add(nombreTercero);
			}
		}

		if (!terceroTipo.getEsquemaImpuestosTercero().isEmpty() && terceroTipo.getEsquemaImpuestosTercero() != null) {
			for (TipoEsquemaImpuestosTercero esquemaImpuestos : terceroTipo.getEsquemaImpuestosTercero()) {
				tercero.getPartyTaxScheme().add(getEsquemaImpuestosTercero(esquemaImpuestos));
			}
		}

		if (!terceroTipo.getPersona().isEmpty() && terceroTipo.getPersona() != null) {
			for (TipoPersona persona : terceroTipo.getPersona()) {

				tercero.getPerson().add(getPersona(persona));
			}
		}

		return tercero;
	}

	private PersonType getPersona(TipoPersona persona) {

		PersonType personas = new PersonType();
		if (persona.getApellido() != null) {
			FamilyNameType apellido = new FamilyNameType();
			getNombre(persona.getApellido(), apellido);
			personas.setFamilyName(apellido);
		}

		if (persona.getPrimerNombre() != null) {
			FirstNameType primerNombre = new FirstNameType();
			getNombre(persona.getPrimerNombre(), primerNombre);
			personas.setFirstName(primerNombre);
		}

		if (persona.getTituloProfesional() != null) {
			JobTitleType tituloProfesional = new JobTitleType();
			getTexto(persona.getTituloProfesional(), tituloProfesional);
			personas.setJobTitle(tituloProfesional);
		}

		if (persona.getSegundoNombre() != null) {
			MiddleNameType segundoNombre = new MiddleNameType();
			getNombre(persona.getSegundoNombre(), segundoNombre);
			personas.setMiddleName(segundoNombre);
		}

		if (persona.getSufijoNombre() != null) {
			NameSuffixType sufijoNombre = new NameSuffixType();
			getTexto(persona.getSufijoNombre(), sufijoNombre);
			personas.setNameSuffix(sufijoNombre);
		}

		if (persona.getDepartamentoOrganizacion() != null) {
			OrganizationDepartmentType departamentoOrganizacion = new OrganizationDepartmentType();
			getTexto(persona.getDepartamentoOrganizacion(), departamentoOrganizacion);
			personas.setOrganizationDepartment(departamentoOrganizacion);
		}

		if (persona.getTitulo() != null) {
			TitleType titulo = new TitleType();
			getTexto(persona.getTitulo(), titulo);
			personas.setTitle(titulo);

		}

		return personas;

	}

	public oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DespatchType getDespacho2(
			TipoEnvio tipoEnvio) {
		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DespatchType despacho = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DespatchType();

		if (tipoEnvio.getID() != null) {
			IDType id = new IDType();
			getIdentificador(tipoEnvio.getID(), id);
			despacho.setID(id);
		}

		if (valida.validateDate(tipoEnvio.getFechaEnvioSolicitado())) {
			RequestedDespatchDateType fechaEnvioSolicitud = new RequestedDespatchDateType();
			fechaEnvioSolicitud.setValue(tipoEnvio.getFechaEnvioSolicitado());
			despacho.setRequestedDespatchDate(fechaEnvioSolicitud);
		}

		if (valida.validateDateHora(tipoEnvio.getHoraEnvioSolicitado())) {
			RequestedDespatchTimeType horaEnvioSolicitud = new RequestedDespatchTimeType();
			horaEnvioSolicitud.setValue(tipoEnvio.getHoraEnvioSolicitado());
			despacho.setRequestedDespatchTime(horaEnvioSolicitud);
		}

		if (valida.validateDate(tipoEnvio.getFechaEstimadaEnvio())) {
			EstimatedDespatchDateType fechaEstimadaEnvio = new EstimatedDespatchDateType();
			fechaEstimadaEnvio.setValue(tipoEnvio.getFechaEstimadaEnvio());
			despacho.setEstimatedDespatchDate(fechaEstimadaEnvio);
		}

		if (valida.validateDateHora(tipoEnvio.getHoraEstimadaEnvio())) {
			EstimatedDespatchTimeType horaEstimadaEnvio = new EstimatedDespatchTimeType();
			horaEstimadaEnvio.setValue(tipoEnvio.getHoraEstimadaEnvio());
			despacho.setEstimatedDespatchTime(horaEstimadaEnvio);
		}

		if (valida.validateDate(tipoEnvio.getFechaActualEnvio())) {
			ActualDespatchDateType fechaActualEnvio = new ActualDespatchDateType();
			fechaActualEnvio.setValue(tipoEnvio.getFechaActualEnvio());
			despacho.setActualDespatchDate(fechaActualEnvio);
		}

		if (valida.validateDateHora(tipoEnvio.getHoraActualEnvio())) {
			ActualDespatchTimeType horaActualEnvio = new ActualDespatchTimeType();
			horaActualEnvio.setValue(tipoEnvio.getHoraActualEnvio());
			despacho.setActualDespatchTime(horaActualEnvio);
		}

		if (tipoEnvio.getDireccion() != null) {
			despacho.setDespatchAddress(getDireccion(tipoEnvio.getDireccion()));

		}
		if (tipoEnvio.getTercero() != null) {
			despacho.setDespatchParty(getTercero(tipoEnvio.getTercero()));

		}
		if (tipoEnvio.getContacto() != null) {
			despacho.setContact(getContacto(tipoEnvio.getContacto()));

		}

		return despacho;
	}

	public CardAccountType getcuentaTarjeta(TipoCuentaTarjeta cuentaTarjeta) {

		CardAccountType tarjeta = new CardAccountType();
		if (cuentaTarjeta.getNumeroCuentaPrincipalID() != null) {
			PrimaryAccountNumberIDType numeroCuentaPrincipalID = new PrimaryAccountNumberIDType();
			getIdentificador(cuentaTarjeta.getNumeroCuentaPrincipalID(), numeroCuentaPrincipalID);
			tarjeta.setPrimaryAccountNumberID(numeroCuentaPrincipalID);
		}

		if (cuentaTarjeta.getRedID() != null) {
			NetworkIDType redID = new NetworkIDType();
			getIdentificador(cuentaTarjeta.getRedID(), redID);
			tarjeta.setNetworkID(redID);
		}

		if (cuentaTarjeta.getTipoCodigoTarjeta() != null) {
			CardTypeCodeType tipoCodigoTarjeta = new CardTypeCodeType();
			getCodigo(cuentaTarjeta.getTipoCodigoTarjeta(), tipoCodigoTarjeta);
			tarjeta.setCardTypeCode(tipoCodigoTarjeta);
		}

		if (valida.validateDate(cuentaTarjeta.getFechaInicialValidez())) {
			ValidityStartDateType fechaInicialValidez = new ValidityStartDateType();
			fechaInicialValidez.setValue(cuentaTarjeta.getFechaInicialValidez());
			tarjeta.setValidityStartDate(fechaInicialValidez);
		}

		if (valida.validateDate(cuentaTarjeta.getFechaCaducidad())) {
			ExpiryDateType fechaCaducidad = new ExpiryDateType();
			fechaCaducidad.setValue(cuentaTarjeta.getFechaCaducidad());
			tarjeta.setExpiryDate(fechaCaducidad);
		}

		if (cuentaTarjeta.getEmisorID() != null) {
			IssuerIDType emisorID = new IssuerIDType();
			getIdentificador(cuentaTarjeta.getEmisorID(), emisorID);
			tarjeta.setIssuerID(emisorID);
		}

		if (cuentaTarjeta.getNumeroEmisorID() != null) {
			IssueNumberIDType numeroEmisorID = new IssueNumberIDType();
			getIdentificador(cuentaTarjeta.getNumeroEmisorID(), numeroEmisorID);
			tarjeta.setIssueNumberID(numeroEmisorID);
		}

		if (cuentaTarjeta.getCV2ID() != null) {
			CV2IDType cV2ID = new CV2IDType();
			getIdentificador(cuentaTarjeta.getCV2ID(), cV2ID);
			tarjeta.setCV2ID(cV2ID);
		}

		if (cuentaTarjeta.getCodigoChipTarjeta() != null) {
			CardChipCodeType codigoChipTarjeta = new CardChipCodeType();
			getCodigo(cuentaTarjeta.getCodigoChipTarjeta(), codigoChipTarjeta);
			tarjeta.setCardChipCode(codigoChipTarjeta);
		}

		if (cuentaTarjeta.getChipAplicacionID() != null) {
			ChipApplicationIDType chipAplicacionID = new ChipApplicationIDType();
			getIdentificador(cuentaTarjeta.getChipAplicacionID(), chipAplicacionID);
			tarjeta.setChipApplicationID(chipAplicacionID);
		}

		if (cuentaTarjeta.getNombreTitular() != null) {
			HolderNameType nombreTitular = new HolderNameType();
			getNombre(cuentaTarjeta.getNombreTitular(), nombreTitular);
			tarjeta.setHolderName(nombreTitular);
		}

		return tarjeta;
	}

	public CreditAccountType getCuentaCredito(TipoIdentificador cuentaCredito) {

		CreditAccountType cuenta = new CreditAccountType();

		if (cuentaCredito != null) {
			AccountIDType valor = new AccountIDType();
			getIdentificador(cuentaCredito, valor);
			cuenta.setAccountID(valor);
		}

		return cuenta;

	}

	public FinancialAccountType getCuentaContribuyenteBeneficiario(TipoCuentaFinanciera cuentas) {

		FinancialAccountType cuenta = new FinancialAccountType();
		if (cuentas.getTipoCodigoCuenta() != null) {
			AccountTypeCodeType codigoCuenta = new AccountTypeCodeType();
			getCodigo(cuentas.getTipoCodigoCuenta(), codigoCuenta);
			cuenta.setAccountTypeCode(codigoCuenta);
		}

		if (cuentas.getPais() != null) {
			cuenta.setCountry(getPais(cuentas.getPais()));
		}

		if (cuentas.getCodigoMoneda() != null) {
			CurrencyCodeType codigoMoneda = new CurrencyCodeType();
			getCodigo(cuentas.getCodigoMoneda(), codigoMoneda);
			cuenta.setCurrencyCode(codigoMoneda);
		}

		if (cuentas.getSucursualInstitucionFinanciera() != null) {
			cuenta.setFinancialInstitutionBranch(
					getSucursualInstitucionFinanciera(cuentas.getSucursualInstitucionFinanciera()));
		}

		if (cuentas.getID() != null) {
			IDType id = new IDType();
			getIdentificador(cuentas.getID(), id);
			cuenta.setID(id);
		}

		if (cuentas.getNombre() != null) {
			NameType nombre = new NameType();
			getNombre(cuentas.getNombre(), nombre);
			cuenta.setName(nombre);
		}

		if (!cuentas.getNotaPago().isEmpty() && cuentas.getNotaPago() != null) {
			for (TipoTexto nota : cuentas.getNotaPago()) {
				PaymentNoteType notaPago = new PaymentNoteType();
				getTexto(nota, notaPago);
				cuenta.getPaymentNote().add(notaPago);
			}
		}

		return cuenta;
	}

	private BranchType getSucursualInstitucionFinanciera(TipoSucursal sucursualInstitucionFinanciera) {

		FinancialInstitutionType institucionFinanciera = new FinancialInstitutionType();
		BranchType sucursal = new BranchType();
		if (sucursualInstitucionFinanciera.getDireccion() != null) {

			sucursal.setAddress(getDireccion(sucursualInstitucionFinanciera.getDireccion()));

		}

		if (sucursualInstitucionFinanciera.getInstitucionFinanciera().getDireccion() != null) {

			institucionFinanciera
					.setAddress(getDireccion(sucursualInstitucionFinanciera.getInstitucionFinanciera().getDireccion()));

		}

		if (sucursualInstitucionFinanciera.getInstitucionFinanciera().getID() != null) {
			IDType id = new IDType();
			getIdentificador(sucursualInstitucionFinanciera.getInstitucionFinanciera().getID(), id);
			institucionFinanciera.setID(id);
		}

		if (sucursualInstitucionFinanciera.getInstitucionFinanciera().getNombre() != null) {
			NameType nombre = new NameType();
			getNombre(sucursualInstitucionFinanciera.getInstitucionFinanciera().getNombre(), nombre);
			institucionFinanciera.setName(nombre);
			sucursal.setFinancialInstitution(institucionFinanciera);
		}

		if (sucursualInstitucionFinanciera.getID() != null) {
			IDType id1 = new IDType();
			getIdentificador(sucursualInstitucionFinanciera.getID(), id1);
			sucursal.setID(id1);
		}

		if (sucursualInstitucionFinanciera.getNombre() != null) {
			NameType nombre1 = new NameType();
			getNombre(sucursualInstitucionFinanciera.getNombre(), nombre1);
			sucursal.setName(nombre1);
		}

		return sucursal;
	}

	public TaxTotalType getImpues(TipoImpuestoTotal impuestoTotal) {

		TaxTotalType total = new TaxTotalType();
		if (impuestoTotal.getMontoRedondeado() != null) {
			RoundingAmountType montoRedondeado = new RoundingAmountType();
			getMonto(impuestoTotal.getMontoRedondeado(), montoRedondeado);
			total.setRoundingAmount(montoRedondeado);
		}

		if (impuestoTotal.getMontoImpuesto() != null) {
			TaxAmountType montoImpuesto = new TaxAmountType();
			getMonto(impuestoTotal.getMontoImpuesto(), montoImpuesto);
			total.setTaxAmount(montoImpuesto);
		}

		TaxEvidenceIndicatorType indicadorEvidenciaImpuesto = new TaxEvidenceIndicatorType();
		indicadorEvidenciaImpuesto.setValue(impuestoTotal.isIndicadorEvidenciaImpuesto());
		total.setTaxEvidenceIndicator(indicadorEvidenciaImpuesto);

		if (!impuestoTotal.getSubtotalImpuesto().isEmpty() && impuestoTotal.getSubtotalImpuesto() != null) {
			for (TipoSubtotalImpuesto subTotal : impuestoTotal.getSubtotalImpuesto()) {
				total.getTaxSubtotal().add(getSubtotalImpuesto2(subTotal));
			}
		}

		return total;
	}

	public co.gov.dian.contratos.facturaelectronica.v1.TaxSubtotalType getSubtotalImpuesto(
			TipoSubtotalImpuesto impuesto) {

		co.gov.dian.contratos.facturaelectronica.v1.TaxSubtotalType subTotalImpuestos = new co.gov.dian.contratos.facturaelectronica.v1.TaxSubtotalType();
		if (impuesto.getBaseUnidadMedida() != null) {
			BaseUnitMeasureType baseUnidadMedida = new BaseUnitMeasureType();
			getMedida(impuesto.getBaseUnidadMedida(), baseUnidadMedida);
			subTotalImpuestos.setBaseUnitMeasure(baseUnidadMedida);
		}

		if (impuesto.getCalculoSecuenciaNumerica() != null) {
			CalculationSequenceNumericType calculoSecuenciaNumerica = new CalculationSequenceNumericType();
			calculoSecuenciaNumerica.setValue(impuesto.getCalculoSecuenciaNumerica());
			subTotalImpuestos.setCalculationSequenceNumeric(calculoSecuenciaNumerica);
		}

		if (impuesto.getPorcentaje() != null) {
			PercentType porcentaje = new PercentType();
			porcentaje.setValue(impuesto.getPorcentaje());
			subTotalImpuestos.setPercent(porcentaje);
		}

		if (impuesto.getMontoPorUnidad() != null) {
			PerUnitAmountType montoPorUnidad = new PerUnitAmountType();
			getMonto(impuesto.getMontoPorUnidad(), montoPorUnidad);
			subTotalImpuestos.setPerUnitAmount(montoPorUnidad);
		}

		if (impuesto.getMontoGravable() != null) {
			TaxableAmountType montoGravable = new TaxableAmountType();
			getMonto(impuesto.getMontoGravable(), montoGravable);
			subTotalImpuestos.setTaxableAmount(montoGravable);
		}

		if (impuesto.getMontoImpuesto() != null) {
			TaxAmountType montoImpuesto = new TaxAmountType();
			getMonto(impuesto.getMontoImpuesto(), montoImpuesto);
			subTotalImpuestos.setTaxAmount(montoImpuesto);
		}

		if (impuesto.getImpuestoCategoria() != null) {
			subTotalImpuestos.setTaxCategory(getImpuestoCategoria(impuesto.getImpuestoCategoria()));
		}

		if (impuesto.getNivelRango() != null) {
			TierRangeType nivelRango = new TierRangeType();
			getTexto(impuesto.getNivelRango(), nivelRango);
			subTotalImpuestos.setTierRange(nivelRango);
		}

		if (impuesto.getPorcentajeNivelRango() != null) {
			TierRatePercentType porcentajeNivelRango = new TierRatePercentType();
			porcentajeNivelRango.setValue(impuesto.getPorcentajeNivelRango());
			subTotalImpuestos.setTierRatePercent(porcentajeNivelRango);
		}

		if (impuesto.getMontoImpuestoMonedaTransaccion() != null) {
			TransactionCurrencyTaxAmountType montoImpuestoMonedaTransaccion = new TransactionCurrencyTaxAmountType();
			getMonto(impuesto.getMontoImpuestoMonedaTransaccion(), montoImpuestoMonedaTransaccion);
			subTotalImpuestos.setTransactionCurrencyTaxAmount(montoImpuestoMonedaTransaccion);
		}

		return subTotalImpuestos;
	}

	public void getMedida(BigDecimal baseUnidadMedida, BaseUnitMeasureType baseUnidadMedida2) {

		if (baseUnidadMedida != null) {
			baseUnidadMedida2.setValue(baseUnidadMedida);
		}
	}

	public TaxSubtotalType getSubtotalImpuesto2(TipoSubtotalImpuesto impuesto) {

		TaxSubtotalType subTotalImpuestos = new TaxSubtotalType();
		if (impuesto.getBaseUnidadMedida() != null) {
			BaseUnitMeasureType baseUnidadMedida = new BaseUnitMeasureType();
			getMedida(impuesto.getBaseUnidadMedida(), baseUnidadMedida);
			subTotalImpuestos.setBaseUnitMeasure(baseUnidadMedida);
		}

		if (impuesto.getCalculoSecuenciaNumerica() != null) {
			CalculationSequenceNumericType calculoSecuenciaNumerica = new CalculationSequenceNumericType();
			calculoSecuenciaNumerica.setValue(impuesto.getCalculoSecuenciaNumerica());
			subTotalImpuestos.setCalculationSequenceNumeric(calculoSecuenciaNumerica);
		}

		if (impuesto.getPorcentaje() != null) {
			PercentType porcentaje = new PercentType();
			porcentaje.setValue(impuesto.getPorcentaje());
			subTotalImpuestos.setPercent(porcentaje);
		}

		if (impuesto.getMontoPorUnidad() != null) {
			PerUnitAmountType montoPorUnidad = new PerUnitAmountType();
			getMonto(impuesto.getMontoPorUnidad(), montoPorUnidad);
			subTotalImpuestos.setPerUnitAmount(montoPorUnidad);
		}

		if (impuesto.getMontoGravable() != null) {
			TaxableAmountType montoGravable = new TaxableAmountType();
			getMonto(impuesto.getMontoGravable(), montoGravable);
			subTotalImpuestos.setTaxableAmount(montoGravable);
		}

		if (impuesto.getMontoImpuesto() != null) {
			TaxAmountType montoImpuesto = new TaxAmountType();
			getMonto(impuesto.getMontoImpuesto(), montoImpuesto);
			subTotalImpuestos.setTaxAmount(montoImpuesto);
		}

		if (impuesto.getImpuestoCategoria() != null) {
			subTotalImpuestos.setTaxCategory(getImpuestoCategoria(impuesto.getImpuestoCategoria()));

		}
		if (impuesto.getNivelRango() != null) {
			TierRangeType nivelRango = new TierRangeType();
			getTexto(impuesto.getNivelRango(), nivelRango);
			subTotalImpuestos.setTierRange(nivelRango);
		}

		if (impuesto.getPorcentajeNivelRango() != null) {
			TierRatePercentType porcentajeNivelRango = new TierRatePercentType();
			porcentajeNivelRango.setValue(impuesto.getPorcentajeNivelRango());
			subTotalImpuestos.setTierRatePercent(porcentajeNivelRango);
		}

		if (impuesto.getMontoImpuestoMonedaTransaccion() != null) {
			TransactionCurrencyTaxAmountType montoImpuestoMonedaTransaccion = new TransactionCurrencyTaxAmountType();
			getMonto(impuesto.getMontoImpuestoMonedaTransaccion(), montoImpuestoMonedaTransaccion);
			subTotalImpuestos.setTransactionCurrencyTaxAmount(montoImpuestoMonedaTransaccion);
		}

		return subTotalImpuestos;
	}

	public TaxCategoryType getImpuestoCategoria(TipoImpuestoCategoria impuestoCategoria) {

		TaxCategoryType categoriImpuesto = new TaxCategoryType();
		if (impuestoCategoria.getBaseUnidadMedida() != null) {
			BaseUnitMeasureType baseUnidadMedida = new BaseUnitMeasureType();
			getCantidadase(impuestoCategoria.getBaseUnidadMedida(), baseUnidadMedida);
			categoriImpuesto.setBaseUnitMeasure(baseUnidadMedida);
		}

		if (impuestoCategoria.getID() != null) {
			IDType id = new IDType();
			getIdentificador(impuestoCategoria.getID(), id);
			categoriImpuesto.setID(id);
		}

		if (impuestoCategoria.getNombre() != null) {
			NameType nombre = new NameType();
			getNombre(impuestoCategoria.getNombre(), nombre);
			categoriImpuesto.setName(nombre);
		}

		if (impuestoCategoria.getPorcentaje() != null) {
			PercentType porcentaje = new PercentType();
			porcentaje.setValue(impuestoCategoria.getPorcentaje());
			categoriImpuesto.setPercent(porcentaje);
		}

		if (impuestoCategoria.getMontoPorUnidad() != null) {
			PerUnitAmountType montoPorUnidad = new PerUnitAmountType();
			getMonto(impuestoCategoria.getMontoPorUnidad(), montoPorUnidad);
			categoriImpuesto.setPerUnitAmount(montoPorUnidad);
		}

		if (impuestoCategoria.getRazonExencionImpuestos() != null) {
			TaxExemptionReasonType razonExencionImpuestos = new TaxExemptionReasonType();
			getTexto(impuestoCategoria.getRazonExencionImpuestos(), razonExencionImpuestos);
			categoriImpuesto.setTaxExemptionReason(razonExencionImpuestos);
		}

		if (impuestoCategoria.getCodigoExencionImpuestos() != null) {
			TaxExemptionReasonCodeType codigoExencionImpuestos = new TaxExemptionReasonCodeType();
			getCodigo(impuestoCategoria.getCodigoExencionImpuestos(), codigoExencionImpuestos);
			categoriImpuesto.setTaxExemptionReasonCode(codigoExencionImpuestos);
		}

		if (impuestoCategoria.getNivelRango() != null) {
			categoriImpuesto.setTaxScheme(getRegimenTriburario(impuestoCategoria.getRegimenTriburario()));
			TierRangeType nivelRango = new TierRangeType();
			getTexto(impuestoCategoria.getNivelRango(), nivelRango);
			categoriImpuesto.setTierRange(nivelRango);
		}

		if (impuestoCategoria.getPorcentajeNivelRango() != null) {
			TierRatePercentType porcentajeNivelRango = new TierRatePercentType();
			porcentajeNivelRango.setValue(impuestoCategoria.getPorcentajeNivelRango());
			categoriImpuesto.setTierRatePercent(porcentajeNivelRango);
		}

		return categoriImpuesto;
	}

	private void getCantidadase(BigDecimal baseUnidadMedida, BaseUnitMeasureType baseUnidadMedida2) {
		if (baseUnidadMedida != null) {
			baseUnidadMedida2.setValue(baseUnidadMedida);
		}

	}

	private TaxSchemeType getRegimenTriburario(TipoRegimenTriburario regimenTriburario) {

		TaxSchemeType regimen = new TaxSchemeType();
		if (regimenTriburario.getCodigoDivisa() != null) {
			CurrencyCodeType codigoDivisa = new CurrencyCodeType();
			getCodigo(regimenTriburario.getCodigoDivisa(), codigoDivisa);
			regimen.setCurrencyCode(codigoDivisa);
		}

		if (regimenTriburario.getId() != null) {
			IDType id = new IDType();
			getIdentificador(regimenTriburario.getId(), id);
			regimen.setID(id);
		}

		if (regimenTriburario.getNombre() != null) {
			NameType nombre = new NameType();
			getNombre(regimenTriburario.getNombre(), nombre);
			regimen.setName(nombre);
		}

		if (regimenTriburario.getTipoCodigoImpuesto() != null) {
			TaxTypeCodeType tipoCodigoImpuesto = new TaxTypeCodeType();
			getCodigo(regimenTriburario.getTipoCodigoImpuesto(), tipoCodigoImpuesto);
			regimen.setTaxTypeCode(tipoCodigoImpuesto);
		}

		if (!regimenTriburario.getDireccionJurisdiccionRegional().isEmpty()
				&& regimenTriburario.getDireccionJurisdiccionRegional() != null) {
			for (TipoDireccion direccion : regimenTriburario.getDireccionJurisdiccionRegional()) {
				regimen.getJurisdictionRegionAddress().add(getDireccion(direccion));
			}
		}

		return regimen;
	}

	public void getMedioDePago(TipoMedioPago medPago, PaymentMeansType medioPago) {
		if (medPago.getId() != null) {
			IDType id = new IDType();
			getIdentificador(medPago.getId(), id);
			medioPago.setID(id);
		}

		if (medPago.getCodigoMedioPago() != null) {
			PaymentMeansCodeType codigoMedioPago = new PaymentMeansCodeType();
			getCodigo(medPago.getCodigoMedioPago(), codigoMedioPago);
			medioPago.setPaymentMeansCode(codigoMedioPago);
		}

		if (valida.validateDate(medPago.getFechaVencimientoPago())) {
			PaymentDueDateType fechaVencimientoPago = new PaymentDueDateType();
			fechaVencimientoPago.setValue(medPago.getFechaVencimientoPago());
			medioPago.setPaymentDueDate(fechaVencimientoPago);
		}

		if (medPago.getCodigoCanalPago() != null) {
			PaymentChannelCodeType codigoCanalDePago = new PaymentChannelCodeType();
			getCodigo(medPago.getCodigoCanalPago(), codigoCanalDePago);
			medioPago.setPaymentChannelCode(codigoCanalDePago);
		}

		if (medPago.getOrdenID() != null) {
			InstructionIDType ordenID = new InstructionIDType();
			getIdentificador(medPago.getOrdenID(), ordenID);
			medioPago.setInstructionID(ordenID);
		}

		if (!medPago.getNotaOrden().isEmpty() && medPago.getNotaOrden() != null) {
			for (TipoTexto nota : medPago.getNotaOrden()) {
				InstructionNoteType notaOrden = new InstructionNoteType();
				getTexto(nota, notaOrden);
				medioPago.getInstructionNote().add(notaOrden);
			}
		}

		if (!medPago.getIDPago().isEmpty() && medPago.getIDPago() != null) {
			for (TipoIdentificador idPago : medPago.getIDPago()) {
				PaymentIDType iDPago = new PaymentIDType();
				getIdentificador(idPago, iDPago);
				medioPago.getPaymentID().add(iDPago);
			}
		}

		if (medPago.getCuentaTarjeta() != null) {
			medioPago.setCardAccount(getcuentaTarjeta(medPago.getCuentaTarjeta()));
		}

		if (medPago.getCuentaContribuyenteBeneficiario() != null) {
			medioPago.setPayerFinancialAccount(
					getCuentaContribuyenteBeneficiario(medPago.getCuentaContribuyenteBeneficiario()));
		}

		if (medPago.getCuentaContribuyenteFinanciero() != null) {
			medioPago.setPayeeFinancialAccount(
					getCuentaContribuyenteBeneficiario(medPago.getCuentaContribuyenteFinanciero()));
		}

		if (medPago.getCuentaCredito() != null) {
			medioPago.setCreditAccount(getCuentaCredito(medPago.getCuentaCredito()));

		}
	}

	public void getCantidad(BigDecimal cantidadFactura, InvoicedQuantityType cantidadFactu) {
		if (cantidadFactura != null) {
			cantidadFactu.setValue(cantidadFactura);

		}
	}

	public OrderLineReferenceType getReferenciaLineaPedido(TipoReferenciaLineaPedido linea) {

		OrderLineReferenceType lineaReferencia = new OrderLineReferenceType();

		if (linea.getIDLinea() != null) {
			LineIDType iD = new LineIDType();
			getIdentificador(linea.getIDLinea(), iD);
			lineaReferencia.setLineID(iD);
		}

		if (linea.getLineaPedidoVentasID() != null) {
			SalesOrderLineIDType lineaPedidoVenta = new SalesOrderLineIDType();
			getIdentificador(linea.getLineaPedidoVentasID(), lineaPedidoVenta);
			lineaReferencia.setSalesOrderLineID(lineaPedidoVenta);
		}

		if (linea.getUUID() != null) {
			UUIDType uuid = new UUIDType();
			getIdentificador(linea.getUUID(), uuid);
			lineaReferencia.setUUID(uuid);
		}

		if (linea.getCodigoEstadoLinea() != null) {
			LineStatusCodeType codigoEstadoLinea = new LineStatusCodeType();
			getCodigo(linea.getCodigoEstadoLinea(), codigoEstadoLinea);
			lineaReferencia.setLineStatusCode(codigoEstadoLinea);
		}

		if (linea.getReferenciaPedido() != null) {
			lineaReferencia.setOrderReference(getReferenciaPedido(linea.getReferenciaPedido()));

		}

		return lineaReferencia;
	}

	private AttachmentType getArchivoAdjunto(TipoArchivoAdjunto archivoAdjunto) {

		AttachmentType archiAdj = new AttachmentType();
		if (archivoAdjunto.getObjetoBinario() != null) {
			EmbeddedDocumentBinaryObjectType binario = new EmbeddedDocumentBinaryObjectType();
			getObjetobinario(archivoAdjunto.getObjetoBinario(), binario);
			archiAdj.setEmbeddedDocumentBinaryObject(binario);
		}

		if (archivoAdjunto.getReferenciaExterna() != null) {
			archiAdj.setExternalReference(getReferenciaExterna(archivoAdjunto.getReferenciaExterna()));

		}

		return archiAdj;
	}

	private ExternalReferenceType getReferenciaExterna(TipoExternalReference referenciaExterna) {

		ExternalReferenceType refExterna = new ExternalReferenceType();
		if (referenciaExterna.getDocumentoHash() != null) {
			DocumentHashType documentHash = new DocumentHashType();
			getTexto(referenciaExterna.getDocumentoHash(), documentHash);
			refExterna.setDocumentHash(documentHash);
		}

		if (valida.validateDate(referenciaExterna.getFechaCaducidad())) {
			ExpiryDateType fechaExpiracion = new ExpiryDateType();
			fechaExpiracion.setValue(referenciaExterna.getFechaCaducidad());
			refExterna.setExpiryDate(fechaExpiracion);
		}

		if (referenciaExterna.getURI() != null) {
			URIType uri = new URIType();
			getIdentificador(referenciaExterna.getURI(), uri);
			refExterna.setURI(uri);
		}

		if (valida.validateDateHora(referenciaExterna.getHoraCaducidad())) {
			ExpiryTimeType horaExpiracion = new ExpiryTimeType();
			horaExpiracion.setValue(referenciaExterna.getHoraCaducidad());
			refExterna.setExpiryTime(horaExpiracion);
		}

		return refExterna;
	}

	private OrderReferenceType getReferenciaPedido(TipoReferenciaPedido referenciaPedido) {

		OrderReferenceType refePedi = new OrderReferenceType();
		if (referenciaPedido.isIndicadorCopia() != null) {
			CopyIndicatorType esCopia = new CopyIndicatorType();
			esCopia.setValue(referenciaPedido.isIndicadorCopia());
			refePedi.setCopyIndicator(esCopia);
		}

		if (referenciaPedido.getReferenciaCliente() != null) {
			CustomerReferenceType referenciaCliente = new CustomerReferenceType();
			getTexto(referenciaPedido.getReferenciaCliente(), referenciaCliente);
			refePedi.setCustomerReference(referenciaCliente);
		}

		if (referenciaPedido.getDocumentoreferencia() != null) {
			refePedi.setDocumentReference(getDocumentoReferencia(referenciaPedido.getDocumentoreferencia()));

		}
		if (referenciaPedido.getID() != null) {
			IDType id = new IDType();
			getIdentificador(referenciaPedido.getID(), id);
			refePedi.setID(id);
		}

		if (valida.validateDate(referenciaPedido.getFechaAsunto())) {
			IssueDateType fechaAsunto = new IssueDateType();
			fechaAsunto.setValue(referenciaPedido.getFechaAsunto());
			refePedi.setIssueDate(fechaAsunto);
		}

		if (referenciaPedido.getIdOrdenesVenta() != null) {
			SalesOrderIDType idOrdenDeVenta = new SalesOrderIDType();
			getIdentificador(referenciaPedido.getIdOrdenesVenta(), idOrdenDeVenta);
			refePedi.setSalesOrderID(idOrdenDeVenta);
		}

		if (valida.validateDateHora(referenciaPedido.getHoraAsunto())) {
			IssueTimeType horaAsunto = new IssueTimeType();
			horaAsunto.setValue(referenciaPedido.getHoraAsunto());
			refePedi.setIssueTime(horaAsunto);
		}

		return refePedi;
	}

	public OrderReferenceType getReferenciaPedidos(TipoReferenciaPedido referenciaPedido, TipoIdentificador CUFE) {

		OrderReferenceType refePedi = new OrderReferenceType();
		if (referenciaPedido.isIndicadorCopia() != null) {
			CopyIndicatorType esCopia = new CopyIndicatorType();
			esCopia.setValue(referenciaPedido.isIndicadorCopia());
			refePedi.setCopyIndicator(esCopia);
		}

		if (referenciaPedido.getReferenciaCliente() != null) {
			CustomerReferenceType referenciaCliente = new CustomerReferenceType();
			getTexto(referenciaPedido.getReferenciaCliente(), referenciaCliente);
			refePedi.setCustomerReference(referenciaCliente);
		}

		if (referenciaPedido.getDocumentoreferencia() != null) {
			refePedi.setDocumentReference(getDocumentoReferencia(referenciaPedido.getDocumentoreferencia()));

		}
		if (referenciaPedido.getID() != null) {
			IDType id = new IDType();
			getIdentificador(referenciaPedido.getID(), id);
			refePedi.setID(id);
		}

		if (valida.validateDate(referenciaPedido.getFechaAsunto())) {
			IssueDateType fechaAsunto = new IssueDateType();
			fechaAsunto.setValue(referenciaPedido.getFechaAsunto());
			refePedi.setIssueDate(fechaAsunto);
		}

		if (referenciaPedido.getIdOrdenesVenta() != null) {
			SalesOrderIDType idOrdenDeVenta = new SalesOrderIDType();
			getIdentificador(referenciaPedido.getIdOrdenesVenta(), idOrdenDeVenta);
			refePedi.setSalesOrderID(idOrdenDeVenta);
		}

		if (valida.validateDateHora(referenciaPedido.getHoraAsunto())) {
			IssueTimeType horaAsunto = new IssueTimeType();
			horaAsunto.setValue(referenciaPedido.getHoraAsunto());
			refePedi.setIssueTime(horaAsunto);
		}

		if (CUFE != null) {
			UUIDType cufe = new UUIDType();
			getIdentificador(CUFE, cufe);
			refePedi.setUUID(cufe);
		}

		return refePedi;
	}

	public DocumentReferenceType getDocumentoReferencia(TipoDocumentoReferencia documentoReferencia) {

		DocumentReferenceType docuRefe = new DocumentReferenceType();
		if (documentoReferencia.getArchivoAdjunto() != null) {
			docuRefe.setAttachment(getArchivoAdjunto(documentoReferencia.getArchivoAdjunto()));

		}
		if (documentoReferencia.isCopiaIndicador() != null) {
			CopyIndicatorType esCopia = new CopyIndicatorType();
			esCopia.setValue(documentoReferencia.isCopiaIndicador());
			docuRefe.setCopyIndicator(esCopia);
		}

		if (documentoReferencia.getTipoDocumento() != null) {
			DocumentTypeType documento = new DocumentTypeType();
			getTexto(documentoReferencia.getTipoDocumento(), documento);
			docuRefe.setDocumentType(documento);
		}

		if (documentoReferencia.getTipoCodigoDocumento() != null) {
			DocumentTypeCodeType codigoDocumento = new DocumentTypeCodeType();
			getCodigo(documentoReferencia.getTipoCodigoDocumento(), codigoDocumento);
			docuRefe.setDocumentTypeCode(codigoDocumento);
		}

		if (documentoReferencia.getID() != null) {
			IDType id = new IDType();
			getIdentificador(documentoReferencia.getID(), id);
			docuRefe.setID(id);
		}

		if (valida.validateDate(documentoReferencia.getFechaAsunto())) {
			IssueDateType fechaAsunto = new IssueDateType();
			fechaAsunto.setValue(documentoReferencia.getFechaAsunto());
			docuRefe.setIssueDate(fechaAsunto);
		}

		if (documentoReferencia.getUUID() != null) {
			UUIDType uid = new UUIDType();
			getIdentificador(documentoReferencia.getUUID(), uid);
			docuRefe.setUUID(uid);
		}

		if (!documentoReferencia.getXPath().isEmpty() && documentoReferencia.getXPath() != null) {
			for (TipoTexto xpath : documentoReferencia.getXPath()) {

				XPathType path = new XPathType();
				getTexto(xpath, path);
				docuRefe.getXPath().add(path);
			}
		}

		return docuRefe;
	}

	public LineReferenceType getLineaReferencia(TipoLineaReferencia lineaReferencia) {

		LineReferenceType referencia = new LineReferenceType();
		if (lineaReferencia.getDocumentoReferencia() != null) {
			referencia.setDocumentReference(getDocumentoReferencia(lineaReferencia.getDocumentoReferencia()));

		}
		if (lineaReferencia.getCodigoEstadoLinea() != null) {
			LineStatusCodeType codigoEstadoLinea = new LineStatusCodeType();
			getCodigo(lineaReferencia.getCodigoEstadoLinea(), codigoEstadoLinea);
			referencia.setLineStatusCode(codigoEstadoLinea);
		}

		if (lineaReferencia.getUUID() != null) {
			UUIDType uuid = new UUIDType();
			getIdentificador(lineaReferencia.getUUID(), uuid);
			referencia.setUUID(uuid);
		}

		if (lineaReferencia.getIDLinea() != null) {
			LineIDType iDLinea = new LineIDType();
			getIdentificador(lineaReferencia.getIDLinea(), iDLinea);
			referencia.setLineID(iDLinea);

		}

		return referencia;
	}

	public BillingReferenceType getReferenciaFactura(TipoReferenciaFactura referenciaFactura) {

		BillingReferenceType refeFact = new BillingReferenceType();
		if (referenciaFactura.getReferenciaDocumentoAdicional() != null) {
			refeFact.setAdditionalDocumentReference(
					getDocumentoReferencia(referenciaFactura.getReferenciaDocumentoAdicional()));
		}

		if (referenciaFactura.getReferenciaDocumentoNotaCredito() != null) {
			refeFact.setCreditNoteDocumentReference(
					getDocumentoReferencia(referenciaFactura.getReferenciaDocumentoNotaCredito()));
		}

		if (referenciaFactura.getReferenciaDocumentoNotaDebito() != null) {
			refeFact.setDebitNoteDocumentReference(
					getDocumentoReferencia(referenciaFactura.getReferenciaDocumentoNotaDebito()));
		}

		if (referenciaFactura.getReferenciaDocumentoFactura() != null) {
			refeFact.setInvoiceDocumentReference(
					getDocumentoReferencia(referenciaFactura.getReferenciaDocumentoFactura()));

		}
		if (referenciaFactura.getRecordatorioDocumentonameerencia() != null) {
			refeFact.setReminderDocumentReference(
					getDocumentoReferencia(referenciaFactura.getRecordatorioDocumentonameerencia()));
		}

		if (referenciaFactura.getReferenciaDocumentoNotaCreditoFacturada() != null) {
			refeFact.setSelfBilledCreditNoteDocumentReference(
					getDocumentoReferencia(referenciaFactura.getReferenciaDocumentoNotaCreditoFacturada()));
		}

		if (referenciaFactura.getReferenciaDocumentoFacturaAutoFacturada() != null) {
			refeFact.setSelfBilledInvoiceDocumentReference(
					getDocumentoReferencia(referenciaFactura.getReferenciaDocumentoFacturaAutoFacturada()));
		}

		if (!referenciaFactura.getLineaReferenciaFactura().isEmpty()
				&& referenciaFactura.getLineaReferenciaFactura() != null) {
			for (TipoReferenciaLineaFactura lineaReferencia : referenciaFactura.getLineaReferenciaFactura()) {

				refeFact.getBillingReferenceLine().add(getLineaReferencia(lineaReferencia));
			}
		}

		return refeFact;
	}

	private BillingReferenceLineType getLineaReferencia(TipoReferenciaLineaFactura lineaReferencia) {

		BillingReferenceLineType lineaRef = new BillingReferenceLineType();
		if (lineaReferencia.getMonto() != null) {
			AmountType monto = new AmountType();
			getMonto(lineaReferencia.getMonto(), monto);
			lineaRef.setAmount(monto);
		}

		if (lineaReferencia.getID() != null) {
			IDType id = new IDType();
			getIdentificador(lineaReferencia.getID(), id);
			lineaRef.setID(id);
		}

		if (!lineaReferencia.getCargo().isEmpty() && lineaReferencia.getCargo() != null) {
			for (TipoCargo cargo : lineaReferencia.getCargo()) {
				lineaRef.getAllowanceCharge().add(getCargos(cargo));
			}
		}

		return lineaRef;
	}

	public oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType getCargos(
			TipoCargo cargo) {
		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType c = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType();

		if (cargo.getCostoContable() != null) {
			AccountingCostType CostoContable = new AccountingCostType();
			getTexto(cargo.getCostoContable(), CostoContable);
			c.setAccountingCost(CostoContable);
		}

		if (cargo.getCodigoCostoContable() != null) {
			AccountingCostCodeType CodigoCostoContable = new AccountingCostCodeType();
			getCodigo(cargo.getCodigoCostoContable(), CodigoCostoContable);
			c.setAccountingCostCode(CodigoCostoContable);
		}

		if (cargo.getRazonAsignacionCargo() != null) {
			AllowanceChargeReasonType RazonAsignacionCargo = new AllowanceChargeReasonType();
			getTexto(cargo.getRazonAsignacionCargo(), RazonAsignacionCargo);
			c.setAllowanceChargeReason(RazonAsignacionCargo);
		}

		if (cargo.getCodigoRazonAsignacionCargo() != null) {
			AllowanceChargeReasonCodeType CodigoRazonAsignacionCargo = new AllowanceChargeReasonCodeType();
			getCodigo(cargo.getCodigoRazonAsignacionCargo(), CodigoRazonAsignacionCargo);
			c.setAllowanceChargeReasonCode(CodigoRazonAsignacionCargo);
		}

		if (cargo.getMonto() != null) {
			AmountType monto = new AmountType();
			getMonto(cargo.getMonto(), monto);
			c.setAmount(monto);
		}

		if (cargo.getMontoBase() != null) {
			BaseAmountType MontoBase = new BaseAmountType();
			getMonto(cargo.getMontoBase(), MontoBase);
			c.setBaseAmount(MontoBase);
		}

		ChargeIndicatorType IndicadorCarga = new ChargeIndicatorType();
		IndicadorCarga.setValue(cargo.isIndicadorCarga());
		c.setChargeIndicator(IndicadorCarga);

		if (cargo.getID() != null) {
			IDType id = new IDType();
			getIdentificador(cargo.getID(), id);
			c.setID(id);
		}

		if (cargo.getFactorNumericoMultiplicador() != null) {
			MultiplierFactorNumericType FactorNumericoMultiplicador = new MultiplierFactorNumericType();
			FactorNumericoMultiplicador.setValue(cargo.getFactorNumericoMultiplicador());
			c.setMultiplierFactorNumeric(FactorNumericoMultiplicador);
		}

		if (cargo.isIndicadorPagoAdelantado() != null) {
			PrepaidIndicatorType IndicadorPagoAdelantado = new PrepaidIndicatorType();
			IndicadorPagoAdelantado.setValue(cargo.isIndicadorPagoAdelantado());
			c.setPrepaidIndicator(IndicadorPagoAdelantado);
		}

		if (cargo.getSecuenciaNumerica() != null) {
			SequenceNumericType SecuenciaNumerica = new SequenceNumericType();
			SecuenciaNumerica.setValue(cargo.getSecuenciaNumerica());
			c.setSequenceNumeric(SecuenciaNumerica);
		}

		if (cargo.getImpuestoTotal() != null) {
			c.setTaxTotal(getImpues(cargo.getImpuestoTotal()));

		}
		if (!cargo.getMedioPago().isEmpty() && cargo.getMedioPago() != null) {
			for (TipoMedioPago medioPago : cargo.getMedioPago()) {
				PaymentMeansType MedioPago = new PaymentMeansType();
				getMedioDePago(medioPago, MedioPago);
				c.getPaymentMeans().add(MedioPago);
			}
		}

		if (!cargo.getCategoriaImpuesto().isEmpty() && cargo.getCategoriaImpuesto() != null) {
			for (TipoImpuestoCategoria impuestos : cargo.getCategoriaImpuesto()) {
				c.getTaxCategory().add(getImpuestoCategoria(impuestos));
			}
		}

		return c;
	}

	public PricingReferenceType getReferenciaPrecios(TipoReferenciaPrecios referenciaPrecios) {

		PricingReferenceType referenciaPrecio = new PricingReferenceType();

		if (referenciaPrecios.getCantidadOriginalUbicacionArticulo() != null) {
			referenciaPrecio.setOriginalItemLocationQuantity(
					getCantidadOriginalArticulo(referenciaPrecios.getCantidadOriginalUbicacionArticulo()));
		}

		if (!referenciaPrecios.getPrecioAlternativoCondicion().isEmpty()
				&& referenciaPrecios.getPrecioAlternativoCondicion() != null) {
			for (TipoPrecio PrecioAlternativoCondicion : referenciaPrecios.getPrecioAlternativoCondicion()) {
				referenciaPrecio.getAlternativeConditionPrice().add(getPrecio2(PrecioAlternativoCondicion));

			}
		}

		return referenciaPrecio;
	}

	public co.gov.dian.contratos.facturaelectronica.v1.PriceType getPrecio(TipoPrecio precios) {

		co.gov.dian.contratos.facturaelectronica.v1.PriceType precio = new co.gov.dian.contratos.facturaelectronica.v1.PriceType();
		if (precios.getCantidadBase() != null) {
			BaseQuantityType cantidadBase = new BaseQuantityType();
			getCantidad(precios.getCantidadBase(), cantidadBase);
			precio.setBaseQuantity(cantidadBase);
		}

		if (precios.getPrecioFactorUnidad() != null) {
			OrderableUnitFactorRateType precioFactorUnidad = new OrderableUnitFactorRateType();
			precioFactorUnidad.setValue(precios.getPrecioFactorUnidad());
			precio.setOrderableUnitFactorRate(precioFactorUnidad);
		}

		if (precios.getPrecioMonto() != null) {
			PriceAmountType precioMonto = new PriceAmountType();
			getMonto(precios.getPrecioMonto(), precioMonto);
			precio.setPriceAmount(precioMonto);
		}

		if (precios.getListaPrecios() != null) {
			precio.setPriceList(getListaPrecios(precios.getListaPrecios()));

		}
		if (precios.getTipoPrecio() != null) {
			precio.setPriceType(getTipoPrecio(precios.getTipoPrecio()));

		}
		if (precios.getTipoCodigoPrecio() != null) {
			PriceTypeCodeType tipoCodigoPrecio = new PriceTypeCodeType();
			getCodigo(precios.getTipoCodigoPrecio(), tipoCodigoPrecio);
			precio.setPriceTypeCode(tipoCodigoPrecio);
		}

		if (!precios.getCargo().isEmpty() && precios.getCargo() != null) {
			for (TipoCargo cargo : precios.getCargo()) {
				precio.getAllowanceCharge().add(getCargos(cargo));
			}
		}

		if (!precios.getRazonCambioPreio().isEmpty() && precios.getRazonCambioPreio() != null) {
			for (TipoTexto razoncambio : precios.getRazonCambioPreio()) {
				PriceChangeReasonType razonCambioPreio = new PriceChangeReasonType();
				getTexto(razoncambio, razonCambioPreio);
				precio.getPriceChangeReason().add(razonCambioPreio);
			}
		}

		if (!precios.getPeriodoValidez().isEmpty() && precios.getPeriodoValidez() != null) {
			for (TipoPeriodo periodo : precios.getPeriodoValidez()) {
				PeriodType periodoValidez = new PeriodType();
				getPeriodo(periodo, periodoValidez);
				precio.getValidityPeriod().add(periodoValidez);
			}
		}

		return precio;
	}

	public PriceType getPrecio2(TipoPrecio precios) {

		PriceType precio = new PriceType();
		if (precios.getCantidadBase() != null) {
			BaseQuantityType cantidadBase = new BaseQuantityType();
			getCantidad(precios.getCantidadBase(), cantidadBase);
			precio.setBaseQuantity(cantidadBase);
		}

		if (precios.getPrecioFactorUnidad() != null) {
			OrderableUnitFactorRateType precioFactorUnidad = new OrderableUnitFactorRateType();
			precioFactorUnidad.setValue(precios.getPrecioFactorUnidad());
			precio.setOrderableUnitFactorRate(precioFactorUnidad);
		}

		if (precios.getPrecioMonto() != null) {
			PriceAmountType precioMonto = new PriceAmountType();
			getMonto(precios.getPrecioMonto(), precioMonto);
			precio.setPriceAmount(precioMonto);
		}

		if (precios.getListaPrecios() != null) {
			precio.setPriceList(getListaPrecios(precios.getListaPrecios()));

		}
		if (precios.getTipoPrecio() != null) {
			precio.setPriceType(getTipoPrecio(precios.getTipoPrecio()));

		}
		if (precios.getTipoCodigoPrecio() != null) {
			PriceTypeCodeType tipoCodigoPrecio = new PriceTypeCodeType();
			getCodigo(precios.getTipoCodigoPrecio(), tipoCodigoPrecio);
			precio.setPriceTypeCode(tipoCodigoPrecio);
		}

		if (!precios.getCargo().isEmpty() && precios.getCargo() != null) {
			for (TipoCargo cargo : precios.getCargo()) {
				precio.getAllowanceCharge().add(getCargos(cargo));
			}
		}

		if (!precios.getRazonCambioPreio().isEmpty() && precios.getRazonCambioPreio() != null) {
			for (TipoTexto razoncambio : precios.getRazonCambioPreio()) {
				PriceChangeReasonType razonCambioPreio = new PriceChangeReasonType();
				getTexto(razoncambio, razonCambioPreio);
				precio.getPriceChangeReason().add(razonCambioPreio);
			}
		}

		if (!precios.getPeriodoValidez().isEmpty() && precios.getPeriodoValidez() != null) {
			for (TipoPeriodo periodo : precios.getPeriodoValidez()) {
				PeriodType periodoValidez = new PeriodType();
				getPeriodo(periodo, periodoValidez);
				precio.getValidityPeriod().add(periodoValidez);
			}
		}

		return precio;
	}

	private ItemLocationQuantityType getCantidadOriginalArticulo(TipoUbicacionCantidadArticulo c) {

		ItemLocationQuantityType cantidad = new ItemLocationQuantityType();
		if (c.isIndicadorRiesgo() != null) {
			HazardousRiskIndicatorType indicadorRiesgo = new HazardousRiskIndicatorType();
			indicadorRiesgo.setValue(c.isIndicadorRiesgo());
			cantidad.setHazardousRiskIndicator(indicadorRiesgo);
		}

		if (c.getMedidaPlazoEntrega() != null) {
			LeadTimeMeasureType medidaPlazoEntrega = new LeadTimeMeasureType();
			getMedida(c.getMedidaPlazoEntrega(), medidaPlazoEntrega);
			cantidad.setLeadTimeMeasure(medidaPlazoEntrega);
		}

		if (c.getCantidadMaxima() != null) {
			MaximumQuantityType cantidadMaxima = new MaximumQuantityType();
			getCantidad(c.getCantidadMaxima(), cantidadMaxima);
			cantidad.setMaximumQuantity(cantidadMaxima);
		}

		if (c.getCantidadMinima() != null) {
			MinimumQuantityType cantidadMinima = new MinimumQuantityType();
			getCantidad(c.getCantidadMinima(), cantidadMinima);
			cantidad.setMinimumQuantity(cantidadMinima);
		}

		if (c.getPrecio() != null) {
			cantidad.setPrice(getPrecio2(c.getPrecio()));

		}

		if (!c.getCategoriaImpuestoAplicable().isEmpty() && c.getCategoriaImpuestoAplicable() != null) {
			for (TipoImpuestoCategoria ci : c.getCategoriaImpuestoAplicable()) {
				cantidad.getApplicableTaxCategory().add(getImpuestoCategoria(ci));
			}
		}

		if (!c.getUnidadEntrega().isEmpty() && c.getUnidadEntrega() != null) {
			for (TipoUnidadEntrega unidadEnt : c.getUnidadEntrega()) {
				cantidad.getDeliveryUnit().add(getUnidadEntrega(unidadEnt));
			}
		}

		if (!c.getRestringcionesComerciales().isEmpty() && c.getRestringcionesComerciales() != null) {
			for (TipoTexto restricciones : c.getRestringcionesComerciales()) {
				TradingRestrictionsType restringcionesComerciales = new TradingRestrictionsType();
				getTexto(restricciones, restringcionesComerciales);
				cantidad.getTradingRestrictions().add(restringcionesComerciales);
			}
		}

		if (!c.getDireccionTerritorioAplicable().isEmpty() && c.getDireccionTerritorioAplicable() != null) {
			for (TipoDireccion dirTerrAplic : c.getDireccionTerritorioAplicable()) {
				cantidad.getApplicableTerritoryAddress().add(getDireccion(dirTerrAplic));
			}
		}

		return cantidad;
	}

	private DeliveryUnitType getUnidadEntrega(TipoUnidadEntrega unidadEnt) {

		DeliveryUnitType unidadDeEntrega = new DeliveryUnitType();

		if (unidadEnt.getCantidadLote() != null) {
			BatchQuantityType cantidadLote = new BatchQuantityType();
			getCantidad(unidadEnt.getCantidadLote(), cantidadLote);
			unidadDeEntrega.setBatchQuantity(cantidadLote);
		}

		if (unidadEnt.getCantidadUnidadConsumo() != null) {
			ConsumerUnitQuantityType cantidadUnidadConsumo = new ConsumerUnitQuantityType();
			getCantidad(unidadEnt.getCantidadUnidadConsumo(), cantidadUnidadConsumo);
			unidadDeEntrega.setConsumerUnitQuantity(cantidadUnidadConsumo);
		}

		if (unidadEnt.isIndicadorRiesgo() != null) {
			HazardousRiskIndicatorType indicadorRiesgo = new HazardousRiskIndicatorType();
			indicadorRiesgo.setValue(unidadEnt.isIndicadorRiesgo());
			unidadDeEntrega.setHazardousRiskIndicator(indicadorRiesgo);
		}

		return unidadDeEntrega;
	}

	private void getCantidad(BigDecimal cantidadUnidadConsumo, ConsumerUnitQuantityType cantidadConsumo) {
		if (valida.validateDate(cantidadUnidadConsumo)) {
			cantidadConsumo.setValue(cantidadUnidadConsumo);

		}

	}

	private void getCantidad(BigDecimal cantidadLote, BatchQuantityType cantidadLote2) {
		if (valida.validateDate(cantidadLote)) {
			cantidadLote2.setValue(cantidadLote);

		}

	}

	private void getMedida(BigDecimal medidaPlazoEntrega, LeadTimeMeasureType medidaPlazoEntrega2) {
		if (valida.validateDate(medidaPlazoEntrega)) {
			medidaPlazoEntrega2.setValue(medidaPlazoEntrega);

		}

	}

	public void getCantidad(BigDecimal cantidadBase, BaseQuantityType cantidadBase2) {
		if (valida.validateDate(cantidadBase)) {
			cantidadBase2.setValue(cantidadBase);

		}

	}

	private PriceListType getListaPrecios(TipoListaPrecios listaPrecios) {

		PriceListType lista = new PriceListType();

		if (listaPrecios.getID() != null) {
			IDType id = new IDType();
			getIdentificador(listaPrecios.getID(), id);
			lista.setID(id);
		}

		if (listaPrecios.getListaPreciosPrevia() != null) {
			lista.setPreviousPriceList(getListaPrecios(listaPrecios.getListaPreciosPrevia()));

		}

		if (listaPrecios.getCodigoEstado() != null) {
			StatusCodeType codigoDeEstado = new StatusCodeType();
			getCodigo(listaPrecios.getCodigoEstado(), codigoDeEstado);
			lista.setStatusCode(codigoDeEstado);
		}

		return lista;
	}

	private PriceTypeType getTipoPrecio(TipoTexto tipoPrecio) {

		PriceTypeType precio = new PriceTypeType();
		if (tipoPrecio.getIdIdioma() != null) {
			precio.setLanguageID(tipoPrecio.getIdIdioma());
		}

		if (tipoPrecio.getValue() != null) {
			precio.setValue(tipoPrecio.getValue());

		}

		return precio;
	}

	public ItemIdentificationType getIdentificacionArticulos(TipoIdentificacionArticulos iden) {

		ItemIdentificationType idItem = new ItemIdentificationType();
		if (iden.getIDProrroga() != null) {
			ExtendedIDType idExtendido = new ExtendedIDType();
			getIdentificador(iden.getIDProrroga(), idExtendido);
			idItem.setExtendedID(idExtendido);
		}

		if (iden.getId() != null) {
			IDType id = new IDType();
			getIdentificador(iden.getId(), id);
			idItem.setID(id);
		}

		if (iden.getTerceroEmisor() != null) {
			idItem.setIssuerParty(getTercero(iden.getTerceroEmisor()));

		}
		if (!iden.getDimensionMedida().isEmpty() && iden.getDimensionMedida() != null) {
			for (TipoDimension medida : iden.getDimensionMedida()) {
				DimensionType medidas = new DimensionType();
				getMedida(medida, medidas);
				idItem.getMeasurementDimension().add(medidas);
			}
		}

		if (!iden.getAtriburoFisico().isEmpty() && iden.getAtriburoFisico() != null) {
			for (TipoAtriburoFisico atr : iden.getAtriburoFisico()) {

				idItem.getPhysicalAttribute().add(getAtributos(atr));
			}

		}

		return idItem;
	}

	private PhysicalAttributeType getAtributos(TipoAtriburoFisico atr) {

		PhysicalAttributeType atributos = new PhysicalAttributeType();
		if (atr.getIDAtriburo() != null) {
			AttributeIDType id = new AttributeIDType();
			getIdentificador(atr.getIDAtriburo(), id);
			atributos.setAttributeID(id);
		}

		if (atr.getCodigoDescripcion() != null) {
			DescriptionCodeType codigoDescripcion = new DescriptionCodeType();
			getCodigo(atr.getCodigoDescripcion(), codigoDescripcion);
			atributos.setDescriptionCode(codigoDescripcion);
		}

		if (atr.getCodigoPosision() != null) {
			PositionCodeType codigoPosicion = new PositionCodeType();
			getCodigo(atr.getCodigoPosision(), codigoPosicion);
			atributos.setPositionCode(codigoPosicion);
		}

		if (!atr.getDescripcion().isEmpty() && atr.getDescripcion() != null) {
			for (TipoTexto descr : atr.getDescripcion()) {

				DescriptionType descripcion = new DescriptionType();
				getTexto(descr, descripcion);
				atributos.getDescription().add(descripcion);
			}
		}

		return atributos;
	}

	private void getMedida(TipoDimension medida, DimensionType medidas) {

		if (medida.getIDAtriburo() != null) {
			AttributeIDType id = new AttributeIDType();
			getIdentificador(medida.getIDAtriburo(), id);
			medidas.setAttributeID(id);
		}

		if (medida.getMedidaMaxima() != null) {
			MaximumMeasureType medidaMaxima = new MaximumMeasureType();
			getMedida(medida.getMedidaMaxima(), medidaMaxima);
			medidas.setMaximumMeasure(medidaMaxima);
		}

		if (medida.getMedida() != null) {
			MeasureType medidaValor = new MeasureType();
			getMedida(medida.getMedida(), medidaValor);
			medidas.setMeasure(medidaValor);
		}

		if (medida.getMedidaMinima() != null) {
			MinimumMeasureType medidaMinima = new MinimumMeasureType();
			getMedida(medida.getMedidaMinima(), medidaMinima);
			medidas.setMinimumMeasure(medidaMinima);

		}

	}

	private void getMedida(BigDecimal medidaMin, MinimumMeasureType medidaMinima) {
		if (valida.validateDate(medidaMin)) {
			medidaMinima.setValue(medidaMin);
		}

	}

	private void getMedida(BigDecimal medida, MeasureType medidaValor) {
		if (valida.validateDate(medida)) {
			medidaValor.setValue(medida);
		}

	}

	private void getMedida(BigDecimal medidaMax, MaximumMeasureType medidaMaxima) {
		if (valida.validateDate(medidaMax)) {
			medidaMaxima.setValue(medidaMax);

		}

	}

	public CommodityClassificationType getClasificacionMercancia(TipoClasificacionMercancia mercancia) {

		CommodityClassificationType clasificacion = new CommodityClassificationType();

		if (mercancia.getTipoCodigoCargo() != null) {
			CargoTypeCodeType tipoCodigoCargo = new CargoTypeCodeType();
			getCodigo(mercancia.getTipoCodigoCargo(), tipoCodigoCargo);
			clasificacion.setCargoTypeCode(tipoCodigoCargo);
		}

		if (mercancia.getCodigoMercancia() != null) {
			CommodityCodeType codigoMercancia = new CommodityCodeType();
			getCodigo(mercancia.getCodigoMercancia(), codigoMercancia);
			clasificacion.setCommodityCode(codigoMercancia);
		}

		if (mercancia.getCodigoClasificacionArticulo() != null) {
			ItemClassificationCodeType codigoClasificacionArticulo = new ItemClassificationCodeType();
			getCodigo(mercancia.getCodigoClasificacionArticulo(), codigoClasificacionArticulo);
			clasificacion.setItemClassificationCode(codigoClasificacionArticulo);
		}

		if (mercancia.getCodigoNatural() != null) {
			NatureCodeType codigoNatural = new NatureCodeType();
			getCodigo(mercancia.getCodigoNatural(), codigoNatural);
			clasificacion.setNatureCode(codigoNatural);
		}

		return clasificacion;
	}

	public TransactionConditionsType getCondicionesTransaccion(TipoCondicionesTransaccion tran) {

		TransactionConditionsType transaccion = new TransactionConditionsType();
		if (tran.getCodigoAccion() != null) {
			ActionCodeType codigoAccion = new ActionCodeType();
			getCodigo(tran.getCodigoAccion(), codigoAccion);
			transaccion.setActionCode(codigoAccion);
		}

		if (tran.getID() != null) {
			IDType id = new IDType();
			getIdentificador(tran.getID(), id);
			transaccion.setID(id);
		}

		if (!tran.getDescripcion().isEmpty() && tran.getDescripcion() != null) {
			for (TipoTexto doc : tran.getDescripcion()) {
				DescriptionType descripcion = new DescriptionType();
				getTexto(doc, descripcion);
				transaccion.getDescription().add(descripcion);
			}
		}

		if (!tran.getDocumentoReferencia().isEmpty() && tran.getDocumentoReferencia() != null) {
			for (TipoDocumentoReferencia ref : tran.getDocumentoReferencia()) {
				transaccion.getDocumentReference().add(getDocumentoReferencia(ref));
			}
		}

		return transaccion;
	}

	public HazardousItemType getArticuloPeligroso(TipoArticuloPeligroso articulos) {

		HazardousItemType artPeligroso = new HazardousItemType();

		if (articulos.getInformacionAdicional() != null) {
			AdditionalInformationType informacionAdicional = new AdditionalInformationType();
			getTexto(articulos.getInformacionAdicional(), informacionAdicional);
			artPeligroso.setAdditionalInformation(informacionAdicional);
		}

		if (articulos.getNombreCategoria() != null) {
			CategoryNameType nombreCategoria = new CategoryNameType();
			getNombre(articulos.getNombreCategoria(), nombreCategoria);
			artPeligroso.setCategoryName(nombreCategoria);
		}
		if (articulos.getContactoTercero() != null) {
			artPeligroso.setContactParty(getTercero(articulos.getContactoTercero()));

		}

		if (articulos.getCodigoProcedimientosEmergencia() != null) {
			EmergencyProceduresCodeType codigoProcedimientosEmergencia = new EmergencyProceduresCodeType();
			getCodigo(articulos.getCodigoProcedimientosEmergencia(), codigoProcedimientosEmergencia);
			artPeligroso.setEmergencyProceduresCode(codigoProcedimientosEmergencia);
		}
		if (articulos.getTemperaturaEmergencia() != null) {
			artPeligroso.setEmergencyTemperature(getTemperaturaEmergencia(articulos.getTemperaturaEmergencia()));

		}

		if (articulos.getTemperaturaPuntoCritico() != null) {
			artPeligroso.setFlashpointTemperature(getTemperaturaEmergencia(articulos.getTemperaturaPuntoCritico()));

		}

		if (articulos.getClaseRiesgoID() != null) {
			HazardClassIDType claseRiesgoID = new HazardClassIDType();
			getIdentificador(articulos.getClaseRiesgoID(), claseRiesgoID);
			artPeligroso.setHazardClassID(claseRiesgoID);
		}

		if (articulos.getCodigoCategoriaRiesgo() != null) {
			HazardousCategoryCodeType codigoCategoriaRiesgo = new HazardousCategoryCodeType();
			getCodigo(articulos.getCodigoCategoriaRiesgo(), codigoCategoriaRiesgo);
			artPeligroso.setHazardousCategoryCode(codigoCategoriaRiesgo);
		}

		if (articulos.getID() != null) {
			IDType iD = new IDType();
			getIdentificador(articulos.getID(), iD);
			artPeligroso.setID(iD);
		}

		if (articulos.getCartelRiesgoInferiorNaranjaID() != null) {
			LowerOrangeHazardPlacardIDType cartelRiesgoInferiorNaranjaID = new LowerOrangeHazardPlacardIDType();
			getIdentificador(articulos.getCartelRiesgoInferiorNaranjaID(), cartelRiesgoInferiorNaranjaID);
			artPeligroso.setLowerOrangeHazardPlacardID(cartelRiesgoInferiorNaranjaID);
		}

		if (articulos.getMarcaID() != null) {
			MarkingIDType marcaID = new MarkingIDType();
			getIdentificador(articulos.getMarcaID(), marcaID);
			artPeligroso.setMarkingID(marcaID);
		}

		if (articulos.getCodigoGuiaPrimerosAuxiliosMedico() != null) {
			MedicalFirstAidGuideCodeType codigoGuiaPrimerosAuxiliosMedico = new MedicalFirstAidGuideCodeType();
			getCodigo(articulos.getCodigoGuiaPrimerosAuxiliosMedico(), codigoGuiaPrimerosAuxiliosMedico);
			artPeligroso.setMedicalFirstAidGuideCode(codigoGuiaPrimerosAuxiliosMedico);
		}

		if (articulos.getMedidaNetaVolumen() != null) {
			NetVolumeMeasureType medidaNetaVolumen = new NetVolumeMeasureType();
			getMedida(articulos.getMedidaNetaVolumen(), medidaNetaVolumen);
			artPeligroso.setNetVolumeMeasure(medidaNetaVolumen);
		}

		if (articulos.getMedidaNetaPeso() != null) {
			NetWeightMeasureType medidaNetaPeso = new NetWeightMeasureType();
			getMedida(articulos.getMedidaNetaPeso(), medidaNetaPeso);
			artPeligroso.setNetWeightMeasure(medidaNetaPeso);
		}

		if (articulos.getAprobacionCartel() != null) {
			PlacardEndorsementType aprobacionCartel = new PlacardEndorsementType();
			getTexto(articulos.getAprobacionCartel(), aprobacionCartel);
			artPeligroso.setPlacardEndorsement(aprobacionCartel);
		}

		if (articulos.getNotaCartel() != null) {
			PlacardNotationType notaCartel = new PlacardNotationType();
			getTexto(articulos.getNotaCartel(), notaCartel);
			artPeligroso.setPlacardNotation(notaCartel);
		}

		if (articulos.getCantidad() != null) {
			QuantityType cantidad = new QuantityType();
			getCantidad(articulos.getCantidad(), cantidad);
			artPeligroso.setQuantity(cantidad);
		}

		if (articulos.getNombreTecnico() != null) {
			TechnicalNameType nombreTecnico = new TechnicalNameType();
			getNombre(articulos.getNombreTecnico(), nombreTecnico);
			artPeligroso.setTechnicalName(nombreTecnico);
		}

		if (articulos.getCodigoUNDG() != null) {
			UNDGCodeType codigoUNDG = new UNDGCodeType();
			getCodigo(articulos.getCodigoUNDG(), codigoUNDG);
			artPeligroso.setUNDGCode(codigoUNDG);
		}

		if (articulos.getIDCartelRiesgoSuperiorNaranja() != null) {
			UpperOrangeHazardPlacardIDType iDCartelRiesgoSuperiorNaranja = new UpperOrangeHazardPlacardIDType();
			getIdentificador(articulos.getIDCartelRiesgoSuperiorNaranja(), iDCartelRiesgoSuperiorNaranja);
			artPeligroso.setUpperOrangeHazardPlacardID(iDCartelRiesgoSuperiorNaranja);
		}

		if (!articulos.getTemperaturaAdicional().isEmpty() && articulos.getTemperaturaAdicional() != null) {
			for (TipoTemperatura tempAd : articulos.getTemperaturaAdicional()) {
				artPeligroso.getAdditionalTemperature().add(getTemperaturaEmergencia(tempAd));
			}
		}

		if (!articulos.getTransitoBienesArriesgado().isEmpty() && articulos.getTransitoBienesArriesgado() != null) {
			for (TipoTransitoBienArriesgado tranbienArriesgado : articulos.getTransitoBienesArriesgado()) {
				artPeligroso.getHazardousGoodsTransit().add(getTransitoBienesArriesgado(tranbienArriesgado));
			}
		}

		if (!articulos.getRiesgoSecundario().isEmpty() && articulos.getRiesgoSecundario() != null) {
			for (TipoRiesgoSecundario riesgSecund : articulos.getRiesgoSecundario()) {
				artPeligroso.getSecondaryHazard().add(getRiesgoSecundario(riesgSecund));

			}
		}

		return artPeligroso;
	}

	private SecondaryHazardType getRiesgoSecundario(TipoRiesgoSecundario riesgSecund) {

		SecondaryHazardType riesgo = new SecondaryHazardType();
		if (riesgSecund.getCodigoProcedimientoEmergencia() != null) {
			EmergencyProceduresCodeType codigoProcedimientoEmergencia = new EmergencyProceduresCodeType();
			getCodigo(riesgSecund.getCodigoProcedimientoEmergencia(), codigoProcedimientoEmergencia);
			riesgo.setEmergencyProceduresCode(codigoProcedimientoEmergencia);
		}

		if (riesgSecund.getExtension() != null) {
			ExtensionType extension = new ExtensionType();
			getTexto(riesgSecund.getExtension(), extension);
			riesgo.setExtension(extension);
		}

		if (riesgSecund.getID() != null) {
			IDType id = new IDType();
			getIdentificador(riesgSecund.getID(), id);
			riesgo.setID(id);
		}

		if (riesgSecund.getAprobacionCartel() != null) {
			PlacardEndorsementType aprobacionCartel = new PlacardEndorsementType();
			getTexto(riesgSecund.getAprobacionCartel(), aprobacionCartel);
			riesgo.setPlacardEndorsement(aprobacionCartel);
		}

		if (riesgSecund.getNotaCartel() != null) {
			PlacardNotationType notaCartel = new PlacardNotationType();
			getTexto(riesgSecund.getNotaCartel(), notaCartel);
			riesgo.setPlacardNotation(notaCartel);
		}

		return riesgo;
	}

	private HazardousGoodsTransitType getTransitoBienesArriesgado(TipoTransitoBienArriesgado tranbienArriesgado) {

		HazardousGoodsTransitType ambiente = new HazardousGoodsTransitType();
		if (tranbienArriesgado.getCodigoRegularionArriesgado() != null) {
			HazardousRegulationCodeType codigoRegularionArriesgado = new HazardousRegulationCodeType();
			getCodigo(tranbienArriesgado.getCodigoRegularionArriesgado(), codigoRegularionArriesgado);
			ambiente.setHazardousRegulationCode(codigoRegularionArriesgado);
		}

		if (tranbienArriesgado.getCodigoZonaToxicaInhalacion() != null) {
			InhalationToxicityZoneCodeType codigoZonaToxicaInhalacion = new InhalationToxicityZoneCodeType();
			getCodigo(tranbienArriesgado.getCodigoZonaToxicaInhalacion(), codigoZonaToxicaInhalacion);
			ambiente.setInhalationToxicityZoneCode(codigoZonaToxicaInhalacion);
		}

		if (tranbienArriesgado.getTemperaturaMaxima() != null) {
			ambiente.setMaximumTemperature(getTemperaturaEmergencia(tranbienArriesgado.getTemperaturaMaxima()));

		}
		if (tranbienArriesgado.getTemperaturaMinima() != null) {
			ambiente.setMinimumTemperature(getTemperaturaEmergencia(tranbienArriesgado.getTemperaturaMinima()));

		}
		if (tranbienArriesgado.getCodigoCriterioPaquete() != null) {
			PackingCriteriaCodeType codigoCriterioPaquete = new PackingCriteriaCodeType();
			getCodigo(tranbienArriesgado.getCodigoCriterioPaquete(), codigoCriterioPaquete);
			ambiente.setPackingCriteriaCode(codigoCriterioPaquete);
		}

		if (tranbienArriesgado.getCodigoAutorizacionTransporte() != null) {
			TransportAuthorizationCodeType codigoAutorizacionTransporte = new TransportAuthorizationCodeType();
			getCodigo(tranbienArriesgado.getCodigoAutorizacionTransporte(), codigoAutorizacionTransporte);
			ambiente.setTransportAuthorizationCode(codigoAutorizacionTransporte);
		}

		if (tranbienArriesgado.getTransporteCodigoTarjetaEmergencia() != null) {
			TransportEmergencyCardCodeType transporteCodigoTarjetaEmergencia = new TransportEmergencyCardCodeType();
			getCodigo(tranbienArriesgado.getTransporteCodigoTarjetaEmergencia(), transporteCodigoTarjetaEmergencia);
			ambiente.setTransportEmergencyCardCode(transporteCodigoTarjetaEmergencia);
		}

		return ambiente;

	}

	private void getMedida(BigDecimal medidaNetaPeso, NetWeightMeasureType medidaPeso) {
		if (valida.validateDate(medidaNetaPeso)) {
			medidaPeso.setValue(medidaNetaPeso);

		}
	}

	private void getMedida(BigDecimal medidaNetaVolumen, NetVolumeMeasureType medidaNetaVolumen2) {
		if (valida.validateDate(medidaNetaVolumen)) {
			medidaNetaVolumen2.setValue(medidaNetaVolumen);

		}
	}

	private TemperatureType getTemperaturaEmergencia(TipoTemperatura temperaturaEmergencia) {

		TemperatureType temp = new TemperatureType();

		if (temperaturaEmergencia.getIDAtributo() != null) {
			AttributeIDType id = new AttributeIDType();
			getIdentificador(temperaturaEmergencia.getIDAtributo(), id);
			temp.setAttributeID(id);
		}

		if (temperaturaEmergencia.getMedida() != null) {
			MeasureType medida = new MeasureType();
			getMedida(temperaturaEmergencia.getMedida(), medida);
			temp.setMeasure(medida);
		}

		if (temperaturaEmergencia.getDescripcion() != null) {
			for (TipoTexto desc : temperaturaEmergencia.getDescripcion()) {
				DescriptionType descripcion = new DescriptionType();
				getTexto(desc, descripcion);
				temp.getDescription().add(descripcion);
			}
		}

		return temp;
	}

	public ItemPropertyType getPropiedadArticuloAdicional(TipoPropiedadArticulo artAdicional) {

		ItemPropertyType item = new ItemPropertyType();
		if (artAdicional.getNombre() != null) {
			NameType nombre = new NameType();
			getNombre(artAdicional.getNombre(), nombre);
			item.setName(nombre);
		}

		if (artAdicional.getPeriodoUsabilidad() != null) {
			PeriodType periodoUsabilidad = new PeriodType();
			getPeriodo(artAdicional.getPeriodoUsabilidad(), periodoUsabilidad);
			item.setUsabilityPeriod(periodoUsabilidad);
		}

		if (artAdicional.getValor() != null) {
			ValueType valor = new ValueType();
			getTexto(artAdicional.getValor(), valor);
			item.setValue(valor);
		}

		if (!artAdicional.getGrupoPropiedadesArticulo().isEmpty()
				&& artAdicional.getGrupoPropiedadesArticulo() != null) {
			for (TipoGrupoPropiedadesArticulo grupPropArt : artAdicional.getGrupoPropiedadesArticulo()) {

				ItemPropertyGroupType grupoPropiedadesArticulo = new ItemPropertyGroupType();
				if (grupPropArt.getID() != null) {
					IDType ids = new IDType();
					getIdentificador(grupPropArt.getID(), ids);
					grupoPropiedadesArticulo.setID(ids);
				}

				if (grupPropArt.getNombre() != null) {
					NameType nombres = new NameType();
					getNombre(grupPropArt.getNombre(), nombres);
					grupoPropiedadesArticulo.setName(nombres);
				}

				item.getItemPropertyGroup().add(grupoPropiedadesArticulo);
			}
		}

		return item;
	}

	public ItemInstanceType getInstanciaArticulo(TipoInstanciaArticulo instArticulo) {

		ItemInstanceType item = new ItemInstanceType();
		if (instArticulo.getIdentificacionLote() != null) {
			LotIdentificationType identificacionLote = new LotIdentificationType();
			getIdentificadorLote(instArticulo.getIdentificacionLote(), identificacionLote);
			item.setLotIdentification(identificacionLote);
		}

		if (valida.validateDate(instArticulo.getFechaFabricacion())) {
			ManufactureDateType fechaFabricacion = new ManufactureDateType();
			fechaFabricacion.setValue(instArticulo.getFechaFabricacion());
			item.setManufactureDate(fechaFabricacion);
		}

		if (valida.validateDateHora(instArticulo.getHoraFacturacion())) {
			ManufactureTimeType horaFacturacion = new ManufactureTimeType();
			horaFacturacion.setValue(instArticulo.getHoraFacturacion());
			item.setManufactureTime(horaFacturacion);
		}

		if (instArticulo.getRastroProductoID() != null) {
			ProductTraceIDType rastroProductoID = new ProductTraceIDType();
			getIdentificador(instArticulo.getRastroProductoID(), rastroProductoID);
			item.setProductTraceID(rastroProductoID);
		}

		if (instArticulo.getIDRegistro() != null) {
			RegistrationIDType iDRegistro = new RegistrationIDType();
			getIdentificador(instArticulo.getIDRegistro(), iDRegistro);
			item.setRegistrationID(iDRegistro);
		}

		if (instArticulo.getIDSerie() != null) {
			SerialIDType iDSerie = new SerialIDType();
			getIdentificador(instArticulo.getIDSerie(), iDSerie);
			item.setSerialID(iDSerie);
		}

		if (!instArticulo.getPropiedadAdicionalArticulo().isEmpty()
				&& instArticulo.getPropiedadAdicionalArticulo() != null) {
			for (TipoPropiedadArticulo propAdic : instArticulo.getPropiedadAdicionalArticulo()) {
				item.getAdditionalItemProperty().add(getPropiedadArticuloAdicional(propAdic));
			}
		}

		return item;
	}

	private void getIdentificadorLote(TipoIdentificacionLote identificacionLote,
			LotIdentificationType identificacionLote2) {

		if (valida.validateDate(identificacionLote.getFechaVencimiento())) {
			ExpiryDateType fechaExpiracion = new ExpiryDateType();
			fechaExpiracion.setValue(identificacionLote.getFechaVencimiento());
			identificacionLote2.setExpiryDate(fechaExpiracion);
		}

		if (identificacionLote.getIDNumeroLote() != null) {
			LotNumberIDType loteNumero = new LotNumberIDType();
			getIdentificador(identificacionLote.getIDNumeroLote(), loteNumero);
			identificacionLote2.setLotNumberID(loteNumero);
		}

		if (!identificacionLote.getPropiedadAdicionalArticulo().isEmpty()
				&& identificacionLote.getPropiedadAdicionalArticulo() != null) {
			for (TipoPropiedadArticulo item : identificacionLote.getPropiedadAdicionalArticulo()) {

				identificacionLote2.getAdditionalItemProperty().add(getPropiedadArticuloAdicional(item));
			}
		}

	}

	public PartyLegalEntityType getEntidadlegal(TipoEntidadLegalTercero entidad) {

		PartyLegalEntityType entidadLegal = new PartyLegalEntityType();

		if (entidad.getEsquemaRegistroCorporativo() != null) {
			entidadLegal.setCorporateRegistrationScheme(
					getEsquemaRegistroCorporativo(entidad.getEsquemaRegistroCorporativo()));
		}

		if (entidad.getIDEmpresa() != null) {
			CompanyIDType iDEmpresa = new CompanyIDType();
			getIdentificador(entidad.getIDEmpresa(), iDEmpresa);
			entidadLegal.setCompanyID(iDEmpresa);
		}

		if (entidad.getDireccionRegistro() != null) {
			entidadLegal.setRegistrationAddress(getDireccion(entidad.getDireccionRegistro()));

		}
		if (entidad.getNombreRegistro() != null) {
			RegistrationNameType nombreRegistro = new RegistrationNameType();
			getNombre(entidad.getNombreRegistro(), nombreRegistro);
			entidadLegal.setRegistrationName(nombreRegistro);
		}

		return entidadLegal;
	}

	private CorporateRegistrationSchemeType getEsquemaRegistroCorporativo(TipoEsquemaRegistroCorporativo esquema) {

		CorporateRegistrationSchemeType corporacion = new CorporateRegistrationSchemeType();
		if (esquema.getTipoCodigoRegistroCorporativo() != null) {
			CorporateRegistrationTypeCodeType tipoCodigoRegistroCorporativo = new CorporateRegistrationTypeCodeType();
			getCodigo(esquema.getTipoCodigoRegistroCorporativo(), tipoCodigoRegistroCorporativo);
			corporacion.setCorporateRegistrationTypeCode(tipoCodigoRegistroCorporativo);
		}

		if (esquema.getID() != null) {
			IDType id = new IDType();
			getIdentificador(esquema.getID(), id);
			corporacion.setID(id);
		}

		if (esquema.getNombre() != null) {
			NameType nombre = new NameType();
			getNombre(esquema.getNombre(), nombre);
			corporacion.setName(nombre);
		}

		if (!esquema.getDireccionRegionJurisdiccion().isEmpty() && esquema.getDireccionRegionJurisdiccion() != null) {
			for (TipoDireccion direccion : esquema.getDireccionRegionJurisdiccion()) {
				corporacion.getJurisdictionRegionAddress().add(getDireccion(direccion));
			}
		}

		return corporacion;
	}

	public PartyTaxSchemeType getEsquemaImpuestosTercero(TipoEsquemaImpuestosTercero esquemaImpuestos) {

		PartyTaxSchemeType esquema = new PartyTaxSchemeType();

		if (esquemaImpuestos.getIDEmpresa() != null) {
			CompanyIDType iDEmpresa = new CompanyIDType();
			getIdentificador(esquemaImpuestos.getIDEmpresa(), iDEmpresa);
			esquema.setCompanyID(iDEmpresa);
		}

		if (esquemaImpuestos.getRazonExencion() != null) {
			ExemptionReasonType razonExencion = new ExemptionReasonType();
			getTexto(esquemaImpuestos.getRazonExencion(), razonExencion);
			esquema.setExemptionReason(razonExencion);
		}

		if (esquemaImpuestos.getCodigoRazonExencion() != null) {
			ExemptionReasonCodeType codigoRazonExencion = new ExemptionReasonCodeType();
			getCodigo(esquemaImpuestos.getCodigoRazonExencion(), codigoRazonExencion);
			esquema.setExemptionReasonCode(codigoRazonExencion);
		}

		if (esquemaImpuestos.getDireccionRegistro() != null) {
			esquema.setRegistrationAddress(getDireccion(esquemaImpuestos.getDireccionRegistro()));

		}
		if (esquemaImpuestos.getNombreRegistro() != null) {
			RegistrationNameType nombre = new RegistrationNameType();
			getNombre(esquemaImpuestos.getNombreRegistro(), nombre);
			esquema.setRegistrationName(nombre);
		}

		if (esquemaImpuestos.getCodigoNivelImpuestos() != null) {
			TaxLevelCodeType codigoNivelImpuestos = new TaxLevelCodeType();
			getCodigo(esquemaImpuestos.getCodigoNivelImpuestos(), codigoNivelImpuestos);
			esquema.setTaxLevelCode(codigoNivelImpuestos);
		}

		if (esquemaImpuestos.getEsquemaImpuestos() != null) {
			esquema.setTaxScheme(getEsquemaImpuestos(esquemaImpuestos.getEsquemaImpuestos()));

		}

		return esquema;
	}

	public void getCantidad(BigDecimal cantidadPaquete, PackQuantityType cantidadPaquete2) {
		if (valida.validateDate(cantidadPaquete)) {
			cantidadPaquete2.setValue(cantidadPaquete);

		}

	}

}
