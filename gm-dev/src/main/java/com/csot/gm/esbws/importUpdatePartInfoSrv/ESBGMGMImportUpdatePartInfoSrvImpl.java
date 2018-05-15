
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.csot.gm.esbws.importUpdatePartInfoSrv;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import com.csot.gm.materialManage.model.original.partNo.PartNo;
import com.csot.gm.rawMaterial.service.PartSaveService;

/**
 * This class was generated by Apache CXF 2.5.2
 * 2016-01-08T13:29:13.424+08:00
 * Generated source version: 2.5.2
 * 
 */

@javax.jws.WebService(
                      serviceName = "ESB_GM_GM_ImportUpdatePartInfoSrv.serviceagent",
                      portName = "ESB_GM_GM_ImportUpdatePartInfoSrv",
                      targetNamespace = "http://www.csot.tcl.com/ESB_GM_GM_ImportUpdatePartInfoSrv/1.0",
                      wsdlLocation = "ESB_GM_GM_ImportUpdatePartInfoSrv.wsdl",
                      endpointInterface = "com.csot.gm.esbws.importUpdatePartInfoSrv.ESBGMGMImportUpdatePartInfoSrv")
                      
public class ESBGMGMImportUpdatePartInfoSrvImpl implements ESBGMGMImportUpdatePartInfoSrv {

    private static final Logger LOG = Logger.getLogger(ESBGMGMImportUpdatePartInfoSrvImpl.class.getName());

    @Resource(name = "PartSaveService")
    private PartSaveService partSaveService;
    
    /* (non-Javadoc)
     * @see com.csot.gm.esbws.importUpdatePartInfoSrv.ESBGMGMImportUpdatePartInfoSrv#process(com.csot.gm.esbws.importUpdatePartInfoSrv.ESBGMGMImportUpdatePartInfoSrvRequest  payload )*
     */
    @Override
    public com.csot.gm.esbws.importUpdatePartInfoSrv.ESBGMGMImportUpdatePartInfoSrvResponse process(ESBGMGMImportUpdatePartInfoSrvRequest payload) { 
        LOG.info("Executing operation process");
        LOG.info(payload.toString());
        ESBGMGMImportUpdatePartInfoSrvInputCollection partInfo = payload.getESBGMGMImportUpdatePartInfoSrvInputCollection();
        List<ESBGMGMImportUpdatePartInfoSrvInputItem> updatePartInfoList = partInfo.getESBGMGMImportUpdatePartInfoSrvInputItem();
        LOG.info("待更新料号数量：" + updatePartInfoList.size());
        try {
          com.csot.gm.esbws.importUpdatePartInfoSrv.ESBGMGMImportUpdatePartInfoSrvResponse _return = new ESBGMGMImportUpdatePartInfoSrvResponse();
            if (null == updatePartInfoList || updatePartInfoList.isEmpty()) {
              _return.setSERVICEMESSAGE("无可更新物料");
              _return.setSERVICEFLAG("FALSE");
            } else {
              List<PartNo> list = new ArrayList<PartNo>();
              for (int i = 0; i < updatePartInfoList.size(); i++) {
                String partNo = updatePartInfoList.get(i).getPartNo();
                if (null != partNo && !"".equals(partNo)) {
                  PartNo pn = new PartNo();
                  pn.setCnDesc(updatePartInfoList.get(i).getCnDesc());
                  pn.setEnDesc(updatePartInfoList.get(i).getEnDesc());
                  pn.setPartName(updatePartInfoList.get(i).getPartName());
                  pn.setPartNo(partNo);
                  pn.setPartNoStatus(updatePartInfoList.get(i).getPartNoStatus());
                  list.add(pn);
                }
              }
              boolean isUpdate = partSaveService.updatePartNoStatus(list);
              if(isUpdate) {
                _return.setSERVICEMESSAGE("更新成功");
                _return.setSERVICEFLAG("TRUE");
              } else {
                _return.setSERVICEMESSAGE("更新失败");
                _return.setSERVICEFLAG("FALSE");
              }
            }
            _return.setErrorCollection(new ErrorCollection());
            _return.setResponseCollection(new ResponseCollection());
            return _return;
        } catch (java.lang.Exception ex) {
            LOG.info(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

}
