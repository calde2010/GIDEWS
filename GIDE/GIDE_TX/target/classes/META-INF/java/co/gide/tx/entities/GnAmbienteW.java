package co.gide.tx.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the gn_ambiente_ws database table.
 * 
 */
@Entity
@Table(name = "gn_ambiente_ws")
@NamedQuery(name = "GnAmbienteW.findAll", query = "SELECT g FROM GnAmbienteW g")
public class GnAmbienteW implements Serializable {
	private static final long serialVersionUID = 1L;

	private String alias;

	private String apellidos;

	@Column(name = "codigo_resolucion_facturacion")
	private Integer codigoResolucionFacturacion;

	private String ctc;

	@Column(name = "desc_tipo_rango")
	private String descTipoRango;

	@Column(name = "e_mail")
	private String eMail;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin_vig")
	private Date fechaFinVig;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_final")
	private Date fechaFinal;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicial")
	private Date fechaInicial;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio_vig")
	private Date fechaInicioVig;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_vigencia_fin")
	private Date fechaVigenciaFin;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_vigencia_ini")
	private Date fechaVigenciaIni;

	@Column(name = "id_persona")
	private Integer idPersona;

	@Column(name = "id_resol_factura")
	private Integer idResolFactura;

	@Column(name = "id_tipo_identificacion")
	private String idTipoIdentificacion;

	@Column(name = "id_tipo_persona")
	private String idTipoPersona;

	@Column(name = "id_tipo_rango")
	private String idTipoRango;

	private String nombres;

	@Column(name = "num_identificacion")
	private String numIdentificacion;

	@Column(name = "numero_final")
	private Integer numeroFinal;

	@Column(name = "numero_inicial")
	private Integer numeroInicial;

	@Column(name = "password_cert_digital")
	private String passwordCertDigital;

	@Column(name = "password_ws")
	private String passwordWs;

	private String pin;

	private String prefijo;

	@Column(name = "razon_social")
	private String razonSocial;

	private String telefono;

	private String token;

	@Column(name = "uri_certificado")
	private String uriCertificado;

	private String url;
	@Id
	private String usuario;

	public GnAmbienteW() {
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getCodigoResolucionFacturacion() {
		return this.codigoResolucionFacturacion;
	}

	public void setCodigoResolucionFacturacion(Integer codigoResolucionFacturacion) {
		this.codigoResolucionFacturacion = codigoResolucionFacturacion;
	}

	public String getCtc() {
		return this.ctc;
	}

	public void setCtc(String ctc) {
		this.ctc = ctc;
	}

	public String getDescTipoRango() {
		return this.descTipoRango;
	}

	public void setDescTipoRango(String descTipoRango) {
		this.descTipoRango = descTipoRango;
	}

	public String getEMail() {
		return this.eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public Date getFechaFinVig() {
		return this.fechaFinVig;
	}

	public void setFechaFinVig(Date fechaFinVig) {
		this.fechaFinVig = fechaFinVig;
	}

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicial() {
		return this.fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaInicioVig() {
		return this.fechaInicioVig;
	}

	public void setFechaInicioVig(Date fechaInicioVig) {
		this.fechaInicioVig = fechaInicioVig;
	}

	public Date getFechaVigenciaFin() {
		return this.fechaVigenciaFin;
	}

	public void setFechaVigenciaFin(Date fechaVigenciaFin) {
		this.fechaVigenciaFin = fechaVigenciaFin;
	}

	public Date getFechaVigenciaIni() {
		return this.fechaVigenciaIni;
	}

	public void setFechaVigenciaIni(Date fechaVigenciaIni) {
		this.fechaVigenciaIni = fechaVigenciaIni;
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Integer getIdResolFactura() {
		return this.idResolFactura;
	}

	public void setIdResolFactura(Integer idResolFactura) {
		this.idResolFactura = idResolFactura;
	}

	public String getIdTipoIdentificacion() {
		return this.idTipoIdentificacion;
	}

	public void setIdTipoIdentificacion(String idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	public String getIdTipoPersona() {
		return this.idTipoPersona;
	}

	public void setIdTipoPersona(String idTipoPersona) {
		this.idTipoPersona = idTipoPersona;
	}

	public String getIdTipoRango() {
		return this.idTipoRango;
	}

	public void setIdTipoRango(String idTipoRango) {
		this.idTipoRango = idTipoRango;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNumIdentificacion() {
		return this.numIdentificacion;
	}

	public void setNumIdentificacion(String numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}

	public Integer getNumeroFinal() {
		return this.numeroFinal;
	}

	public void setNumeroFinal(Integer numeroFinal) {
		this.numeroFinal = numeroFinal;
	}

	public Integer getNumeroInicial() {
		return this.numeroInicial;
	}

	public void setNumeroInicial(Integer numeroInicial) {
		this.numeroInicial = numeroInicial;
	}

	public String getPasswordCertDigital() {
		return this.passwordCertDigital;
	}

	public void setPasswordCertDigital(String passwordCertDigital) {
		this.passwordCertDigital = passwordCertDigital;
	}

	public String getPasswordWs() {
		return this.passwordWs;
	}

	public void setPasswordWs(String passwordWs) {
		this.passwordWs = passwordWs;
	}

	public String getPin() {
		return this.pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPrefijo() {
		return this.prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUriCertificado() {
		return this.uriCertificado;
	}

	public void setUriCertificado(String uriCertificado) {
		this.uriCertificado = uriCertificado;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}