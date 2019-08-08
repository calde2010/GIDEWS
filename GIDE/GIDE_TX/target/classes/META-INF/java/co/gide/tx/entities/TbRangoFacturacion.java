/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gide.tx.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lcalderon
 */
@Entity
@Table(name = "tb_rango_facturacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbRangoFacturacion.findAll", query = "SELECT t FROM TbRangoFacturacion t")
    , @NamedQuery(name = "TbRangoFacturacion.findByIdRangoFacturacion", query = "SELECT t FROM TbRangoFacturacion t WHERE t.idRangoFacturacion = :idRangoFacturacion")
    , @NamedQuery(name = "TbRangoFacturacion.findByFechaInicial", query = "SELECT t FROM TbRangoFacturacion t WHERE t.fechaInicial = :fechaInicial")
    , @NamedQuery(name = "TbRangoFacturacion.findByFechaFinal", query = "SELECT t FROM TbRangoFacturacion t WHERE t.fechaFinal = :fechaFinal")
    , @NamedQuery(name = "TbRangoFacturacion.findByNumeroInicial", query = "SELECT t FROM TbRangoFacturacion t WHERE t.numeroInicial = :numeroInicial")
    , @NamedQuery(name = "TbRangoFacturacion.findByNumeroFinal", query = "SELECT t FROM TbRangoFacturacion t WHERE t.numeroFinal = :numeroFinal")
    , @NamedQuery(name = "TbRangoFacturacion.findByPrefijo", query = "SELECT t FROM TbRangoFacturacion t WHERE t.prefijo = :prefijo")
    , @NamedQuery(name = "TbRangoFacturacion.findByIdTipoRango", query = "SELECT t FROM TbRangoFacturacion t WHERE t.idTipoRango = :idTipoRango")})
public class TbRangoFacturacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_rango_facturacion")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idRangoFacturacion;
    @Column(name = "fecha_inicial")
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;
    @Column(name = "fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @Column(name = "numero_inicial")
    private Integer numeroInicial;
    @Column(name = "numero_final")
    private Integer numeroFinal;
    @Column(name = "prefijo")
    private String prefijo;
    @Column(name = "id_tipo_rango")
    private String idTipoRango;
    @JoinColumn(name = "id_resol_factura", referencedColumnName = "id_resol_factura")
    @ManyToOne(optional = false)
    private TbResolucionFacturacion idResolFactura;

    
    
    public TbRangoFacturacion(Date fechaInicial, Date fechaFinal, Integer numeroInicial, Integer numeroFinal,
			String prefijo, String idTipoRango, TbResolucionFacturacion idResolFactura) {
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.numeroInicial = numeroInicial;
		this.numeroFinal = numeroFinal;
		this.prefijo = prefijo;
		this.idTipoRango = idTipoRango;
		this.idResolFactura = idResolFactura;
	}

	public TbRangoFacturacion() {
    }

    public TbRangoFacturacion(Integer idRangoFacturacion) {
        this.idRangoFacturacion = idRangoFacturacion;
    }

    public Integer getIdRangoFacturacion() {
        return idRangoFacturacion;
    }

    public void setIdRangoFacturacion(Integer idRangoFacturacion) {
        this.idRangoFacturacion = idRangoFacturacion;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Integer getNumeroInicial() {
        return numeroInicial;
    }

    public void setNumeroInicial(Integer numeroInicial) {
        this.numeroInicial = numeroInicial;
    }

    public Integer getNumeroFinal() {
        return numeroFinal;
    }

    public void setNumeroFinal(Integer numeroFinal) {
        this.numeroFinal = numeroFinal;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getIdTipoRango() {
        return idTipoRango;
    }

    public void setIdTipoRango(String idTipoRango) {
        this.idTipoRango = idTipoRango;
    }

    public TbResolucionFacturacion getIdResolFactura() {
        return idResolFactura;
    }

    public void setIdResolFactura(TbResolucionFacturacion idResolFactura) {
        this.idResolFactura = idResolFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRangoFacturacion != null ? idRangoFacturacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbRangoFacturacion)) {
            return false;
        }
        TbRangoFacturacion other = (TbRangoFacturacion) object;
        if ((this.idRangoFacturacion == null && other.idRangoFacturacion != null) || (this.idRangoFacturacion != null && !this.idRangoFacturacion.equals(other.idRangoFacturacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gide.tx.entities.TbRangoFacturacion[ idRangoFacturacion=" + idRangoFacturacion + " ]";
    }
    
}
