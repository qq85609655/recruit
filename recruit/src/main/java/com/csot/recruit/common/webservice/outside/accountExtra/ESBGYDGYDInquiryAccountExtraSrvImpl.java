
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.csot.recruit.common.webservice.outside.accountExtra;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2015-10-15T09:38:47.073+08:00
 * Generated source version: 2.7.12
 * 
 */

@javax.jws.WebService(
                      serviceName = "ESB_GYD_GYD_InquiryAccountExtraSrv.serviceagent",
                      portName = "ESB_GYD_GYD_InquiryAccountExtraSrv",
                      targetNamespace = "http://webservice.plm.csot.kmss.landray.com/",
                      wsdlLocation = "http://t2eaesbapp01.csot.tcl.com:9016/CoreServices/BusinessServices/Services/ESB_GYD_GYD_InquiryAccountExtraSrv/v1.0.0/ESB_GYD_GYD_InquiryAccountExtraSrv.serviceagent?wsdl",
                      endpointInterface = "com.recruit.ESBGYDGYDInquiryAccountExtraSrv")
                      
public class ESBGYDGYDInquiryAccountExtraSrvImpl implements ESBGYDGYDInquiryAccountExtraSrv {

    private static final Logger LOG = Logger.getLogger(ESBGYDGYDInquiryAccountExtraSrvImpl.class.getName());

    /* (non-Javadoc)
     * @see com.recruit.ESBGYDGYDInquiryAccountExtraSrv#process(com.recruit.ESBGYDGYDInquiryAccountExtraSrvRequest  payload )*
     */
    public ESBGYDGYDInquiryAccountExtraSrvResponse process(ESBGYDGYDInquiryAccountExtraSrvRequest payload) { 
        LOG.info("Executing operation process");
        System.out.println(payload);
        try {
            ESBGYDGYDInquiryAccountExtraSrvResponse _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}