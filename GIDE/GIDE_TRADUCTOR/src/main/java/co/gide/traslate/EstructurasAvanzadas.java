package co.gide.traslate;

import com.growupit.gideesquema.TipoArticulo;
import com.growupit.gideesquema.TipoArticuloPeligroso;
import com.growupit.gideesquema.TipoCargo;
import com.growupit.gideesquema.TipoClasificacionMercancia;
import com.growupit.gideesquema.TipoClienteTercero;
import com.growupit.gideesquema.TipoCondicionesTransaccion;
import com.growupit.gideesquema.TipoContrato;
import com.growupit.gideesquema.TipoDetalleFactura;
import com.growupit.gideesquema.TipoDireccion;
import com.growupit.gideesquema.TipoDocumentoReferencia;
import com.growupit.gideesquema.TipoEntrega;
import com.growupit.gideesquema.TipoIdentificacionArticulos;
import com.growupit.gideesquema.TipoIdentificador;
import com.growupit.gideesquema.TipoImpuestoCategoria;
import com.growupit.gideesquema.TipoImpuestoTotal;
import com.growupit.gideesquema.TipoInstanciaArticulo;
import com.growupit.gideesquema.TipoLineaReferencia;
import com.growupit.gideesquema.TipoMedioPago;
import com.growupit.gideesquema.TipoPago;
import com.growupit.gideesquema.TipoPropiedadArticulo;
import com.growupit.gideesquema.TipoProveedor;
import com.growupit.gideesquema.TipoReferenciaFactura;
import com.growupit.gideesquema.TipoReferenciaLineaPedido;
import com.growupit.gideesquema.TipoReferenciaPedido;
import com.growupit.gideesquema.TipoSubtotalImpuesto;
import com.growupit.gideesquema.TipoTasaCambio;
import com.growupit.gideesquema.TipoTercero;
import com.growupit.gideesquema.TipoTerminosEntrega;
import com.growupit.gideesquema.TipoTerminosPago;
import com.growupit.gideesquema.TipoTexto;
import com.growupit.gideesquema.TipoTotalMonetarioLegal;
import co.gov.dian.contratos.facturaelectronica.v1.AllowanceChargeType;
import co.gov.dian.contratos.facturaelectronica.v1.CustomerPartyType;
import co.gov.dian.contratos.facturaelectronica.v1.DeliveryTermsType;
import co.gov.dian.contratos.facturaelectronica.v1.DeliveryType;
import co.gov.dian.contratos.facturaelectronica.v1.InvoiceLineType;
import co.gov.dian.contratos.facturaelectronica.v1.ItemType;
import co.gov.dian.contratos.facturaelectronica.v1.MonetaryTotalType;
import co.gov.dian.contratos.facturaelectronica.v1.PaymentType;
import co.gov.dian.contratos.facturaelectronica.v1.SupplierPartyType;
import co.gov.dian.contratos.facturaelectronica.v1.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ContractType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ExchangeRateType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMeansType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentTermsType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.*;

public class EstructurasAvanzadas {


	private EstructurasBasicas estBasicas;

	public OrderReferenceType getReferenciaPedidos(TipoReferenciaPedido referenciaPedido, TipoIdentificador CUFE) {

		OrderReferenceType refePedi = new OrderReferenceType();
	
			CopyIndicatorType esCopia = new CopyIndicatorType();
			esCopia.setValue(referenciaPedido.isIndicadorCopia());
			refePedi.setCopyIndicator(esCopia);
		

		if (referenciaPedido.getReferenciaCliente() != null) {
			CustomerReferenceType referenciaCliente = new CustomerReferenceType();
			estBasicas.getTexto(referenciaPedido.getReferenciaCliente(), referenciaCliente);
			refePedi.setCustomerReference(referenciaCliente);
		}

		if (referenciaPedido.getDocumentoreferencia() != null) {
			refePedi.setDocumentReference(estBasicas.getDocumentoReferencia(referenciaPedido.getDocumentoreferencia()));

		}
		if (referenciaPedido.getID() != null) {
			IDType id = new IDType();
			estBasicas.getIdentificador(referenciaPedido.getID(), id);
			refePedi.setID(id);
		}

		if (referenciaPedido.getFechaAsunto() != null) {
			IssueDateType fechaAsunto = new IssueDateType();
			fechaAsunto.setValue(referenciaPedido.getFechaAsunto());
			refePedi.setIssueDate(fechaAsunto);
		}

		if (referenciaPedido.getIdOrdenesVenta() != null) {
			SalesOrderIDType idOrdenDeVenta = new SalesOrderIDType();
			estBasicas.getIdentificador(referenciaPedido.getIdOrdenesVenta(), idOrdenDeVenta);
			refePedi.setSalesOrderID(idOrdenDeVenta);
		}

		if (referenciaPedido.getHoraAsunto() != null) {
			IssueTimeType horaAsunto = new IssueTimeType();
			horaAsunto.setValue(referenciaPedido.getHoraAsunto());
			refePedi.setIssueTime(horaAsunto);
		}

		if (CUFE != null) {
			UUIDType cufe = new UUIDType();
			estBasicas.getIdentificador(CUFE, cufe);
			refePedi.setUUID(cufe);
		}

		return refePedi;
	}

	public SupplierPartyType getTerceroProveedor(TipoProveedor terceroProveedor) {

		SupplierPartyType proveedor = new SupplierPartyType();
		if (terceroProveedor.getContactoContable() != null) {
			proveedor.setAccountingContact(estBasicas.getContacto(terceroProveedor.getContactoContable()));

		}
		if (terceroProveedor.getCuentaAdicionalID() != null) {
			AdditionalAccountIDType idCuentaAdcional = new AdditionalAccountIDType();
			estBasicas.getIdentificador(terceroProveedor.getCuentaAdicionalID(), idCuentaAdcional);
			proveedor.setAdditionalAccountID(idCuentaAdcional);
		}

		if (terceroProveedor.getCuentaAsignadaClienteID() != null) {
			CustomerAssignedAccountIDType cuentaAsignadaClienteID = new CustomerAssignedAccountIDType();
			estBasicas.getIdentificador(terceroProveedor.getCuentaAsignadaClienteID(), cuentaAsignadaClienteID);
			proveedor.setCustomerAssignedAccountID(cuentaAsignadaClienteID);
		}

		if (terceroProveedor.getCapacidadEnvioDatos() != null) {
			DataSendingCapabilityType capacidadEnvioDatos = new DataSendingCapabilityType();
			estBasicas.getTexto(terceroProveedor.getCapacidadEnvioDatos(), capacidadEnvioDatos);
			proveedor.setDataSendingCapability(capacidadEnvioDatos);
		}

		if (terceroProveedor.getContactoDespacho() != null) {
			proveedor.setDespatchContact(estBasicas.getContacto(terceroProveedor.getContactoDespacho()));

		}
		if (terceroProveedor.getTercero() != null) {
			proveedor.setParty(estBasicas.getTerceroDIAN(terceroProveedor.getTercero()));

		}
		if (terceroProveedor.getContactoVendedor() != null) {
			proveedor.setSellerContact(estBasicas.getContacto(terceroProveedor.getContactoVendedor()));

		}

		return proveedor;
	}

	public CustomerPartyType getTerceroCliente(TipoClienteTercero terceroCliente) {

		CustomerPartyType cliente = new CustomerPartyType();
		if (terceroCliente.getContactoContable() != null) {
			cliente.setAccountingContact(estBasicas.getContacto(terceroCliente.getContactoContable()));

		}
		if (terceroCliente.getCuentaAdicionalID() != null) {
			AdditionalAccountIDType idCuentaAdcional = new AdditionalAccountIDType();
			estBasicas.getIdentificador(terceroCliente.getCuentaAdicionalID(), idCuentaAdcional);
			cliente.setAdditionalAccountID(idCuentaAdcional);

		}

		if (terceroCliente.getCuentaAsignadaClienteID() != null) {
			CustomerAssignedAccountIDType cuentaAsignadaClienteID = new CustomerAssignedAccountIDType();
			estBasicas.getIdentificador(terceroCliente.getCuentaAsignadaClienteID(), cuentaAsignadaClienteID);
			cliente.setCustomerAssignedAccountID(cuentaAsignadaClienteID);
		}

		if (terceroCliente.getTercero() != null) {
			cliente.setParty(estBasicas.getTerceroDIAN(terceroCliente.getTercero()));

		}
		if (terceroCliente.getContactoComprador() != null) {
			cliente.setBuyerContact(estBasicas.getContacto(terceroCliente.getContactoComprador()));
		}
		if (terceroCliente.getContactoEntrega() != null) {
			cliente.setDeliveryContact(estBasicas.getContacto(terceroCliente.getContactoEntrega()));

		}
		if (terceroCliente.getCuentaAsignadaProveedorID() != null) {
			SupplierAssignedAccountIDType cuentaAsignadaProveedorID = new SupplierAssignedAccountIDType();
			estBasicas.getIdentificador(terceroCliente.getCuentaAsignadaProveedorID(), cuentaAsignadaProveedorID);
			cliente.setSupplierAssignedAccountID(cuentaAsignadaProveedorID);
		}

		return cliente;
	}

