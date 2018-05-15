
package com.csot.gm.esbws.inquiryPartInfoSrv;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.csot.gm.esbws.inquiryPartInfoSrv package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ESBGMGMInquiryPartInfoSrvRequest_QNAME = new QName("http://www.csot.tcl.com/ESB_GM_GM_InquiryPartInfoSrv/1.0", "ESB_GM_GM_InquiryPartInfoSrvRequest");
    private final static QName _ESBGMGMInquiryPartInfoSrvResponse_QNAME = new QName("http://www.csot.tcl.com/ESB_GM_GM_InquiryPartInfoSrv/1.0", "ESB_GM_GM_InquiryPartInfoSrvResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.csot.gm.esbws.inquiryPartInfoSrv
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MsgHeader }
     * 
     */
    public MsgHeader createMsgHeader() {
        return new MsgHeader();
    }

    /**
     * Create an instance of {@link ESBGMGMInquiryPartInfoSrvResponse }
     * 
     */
    public ESBGMGMInquiryPartInfoSrvResponse createESBGMGMInquiryPartInfoSrvResponse() {
        return new ESBGMGMInquiryPartInfoSrvResponse();
    }

    /**
     * Create an instance of {@link ESBGMGMInquiryPartInfoSrvRequest }
     * 
     */
    public ESBGMGMInquiryPartInfoSrvRequest createESBGMGMInquiryPartInfoSrvRequest() {
        return new ESBGMGMInquiryPartInfoSrvRequest();
    }

    /**
     * Create an instance of {@link ESBGMGMInquiryPartInfoSrvOutputItem }
     * 
     */
    public ESBGMGMInquiryPartInfoSrvOutputItem createESBGMGMInquiryPartInfoSrvOutputItem() {
        return new ESBGMGMInquiryPartInfoSrvOutputItem();
    }

    /**
     * Create an instance of {@link ESBGMGMInquiryPartInfoSrvOutputCollection }
     * 
     */
    public ESBGMGMInquiryPartInfoSrvOutputCollection createESBGMGMInquiryPartInfoSrvOutputCollection() {
        return new ESBGMGMInquiryPartInfoSrvOutputCollection();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBGMGMInquiryPartInfoSrvRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_GM_GM_InquiryPartInfoSrv/1.0", name = "ESB_GM_GM_InquiryPartInfoSrvRequest")
    public JAXBElement<ESBGMGMInquiryPartInfoSrvRequest> createESBGMGMInquiryPartInfoSrvRequest(ESBGMGMInquiryPartInfoSrvRequest value) {
        return new JAXBElement<ESBGMGMInquiryPartInfoSrvRequest>(_ESBGMGMInquiryPartInfoSrvRequest_QNAME, ESBGMGMInquiryPartInfoSrvRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBGMGMInquiryPartInfoSrvResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_GM_GM_InquiryPartInfoSrv/1.0", name = "ESB_GM_GM_InquiryPartInfoSrvResponse")
    public JAXBElement<ESBGMGMInquiryPartInfoSrvResponse> createESBGMGMInquiryPartInfoSrvResponse(ESBGMGMInquiryPartInfoSrvResponse value) {
        return new JAXBElement<ESBGMGMInquiryPartInfoSrvResponse>(_ESBGMGMInquiryPartInfoSrvResponse_QNAME, ESBGMGMInquiryPartInfoSrvResponse.class, null, value);
    }

}
