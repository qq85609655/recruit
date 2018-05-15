package com.csot.recruit.common.webservice.outside.sms;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2015-10-22T15:52:06.663+08:00
 * Generated source version: 2.7.12
 * 
 */
@WebServiceClient(name = "ESB_SMS_SMS_ImportSmsSrv.serviceagent", 
                  wsdlLocation = "http://t2eaesbapp01.csot.tcl.com:9014/CoreServices/BusinessServices/Service/ESB_SMS_SMS_ImportSmsSrv/v1.0.0/ESB_SMS_SMS_ImportSmsSrv.serviceagent?wsdl",
                  targetNamespace = "http://xmlns.example.com/1435191957135") 
public class ESBSMSSMSImportSmsSrvServiceagent extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://xmlns.example.com/1435191957135", "ESB_SMS_SMS_ImportSmsSrv.serviceagent");
    public final static QName ESBSMSSMSImportSmsSrv = new QName("http://xmlns.example.com/1435191957135", "ESB_SMS_SMS_ImportSmsSrv");
    static {
        URL url = null;
        try {
            url = new URL("http://t2eaesbapp01.csot.tcl.com:9014/CoreServices/BusinessServices/Service/ESB_SMS_SMS_ImportSmsSrv/v1.0.0/ESB_SMS_SMS_ImportSmsSrv.serviceagent?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ESBSMSSMSImportSmsSrvServiceagent.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://t2eaesbapp01.csot.tcl.com:9014/CoreServices/BusinessServices/Service/ESB_SMS_SMS_ImportSmsSrv/v1.0.0/ESB_SMS_SMS_ImportSmsSrv.serviceagent?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ESBSMSSMSImportSmsSrvServiceagent(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ESBSMSSMSImportSmsSrvServiceagent(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ESBSMSSMSImportSmsSrvServiceagent() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ESBSMSSMSImportSmsSrvServiceagent(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ESBSMSSMSImportSmsSrvServiceagent(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ESBSMSSMSImportSmsSrvServiceagent(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns ESBESBSMSImportSmsSrv
     */
    @WebEndpoint(name = "ESB_SMS_SMS_ImportSmsSrv")
    public ESBESBSMSImportSmsSrv getESBSMSSMSImportSmsSrv() {
        return super.getPort(ESBSMSSMSImportSmsSrv, ESBESBSMSImportSmsSrv.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ESBESBSMSImportSmsSrv
     */
    @WebEndpoint(name = "ESB_SMS_SMS_ImportSmsSrv")
    public ESBESBSMSImportSmsSrv getESBSMSSMSImportSmsSrv(WebServiceFeature... features) {
        return super.getPort(ESBSMSSMSImportSmsSrv, ESBESBSMSImportSmsSrv.class, features);
    }

}