	private co.gov.dian.contratos.facturaelectronica.v1.AddressType getDireccion2(TipoDireccion tipoDireccion) {

		co.gov.dian.contratos.facturaelectronica.v1.AddressType direccion = new co.gov.dian.contratos.facturaelectronica.v1.AddressType();
		if (tipoDireccion.getID() != null) {
			IDType id = new IDType();
			estBasicas.getIdentificador(tipoDireccion.getID(), id);
			direccion.setID(id);
		}

		if (tipoDireccion.getTipoCodigoDireccion() != null) {
			AddressTypeCodeType tipoCodigoDireccion = new AddressTypeCodeType();
			estBasicas.getCodigo(tipoDireccion.getTipoCodigoDireccion(), tipoCodigoDireccion);
			direccion.setAddressTypeCode(tipoCodigoDireccion);
		}

		if (tipoDireccion.getTipoCodigoDireccion() != null) {
			AddressFormatCodeType formatoCodigoDireccion = new AddressFormatCodeType();
			estBasicas.getCodigo(tipoDireccion.getTipoCodigoDireccion(), formatoCodigoDireccion);
			direccion.setAddressFormatCode(formatoCodigoDireccion);
		}

		if (tipoDireccion.getBuzon() != null) {
			PostboxType buzon = new PostboxType();
			estBasicas.getTexto(tipoDireccion.getBuzon(), buzon);
			direccion.setPostbox(buzon);
		}

		if (tipoDireccion.getPiso() != null) {
			FloorType piso = new FloorType();
			estBasicas.getTexto(tipoDireccion.getPiso(), piso);
			direccion.setFloor(piso);
		}

		if (tipoDireccion.getCuarto() != null) {
			RoomType cuarto = new RoomType();
			estBasicas.getTexto(tipoDireccion.getCuarto(), cuarto);
			direccion.setRoom(cuarto);
		}

		if (tipoDireccion.getNombreCalle() != null) {
			StreetNameType nombreCalle = new StreetNameType();
			estBasicas.getNombre(tipoDireccion.getNombreCalle(), nombreCalle);
			direccion.setStreetName(nombreCalle);
		}

		if (tipoDireccion.getNombreCalleAdicional() != null) {
			AdditionalStreetNameType nombreCalleAdicional = new AdditionalStreetNameType();
			estBasicas.getNombre(tipoDireccion.getNombreCalleAdicional(), nombreCalleAdicional);
			direccion.setAdditionalStreetName(nombreCalleAdicional);
		}

		if (tipoDireccion.getNombreBloque() != null) {
			BlockNameType nombreBloque = new BlockNameType();
			estBasicas.getNombre(tipoDireccion.getNombreBloque(), nombreBloque);
			direccion.setBlockName(nombreBloque);
		}

		if (tipoDireccion.getNombreEdificio() != null) {
			BuildingNameType nombreEdificio = new BuildingNameType();
			estBasicas.getNombre(tipoDireccion.getNombreEdificio(), nombreEdificio);
			direccion.setBuildingName(nombreEdificio);
		}

		if (tipoDireccion.getNumeroEdificio() != null) {
			BuildingNumberType numeroEdificio = new BuildingNumberType();
			estBasicas.getTexto(tipoDireccion.getNumeroEdificio(), numeroEdificio);
			direccion.setBuildingNumber(numeroEdificio);
		}

		if (tipoDireccion.getCorreoInterno() != null) {
			InhouseMailType correoInterno = new InhouseMailType();
			estBasicas.getTexto(tipoDireccion.getCorreoInterno(), correoInterno);
			direccion.setInhouseMail(correoInterno);
		}

		if (tipoDireccion.getDepartamento() != null) {
			DepartmentType departamento = new DepartmentType();
			estBasicas.getTexto(tipoDireccion.getDepartamento(), departamento);
			direccion.setDepartment(departamento);
		}

		if (tipoDireccion.getMarcaAtencion() != null) {
			MarkAttentionType marcaAtencion = new MarkAttentionType();
			estBasicas.getTexto(tipoDireccion.getMarcaAtencion(), marcaAtencion);
			direccion.setMarkAttention(marcaAtencion);
		}

		if (tipoDireccion.getIdentificacionParcela() != null) {
			PlotIdentificationType identificacionParcela = new PlotIdentificationType();
			estBasicas.getTexto(tipoDireccion.getIdentificacionParcela(), identificacionParcela);
			direccion.setPlotIdentification(identificacionParcela);
		}

		if (tipoDireccion.getNombreSubdivisionCiudad() != null) {
			CitySubdivisionNameType nombreSubdivisionCiudad = new CitySubdivisionNameType();
			estBasicas.getNombre(tipoDireccion.getNombreSubdivisionCiudad(), nombreSubdivisionCiudad);
			direccion.setCitySubdivisionName(nombreSubdivisionCiudad);
		}

		if (tipoDireccion.getNombreCiudad() != null) {
			CityNameType nombreCiudad = new CityNameType();
			estBasicas.getNombre(tipoDireccion.getNombreCiudad(), nombreCiudad);
			direccion.setCityName(nombreCiudad);
		}

		if (tipoDireccion.getZonaPostal() != null) {
			PostalZoneType zonaPostal = new PostalZoneType();
			estBasicas.getTexto(tipoDireccion.getZonaPostal(), zonaPostal);
			direccion.setPostalZone(zonaPostal);
		}

		if (tipoDireccion.getSubentidadPais() != null) {
			CountrySubentityType subentidadPais = new CountrySubentityType();
			estBasicas.getTexto(tipoDireccion.getSubentidadPais(), subentidadPais);
			direccion.setCountrySubentity(subentidadPais);
		}

		if (tipoDireccion.getCodigoSubentidadesPais() != null) {
			CountrySubentityCodeType codigoSubentidadesPais = new CountrySubentityCodeType();
			estBasicas.getCodigo(tipoDireccion.getCodigoSubentidadesPais(), codigoSubentidadesPais);
			direccion.setCountrySubentityCode(codigoSubentidadesPais);
		}

		if (tipoDireccion.getRegion() != null) {
			RegionType region = new RegionType();
			estBasicas.getTexto(tipoDireccion.getRegion(), region);
			direccion.setRegion(region);
		}

		if (tipoDireccion.getDistrito() != null) {
			DistrictType distrito = new DistrictType();
			estBasicas.getTexto(tipoDireccion.getDistrito(), distrito);
			direccion.setDistrict(distrito);
		}

		if (tipoDireccion.getZonaHorariaOffset() != null) {
			TimezoneOffsetType zonaHorariaOffset = new TimezoneOffsetType();
			estBasicas.getTexto(tipoDireccion.getZonaHorariaOffset(), zonaHorariaOffset);
			direccion.setTimezoneOffset(zonaHorariaOffset);
		}

		if (!tipoDireccion.getLineaDireccion().isEmpty() && tipoDireccion.getLineaDireccion() != null) {
			for (TipoTexto lineaDirecciones : tipoDireccion.getLineaDireccion()) {

				AddressLineType lineaDireccion = new AddressLineType();
				estBasicas.getLineaDireccion(lineaDirecciones, lineaDireccion);
				direccion.getAddressLine().add(lineaDireccion);

			}
		}
		if (!tipoDireccion.getLineaDireccion().isEmpty() && tipoDireccion.getLineaDireccion() != null) {

			for (TipoTexto lineaDirecciones : tipoDireccion.getLineaDireccion()) {

				AddressLineType lineaDireccion = new AddressLineType();
				estBasicas.getLineaDireccion(lineaDirecciones, lineaDireccion);
				direccion.getAddressLine().add(lineaDireccion);

			}
		}

		if (tipoDireccion.getPais() != null) {
			direccion.setCountry(estBasicas.getPais(tipoDireccion.getPais()));

		}
		if (tipoDireccion.getCoordenadasUbicacion() != null) {
			direccion
					.setLocationCoordinate(estBasicas.getCoordenadasUbicacion(tipoDireccion.getCoordenadasUbicacion()));

		}
		return direccion;
	}

