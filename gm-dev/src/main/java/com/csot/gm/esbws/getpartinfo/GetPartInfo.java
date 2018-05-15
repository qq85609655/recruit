package com.csot.gm.esbws.getpartinfo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.csot.gm.esbws.getpartinfo.utils.PartInfoForm;
import com.csot.gm.esbws.getpartinfo.utils.WXPartInfoForm;

/**
 * @author Administrator
 *
 */
@WebService(targetNamespace = "http://gm.csot.tcl.com/gm/service")
public interface GetPartInfo {

  @WebMethod(operationName = "GetWXInformation")
  @WebResult(name = "wXPartInfoForm")
  public WXPartInfoForm getWXInformation(@WebParam(name = "uuid") String uuid);

  @WebMethod(operationName = "GetCreatPartInfo")
  @WebResult(name = "partInfoForm")
  public PartInfoForm getCreatPartInfo(@WebParam(name = "uuid") String uuid);
}
