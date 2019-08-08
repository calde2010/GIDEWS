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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lcalderon
 */
@Entity
@Table(name = "tb_parametros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbParametros.findAll", query = "SELECT t FROM TbParametros t")
    , @NamedQuery(name = "TbParametros.findByIdParametro", query = "SELECT t FROM TbParametros t WHERE t.idParametro = :idParametro")
    , @NamedQuery(name = "TbParametros.findByCodigo", query = "SELECT t FROM TbParametros t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "TbParametros.findByValor", query = "SELECT t FROM TbParametros t WHERE t.valor = :valor")
    , @NamedQuery(name = "TbParametros.findByDescripcion", query = "SELECT t FROM TbParametros t WHERE t.descripcion = :descripcion")})
public class TbParametros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_parametro")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idParametro;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "valor")
    private String valor;
    @Column(name = "descripcion")
    private String descripcion;

    public TbParametros() {
    }

    public TbParametros(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public TbParametros(Integer idParametro, String codigo, String valor) {
        this.idParametro = idParametro;
        this.codigo = codigo;
        this.valor = valor;
    }

    public Integer getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametro != null ? idParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbParametros)) {
            return false;
        }
        TbParametros other = (TbParametros) object;
        if ((this.idParametro == null && other.idParametro != null) || (this.idParametro != null && !this.idParametro.equals(other.idParametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gide.tx.entities.TbParametros[ idParametro=" + idParametro + " ]";
    }
    
}