	private AddressType getDireccion(TipoDireccion tipoDireccion) {

		AddressType direccion = new AddressType();
		if (tipoDireccion.getID() != null) {
			IDType id = new IDType();
			estBasicas.getIdentificador(tipoDireccion.getID(), id);
			direccion.setID(id);
		}

		if (tipoDireccion.getTipoCodigoDireccion() != null) {
			AddressTypeCodeType tipoCodigoDireccion = new AddressTypeCodeType();
			estBasicas.getCodigo(tipoDireccion.getTipoCodigoDireccion(), tipoCodigoDireccion);
			direccion.setAddressTypeCode(tipoCodigoDireccion);
		}

		if (tipoDireccion.getTipoCodigoDireccion() != null) {
			AddressFormatCodeType formatoCodigoDireccion = new AddressFormatCodeType();
			estBasicas.getCodigo(tipoDireccion.getTipoCodigoDireccion(), formatoCodigoDireccion);
			direccion.setAddressFormatCode(formatoCodigoDireccion);
		}

		if (tipoDireccion.getBuzon() != null) {
			PostboxType buzon = new PostboxType();
			estBasicas.getTexto(tipoDireccion.getBuzon(), buzon);
			direccion.setPostbox(buzon);
		}

		if (tipoDireccion.getPiso() != null) {
			FloorType piso = new FloorType();
			estBasicas.getTexto(tipoDireccion.getPiso(), piso);
			direccion.setFloor(piso);
		}

		if (tipoDireccion.getCuarto() != null) {
			RoomType cuarto = new RoomType();
			estBasicas.getTexto(tipoDireccion.getCuarto(), cuarto);
			direccion.setRoom(cuarto);
		}

		if (tipoDireccion.getNombreCalle() != null) {
			StreetNameType nombreCalle = new StreetNameType();
			estBasicas.getNombre(tipoDireccion.getNombreCalle(), nombreCalle);
			direccion.setStreetName(nombreCalle);
		}

		if (tipoDireccion.getNombreCalleAdicional() != null) {
			AdditionalStreetNameType nombreCalleAdicional = new AdditionalStreetNameType();
			estBasicas.getNombre(tipoDireccion.getNombreCalleAdicional(), nombreCalleAdicional);
			direccion.setAdditionalStreetName(nombreCalleAdicional);
		}

		if (tipoDireccion.getNombreBloque() != null) {
			BlockNameType nombreBloque = new BlockNameType();
			estBasicas.getNombre(tipoDireccion.getNombreBloque(), nombreBloque);
			direccion.setBlockName(nombreBloque);
		}

		if (tipoDireccion.getNombreEdificio() != null) {
			BuildingNameType nombreEdificio = new BuildingNameType();
			estBasicas.getNombre(tipoDireccion.getNombreEdificio(), nombreEdificio);
			direccion.setBuildingName(nombreEdificio);
		}

		if (tipoDireccion.getNumeroEdificio() != null) {
			BuildingNumberType numeroEdificio = new BuildingNumberType();
			estBasicas.getTexto(tipoDireccion.getNumeroEdificio(), numeroEdificio);
			direccion.setBuildingNumber(numeroEdificio);
		}

		if (tipoDireccion.getCorreoInterno() != null) {
			InhouseMailType correoInterno = new InhouseMailType();
			estBasicas.getTexto(tipoDireccion.getCorreoInterno(), correoInterno);
			direccion.setInhouseMail(correoInterno);
		}

		if (tipoDireccion.getDepartamento() != null) {
			DepartmentType departamento = new DepartmentType();
			estBasicas.getTexto(tipoDireccion.getDepartamento(), departamento);
			direccion.setDepartment(departamento);
		}

		if (tipoDireccion.getMarcaAtencion() != null) {
			MarkAttentionType marcaAtencion = new MarkAttentionType();
			estBasicas.getTexto(tipoDireccion.getMarcaAtencion(), marcaAtencion);
			direccion.setMarkAttention(marcaAtencion);
		}

		if (tipoDireccion.getIdentificacionParcela() != null) {
			PlotIdentificationType identificacionParcela = new PlotIdentificationType();
			estBasicas.getTexto(tipoDireccion.getIdentificacionParcela(), identificacionParcela);
			direccion.setPlotIdentification(identificacionParcela);
		}

		if (tipoDireccion.getNombreSubdivisionCiudad() != null) {
			CitySubdivisionNameType nombreSubdivisionCiudad = new CitySubdivisionNameType();
			estBasicas.getNombre(tipoDireccion.getNombreSubdivisionCiudad(), nombreSubdivisionCiudad);
			direccion.setCitySubdivisionName(nombreSubdivisionCiudad);
		}

		if (tipoDireccion.getNombreCiudad() != null) {
			CityNameType nombreCiudad = new CityNameType();
			estBasicas.getNombre(tipoDireccion.getNombreCiudad(), nombreCiudad);
			direccion.setCityName(nombreCiudad);
		}

		if (tipoDireccion.getZonaPostal() != null) {
			PostalZoneType zonaPostal = new PostalZoneType();
			estBasicas.getTexto(tipoDireccion.getZonaPostal(), zonaPostal);
			direccion.setPostalZone(zonaPostal);
		}

		if (tipoDireccion.getSubentidadPais() != null) {
			CountrySubentityType subentidadPais = new CountrySubentityType();
			estBasicas.getTexto(tipoDireccion.getSubentidadPais(), subentidadPais);
			direccion.setCountrySubentity(subentidadPais);
		}

		if (tipoDireccion.getCodigoSubentidadesPais() != null) {
			CountrySubentityCodeType codigoSubentidadesPais = new CountrySubentityCodeType();
			estBasicas.getCodigo(tipoDireccion.getCodigoSubentidadesPais(), codigoSubentidadesPais);
			direccion.setCountrySubentityCode(codigoSubentidadesPais);
		}

		if (tipoDireccion.getRegion() != null) {
			RegionType region = new RegionType();
			estBasicas.getTexto(tipoDireccion.getRegion(), region);
			direccion.setRegion(region);
		}

		if (tipoDireccion.getDistrito() != null) {
			DistrictType distrito = new DistrictType();
			estBasicas.getTexto(tipoDireccion.getDistrito(), distrito);
			direccion.setDistrict(distrito);
		}

		if (tipoDireccion.getZonaHorariaOffset() != null) {
			TimezoneOffsetType zonaHorariaOffset = new TimezoneOffsetType();
			estBasicas.getTexto(tipoDireccion.getZonaHorariaOffset(), zonaHorariaOffset);
			direccion.setTimezoneOffset(zonaHorariaOffset);
		}

		if (!tipoDireccion.getLineaDireccion().isEmpty() && tipoDireccion.getLineaDireccion() != null) {
			for (TipoTexto lineaDirecciones : tipoDireccion.getLineaDireccion()) {

				AddressLineType lineaDireccion = new AddressLineType();
				estBasicas.getLineaDireccion(lineaDirecciones, lineaDireccion);
				direccion.getAddressLine().add(lineaDireccion);

			}
		}

		if (tipoDireccion.getPais() != null) {
			direccion.setCountry(estBasicas.getPais(tipoDireccion.getPais()));

		}
		if (tipoDireccion.getCoordenadasUbicacion() != null) {
			direccion
					.setLocationCoordinate(estBasicas.getCoordenadasUbicacion(tipoDireccion.getCoordenadasUbicacion()));

		}
		return direccion;
	}

	public oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType getTerceroComprador(
			TipoClienteTercero terceroComprador) {

		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType comprador = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType();
		if (terceroComprador.getContactoContable() != null) {
			comprador.setAccountingContact(estBasicas.getContacto(terceroComprador.getContactoContable()));

		}
		if (terceroComprador.getContactoComprador() != null)

		{
			comprador.setBuyerContact(estBasicas.getContacto(terceroComprador.getContactoComprador()));
		}

		if (terceroComprador.getCuentaAsignadaClienteID() != null) {
			CustomerAssignedAccountIDType cuentaAsignadaClienteID = new CustomerAssignedAccountIDType();
			estBasicas.getIdentificador(terceroComprador.getCuentaAsignadaClienteID(), cuentaAsignadaClienteID);
			comprador.setCustomerAssignedAccountID(cuentaAsignadaClienteID);
		}

		if (terceroComprador.getContactoEntrega() != null) {

			comprador.setDeliveryContact(estBasicas.getContacto(terceroComprador.getContactoEntrega()));

		}
		if (terceroComprador.getTercero() != null) {
			comprador.setParty(estBasicas.getTercero(terceroComprador.getTercero()));

		}

		if (terceroComprador.getCuentaAsignadaProveedorID() != null) {

			SupplierAssignedAccountIDType cuentaAsignadaProveedorID = new SupplierAssignedAccountIDType();
			estBasicas.getIdentificador(terceroComprador.getCuentaAsignadaProveedorID(), cuentaAsignadaProveedorID);
			comprador.setSupplierAssignedAccountID(cuentaAsignadaProveedorID);
		}

		if (terceroComprador.getCuentaAdicionalID() != null) {

			AdditionalAccountIDType cuentaAdicionalID = new AdditionalAccountIDType();
			estBasicas.getIdentificador(terceroComprador.getCuentaAdicionalID(), cuentaAdicionalID);
			comprador.getAdditionalAccountID().add(cuentaAdicionalID);
		}

		return comprador;
	}

	public oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType getTerceroProveedorVendedor(
			TipoProveedor terceroProveedorVendedor) {

		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType proveedorVendedor = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType();
		if (terceroProveedorVendedor.getCuentaAsignadaClienteID() != null) {
			CustomerAssignedAccountIDType cuentaAsignadaClienteID = new CustomerAssignedAccountIDType();
			estBasicas.getIdentificador(terceroProveedorVendedor.getCuentaAsignadaClienteID(), cuentaAsignadaClienteID);
			proveedorVendedor.setCustomerAssignedAccountID(cuentaAsignadaClienteID);

		}

		if (terceroProveedorVendedor.getCuentaAdicionalID() != null) {

			AdditionalAccountIDType cuentaAdicionalID = new AdditionalAccountIDType();
			estBasicas.getIdentificador(terceroProveedorVendedor.getCuentaAdicionalID(), cuentaAdicionalID);
			proveedorVendedor.getAdditionalAccountID().add(cuentaAdicionalID);
		}

		if (terceroProveedorVendedor.getCapacidadEnvioDatos() != null) {
			DataSendingCapabilityType capacidadEnvioDatos = new DataSendingCapabilityType();
			estBasicas.getTexto(terceroProveedorVendedor.getCapacidadEnvioDatos(), capacidadEnvioDatos);
			proveedorVendedor.setDataSendingCapability(capacidadEnvioDatos);

		}

		if (terceroProveedorVendedor.getTercero() != null) {

			proveedorVendedor.setParty(estBasicas.getTercero(terceroProveedorVendedor.getTercero()));

		}
		if (terceroProveedorVendedor.getContactoDespacho() != null) {

			proveedorVendedor
					.setDespatchContact(estBasicas.getContacto(terceroProveedorVendedor.getContactoDespacho()));

		}
		if (terceroProveedorVendedor.getContactoContable() != null) {

			proveedorVendedor
					.setAccountingContact(estBasicas.getContacto(terceroProveedorVendedor.getContactoContable()));

		}
		if (terceroProveedorVendedor.getContactoVendedor() != null) {
			proveedorVendedor.setSellerContact(estBasicas.getContacto(terceroProveedorVendedor.getContactoVendedor()));

		}

		return proveedorVendedor;
	}

