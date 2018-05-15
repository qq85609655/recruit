/**
 * .
 * @author WangYu
 */

package org.amberframework.web.demo.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Demo.
 * 
 * <p>
 * This is only a demo
 * </p>
 * 
 * @author WangYu
 */
@Controller
@RequestMapping(value="hrPlmController")
public class HrPlmController {

  private static final Logger logger = LoggerFactory.getLogger(HrPlmController.class);
  
//  @Resource
//  private ModelnameMapper modelnameMapper;

  @RequestMapping(value="hrPlm")
  public ModelAndView hrPlm(HttpServletRequest request) {
//    UserCriteria userCriteria = new UserCriteria();
//    //userExample.createCriteria().andJobNumberEqualTo("00001' or '1'='1");
//    //userExample.createCriteria().andJobNumberEqualTo("00001\' or \'1\'=\'1");
//    userCriteria.createCriteria().andJobNumberEqualTo("00001");
//    ModelnameCriteria modelnameCriteria = new ModelnameCriteria();
//    int modelnameCount = modelnameMapper.countByExample(modelnameCriteria);
//    request.setAttribute("modelnameCount", modelnameCount);
    System.out.println(request.getParameter("method"));
    return new ModelAndView("index");
  }

//  public UserMapper getUserMapper() {
//    return userMapper;
//  }
//
//  public void setUserMapper(UserMapper userMapper) {
//    this.userMapper = userMapper;
//  }
//
//  public ModelnameMapper getModelnameMapper() {
//    return modelnameMapper;
//  }
//
//  public void setModelnameMapper(ModelnameMapper modelnameMapper) {
//    this.modelnameMapper = modelnameMapper;
//  }

}
