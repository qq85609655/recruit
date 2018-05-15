package com.csot.recruit.soa.status;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.14
 * 2017-06-30T13:31:11.151+08:00
 * Generated source version: 2.7.14
 * 
 */
@WebServiceClient(name = "ESB_ESB_ESB_ImportProcessStatusSrv.serviceagent", 
                  wsdlLocation = "file:/E:/ESB/ESB_ESB_ESB_ImportProcessStatusSrv/ESB_ESB_ESB_ImportProcessStatusSrv.wsdl",
                  targetNamespace = "http://www.csot.tcl.com/ESB_ESB_ESB_ImportProcessStatusSrv/1.0") 
public class ESBESBESBImportProcessStatusSrvServiceagent extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.csot.tcl.com/ESB_ESB_ESB_ImportProcessStatusSrv/1.0", "ESB_ESB_ESB_ImportProcessStatusSrv.serviceagent");
    public final static QName ESBESBESBImportProcessStatusSrv = new QName("http://www.csot.tcl.com/ESB_ESB_ESB_ImportProcessStatusSrv/1.0", "ESB_ESB_ESB_ImportProcessStatusSrv");
    static {
        URL url = null;
        try {
            url = new URL("file:/E:/ESB/ESB_ESB_ESB_ImportProcessStatusSrv/ESB_ESB_ESB_ImportProcessStatusSrv.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ESBESBESBImportProcessStatusSrvServiceagent.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/E:/ESB/ESB_ESB_ESB_ImportProcessStatusSrv/ESB_ESB_ESB_ImportProcessStatusSrv.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ESBESBESBImportProcessStatusSrvServiceagent(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ESBESBESBImportProcessStatusSrvServiceagent(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ESBESBESBImportProcessStatusSrvServiceagent() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ESBESBESBImportProcessStatusSrvServiceagent(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ESBESBESBImportProcessStatusSrvServiceagent(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ESBESBESBImportProcessStatusSrvServiceagent(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns ESBESBESBImportProcessStatusSrv
     */
    @WebEndpoint(name = "ESB_ESB_ESB_ImportProcessStatusSrv")
    public ESBESBESBImportProcessStatusSrv getESBESBESBImportProcessStatusSrv() {
        return super.getPort(ESBESBESBImportProcessStatusSrv, ESBESBESBImportProcessStatusSrv.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ESBESBESBImportProcessStatusSrv
     */
    @WebEndpoint(name = "ESB_ESB_ESB_ImportProcessStatusSrv")
    public ESBESBESBImportProcessStatusSrv getESBESBESBImportProcessStatusSrv(WebServiceFeature... features) {
        return super.getPort(ESBESBESBImportProcessStatusSrv, ESBESBESBImportProcessStatusSrv.class, features);
    }

}
