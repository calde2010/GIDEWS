//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.08.08 at 03:17:20 PM COT 
//


package com.growupit.gideesquema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoUbicacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoUbicacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.growupit.com/gideEsquema}TipoIdentificador" minOccurs="0"/>
 *         &lt;element name="Descripcion" type="{http://www.growupit.com/gideEsquema}TipoTexto" minOccurs="0"/>
 *         &lt;element name="Condiciones" type="{http://www.growupit.com/gideEsquema}TipoTexto" minOccurs="0"/>
 *         &lt;element name="SubentidadPais" type="{http://www.growupit.com/gideEsquema}TipoTexto" minOccurs="0"/>
 *         &lt;element name="CodigoSubentidadPais" type="{http://www.growupit.com/gideEsquema}TipoCodigo" minOccurs="0"/>
 *         &lt;element name="PeriodoValidez" type="{http://www.growupit.com/gideEsquema}TipoPeriodo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Direccion" type="{http://www.growupit.com/gideEsquema}TipoDireccion" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoUbicacion", propOrder = {
    "id",
    "descripcion",
    "condiciones",
    "subentidadPais",
    "codigoSubentidadPais",
    "periodoValidez",
    "direccion"
})
public class TipoUbicacion
    implements Serializable
{

    private final static long serialVersionUID = 123456789012L;
    @XmlElement(name = "ID")
    protected TipoIdentificador id;
    @XmlElement(name = "Descripcion")
    protected TipoTexto descripcion;
    @XmlElement(name = "Condiciones")
    protected TipoTexto condiciones;
    @XmlElement(name = "SubentidadPais")
    protected TipoTexto subentidadPais;
    @XmlElement(name = "CodigoSubentidadPais")
    protected TipoCodigo codigoSubentidadPais;
    @XmlElement(name = "PeriodoValidez")
    protected List<TipoPeriodo> periodoValidez;
    @XmlElement(name = "Direccion")
    protected TipoDireccion direccion;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link TipoIdentificador }
     *     
     */
    public TipoIdentificador getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoIdentificador }
     *     
     */
    public void setID(TipoIdentificador value) {
        this.id = value;
    }

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link TipoTexto }
     *     
     */
    public TipoTexto getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTexto }
     *     
     */
    public void setDescripcion(TipoTexto value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the condiciones property.
     * 
     * @return
     *     possible object is
     *     {@link TipoTexto }
     *     
     */
    public TipoTexto getCondiciones() {
        return condiciones;
    }

    /**
     * Sets the value of the condiciones property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTexto }
     *     
     */
    public void setCondiciones(TipoTexto value) {
        this.condiciones = value;
    }

    /**
     * Gets the value of the subentidadPais property.
     * 
     * @return
     *     possible object is
     *     {@link TipoTexto }
     *     
     */
    public TipoTexto getSubentidadPais() {
        return subentidadPais;
    }

    /**
     * Sets the value of the subentidadPais property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTexto }
     *     
     */
    public void setSubentidadPais(TipoTexto value) {
        this.subentidadPais = value;
    }

    /**
     * Gets the value of the codigoSubentidadPais property.
     * 
     * @return
     *     possible object is
     *     {@link TipoCodigo }
     *     
     */
    public TipoCodigo getCodigoSubentidadPais() {
        return codigoSubentidadPais;
    }

    /**
     * Sets the value of the codigoSubentidadPais property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCodigo }
     *     
     */
    public void setCodigoSubentidadPais(TipoCodigo value) {
        this.codigoSubentidadPais = value;
    }

    /**
     * Gets the value of the periodoValidez property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the periodoValidez property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPeriodoValidez().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoPeriodo }
     * 
     * 
     */
    public List<TipoPeriodo> getPeriodoValidez() {
        if (periodoValidez == null) {
            periodoValidez = new ArrayList<TipoPeriodo>();
        }
        return this.periodoValidez;
    }

    /**
     * Gets the value of the direccion property.
     * 
     * @return
     *     possible object is
     *     {@link TipoDireccion }
     *     
     */
    public TipoDireccion getDireccion() {
        return direccion;
    }

    /**
     * Sets the value of the direccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoDireccion }
     *     
     */
    public void setDireccion(TipoDireccion value) {
        this.direccion = value;
    }

}