	public oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryType getCondicionesDeEntrega2(
			TipoEntrega entrega) {

		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryType e = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryType();
		if (entrega.getID() != null) {
			IDType id = new IDType();
			estBasicas.getIdentificador(entrega.getID(), id);
			e.setID(id);

		}

		if (entrega.getCantidad() != null) {

			QuantityType cantidad = new QuantityType();
			estBasicas.getCantidad(entrega.getCantidad(), cantidad);
			e.setQuantity(cantidad);
		}

		if (entrega.getCantidadMinima() != null) {

			MinimumQuantityType cantidadMinima = new MinimumQuantityType();
			estBasicas.getCantidad(entrega.getCantidadMinima(), cantidadMinima);
			e.setMinimumQuantity(cantidadMinima);
		}

		if (entrega.getCantidadMaxima() != null) {

			MaximumQuantityType cantidadMaxima = new MaximumQuantityType();
			estBasicas.getCantidad(entrega.getCantidadMaxima(), cantidadMaxima);
			e.setMaximumQuantity(cantidadMaxima);
		}

		if (entrega.getFechaActualEntrega() != null) {

			ActualDeliveryDateType fechaActualEntrega = new ActualDeliveryDateType();
			fechaActualEntrega.setValue(entrega.getFechaActualEntrega());
			e.setActualDeliveryDate(fechaActualEntrega);
		}

		if (entrega.getHoraActualEntrega() != null) {

			ActualDeliveryTimeType horaActualEntrega = new ActualDeliveryTimeType();
			horaActualEntrega.setValue(entrega.getHoraActualEntrega());
			e.setActualDeliveryTime(horaActualEntrega);
		}

		if (entrega.getFechaUltimaEntrega() != null) {

			LatestDeliveryDateType fechaUltimaEntrega = new LatestDeliveryDateType();
			fechaUltimaEntrega.setValue(entrega.getFechaUltimaEntrega());
			e.setLatestDeliveryDate(fechaUltimaEntrega);
		}

		if (entrega.getHoraUltimaEntrega() != null) {

			LatestDeliveryTimeType horaUltimaEntrega = new LatestDeliveryTimeType();
			horaUltimaEntrega.setValue(entrega.getHoraUltimaEntrega());
			e.setLatestDeliveryTime(horaUltimaEntrega);
		}

		if (entrega.getIDSeguimiento() != null) {

			TrackingIDType iDSeguimiento = new TrackingIDType();
			estBasicas.getIdentificador(entrega.getIDSeguimiento(), iDSeguimiento);
			e.setTrackingID(iDSeguimiento);
		}

		if (entrega.getDireccionEntrega() != null) {

			e.setDeliveryAddress(getDireccion(entrega.getDireccionEntrega()));

		}
		if (entrega.getUbicacionEntrega() != null) {

			e.setDeliveryLocation(estBasicas.getUbicacionFisica2(entrega.getUbicacionEntrega()));

		}

		if (entrega.getPlazoEntregaSolicitado() != null) {
			PeriodType plazoEntregaSolicitado = new PeriodType();
			estBasicas.getPeriodo(entrega.getPlazoEntregaSolicitado(), plazoEntregaSolicitado);
			e.setRequestedDeliveryPeriod(plazoEntregaSolicitado);

		}

		if (entrega.getPlazoEntregaPrometido() != null) {
			PeriodType plazoEntregaPrometido = new PeriodType();
			estBasicas.getPeriodo(entrega.getPlazoEntregaPrometido(), plazoEntregaPrometido);
			e.setPromisedDeliveryPeriod(plazoEntregaPrometido);

		}

		if (entrega.getPlazoEntregaEstimado() != null) {
			PeriodType plazoEntregaEstimado = new PeriodType();
			estBasicas.getPeriodo(entrega.getPlazoEntregaEstimado(), plazoEntregaEstimado);
			e.setEstimatedDeliveryPeriod(plazoEntregaEstimado);

		}

		if (entrega.getEntregaTercero() != null) {
			e.setDeliveryParty(estBasicas.getTercero(entrega.getEntregaTercero()));
		}
		if (entrega.getDespacho() != null) {
			e.setDespatch(estBasicas.getDespacho2(entrega.getDespacho()));
		}

		return e;
	}

	public DeliveryType getCondicionesDeEntrega(TipoEntrega entrega) {

		DeliveryType e = new DeliveryType();
		if (entrega.getID() != null) {

			IDType id = new IDType();
			estBasicas.getIdentificador(entrega.getID(), id);
			e.setID(id);
		}

		if (entrega.getCantidad() != null) {
			QuantityType cantidad = new QuantityType();
			estBasicas.getCantidad(entrega.getCantidad(), cantidad);
			e.setQuantity(cantidad);

		}

		if (entrega.getCantidadMinima() != null) {
			MinimumQuantityType cantidadMinima = new MinimumQuantityType();
			estBasicas.getCantidad(entrega.getCantidadMinima(), cantidadMinima);
			e.setMinimumQuantity(cantidadMinima);

		}

		if (entrega.getCantidadMaxima() != null) {
			MaximumQuantityType cantidadMaxima = new MaximumQuantityType();
			estBasicas.getCantidad(entrega.getCantidadMaxima(), cantidadMaxima);
			e.setMaximumQuantity(cantidadMaxima);

		}

		if (entrega.getFechaActualEntrega() != null) {
			ActualDeliveryDateType fechaActualEntrega = new ActualDeliveryDateType();
			fechaActualEntrega.setValue(entrega.getFechaActualEntrega());
			e.setActualDeliveryDate(fechaActualEntrega);

		}

		if (entrega.getHoraActualEntrega() != null) {
			ActualDeliveryTimeType horaActualEntrega = new ActualDeliveryTimeType();
			horaActualEntrega.setValue(entrega.getHoraActualEntrega());
			e.setActualDeliveryTime(horaActualEntrega);

		}

		if (entrega.getFechaUltimaEntrega() != null) {

			LatestDeliveryDateType fechaUltimaEntrega = new LatestDeliveryDateType();
			fechaUltimaEntrega.setValue(entrega.getFechaUltimaEntrega());
			e.setLatestDeliveryDate(fechaUltimaEntrega);
		}

		if (entrega.getHoraUltimaEntrega() != null) {

			LatestDeliveryTimeType horaUltimaEntrega = new LatestDeliveryTimeType();
			horaUltimaEntrega.setValue(entrega.getHoraUltimaEntrega());
			e.setLatestDeliveryTime(horaUltimaEntrega);
		}

		if (entrega.getIDSeguimiento() != null) {

			TrackingIDType iDSeguimiento = new TrackingIDType();
			estBasicas.getIdentificador(entrega.getIDSeguimiento(), iDSeguimiento);
			e.setTrackingID(iDSeguimiento);
		}

		if (entrega.getDireccionEntrega() != null) {

			e.setDeliveryAddress(getDireccion2(entrega.getDireccionEntrega()));

		}
		if (entrega.getUbicacionEntrega() != null) {
			e.setDeliveryLocation(estBasicas.getUbicacionFisica(entrega.getUbicacionEntrega()));

		}
		if (entrega.getPlazoEntregaSolicitado() != null) {

			PeriodType plazoEntregaSolicitado = new PeriodType();
			estBasicas.getPeriodo(entrega.getPlazoEntregaSolicitado(), plazoEntregaSolicitado);
			e.setRequestedDeliveryPeriod(plazoEntregaSolicitado);
		}

		if (entrega.getPlazoEntregaPrometido() != null) {
			PeriodType plazoEntregaPrometido = new PeriodType();
			estBasicas.getPeriodo(entrega.getPlazoEntregaPrometido(), plazoEntregaPrometido);
			e.setPromisedDeliveryPeriod(plazoEntregaPrometido);

		}

		if (entrega.getPlazoEntregaEstimado() != null) {
			PeriodType plazoEntregaEstimado = new PeriodType();
			estBasicas.getPeriodo(entrega.getPlazoEntregaEstimado(), plazoEntregaEstimado);
			e.setEstimatedDeliveryPeriod(plazoEntregaEstimado);

		}

		if (entrega.getEntregaTercero() != null) {
			e.setDeliveryParty(estBasicas.getTerceroDIAN(entrega.getEntregaTercero()));

		}
		if (entrega.getDespacho() != null) {

			e.setDespatch(estBasicas.getDespacho(entrega.getDespacho()));

		}

		return e;
	}

	public DeliveryTermsType getTerminosEntrega(TipoTerminosEntrega terminosEntrega) {

		DeliveryTermsType termEntr = new DeliveryTermsType();
		if (terminosEntrega.getCargo() != null) {

			termEntr.setAllowanceCharge(estBasicas.getCargos(terminosEntrega.getCargo()));

		}
		if (terminosEntrega.getCargo() != null) {

			termEntr.setAllowanceCharge(estBasicas.getCargos(terminosEntrega.getCargo()));

		}
		if (terminosEntrega.getID() != null) {
			IDType id = new IDType();
			estBasicas.getIdentificador(terminosEntrega.getID(), id);
			termEntr.setID(id);

		}

		if (terminosEntrega.getRiesgoPerdida() != null) {

			LossRiskType riesgoPerdida = new LossRiskType();
			estBasicas.getTexto(terminosEntrega.getRiesgoPerdida(), riesgoPerdida);
			termEntr.setLossRisk(riesgoPerdida);
		}

		if (terminosEntrega.getCodigoResponsableRiesgoPerdida() != null) {

			LossRiskResponsibilityCodeType codigoResponsableRiesgoPerdida = new LossRiskResponsibilityCodeType();
			estBasicas.getCodigo(terminosEntrega.getCodigoResponsableRiesgoPerdida(), codigoResponsableRiesgoPerdida);
			termEntr.setLossRiskResponsibilityCode(codigoResponsableRiesgoPerdida);
		}

		if (terminosEntrega.getTerminosEspeciales() != null) {
			SpecialTermsType terminosEspeciales = new SpecialTermsType();
			estBasicas.getTexto(terminosEntrega.getTerminosEspeciales(), terminosEspeciales);
			termEntr.setSpecialTerms(terminosEspeciales);

		}

		return termEntr;
	}

	public oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryTermsType getTerminosEntrega2(
			TipoTerminosEntrega terminosEntrega) {

		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryTermsType termEntr = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryTermsType();
		if (terminosEntrega.getCargo() != null) {
			termEntr.setAllowanceCharge(estBasicas.getCargos(terminosEntrega.getCargo()));

		}
		if (terminosEntrega.getUbicacionEntrega() != null) {

			termEntr.setDeliveryLocation(estBasicas.getUbicacionFisica2(terminosEntrega.getUbicacionEntrega()));

		}
		if (terminosEntrega.getID() != null) {

			IDType id = new IDType();
			estBasicas.getIdentificador(terminosEntrega.getID(), id);
			termEntr.setID(id);
		}

		if (terminosEntrega.getRiesgoPerdida() != null) {

			LossRiskType riesgoPerdida = new LossRiskType();
			estBasicas.getTexto(terminosEntrega.getRiesgoPerdida(), riesgoPerdida);
			termEntr.setLossRisk(riesgoPerdida);
		}

		if (terminosEntrega.getCodigoResponsableRiesgoPerdida() != null) {

			LossRiskResponsibilityCodeType codigoResponsableRiesgoPerdida = new LossRiskResponsibilityCodeType();
			estBasicas.getCodigo(terminosEntrega.getCodigoResponsableRiesgoPerdida(), codigoResponsableRiesgoPerdida);
			termEntr.setLossRiskResponsibilityCode(codigoResponsableRiesgoPerdida);
		}

		if (terminosEntrega.getTerminosEspeciales() != null) {

			SpecialTermsType terminosEspeciales = new SpecialTermsType();
			estBasicas.getTexto(terminosEntrega.getTerminosEspeciales(), terminosEspeciales);
			termEntr.setSpecialTerms(terminosEspeciales);
		}

		return termEntr;
	}

