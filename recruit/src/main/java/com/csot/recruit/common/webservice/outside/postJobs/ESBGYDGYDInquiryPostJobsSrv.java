package com.csot.recruit.common.webservice.outside.postJobs;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2015-10-15T09:40:11.932+08:00
 * Generated source version: 2.7.12
 * 
 */
@WebService(targetNamespace = "http://webservice.plm.csot.kmss.landray.com/", name = "ESB_GYD_GYD_InquiryPostJobsSrv")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ESBGYDGYDInquiryPostJobsSrv {

    @WebResult(name = "ESB_GYD_GYD_InquiryPostJobsSrvResponse", targetNamespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryPostJobsSrv/1.0", partName = "payload")
    @WebMethod(action = "/ESB_GYD_GYD_InquiryPostJobsSrv/v1/process")
    public ESBGYDGYDInquiryPostJobsSrvResponse process(
        @WebParam(partName = "payload", name = "ESB_GYD_GYD_InquiryPostJobsSrvRequest", targetNamespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryPostJobsSrv/1.0")
        ESBGYDGYDInquiryPostJobsSrvRequest payload
    );
}