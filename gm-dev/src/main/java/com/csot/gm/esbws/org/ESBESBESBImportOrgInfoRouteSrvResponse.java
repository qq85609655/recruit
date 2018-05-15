
package com.csot.gm.esbws.org;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ESB_ESB_ESB_ImportOrgInfoRouteSrvResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ESB_ESB_ESB_ImportOrgInfoRouteSrvResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SERVICE_FLAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="INSTANCE_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="SERVICE_MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ERROR_LEVEL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ERROR_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_4" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_5" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ErrorCollection" type="{http://www.csot.tcl.com/ESB_ESB_ESB_ImportOrgInfoRouteSrv/1.0}ErrorCollection"/>
 *         &lt;element name="ResponseCollection" type="{http://www.csot.tcl.com/ESB_ESB_ESB_ImportOrgInfoRouteSrv/1.0}ResponseCollection"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESB_ESB_ESB_ImportOrgInfoRouteSrvResponse", propOrder = {
    "serviceflag",
    "instanceid",
    "servicemessage",
    "errorlevel",
    "errorcode",
    "reserved1",
    "reserved2",
    "reserved3",
    "reserved4",
    "reserved5",
    "errorCollection",
    "responseCollection"
})
public class ESBESBESBImportOrgInfoRouteSrvResponse {

    @XmlElement(name = "SERVICE_FLAG", required = true, nillable = true)
    protected String serviceflag;
    @XmlElement(name = "INSTANCE_ID", required = true, nillable = true)
    protected BigDecimal instanceid;
    @XmlElement(name = "SERVICE_MESSAGE", required = true, nillable = true)
    protected String servicemessage;
    @XmlElement(name = "ERROR_LEVEL", required = true, nillable = true)
    protected String errorlevel;
    @XmlElement(name = "ERROR_CODE", required = true, nillable = true)
    protected String errorcode;
    @XmlElement(name = "RESERVED_1", required = true, nillable = true)
    protected String reserved1;
    @XmlElement(name = "RESERVED_2", required = true, nillable = true)
    protected String reserved2;
    @XmlElement(name = "RESERVED_3", required = true, nillable = true)
    protected String reserved3;
    @XmlElement(name = "RESERVED_4", required = true, nillable = true)
    protected String reserved4;
    @XmlElement(name = "RESERVED_5", required = true, nillable = true)
    protected String reserved5;
    @XmlElement(name = "ErrorCollection", required = true)
    protected ErrorCollection errorCollection;
    @XmlElement(name = "ResponseCollection", required = true)
    protected ResponseCollection responseCollection;

    /**
     * Gets the value of the serviceflag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVICEFLAG() {
        return serviceflag;
    }

    /**
     * Sets the value of the serviceflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVICEFLAG(String value) {
        this.serviceflag = value;
    }

    /**
     * Gets the value of the instanceid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getINSTANCEID() {
        return instanceid;
    }

    /**
     * Sets the value of the instanceid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setINSTANCEID(BigDecimal value) {
        this.instanceid = value;
    }

    /**
     * Gets the value of the servicemessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVICEMESSAGE() {
        return servicemessage;
    }

    /**
     * Sets the value of the servicemessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVICEMESSAGE(String value) {
        this.servicemessage = value;
    }

    /**
     * Gets the value of the errorlevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERRORLEVEL() {
        return errorlevel;
    }

    /**
     * Sets the value of the errorlevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERRORLEVEL(String value) {
        this.errorlevel = value;
    }

    /**
     * Gets the value of the errorcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERRORCODE() {
        return errorcode;
    }

    /**
     * Sets the value of the errorcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERRORCODE(String value) {
        this.errorcode = value;
    }

    /**
     * Gets the value of the reserved1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED1() {
        return reserved1;
    }

    /**
     * Sets the value of the reserved1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED1(String value) {
        this.reserved1 = value;
    }

    /**
     * Gets the value of the reserved2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED2() {
        return reserved2;
    }

    /**
     * Sets the value of the reserved2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED2(String value) {
        this.reserved2 = value;
    }

    /**
     * Gets the value of the reserved3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED3() {
        return reserved3;
    }

    /**
     * Sets the value of the reserved3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED3(String value) {
        this.reserved3 = value;
    }

    /**
     * Gets the value of the reserved4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED4() {
        return reserved4;
    }

    /**
     * Sets the value of the reserved4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED4(String value) {
        this.reserved4 = value;
    }

    /**
     * Gets the value of the reserved5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED5() {
        return reserved5;
    }

    /**
     * Sets the value of the reserved5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED5(String value) {
        this.reserved5 = value;
    }

    /**
     * Gets the value of the errorCollection property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorCollection }
     *     
     */
    public ErrorCollection getErrorCollection() {
        return errorCollection;
    }

    /**
     * Sets the value of the errorCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorCollection }
     *     
     */
    public void setErrorCollection(ErrorCollection value) {
        this.errorCollection = value;
    }

    /**
     * Gets the value of the responseCollection property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseCollection }
     *     
     */
    public ResponseCollection getResponseCollection() {
        return responseCollection;
    }

    /**
     * Sets the value of the responseCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseCollection }
     *     
     */
    public void setResponseCollection(ResponseCollection value) {
        this.responseCollection = value;
    }

}
