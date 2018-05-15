
package com.csot.recruit.common.webservice.applicantInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ESB_HRZP_HRZP_InquiryApplicantInfoSrvRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ESB_HRZP_HRZP_InquiryApplicantInfoSrvRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgHeader" type="{http://www.csot.tcl.com/MsgHeader/1.0}MsgHeader"/>
 *         &lt;element name="APPLICATION_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_4" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_5" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESB_HRZP_HRZP_InquiryApplicantInfoSrvRequest", propOrder = {
    "msgHeader",
    "applicationcode",
    "reserved1",
    "reserved2",
    "reserved3",
    "reserved4",
    "reserved5"
})
public class ESBHRZPHRZPInquiryApplicantInfoSrvRequest {

    @XmlElement(name = "MsgHeader", required = true)
    protected MsgHeader msgHeader;
    @XmlElement(name = "APPLICATION_CODE", required = true, nillable = true)
    protected String applicationcode;
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
     * ��ȡapplicationcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPPLICATIONCODE() {
        return applicationcode;
    }

    /**
     * ����applicationcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPPLICATIONCODE(String value) {
        this.applicationcode = value;
    }

    /**
     * ��ȡreserved1���Ե�ֵ��
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
     * ����reserved1���Ե�ֵ��
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
     * ��ȡreserved2���Ե�ֵ��
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
     * ����reserved2���Ե�ֵ��
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
     * ��ȡreserved3���Ե�ֵ��
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
     * ����reserved3���Ե�ֵ��
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
     * ��ȡreserved4���Ե�ֵ��
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
     * ����reserved4���Ե�ֵ��
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
     * ��ȡreserved5���Ե�ֵ��
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
     * ����reserved5���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED5(String value) {
        this.reserved5 = value;
    }

}
