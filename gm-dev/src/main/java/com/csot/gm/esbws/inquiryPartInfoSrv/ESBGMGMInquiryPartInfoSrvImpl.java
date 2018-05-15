/**
 * Please modify this class to meet your needs This class is not complete
 */

package com.csot.gm.esbws.inquiryPartInfoSrv;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import com.csot.gm.materialManage.model.extension.partNo.PartNoExt;
import com.csot.gm.materialManage.service.partNo.PartNoService;

/**
 * This class was generated by Apache CXF 2.5.2 2016-01-08T11:46:23.799+08:00 Generated source
 * version: 2.5.2
 * 
 */

@javax.jws.WebService(serviceName = "ESB_GM_GM_InquiryPartInfoSrv.serviceagent",
    portName = "ESB_GM_GM_InquiryPartInfoSrv",
    targetNamespace = "http://www.csot.tcl.com/ESB_GM_GM_InquiryPartInfoSrv/1.0",
    wsdlLocation = "ESB_GM_GM_InquiryPartInfoSrv.wsdl",
    endpointInterface = "com.csot.gm.esbws.inquiryPartInfoSrv.ESBGMGMInquiryPartInfoSrv")
public class ESBGMGMInquiryPartInfoSrvImpl implements ESBGMGMInquiryPartInfoSrv {

  private static final Logger LOG = Logger.getLogger(ESBGMGMInquiryPartInfoSrvImpl.class.getName());

  @Resource(name = "partNoService")
  private PartNoService partNoService;

  /*
   * (non-Javadoc)
   * 
   * @see com.csot.gm.esbws.inquiryPartInfoSrv.ESBGMGMInquiryPartInfoSrv#process(com.csot.gm.esbws.
   * inquiryPartInfoSrv.ESBGMGMInquiryPartInfoSrvRequest payload )*
   */
  @Override
  public com.csot.gm.esbws.inquiryPartInfoSrv.ESBGMGMInquiryPartInfoSrvResponse process(
      ESBGMGMInquiryPartInfoSrvRequest payload) {
    LOG.info("Executing operation process");
    String uid = payload.getUid();
    LOG.info("inquiry+uid：" + uid);
    try {
      com.csot.gm.esbws.inquiryPartInfoSrv.ESBGMGMInquiryPartInfoSrvResponse _return =
          new ESBGMGMInquiryPartInfoSrvResponse();
      PartNoExt pne = partNoService.getPartNoByUid(uid);
      if (null == pne) {
        _return.setSERVICEMESSAGE("未查询到相关信息");
        _return.setSERVICEFLAG("FALSE");
        _return
            .setESBGMGMInquiryPartInfoSrvOutputCollection(new ESBGMGMInquiryPartInfoSrvOutputCollection());
      } else {
        ESBGMGMInquiryPartInfoSrvOutputCollection value =
            new ESBGMGMInquiryPartInfoSrvOutputCollection();
        List<ESBGMGMInquiryPartInfoSrvOutputItem> esbgmgmInquiryPartInfoSrvOutputItem =
            new ArrayList<ESBGMGMInquiryPartInfoSrvOutputItem>();
        ESBGMGMInquiryPartInfoSrvOutputItem partInfo = new ESBGMGMInquiryPartInfoSrvOutputItem();
        partInfo.setCnDesc(pne.getCnDesc());
        partInfo.setEnDesc(pne.getEnDesc());
        partInfo.setPartName(pne.getPartName());
        partInfo.setPartNo(pne.getPartNo());
        partInfo.setCreateCode(pne.getCreateCode());
        partInfo.setCreateName(pne.getCreateName());
        partInfo.setDepartment(pne.getDepartment());
        partInfo.setTelephone(pne.getTelephone());
        esbgmgmInquiryPartInfoSrvOutputItem.add(partInfo);
        value.esbgmgmInquiryPartInfoSrvOutputItem = esbgmgmInquiryPartInfoSrvOutputItem;
        _return.setESBGMGMInquiryPartInfoSrvOutputCollection(value);
        _return.setSERVICEFLAG("TRUE");
        _return.setSERVICEMESSAGE("查询成功！");
      }
      return _return;
    } catch (java.lang.Exception ex) {
      LOG.info(ex.getMessage());
      throw new RuntimeException(ex);
    }
  }

}
