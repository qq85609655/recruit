package com.csot.recruit.soa;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.ws.BindingProvider;

import org.amberframework.core.spring.service.impl.SpringPropertyResourceReader;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import com.csot.recruit.soa.handler.AuthClientPasswordHandler;
import com.csot.recruit.soa.start.ESBOAOAImportStandardProcessSrv;
import com.csot.recruit.soa.start.ESBOAOAImportStandardProcessSrvInputCollection;
import com.csot.recruit.soa.start.ESBOAOAImportStandardProcessSrvInputItem;
import com.csot.recruit.soa.start.ESBOAOAImportStandardProcessSrvRequest;
import com.csot.recruit.soa.start.ESBOAOAImportStandardProcessSrvResponse;
import com.csot.recruit.soa.start.ESBOAOAImportStandardProcessSrvServiceagent;
import com.csot.recruit.soa.start.MsgHeader;

public class SendToOAUtil {

  @Resource
  private static SpringPropertyResourceReader springPropertyResourceReader;

  /**
   * OA WEBSERVICE 调用
   * 
   * @param soaObject WEBSERVICE自定义通用对象
   * @return
   */
  public static ESBOAOAImportStandardProcessSrvResponse invokeOpenPoOaSignProcess(SoaObject soaObject) {
    // 调用客户端
    String startOaFlowUrl = springPropertyResourceReader.getProperty("recruit.soa.start.url");
    ESBOAOAImportStandardProcessSrvServiceagent agent = null;
    try {
      agent = new ESBOAOAImportStandardProcessSrvServiceagent(new URL(startOaFlowUrl));
    } catch (MalformedURLException e) {
      java.util.logging.Logger
          .getLogger(ESBOAOAImportStandardProcessSrvServiceagent.class.getName())
          .log(
              java.util.logging.Level.INFO,
              "Can not invokeCsotVecnOaSignProcess wsdl from {0}",
              "http://t2eaesbapp01.csot.tcl.com:9005/CoreServices/BusinessServices/Services/ESB_OA_OA_ImportStandardProcessSrv/v1.0.0/ESB_OA_OA_ImportStandardProcessSrv.serviceagent?wsdl");
    }
    ESBOAOAImportStandardProcessSrv service = agent.getESBOAOAImportStandardProcessSrv();

    // 设置timeout等属性的方法，timeout的时间单位为ms毫秒
    ((BindingProvider) service).getRequestContext().put("com.sun.xml.internal.ws.connect.timeout",
        60000);
    ((BindingProvider) service).getRequestContext().put("com.sun.xml.internal.ws.request.timeout",
        60000);
    // ESB用户密码验证方法
    Client client = ClientProxy.getClient(service);
    Endpoint cxfEndpoint = client.getEndpoint();
    Map<String, Object> outProps = new HashMap<String, Object>();
    outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
    // 设置用户名,需要可配置
    String username = springPropertyResourceReader.getProperty("recruit.soa.start.user");
    String password = springPropertyResourceReader.getProperty("recruit.soa.start.password");
    outProps.put(WSHandlerConstants.USER, username);
    outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
    // 设置密码
    outProps.put(WSHandlerConstants.PW_CALLBACK_REF, new AuthClientPasswordHandler(password));
    WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
    cxfEndpoint.getOutInterceptors().add(wssOut);
    // WEBSERVICE主体数据
    ESBOAOAImportStandardProcessSrvRequest processPayload =
        new ESBOAOAImportStandardProcessSrvRequest();
    MsgHeader msgHeader = new MsgHeader();
    msgHeader.setAPPID(soaObject.getAppid());
    msgHeader.setAPPNAME(soaObject.getAppname());
    msgHeader.setMODID(soaObject.getModid());
    msgHeader.setMODNAME(soaObject.getModname());
    ESBOAOAImportStandardProcessSrvInputCollection inputCollection =
        new ESBOAOAImportStandardProcessSrvInputCollection();
    List<ESBOAOAImportStandardProcessSrvInputItem> inputItemList =
        inputCollection.getESBOAOAImportStandardProcessSrvInputItem();
    // 封装inputItem数据 申请人 唯一键
    ESBOAOAImportStandardProcessSrvInputItem inputItem =
        new ESBOAOAImportStandardProcessSrvInputItem();
    inputItem.setPRIKEY(soaObject.getPrikey());
    inputItem.setDOCCONTENT(soaObject.getDoccontent());
    inputItem.setDOCCREATOR(soaObject.getDoccreator());
    inputItem.setDOCSUBJECT(soaObject.getDocsubject());
    inputItem.setFDTEMPLATEID(soaObject.getFdtemplateid());
    System.out.println("FORMVALUE:" + soaObject.getFormvalues());
    inputItem.setFORMVALUES(soaObject.getFormvalues());
    // 填充inputItem
    inputItemList.add(inputItem);
    processPayload.setMsgHeader(msgHeader);
    processPayload.setESBOAOAImportStandardProcessSrvInputCollection(inputCollection);
    ESBOAOAImportStandardProcessSrvResponse res = service.process(processPayload);
    System.out.println("调用结束");
    return res;
    /*
     * if ("FALSE".equals(res.getSERVICEFLAG())) { throw new
     * RuntimeException(res.getSERVICEMESSAGE()); }
     */
  }
}
