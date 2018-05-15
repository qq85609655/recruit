
package com.csot.recruit.common.webservice.outside.getCaptcha;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ESB_GYD_GYD_InquiryCaptchaSrvResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ESB_GYD_GYD_InquiryCaptchaSrvResponse">
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
 *         &lt;element name="ESB_GYD_GYD_InquiryCaptchaSrvOutputCollection" type="{http://www.csot.tcl.com/ESB_GYD_GYD_InquiryCaptchaSrv/1.0}ESB_GYD_GYD_InquiryCaptchaSrvOutputCollection"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESB_GYD_GYD_InquiryCaptchaSrvResponse", propOrder = {
    "serviceflag",
    "servicemessage",
    "instanceid",
    "totalrecord",
    "totalpage",
    "pagesize",
    "currentpage",
    "esbgydgydInquiryCaptchaSrvOutputCollection"
})
public class ESBGYDGYDInquiryCaptchaSrvResponse {

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
    @XmlElement(name = "ESB_GYD_GYD_InquiryCaptchaSrvOutputCollection", required = true)
    protected ESBGYDGYDInquiryCaptchaSrvOutputCollection esbgydgydInquiryCaptchaSrvOutputCollection;

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
     * ��ȡesbgydgydInquiryCaptchaSrvOutputCollection���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ESBGYDGYDInquiryCaptchaSrvOutputCollection }
     *     
     */
    public ESBGYDGYDInquiryCaptchaSrvOutputCollection getESBGYDGYDInquiryCaptchaSrvOutputCollection() {
        return esbgydgydInquiryCaptchaSrvOutputCollection;
    }

    /**
     * ����esbgydgydInquiryCaptchaSrvOutputCollection���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ESBGYDGYDInquiryCaptchaSrvOutputCollection }
     *     
     */
    public void setESBGYDGYDInquiryCaptchaSrvOutputCollection(ESBGYDGYDInquiryCaptchaSrvOutputCollection value) {
        this.esbgydgydInquiryCaptchaSrvOutputCollection = value;
    }

}
