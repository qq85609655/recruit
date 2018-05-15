
package com.csot.recruit.common.webservice.outside.getCaptcha;

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

    private final static QName _ESBGYDGYDInquiryCaptchaSrvRequest_QNAME = new QName("http://www.csot.tcl.com/ESB_GYD_GYD_InquiryCaptchaSrv/1.0", "ESB_GYD_GYD_InquiryCaptchaSrvRequest");
    private final static QName _ESBGYDGYDInquiryCaptchaSrvResponse_QNAME = new QName("http://www.csot.tcl.com/ESB_GYD_GYD_InquiryCaptchaSrv/1.0", "ESB_GYD_GYD_InquiryCaptchaSrvResponse");

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
     * Create an instance of {@link ESBGYDGYDInquiryCaptchaSrvResponse }
     * 
     */
    public ESBGYDGYDInquiryCaptchaSrvResponse createESBGYDGYDInquiryCaptchaSrvResponse() {
        return new ESBGYDGYDInquiryCaptchaSrvResponse();
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryCaptchaSrvRequest }
     * 
     */
    public ESBGYDGYDInquiryCaptchaSrvRequest createESBGYDGYDInquiryCaptchaSrvRequest() {
        return new ESBGYDGYDInquiryCaptchaSrvRequest();
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryCaptchaSrvOutputCollection }
     * 
     */
    public ESBGYDGYDInquiryCaptchaSrvOutputCollection createESBGYDGYDInquiryCaptchaSrvOutputCollection() {
        return new ESBGYDGYDInquiryCaptchaSrvOutputCollection();
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryCaptchaSrvOutputItem }
     * 
     */
    public ESBGYDGYDInquiryCaptchaSrvOutputItem createESBGYDGYDInquiryCaptchaSrvOutputItem() {
        return new ESBGYDGYDInquiryCaptchaSrvOutputItem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBGYDGYDInquiryCaptchaSrvRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryCaptchaSrv/1.0", name = "ESB_GYD_GYD_InquiryCaptchaSrvRequest")
    public JAXBElement<ESBGYDGYDInquiryCaptchaSrvRequest> createESBGYDGYDInquiryCaptchaSrvRequest(ESBGYDGYDInquiryCaptchaSrvRequest value) {
        return new JAXBElement<ESBGYDGYDInquiryCaptchaSrvRequest>(_ESBGYDGYDInquiryCaptchaSrvRequest_QNAME, ESBGYDGYDInquiryCaptchaSrvRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBGYDGYDInquiryCaptchaSrvResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryCaptchaSrv/1.0", name = "ESB_GYD_GYD_InquiryCaptchaSrvResponse")
    public JAXBElement<ESBGYDGYDInquiryCaptchaSrvResponse> createESBGYDGYDInquiryCaptchaSrvResponse(ESBGYDGYDInquiryCaptchaSrvResponse value) {
        return new JAXBElement<ESBGYDGYDInquiryCaptchaSrvResponse>(_ESBGYDGYDInquiryCaptchaSrvResponse_QNAME, ESBGYDGYDInquiryCaptchaSrvResponse.class, null, value);
    }

}
