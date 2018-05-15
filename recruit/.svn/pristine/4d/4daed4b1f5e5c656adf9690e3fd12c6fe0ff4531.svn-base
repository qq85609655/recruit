package com.csot.recruit.soa.status;

import com.google.common.base.Throwables;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.amberframework.core.spring.service.impl.SpringPropertyResourceReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * OA回传统一接口
 */
@javax.jws.WebService(
    serviceName = "ESB_ESB_ESB_ImportProcessStatusSrv.serviceagent",
    portName = "ESB_ESB_ESB_ImportProcessStatusSrv",
    targetNamespace = "http://www.csot.tcl.com/ESB_ESB_ESB_ImportProcessStatusSrv/1.0",
    wsdlLocation = "file:/E:/ESB/ESB_SRM_PO_ImportOpenPoReceivingRecordSrv/ESB_SRM_PO_ImportOpenPoReceivingRecordSrv.wsdl",
    endpointInterface = "com.csot.srm.soa.oa.server.process.status.ESBESBESBImportProcessStatusSrv")
public class ESBESBESBImportProcessStatusSrvImpl implements ESBESBESBImportProcessStatusSrv{

//  @Resource
//  private OaBackWriteService oaBackWriteService;

//  @Resource
  private SpringPropertyResourceReader springPropertyResourceReader;

//  private VecnImportWriteBackService vecnImportWriteBackService;
  
  /**车辆人员入场流程*/
  private static String SRM_APPLY_TYPE_VISITOR = "entranceVisitor";
  
  /**物流车辆入场流程*/
  private static String SRM_APPLY_TYPE_VEHICLE = "entranceVehicle";
  
  /**Open Po关闭申请流程*/
  private static String SRM_APPLY_TYPE_OPENPO_CLOSE = "openPoClose";
  
  private static final Logger logger = LoggerFactory.getLogger(ESBESBESBImportProcessStatusSrvImpl.class);
  
  @Override
  public ESBESBESBImportProcessStatusSrvResponse process(
      ESBESBESBImportProcessStatusSrvRequest payload) {
    ESBESBESBImportProcessStatusSrvResponse returnResponse = new ESBESBESBImportProcessStatusSrvResponse(); 
    ResponseCollection responseCollection = new ResponseCollection();
    ErrorCollection errorCollection = new ErrorCollection();
    ESBESBESBImportProcessStatusSrvInputCollection inputCollection =
        payload.getESBESBESBImportProcessStatusSrvInputCollection();
    List<ESBESBESBImportProcessStatusSrvInputItem> inputItems = 
        inputCollection.getESBESBESBImportProcessStatusSrvInputItem();
    List<ResponseItem> responseItemList = responseCollection.getResponseItem();
    List<ErrorItem> errorItemList = errorCollection.getErrorItem();

    try{
      if(inputItems.size()!=0){
        String csotTempId = springPropertyResourceReader.getProperty("srm.soa.oa.process.vecn.csot.template.id");
        String supTempId = springPropertyResourceReader.getProperty("srm.soa.oa.process.vecn.supplier.template.id");
        ESBESBESBImportProcessStatusSrvInputItem inputItem = inputItems.get(0);
        String formValues = inputItem.getFORMVALUES();
        logger.info("formValues:"+formValues);
        JsonObject formValuesJson = new JsonParser().parse(formValues).getAsJsonObject();
        JsonElement jsonElement = formValuesJson.get("srmTempelId");
        String flag = jsonElement.getAsString();
        if(SRM_APPLY_TYPE_VISITOR.equals(flag) || SRM_APPLY_TYPE_VEHICLE.equals(flag)
                || SRM_APPLY_TYPE_OPENPO_CLOSE.equals(flag)){//车辆模块

//          oaBackWriteService.process(inputItems,returnResponse);
        }else if(csotTempId.equalsIgnoreCase(flag) || supTempId.equalsIgnoreCase(flag)){//vecn模块

//          VecnImportWriteBackDto vecnImportWriteBackDto = new VecnImportWriteBackDto(inputItem);
//          vecnImportWriteBackService.writeBackOaSignData(vecnImportWriteBackDto, responseItemList, errorItemList);
        }

      }
      
      returnResponse.setResponseCollection(responseCollection);
      returnResponse.setErrorCollection(errorCollection);
      returnResponse.setSERVICEFLAG(errorItemList.isEmpty() ? "TRUE" : "FALSE");
      return returnResponse;
    }catch(Exception ex){
      throw Throwables.propagate(ex);
    }
  }

}
