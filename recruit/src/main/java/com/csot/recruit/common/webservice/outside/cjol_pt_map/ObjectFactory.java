
package com.csot.recruit.common.webservice.outside.cjol_pt_map;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the recruit package. 
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

    private final static QName _ESBGYDGYDInquiryFunctionMappingSrvResponse_QNAME = new QName("http://www.csot.tcl.com/ESB_GYD_GYD_InquiryFunctionMappingSrv/1.0", "ESB_GYD_GYD_InquiryFunctionMappingSrvResponse");
    private final static QName _ESBGYDGYDInquiryFunctionMappingSrvRequest_QNAME = new QName("http://www.csot.tcl.com/ESB_GYD_GYD_InquiryFunctionMappingSrv/1.0", "ESB_GYD_GYD_InquiryFunctionMappingSrvRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: recruit
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryFunctionMappingSrvResponse }
     * 
     */
    public ESBGYDGYDInquiryFunctionMappingSrvResponse createESBGYDGYDInquiryFunctionMappingSrvResponse() {
        return new ESBGYDGYDInquiryFunctionMappingSrvResponse();
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryFunctionMappingSrvRequest }
     * 
     */
    public ESBGYDGYDInquiryFunctionMappingSrvRequest createESBGYDGYDInquiryFunctionMappingSrvRequest() {
        return new ESBGYDGYDInquiryFunctionMappingSrvRequest();
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryFunctionMappingSrvOutputCollection }
     * 
     */
    public ESBGYDGYDInquiryFunctionMappingSrvOutputCollection createESBGYDGYDInquiryFunctionMappingSrvOutputCollection() {
        return new ESBGYDGYDInquiryFunctionMappingSrvOutputCollection();
    }

    /**
     * Create an instance of {@link ESBGYDGYDInquiryFunctionMappingSrvOutputItem }
     * 
     */
    public ESBGYDGYDInquiryFunctionMappingSrvOutputItem createESBGYDGYDInquiryFunctionMappingSrvOutputItem() {
        return new ESBGYDGYDInquiryFunctionMappingSrvOutputItem();
    }

    /**
     * Create an instance of {@link MsgHeader }
     * 
     */
    public MsgHeader createMsgHeader() {
        return new MsgHeader();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBGYDGYDInquiryFunctionMappingSrvResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryFunctionMappingSrv/1.0", name = "ESB_GYD_GYD_InquiryFunctionMappingSrvResponse")
    public JAXBElement<ESBGYDGYDInquiryFunctionMappingSrvResponse> createESBGYDGYDInquiryFunctionMappingSrvResponse(ESBGYDGYDInquiryFunctionMappingSrvResponse value) {
        return new JAXBElement<ESBGYDGYDInquiryFunctionMappingSrvResponse>(_ESBGYDGYDInquiryFunctionMappingSrvResponse_QNAME, ESBGYDGYDInquiryFunctionMappingSrvResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBGYDGYDInquiryFunctionMappingSrvRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryFunctionMappingSrv/1.0", name = "ESB_GYD_GYD_InquiryFunctionMappingSrvRequest")
    public JAXBElement<ESBGYDGYDInquiryFunctionMappingSrvRequest> createESBGYDGYDInquiryFunctionMappingSrvRequest(ESBGYDGYDInquiryFunctionMappingSrvRequest value) {
        return new JAXBElement<ESBGYDGYDInquiryFunctionMappingSrvRequest>(_ESBGYDGYDInquiryFunctionMappingSrvRequest_QNAME, ESBGYDGYDInquiryFunctionMappingSrvRequest.class, null, value);
    }

}
