
package com.csot.recruit.common.webservice.outside.hasCaptcha;

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

import net.sf.json.JSONArray;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2015-10-14T17:19:19.026+08:00
 * Generated source version: 2.7.12
 * 
 */
public final class ESBGYDGYDInquiryHasCaptchaSrv_ESBGYDGYDInquiryHasCaptchaSrv_Client {

    private static final QName SERVICE_NAME = new QName("http://webservice.plm.csot.kmss.landray.com/", "ESB_GYD_GYD_InquiryHasCaptchaSrv.serviceagent");

    private ESBGYDGYDInquiryHasCaptchaSrv_ESBGYDGYDInquiryHasCaptchaSrv_Client() {
    }

    /*public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ESBGYDGYDInquiryHasCaptchaSrvServiceagent.WSDL_LOCATION;
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
      
        ESBGYDGYDInquiryHasCaptchaSrvServiceagent ss = new ESBGYDGYDInquiryHasCaptchaSrvServiceagent();
        ESBGYDGYDInquiryHasCaptchaSrv port = ss.getESBGYDGYDInquiryHasCaptchaSrv();  
        
        {
        System.out.println("Invoking process...");
        ESBGYDGYDInquiryHasCaptchaSrvRequest _process_payload = new ESBGYDGYDInquiryHasCaptchaSrvRequest();
        _process_payload.setMsgHeader(new MsgHeader());
        _process_payload.setPARAMATERS("hasCaptcha=true&appkey=70b88fb007fe");
        _process_payload.setPOSTDATA("");
        _process_payload.setRESULTTYPE("application/json");
        ESBGYDGYDInquiryHasCaptchaSrvResponse _process__return = port.process(_process_payload);
        JSONArray jsonArray = JSONArray.fromObject(_process__return.getESBGYDGYDInquiryHasCaptchaSrvOutputCollection().getESBGYDGYDInquiryHasCaptchaSrvOutputItem().get(0).getASCIICONTENT());   
        System.out.println(jsonArray);

        }

        System.exit(0);
    }*/

}