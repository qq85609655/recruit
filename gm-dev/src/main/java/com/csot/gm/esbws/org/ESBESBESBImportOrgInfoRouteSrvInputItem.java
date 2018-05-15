
package com.csot.gm.esbws.org;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ESB_ESB_ESB_ImportOrgInfoRouteSrvInputItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ESB_ESB_ESB_ImportOrgInfoRouteSrvInputItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PRI_KEY" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="OPERATE_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_ORGNAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_OLD_ORGCODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_ORGCODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_ORGTYPE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="C_OLD_CHARGECODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_CHARGECODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_OLD_ORGPARENTCODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_ORGPARENTCODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_OLD_ORGPARENTLEAD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_ORGPARENTLEAD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_AVAILABLE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_SORT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="C_KEY" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_REMARK" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_STATUS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ORGID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="KOSTL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="KOSTLT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_ONEUNIT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_TWOUNIT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_THREEUNIT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_FOURUNIT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_FIVEUNIT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IS_TEMP_ORG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="C_OPERATORTIME" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="FD_PRIMARY_KEY" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FD_STATUS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FD_EXCUTE_TIME" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="FD_IS_UPDATED" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FD_UPDATE_EMP_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FD_UPDATE_TIME" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="RESERVED_1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_4" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_5" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_6" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_7" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_8" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_9" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_10" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_11" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_12" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_13" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_14" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_15" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_16" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_17" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_18" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_19" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_20" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESB_ESB_ESB_ImportOrgInfoRouteSrvInputItem", propOrder = {
    "prikey",
    "operatetype",
    "corgname",
    "coldorgcode",
    "corgcode",
    "corgtype",
    "coldchargecode",
    "cchargecode",
    "coldorgparentcode",
    "corgparentcode",
    "coldorgparentlead",
    "corgparentlead",
    "cavailable",
    "csort",
    "ckey",
    "cremark",
    "cstatus",
    "orgid",
    "kostl",
    "kostlt",
    "coneunit",
    "ctwounit",
    "cthreeunit",
    "cfourunit",
    "cfiveunit",
    "istemporg",
    "coperatortime",
    "fdprimarykey",
    "fdstatus",
    "fdexcutetime",
    "fdisupdated",
    "fdupdateempno",
    "fdupdatetime",
    "reserved1",
    "reserved2",
    "reserved3",
    "reserved4",
    "reserved5",
    "reserved6",
    "reserved7",
    "reserved8",
    "reserved9",
    "reserved10",
    "reserved11",
    "reserved12",
    "reserved13",
    "reserved14",
    "reserved15",
    "reserved16",
    "reserved17",
    "reserved18",
    "reserved19",
    "reserved20"
})
public class ESBESBESBImportOrgInfoRouteSrvInputItem {

