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
@Table(name = "tb_resolucion_facturacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbResolucionFacturacion.findAll", query = "SELECT t FROM TbResolucionFacturacion t")
    , @NamedQuery(name = "TbResolucionFacturacion.findByIdResolFactura", query = "SELECT t FROM TbResolucionFacturacion t WHERE t.idResolFactura = :idResolFactura")
    , @NamedQuery(name = "TbResolucionFacturacion.findByCodigoResolucionFacturacion", query = "SELECT t FROM TbResolucionFacturacion t WHERE t.codigoResolucionFacturacion = :codigoResolucionFacturacion")
    , @NamedQuery(name = "TbResolucionFacturacion.findByDescResolucion", query = "SELECT t FROM TbResolucionFacturacion t WHERE t.descResolucion = :descResolucion")
    , @NamedQuery(name = "TbResolucionFacturacion.findByDescTipoRango", query = "SELECT t FROM TbResolucionFacturacion t WHERE t.descTipoRango = :descTipoRango")})
public class TbResolucionFacturacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_resol_factura")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idResolFactura;
    @Column(name = "codigo_resolucion_facturacion")
    private Integer codigoResolucionFacturacion;
    @Basic(optional = false)
    @Column(name = "desc_resolucion")
    private String descResolucion;
    @Basic(optional = false)
    @Column(name = "desc_tipo_rango")
    private String descTipoRango;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idResolFactura")
    private List<TbRangoFacturacion> tbRangoFacturacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbResolucionFacturacion")
    private List<TbSwResolCliente> tbSwResolClienteList;

    public TbResolucionFacturacion() {
    }

    public TbResolucionFacturacion(Integer idResolFactura) {
        this.idResolFactura = idResolFactura;
    }

    public TbResolucionFacturacion(String descResolucion, String descTipoRango) {
        this.descResolucion = descResolucion;
        this.descTipoRango = descTipoRango;
    }

    public Integer getIdResolFactura() {
        return idResolFactura;
    }

    public void setIdResolFactura(Integer idResolFactura) {
        this.idResolFactura = idResolFactura;
    }

    public Integer getCodigoResolucionFacturacion() {
        return codigoResolucionFacturacion;
    }

    public void setCodigoResolucionFacturacion(Integer codigoResolucionFacturacion) {
        this.codigoResolucionFacturacion = codigoResolucionFacturacion;
    }

    public String getDescResolucion() {
        return descResolucion;
    }

    public void setDescResolucion(String descResolucion) {
        this.descResolucion = descResolucion;
    }

    public String getDescTipoRango() {
        return descTipoRango;
    }

    public void setDescTipoRango(String descTipoRango) {
        this.descTipoRango = descTipoRango;
    }

    @XmlTransient
    public List<TbRangoFacturacion> getTbRangoFacturacionList() {
        return tbRangoFacturacionList;
    }

    public void setTbRangoFacturacionList(List<TbRangoFacturacion> tbRangoFacturacionList) {
        this.tbRangoFacturacionList = tbRangoFacturacionList;
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
        hash += (idResolFactura != null ? idResolFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbResolucionFacturacion)) {
            return false;
        }
        TbResolucionFacturacion other = (TbResolucionFacturacion) object;
        if ((this.idResolFactura == null && other.idResolFactura != null) || (this.idResolFactura != null && !this.idResolFactura.equals(other.idResolFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gide.tx.entities.TbResolucionFacturacion[ idResolFactura=" + idResolFactura + " ]";
    }
    
}
