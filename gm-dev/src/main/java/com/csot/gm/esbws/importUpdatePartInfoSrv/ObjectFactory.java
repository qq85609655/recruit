
package com.csot.gm.esbws.importUpdatePartInfoSrv;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.csot.gm.esbws.importUpdatePartInfoSrv package. 
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

    private final static QName _ESBGMGMImportUpdatePartInfoSrvRequest_QNAME = new QName("http://www.csot.tcl.com/ESB_GM_GM_ImportUpdatePartInfoSrv/1.0", "ESB_GM_GM_ImportUpdatePartInfoSrvRequest");
    private final static QName _ESBGMGMImportUpdatePartInfoSrvResponse_QNAME = new QName("http://www.csot.tcl.com/ESB_GM_GM_ImportUpdatePartInfoSrv/1.0", "ESB_GM_GM_ImportUpdatePartInfoSrvResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.csot.gm.esbws.importUpdatePartInfoSrv
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ESBGMGMImportUpdatePartInfoSrvRequest }
     * 
     */
    public ESBGMGMImportUpdatePartInfoSrvRequest createESBGMGMImportUpdatePartInfoSrvRequest() {
        return new ESBGMGMImportUpdatePartInfoSrvRequest();
    }

    /**
     * Create an instance of {@link ESBGMGMImportUpdatePartInfoSrvResponse }
     * 
     */
    public ESBGMGMImportUpdatePartInfoSrvResponse createESBGMGMImportUpdatePartInfoSrvResponse() {
        return new ESBGMGMImportUpdatePartInfoSrvResponse();
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
     * Create an instance of {@link ESBGMGMImportUpdatePartInfoSrvInputItem }
     * 
     */
    public ESBGMGMImportUpdatePartInfoSrvInputItem createESBGMGMImportUpdatePartInfoSrvInputItem() {
        return new ESBGMGMImportUpdatePartInfoSrvInputItem();
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
     * Create an instance of {@link ESBGMGMImportUpdatePartInfoSrvInputCollection }
     * 
     */
    public ESBGMGMImportUpdatePartInfoSrvInputCollection createESBGMGMImportUpdatePartInfoSrvInputCollection() {
        return new ESBGMGMImportUpdatePartInfoSrvInputCollection();
    }

    /**
     * Create an instance of {@link MsgHeader }
     * 
     */
    public MsgHeader createMsgHeader() {
        return new MsgHeader();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBGMGMImportUpdatePartInfoSrvRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_GM_GM_ImportUpdatePartInfoSrv/1.0", name = "ESB_GM_GM_ImportUpdatePartInfoSrvRequest")
    public JAXBElement<ESBGMGMImportUpdatePartInfoSrvRequest> createESBGMGMImportUpdatePartInfoSrvRequest(ESBGMGMImportUpdatePartInfoSrvRequest value) {
        return new JAXBElement<ESBGMGMImportUpdatePartInfoSrvRequest>(_ESBGMGMImportUpdatePartInfoSrvRequest_QNAME, ESBGMGMImportUpdatePartInfoSrvRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ESBGMGMImportUpdatePartInfoSrvResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.csot.tcl.com/ESB_GM_GM_ImportUpdatePartInfoSrv/1.0", name = "ESB_GM_GM_ImportUpdatePartInfoSrvResponse")
    public JAXBElement<ESBGMGMImportUpdatePartInfoSrvResponse> createESBGMGMImportUpdatePartInfoSrvResponse(ESBGMGMImportUpdatePartInfoSrvResponse value) {
        return new JAXBElement<ESBGMGMImportUpdatePartInfoSrvResponse>(_ESBGMGMImportUpdatePartInfoSrvResponse_QNAME, ESBGMGMImportUpdatePartInfoSrvResponse.class, null, value);
    }

}