	public PaymentMeansType getMedioDePago(TipoMedioPago medioDePago) {

		PaymentMeansType mediosDePago = new PaymentMeansType();
		if (medioDePago.getCuentaTarjeta() != null) {
			mediosDePago.setCardAccount(estBasicas.getcuentaTarjeta(medioDePago.getCuentaTarjeta()));

		}
		if (medioDePago.getCuentaCredito() != null) {
			mediosDePago.setCreditAccount(estBasicas.getCuentaCredito(medioDePago.getCuentaCredito()));

		}
		if (medioDePago.getId() != null) {

			IDType id = new IDType();
			estBasicas.getIdentificador(medioDePago.getId(), id);
			mediosDePago.setID(id);
		}

		if (medioDePago.getOrdenID() != null) {
			InstructionIDType ordenID = new InstructionIDType();
			estBasicas.getIdentificador(medioDePago.getOrdenID(), ordenID);
			mediosDePago.setInstructionID(ordenID);

		}

		if (medioDePago.getCuentaContribuyenteBeneficiario() != null) {
			mediosDePago.setPayeeFinancialAccount(
					estBasicas.getCuentaContribuyenteBeneficiario(medioDePago.getCuentaContribuyenteBeneficiario()));

		}

		if (medioDePago.getCuentaContribuyenteFinanciero() != null) {

			mediosDePago.setPayerFinancialAccount(
					estBasicas.getCuentaContribuyenteBeneficiario(medioDePago.getCuentaContribuyenteFinanciero()));
		}

		if (medioDePago.getCodigoCanalPago() != null) {

			PaymentChannelCodeType codigoCanalPago = new PaymentChannelCodeType();
			estBasicas.getCodigo(medioDePago.getCodigoCanalPago(), codigoCanalPago);
			mediosDePago.setPaymentChannelCode(codigoCanalPago);
		}

		if (medioDePago.getFechaVencimientoPago() != null) {
			PaymentDueDateType fechaVencimientoPago = new PaymentDueDateType();
			fechaVencimientoPago.setValue(medioDePago.getFechaVencimientoPago());
			mediosDePago.setPaymentDueDate(fechaVencimientoPago);

		}

		if (medioDePago.getCodigoMedioPago() != null) {
			PaymentMeansCodeType codigoMedioPago = new PaymentMeansCodeType();
			estBasicas.getCodigo(medioDePago.getCodigoMedioPago(), codigoMedioPago);
			mediosDePago.setPaymentMeansCode(codigoMedioPago);
		}

		if (!medioDePago.getIDPago().isEmpty() && medioDePago.getIDPago() != null) {
			for (TipoIdentificador pago : medioDePago.getIDPago()) {
				PaymentIDType iDPago = new PaymentIDType();
				estBasicas.getIdentificador(pago, iDPago);
				mediosDePago.getPaymentID().add(iDPago);
			}
		}

		if (!medioDePago.getNotaOrden().isEmpty() && medioDePago.getNotaOrden() != null) {
			for (TipoTexto orden : medioDePago.getNotaOrden()) {
				InstructionNoteType notaOrden = new InstructionNoteType();
				estBasicas.getTexto(orden, notaOrden);
				mediosDePago.getInstructionNote().add(notaOrden);
			}

		}

		return mediosDePago;
	}

	public PaymentTermsType getTerminoDePago(TipoTerminosPago terminoDePago) {

		PaymentTermsType condicionesDePago = new PaymentTermsType();
		if (terminoDePago.getMonto() != null) {

			AmountType monto = new AmountType();
			estBasicas.getMonto(terminoDePago.getMonto(), monto);
			condicionesDePago.setAmount(monto);
		}

		if (terminoDePago.getID() != null) {

			IDType id = new IDType();
			estBasicas.getIdentificador(terminoDePago.getID(), id);
			condicionesDePago.setID(id);
		}

		if (terminoDePago.getIDMedioPago() != null) {

			PaymentMeansIDType iDMedioPago = new PaymentMeansIDType();
			estBasicas.getIdentificador(terminoDePago.getIDMedioPago(), iDMedioPago);
			condicionesDePago.setPaymentMeansID(iDMedioPago);
		}

		if (terminoDePago.getPeriodoPenalizacion() != null) {

			PeriodType periodoPenalizacion = new PeriodType();
			estBasicas.getPeriodo(terminoDePago.getPeriodoPenalizacion(), periodoPenalizacion);
			condicionesDePago.setPenaltyPeriod(periodoPenalizacion);
		}

		if (terminoDePago.getPorcentajeRecargoPenal() != null) {
			PenaltySurchargePercentType porcentajeRecargoPenal = new PenaltySurchargePercentType();
			porcentajeRecargoPenal.setValue(terminoDePago.getPorcentajeRecargoPenal());
			condicionesDePago.setPenaltySurchargePercent(porcentajeRecargoPenal);

		}

		if (terminoDePago.getIDReferenciaPagoPrepago() != null) {
			PrepaidPaymentReferenceIDType iDReferenciaPagoPrepago = new PrepaidPaymentReferenceIDType();
			estBasicas.getIdentificador(terminoDePago.getIDReferenciaPagoPrepago(), iDReferenciaPagoPrepago);
			condicionesDePago.setPrepaidPaymentReferenceID(iDReferenciaPagoPrepago);

		}

		if (terminoDePago.getCodigoReferenciaEvento() != null) {

			ReferenceEventCodeType codigoReferenciaEvento = new ReferenceEventCodeType();
			estBasicas.getCodigo(terminoDePago.getCodigoReferenciaEvento(), codigoReferenciaEvento);
			condicionesDePago.setReferenceEventCode(codigoReferenciaEvento);
		}

		if (terminoDePago.getPorcentajeDescuentoLiquidacion() != null) {
			SettlementDiscountPercentType porcentajeDescuentoLiquidacion = new SettlementDiscountPercentType();
			porcentajeDescuentoLiquidacion.setValue(terminoDePago.getPorcentajeDescuentoLiquidacion());
			condicionesDePago.setSettlementDiscountPercent(porcentajeDescuentoLiquidacion);

		}

		if (terminoDePago.getPeriodoLiquidacion() != null) {

			PeriodType periodoLiquidacion = new PeriodType();
			estBasicas.getPeriodo(terminoDePago.getPeriodoLiquidacion(), periodoLiquidacion);
			condicionesDePago.setSettlementPeriod(periodoLiquidacion);
		}

		if (terminoDePago.getNota() != null) {
			for (TipoTexto notas : terminoDePago.getNota()) {
				NoteType nota = new NoteType();
				estBasicas.getTexto(notas, nota);
				condicionesDePago.getNote().add(nota);

			}

		}

		return condicionesDePago;
	}

	public PaymentType getPagoAnticipado(TipoPago pagoAnticipado) {

		PaymentType anticipo = new PaymentType();
		if (pagoAnticipado.getID() != null) {

			IDType id = new IDType();
			estBasicas.getIdentificador(pagoAnticipado.getID(), id);
			anticipo.setID(id);
		}

		if (pagoAnticipado.getOrdenID() != null) {
			InstructionIDType ordenID = new InstructionIDType();
			estBasicas.getIdentificador(pagoAnticipado.getOrdenID(), ordenID);
			anticipo.setInstructionID(ordenID);

		}

		if (pagoAnticipado.getMontoPagado() != null) {
			PaidAmountType montoPagado = new PaidAmountType();
			estBasicas.getMonto(pagoAnticipado.getMontoPagado(), montoPagado);
			anticipo.setPaidAmount(montoPagado);

		}

		if (pagoAnticipado.getFechaPago() != null) {
			PaidDateType fechaPago = new PaidDateType();
			fechaPago.setValue(pagoAnticipado.getFechaPago());
			anticipo.setPaidDate(fechaPago);
		}

		if (pagoAnticipado.getHoraPago() != null) {
			PaidTimeType horaPago = new PaidTimeType();
			horaPago.setValue(pagoAnticipado.getHoraPago());
			anticipo.setPaidTime(horaPago);

		}

		if (pagoAnticipado.getFechaRecibido() != null) {

			ReceivedDateType fechaRecibido = new ReceivedDateType();
			fechaRecibido.setValue(pagoAnticipado.getFechaRecibido());
			anticipo.setReceivedDate(fechaRecibido);
		}

		return anticipo;
	}

