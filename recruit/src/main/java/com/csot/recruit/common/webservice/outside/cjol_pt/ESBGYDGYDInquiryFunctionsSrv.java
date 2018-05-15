package com.csot.recruit.common.webservice.outside.cjol_pt;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2015-10-22T16:06:51.925+08:00
 * Generated source version: 2.7.12
 * 
 */
@WebService(targetNamespace = "http://webservice.plm.csot.kmss.landray.com/", name = "ESB_GYD_GYD_InquiryFunctionsSrv")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ESBGYDGYDInquiryFunctionsSrv {

    @WebResult(name = "ESB_GYD_GYD_InquiryFunctionsSrvResponse", targetNamespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryFunctionsSrv/1.0", partName = "payload")
    @WebMethod(action = "/ESB_GYD_GYD_InquiryFunctionsSrv/v1/process")
    public ESBGYDGYDInquiryFunctionsSrvResponse process(
        @WebParam(partName = "payload", name = "ESB_GYD_GYD_InquiryFunctionsSrvRequest", targetNamespace = "http://www.csot.tcl.com/ESB_GYD_GYD_InquiryFunctionsSrv/1.0")
        ESBGYDGYDInquiryFunctionsSrvRequest payload
    );
}