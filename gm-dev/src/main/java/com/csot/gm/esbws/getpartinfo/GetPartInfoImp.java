package com.csot.gm.esbws.getpartinfo;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import com.csot.gm.esbws.getpartinfo.utils.PartInfoForm;
import com.csot.gm.esbws.getpartinfo.utils.PartPropertyBean;
import com.csot.gm.esbws.getpartinfo.utils.WXPartInfoForm;
import com.csot.gm.materialManage.dao.extension.propertyRtn.PropertyRtnExtMapper;
import com.csot.gm.materialManage.dao.extension.wxmap.WXMapExtMapper;
import com.csot.gm.materialManage.model.extension.partNo.PartNoExt;
import com.csot.gm.materialManage.model.extension.propertyRtn.PropertyRtnExt;
import com.csot.gm.materialManage.model.extension.wxmap.WXMapExt;
import com.csot.gm.materialManage.service.partNo.PartNoService;

@WebService(endpointInterface = "com.csot.gm.esbws.getpartinfo.GetPartInfo")
public class GetPartInfoImp implements GetPartInfo {

  @Resource(name = "partNoService")
  private PartNoService partNoService;

  @Resource(name = "WXMapExtMapper")
  private WXMapExtMapper wxMapExtMapper;

  @Resource(name = "propertyRtnExtMapper")
  private PropertyRtnExtMapper propertyRtnExtMapper;

  @Override
  public WXPartInfoForm getWXInformation(String uuid) {
    WXPartInfoForm wxForm = new WXPartInfoForm();
    PartNoExt partNOExt = partNoService.getPartNoByUid(uuid);
    if (partNOExt != null) {
      String partNO = partNOExt.getPartNo();
      wxForm.setPartInfo(partNO);
      List<WXMapExt> wxInfoExt = wxMapExtMapper.selectByWXCode(partNO);
      if (!wxInfoExt.isEmpty()) {
        wxForm.setPrePartInfo(wxInfoExt.get(0).getSpareCode());
      }
    }

    return wxForm;
  }

  @Override
  public PartInfoForm getCreatPartInfo(String uuid) {
    PartInfoForm partForm = new PartInfoForm();
    List<PropertyRtnExt> properties = propertyRtnExtMapper.selectByUid(uuid);
    HashMap<String, PartPropertyBean> propertyMap = new HashMap<String, PartPropertyBean>();
    if (!properties.isEmpty()) {
      for (PropertyRtnExt rtn : properties) {
        PartPropertyBean bean = new PartPropertyBean();
        bean.setTrueValue(rtn.getPropertyValue());
        bean.setDisplayValue(rtn.getPropertyText());
        propertyMap.put(rtn.getPropertyName(), bean);
      }
      partForm.setProperties(propertyMap);
    }

    return partForm;
  }

}
