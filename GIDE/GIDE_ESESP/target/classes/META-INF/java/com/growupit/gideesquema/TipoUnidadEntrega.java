//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.08.08 at 03:17:20 PM COT 
//


package com.growupit.gideesquema;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoUnidadEntrega complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoUnidadEntrega">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CantidadLote" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CantidadUnidadConsumo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="IndicadorRiesgo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoUnidadEntrega", propOrder = {
    "cantidadLote",
    "cantidadUnidadConsumo",
    "indicadorRiesgo"
})
public class TipoUnidadEntrega
    implements Serializable
{

    private final static long serialVersionUID = 123456789012L;
    @XmlElement(name = "CantidadLote", required = true)
    protected BigDecimal cantidadLote;
    @XmlElement(name = "CantidadUnidadConsumo")
    protected BigDecimal cantidadUnidadConsumo;
    @XmlElement(name = "IndicadorRiesgo")
    protected Boolean indicadorRiesgo;

    /**
     * Gets the value of the cantidadLote property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCantidadLote() {
        return cantidadLote;
    }

    /**
     * Sets the value of the cantidadLote property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCantidadLote(BigDecimal value) {
        this.cantidadLote = value;
    }

    /**
     * Gets the value of the cantidadUnidadConsumo property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCantidadUnidadConsumo() {
        return cantidadUnidadConsumo;
    }

    /**
     * Sets the value of the cantidadUnidadConsumo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCantidadUnidadConsumo(BigDecimal value) {
        this.cantidadUnidadConsumo = value;
    }

    /**
     * Gets the value of the indicadorRiesgo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIndicadorRiesgo() {
        return indicadorRiesgo;
    }

    /**
     * Sets the value of the indicadorRiesgo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIndicadorRiesgo(Boolean value) {
        this.indicadorRiesgo = value;
    }

}
