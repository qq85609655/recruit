package com.csot.recruit.controller.flow.interview;

import com.csot.recruit.model.original.flow.interview.Feedback;
import com.csot.recruit.model.vo.InterviewBookVo;
import com.csot.recruit.service.flow.interview.FeedbackService;

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
@RequestMapping("feedbackController")
public class FeedbackController {
    private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class);

    @Resource
    private FeedbackService feedbackService;

    @RequestMapping("list")
    public ModelAndView list() {
        return new ModelAndView("com/csot/recruit/flow/interview/feedbackList");
    }

    @RequestMapping("datagrid")
    @ResponseBody
    public MiniRtn2Grid<Feedback> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
        String searchKey = request.getParameter("searchKey");
        return feedbackService.getGrid(pageSort, searchKey);
    }

    @RequestMapping("create")
    public ModelAndView create() {
        return new ModelAndView("com/csot/recruit/flow/interview/feedbackEdit");
    }

    @RequestMapping("modify/{id}")
    public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
        Feedback feedback = feedbackService.getByPrimaryKey(id);
        request.setAttribute("feedback", feedback);
        return new ModelAndView("com/csot/recruit/flow/interview/feedbackEdit");
    }

    @RequestMapping("view/{id}")
    public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
        Feedback feedback = feedbackService.getByPrimaryKey(id);
        request.setAttribute("feedback", feedback);
        return new ModelAndView("com/csot/recruit/flow/interview/feedbackView");
    }

    @RequestMapping("remove/{id}")
    @ResponseBody
    public AjaxRtnJson remove(@PathVariable String id) {
        try {
            feedbackService.remove(id);
            return new AjaxRtnJson(true, "删除成功");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
        }
    }

    @RequestMapping("save")
    @ResponseBody
    public AjaxRtnJson save(Feedback feedback) {
        if (StringUtils.hasText(feedback.getId())) {
            try {
                feedbackService.updateSelective(feedback);
                return new AjaxRtnJson(true, "修改成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
            }
        } else {
            try {
                feedback.setId(UUID.randomUUID().toString().replace("-", ""));
                feedbackService.create(feedback);
                return new AjaxRtnJson(true, "新建成功");
            } catch (DataAccessException e) {
                logger.error(e.getMessage(), e);
                return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
            }
        }
    }
    
    @RequestMapping("batchInsertFeedBack")
    @ResponseBody
    public Map<String,Object> batchInsertFeedBack(@CurrentUser SysUser sysUser, String ids,String reason) {
      Map<String,Object> map = new HashMap<String,Object>();
      StringBuffer sb = new StringBuffer();
          try{
            
          String[] idsArray = ids.split(",");
          Feedback feedback = null ;
          List<String> list = new ArrayList<String>();
          for(String item : idsArray){
            list.add(item);
          }
          Map<String,Object> param = new HashMap<String,Object>();
          param.put("list", list);
          feedbackService.removeByInterviewIds(param);
          for(String id : idsArray){
            
            feedback = new Feedback();
            feedback.setContent(reason);
            feedback.setCreateTime(new Date());
            feedback.setInterviewId(id);
            feedback.setId(UUID.randomUUID().toString().replace("-", ""));
            feedback.setUserId(sysUser.getId());
            feedbackService.create(feedback);
          }
            sb.append("保存成功");
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