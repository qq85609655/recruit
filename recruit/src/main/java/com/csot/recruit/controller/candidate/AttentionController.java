package com.csot.recruit.controller.candidate;

import com.csot.recruit.model.original.candidate.Attention;
import com.csot.recruit.model.original.candidate.CandidatePost;
import com.csot.recruit.model.original.flow.interview.Feedback;
import com.csot.recruit.service.candidate.AttentionService;
import com.csot.recruit.service.candidate.CandidateService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("attentionController")
public class AttentionController {
    private static final Logger logger = LoggerFactory.getLogger(AttentionController.class);

    @Resource
    private AttentionService attentionService;
    
    @Resource
    private CandidateService candidateService ;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/candidate/attentionList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<Attention> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return attentionService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/candidate/attentionEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        Attention attention = attentionService.getByPrimaryKey(id);
        request.setAttribute("attention", attention);
        return new ModelAndView("com/csot/recruit/candidate/attentionEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        Attention attention = attentionService.getByPrimaryKey(id);
        request.setAttribute("attention", attention);
        return new ModelAndView("com/csot/recruit/candidate/attentionView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            attentionService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(Attention attention) {
        if (StringUtils.hasText(attention.getId())) {
            try {
                attentionService.updateSelective(attention);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                attention.setId(UUID.randomUUID().toString().replace("-", ""));
                attentionService.create(attention);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
    
    
    
    @RequestMapping("addAttention")
    @ResponseBody
    public Map<String,Object> addAttention(@CurrentUser SysUser sysUser, String ids,String positionIds) {
      Map<String,Object> map = new HashMap<String,Object>();
      StringBuffer sb = new StringBuffer();
          try{
            
          String[] idsArray = ids.split(",");
          String[] positionIdsArray = positionIds.split(",");
          Attention attention = null ;
          Map<String,Object> param = null ;
          CandidatePost cp = null ;
          for(int i = 0 ; i < idsArray.length; i++){
            param = new HashMap<String,Object>();
            cp = new CandidatePost();
            
            param.put("candidateId", idsArray[i]);
            param.put("positionId", positionIdsArray[i]);
            cp = candidateService.selectCandidatePostByMap(param);
            if(cp != null){
              param.put("candidatePostId", cp.getId());
              param.put("userId", sysUser.getId());
              attention = attentionService.getAttentionByMap(param);
              if(null == attention){
                attention = new Attention();
                attention.setCreateTime(new Date());
                attention.setCandidatePostId(cp.getId());
                attention.setId(UUID.randomUUID().toString().replace("-", ""));
                attention.setUserId(sysUser.getId());
                attentionService.create(attention);
              }
            }
          }
            sb.append("关注成功");
            map.put("status", 200);
            return map ;
          }catch(Exception e){
            logger.error(e.getMessage(), e);
            map.put("status", 404);
            sb.append("网络异常");
          }finally{
            map.put("msg", sb.toString());
          }
          return map ;
 }
    
    @RequestMapping("cancelAttention")
    @ResponseBody
    public Map<String,Object> cancelAttention(@CurrentUser SysUser sysUser, String ids) {
      Map<String,Object> map = new HashMap<String,Object>();
      StringBuffer sb = new StringBuffer();
      Map<String,Object> param = new HashMap<String,Object>();
          try{
          String[] idsArray = ids.split(",");
          List<String> list = new ArrayList<String>();
          for(String str : idsArray){
            list.add(str);
          }
          param.put("list", list);
          param.put("userId", sysUser.getId());
          attentionService.batchRemove(param);
 
            sb.append("取消成功");
            map.put("status", 200);
            return map ;
          }catch(Exception e){
            logger.error(e.getMessage(), e);
            map.put("status", 404);
            sb.append("网络异常");
          }finally{
            map.put("msg", sb.toString());
          }
          return map ;
 }
}