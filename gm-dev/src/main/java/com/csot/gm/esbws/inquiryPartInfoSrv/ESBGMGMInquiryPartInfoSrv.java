package com.csot.gm.esbws.inquiryPartInfoSrv;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.5.2
 * 2016-01-08T11:46:23.858+08:00
 * Generated source version: 2.5.2
 * 
 */
@WebService(targetNamespace = "http://www.csot.tcl.com/ESB_GM_GM_InquiryPartInfoSrv/1.0", name = "ESB_GM_GM_InquiryPartInfoSrv")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ESBGMGMInquiryPartInfoSrv {

    @WebResult(name = "ESB_GM_GM_InquiryPartInfoSrvResponse", targetNamespace = "http://www.csot.tcl.com/ESB_GM_GM_InquiryPartInfoSrv/1.0", partName = "payload")
    @WebMethod(action = "/ESB_GM_GM_InquiryPartInfoSrv/v1/process")
    public ESBGMGMInquiryPartInfoSrvResponse process(
        @WebParam(partName = "payload", name = "ESB_GM_GM_InquiryPartInfoSrvRequest", targetNamespace = "http://www.csot.tcl.com/ESB_GM_GM_InquiryPartInfoSrv/1.0")
        ESBGMGMInquiryPartInfoSrvRequest payload
    );
}