	public AllowanceChargeType getCargo(TipoCargo cargo) {

		AllowanceChargeType c = new AllowanceChargeType();
		if (cargo.getCostoContable() != null) {

			AccountingCostType CostoContable = new AccountingCostType();
			estBasicas.getTexto(cargo.getCostoContable(), CostoContable);
			c.setAccountingCost(CostoContable);
		}

		if (cargo.getCodigoCostoContable() != null) {

			AccountingCostCodeType CodigoCostoContable = new AccountingCostCodeType();
			estBasicas.getCodigo(cargo.getCodigoCostoContable(), CodigoCostoContable);
			c.setAccountingCostCode(CodigoCostoContable);
		}

		if (cargo.getRazonAsignacionCargo() != null) {
			AllowanceChargeReasonType RazonAsignacionCargo = new AllowanceChargeReasonType();
			estBasicas.getTexto(cargo.getRazonAsignacionCargo(), RazonAsignacionCargo);
			c.setAllowanceChargeReason(RazonAsignacionCargo);

		}

		if (cargo.getCodigoRazonAsignacionCargo() != null) {
			AllowanceChargeReasonCodeType CodigoRazonAsignacionCargo = new AllowanceChargeReasonCodeType();
			estBasicas.getCodigo(cargo.getCodigoRazonAsignacionCargo(), CodigoRazonAsignacionCargo);
			c.setAllowanceChargeReasonCode(CodigoRazonAsignacionCargo);

		}

		if (cargo.getMonto() != null) {

			AmountType monto = new AmountType();
			estBasicas.getMonto(cargo.getMonto(), monto);
			c.setAmount(monto);
		}

		if (cargo.getMontoBase() != null) {

			BaseAmountType MontoBase = new BaseAmountType();
			estBasicas.getMonto(cargo.getMontoBase(), MontoBase);
			c.setBaseAmount(MontoBase);
		}

		if (cargo.isIndicadorCarga()) {
			ChargeIndicatorType IndicadorCarga = new ChargeIndicatorType();
			IndicadorCarga.setValue(cargo.isIndicadorCarga());
			c.setChargeIndicator(IndicadorCarga);

		}

		if (cargo.getID() != null) {

			IDType id = new IDType();
			estBasicas.getIdentificador(cargo.getID(), id);
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

			c.setTaxTotal(estBasicas.getImpues(cargo.getImpuestoTotal()));
		}

		if (!cargo.getMedioPago().isEmpty() && cargo.getMedioPago() != null) {
			for (TipoMedioPago medioPago : cargo.getMedioPago()) {
				PaymentMeansType MedioPago = new PaymentMeansType();
				estBasicas.getMedioDePago(medioPago, MedioPago);
				c.getPaymentMeans().add(MedioPago);
			}

		}

		if (!cargo.getCategoriaImpuesto().isEmpty() && cargo.getCategoriaImpuesto() != null) {

			for (TipoImpuestoCategoria impuestos : cargo.getCategoriaImpuesto()) {
				c.getTaxCategory().add(estBasicas.getImpuestoCategoria(impuestos));
			}
		}

		return c;
	}

	public ExchangeRateType getTasaCambioPago(TipoTasaCambio tasaCambioPago) {

		ExchangeRateType tasaDeCambio = new ExchangeRateType();
		if (tasaCambioPago.getTasaCalculada() != null) {
			CalculationRateType tasaCalculada = new CalculationRateType();
			tasaCalculada.setValue(tasaCambioPago.getTasaCalculada());
			tasaDeCambio.setCalculationRate(tasaCalculada);
		}

		if (tasaCambioPago.getFecha() != null) {

			DateType fecha = new DateType();
			fecha.setValue(tasaCambioPago.getFecha());
			tasaDeCambio.setDate(fecha);
		}

		if (tasaCambioPago.getIDIntercambioMercado() != null) {
			ExchangeMarketIDType iDIntercambioMercado = new ExchangeMarketIDType();
			estBasicas.getIdentificador(tasaCambioPago.getIDIntercambioMercado(), iDIntercambioMercado);
			tasaDeCambio.setExchangeMarketID(iDIntercambioMercado);

		}

		if (tasaCambioPago.getContratoMonedaExtranjera() != null) {
			tasaDeCambio.setForeignExchangeContract(
					getContratoMonedaExtranjera(tasaCambioPago.getContratoMonedaExtranjera()));

		}

		if (tasaCambioPago.getCodigoOperadorMatematico() != null) {
			MathematicOperatorCodeType codigoOperadorMatematico = new MathematicOperatorCodeType();
			estBasicas.getCodigo(tasaCambioPago.getCodigoOperadorMatematico(), codigoOperadorMatematico);
			tasaDeCambio.setMathematicOperatorCode(codigoOperadorMatematico);

		}

		if (tasaCambioPago.getTasaBaseModenaFuente() != null) {

			SourceCurrencyBaseRateType tasaBaseModenaFuente = new SourceCurrencyBaseRateType();
			tasaBaseModenaFuente.setValue(tasaCambioPago.getTasaBaseModenaFuente());
			tasaDeCambio.setSourceCurrencyBaseRate(tasaBaseModenaFuente);
		}

		if (tasaCambioPago.getCodigoMonedaFuente() != null) {

			SourceCurrencyCodeType codigoMoneda = new SourceCurrencyCodeType();
			estBasicas.getCodigo(tasaCambioPago.getCodigoMonedaFuente(), codigoMoneda);
			tasaDeCambio.setSourceCurrencyCode(codigoMoneda);
		}

		if (tasaCambioPago.getTasaBaseMonedaObjetivo() != null) {
			TargetCurrencyBaseRateType tasaBaseMonedaObjetivo = new TargetCurrencyBaseRateType();
			tasaBaseMonedaObjetivo.setValue(tasaCambioPago.getTasaBaseMonedaObjetivo());
			tasaDeCambio.setTargetCurrencyBaseRate(tasaBaseMonedaObjetivo);

		}

		if (tasaCambioPago.getCodigoMonedaObjetivo() != null) {
			TargetCurrencyCodeType codigoMonedaObjetivo = new TargetCurrencyCodeType();
			estBasicas.getCodigo(tasaCambioPago.getCodigoMonedaObjetivo(), codigoMonedaObjetivo);
			tasaDeCambio.setTargetCurrencyCode(codigoMonedaObjetivo);

		}

		return tasaDeCambio;
	}

	private ContractType getContratoMonedaExtranjera(TipoContrato contratoMonedaExtranjera) {

		ContractType monedaExtranjera = new ContractType();
		if (contratoMonedaExtranjera.getTipoContrato() != null) {

			ContractTypeType TipoContrato = new ContractTypeType();
			estBasicas.getTexto(contratoMonedaExtranjera.getTipoContrato(), TipoContrato);
			monedaExtranjera.setContractType(TipoContrato);
		}

		if (contratoMonedaExtranjera.getTipoCodigoContrato() != null) {

			ContractTypeCodeType TipoCodigoContrato = new ContractTypeCodeType();
			estBasicas.getCodigo(contratoMonedaExtranjera.getTipoCodigoContrato(), TipoCodigoContrato);
			monedaExtranjera.setContractTypeCode(TipoCodigoContrato);
		}

		if (contratoMonedaExtranjera.getID() != null) {

			IDType id = new IDType();
			estBasicas.getIdentificador(contratoMonedaExtranjera.getID(), id);
			monedaExtranjera.setID(id);
		}

		if (contratoMonedaExtranjera.getFechaEmision() != null) {
			IssueDateType FechaEmision = new IssueDateType();
			FechaEmision.setValue(contratoMonedaExtranjera.getFechaEmision());
			monedaExtranjera.setIssueDate(FechaEmision);

		}

		if (contratoMonedaExtranjera.getHoraEmision() != null) {

			IssueTimeType HoraEmision = new IssueTimeType();
			HoraEmision.setValue(contratoMonedaExtranjera.getHoraEmision());
			monedaExtranjera.setIssueTime(HoraEmision);
		}

		if (contratoMonedaExtranjera.getPeriodoValidez() != null) {

			PeriodType PeriodoValidez = new PeriodType();
			estBasicas.getPeriodo(contratoMonedaExtranjera.getPeriodoValidez(), PeriodoValidez);
			monedaExtranjera.setValidityPeriod(PeriodoValidez);
		}

		if (!contratoMonedaExtranjera.getDocumentoReferenciaContrato().isEmpty()
				&& contratoMonedaExtranjera.getDocumentoReferenciaContrato() != null) {

			for (TipoDocumentoReferencia contrato : contratoMonedaExtranjera.getDocumentoReferenciaContrato()) {

				monedaExtranjera.getContractDocumentReference().add(estBasicas.getDocumentoReferencia(contrato));
			}
		}

		return monedaExtranjera;
	}

	public TaxTotalType getTotalImpuesto(TipoImpuestoTotal totalImpuesto) {

		TaxTotalType impuestos = new TaxTotalType();
		if (totalImpuesto.getMontoRedondeado() != null) {
			RoundingAmountType montoRedondeado = new RoundingAmountType();
			estBasicas.getMonto(totalImpuesto.getMontoRedondeado(), montoRedondeado);
			impuestos.setRoundingAmount(montoRedondeado);

		}

		if (totalImpuesto.getMontoImpuesto() != null) {
			TaxAmountType montoImpuesto = new TaxAmountType();
			estBasicas.getMonto(totalImpuesto.getMontoImpuesto(), montoImpuesto);
			impuestos.setTaxAmount(montoImpuesto);

		}

		TaxEvidenceIndicatorType indicadorEvidenciaImpuesto = new TaxEvidenceIndicatorType();
		indicadorEvidenciaImpuesto.setValue(totalImpuesto.isIndicadorEvidenciaImpuesto());
		impuestos.setTaxEvidenceIndicator(indicadorEvidenciaImpuesto);

		if (!totalImpuesto.getSubtotalImpuesto().isEmpty() && totalImpuesto.getSubtotalImpuesto() != null) {

			for (TipoSubtotalImpuesto impuesto : totalImpuesto.getSubtotalImpuesto()) {
				impuestos.getTaxSubtotal().add(estBasicas.getSubtotalImpuesto(impuesto));

			}
		}

		return impuestos;
	}

	private oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType getTotalImpuesto2(
			TipoImpuestoTotal totalImpuesto) {
		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType impuestos = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType();
		if (totalImpuesto.getMontoRedondeado() != null) {
			RoundingAmountType montoRedondeado = new RoundingAmountType();
			estBasicas.getMonto(totalImpuesto.getMontoRedondeado(), montoRedondeado);
			impuestos.setRoundingAmount(montoRedondeado);

		}

		if (totalImpuesto.getMontoImpuesto() != null) {

			TaxAmountType montoImpuesto = new TaxAmountType();
			estBasicas.getMonto(totalImpuesto.getMontoImpuesto(), montoImpuesto);
			impuestos.setTaxAmount(montoImpuesto);
		}

		TaxEvidenceIndicatorType indicadorEvidenciaImpuesto = new TaxEvidenceIndicatorType();
		indicadorEvidenciaImpuesto.setValue(totalImpuesto.isIndicadorEvidenciaImpuesto());
		impuestos.setTaxEvidenceIndicator(indicadorEvidenciaImpuesto);

		if (!totalImpuesto.getSubtotalImpuesto().isEmpty() && totalImpuesto.getSubtotalImpuesto() != null) {

			for (TipoSubtotalImpuesto impuesto : totalImpuesto.getSubtotalImpuesto()) {
				impuestos.getTaxSubtotal().add(getSubtotalImpuesto2(impuesto));

			}
		}

		return impuestos;

	}

