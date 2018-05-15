
package com.csot.recruit.common.webservice.outside.sms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ErrorItem complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ErrorItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ENTITY_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PRI_KEY" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ERROR_MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RESERVED_2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ErrorItem", propOrder = {
    "entityname",
    "prikey",
    "errormessage",
    "reserved1",
    "reserved2"
})
public class ErrorItem {

    @XmlElement(name = "ENTITY_NAME", required = true, nillable = true)
    protected String entityname;
    @XmlElement(name = "PRI_KEY", required = true, nillable = true)
    protected String prikey;
    @XmlElement(name = "ERROR_MESSAGE", required = true, nillable = true)
    protected String errormessage;
    @XmlElement(name = "RESERVED_1", required = true, nillable = true)
    protected String reserved1;
    @XmlElement(name = "RESERVED_2", required = true, nillable = true)
    protected String reserved2;

    /**
     * ��ȡentityname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTITYNAME() {
        return entityname;
    }

    /**
     * ����entityname���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTITYNAME(String value) {
        this.entityname = value;
    }

    /**
     * ��ȡprikey���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRIKEY() {
        return prikey;
    }

    /**
     * ����prikey���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRIKEY(String value) {
        this.prikey = value;
    }

    /**
     * ��ȡerrormessage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getERRORMESSAGE() {
        return errormessage;
    }

    /**
     * ����errormessage���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setERRORMESSAGE(String value) {
        this.errormessage = value;
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

}
