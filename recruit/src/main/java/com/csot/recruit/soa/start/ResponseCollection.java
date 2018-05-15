
package com.csot.recruit.soa.start;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ResponseCollection complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ResponseCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResponseItem" type="{http://www.csot.tcl.com/ESB_OA_OA_ImportStandardProcessSrv/1.0}ResponseItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseCollection", propOrder = {
    "responseItem"
})
public class ResponseCollection {

    @XmlElement(name = "ResponseItem")
    protected List<ResponseItem> responseItem;

    /**
     * Gets the value of the responseItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the responseItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResponseItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResponseItem }
     * 
     * 
     */
    public List<ResponseItem> getResponseItem() {
        if (responseItem == null) {
            responseItem = new ArrayList<ResponseItem>();
        }
        return this.responseItem;
    }

}
