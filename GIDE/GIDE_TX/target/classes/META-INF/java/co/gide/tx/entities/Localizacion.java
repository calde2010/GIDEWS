/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gide.tx.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lcalderon
 */
@Entity
@Table(name = "localizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localizacion.findAll", query = "SELECT l FROM Localizacion l")
    , @NamedQuery(name = "Localizacion.findByIdLocalizacion", query = "SELECT l FROM Localizacion l WHERE l.idLocalizacion = :idLocalizacion")
    , @NamedQuery(name = "Localizacion.findByPais", query = "SELECT l FROM Localizacion l WHERE l.pais = :pais")
    , @NamedQuery(name = "Localizacion.findByMunicipio", query = "SELECT l FROM Localizacion l WHERE l.municipio = :municipio")
    , @NamedQuery(name = "Localizacion.findByCiudad", query = "SELECT l FROM Localizacion l WHERE l.ciudad = :ciudad")
    , @NamedQuery(name = "Localizacion.findByDireccion", query = "SELECT l FROM Localizacion l WHERE l.direccion = :direccion")})
public class Localizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_localizacion")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idLocalizacion;
    @Basic(optional = false)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @Column(name = "municipio")
    private String municipio;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private TbClientes idPersona;

    public Localizacion() {
    }

    public Localizacion(Integer idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public Localizacion(Integer idLocalizacion, String pais, String municipio, String ciudad, String direccion) {
        this.idLocalizacion = idLocalizacion;
        this.pais = pais;
        this.municipio = municipio;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Integer getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(Integer idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TbClientes getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(TbClientes idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocalizacion != null ? idLocalizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localizacion)) {
            return false;
        }
        Localizacion other = (Localizacion) object;
        if ((this.idLocalizacion == null && other.idLocalizacion != null) || (this.idLocalizacion != null && !this.idLocalizacion.equals(other.idLocalizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gide.tx.entities.Localizacion[ idLocalizacion=" + idLocalizacion + " ]";
    }
    
}
