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
@Table(name = "tb_firma_digital")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFirmaDigital.findAll", query = "SELECT t FROM TbFirmaDigital t")
    , @NamedQuery(name = "TbFirmaDigital.findByIdFirma", query = "SELECT t FROM TbFirmaDigital t WHERE t.idFirma = :idFirma")
    , @NamedQuery(name = "TbFirmaDigital.findByAlias", query = "SELECT t FROM TbFirmaDigital t WHERE t.alias = :alias")
    , @NamedQuery(name = "TbFirmaDigital.findByPassword", query = "SELECT t FROM TbFirmaDigital t WHERE t.password = :password")
    , @NamedQuery(name = "TbFirmaDigital.findByUriCertificado", query = "SELECT t FROM TbFirmaDigital t WHERE t.uriCertificado = :uriCertificado")
    , @NamedQuery(name = "TbFirmaDigital.findByFechaVigenciaIni", query = "SELECT t FROM TbFirmaDigital t WHERE t.fechaVigenciaIni = :fechaVigenciaIni")
    , @NamedQuery(name = "TbFirmaDigital.findByFechaVigenciaFin", query = "SELECT t FROM TbFirmaDigital t WHERE t.fechaVigenciaFin = :fechaVigenciaFin")})
public class TbFirmaDigital implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_firma")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private Integer idFirma;
    @Basic(optional = false)
    @Column(name = "alias")
    private String alias;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "uri_certificado")
    private String uriCertificado;
    @Basic(optional = false)
    @Column(name = "fecha_vigencia_ini")
    @Temporal(TemporalType.DATE)
    private Date fechaVigenciaIni;
    @Basic(optional = false)
    @Column(name = "fecha_vigencia_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaVigenciaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbFirmaDigital")
    private List<TbSwResolCliente> tbSwResolClienteList;

    public TbFirmaDigital() {
    }

    public TbFirmaDigital(Integer idFirma) {
        this.idFirma = idFirma;
    }

    public TbFirmaDigital(String alias, String password, String uriCertificado, Date fechaVigenciaIni, Date fechaVigenciaFin) {

        this.alias = alias;
        this.password = password;
        this.uriCertificado = uriCertificado;
        this.fechaVigenciaIni = fechaVigenciaIni;
        this.fechaVigenciaFin = fechaVigenciaFin;
    }

    public Integer getIdFirma() {
        return idFirma;
    }

    public void setIdFirma(Integer idFirma) {
        this.idFirma = idFirma;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUriCertificado() {
        return uriCertificado;
    }

    public void setUriCertificado(String uriCertificado) {
        this.uriCertificado = uriCertificado;
    }

    public Date getFechaVigenciaIni() {
        return fechaVigenciaIni;
    }

    public void setFechaVigenciaIni(Date fechaVigenciaIni) {
        this.fechaVigenciaIni = fechaVigenciaIni;
    }

    public Date getFechaVigenciaFin() {
        return fechaVigenciaFin;
    }

    public void setFechaVigenciaFin(Date fechaVigenciaFin) {
        this.fechaVigenciaFin = fechaVigenciaFin;
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
        hash += (idFirma != null ? idFirma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbFirmaDigital)) {
            return false;
        }
        TbFirmaDigital other = (TbFirmaDigital) object;
        if ((this.idFirma == null && other.idFirma != null) || (this.idFirma != null && !this.idFirma.equals(other.idFirma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gide.tx.entities.TbFirmaDigital[ idFirma=" + idFirma + " ]";
    }
    
}
