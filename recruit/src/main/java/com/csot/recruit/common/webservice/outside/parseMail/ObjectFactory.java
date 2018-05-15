
package com.csot.recruit.common.webservice.outside.parseMail;

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

    private final static QName _ESBGYDGYDInquiryParseMailSrvResponse_QNAME = new QName("http://www.csot.tcl.com/ESB_GYD_GYD_InquiryParseMailSrv/1.0", "ESB_GYD_GYD_InquiryParseMailSrvResponse");
    private final static QName _ESBGYDGYDInquiryParseMailSrvRequest_QNAME = new QName("http://www.csot.tcl.com/ESB_GYD_GYD_InquiryParseMailSrv/1.0", "ESB_GYD_GYD_InquiryParseMailSrvRequest");

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
     * Create an instance of {@link ESBGYDGYDInquiryParseMailSrvResponse }
     * 
     */
    public ESBGYDGYDInquiryParseMailSrvResponse createESBGYDGYDInquiryParseMailSrvResponse() {
        return new ESBGYDGYDInquiryParseMailSrvResponse();
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryParseMailSrvRequest }
     * 
     */
    public ESBGYDGYDInquiryParseMailSrvRequest createESBGYDGYDInquiryParseMailSrvRequest() {
        return new ESBGYDGYDInquiryParseMailSrvRequest();
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryParseMailSrvOutputCollection }
     * 
     */
    public ESBGYDGYDInquiryParseMailSrvOutputCollection createESBGYDGYDInquiryParseMailSrvOutputCollection() {
        return new ESBGYDGYDInquiryParseMailSrvOutputCollection();
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryParseMailSrvOutputItem }
     * 
     */
    public ESBGYDGYDInquiryParseMailSrvOutputItem createESBGYDGYDInquiryParseMailSrvOutputItem() {
        return new ESBGYDGYDInquiryParseMailSrvOutputItem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBGYDGYDInquiryParseMailSrvResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryParseMailSrv/1.0", name = "ESB_GYD_GYD_InquiryParseMailSrvResponse")
    public JAXBElement<ESBGYDGYDInquiryParseMailSrvResponse> createESBGYDGYDInquiryParseMailSrvResponse(ESBGYDGYDInquiryParseMailSrvResponse value) {
        return new JAXBElement<ESBGYDGYDInquiryParseMailSrvResponse>(_ESBGYDGYDInquiryParseMailSrvResponse_QNAME, ESBGYDGYDInquiryParseMailSrvResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBGYDGYDInquiryParseMailSrvRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryParseMailSrv/1.0", name = "ESB_GYD_GYD_InquiryParseMailSrvRequest")
    public JAXBElement<ESBGYDGYDInquiryParseMailSrvRequest> createESBGYDGYDInquiryParseMailSrvRequest(ESBGYDGYDInquiryParseMailSrvRequest value) {
        return new JAXBElement<ESBGYDGYDInquiryParseMailSrvRequest>(_ESBGYDGYDInquiryParseMailSrvRequest_QNAME, ESBGYDGYDInquiryParseMailSrvRequest.class, null, value);
    }

}
