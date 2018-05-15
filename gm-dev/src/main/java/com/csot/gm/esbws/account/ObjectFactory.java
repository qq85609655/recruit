
package com.csot.gm.esbws.account;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.csot.plm.soa.imp.hr.account package. 
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

    private final static QName _ESBESBESBImportUserAccountInfoRouteSrvRequest_QNAME = new QName("http://www.csot.tcl.com/ESB_ESB_ESB_ImportUserAccountInfoRouteSrv/1.0", "ESB_ESB_ESB_ImportUserAccountInfoRouteSrvRequest");
    private final static QName _ESBESBESBImportUserAccountInfoRouteSrvResponse_QNAME = new QName("http://www.csot.tcl.com/ESB_ESB_ESB_ImportUserAccountInfoRouteSrv/1.0", "ESB_ESB_ESB_ImportUserAccountInfoRouteSrvResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.csot.plm.soa.imp.hr.account
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ESBESBESBImportUserAccountInfoRouteSrvResponse }
     * 
     */
    public ESBESBESBImportUserAccountInfoRouteSrvResponse createESBESBESBImportUserAccountInfoRouteSrvResponse() {
        return new ESBESBESBImportUserAccountInfoRouteSrvResponse();
    }

    /**
     * Create an instance of {@link ESBESBESBImportUserAccountInfoRouteSrvRequest }
     * 
     */
    public ESBESBESBImportUserAccountInfoRouteSrvRequest createESBESBESBImportUserAccountInfoRouteSrvRequest() {
        return new ESBESBESBImportUserAccountInfoRouteSrvRequest();
    }

    /**
     * Create an instance of {@link ESBESBESBImportUserAccountInfoRouteSrvInputItem }
     * 
     */
    public ESBESBESBImportUserAccountInfoRouteSrvInputItem createESBESBESBImportUserAccountInfoRouteSrvInputItem() {
        return new ESBESBESBImportUserAccountInfoRouteSrvInputItem();
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
     * Create an instance of {@link ESBESBESBImportUserAccountInfoRouteSrvInputCollection }
     * 
     */
    public ESBESBESBImportUserAccountInfoRouteSrvInputCollection createESBESBESBImportUserAccountInfoRouteSrvInputCollection() {
        return new ESBESBESBImportUserAccountInfoRouteSrvInputCollection();
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
     * Create an instance of {@link MsgHeader }
     * 
     */
    public MsgHeader createMsgHeader() {
        return new MsgHeader();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBESBESBImportUserAccountInfoRouteSrvRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_ESB_ESB_ImportUserAccountInfoRouteSrv/1.0", name = "ESB_ESB_ESB_ImportUserAccountInfoRouteSrvRequest")
    public JAXBElement<ESBESBESBImportUserAccountInfoRouteSrvRequest> createESBESBESBImportUserAccountInfoRouteSrvRequest(ESBESBESBImportUserAccountInfoRouteSrvRequest value) {
        return new JAXBElement<ESBESBESBImportUserAccountInfoRouteSrvRequest>(_ESBESBESBImportUserAccountInfoRouteSrvRequest_QNAME, ESBESBESBImportUserAccountInfoRouteSrvRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBESBESBImportUserAccountInfoRouteSrvResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_ESB_ESB_ImportUserAccountInfoRouteSrv/1.0", name = "ESB_ESB_ESB_ImportUserAccountInfoRouteSrvResponse")
    public JAXBElement<ESBESBESBImportUserAccountInfoRouteSrvResponse> createESBESBESBImportUserAccountInfoRouteSrvResponse(ESBESBESBImportUserAccountInfoRouteSrvResponse value) {
        return new JAXBElement<ESBESBESBImportUserAccountInfoRouteSrvResponse>(_ESBESBESBImportUserAccountInfoRouteSrvResponse_QNAME, ESBESBESBImportUserAccountInfoRouteSrvResponse.class, null, value);
    }

}
