
package com.csot.recruit.common.webservice.outside.postingExtra;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.recruit package. 
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

    private final static QName _ESBGYDGYDInquiryPostingExtraSrvResponse_QNAME = new QName("http://www.csot.tcl.com/ESB_GYD_GYD_InquiryPostingExtraSrv/1.0", "ESB_GYD_GYD_InquiryPostingExtraSrvResponse");
    private final static QName _ESBGYDGYDInquiryPostingExtraSrvRequest_QNAME = new QName("http://www.csot.tcl.com/ESB_GYD_GYD_InquiryPostingExtraSrv/1.0", "ESB_GYD_GYD_InquiryPostingExtraSrvRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.recruit
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
     * Create an instance of {@link ESBGYDGYDInquiryPostingExtraSrvRequest }
     * 
     */
    public ESBGYDGYDInquiryPostingExtraSrvRequest createESBGYDGYDInquiryPostingExtraSrvRequest() {
        return new ESBGYDGYDInquiryPostingExtraSrvRequest();
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryPostingExtraSrvResponse }
     * 
     */
    public ESBGYDGYDInquiryPostingExtraSrvResponse createESBGYDGYDInquiryPostingExtraSrvResponse() {
        return new ESBGYDGYDInquiryPostingExtraSrvResponse();
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryPostingExtraSrvOutputItem }
     * 
     */
    public ESBGYDGYDInquiryPostingExtraSrvOutputItem createESBGYDGYDInquiryPostingExtraSrvOutputItem() {
        return new ESBGYDGYDInquiryPostingExtraSrvOutputItem();
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryPostingExtraSrvOutputCollection }
     * 
     */
    public ESBGYDGYDInquiryPostingExtraSrvOutputCollection createESBGYDGYDInquiryPostingExtraSrvOutputCollection() {
        return new ESBGYDGYDInquiryPostingExtraSrvOutputCollection();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBGYDGYDInquiryPostingExtraSrvResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryPostingExtraSrv/1.0", name = "ESB_GYD_GYD_InquiryPostingExtraSrvResponse")
    public JAXBElement<ESBGYDGYDInquiryPostingExtraSrvResponse> createESBGYDGYDInquiryPostingExtraSrvResponse(ESBGYDGYDInquiryPostingExtraSrvResponse value) {
        return new JAXBElement<ESBGYDGYDInquiryPostingExtraSrvResponse>(_ESBGYDGYDInquiryPostingExtraSrvResponse_QNAME, ESBGYDGYDInquiryPostingExtraSrvResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBGYDGYDInquiryPostingExtraSrvRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryPostingExtraSrv/1.0", name = "ESB_GYD_GYD_InquiryPostingExtraSrvRequest")
    public JAXBElement<ESBGYDGYDInquiryPostingExtraSrvRequest> createESBGYDGYDInquiryPostingExtraSrvRequest(ESBGYDGYDInquiryPostingExtraSrvRequest value) {
        return new JAXBElement<ESBGYDGYDInquiryPostingExtraSrvRequest>(_ESBGYDGYDInquiryPostingExtraSrvRequest_QNAME, ESBGYDGYDInquiryPostingExtraSrvRequest.class, null, value);
    }

}
