
package com.csot.recruit.common.webservice.outside.sms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ESB_ESB_SMS_ImportSmsSrvRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ESB_ESB_SMS_ImportSmsSrvRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgHeader" type="{http://www.csot.tcl.com/MsgHeader/1.0}MsgHeader"/>
 *         &lt;element name="ESB_ESB_SMS_ImportSmsSrvInputCollection" type="{http://www.csot.tcl.com/ESB_ESB_SMS_ImportSmsSrv/1.0}ESB_ESB_SMS_ImportSmsSrvInputCollection"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESB_ESB_SMS_ImportSmsSrvRequest", propOrder = {
    "msgHeader",
    "esbesbsmsImportSmsSrvInputCollection"
})
public class ESBESBSMSImportSmsSrvRequest {

    @XmlElement(name = "MsgHeader", required = true)
    protected MsgHeader msgHeader;
    @XmlElement(name = "ESB_ESB_SMS_ImportSmsSrvInputCollection", required = true)
    protected ESBESBSMSImportSmsSrvInputCollection esbesbsmsImportSmsSrvInputCollection;

    /**
     * ��ȡmsgHeader���Ե�ֵ��
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
     * ����msgHeader���Ե�ֵ��
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
     * ��ȡesbesbsmsImportSmsSrvInputCollection���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ESBESBSMSImportSmsSrvInputCollection }
     *     
     */
    public ESBESBSMSImportSmsSrvInputCollection getESBESBSMSImportSmsSrvInputCollection() {
        return esbesbsmsImportSmsSrvInputCollection;
    }

    /**
     * ����esbesbsmsImportSmsSrvInputCollection���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ESBESBSMSImportSmsSrvInputCollection }
     *     
     */
    public void setESBESBSMSImportSmsSrvInputCollection(ESBESBSMSImportSmsSrvInputCollection value) {
        this.esbesbsmsImportSmsSrvInputCollection = value;
    }

}
