
package com.csot.gm.esbws.importUpdatePartInfoSrv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ESB_GM_GM_ImportUpdatePartInfoSrvInputCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ESB_GM_GM_ImportUpdatePartInfoSrvInputCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ESB_GM_GM_ImportUpdatePartInfoSrvInputItem" type="{http://www.csot.tcl.com/ESB_GM_GM_ImportUpdatePartInfoSrv/1.0}ESB_GM_GM_ImportUpdatePartInfoSrvInputItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESB_GM_GM_ImportUpdatePartInfoSrvInputCollection", propOrder = {
    "esbgmgmImportUpdatePartInfoSrvInputItem"
})
public class ESBGMGMImportUpdatePartInfoSrvInputCollection {

    @XmlElement(name = "ESB_GM_GM_ImportUpdatePartInfoSrvInputItem")
    protected List<ESBGMGMImportUpdatePartInfoSrvInputItem> esbgmgmImportUpdatePartInfoSrvInputItem;

    /**
     * Gets the value of the esbgmgmImportUpdatePartInfoSrvInputItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the esbgmgmImportUpdatePartInfoSrvInputItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getESBGMGMImportUpdatePartInfoSrvInputItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ESBGMGMImportUpdatePartInfoSrvInputItem }
     * 
     * 
     */
    public List<ESBGMGMImportUpdatePartInfoSrvInputItem> getESBGMGMImportUpdatePartInfoSrvInputItem() {
        if (esbgmgmImportUpdatePartInfoSrvInputItem == null) {
            esbgmgmImportUpdatePartInfoSrvInputItem = new ArrayList<ESBGMGMImportUpdatePartInfoSrvInputItem>();
        }
        return this.esbgmgmImportUpdatePartInfoSrvInputItem;
    }

}
