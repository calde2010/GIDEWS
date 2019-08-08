/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gide.tx.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author lcalderon
 */
@Embeddable
public class TbSwResolClientePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_software")
    private int idSoftware;
    @Basic(optional = false)
    @Column(name = "id_persona")
    private int idPersona;
    @Basic(optional = false)
    @Column(name = "id_resol_factura")
    private int idResolFactura;
    @Basic(optional = false)
    @Column(name = "id_firma")
    private int idFirma;

    public TbSwResolClientePK() {
    }

    public TbSwResolClientePK(int idSoftware, int idPersona, int idResolFactura, int idFirma) {
        this.idSoftware = idSoftware;
        this.idPersona = idPersona;
        this.idResolFactura = idResolFactura;
        this.idFirma = idFirma;
    }

    public int getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(int idSoftware) {
        this.idSoftware = idSoftware;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdResolFactura() {
        return idResolFactura;
    }

    public void setIdResolFactura(int idResolFactura) {
        this.idResolFactura = idResolFactura;
    }

    public int getIdFirma() {
        return idFirma;
    }

    public void setIdFirma(int idFirma) {
        this.idFirma = idFirma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSoftware;
        hash += (int) idPersona;
        hash += (int) idResolFactura;
        hash += (int) idFirma;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbSwResolClientePK)) {
            return false;
        }
        TbSwResolClientePK other = (TbSwResolClientePK) object;
        if (this.idSoftware != other.idSoftware) {
            return false;
        }
        if (this.idPersona != other.idPersona) {
            return false;
        }
        if (this.idResolFactura != other.idResolFactura) {
            return false;
        }
        if (this.idFirma != other.idFirma) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gide.tx.entities.TbSwResolClientePK[ idSoftware=" + idSoftware + ", idPersona=" + idPersona + ", idResolFactura=" + idResolFactura + ", idFirma=" + idFirma + " ]";
    }
    
}
