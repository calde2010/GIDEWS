//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.08.08 at 03:17:20 PM COT 
//


package com.growupit.gideesquema;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoCargo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoCargo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.growupit.com/gideEsquema}TipoIdentificador" minOccurs="0"/>
 *         &lt;element name="IndicadorCarga" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CodigoRazonAsignacionCargo" type="{http://www.growupit.com/gideEsquema}TipoCodigo" minOccurs="0"/>
 *         &lt;element name="RazonAsignacionCargo" type="{http://www.growupit.com/gideEsquema}TipoTexto" minOccurs="0"/>
 *         &lt;element name="FactorNumericoMultiplicador" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="IndicadorPagoAdelantado" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SecuenciaNumerica" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Monto" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MontoBase" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="CodigoCostoContable" type="{http://www.growupit.com/gideEsquema}TipoCodigo" minOccurs="0"/>
 *         &lt;element name="CostoContable" type="{http://www.growupit.com/gideEsquema}TipoTexto" minOccurs="0"/>
 *         &lt;element name="CategoriaImpuesto" type="{http://www.growupit.com/gideEsquema}TipoImpuestoCategoria" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ImpuestoTotal" type="{http://www.growupit.com/gideEsquema}TipoImpuestoTotal" minOccurs="0"/>
 *         &lt;element name="MedioPago" type="{http://www.growupit.com/gideEsquema}TipoMedioPago" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoCargo", propOrder = {
    "id",
    "indicadorCarga",
    "codigoRazonAsignacionCargo",
    "razonAsignacionCargo",
    "factorNumericoMultiplicador",
    "indicadorPagoAdelantado",
    "secuenciaNumerica",
    "monto",
    "montoBase",
    "codigoCostoContable",
    "costoContable",
    "categoriaImpuesto",
    "impuestoTotal",
    "medioPago"
})
public class TipoCargo
    implements Serializable
{

    private final static long serialVersionUID = 123456789012L;
    @XmlElement(name = "ID")
    protected TipoIdentificador id;
    @XmlElement(name = "IndicadorCarga")
    protected boolean indicadorCarga;
    @XmlElement(name = "CodigoRazonAsignacionCargo")
    protected TipoCodigo codigoRazonAsignacionCargo;
    @XmlElement(name = "RazonAsignacionCargo")
    protected TipoTexto razonAsignacionCargo;
    @XmlElement(name = "FactorNumericoMultiplicador", required = true)
    protected BigDecimal factorNumericoMultiplicador;
    @XmlElement(name = "IndicadorPagoAdelantado")
    protected Boolean indicadorPagoAdelantado;
    @XmlElement(name = "SecuenciaNumerica")
    protected BigDecimal secuenciaNumerica;
    @XmlElement(name = "Monto", required = true)
    protected BigDecimal monto;
    @XmlElement(name = "MontoBase")
    protected BigDecimal montoBase;
    @XmlElement(name = "CodigoCostoContable")
    protected TipoCodigo codigoCostoContable;
    @XmlElement(name = "CostoContable")
    protected TipoTexto costoContable;
    @XmlElement(name = "CategoriaImpuesto")
    protected List<TipoImpuestoCategoria> categoriaImpuesto;
    @XmlElement(name = "ImpuestoTotal")
    protected TipoImpuestoTotal impuestoTotal;
    @XmlElement(name = "MedioPago")
    protected List<TipoMedioPago> medioPago;

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
     * Gets the value of the indicadorCarga property.
     * 
     */
    public boolean isIndicadorCarga() {
        return indicadorCarga;
    }

    /**
     * Sets the value of the indicadorCarga property.
     * 
     */
    public void setIndicadorCarga(boolean value) {
        this.indicadorCarga = value;
    }

    /**
     * Gets the value of the codigoRazonAsignacionCargo property.
     * 
     * @return
     *     possible object is
     *     {@link TipoCodigo }
     *     
     */
    public TipoCodigo getCodigoRazonAsignacionCargo() {
        return codigoRazonAsignacionCargo;
    }

    /**
     * Sets the value of the codigoRazonAsignacionCargo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCodigo }
     *     
     */
    public void setCodigoRazonAsignacionCargo(TipoCodigo value) {
        this.codigoRazonAsignacionCargo = value;
    }

    /**
     * Gets the value of the razonAsignacionCargo property.
     * 
     * @return
     *     possible object is
     *     {@link TipoTexto }
     *     
     */
    public TipoTexto getRazonAsignacionCargo() {
        return razonAsignacionCargo;
    }

    /**
     * Sets the value of the razonAsignacionCargo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTexto }
     *     
     */
    public void setRazonAsignacionCargo(TipoTexto value) {
        this.razonAsignacionCargo = value;
    }

    /**
     * Gets the value of the factorNumericoMultiplicador property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFactorNumericoMultiplicador() {
        return factorNumericoMultiplicador;
    }

    /**
     * Sets the value of the factorNumericoMultiplicador property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFactorNumericoMultiplicador(BigDecimal value) {
        this.factorNumericoMultiplicador = value;
    }

    /**
     * Gets the value of the indicadorPagoAdelantado property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIndicadorPagoAdelantado() {
        return indicadorPagoAdelantado;
    }

    /**
     * Sets the value of the indicadorPagoAdelantado property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIndicadorPagoAdelantado(Boolean value) {
        this.indicadorPagoAdelantado = value;
    }

    /**
     * Gets the value of the secuenciaNumerica property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSecuenciaNumerica() {
        return secuenciaNumerica;
    }

    /**
     * Sets the value of the secuenciaNumerica property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSecuenciaNumerica(BigDecimal value) {
        this.secuenciaNumerica = value;
    }

    /**
     * Gets the value of the monto property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMonto() {
        return monto;
    }

    /**
     * Sets the value of the monto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMonto(BigDecimal value) {
        this.monto = value;
    }

    /**
     * Gets the value of the montoBase property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMontoBase() {
        return montoBase;
    }

    /**
     * Sets the value of the montoBase property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMontoBase(BigDecimal value) {
        this.montoBase = value;
    }

    /**
     * Gets the value of the codigoCostoContable property.
     * 
     * @return
     *     possible object is
     *     {@link TipoCodigo }
     *     
     */
    public TipoCodigo getCodigoCostoContable() {
        return codigoCostoContable;
    }

    /**
     * Sets the value of the codigoCostoContable property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCodigo }
     *     
     */
    public void setCodigoCostoContable(TipoCodigo value) {
        this.codigoCostoContable = value;
    }

    /**
     * Gets the value of the costoContable property.
     * 
     * @return
     *     possible object is
     *     {@link TipoTexto }
     *     
     */
    public TipoTexto getCostoContable() {
        return costoContable;
    }

    /**
     * Sets the value of the costoContable property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTexto }
     *     
     */
    public void setCostoContable(TipoTexto value) {
        this.costoContable = value;
    }

    /**
     * Gets the value of the categoriaImpuesto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categoriaImpuesto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategoriaImpuesto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoImpuestoCategoria }
     * 
     * 
     */
    public List<TipoImpuestoCategoria> getCategoriaImpuesto() {
        if (categoriaImpuesto == null) {
            categoriaImpuesto = new ArrayList<TipoImpuestoCategoria>();
        }
        return this.categoriaImpuesto;
    }

    /**
     * Gets the value of the impuestoTotal property.
     * 
     * @return
     *     possible object is
     *     {@link TipoImpuestoTotal }
     *     
     */
    public TipoImpuestoTotal getImpuestoTotal() {
        return impuestoTotal;
    }

    /**
     * Sets the value of the impuestoTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoImpuestoTotal }
     *     
     */
    public void setImpuestoTotal(TipoImpuestoTotal value) {
        this.impuestoTotal = value;
    }

    /**
     * Gets the value of the medioPago property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the medioPago property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMedioPago().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoMedioPago }
     * 
     * 
     */
    public List<TipoMedioPago> getMedioPago() {
        if (medioPago == null) {
            medioPago = new ArrayList<TipoMedioPago>();
        }
        return this.medioPago;
    }

}
