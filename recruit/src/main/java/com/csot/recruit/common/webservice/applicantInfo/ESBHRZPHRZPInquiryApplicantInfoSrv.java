package com.csot.recruit.common.webservice.applicantInfo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.12
 * 2017-03-14T09:11:19.075+08:00
 * Generated source version: 2.7.12
 * 
 */
@WebService(targetNamespace = "http://webservice.plm.csot.kmss.landray.com/", name = "ESB_HRZP_HRZP_InquiryApplicantInfoSrv")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ESBHRZPHRZPInquiryApplicantInfoSrv {

    @WebResult(name = "ESB_HRZP_HRZP_InquiryApplicantInfoSrvResponse", targetNamespace = "http://www.csot.tcl.com/ESB_HRZP_HRZP_InquiryApplicantInfoSrv/1.0", partName = "payload")
    @WebMethod(action = "/ESB_HRZP_HRZP_InquiryApplicantInfoSrv/v1/process")
    public ESBHRZPHRZPInquiryApplicantInfoSrvResponse process(
        @WebParam(partName = "payload", name = "ESB_HRZP_HRZP_InquiryApplicantInfoSrvRequest", targetNamespace = "http://www.csot.tcl.com/ESB_HRZP_HRZP_InquiryApplicantInfoSrv/1.0")
        ESBHRZPHRZPInquiryApplicantInfoSrvRequest payload
    );
}