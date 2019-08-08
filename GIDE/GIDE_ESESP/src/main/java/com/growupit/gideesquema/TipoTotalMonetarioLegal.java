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
 * <p>Java class for TipoTotalMonetarioLegal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoTotalMonetarioLegal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MontoExtensionLinea" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MontoExclusivoImpuesto" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MontoIncluyendoImpuesto" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="MontoTotalPermitido" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="MontoTotalCargado" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="MontoPagadoPorAdelantado" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="MontoRedondeadoPagado" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="MontoPagado" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoTotalMonetarioLegal", propOrder = {
    "montoExtensionLinea",
    "montoExclusivoImpuesto",
    "montoIncluyendoImpuesto",
    "montoTotalPermitido",
    "montoTotalCargado",
    "montoPagadoPorAdelantado",
    "montoRedondeadoPagado",
    "montoPagado"
})
public class TipoTotalMonetarioLegal
    implements Serializable
{

    private final static long serialVersionUID = 123456789012L;
    @XmlElement(name = "MontoExtensionLinea", required = true)
    protected BigDecimal montoExtensionLinea;
    @XmlElement(name = "MontoExclusivoImpuesto", required = true)
    protected BigDecimal montoExclusivoImpuesto;
    @XmlElement(name = "MontoIncluyendoImpuesto")
    protected BigDecimal montoIncluyendoImpuesto;
    @XmlElement(name = "MontoTotalPermitido")
    protected BigDecimal montoTotalPermitido;
    @XmlElement(name = "MontoTotalCargado")
    protected BigDecimal montoTotalCargado;
    @XmlElement(name = "MontoPagadoPorAdelantado")
    protected BigDecimal montoPagadoPorAdelantado;
    @XmlElement(name = "MontoRedondeadoPagado")
    protected BigDecimal montoRedondeadoPagado;
    @XmlElement(name = "MontoPagado", required = true)
    protected BigDecimal montoPagado;

    /**
     * Gets the value of the montoExtensionLinea property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoExtensionLinea() {
        return montoExtensionLinea;
    }

    /**
     * Sets the value of the montoExtensionLinea property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoExtensionLinea(BigDecimal value) {
        this.montoExtensionLinea = value;
    }

    /**
     * Gets the value of the montoExclusivoImpuesto property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoExclusivoImpuesto() {
        return montoExclusivoImpuesto;
    }

    /**
     * Sets the value of the montoExclusivoImpuesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoExclusivoImpuesto(BigDecimal value) {
        this.montoExclusivoImpuesto = value;
    }

    /**
     * Gets the value of the montoIncluyendoImpuesto property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoIncluyendoImpuesto() {
        return montoIncluyendoImpuesto;
    }

    /**
     * Sets the value of the montoIncluyendoImpuesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoIncluyendoImpuesto(BigDecimal value) {
        this.montoIncluyendoImpuesto = value;
    }

    /**
     * Gets the value of the montoTotalPermitido property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoTotalPermitido() {
        return montoTotalPermitido;
    }

    /**
     * Sets the value of the montoTotalPermitido property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoTotalPermitido(BigDecimal value) {
        this.montoTotalPermitido = value;
    }

    /**
     * Gets the value of the montoTotalCargado property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoTotalCargado() {
        return montoTotalCargado;
    }

    /**
     * Sets the value of the montoTotalCargado property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoTotalCargado(BigDecimal value) {
        this.montoTotalCargado = value;
    }

    /**
     * Gets the value of the montoPagadoPorAdelantado property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoPagadoPorAdelantado() {
        return montoPagadoPorAdelantado;
    }

    /**
     * Sets the value of the montoPagadoPorAdelantado property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoPagadoPorAdelantado(BigDecimal value) {
        this.montoPagadoPorAdelantado = value;
    }

    /**
     * Gets the value of the montoRedondeadoPagado property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoRedondeadoPagado() {
        return montoRedondeadoPagado;
    }

    /**
     * Sets the value of the montoRedondeadoPagado property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoRedondeadoPagado(BigDecimal value) {
        this.montoRedondeadoPagado = value;
    }

    /**
     * Gets the value of the montoPagado property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoPagado() {
        return montoPagado;
    }

    /**
     * Sets the value of the montoPagado property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoPagado(BigDecimal value) {
        this.montoPagado = value;
    }

}
