/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gide.tx.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lcalderon
 */
@Entity
@Table(name = "tb_software")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSoftware.findAll", query = "SELECT t FROM TbSoftware t")
    , @NamedQuery(name = "TbSoftware.findByIdSoftware", query = "SELECT t FROM TbSoftware t WHERE t.idSoftware = :idSoftware")
    , @NamedQuery(name = "TbSoftware.findByDescSoftware", query = "SELECT t FROM TbSoftware t WHERE t.descSoftware = :descSoftware")
    , @NamedQuery(name = "TbSoftware.findByPin", query = "SELECT t FROM TbSoftware t WHERE t.pin = :pin")
    , @NamedQuery(name = "TbSoftware.findByPassword", query = "SELECT t FROM TbSoftware t WHERE t.password = :password")
    , @NamedQuery(name = "TbSoftware.findByCtc", query = "SELECT t FROM TbSoftware t WHERE t.ctc = :ctc")
    , @NamedQuery(name = "TbSoftware.findByUrl", query = "SELECT t FROM TbSoftware t WHERE t.url = :url")
    , @NamedQuery(name = "TbSoftware.findByIdFirma", query = "SELECT t FROM TbSoftware t WHERE t.idFirma = :idFirma")})
public class TbSoftware implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_software")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idSoftware;
    @Basic(optional = false)
    @Column(name = "desc_software")
    private String descSoftware;
    @Basic(optional = false)
    @Column(name = "pin")
    private String pin;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "ctc")
    private String ctc;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;
    @Column(name = "id_firma")
    private Integer idFirma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbSoftware")
    private List<TbSwResolCliente> tbSwResolClienteList;

    public TbSoftware() {
    }

    public TbSoftware(Integer idSoftware) {
        this.idSoftware = idSoftware;
    }

    public TbSoftware( String descSoftware, String pin, String password, String ctc, String url) {
   
        this.descSoftware = descSoftware;
        this.pin = pin;
        this.password = password;
        this.ctc = ctc;
        this.url = url;
    }

    public Integer getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(Integer idSoftware) {
        this.idSoftware = idSoftware;
    }

    public String getDescSoftware() {
        return descSoftware;
    }

    public void setDescSoftware(String descSoftware) {
        this.descSoftware = descSoftware;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCtc() {
        return ctc;
    }

    public void setCtc(String ctc) {
        this.ctc = ctc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIdFirma() {
        return idFirma;
    }

    public void setIdFirma(Integer idFirma) {
        this.idFirma = idFirma;
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
        hash += (idSoftware != null ? idSoftware.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbSoftware)) {
            return false;
        }
        TbSoftware other = (TbSoftware) object;
        if ((this.idSoftware == null && other.idSoftware != null) || (this.idSoftware != null && !this.idSoftware.equals(other.idSoftware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gide.tx.entities.TbSoftware[ idSoftware=" + idSoftware + " ]";
    }
    
}
