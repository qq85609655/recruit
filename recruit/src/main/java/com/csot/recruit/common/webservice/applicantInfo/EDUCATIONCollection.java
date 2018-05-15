
package com.csot.recruit.common.webservice.applicantInfo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>EDUCATION_Collection complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="EDUCATION_Collection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EDUCATION_Item" type="{http://www.csot.tcl.com/ESB_HRZP_HRZP_InquiryApplicantInfoSrv/1.0}EDUCATION_Item" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EDUCATION_Collection", propOrder = {
    "educationItem"
})
public class EDUCATIONCollection {

    @XmlElement(name = "EDUCATION_Item")
    protected List<EDUCATIONItem> educationItem;

    /**
     * Gets the value of the educationItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the educationItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEDUCATIONItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EDUCATIONItem }
     * 
     * 
     */
    public List<EDUCATIONItem> getEDUCATIONItem() {
        if (educationItem == null) {
            educationItem = new ArrayList<EDUCATIONItem>();
        }
        return this.educationItem;
    }

}
