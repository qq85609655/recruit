
package com.csot.recruit.common.webservice.outside.accountExtra;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2015-10-15T09:38:46.996+08:00
 * Generated source version: 2.7.12
 * 
 */
public final class ESBGYDGYDInquiryAccountExtraSrv_ESBGYDGYDInquiryAccountExtraSrv_Client {

    private static final QName SERVICE_NAME = new QName("http://webservice.plm.csot.kmss.landray.com/", "ESB_GYD_GYD_InquiryAccountExtraSrv.serviceagent");

    private ESBGYDGYDInquiryAccountExtraSrv_ESBGYDGYDInquiryAccountExtraSrv_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ESBGYDGYDInquiryAccountExtraSrvServiceagent.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        ESBGYDGYDInquiryAccountExtraSrvServiceagent ss = new ESBGYDGYDInquiryAccountExtraSrvServiceagent(wsdlURL, SERVICE_NAME);
        ESBGYDGYDInquiryAccountExtraSrv port = ss.getESBGYDGYDInquiryAccountExtraSrv();  
        
        {
        System.out.println("Invoking process...");
        ESBGYDGYDInquiryAccountExtraSrvRequest _process_payload = null;
        ESBGYDGYDInquiryAccountExtraSrvResponse _process__return = port.process(_process_payload);
        System.out.println("process.result=" + _process__return);


        }

        System.exit(0);
    }

}