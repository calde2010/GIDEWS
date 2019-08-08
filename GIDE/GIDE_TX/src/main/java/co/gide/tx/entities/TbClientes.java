/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gide.tx.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lcalderon
 */
@Entity
@Table(name = "tb_clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbClientes.findAll", query = "SELECT t FROM TbClientes t")
    , @NamedQuery(name = "TbClientes.findByIdPersona", query = "SELECT t FROM TbClientes t WHERE t.idPersona = :idPersona")
    , @NamedQuery(name = "TbClientes.findByIdTipoIdentificacion", query = "SELECT t FROM TbClientes t WHERE t.idTipoIdentificacion = :idTipoIdentificacion")
    , @NamedQuery(name = "TbClientes.findByIdTipoPersona", query = "SELECT t FROM TbClientes t WHERE t.idTipoPersona = :idTipoPersona")
    , @NamedQuery(name = "TbClientes.findByNumIdentificacion", query = "SELECT t FROM TbClientes t WHERE t.numIdentificacion = :numIdentificacion")
    , @NamedQuery(name = "TbClientes.findByRazonSocial", query = "SELECT t FROM TbClientes t WHERE t.razonSocial = :razonSocial")
    , @NamedQuery(name = "TbClientes.findByApellidos", query = "SELECT t FROM TbClientes t WHERE t.apellidos = :apellidos")
    , @NamedQuery(name = "TbClientes.findByNombres", query = "SELECT t FROM TbClientes t WHERE t.nombres = :nombres")
    , @NamedQuery(name = "TbClientes.findByFechaInicioVig", query = "SELECT t FROM TbClientes t WHERE t.fechaInicioVig = :fechaInicioVig")
    , @NamedQuery(name = "TbClientes.findByFechaFinVig", query = "SELECT t FROM TbClientes t WHERE t.fechaFinVig = :fechaFinVig")
    , @NamedQuery(name = "TbClientes.findByEMail", query = "SELECT t FROM TbClientes t WHERE t.eMail = :eMail")
    , @NamedQuery(name = "TbClientes.findByTelefono", query = "SELECT t FROM TbClientes t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "TbClientes.findByUsuario", query = "SELECT t FROM TbClientes t WHERE t.usuario = :usuario")
    , @NamedQuery(name = "TbClientes.findByToken", query = "SELECT t FROM TbClientes t WHERE t.token = :token")})
public class TbClientes implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona", updatable = false, nullable = false)
    private Integer idPersona;
    @Basic(optional = false)
    @Column(name = "id_tipo_identificacion")
    private String idTipoIdentificacion;
    @Basic(optional = false)
    @Column(name = "id_tipo_persona")
    private String idTipoPersona;
    @Basic(optional = false)
    @Column(name = "num_identificacion")
    private String numIdentificacion;
    @Basic(optional = false)
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "fecha_inicio_vig")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioVig;
    @Basic(optional = false)
    @Column(name = "fecha_fin_vig")
    @Temporal(TemporalType.DATE)
    private Date fechaFinVig;
    @Basic(optional = false)
    @Column(name = "e_mail")
    private String eMail;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "token")
    private String token;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<Localizacion> localizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbClientes")
    private List<TbSwResolCliente> tbSwResolClienteList;

    public TbClientes() {
    }

    public TbClientes(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public void  cargarClientes(  
    		String idTipoIdentificacion,
			    		String idTipoPersona,
			    		String numIdentificacion,
			    		String razonSocial,
			    		String nombres,
			    		Date   fechaInicioVig,
			    		Date   fechaFinVig,
			    		String eMail,
			    		String telefono,
			    		String usuario,
			    		String token) {
        this.idTipoIdentificacion = idTipoIdentificacion;
        this.idTipoPersona = idTipoPersona;
        this.numIdentificacion = numIdentificacion;
        this.razonSocial = razonSocial;
        this.nombres = nombres;
        this.fechaInicioVig = fechaInicioVig;
        this.fechaFinVig = fechaFinVig;
        this.eMail = eMail;
        this.telefono = telefono;
        this.usuario = usuario;
        this.token = token;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getIdTipoIdentificacion() {
        return idTipoIdentificacion;
    }

    public void setIdTipoIdentificacion(String idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    public String getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(String idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getFechaInicioVig() {
        return fechaInicioVig;
    }

    public void setFechaInicioVig(Date fechaInicioVig) {
        this.fechaInicioVig = fechaInicioVig;
    }

    public Date getFechaFinVig() {
        return fechaFinVig;
    }

    public void setFechaFinVig(Date fechaFinVig) {
        this.fechaFinVig = fechaFinVig;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @XmlTransient
    public List<Localizacion> getLocalizacionList() {
        return localizacionList;
    }

    public void setLocalizacionList(List<Localizacion> localizacionList) {
        this.localizacionList = localizacionList;
    }

    @XmlTransient
    public List<TbSwResolCliente> getTbSwResolClienteList() {
        return tbSwResolClienteList;
    }

    public void setTbSwResolClienteList(List<TbSwResolCliente> tbSwResolClienteList) {
        this.tbSwResolClienteList = tbSwResolClienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbClientes)) {
            return false;
        }
        TbClientes other = (TbClientes) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gide.tx.entities.TbClientes[ idPersona=" + idPersona + " ]";
    }
    
}
