
package com.csot.recruit.soa.status;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ESB_ESB_ESB_ImportProcessStatusSrvRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ESB_ESB_ESB_ImportProcessStatusSrvRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgHeader" type="{http://www.csot.tcl.com/MsgHeader/1.0}MsgHeader"/>
 *         &lt;element name="ESB_ESB_ESB_ImportProcessStatusSrvInputCollection" type="{http://www.csot.tcl.com/ESB_ESB_ESB_ImportProcessStatusSrv/1.0}ESB_ESB_ESB_ImportProcessStatusSrvInputCollection"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESB_ESB_ESB_ImportProcessStatusSrvRequest", propOrder = {
    "msgHeader",
    "esbesbesbImportProcessStatusSrvInputCollection"
})
public class ESBESBESBImportProcessStatusSrvRequest {

    @XmlElement(name = "MsgHeader", required = true)
    protected MsgHeader msgHeader;
    @XmlElement(name = "ESB_ESB_ESB_ImportProcessStatusSrvInputCollection", required = true)
    protected ESBESBESBImportProcessStatusSrvInputCollection esbesbesbImportProcessStatusSrvInputCollection;

    /**
     * 获取msgHeader属性的值。
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
     * 设置msgHeader属性的值。
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
     * 获取esbesbesbImportProcessStatusSrvInputCollection属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ESBESBESBImportProcessStatusSrvInputCollection }
     *     
     */
    public ESBESBESBImportProcessStatusSrvInputCollection getESBESBESBImportProcessStatusSrvInputCollection() {
        return esbesbesbImportProcessStatusSrvInputCollection;
    }

    /**
     * 设置esbesbesbImportProcessStatusSrvInputCollection属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ESBESBESBImportProcessStatusSrvInputCollection }
     *     
     */
    public void setESBESBESBImportProcessStatusSrvInputCollection(ESBESBESBImportProcessStatusSrvInputCollection value) {
        this.esbesbesbImportProcessStatusSrvInputCollection = value;
    }

}
