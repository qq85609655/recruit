package com.csot.recruit.common.webservice.outside.getCaptcha;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2015-10-14T20:29:05.663+08:00
 * Generated source version: 2.7.12
 * 
 */
@WebServiceClient(name = "ESB_GYD_GYD_InquiryCaptchaSrv.serviceagent", 
                  wsdlLocation = "http://t2eaesbapp01.csot.tcl.com:9016/CoreServices/BusinessServices/Services/ESB_GYD_GYD_InquiryCaptchaSrv/v1.0.0/ESB_GYD_GYD_InquiryCaptchaSrv.serviceagent?wsdl",
                  targetNamespace = "http://webservice.plm.csot.kmss.landray.com/") 
public class ESBGYDGYDInquiryCaptchaSrvServiceagent extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://webservice.plm.csot.kmss.landray.com/", "ESB_GYD_GYD_InquiryCaptchaSrv.serviceagent");
    public final static QName ESBGYDGYDInquiryCaptchaSrv = new QName("http://webservice.plm.csot.kmss.landray.com/", "ESB_GYD_GYD_InquiryCaptchaSrv");
    static {
        URL url = null;
        try {
            url = new URL("http://t2eaesbapp01.csot.tcl.com:9016/CoreServices/BusinessServices/Services/ESB_GYD_GYD_InquiryCaptchaSrv/v1.0.0/ESB_GYD_GYD_InquiryCaptchaSrv.serviceagent?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ESBGYDGYDInquiryCaptchaSrvServiceagent.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://t2eaesbapp01.csot.tcl.com:9016/CoreServices/BusinessServices/Services/ESB_GYD_GYD_InquiryCaptchaSrv/v1.0.0/ESB_GYD_GYD_InquiryCaptchaSrv.serviceagent?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ESBGYDGYDInquiryCaptchaSrvServiceagent(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ESBGYDGYDInquiryCaptchaSrvServiceagent(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ESBGYDGYDInquiryCaptchaSrvServiceagent() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ESBGYDGYDInquiryCaptchaSrvServiceagent(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ESBGYDGYDInquiryCaptchaSrvServiceagent(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public ESBGYDGYDInquiryCaptchaSrvServiceagent(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns ESBGYDGYDInquiryCaptchaSrv
     */
    @WebEndpoint(name = "ESB_GYD_GYD_InquiryCaptchaSrv")
    public ESBGYDGYDInquiryCaptchaSrv getESBGYDGYDInquiryCaptchaSrv() {
        return super.getPort(ESBGYDGYDInquiryCaptchaSrv, ESBGYDGYDInquiryCaptchaSrv.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ESBGYDGYDInquiryCaptchaSrv
     */
    @WebEndpoint(name = "ESB_GYD_GYD_InquiryCaptchaSrv")
    public ESBGYDGYDInquiryCaptchaSrv getESBGYDGYDInquiryCaptchaSrv(WebServiceFeature... features) {
        return super.getPort(ESBGYDGYDInquiryCaptchaSrv, ESBGYDGYDInquiryCaptchaSrv.class, features);
    }

}
