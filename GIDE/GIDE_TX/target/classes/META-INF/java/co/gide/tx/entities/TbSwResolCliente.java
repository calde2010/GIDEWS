/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gide.tx.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "tb_sw_resol_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbSwResolCliente.findAll", query = "SELECT t FROM TbSwResolCliente t")
    , @NamedQuery(name = "TbSwResolCliente.findByIdSoftware", query = "SELECT t FROM TbSwResolCliente t WHERE t.tbSwResolClientePK.idSoftware = :idSoftware")
    , @NamedQuery(name = "TbSwResolCliente.findByIdPersona", query = "SELECT t FROM TbSwResolCliente t WHERE t.tbSwResolClientePK.idPersona = :idPersona")
    , @NamedQuery(name = "TbSwResolCliente.findByIdResolFactura", query = "SELECT t FROM TbSwResolCliente t WHERE t.tbSwResolClientePK.idResolFactura = :idResolFactura")
    , @NamedQuery(name = "TbSwResolCliente.findByIdFirma", query = "SELECT t FROM TbSwResolCliente t WHERE t.tbSwResolClientePK.idFirma = :idFirma")
    , @NamedQuery(name = "TbSwResolCliente.findByEstado", query = "SELECT t FROM TbSwResolCliente t WHERE t.estado = :estado")})
public class TbSwResolCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TbSwResolClientePK tbSwResolClientePK;
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbClientes tbClientes;
    @JoinColumn(name = "id_firma", referencedColumnName = "id_firma", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbFirmaDigital tbFirmaDigital;
    @JoinColumn(name = "id_resol_factura", referencedColumnName = "id_resol_factura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbResolucionFacturacion tbResolucionFacturacion;
    @JoinColumn(name = "id_software", referencedColumnName = "id_software", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TbSoftware tbSoftware;

    public TbSwResolCliente() {
    }

    public TbSwResolCliente(TbSwResolClientePK tbSwResolClientePK) {
        this.tbSwResolClientePK = tbSwResolClientePK;
    }

    public TbSwResolCliente(int idSoftware, int idPersona, int idResolFactura, int idFirma,String estado ) {
        this.tbSwResolClientePK = new TbSwResolClientePK(idSoftware, idPersona, idResolFactura, idFirma);
        this.estado=estado;
    }

    public TbSwResolClientePK getTbSwResolClientePK() {
        return tbSwResolClientePK;
    }

    public void setTbSwResolClientePK(TbSwResolClientePK tbSwResolClientePK) {
        this.tbSwResolClientePK = tbSwResolClientePK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TbClientes getTbClientes() {
        return tbClientes;
    }

    public void setTbClientes(TbClientes tbClientes) {
        this.tbClientes = tbClientes;
    }

    public TbFirmaDigital getTbFirmaDigital() {
        return tbFirmaDigital;
    }

    public void setTbFirmaDigital(TbFirmaDigital tbFirmaDigital) {
        this.tbFirmaDigital = tbFirmaDigital;
    }

    public TbResolucionFacturacion getTbResolucionFacturacion() {
        return tbResolucionFacturacion;
    }

    public void setTbResolucionFacturacion(TbResolucionFacturacion tbResolucionFacturacion) {
        this.tbResolucionFacturacion = tbResolucionFacturacion;
    }

    public TbSoftware getTbSoftware() {
        return tbSoftware;
    }

    public void setTbSoftware(TbSoftware tbSoftware) {
        this.tbSoftware = tbSoftware;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tbSwResolClientePK != null ? tbSwResolClientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbSwResolCliente)) {
            return false;
        }
        TbSwResolCliente other = (TbSwResolCliente) object;
        if ((this.tbSwResolClientePK == null && other.tbSwResolClientePK != null) || (this.tbSwResolClientePK != null && !this.tbSwResolClientePK.equals(other.tbSwResolClientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gide.tx.entities.TbSwResolCliente[ tbSwResolClientePK=" + tbSwResolClientePK + " ]";
    }
    
}