	private oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSubtotalType getSubtotalImpuesto2(
			TipoSubtotalImpuesto impuesto) {

		oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSubtotalType subTotalImpuestos = new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSubtotalType();
		if (impuesto.getBaseUnidadMedida() != null) {

			BaseUnitMeasureType baseUnidadMedida = new BaseUnitMeasureType();
			estBasicas.getMedida(impuesto.getBaseUnidadMedida(), baseUnidadMedida);
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
			estBasicas.getMonto(impuesto.getMontoPorUnidad(), montoPorUnidad);
			subTotalImpuestos.setPerUnitAmount(montoPorUnidad);
		}

		if (impuesto.getMontoGravable() != null) {
			TaxableAmountType montoGravable = new TaxableAmountType();
			estBasicas.getMonto(impuesto.getMontoGravable(), montoGravable);
			subTotalImpuestos.setTaxableAmount(montoGravable);

		}

		if (impuesto.getMontoImpuesto() != null) {
			TaxAmountType montoImpuesto = new TaxAmountType();
			estBasicas.getMonto(impuesto.getMontoImpuesto(), montoImpuesto);
			subTotalImpuestos.setTaxAmount(montoImpuesto);

		}

		if (impuesto.getImpuestoCategoria() != null) {

			subTotalImpuestos.setTaxCategory(estBasicas.getImpuestoCategoria(impuesto.getImpuestoCategoria()));

		}
		if (impuesto.getNivelRango() != null) {
			TierRangeType nivelRango = new TierRangeType();
			estBasicas.getTexto(impuesto.getNivelRango(), nivelRango);
			subTotalImpuestos.setTierRange(nivelRango);

		}

		if (impuesto.getPorcentajeNivelRango() != null) {

			TierRatePercentType porcentajeNivelRango = new TierRatePercentType();
			porcentajeNivelRango.setValue(impuesto.getPorcentajeNivelRango());
			subTotalImpuestos.setTierRatePercent(porcentajeNivelRango);
		}

		if (impuesto.getMontoImpuestoMonedaTransaccion() != null) {
			TransactionCurrencyTaxAmountType montoImpuestoMonedaTransaccion = new TransactionCurrencyTaxAmountType();
			estBasicas.getMonto(impuesto.getMontoImpuestoMonedaTransaccion(), montoImpuestoMonedaTransaccion);
			subTotalImpuestos.setTransactionCurrencyTaxAmount(montoImpuestoMonedaTransaccion);

		}

		return subTotalImpuestos;
	}

	public MonetaryTotalType getTotales(TipoTotalMonetarioLegal totales) {

		MonetaryTotalType total = new MonetaryTotalType();
		if (totales.getMontoTotalPermitido() != null) {
			AllowanceTotalAmountType montoTotalPermitido = new AllowanceTotalAmountType();
			estBasicas.getMonto(totales.getMontoTotalPermitido(), montoTotalPermitido);
			total.setAllowanceTotalAmount(montoTotalPermitido);

		}

		if (totales.getMontoTotalCargado() != null) {
			ChargeTotalAmountType montoTotalCargado = new ChargeTotalAmountType();
			estBasicas.getMonto(totales.getMontoTotalCargado(), montoTotalCargado);
			total.setChargeTotalAmount(montoTotalCargado);

		}

		if (totales.getMontoExtensionLinea() != null) {

			LineExtensionAmountType montoExtensionLinea = new LineExtensionAmountType();
			estBasicas.getMonto(totales.getMontoExtensionLinea(), montoExtensionLinea);
			total.setLineExtensionAmount(montoExtensionLinea);
		}

		if (totales.getMontoPagado() != null) {

			PayableAmountType montoPagado = new PayableAmountType();
			estBasicas.getMonto(totales.getMontoPagado(), montoPagado);
			total.setPayableAmount(montoPagado);
		}

		if (totales.getMontoRedondeadoPagado() != null) {

			PayableRoundingAmountType montoRedondeadoPagado = new PayableRoundingAmountType();
			estBasicas.getMonto(totales.getMontoRedondeadoPagado(), montoRedondeadoPagado);
			total.setPayableRoundingAmount(montoRedondeadoPagado);
		}

		if (totales.getMontoPagadoPorAdelantado() != null) {

			PrepaidAmountType montoPagadoPorAdelantado = new PrepaidAmountType();
			estBasicas.getMonto(totales.getMontoPagadoPorAdelantado(), montoPagadoPorAdelantado);
			total.setPrepaidAmount(montoPagadoPorAdelantado);
		}

		if (totales.getMontoExclusivoImpuesto() != null) {
			TaxExclusiveAmountType montoExclusivoImpuesto = new TaxExclusiveAmountType();
			estBasicas.getMonto(totales.getMontoExclusivoImpuesto(), montoExclusivoImpuesto);
			total.setTaxExclusiveAmount(montoExclusivoImpuesto);

		}

		if (totales.getMontoIncluyendoImpuesto() != null) {

			TaxInclusiveAmountType montoIncluyendoImpuesto = new TaxInclusiveAmountType();
			estBasicas.getMonto(totales.getMontoIncluyendoImpuesto(), montoIncluyendoImpuesto);
			total.setTaxInclusiveAmount(montoIncluyendoImpuesto);
		}

		return total;
	}

	public InvoiceLineType getDetalleFactura(TipoDetalleFactura detalleFactura) {

		InvoiceLineType detalle = new InvoiceLineType();
		if (detalleFactura.getID() != null) {

			IDType id = new IDType();
			estBasicas.getIdentificador(detalleFactura.getID(), id);
			detalle.setID(id);
		}

		if (detalleFactura.getUUID() != null) {
			UUIDType uuid = new UUIDType();
			estBasicas.getIdentificador(detalleFactura.getUUID(), uuid);
			detalle.setUUID(uuid);

		}

		if (detalleFactura.getNota() != null) {
			NoteType nota = new NoteType();
			estBasicas.getTexto(detalleFactura.getNota(), nota);
			detalle.setNote(nota);

		}

		if (detalleFactura.getCantidadFactura() != null) {
			InvoicedQuantityType cantidadFactura = new InvoicedQuantityType();
			estBasicas.getCantidad(detalleFactura.getCantidadFactura(), cantidadFactura);
			detalle.setInvoicedQuantity(cantidadFactura);

		}

		if (detalleFactura.getMontoLineaExtension() != null) {

			LineExtensionAmountType montoLineaExtension = new LineExtensionAmountType();
			estBasicas.getMonto(detalleFactura.getMontoLineaExtension(), montoLineaExtension);
			detalle.setLineExtensionAmount(montoLineaExtension);
		}

		if (detalleFactura.getFechaImpuesto() != null) {
			TaxPointDateType fechaImpuesto = new TaxPointDateType();
			fechaImpuesto.setValue(detalleFactura.getFechaImpuesto());
			detalle.setTaxPointDate(fechaImpuesto);

		}

		if (detalleFactura.getCodigoCosteContable() != null) {

			AccountingCostCodeType codigoCosteContable = new AccountingCostCodeType();
			estBasicas.getCodigo(detalleFactura.getCodigoCosteContable(), codigoCosteContable);
			detalle.setAccountingCostCode(codigoCosteContable);
		}

		if (detalleFactura.getCostoContable() != null) {

			AccountingCostType costoContable = new AccountingCostType();
			estBasicas.getTexto(detalleFactura.getCostoContable(), costoContable);
			detalle.setAccountingCost(costoContable);
		}

		if (detalleFactura.isIndicadorSinCargo() != null) {
			FreeOfChargeIndicatorType indicadorSinCargo = new FreeOfChargeIndicatorType();
			indicadorSinCargo.setValue(detalleFactura.isIndicadorSinCargo());
			detalle.setFreeOfChargeIndicator(indicadorSinCargo);

		}

		if (!detalleFactura.getReferenciaLineaPedido().isEmpty() && detalleFactura.getReferenciaLineaPedido() != null) {

			for (TipoReferenciaLineaPedido linea : detalleFactura.getReferenciaLineaPedido()) {
				detalle.getOrderLineReference().add(estBasicas.getReferenciaLineaPedido(linea));
			}
		}

		if (!detalleFactura.getLineaReferenciaEnvio().isEmpty() && detalleFactura.getLineaReferenciaEnvio() != null) {

			for (TipoLineaReferencia lineaReferencia : detalleFactura.getLineaReferenciaEnvio()) {
				detalle.getDespatchLineReference().add(estBasicas.getLineaReferencia(lineaReferencia));
			}
		}

		if (!detalleFactura.getReferenciaLineaRecepcion().isEmpty()
				&& detalleFactura.getReferenciaLineaRecepcion() != null) {

			for (TipoLineaReferencia lineaRef : detalleFactura.getReferenciaLineaRecepcion()) {
				detalle.getReceiptLineReference().add(estBasicas.getLineaReferencia(lineaRef));
			}
		}

		if (!detalleFactura.getReferenciaFactura().isEmpty() && detalleFactura.getReferenciaFactura() != null) {
			for (TipoReferenciaFactura refFactura : detalleFactura.getReferenciaFactura()) {
				detalle.getBillingReference().add(estBasicas.getReferenciaFactura(refFactura));
			}

		}

		if (!detalleFactura.getReferenciaDocumento().isEmpty() && detalleFactura.getReferenciaDocumento() != null) {
			for (TipoDocumentoReferencia referenciaDocumento : detalleFactura.getReferenciaDocumento()) {
				detalle.getDocumentReference().add(estBasicas.getDocumentoReferencia(referenciaDocumento));
			}

		}

		if (detalleFactura.getReferenciaPrecios() != null) {

			detalle.setPricingReference(estBasicas.getReferenciaPrecios(detalleFactura.getReferenciaPrecios()));

		}
		if (detalleFactura.getTerceroOriginador() != null) {
			detalle.setOriginatorParty(estBasicas.getTercero(detalleFactura.getTerceroOriginador()));

		}
		if (!detalleFactura.getEntrega().isEmpty() && detalleFactura.getEntrega() != null) {
			for (TipoEntrega entregad : detalleFactura.getEntrega()) {
				detalle.getDelivery().add(getCondicionesDeEntrega2(entregad));

			}

		}

		if (!detalleFactura.getCondicionesPago().isEmpty() && detalleFactura.getCondicionesPago() != null) {

			for (TipoTerminosPago terminosDePago : detalleFactura.getCondicionesPago()) {
				detalle.getPaymentTerms().add(getTerminoDePago(terminosDePago));
			}
		}

		if (!detalleFactura.getCargo().isEmpty() && detalleFactura.getCargo() != null) {
			for (TipoCargo cargo : detalleFactura.getCargo()) {
				detalle.getAllowanceCharge().add(estBasicas.getCargos(cargo));
			}

		}

		if (detalleFactura.getImpuestoTotal() != null) {
			for (TipoImpuestoTotal totalImpuesto : detalleFactura.getImpuestoTotal()) {

				detalle.getTaxTotal().add(getTotalImpuesto2(totalImpuesto));
			}
		}

		if (detalleFactura.getArticulo() != null) {

			detalle.setItem(getArticulo(detalleFactura.getArticulo()));

		}
		if (detalleFactura.getPrecio() != null) {

			detalle.setPrice(estBasicas.getPrecio(detalleFactura.getPrecio()));

		}
		if (detalleFactura.getTerminosEntrega() != null) {

			detalle.setDeliveryTerms(getTerminosEntrega2(detalleFactura.getTerminosEntrega()));

		}

		return detalle;
	}

