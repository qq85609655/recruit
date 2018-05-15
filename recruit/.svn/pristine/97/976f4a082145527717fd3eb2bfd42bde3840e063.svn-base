package com.csot.recruit.controller.datadict;

import java.util.List;
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

import com.csot.recruit.common.service.CommonService;
import com.csot.recruit.model.datadict.DataConfig;
import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.service.datadict.DatadictGroupService;

@Controller
@RequestMapping("datadictGroupController")
public class DatadictGroupController {
    private static final Logger logger = LoggerFactory.getLogger(DatadictGroupController.class);

    @Resource
    private DatadictGroupService datadictGroupService;
    
    @Resource
    private CommonService commonService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/controller/datadict/datadictGroupList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<DatadictGroup> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return datadictGroupService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/controller/datadict/datadictGroupEdit");
    }

    @RequestMapping("config/{code}")
    public ModelAndView modify(@PathVariable String code, HttpServletRequest request) {
      request.setAttribute("typeGroupCode", code);  
      return new ModelAndView("com/csot/datadict/dataConfig");
    }
   
    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        DatadictGroup datadictGroup = datadictGroupService.getByPrimaryKey(id);
        request.setAttribute("datadictGroup", datadictGroup);
        return new ModelAndView("com/csot/recruit/controller/datadict/datadictGroupView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            datadictGroupService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(DatadictGroup datadictGroup) {
        if (StringUtils.hasText(datadictGroup.getGroupId())) {
            try {
                datadictGroupService.updateSelective(datadictGroup);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                datadictGroup.setGroupId(UUID.randomUUID().toString().replace("-", ""));
                datadictGroupService.create(datadictGroup);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
    /***
     * 跳转数据配置页面
     * @return
     */
    @RequestMapping("dataConfig")
    public ModelAndView dataConfig() {
        return new ModelAndView("com/csot/datadict/dataConfig");
    }
    
    /***
     * 查询数据配置信息
     * @return
     */
    @RequestMapping("queryDatadictList")
    @ResponseBody
    public List<DataConfig> queryDatadictList() {
        return datadictGroupService.queryDatadictGroupList();
    }
    
    /***
     * 创建、更新数据配置数据
     * @param datadictGroup
     * @return
     */
    @RequestMapping("saveDataGroup")
    @ResponseBody
    public AjaxRtnJson saveDataGroup(DatadictGroup datadictGroup) {
    	if(datadictGroupService.getDatadictGroupCount(datadictGroup) != 0){
    		return new AjaxRtnJson(false, "已存在同名称的配置" );
    	}
        if (StringUtils.hasText(datadictGroup.getGroupId())) {
            try {
                datadictGroupService.updateSelective(datadictGroup);
                commonService.initAllDatadict();
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                datadictGroup.setGroupId(UUID.randomUUID().toString().replace("-", ""));
                datadictGroupService.create(datadictGroup);
                commonService.initAllDatadict();
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
    
    /***
     * 根据ID删除数据字典group
     * @param id 
     * @return
     */
    @RequestMapping("removeByGroupId")
    @ResponseBody
    public AjaxRtnJson removeByGroupId(@RequestParam(value = "groupId", required = true) String groupId) {
    	int count = datadictGroupService.getGroupTypeCountByGroupId(groupId);
    	//判断一级菜单下是否二级菜单项，如果有责给出提示
    	if(count != 0){
    		return new AjaxRtnJson(false, "该配置项下面还有子配置项，请先删除该配置项的子配置项" );
    	}
    	try {
    		datadictGroupService.remove(groupId);
    		commonService.initAllDatadict();
    		return new AjaxRtnJson(true,"删除成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
		}
    }

}