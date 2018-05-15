
package com.csot.gm.esbws.emp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ESB_ESB_ESB_ImportEmpBasicInfoRouteSrvRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ESB_ESB_ESB_ImportEmpBasicInfoRouteSrvRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgHeader" type="{http://www.csot.tcl.com/MsgHeader/1.0}MsgHeader"/>
 *         &lt;element name="ESB_ESB_ESB_ImportEmpBasicInfoRouteSrvInputCollection" type="{http://www.csot.tcl.com/ESB_ESB_ESB_ImportEmpBasicInfoRouteSrv/1.0}ESB_ESB_ESB_ImportEmpBasicInfoRouteSrvInputCollection"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESB_ESB_ESB_ImportEmpBasicInfoRouteSrvRequest", propOrder = {
    "msgHeader",
    "esbesbesbImportEmpBasicInfoRouteSrvInputCollection"
})
public class ESBESBESBImportEmpBasicInfoRouteSrvRequest {

    @XmlElement(name = "MsgHeader", required = true)
    protected MsgHeader msgHeader;
    @XmlElement(name = "ESB_ESB_ESB_ImportEmpBasicInfoRouteSrvInputCollection", required = true)
    protected ESBESBESBImportEmpBasicInfoRouteSrvInputCollection esbesbesbImportEmpBasicInfoRouteSrvInputCollection;

    /**
     * Gets the value of the msgHeader property.
     * 
     * @return
     *     possible object is
     *     {@link MsgHeader }
     *     
     */
    public MsgHeader getMsgHeader() {
        return msgHeader;
    }

    /**
     * Sets the value of the msgHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link MsgHeader }
     *     
     */
    public void setMsgHeader(MsgHeader value) {
        this.msgHeader = value;
    }

    /**
     * Gets the value of the esbesbesbImportEmpBasicInfoRouteSrvInputCollection property.
     * 
     * @return
     *     possible object is
     *     {@link ESBESBESBImportEmpBasicInfoRouteSrvInputCollection }
     *     
     */
    public ESBESBESBImportEmpBasicInfoRouteSrvInputCollection getESBESBESBImportEmpBasicInfoRouteSrvInputCollection() {
        return esbesbesbImportEmpBasicInfoRouteSrvInputCollection;
    }

    /**
     * Sets the value of the esbesbesbImportEmpBasicInfoRouteSrvInputCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link ESBESBESBImportEmpBasicInfoRouteSrvInputCollection }
     *     
     */
    public void setESBESBESBImportEmpBasicInfoRouteSrvInputCollection(ESBESBESBImportEmpBasicInfoRouteSrvInputCollection value) {
        this.esbesbesbImportEmpBasicInfoRouteSrvInputCollection = value;
    }

}
