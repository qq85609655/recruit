
package com.csot.recruit.common.webservice.outside.parseDocument;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ESB_GYD_GYD_InquiryParseDocumentSrvOutputCollection complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ESB_GYD_GYD_InquiryParseDocumentSrvOutputCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ESB_GYD_GYD_InquiryParseDocumentSrvOutputItem" type="{http://www.csot.tcl.com/ESB_GYD_GYD_InquiryParseDocumentSrv/1.0}ESB_GYD_GYD_InquiryParseDocumentSrvOutputItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESB_GYD_GYD_InquiryParseDocumentSrvOutputCollection", propOrder = {
    "esbgydgydInquiryParseDocumentSrvOutputItem"
})
public class ESBGYDGYDInquiryParseDocumentSrvOutputCollection {

    @XmlElement(name = "ESB_GYD_GYD_InquiryParseDocumentSrvOutputItem")
    protected List<ESBGYDGYDInquiryParseDocumentSrvOutputItem> esbgydgydInquiryParseDocumentSrvOutputItem;

    /**
     * Gets the value of the esbgydgydInquiryParseDocumentSrvOutputItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the esbgydgydInquiryParseDocumentSrvOutputItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getESBGYDGYDInquiryParseDocumentSrvOutputItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ESBGYDGYDInquiryParseDocumentSrvOutputItem }
     * 
     * 
     */
    public List<ESBGYDGYDInquiryParseDocumentSrvOutputItem> getESBGYDGYDInquiryParseDocumentSrvOutputItem() {
        if (esbgydgydInquiryParseDocumentSrvOutputItem == null) {
            esbgydgydInquiryParseDocumentSrvOutputItem = new ArrayList<ESBGYDGYDInquiryParseDocumentSrvOutputItem>();
        }
        return this.esbgydgydInquiryParseDocumentSrvOutputItem;
    }

}