    @XmlElement(name = "PRI_KEY", required = true, nillable = true)
    protected BigDecimal prikey;
    @XmlElement(name = "OPERATE_TYPE", required = true, nillable = true)
    protected String operatetype;
    @XmlElement(name = "C_ORGNAME", required = true, nillable = true)
    protected String corgname;
    @XmlElement(name = "C_OLD_ORGCODE", required = true, nillable = true)
    protected String coldorgcode;
    @XmlElement(name = "C_ORGCODE", required = true, nillable = true)
    protected String corgcode;
    @XmlElement(name = "C_ORGTYPE", required = true, nillable = true)
    protected BigDecimal corgtype;
    @XmlElement(name = "C_OLD_CHARGECODE", required = true, nillable = true)
    protected String coldchargecode;
    @XmlElement(name = "C_CHARGECODE", required = true, nillable = true)
    protected String cchargecode;
    @XmlElement(name = "C_OLD_ORGPARENTCODE", required = true, nillable = true)
    protected String coldorgparentcode;
    @XmlElement(name = "C_ORGPARENTCODE", required = true, nillable = true)
    protected String corgparentcode;
    @XmlElement(name = "C_OLD_ORGPARENTLEAD", required = true, nillable = true)
    protected String coldorgparentlead;
    @XmlElement(name = "C_ORGPARENTLEAD", required = true, nillable = true)
    protected String corgparentlead;
    @XmlElement(name = "C_AVAILABLE", required = true, nillable = true)
    protected String cavailable;
    @XmlElement(name = "C_SORT", required = true, nillable = true)
    protected BigDecimal csort;
    @XmlElement(name = "C_KEY", required = true, nillable = true)
    protected String ckey;
    @XmlElement(name = "C_REMARK", required = true, nillable = true)
    protected String cremark;
    @XmlElement(name = "C_STATUS", required = true, nillable = true)
    protected String cstatus;
    @XmlElement(name = "ORGID", required = true, nillable = true)
    protected String orgid;
    @XmlElement(name = "KOSTL", required = true, nillable = true)
    protected String kostl;
    @XmlElement(name = "KOSTLT", required = true, nillable = true)
    protected String kostlt;
    @XmlElement(name = "C_ONEUNIT", required = true, nillable = true)
    protected String coneunit;
    @XmlElement(name = "C_TWOUNIT", required = true, nillable = true)
    protected String ctwounit;
    @XmlElement(name = "C_THREEUNIT", required = true, nillable = true)
    protected String cthreeunit;
    @XmlElement(name = "C_FOURUNIT", required = true, nillable = true)
    protected String cfourunit;
    @XmlElement(name = "C_FIVEUNIT", required = true, nillable = true)
    protected String cfiveunit;
    @XmlElement(name = "IS_TEMP_ORG", required = true, nillable = true)
    protected String istemporg;
    @XmlElement(name = "C_OPERATORTIME", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar coperatortime;
    @XmlElement(name = "FD_PRIMARY_KEY", required = true, nillable = true)
    protected String fdprimarykey;
    @XmlElement(name = "FD_STATUS", required = true, nillable = true)
    protected String fdstatus;
    @XmlElement(name = "FD_EXCUTE_TIME", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fdexcutetime;
    @XmlElement(name = "FD_IS_UPDATED", required = true, nillable = true)
    protected String fdisupdated;
    @XmlElement(name = "FD_UPDATE_EMP_NO", required = true, nillable = true)
    protected String fdupdateempno;
    @XmlElement(name = "FD_UPDATE_TIME", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fdupdatetime;
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
    @XmlElement(name = "RESERVED_6", required = true, nillable = true)
    protected String reserved6;
    @XmlElement(name = "RESERVED_7", required = true, nillable = true)
    protected String reserved7;
    @XmlElement(name = "RESERVED_8", required = true, nillable = true)
    protected String reserved8;
    @XmlElement(name = "RESERVED_9", required = true, nillable = true)
    protected String reserved9;
    @XmlElement(name = "RESERVED_10", required = true, nillable = true)
    protected String reserved10;
    @XmlElement(name = "RESERVED_11", required = true, nillable = true)
    protected String reserved11;
    @XmlElement(name = "RESERVED_12", required = true, nillable = true)
    protected String reserved12;
    @XmlElement(name = "RESERVED_13", required = true, nillable = true)
    protected String reserved13;
    @XmlElement(name = "RESERVED_14", required = true, nillable = true)
    protected String reserved14;
    @XmlElement(name = "RESERVED_15", required = true, nillable = true)
    protected String reserved15;
    @XmlElement(name = "RESERVED_16", required = true, nillable = true)
    protected String reserved16;
    @XmlElement(name = "RESERVED_17", required = true, nillable = true)
    protected String reserved17;
    @XmlElement(name = "RESERVED_18", required = true, nillable = true)
    protected String reserved18;
    @XmlElement(name = "RESERVED_19", required = true, nillable = true)
    protected String reserved19;
    @XmlElement(name = "RESERVED_20", required = true, nillable = true)
    protected String reserved20;

    /**
     * Gets the value of the prikey property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPRIKEY() {
        return prikey;
    }

    /**
     * Sets the value of the prikey property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPRIKEY(BigDecimal value) {
        this.prikey = value;
    }

    /**
     * Gets the value of the operatetype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPERATETYPE() {
        return operatetype;
    }

    /**
     * Sets the value of the operatetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPERATETYPE(String value) {
        this.operatetype = value;
    }

    /**
     * Gets the value of the corgname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCORGNAME() {
        return corgname;
    }

    /**
     * Sets the value of the corgname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCORGNAME(String value) {
        this.corgname = value;
    }

    /**
     * Gets the value of the coldorgcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOLDORGCODE() {
        return coldorgcode;
    }

    /**
     * Sets the value of the coldorgcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOLDORGCODE(String value) {
        this.coldorgcode = value;
    }

    /**
     * Gets the value of the corgcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCORGCODE() {
        return corgcode;
    }

    /**
     * Sets the value of the corgcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCORGCODE(String value) {
        this.corgcode = value;
    }

    /**
     * Gets the value of the corgtype property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCORGTYPE() {
        return corgtype;
    }

    /**
     * Sets the value of the corgtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCORGTYPE(BigDecimal value) {
        this.corgtype = value;
    }

    /**
     * Gets the value of the coldchargecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOLDCHARGECODE() {
        return coldchargecode;
    }

    /**
     * Sets the value of the coldchargecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOLDCHARGECODE(String value) {
        this.coldchargecode = value;
    }

    /**
     * Gets the value of the cchargecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCHARGECODE() {
        return cchargecode;
    }

    /**
     * Sets the value of the cchargecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCHARGECODE(String value) {
        this.cchargecode = value;
    }

    /**
     * Gets the value of the coldorgparentcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOLDORGPARENTCODE() {
        return coldorgparentcode;
    }

    /**
     * Sets the value of the coldorgparentcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOLDORGPARENTCODE(String value) {
        this.coldorgparentcode = value;
    }

    /**
     * Gets the value of the corgparentcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCORGPARENTCODE() {
        return corgparentcode;
    }

    /**
     * Sets the value of the corgparentcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCORGPARENTCODE(String value) {
        this.corgparentcode = value;
    }

    /**
     * Gets the value of the coldorgparentlead property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOLDORGPARENTLEAD() {
        return coldorgparentlead;
    }

    /**
     * Sets the value of the coldorgparentlead property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOLDORGPARENTLEAD(String value) {
        this.coldorgparentlead = value;
    }

    /**
     * Gets the value of the corgparentlead property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCORGPARENTLEAD() {
        return corgparentlead;
    }

    /**
     * Sets the value of the corgparentlead property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCORGPARENTLEAD(String value) {
        this.corgparentlead = value;
    }

    /**
     * Gets the value of the cavailable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAVAILABLE() {
        return cavailable;
    }

    /**
     * Sets the value of the cavailable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAVAILABLE(String value) {
        this.cavailable = value;
    }

    /**
     * Gets the value of the csort property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCSORT() {
        return csort;
    }

    /**
     * Sets the value of the csort property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCSORT(BigDecimal value) {
        this.csort = value;
    }

    /**
     * Gets the value of the ckey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCKEY() {
        return ckey;
    }

    /**
     * Sets the value of the ckey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCKEY(String value) {
        this.ckey = value;
    }

    /**
     * Gets the value of the cremark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREMARK() {
        return cremark;
    }

    /**
     * Sets the value of the cremark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREMARK(String value) {
        this.cremark = value;
    }

    /**
     * Gets the value of the cstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSTATUS() {
        return cstatus;
    }

    /**
     * Sets the value of the cstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSTATUS(String value) {
        this.cstatus = value;
    }

    /**
     * Gets the value of the orgid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORGID() {
        return orgid;
    }

    /**
     * Sets the value of the orgid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORGID(String value) {
        this.orgid = value;
    }

    /**
     * Gets the value of the kostl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKOSTL() {
        return kostl;
    }

    /**
     * Sets the value of the kostl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKOSTL(String value) {
        this.kostl = value;
    }

    /**
     * Gets the value of the kostlt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKOSTLT() {
        return kostlt;
    }

    /**
     * Sets the value of the kostlt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKOSTLT(String value) {
        this.kostlt = value;
    }

    /**
     * Gets the value of the coneunit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONEUNIT() {
        return coneunit;
    }

    /**
     * Sets the value of the coneunit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONEUNIT(String value) {
        this.coneunit = value;
    }

    /**
     * Gets the value of the ctwounit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCTWOUNIT() {
        return ctwounit;
    }

    /**
     * Sets the value of the ctwounit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCTWOUNIT(String value) {
        this.ctwounit = value;
    }

    /**
     * Gets the value of the cthreeunit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCTHREEUNIT() {
        return cthreeunit;
    }

    /**
     * Sets the value of the cthreeunit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCTHREEUNIT(String value) {
        this.cthreeunit = value;
    }

    /**
     * Gets the value of the cfourunit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFOURUNIT() {
        return cfourunit;
    }

    /**
     * Sets the value of the cfourunit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFOURUNIT(String value) {
        this.cfourunit = value;
    }

    /**
     * Gets the value of the cfiveunit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFIVEUNIT() {
        return cfiveunit;
    }

    /**
     * Sets the value of the cfiveunit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFIVEUNIT(String value) {
        this.cfiveunit = value;
    }

    /**
     * Gets the value of the istemporg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISTEMPORG() {
        return istemporg;
    }

    /**
     * Sets the value of the istemporg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISTEMPORG(String value) {
        this.istemporg = value;
    }

    /**
     * Gets the value of the coperatortime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCOPERATORTIME() {
        return coperatortime;
    }

    /**
     * Sets the value of the coperatortime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCOPERATORTIME(XMLGregorianCalendar value) {
        this.coperatortime = value;
    }

    /**
     * Gets the value of the fdprimarykey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFDPRIMARYKEY() {
        return fdprimarykey;
    }

    /**
     * Sets the value of the fdprimarykey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFDPRIMARYKEY(String value) {
        this.fdprimarykey = value;
    }

    /**
     * Gets the value of the fdstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFDSTATUS() {
        return fdstatus;
    }

    /**
     * Sets the value of the fdstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFDSTATUS(String value) {
        this.fdstatus = value;
    }

    /**
     * Gets the value of the fdexcutetime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFDEXCUTETIME() {
        return fdexcutetime;
    }

    /**
     * Sets the value of the fdexcutetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFDEXCUTETIME(XMLGregorianCalendar value) {
        this.fdexcutetime = value;
    }

    /**
     * Gets the value of the fdisupdated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFDISUPDATED() {
        return fdisupdated;
    }

    /**
     * Sets the value of the fdisupdated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFDISUPDATED(String value) {
        this.fdisupdated = value;
    }

    /**
     * Gets the value of the fdupdateempno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFDUPDATEEMPNO() {
        return fdupdateempno;
    }

    /**
     * Sets the value of the fdupdateempno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFDUPDATEEMPNO(String value) {
        this.fdupdateempno = value;
    }

    /**
     * Gets the value of the fdupdatetime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFDUPDATETIME() {
        return fdupdatetime;
    }

    /**
     * Sets the value of the fdupdatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFDUPDATETIME(XMLGregorianCalendar value) {
        this.fdupdatetime = value;
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
     * Gets the value of the reserved6 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED6() {
        return reserved6;
    }

    /**
     * Sets the value of the reserved6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED6(String value) {
        this.reserved6 = value;
    }

    /**
     * Gets the value of the reserved7 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED7() {
        return reserved7;
    }

    /**
     * Sets the value of the reserved7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED7(String value) {
        this.reserved7 = value;
    }

    /**
     * Gets the value of the reserved8 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED8() {
        return reserved8;
    }

    /**
     * Sets the value of the reserved8 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED8(String value) {
        this.reserved8 = value;
    }

    /**
     * Gets the value of the reserved9 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED9() {
        return reserved9;
    }

    /**
     * Sets the value of the reserved9 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED9(String value) {
        this.reserved9 = value;
    }

    /**
     * Gets the value of the reserved10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED10() {
        return reserved10;
    }

    /**
     * Sets the value of the reserved10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED10(String value) {
        this.reserved10 = value;
    }

    /**
     * Gets the value of the reserved11 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED11() {
        return reserved11;
    }

    /**
     * Sets the value of the reserved11 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED11(String value) {
        this.reserved11 = value;
    }

    /**
     * Gets the value of the reserved12 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED12() {
        return reserved12;
    }

    /**
     * Sets the value of the reserved12 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED12(String value) {
        this.reserved12 = value;
    }

    /**
     * Gets the value of the reserved13 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED13() {
        return reserved13;
    }

    /**
     * Sets the value of the reserved13 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED13(String value) {
        this.reserved13 = value;
    }

    /**
     * Gets the value of the reserved14 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED14() {
        return reserved14;
    }

    /**
     * Sets the value of the reserved14 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED14(String value) {
        this.reserved14 = value;
    }

    /**
     * Gets the value of the reserved15 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED15() {
        return reserved15;
    }

    /**
     * Sets the value of the reserved15 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED15(String value) {
        this.reserved15 = value;
    }

    /**
     * Gets the value of the reserved16 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED16() {
        return reserved16;
    }

    /**
     * Sets the value of the reserved16 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED16(String value) {
        this.reserved16 = value;
    }

    /**
     * Gets the value of the reserved17 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED17() {
        return reserved17;
    }

    /**
     * Sets the value of the reserved17 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED17(String value) {
        this.reserved17 = value;
    }

    /**
     * Gets the value of the reserved18 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED18() {
        return reserved18;
    }

    /**
     * Sets the value of the reserved18 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED18(String value) {
        this.reserved18 = value;
    }

    /**
     * Gets the value of the reserved19 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED19() {
        return reserved19;
    }

    /**
     * Sets the value of the reserved19 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED19(String value) {
        this.reserved19 = value;
    }

    /**
     * Gets the value of the reserved20 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED20() {
        return reserved20;
    }

    /**
     * Sets the value of the reserved20 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED20(String value) {
        this.reserved20 = value;
    }

}
