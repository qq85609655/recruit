
package com.csot.gm.esbws.account;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for MsgHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MsgHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="APP_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="APP_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MOD_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MOD_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TOKEN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="USERID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="USERNAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SUBMITDATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PAGE_SIZE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CURRENT_PAGE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TOTAL_RECORD" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ROUTE_CODE1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ROUTE_CODE2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MsgHeader", namespace = "http://www.csot.tcl.com/MsgHeader/1.0", propOrder = {
    "appid",
    "appname",
    "modid",
    "modname",
    "token",
    "userid",
    "username",
    "submitdate",
    "pagesize",
    "currentpage",
    "totalrecord",
    "routecode1",
    "routecode2"
})
public class MsgHeader {

    @XmlElement(name = "APP_ID", required = true, nillable = true)
    protected String appid;
    @XmlElement(name = "APP_NAME", required = true, nillable = true)
    protected String appname;
    @XmlElement(name = "MOD_ID", required = true, nillable = true)
    protected String modid;
    @XmlElement(name = "MOD_NAME", required = true, nillable = true)
    protected String modname;
    @XmlElement(name = "TOKEN", required = true, nillable = true)
    protected String token;
    @XmlElement(name = "USERID", required = true, nillable = true)
    protected BigDecimal userid;
    @XmlElement(name = "USERNAME", required = true, nillable = true)
    protected String username;
    @XmlElement(name = "SUBMITDATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar submitdate;
    @XmlElement(name = "PAGE_SIZE", required = true, nillable = true)
    protected BigDecimal pagesize;
    @XmlElement(name = "CURRENT_PAGE", required = true, nillable = true)
    protected BigDecimal currentpage;
    @XmlElement(name = "TOTAL_RECORD", required = true, nillable = true)
    protected BigDecimal totalrecord;
    @XmlElement(name = "ROUTE_CODE1", required = true, nillable = true)
    protected String routecode1;
    @XmlElement(name = "ROUTE_CODE2", required = true, nillable = true)
    protected String routecode2;

    /**
     * Gets the value of the appid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPPID() {
        return appid;
    }

    /**
     * Sets the value of the appid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPPID(String value) {
        this.appid = value;
    }

    /**
     * Gets the value of the appname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPPNAME() {
        return appname;
    }

    /**
     * Sets the value of the appname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPPNAME(String value) {
        this.appname = value;
    }

    /**
     * Gets the value of the modid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMODID() {
        return modid;
    }

    /**
     * Sets the value of the modid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMODID(String value) {
        this.modid = value;
    }

    /**
     * Gets the value of the modname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMODNAME() {
        return modname;
    }

    /**
     * Sets the value of the modname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMODNAME(String value) {
        this.modname = value;
    }

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOKEN() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOKEN(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the userid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUSERID() {
        return userid;
    }

    /**
     * Sets the value of the userid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUSERID(BigDecimal value) {
        this.userid = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERNAME() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERNAME(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the submitdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSUBMITDATE() {
        return submitdate;
    }

    /**
     * Sets the value of the submitdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSUBMITDATE(XMLGregorianCalendar value) {
        this.submitdate = value;
    }

    /**
     * Gets the value of the pagesize property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPAGESIZE() {
        return pagesize;
    }

    /**
     * Sets the value of the pagesize property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPAGESIZE(BigDecimal value) {
        this.pagesize = value;
    }

    /**
     * Gets the value of the currentpage property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCURRENTPAGE() {
        return currentpage;
    }

    /**
     * Sets the value of the currentpage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCURRENTPAGE(BigDecimal value) {
        this.currentpage = value;
    }

    /**
     * Gets the value of the totalrecord property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTOTALRECORD() {
        return totalrecord;
    }

    /**
     * Sets the value of the totalrecord property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTOTALRECORD(BigDecimal value) {
        this.totalrecord = value;
    }

    /**
     * Gets the value of the routecode1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getROUTECODE1() {
        return routecode1;
    }

    /**
     * Sets the value of the routecode1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setROUTECODE1(String value) {
        this.routecode1 = value;
    }

    /**
     * Gets the value of the routecode2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getROUTECODE2() {
        return routecode2;
    }

    /**
     * Sets the value of the routecode2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setROUTECODE2(String value) {
        this.routecode2 = value;
    }

}
