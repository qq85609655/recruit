
package com.csot.recruit.common.webservice.applicantInfo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ESB_HRZP_HRZP_InquiryApplicantInfoSrvResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ESB_HRZP_HRZP_InquiryApplicantInfoSrvResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SERVICE_FLAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SERVICE_MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="INSTANCE_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TOTAL_RECORD" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TOTAL_PAGE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PAGE_SIZE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CURRENT_PAGE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ERROR_LEVEL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ERROR_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_4" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_5" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ESB_HRZP_HRZP_InquiryApplicantInfoSrvOutputCollection" type="{http://www.csot.tcl.com/ESB_HRZP_HRZP_InquiryApplicantInfoSrv/1.0}ESB_HRZP_HRZP_InquiryApplicantInfoSrvOutputCollection"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESB_HRZP_HRZP_InquiryApplicantInfoSrvResponse", propOrder = {
    "serviceflag",
    "servicemessage",
    "instanceid",
    "totalrecord",
    "totalpage",
    "pagesize",
    "currentpage",
    "errorlevel",
    "errorcode",
    "reserved1",
    "reserved2",
    "reserved3",
    "reserved4",
    "reserved5",
    "esbhrzphrzpInquiryApplicantInfoSrvOutputCollection"
})
public class ESBHRZPHRZPInquiryApplicantInfoSrvResponse {

    @XmlElement(name = "SERVICE_FLAG", required = true, nillable = true)
    protected String serviceflag;
    @XmlElement(name = "SERVICE_MESSAGE", required = true, nillable = true)
    protected String servicemessage;
    @XmlElement(name = "INSTANCE_ID", required = true, nillable = true)
    protected String instanceid;
    @XmlElement(name = "TOTAL_RECORD", required = true, nillable = true)
    protected BigDecimal totalrecord;
    @XmlElement(name = "TOTAL_PAGE", required = true, nillable = true)
    protected BigDecimal totalpage;
    @XmlElement(name = "PAGE_SIZE", required = true, nillable = true)
    protected BigDecimal pagesize;
    @XmlElement(name = "CURRENT_PAGE", required = true, nillable = true)
    protected BigDecimal currentpage;
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
    @XmlElement(name = "ESB_HRZP_HRZP_InquiryApplicantInfoSrvOutputCollection", required = true)
    protected ESBHRZPHRZPInquiryApplicantInfoSrvOutputCollection esbhrzphrzpInquiryApplicantInfoSrvOutputCollection;

    /**
     * ��ȡserviceflag���Ե�ֵ��
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
     * ����serviceflag���Ե�ֵ��
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
     * ��ȡservicemessage���Ե�ֵ��
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
     * ����servicemessage���Ե�ֵ��
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
     * ��ȡinstanceid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINSTANCEID() {
        return instanceid;
    }

    /**
     * ����instanceid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINSTANCEID(String value) {
        this.instanceid = value;
    }

    /**
     * ��ȡtotalrecord���Ե�ֵ��
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
     * ����totalrecord���Ե�ֵ��
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
     * ��ȡtotalpage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTOTALPAGE() {
        return totalpage;
    }

    /**
     * ����totalpage���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTOTALPAGE(BigDecimal value) {
        this.totalpage = value;
    }

    /**
     * ��ȡpagesize���Ե�ֵ��
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
     * ����pagesize���Ե�ֵ��
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
     * ��ȡcurrentpage���Ե�ֵ��
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
     * ����currentpage���Ե�ֵ��
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
     * ��ȡerrorlevel���Ե�ֵ��
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
     * ����errorlevel���Ե�ֵ��
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
     * ��ȡerrorcode���Ե�ֵ��
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
     * ����errorcode���Ե�ֵ��
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

    /**
     * ��ȡesbhrzphrzpInquiryApplicantInfoSrvOutputCollection���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ESBHRZPHRZPInquiryApplicantInfoSrvOutputCollection }
     *     
     */
    public ESBHRZPHRZPInquiryApplicantInfoSrvOutputCollection getESBHRZPHRZPInquiryApplicantInfoSrvOutputCollection() {
        return esbhrzphrzpInquiryApplicantInfoSrvOutputCollection;
    }

    /**
     * ����esbhrzphrzpInquiryApplicantInfoSrvOutputCollection���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ESBHRZPHRZPInquiryApplicantInfoSrvOutputCollection }
     *     
     */
    public void setESBHRZPHRZPInquiryApplicantInfoSrvOutputCollection(ESBHRZPHRZPInquiryApplicantInfoSrvOutputCollection value) {
        this.esbhrzphrzpInquiryApplicantInfoSrvOutputCollection = value;
    }

}