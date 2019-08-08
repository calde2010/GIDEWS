//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.08 at 09:18:26 AM CEST 
//


package co.gide.traslate.firma;

import java.io.File;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



/**
 * <p>Java class for DocToSignPathRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocToSignPathRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="keystorePath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="keystorePassword" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="urlTSA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="documentPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="documentOutPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="signatureType" type="{http://data.signature.mmdd.indra.com}SignatureType"/>
 *         &lt;element name="alias" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="proxy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="validateCertType" type="{http://data.signature.mmdd.indra.com}ValidateCertType" minOccurs="0"/>
 *         &lt;element name="policy" type="{http://data.signature.mmdd.indra.com}PolicyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocToSignPathRequestType", propOrder = {
    "keystore",
    "keystorePassword",
    "urlTSA",
    "documentPath",
    "documentOutPath",
    "signatureType",
    "alias",
    "password",
    "proxy",
    "port",
    "validateCertType",
    "policy"
})

public class DocToSignPathRequestType {

    @XmlElement(required = true)
    protected File keystore;
    @XmlElement(required = true)
    protected String keystorePassword;
    protected String urlTSA;
    @XmlElement(required = true)
    protected String documentPath;
    @XmlElement(required = true)
    protected String documentOutPath;
    @XmlElement(required = true)
    protected SignatureType signatureType;
    @XmlElement(required = true)
    protected String alias;
    @XmlElement(required = true)
    protected String password;
    protected String proxy;
    protected String port;
    protected ValidateCertType validateCertType;
    protected PolicyType policy;

    /**
     * Gets the value of the keystorePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public File getKeystore() {
        return keystore;
    }

    /**
     * Sets the value of the keystorePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeystore(File value) {
        this.keystore = value;
    }

    /**
     * Gets the value of the keystorePassword property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public String getKeystorePassword() {
        return keystorePassword;
    }

    /**
     * Sets the value of the keystorePassword property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setKeystorePassword(String value) {
        this.keystorePassword = value;
    }

    /**
     * Gets the value of the urlTSA property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlTSA() {
        return urlTSA;
    }

    /**
     * Sets the value of the urlTSA property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlTSA(String value) {
        this.urlTSA = value;
    }

    /**
     * Gets the value of the documentPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentPath() {
        return documentPath;
    }

    /**
     * Sets the value of the documentPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentPath(String value) {
        this.documentPath = value;
    }

    /**
     * Gets the value of the documentOutPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentOutPath() {
        return documentOutPath;
    }

    /**
     * Sets the value of the documentOutPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentOutPath(String value) {
        this.documentOutPath = value;
    }

    /**
     * Gets the value of the signatureType property.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    public SignatureType getSignatureType() {
        return signatureType;
    }

    /**
     * Sets the value of the signatureType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    public void setSignatureType(SignatureType value) {
        this.signatureType = value;
    }

    /**
     * Gets the value of the alias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the value of the alias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlias(String value) {
        this.alias = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the proxy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxy() {
        return proxy;
    }

    /**
     * Sets the value of the proxy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxy(String value) {
        this.proxy = value;
    }

    /**
     * Gets the value of the port property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPort(String value) {
        this.port = value;
    }

    /**
     * Gets the value of the validateCertType property.
     * 
     * @return
     *     possible object is
     *     {@link ValidateCertType }
     *     
     */
    public ValidateCertType getValidateCertType() {
        return validateCertType;
    }

    /**
     * Sets the value of the validateCertType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidateCertType }
     *     
     */
    public void setValidateCertType(ValidateCertType value) {
        this.validateCertType = value;
    }

    /**
     * Gets the value of the policy property.
     * 
     * @return
     *     possible object is
     *     {@link PolicyType }
     *     
     */
    public PolicyType getPolicy() {
        return policy;
    }

    /**
     * Sets the value of the policy property.
     * 
     * @param value
     *     allowed object is
     *     {@link PolicyType }
     *     
     */
    public void setPolicy(PolicyType value) {
        this.policy = value;
    }

}
