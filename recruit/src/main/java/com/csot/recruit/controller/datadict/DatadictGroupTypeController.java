package com.csot.recruit.controller.datadict;

import com.csot.recruit.common.service.CommonService;
import com.csot.recruit.model.datadict.DatadictGroupType;
import com.csot.recruit.service.datadict.DatadictGroupTypeService;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("datadictGroupTypeController")
public class DatadictGroupTypeController {
    private static final Logger logger = LoggerFactory.getLogger(DatadictGroupTypeController.class);

    @Resource
    private DatadictGroupTypeService datadictGroupTypeService;
    
    @Resource
    private CommonService commonService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/controller/datadict/datadictGroupTypeList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<DatadictGroupType> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return datadictGroupTypeService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/controller/datadict/datadictGroupTypeEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        DatadictGroupType datadictGroupType = datadictGroupTypeService.getByPrimaryKey(id);
        request.setAttribute("datadictGroupType", datadictGroupType);
        return new ModelAndView("com/csot/recruit/controller/datadict/datadictGroupTypeEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        DatadictGroupType datadictGroupType = datadictGroupTypeService.getByPrimaryKey(id);
        request.setAttribute("datadictGroupType", datadictGroupType);
        return new ModelAndView("com/csot/recruit/controller/datadict/datadictGroupTypeView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            datadictGroupTypeService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(DatadictGroupType datadictGroupType) {
        if (StringUtils.hasText(datadictGroupType.getTypeId())) {
            try {
                datadictGroupTypeService.updateSelective(datadictGroupType);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                datadictGroupType.setTypeId(UUID.randomUUID().toString().replace("-", ""));
                datadictGroupTypeService.create(datadictGroupType);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
    
    
    @RequestMapping("saveDataGroupType")
    @ResponseBody
    public AjaxRtnJson saveDataGroupType(DatadictGroupType datadictGroupType) {
    	if(datadictGroupTypeService.getDatadictGroupType(datadictGroupType) != 0){
    		return new AjaxRtnJson(false, "在该一级节点配置已存在同名称的配置" );
    	}
        if (StringUtils.hasText(datadictGroupType.getTypeId())) {
            try {
                datadictGroupTypeService.updateSelective(datadictGroupType);
                commonService.initAllDatadict();
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                datadictGroupType.setTypeId(UUID.randomUUID().toString().replace("-", ""));
                datadictGroupTypeService.create(datadictGroupType);
                commonService.initAllDatadict();
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
    
    
    /***
     * 根据ID删除数据字典group_type表数据
     * @param id 
     * @return
     */
    @RequestMapping("removeByGroupTypeId")
    @ResponseBody
    public AjaxRtnJson removeByGroupTypeId(@RequestParam(value = "id", required = true) String id) {
    	try {
    		datadictGroupTypeService.remove(id);
    		commonService.initAllDatadict();
    		return new AjaxRtnJson(true,"删除成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
		}
    }
    
    @RequestMapping("getDictsByCode/{groupCode}")
    @ResponseBody
    public MiniRtn2Grid<DatadictGroupType> getDictsByCode(@PathVariable String groupCode) {
        return datadictGroupTypeService.getGridByGorupCode(groupCode);
    }
  
}