//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.20 at 01:28:29 PM CDT 
//


package com.opengamma.strata.examples.fpml.generated;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * An exchange traded derivative contract.
 * 
 * <p>Java class for ExchangeTradedContract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExchangeTradedContract">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.fpml.org/FpML-5/pretrade}ExchangeTraded">
 *       &lt;sequence>
 *         &lt;element name="multiplier" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="contractReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expirationDate" type="{http://www.fpml.org/FpML-5/pretrade}AdjustableOrRelativeDate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExchangeTradedContract", propOrder = {
    "multiplier",
    "contractReference",
    "expirationDate"
})
@XmlSeeAlso({
    ExchangeTradedOption.class
})
public class ExchangeTradedContract
    extends ExchangeTraded
{

    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger multiplier;
    protected String contractReference;
    protected AdjustableOrRelativeDate expirationDate;

    /**
     * Gets the value of the multiplier property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMultiplier() {
        return multiplier;
    }

    /**
     * Sets the value of the multiplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMultiplier(BigInteger value) {
        this.multiplier = value;
    }

    /**
     * Gets the value of the contractReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractReference() {
        return contractReference;
    }

    /**
     * Sets the value of the contractReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractReference(String value) {
        this.contractReference = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link AdjustableOrRelativeDate }
     *     
     */
    public AdjustableOrRelativeDate getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdjustableOrRelativeDate }
     *     
     */
    public void setExpirationDate(AdjustableOrRelativeDate value) {
        this.expirationDate = value;
    }

}