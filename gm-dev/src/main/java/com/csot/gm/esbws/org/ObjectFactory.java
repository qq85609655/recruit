
package com.csot.gm.esbws.org;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.csot.gm.esbws.org package. 
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

    private final static QName _ESBESBESBImportOrgInfoRouteSrvRequest_QNAME = new QName("http://www.csot.tcl.com/ESB_ESB_ESB_ImportOrgInfoRouteSrv/1.0", "ESB_ESB_ESB_ImportOrgInfoRouteSrvRequest");
    private final static QName _ESBESBESBImportOrgInfoRouteSrvResponse_QNAME = new QName("http://www.csot.tcl.com/ESB_ESB_ESB_ImportOrgInfoRouteSrv/1.0", "ESB_ESB_ESB_ImportOrgInfoRouteSrvResponse");

    /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes
   * for package: com.csot.gm.esbws.org
   * 
   */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ESBESBESBImportOrgInfoRouteSrvResponse }
     * 
     */
    public ESBESBESBImportOrgInfoRouteSrvResponse createESBESBESBImportOrgInfoRouteSrvResponse() {
        return new ESBESBESBImportOrgInfoRouteSrvResponse();
    }

    /**
     * Create an instance of {@link ESBESBESBImportOrgInfoRouteSrvRequest }
     * 
     */
    public ESBESBESBImportOrgInfoRouteSrvRequest createESBESBESBImportOrgInfoRouteSrvRequest() {
        return new ESBESBESBImportOrgInfoRouteSrvRequest();
    }

    /**
     * Create an instance of {@link ErrorItem }
     * 
     */
    public ErrorItem createErrorItem() {
        return new ErrorItem();
    }

    /**
     * Create an instance of {@link ESBESBESBImportOrgInfoRouteSrvInputItem }
     * 
     */
    public ESBESBESBImportOrgInfoRouteSrvInputItem createESBESBESBImportOrgInfoRouteSrvInputItem() {
        return new ESBESBESBImportOrgInfoRouteSrvInputItem();
    }

    /**
     * Create an instance of {@link ResponseCollection }
     * 
     */
    public ResponseCollection createResponseCollection() {
        return new ResponseCollection();
    }

    /**
     * Create an instance of {@link ESBESBESBImportOrgInfoRouteSrvInputCollection }
     * 
     */
  public ESBESBESBImportOrgInfoRouteSrvInputCollection
      createESBESBESBImportOrgInfoRouteSrvInputCollection() {
        return new ESBESBESBImportOrgInfoRouteSrvInputCollection();
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
   * Create an instance of {@link JAXBElement }{@code <}{@link ESBESBESBImportOrgInfoRouteSrvRequest }
   * {@code >}
   * 
   */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_ESB_ESB_ImportOrgInfoRouteSrv/1.0", name = "ESB_ESB_ESB_ImportOrgInfoRouteSrvRequest")
  public JAXBElement<ESBESBESBImportOrgInfoRouteSrvRequest>
      createESBESBESBImportOrgInfoRouteSrvRequest(ESBESBESBImportOrgInfoRouteSrvRequest value) {
    return new JAXBElement<ESBESBESBImportOrgInfoRouteSrvRequest>(
        _ESBESBESBImportOrgInfoRouteSrvRequest_QNAME, ESBESBESBImportOrgInfoRouteSrvRequest.class,
        null, value);
    }

    /**
   * Create an instance of {@link JAXBElement }{@code <}
   * {@link ESBESBESBImportOrgInfoRouteSrvResponse }{@code >}
   * 
   */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_ESB_ESB_ImportOrgInfoRouteSrv/1.0", name = "ESB_ESB_ESB_ImportOrgInfoRouteSrvResponse")
  public JAXBElement<ESBESBESBImportOrgInfoRouteSrvResponse>
      createESBESBESBImportOrgInfoRouteSrvResponse(ESBESBESBImportOrgInfoRouteSrvResponse value) {
    return new JAXBElement<ESBESBESBImportOrgInfoRouteSrvResponse>(
        _ESBESBESBImportOrgInfoRouteSrvResponse_QNAME,
        ESBESBESBImportOrgInfoRouteSrvResponse.class, null, value);
    }

}