	private ItemType getArticulo(TipoArticulo articulo) {

		ItemType item = new ItemType();
		if (!articulo.getDescripcion().isEmpty() && articulo.getDescripcion() != null) {
			for (TipoTexto descripciones : articulo.getDescripcion()) {
				DescriptionType descripcion = new DescriptionType();
				estBasicas.getTexto(descripciones, descripcion);
				item.getDescription().add(descripcion);
			}

		}

		if (articulo.getCantidadPaquete() != null) {
			PackQuantityType cantidadPaquete = new PackQuantityType();
			estBasicas.getCantidad(articulo.getCantidadPaquete(), cantidadPaquete);
			item.setPackQuantity(cantidadPaquete);

		}

		if (articulo.getTamanoNumericoPaquete() != null) {
			PackSizeNumericType tamanoNumericoPaquete = new PackSizeNumericType();
			tamanoNumericoPaquete.setValue(articulo.getTamanoNumericoPaquete());
			item.setPackSizeNumeric(tamanoNumericoPaquete);

		}

		if (articulo.isIndicadorCatalogo() != null) {
			CatalogueIndicatorType indicadorCatalogo = new CatalogueIndicatorType();
			indicadorCatalogo.setValue(articulo.isIndicadorCatalogo());
			item.setCatalogueIndicator(indicadorCatalogo);

		}

		if (articulo.getNombre() != null) {
			NameType nombre = new NameType();
			estBasicas.getNombre(articulo.getNombre(), nombre);
			item.setName(nombre);

		}

		if (articulo.isIndicadorRiesgo() != null) {

			HazardousRiskIndicatorType indicadorRiesgo = new HazardousRiskIndicatorType();
			indicadorRiesgo.setValue(articulo.isIndicadorRiesgo());
			item.setHazardousRiskIndicator(indicadorRiesgo);
		}

		if (articulo.getInformacionAdicional() != null) {

			AdditionalInformationType informacionAdicional = new AdditionalInformationType();
			estBasicas.getTexto(articulo.getInformacionAdicional(), informacionAdicional);
			item.setAdditionalInformation(informacionAdicional);
		}

		if (!articulo.getPalabraClave().isEmpty() && articulo.getPalabraClave() != null) {

			for (TipoTexto key : articulo.getPalabraClave()) {
				KeywordType palabraClave = new KeywordType();
				estBasicas.getTexto(key, palabraClave);
				item.getKeyword().add(palabraClave);
			}
		}

		if (!articulo.getMarca().isEmpty() && articulo.getMarca() != null) {

			for (String marc : articulo.getMarca()) {
				BrandNameType marca = new BrandNameType();
				estBasicas.getNombre(marc, marca);
				item.getBrandName().add(marca);

			}
		}

		if (!articulo.getNombreModelo().isEmpty() && articulo.getNombreModelo() != null) {
			for (String marc : articulo.getNombreModelo()) {
				ModelNameType nombreModelo = new ModelNameType();
				estBasicas.getNombre(marc, nombreModelo);
				item.getModelName().add(nombreModelo);
			}

		}

		if (articulo.getIdentificacionArticuloVendedores() != null) {

			item.setBuyersItemIdentification(
					estBasicas.getIdentificacionArticulos(articulo.getIdentificacionArticuloVendedores()));
		}

		if (articulo.getIdentificacionArticulosCompradores() != null) {

			item.setSellersItemIdentification(
					estBasicas.getIdentificacionArticulos(articulo.getIdentificacionArticulosCompradores()));
		}

		if (articulo.getIdentificacionArticuloVendedores() != null) {

			item.getManufacturersItemIdentification()
					.add(estBasicas.getIdentificacionArticulos(articulo.getIdentificacionArticuloVendedores()));
		}

		if (articulo.getIdentificacionArticuloEstandar() != null) {
			item.setStandardItemIdentification(
					estBasicas.getIdentificacionArticulos(articulo.getIdentificacionArticuloEstandar()));

		}

		if (articulo.getIdentificacionArticuloCatalogo() != null) {
			item.setCatalogueItemIdentification(
					estBasicas.getIdentificacionArticulos(articulo.getIdentificacionArticuloCatalogo()));

		}

		if (!articulo.getIdentificacionArticuloAdicional().isEmpty()
				&& articulo.getIdentificacionArticuloAdicional() != null) {
			for (TipoIdentificacionArticulos art : articulo.getIdentificacionArticuloAdicional()) {
				item.getAdditionalItemIdentification().add(estBasicas.getIdentificacionArticulos(art));
			}

		}

		if (articulo.getDocumentoRefereciaCatalogo() != null) {

			item.setCatalogueDocumentReference(
					estBasicas.getDocumentoReferencia(articulo.getDocumentoRefereciaCatalogo()));

		}
		if (!articulo.getReferenciaDocumentoEspecificacionArticulo().isEmpty()
				&& articulo.getReferenciaDocumentoEspecificacionArticulo() != null) {

			for (TipoDocumentoReferencia ref : articulo.getReferenciaDocumentoEspecificacionArticulo()) {
				item.getItemSpecificationDocumentReference().add(estBasicas.getDocumentoReferencia(ref));
			}
		}

		if (articulo.getPaisOrigen() != null) {

			item.setOriginCountry(estBasicas.getPais(articulo.getPaisOrigen()));

		}
		if (!articulo.getClasificacionMercancia().isEmpty() && articulo.getClasificacionMercancia() != null) {

			for (TipoClasificacionMercancia clasificacion : articulo.getClasificacionMercancia()) {
				item.getCommodityClassification().add(estBasicas.getClasificacionMercancia(clasificacion));
			}
		}

		if (!articulo.getCondicionesTransaccion().isEmpty() && articulo.getCondicionesTransaccion() != null) {

			for (TipoCondicionesTransaccion tran : articulo.getCondicionesTransaccion()) {
				item.getTransactionConditions().add(estBasicas.getCondicionesTransaccion(tran));
			}
		}

		if (!articulo.getArticuloPeligroso().isEmpty() && articulo.getArticuloPeligroso() != null) {

			for (TipoArticuloPeligroso articulos : articulo.getArticuloPeligroso()) {
				item.getHazardousItem().add(estBasicas.getArticuloPeligroso(articulos));
			}
		}

		if (!articulo.getCategoriaImpuestoClasificado().isEmpty()
				&& articulo.getCategoriaImpuestoClasificado() != null) {

			for (TipoImpuestoCategoria categoriaImp : articulo.getCategoriaImpuestoClasificado()) {
				item.getClassifiedTaxCategory().add(estBasicas.getImpuestoCategoria(categoriaImp));
			}
		}

		if (!articulo.getPropiedadArticuloAdicional().isEmpty() && articulo.getPropiedadArticuloAdicional() != null) {
			for (TipoPropiedadArticulo artAdicional : articulo.getPropiedadArticuloAdicional()) {
				item.getAdditionalItemProperty().add(estBasicas.getPropiedadArticuloAdicional(artAdicional));

			}

		}

		if (!articulo.getTerceroFabricante().isEmpty() && articulo.getTerceroFabricante() != null) {

			for (TipoTercero tercefav : articulo.getTerceroFabricante()) {
				item.getManufacturerParty().add(estBasicas.getTercero(tercefav));
			}
		}

		if (articulo.getTerceroProveedorContenidoInformacion() != null) {

			item.setInformationContentProviderParty(
					estBasicas.getTercero(articulo.getTerceroProveedorContenidoInformacion()));
		}

		if (!articulo.getDireccionOriginal().isEmpty() && articulo.getDireccionOriginal() != null) {
			for (TipoDireccion dir : articulo.getDireccionOriginal()) {
				item.getOriginAddress().add(getDireccion(dir));
			}

		}

		if (!articulo.getInstanciaArticulo().isEmpty() && articulo.getInstanciaArticulo() != null) {

			for (TipoInstanciaArticulo instArticulo : articulo.getInstanciaArticulo()) {
				item.getItemInstance().add(estBasicas.getInstanciaArticulo(instArticulo));
			}
		}

		return item;
	}
}
