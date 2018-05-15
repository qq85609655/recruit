
package com.csot.recruit.soa.start;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ESB_OA_OA_ImportStandardProcessSrvRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ESB_OA_OA_ImportStandardProcessSrvRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgHeader" type="{http://www.csot.tcl.com/MsgHeader/1.0}MsgHeader"/>
 *         &lt;element name="ESB_OA_OA_ImportStandardProcessSrvInputCollection" type="{http://www.csot.tcl.com/ESB_OA_OA_ImportStandardProcessSrv/1.0}ESB_OA_OA_ImportStandardProcessSrvInputCollection"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESB_OA_OA_ImportStandardProcessSrvRequest", propOrder = {
    "msgHeader",
    "esboaoaImportStandardProcessSrvInputCollection"
})
public class ESBOAOAImportStandardProcessSrvRequest {

    @XmlElement(name = "MsgHeader", required = true)
    protected MsgHeader msgHeader;
    @XmlElement(name = "ESB_OA_OA_ImportStandardProcessSrvInputCollection", required = true)
    protected ESBOAOAImportStandardProcessSrvInputCollection esboaoaImportStandardProcessSrvInputCollection;

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
     * ��ȡesboaoaImportStandardProcessSrvInputCollection���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ESBOAOAImportStandardProcessSrvInputCollection }
     *     
     */
    public ESBOAOAImportStandardProcessSrvInputCollection getESBOAOAImportStandardProcessSrvInputCollection() {
        return esboaoaImportStandardProcessSrvInputCollection;
    }

    /**
     * ����esboaoaImportStandardProcessSrvInputCollection���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ESBOAOAImportStandardProcessSrvInputCollection }
     *     
     */
    public void setESBOAOAImportStandardProcessSrvInputCollection(ESBOAOAImportStandardProcessSrvInputCollection value) {
        this.esboaoaImportStandardProcessSrvInputCollection = value;
    }

}
