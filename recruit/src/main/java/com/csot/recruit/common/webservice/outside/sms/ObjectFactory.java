
package com.csot.recruit.common.webservice.outside.sms;

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

    private final static QName _ESBESBSMSImportSmsSrvResponse_QNAME = new QName("http://www.csot.tcl.com/ESB_ESB_SMS_ImportSmsSrv/1.0", "ESB_ESB_SMS_ImportSmsSrvResponse");
    private final static QName _ESBESBSMSImportSmsSrvRequest_QNAME = new QName("http://www.csot.tcl.com/ESB_ESB_SMS_ImportSmsSrv/1.0", "ESB_ESB_SMS_ImportSmsSrvRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: recruit
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ESBESBSMSImportSmsSrvResponse }
     * 
     */
    public ESBESBSMSImportSmsSrvResponse createESBESBSMSImportSmsSrvResponse() {
        return new ESBESBSMSImportSmsSrvResponse();
    }

    /**
     * Create an instance of {@link ESBESBSMSImportSmsSrvRequest }
     * 
     */
    public ESBESBSMSImportSmsSrvRequest createESBESBSMSImportSmsSrvRequest() {
        return new ESBESBSMSImportSmsSrvRequest();
    }

    /**
     * Create an instance of {@link ErrorItem }
     * 
     */
    public ErrorItem createErrorItem() {
        return new ErrorItem();
    }

    /**
     * Create an instance of {@link ResponseCollection }
     * 
     */
    public ResponseCollection createResponseCollection() {
        return new ResponseCollection();
    }

    /**
     * Create an instance of {@link ESBESBSMSImportSmsSrvInputItem }
     * 
     */
    public ESBESBSMSImportSmsSrvInputItem createESBESBSMSImportSmsSrvInputItem() {
        return new ESBESBSMSImportSmsSrvInputItem();
    }

    /**
     * Create an instance of {@link MobileItem }
     * 
     */
    public MobileItem createMobileItem() {
        return new MobileItem();
    }

    /**
     * Create an instance of {@link MobileCollection }
     * 
     */
    public MobileCollection createMobileCollection() {
        return new MobileCollection();
    }

    /**
     * Create an instance of {@link ErrorCollection }
     * 
     */
    public ErrorCollection createErrorCollection() {
        return new ErrorCollection();
    }

    /**
     * Create an instance of {@link ResponseItem }
     * 
     */
    public ResponseItem createResponseItem() {
        return new ResponseItem();
    }

    /**
     * Create an instance of {@link ESBESBSMSImportSmsSrvInputCollection }
     * 
     */
    public ESBESBSMSImportSmsSrvInputCollection createESBESBSMSImportSmsSrvInputCollection() {
        return new ESBESBSMSImportSmsSrvInputCollection();
    }

    /**
     * Create an instance of {@link MsgHeader }
     * 
     */
    public MsgHeader createMsgHeader() {
        return new MsgHeader();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBESBSMSImportSmsSrvResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_ESB_SMS_ImportSmsSrv/1.0", name = "ESB_ESB_SMS_ImportSmsSrvResponse")
    public JAXBElement<ESBESBSMSImportSmsSrvResponse> createESBESBSMSImportSmsSrvResponse(ESBESBSMSImportSmsSrvResponse value) {
        return new JAXBElement<ESBESBSMSImportSmsSrvResponse>(_ESBESBSMSImportSmsSrvResponse_QNAME, ESBESBSMSImportSmsSrvResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBESBSMSImportSmsSrvRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_ESB_SMS_ImportSmsSrv/1.0", name = "ESB_ESB_SMS_ImportSmsSrvRequest")
    public JAXBElement<ESBESBSMSImportSmsSrvRequest> createESBESBSMSImportSmsSrvRequest(ESBESBSMSImportSmsSrvRequest value) {
        return new JAXBElement<ESBESBSMSImportSmsSrvRequest>(_ESBESBSMSImportSmsSrvRequest_QNAME, ESBESBSMSImportSmsSrvRequest.class, null, value);
    }

}
