package com.csot.gm.esbws.emp;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.5.2
 * 2016-10-14T17:01:17.890+08:00
 * Generated source version: 2.5.2
 * 
 */
@WebService(targetNamespace = "http://www.csot.tcl.com/ESB_ESB_ESB_ImportEmpBasicInfoRouteSrv/1.0", name = "ESB_ESB_ESB_ImportEmpBasicInfoRouteSrv")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface ESBESBESBImportEmpBasicInfoRouteSrv {

    @WebResult(name = "ESB_ESB_ESB_ImportEmpBasicInfoRouteSrvResponse", targetNamespace = "http://www.csot.tcl.com/ESB_ESB_ESB_ImportEmpBasicInfoRouteSrv/1.0", partName = "payload")
    @WebMethod(action = "/ESB_ESB_ESB_ImportEmpBasicInfoRouteSrv/v1/process")
    public ESBESBESBImportEmpBasicInfoRouteSrvResponse process(
        @WebParam(partName = "payload", name = "ESB_ESB_ESB_ImportEmpBasicInfoRouteSrvRequest", targetNamespace = "http://www.csot.tcl.com/ESB_ESB_ESB_ImportEmpBasicInfoRouteSrv/1.0")
        ESBESBESBImportEmpBasicInfoRouteSrvRequest payload
    );
}