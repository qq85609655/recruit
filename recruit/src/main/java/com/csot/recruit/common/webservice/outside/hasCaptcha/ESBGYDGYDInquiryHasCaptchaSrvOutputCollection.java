
package com.csot.recruit.common.webservice.outside.hasCaptcha;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem" type="{http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0}ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputCollection", propOrder = {
    "esbgydgydInquiryHasCaptchaSrvOutputItem"
})
public class ESBGYDGYDInquiryHasCaptchaSrvOutputCollection {

    @XmlElement(name = "ESB_GYD_GYD_InquiryHasCaptchaSrvOutputItem")
    protected List<ESBGYDGYDInquiryHasCaptchaSrvOutputItem> esbgydgydInquiryHasCaptchaSrvOutputItem;

    /**
     * Gets the value of the esbgydgydInquiryHasCaptchaSrvOutputItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the esbgydgydInquiryHasCaptchaSrvOutputItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getESBGYDGYDInquiryHasCaptchaSrvOutputItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ESBGYDGYDInquiryHasCaptchaSrvOutputItem }
     * 
     * 
     */
    public List<ESBGYDGYDInquiryHasCaptchaSrvOutputItem> getESBGYDGYDInquiryHasCaptchaSrvOutputItem() {
        if (esbgydgydInquiryHasCaptchaSrvOutputItem == null) {
            esbgydgydInquiryHasCaptchaSrvOutputItem = new ArrayList<ESBGYDGYDInquiryHasCaptchaSrvOutputItem>();
        }
        return this.esbgydgydInquiryHasCaptchaSrvOutputItem;
    }

}
