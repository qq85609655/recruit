
package com.csot.recruit.common.webservice.outside.hasCaptcha;

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

    private final static QName _ESBGYDGYDInquiryHasCaptchaSrvRequest_QNAME = new QName("http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0", "ESB_GYD_GYD_InquiryHasCaptchaSrvRequest");
    private final static QName _ESBGYDGYDInquiryHasCaptchaSrvResponse_QNAME = new QName("http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0", "ESB_GYD_GYD_InquiryHasCaptchaSrvResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.recruit
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryHasCaptchaSrvRequest }
     * 
     */
    public ESBGYDGYDInquiryHasCaptchaSrvRequest createESBGYDGYDInquiryHasCaptchaSrvRequest() {
        return new ESBGYDGYDInquiryHasCaptchaSrvRequest();
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryHasCaptchaSrvResponse }
     * 
     */
    public ESBGYDGYDInquiryHasCaptchaSrvResponse createESBGYDGYDInquiryHasCaptchaSrvResponse() {
        return new ESBGYDGYDInquiryHasCaptchaSrvResponse();
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryHasCaptchaSrvOutputItem }
     * 
     */
    public ESBGYDGYDInquiryHasCaptchaSrvOutputItem createESBGYDGYDInquiryHasCaptchaSrvOutputItem() {
        return new ESBGYDGYDInquiryHasCaptchaSrvOutputItem();
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryHasCaptchaSrvOutputCollection }
     * 
     */
    public ESBGYDGYDInquiryHasCaptchaSrvOutputCollection createESBGYDGYDInquiryHasCaptchaSrvOutputCollection() {
        return new ESBGYDGYDInquiryHasCaptchaSrvOutputCollection();
    }

    /**
     * Create an instance of {@link MsgHeader }
     * 
     */
    public MsgHeader createMsgHeader() {
        return new MsgHeader();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBGYDGYDInquiryHasCaptchaSrvRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0", name = "ESB_GYD_GYD_InquiryHasCaptchaSrvRequest")
    public JAXBElement<ESBGYDGYDInquiryHasCaptchaSrvRequest> createESBGYDGYDInquiryHasCaptchaSrvRequest(ESBGYDGYDInquiryHasCaptchaSrvRequest value) {
        return new JAXBElement<ESBGYDGYDInquiryHasCaptchaSrvRequest>(_ESBGYDGYDInquiryHasCaptchaSrvRequest_QNAME, ESBGYDGYDInquiryHasCaptchaSrvRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBGYDGYDInquiryHasCaptchaSrvResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryHasCaptchaSrv/1.0", name = "ESB_GYD_GYD_InquiryHasCaptchaSrvResponse")
    public JAXBElement<ESBGYDGYDInquiryHasCaptchaSrvResponse> createESBGYDGYDInquiryHasCaptchaSrvResponse(ESBGYDGYDInquiryHasCaptchaSrvResponse value) {
        return new JAXBElement<ESBGYDGYDInquiryHasCaptchaSrvResponse>(_ESBGYDGYDInquiryHasCaptchaSrvResponse_QNAME, ESBGYDGYDInquiryHasCaptchaSrvResponse.class, null, value);
    }

}
