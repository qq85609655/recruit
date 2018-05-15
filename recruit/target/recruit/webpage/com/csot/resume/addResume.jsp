<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
  <head>
    <base href="${ctx}/resume/addResume">
    <%@include file="/webpage/common.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title id="resumeTitle">简历编辑</title>
  </head>
  <body >
    <div class="backColor">
      <div>
      <input id="hidResumeLanguage" name="hidResumeLanguage" type="hidden" value="" />
      <div id="resume_header" style=" position:fixed; top:0px; left:0px;">
        <div class="header_tab">
          <div class="tab_title">
            <span>中文简历</span>&nbsp;&nbsp;<span>Resume</span>
          </div>
        </div>
      </div>
      <div  id="resume_menu" >
           <div style="vertical-align:middle;float: left;margin-top: 32px;">&nbsp;&nbsp;&nbsp;&nbsp; 是否锁定候选人<input id="isLock"  type="checkbox" name="isLock" value="1"></div>
          <div class="resume_menu_button" id="resume_menu_button" style="float: right;">
           <input type="button" value="保存" class="menu_btn" id="btnSaveResume" />&nbsp;&nbsp;
           <a href="" target="preview-window" id = "resumePreview"></a> 
           <input type="button"  value="预览" class="menu_btn" id="btnShowResume"/>
          </div>
          <div class="clr"></div>
        </div>
      <div id="content" class="resumeContent" >
        <!-- 基本信息 -->
        <h3 class="tit_blue">基本信息
            <a id="btnEditBasicInfo" class="edit_resume" style="display: block;">编辑</a>  
          </h3>
        <div class="resume_basicinfo same">
          <div class="grayBg basicinfoShow" style="height:250px;">
              <div class="avatar">
                <!-- <p style="display:none;"><img id="resumeAvatarImg" alt="" src="../resources/images/photo_100.jpg"></p>
                <p style="display: none;"><a id="btnUpload" class="uc03c"  href="javascript:void(0);">上传头像</a></p>
                <img style="display: none;" id="uploading" src="../resources/images/ajax-loader.gif" alt="上传中"> -->
              </div>  
              <div class="basicinfoData" id="basicinfoData">
                
              </div> 
              <div class="clr"></div>
      </div>
          <div>
            <input type="text" value="${id}" id="hiddenData" style="display:none;">
            <input type="text" value="" id="positionId" style="display:none;">
            <input type="text" value="${preview}" id="previewResume" style="display:none;">
            <a href="" id="resumeSave" target="resumeSave-window"></a>
            <form action="" id="basicInforForm">
              <table width="100%" cellspacing="0" cellpadding="0" border="0" class="basicFormTable" >
                <tbody>
                  <tr>
                    <th class="c999"><span class="red">*</span> <span>姓名：</span></th>
                    <td> <input type="text" value="" name="Name" maxlength="50" id="Name" class="fl input_txt w150" onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\.]/g,'')" onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\.]/g,'')" oncontextmenu = "value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\.]/g,'')" ><span id="nameError"  class="error"></span></td>
                  </tr>
                  <tr>
                    <th class="c999"><span class="red">*</span> <span>岗位：</span></th>
                    <td> <input name="applyPostName" id="applyPostName" class="mini-textbox"
              value="" required="true" readonly="readonly" /><label
              class="copy-posi" onclick="choseJob()"> <label class="font-icon icon-reply-all"
                title="选择岗位"></label>选择岗位
            </label><span id="applyPostNameError"  class="error"></span></td>
                  </tr>
                 
                   <tr>
                    <th  class="c999">&nbsp;<span>国籍:</span></th>
                    <td> <t:dictSelect labelClass="interview" type="select" id="nationality" field="nationality" typeGroupCode="nationality" defaultVal="${ basicInfo.nationality }" hasLabel="false"></t:dictSelect></td>
                  </tr>
                  <tr>
                    <th  class="c999">&nbsp;<span>性别:</span></th>
                    <td> <select name="Sex" id="Sex"><option value="">-选择-</option><option value="001-000">男</option><option value="001-001">女</option></select></td>
                  </tr>
                  <tr class="brithdayTime">
                    <th class="c999">&nbsp;<span>出生日期：</span></th>
                    <td><input type="text" class="mini-datepicker input_txt" id="brithday" ondrawdate="onBrithDrawDate" showTodayButton="false">
                  </tr>
                  <tr>
                    <th class="c999">&nbsp;居住地： </th>
                    <td><input type="button" value="选择/修改" id="residencyBtn" title="选择/修改" class="choose_btn"> <a style="display:none;" class="fltl rst" id="residencyClear">清除</a>
                        <input type="hidden" id = "residencyHid">
                        <div class ="residencyData pData">
                          <div class="residencyTitle pTitle">
                            <span><b>选择居住地</b></span> <span class="closeResidency close"><b>X</b></span>
                          </div>
                          <div class="residencyContent pContent"></div>
                        </div>
                        <div class="residencyChildData cData">
                            <div class="residencyChildTitle cTitle"><span class="closeResidency close"><b>X</b></span></div>
                            <div class="residencyChildContent cContent"></div>
                        </div>
                        </td>     
                  </tr>
                  <tr>
                    <th class="c999">&nbsp;婚姻状况：</th>
                    <td><select name="Marriage" id="Marriage"><option value="">-选择-</option><option value="019-001">未婚</option><option value="019-002">已婚</option><option value="019-003">离异</option></select></td>
                  </tr>
                  <tr>
                    <th class="c999">&nbsp;工作年限：</th>
                    <td><input type="text" value="" name="WorkYears" maxlength="3" id="WorkYears" class="input_txt w150">&nbsp;&nbsp;<span id="wordYearsCheck" style="display:none;" class="red">工作年限在0-100之间</span></td>
                  </tr>
                  <tr>
                    <th class="c999">&nbsp;备用电话： </th>
                    <td><input type="text" value="" name="AlternativePhone" maxlength="25" id="AlternativePhone" class="input_txt w150"></td>
                  </tr>
                  <tr>
                    <th class="c999"><span class="red">*</span>手机号码：</th>
                    <td><input type="text" value="" name="Phone" maxlength="25" id="Phone" class="input_txt w150">&nbsp;<label style="display: none; " class="error" id="mobileLengthTips" for="Mobile">请输入11位数字手机号码</label></td>
                  </tr>
                  <tr>
                    <th class="c999"><span class="red">*</span>邮箱地址：</th>
                    <td><input type="text" value="" name="Email" maxlength="100" id="Email" class="input_txt w230"><span id="emailError"  class="error"></span></td>
                  </tr>
                  <tr>
                    <th class="c999">&nbsp;联系地址：</th>
                    <td><input type="text" value="" name="Address" maxlength="250" id="Address" class="input_txt w640"></td>
                  </tr>
                  <tr>
                    <th class="c999">&nbsp;民族：</th>
                    <td><t:dictSelect labelClass="interview" type="select" id="nation" field="nation" typeGroupCode="nation" defaultVal="${ basicInfo.nation }" hasLabel="false"></t:dictSelect></td>
                  </tr>
                  <tr>
                  <th class="c999">&nbsp;证件类型：</th>
                    <td><t:dictSelect labelClass="interview" type="select" id="certificateType" field="certificateType" typeGroupCode="certificate-type" defaultVal="${ basicInfo.certificateType }" hasLabel="false"></t:dictSelect></td>
                  </tr>
                  <tr>
                    <th class="c999"><span class="red">*</span>&nbsp;证件号码：</th>
                    <td>
                      <input type="text" value="" name="IDNumber" maxlength="250" id="IDNumber" class="input_txt w230" onKeyUp="value=value.replace(/[^\d|chun]/g,'')">
                    </td>
                  </tr>
                  <tr>
                    <th class="c999">&nbsp;身份证地址：</th>
                    <td><input type="text" value="" name="IDAddress" maxlength="250" id="IDAddress" class="input_txt w640"></td>
                  </tr>
                  <tr style="height: 60;">
                    <th></th>
                    <td class="pt8"><input type="button" id="editBascicInfoSave" class="submit_btn" value="保存">&nbsp;&nbsp;
                    <input type="button" id="editBacsicInfoCancel" class="cancel_btn cancel_btn_pop" value="取消"></td>
                  </tr>
                </tbody>
              </table>
            </form>
          </div>
        </div>
        
        <!-- 背景概要 -->
        <h3  id="showSelfEvaluation" class="tit_blue nobd"> 背景概要
          <a id="btnEditSelfEvaluation"  data-tip="SelfEvaluation" class="editdetail edit_resume" >编辑</a>&nbsp;&nbsp;&nbsp;
          <a id="btnEdlSelfEvaluation"  class="dels" style=" display: block;">删除</a>
        </h3>
        <div class="selfEvaluation same bd_c8e4f1 grayBg">
          <div id="viewSelfEvaluation" class="pt8" style="display: none;" data-tip="pt8SelfEvaluation"></div>
          <div id="SelfEvaluation" class=" work_exp ">
            <div id="divEditSelfEvaluation" style="">
              <form method="post" id="editSelfEvaluationForm" >                    
                <textarea rows="10" name="SelfEvaluation" id="editSelfEvaluation" cols="40"></textarea>                    
                <p class="pt10">
                  <input type="button" value="保存" data-tip="pt8SelfEvaluation" class="submit_btn_pop" id="SelfEvaluationSave">
                  <input type="button" class="cancel_btn_pop cancel_detail" data-tip="SelfEvaluation" value="取消">
                </p>
              </form>                
            </div>
          </div>
        </div>
        
        <!-- 求职意向 -->
        <h3  id="showCareerObject" class="tit_blue nobd">求职意向 
          <a id="btnEditCareerObject" data-tip="CareerObject" class="editdetail edit_resume" >编辑</a>&nbsp;&nbsp;&nbsp;
          <a   data-tip="SelfEvaluation" class="dels" >删除</a>       </h3>
        <div id="CareerObject" class="bd_c8e4f1 work_exp grayBg same" >
            <div style="display: none;" class="pt8" id="viewCareerObject" data-tip="pt8viewCareerObject"></div>
            <div style="" id="divEditCareerObject">
              <form  id="editCareerObjectForm" method="post">                    
                <input value="-1582113222" name="resumeId" type="hidden">
                <input value="CareerObject" name="key" type="hidden">
                <textarea cols="40" id="editCareerObject" name="paragraphText" rows="10"></textarea>                    
                <p class="pt10">
                  <input class="submit_btn_pop" value="保存" data-tip="pt8viewCareerObject" type="button" id="careerObjectSave">
                  <input value="取消" data-tip="CareerObject" class="cancel_btn_pop cancel_detail" type="button">
                </p>
              </form>                
            </div>
        </div>
        
        <!-- 工作经历 -->
        <h3 style="" id="showWork" class="tit_blue nobd">工作经历  
          <a id="expAddBtn" data-tip="WorkExperience" class="increase edit_resume">添加</a>
        </h3>
          <div style="" id="workCon" class="grayBg bd_c8e4f1 work_exp same">
            <div class="workConData" id="workConData">
            
            </div>
            <div id="expFormWrap">
              <form method="post" id="editExperienceForm" >
                <input type="hidden" name="resumeId" value="-1582113222">
                <div class="expInfo bord">
                  <table width="100%" border="0">
                    <tbody>
                      <tr>
                        <td width="120" class="c999"><span class="red">* </span> 公司名称：</td>
                        <td colspan="3"><input type="text" value="" name="Company" maxlength="100" id="Company" class="w222 fl input_txt"><span class="error" id="companyError"></span></td>
                        <td> &nbsp;&nbsp;&nbsp;<span class="red">添加第一份工作经历，保存以后，点击右上角的"加号"图标，添加多条工作经历，工作经历按时间倒序排序 ，在"加号"图标下方有"编辑"与"删除"按钮</span></td>
                      </tr>
                      <tr>
                        <td class="c999"> <span class="red">* </span> 时间：</td>
                        <td  colspan="4" id="timeSelect">
                          <input type="text" value="" class="mini-datepicker input_txt" name="StartDate" id="expStartDate" format="yyyy-MM-dd" ondrawdate="onDrawDate">&nbsp;至
                          <input type="text" value="" class="mini-datepicker input_txt" name="EndDate" id="expEndDate" format="yyyy-MM-dd"  ondrawdate="onDrawDate">&nbsp;
                          <span class="red" id="expDateError"></span>
                        </td>
                      </tr>
                      <tr>
                        <td class="c999"> &nbsp;&nbsp;行业类别：</td>
                        <td> 
                          <input type="button" title="选择/修改" value="选择/修改" id="industryBtn"  class="choose_btn"><a style="display:none;" class="fltl rst" id="industryClear">清除</a> 
                          <input type="hidden" id="industryHid">
                           <div class ="industryBtn pData">
                          <div class="industryTitle pTitle">
                            <span><b>行业类别</b></span> <span class="industryClose close"><b>X</b></span>
                          </div>
                          <div class="industryContent pContent"></div>
                        </div>
                        <div class="industryChild cData">
                            <div class="industryChildTitle cTitle"><span class="industryChildClose close"><b>X</b></span></div>
                            <div class="industryChildContent cContent"></div>
                        </div>
                        </td>
                      </tr>
                      <tr>
                        <td width="80" class="c999"><span class="red">* </span> 职位名称： </td>
                        <td> <input type="text" value="" name="RoleName" maxlength="100" id="RoleName" class="w150 fl input_txt"><span class="error" id="roleError"></span> </td>
                        <td> &nbsp;</td>
                      </tr>
                      <tr>
                        <td class="c999">&nbsp;&nbsp;工作地点：</td>
                        <td id="locationOffset">
                          <input type="button" value="选择/修改" title="选择/修改" id="locationBtn" class="choose_btn"><a style="display:none;" class="fltl rst" id="locationClear">清除</a> 
                          <input type="hidden" value="" id="locationHid">
                           <div class ="locationData pData">
                          <div class="locationTitle pTitle">
                            <span><b>选择居住地</b></span> <span class="closeLocation close"><b>X</b></span>
                          </div>
                          <div class="locationContent pContent"></div>
                        </div>
                        <div class="locationChildData cData">
                            <div class="locationChildTitle cTitle"><span class="closeClocation close"><b>X</b></span></div>
                            <div class="locationChildContent cContent"></div>
                        </div>
                        </td>
                      </tr>
                      <tr>
                        <td class="c999">&nbsp;&nbsp;公司性质：</td>
                       <td><select name="CompanyTypeId" id="CompanyTypeId"><option value="">-选择-</option><option value="020-001">外资(欧美)</option><option value="020-002">外资(非欧美)</option><option value="020-003">合资(欧美)</option><option value="020-004">合资(非欧美)</option><option value="020-005">国企/上市公司</option><option value="020-006">民营/私营公司</option><option value="020-007">外企代表处</option><option value="020-008">其它性质</option></select></td>
                       <td>&nbsp;</td>
                     </tr>
                     <tr>
                       <td class="c999">&nbsp;&nbsp;工作职责： </td>
                       <td colspan="4"><textarea rows="10" name="Responsibility" id="Responsibility" cols="10" class="desc"></textarea> <p class="c999">工作职责长度不超过1000字</p><span class="error" id="descriptionError"></span></td>
                     </tr>
                     <tr>
                       <td colspan="5"><div class="imgM"><span id="plus" class="plus">&nbsp;</span>更多信息</div>
                         <div id="moreInfo">
                           <table border="0"  width="55%">
                             <tbody>
                               <tr>
                                 <td class="c999" width="200px;">汇报对象：</td>
                                 <td> <input type="text" value="" name="ReportObject" maxlength="50" id="ReportObject" class="fl input_txt"> </td>
                                 <td class="c999">下属人数： </td>
                                 <td><input type="text" value="" name="Subordinate" maxlength="6" id="Subordinate" class="fl input_txt"><span class="error" id="subError"></span></td>
                               </tr>
                               <tr>
                                 <td class="c999">职位薪水：</td>
                                 <td colspan="3">
                                   <select name="CurrencyType" id="CurrencyType"><option value="">-选择-</option><option value="021-001">人民币</option><option value="021-002">港币</option><option value="021-003">美元</option><option value="021-004">日元</option><option value="021-005">欧元</option></select>
                                   <input type="text" value="" name="Salary" maxlength="8" id="Salary" class="fl ml10 input_txt">
                                   <span class="error" id="salaryError"></span>
                                 </td>
                               </tr>
                               <tr>
                                 <td class="c999">业绩描述：  </td>
                                 <td colspan="3">
                                   <textarea rows="10" name="Achievement" id="Achievement" cols="10" class="desc"></textarea>
                                   <p class="c999">业绩描述长度不超过1000字</p>
                                   <span class="error" id="achievementError"></span>
                                 </td>
                               </tr>
                             </tbody>
                           </table>
                         </div>
                       </td>
                     </tr>
                     <tr style="height: 60;">
                       <td></td>
                       <td class="pt10" colspan="4">
                         <input type="button" class="submit_btn" value="保 存" id="editResumeExperienceSave">&nbsp;
                         <input type="button" class="cancel_btn_pop" value="取 消" data-tip="WorkExperience"  id="editResumeExperienceCancel"></td>
                     </tr>
                   </tbody>
                 </table>
               </div>
             </form>
           </div>
         </div>
         
         <!-- 详细工作经历 -->
         <h3 style="" id="showWorkDetails" class="tit_blue nobd">详细工作经历 
           <a id="btnEditExperienceDetail" data-tip="ExperienceDetail" class="edit_resume" >编辑</a>&nbsp;&nbsp;&nbsp;
            <a   data-tip="SelfEvaluation" class="editdetail dels" >删除</a>
         </h3>
         <div style="" id="workDetailsCon" class="bd_c8e4f1 work_exp grayBg same">
           <div id="viewExperienceDetail" class="pt8" style="display: none;" data-tip="pt8ExperienceDetail"></div>
             <div id="divEditExperienceDetail" style="">
               <form method="post" id="editExperienceDetailForm">                    
                 <input type="hidden" name="resumeId" value="-1207654033">
                 <textarea rows="10" name="experienceDetail" id="editExperienceDetail" cols="40"></textarea>                    
                 <p class="pt10">
                   <input type="button" value="保存" class="submit_btn_pop" data-tip="pt8ExperienceDetail" id="experienceDetailSave">
                   <input type="button" value="取消" id="resetExperienceDetail" data-tip="ExperienceDetail" class="cancel_btn_pop">
                 </p>
               </form>          
             </div>
           </div>
           
           <!-- 项目经验 -->
           <h3 style="" id="showProjectExperience" class="tit_blue nobd">项目经验
             <a id="btnEditProjectExperience" data-tip="ProjectExperience" class="editdetail edit_resume" >编辑</a>&nbsp;&nbsp;&nbsp;
              <a   data-tip="SelfEvaluation" class="editdetail dels" >删除</a>
           </h3>
           <div style="" id="ProjectExperience" class="bd_c8e4f1 work_exp grayBg same">
             <div id="viewProjectExperience" class="pt8" style="display: none;" data-tip="pt8ProjectExperience"></div>
               <div id="divEditProjectExperience" style="">
                 <form method="post" id="editProjectExperienceForm" >                   
                   <input type="hidden" name="resumeId" value="-1207654033">
                   <input type="hidden" name="key" value="ProjectExperience">
                   <textarea rows="10" name="paragraphText" id="editProjectExperience" cols="40"></textarea>                   
                   <p class="pt10">
                     <input type="button" value="保存" class="submit_btn_pop" data-tip="pt8ProjectExperience" id="projectExperienceSave">
                     <input type="button" class="cancel_btn_pop cancel_detail" data-tip="ProjectExperience" value="取消">
                   </p>
                 </form>                
               </div>
             </div>
             
             <h3 style="" id="showEdu" class="tit_blue nobd">教育经历
               <a id="eduAddBtn" data-tip="ResumeEducationCancel" class="increase edit_resume" >添加</a>
             </h3>
             <div style="" id="eduCon" class="grayBg bd_c8e4f1 work_exp same">
               <div class="educationExperience" id="educationExperience"></div>
               <div id="eduFormWrap">
                 <form method="post" id="editEducationForm">   
                   <input type="hidden" name="resumeId" value="-1207654033">
                   <input type="hidden" name="id" value="">
                   <input type="hidden" name="eduForValidate">
                   <table width="100%" cellspacing="0" cellpadding="0" border="0">
                     <tbody>
                       <tr>
                         <td width="90" class="c999">
                           <span class="red">*</span>时间：
                         </td>
                         <td>
                           <input type="text" value="" class="mini-datepicker input_txt" name="StartYearMonth" id="startYearMonth" onDrawDate="onDrawDate">&nbsp;至&nbsp;
                           <input type="text" value="" class="mini-datepicker input_txt" name="EndYearMonth" id="endYearMonth" onDrawDate="onDrawDate">&nbsp;
                           <span class="red" id="eduDateError"></span>
                         </td>
                         <td>&nbsp;&nbsp;&nbsp;<span class="red">添加第一份教育经历，保存以后，点击右上角的"加号"图标，添加多条工作经历，工作经历按时间倒序排序，在"加号"图标下方有"编辑"与"删除"按钮 </span></td>
                       </tr>
                       <tr style="height: 40px;">
                         <td class="c999">
                           <span class="red">*</span>学历：
                         </td>
                         <td>
                           <select name="DegreeId" class="selectEvent" id="DegreeId">
                              <option value="">-选择-</option>
                              <option value="014-001">高中及以下</option>
                              <option value="014-002">大专</option>
                              <option value="014-003">本科</option>
                              <option value="014-004">硕士</option>
                              <option value="014-005">MBA</option>
                              <option value="014-006">博士</option>
                           </select>
                           <span class="red" id="DegreeIdError"></span>
                         </td>
                         <tr>
                         <td class="c999">
                                                                                    学习方式：
                         </td>
                           <td>
                           <select name="eduType" class="selectEvent" id="eduType">
                              <option value="">-选择-</option>
                              <option value="1">全日制</option>
                              <option value="2">夜校</option>
                           </select>
                           <span class="red" id="DegreeIdError"></span>
                         </td>
                         
                         </tr>
                       </tr>
                       <tr id="schoolOffset">
                         <td class="c999">
                           <span class="red">*</span>毕业院校：
                         </td>
                         <td>
                           <input type="button" value="选择/修改" id="schoolBtn" title="选择/修改" class="choose_btn"><a style="display:none;" class="fltl rst" id="schoolClear">清除</a>
                           <input type="hidden" id="schoolHid">
                           <div class ="schoolData pData">
                           <div class="schoolTitle pTitle">
                             <span><b>毕业院校</b></span> <span class="schoolResidency close"><b>X</b></span>
                           </div>
                         <div class="schoolContent pContent"></div>
                        </div>
                        <div class="schoolChildData cData">
                            <div class="schoolChildTitle cTitle"><span class="closeResidency close"><b>X</b></span></div>
                            <div class="schoolChildContent cContent"></div>
                        </div>
                         </td>
                       </tr>
                       <tr id="majorOffset">
                         <td>&nbsp; </td>
                         <td>
                           <input type="text" value="" name="SchoolName" maxlength="100" id="SchoolName" class="w150 input_txt" onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\ ]/g,'')" onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\ ]/g,'')" oncontextmenu = "value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\ ]/g,'')"> 
                           <span class="c999">请选择学校，若无合适选项，可在此填写</span>
                         </td>
                       </tr>
                       <tr>
                         <td class="c999">
                           <span class="red">*</span>专业：
                         </td>
                         <td>
                           <input type="button" value="选择/修改" id="majorBtn" title="选择/修改" class="choose_btn"> <a style="display:none;" class="fltl rst" id="majorClear">清除</a>
                           <input type="hidden" value="" id="majorHid">
                           <div class ="majorData pData">
                           <div class="majorTitle pTitle">
                             <span><b>专业</b></span> <span class="closeMajor close"><b>X</b></span>
                           </div>
                           <div class="majorContent pContent"></div>
                         </div>
                         <div class="majorChildData cData">
                           <div class="majorChildTitle cTitle"><span class="closeMajor close"><b>X</b></span></div>
                           <div class="majorChildContent cContent"></div>
                         </div>
                         </td>
                       </tr>
                       <tr>
                         <td>&nbsp; </td>
                         <td>
                           <input type="text" value="" name="MajorName" maxlength="100" id="MajorName" class="w150 ml10 input_txt" onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\ ]/g,'')" onpaste="value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\ ]/g,'')" oncontextmenu = "value=value.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5\ ]/g,'')">
                           <span class="c999">请选择符合或接近的专业，若无合适选项，可在此填写</span>
                         </td>
                       </tr>
                       <tr style="height: 60;">
                         <td></td>
                         <td class="pt8">
                           <input type="button" class="submit_btn" value="保 存" id="editResumeEducationSave">
                           &nbsp;&nbsp;
                           <input type="button" class="cancel_btn cancel_btn_pop" data-tip="ResumeEducationCancel" value="取 消" id="editResumeEducationCancel">
                           &nbsp;
                           <span class="red" id="eduSchoolError"></span>
                           <span class="red" id="eduMajorError"></span>
                         </td>
                       </tr>
                     </tbody>
                   </table>
                 </form>
               </div>
             </div>
             
             <!--培训信息-->
             <h3 style="" id="showTrainingInfo" class="tit_blue nobd">培训信息
               <a id="btnEditTrainingInfo"  data-tip="TrainingInfo" class="editdetail edit_resume" >编辑</a>&nbsp;&nbsp;&nbsp;
                <a   data-tip="SelfEvaluation" class="editdetail dels" >删除</a>
             </h3>
             <div style="" id="TrainingInfo" class="bd_c8e4f1 work_exp grayBg same">
               <div id="viewTrainingInfo" class="pt8" style="display: none;"  data-tip="pt8TrainingInfo"></div>
               <div id="divEditTrainingInfo" style="">
                 <form method="post" id="editTrainingInfoForm">                   
                   <input type="hidden" name="resumeId" value="-1207654033">
                   <input type="hidden" name="key" value="TrainingInfo">
                   <textarea rows="10" name="paragraphText" id="editTrainingInfo" cols="40"></textarea>  
                   <p class="pt10">
                     <input type="button" value="保存" class="submit_btn_pop" data-tip="pt8TrainingInfo" id="trainingInfoSave">
                     <input type="button" class="cancel_btn_pop cancel_detail" data-tip="TrainingInfo" value="取消">
                   </p>
                 </form>               
               </div>
              </div>
                
              <!--语言 -->
              <h3 style="" id="showLang" class="tit_blue nobd">语言
                <a id="btnAddResumeLanguage"   data-tip="ResumeLanguageCancel" class="increase edit_resume" >添加</a>
              </h3>
              <div style="" id="langCon" class="bd_c8e4f1 work_exp grayBg same">
                <div class="languageList" id="languageList"></div>
                <div id="languageFormWrap">
                  <form method="post" id="editLanguageForm">   
                    <input type="hidden" name="resumeId" value="-1207654033">
                    <input type="hidden" name="id" value="">
                    <table width="100%" cellspacing="0" cellpadding="0" border="0">
                      <tbody>
                        <tr>
                          <td width="90" class="c999">
                            <span class="red">* </span>语言：
                          </td>
                          
                          <td>
                            <select name="LanguageId" id="LanguageId"><option value="">-选择-</option><option value="017-001">英语</option><option value="017-002">俄语</option><option value="017-003">德语</option><option value="017-004">法语</option><option value="017-005">西班牙语</option><option value="017-006">意大利语</option><option value="017-007">阿拉伯语</option><option value="017-008">朝鲜语</option><option value="017-009">日语</option><option value="017-010">其他</option></select>
                             <span class="red" id="languageError"></span>
                          </td>
                          <td>&nbsp;&nbsp;&nbsp;<span class="red">添加第一种语言，保存以后，点击右上角的"加号"图标，当语言选择"其他"，可以在"语言描述"予以说明，在"加号"图标下方有"编辑"与"删除"按钮 </span></td>
                        </tr>
                        <tr>
                          <td class="c999">
                            &nbsp;&nbsp;等级：
                          </td>
                          <td>
                            <select name="languageLevelId" id="languageLevelId"><option value="">-选择-</option><option value="013-001">四级</option><option value="013-002">六级</option><option value="013-003">专业四级</option><option value="013-004">专业八级</option></select>
                          </td>
                        </tr>
                        <tr>
                          <td class="c999">&nbsp;&nbsp;口语水平：</td>
                          <td>
                            <select name="OralLevelId" id="OralLevelId"><option value="">-选择-</option><option value="018-001">一般</option><option value="018-002">良好</option><option value="018-003">流利</option><option value="018-004">母语</option></select>
                          </td>
                        </tr>
                        <tr>
                          <td></td>
                          <td class="pt8">
                            <input type="button" id="editResumeLanguageSave" class="submit_btn" value="保存">
                            &nbsp;&nbsp;
                            <input type="button" id="editResumeLanguageCancel" data-tip="ResumeLanguageCancel" class="cancel_btn cancel_btn_pop" value="取消">
                          </td>
                        </tr>
                      </tbody>
                    </table>
                  </form>
                </div>
              </div>
              
              <!--语言描述  -->
              <h3 style="" id="showLanguageSkill" class="tit_blue nobd">语言描述
                <a id="btnEditLanguageSkill"  data-tip="LanguageSkill" class="editdetail edit_resume" >编辑</a>&nbsp;&nbsp;&nbsp;
                 <a   data-tip="SelfEvaluation" class="editdetail dels" >删除</a>
              </h3>
              <div style="" id="LanguageSkill" class="bd_c8e4f1 work_exp grayBg same">
                <div id="viewLanguageSkill" class="pt8" style="display: none;" data-tip="pt8LanguageSkill"></div>
                <div id="divEditLanguageSkill" style="">
                  <form method="post" id="editLanguageSkillForm" >                    
                    <input type="hidden" name="resumeId" value="-1207654033">
                    <input type="hidden" name="key" value="LanguageSkill">
                    <textarea rows="10" name="paragraphText" id="editLanguageSkill" cols="40"></textarea>                    
                    <p class="pt10">
                      <input type="button" value="保存" class="submit_btn_pop" data-tip="pt8LanguageSkill" id="languageSkillSave">
                      <input type="button" class="cancel_btn_pop cancel_detail" data-tip="LanguageSkill" value="取消">
                    </p>
                  </form>               
                </div>
              </div>
              
              <!-- 证书信息 -->
              <h3 style="" id="showRewards" class="tit_blue nobd">奖励信息
                <a id="btnEditRewards"  data-tip="Rewards" class="editdetail edit_resume" style="display: none;">编辑</a>&nbsp;&nbsp;&nbsp;
                 <a   data-tip="SelfEvaluation" class="editdetail dels" >删除</a>            
               </h3>
              <div style="" id="Rewards" class="bd_c8e4f1 work_exp grayBg same">
                <div id="viewRewards" class="pt8" style="display: none;" data-tip="pt8Rewards"> </div>
                <div id="divEditRewards" >
                  <form method="post" id="editRewardsForm" >                   
                    <input type="hidden" name="resumeId" value="-1279075866">
                    <input type="hidden" name="key" value="Reward">
                    <textarea rows="10" name="paragraphText" id="editRewards" cols="40"></textarea>                    
                    <p class="pt10">
                      <input type="button" value="保存" class="submit_btn_pop" data-tip="pt8Rewards" id="rewardsSave">
                      <input type="button" class="cancel_btn_pop cancel_detail" data-tip="Rewards" value="取消">
                    </p>
                  </form>                
                </div>
              </div>
              
              <!-- 技能 -->
              <h3 style="" id="showSkill" class="tit_blue nobd">技能
              <a id="btnAddResumeSkill"  data-tip="ResumeSkillCancel" class="increase edit_resume">添加</a>
              </h3>
              <div style="" id="skillCon" class="bd_c8e4f1 grayBg same">
                <table id="skillData"></table>
                <form method="post" id="editSkillForm" > 
                  <table width="100%" cellspacing="0" cellpadding="0" border="0" id="skillList" class="res tGlobal">
                    <tbody>
                      <tr style="background:#fff;" class="editTr"><td colspan="5">
                        <div class="edit_con" id="skillFormWrap">
                          <input type="hidden" name="resumeId" value="-1207654033">
                          <input type="hidden" name="id" value="">
                          <table width="100%" cellspacing="0" cellpadding="0" border="0">
                            <tbody>
                              <tr>
                                <td width="120" class="c999">
                                  <span class="red">* </span>技能：
                                </td>
                                <td id="skillOffset">
                                
                                  <input type="text" value="" name="skillHid" maxlength="50" id="skillHid" class="fl input_txt w150" >
                                </td>
                                <td>&nbsp;&nbsp;&nbsp;<span class="red">添加第一种技能，保存以后，点击右上角的"加号"图标，在"加号"图标下方有"编辑"与"删除"按钮 </span></td>
                              </tr>
                              <tr>
                                <td class="c999">
                                  <span class="red">* </span>熟练程度：
                                </td>
                                <td>
                                  <select name="LevelId" class="selectEvent" id="skillLevelId">
                                    <option value="">-选择-</option>
                                    <option value="022-001">一般</option>
                                    <option value="022-002">熟练</option>
                                    <option value="022-003">良好</option>
                                    <option value="022-004">精通</option>
                                  </select>
                                  <span id="errorLevelId"></span>
                                </td>
                              </tr>
                              <tr>
                                <td></td>
                                <td class="pt8">
                                  <input type="button" id="editResumeSkillSave" class="submit_btn" value="保存">
                                  &nbsp;&nbsp;
                                  <input type="button" id="editResumeSkillCancel"  data-tip="ResumeSkillCancel" class="cancel_btn cancel_btn_pop" value="取消">
                                </td>
                              </tr>
                            </tbody>
                          </table>
                        </div>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </form>
            </div>
            
            <!--其他技能信息  -->
            <h3 style="" id="showSkillText" class="tit_blue nobd">其他技能信息
              <a id="btnEditSkillText"  data-tip="SkillText" class="editdetail edit_resume" >编辑</a>&nbsp;&nbsp;&nbsp;
               <a   data-tip="SelfEvaluation" class="editdetail dels" >删除</a>
            </h3>
            <div style="" id="SkillText" class="bd_c8e4f1 work_exp grayBg same">
              <div id="viewSkillText" class="pt8" style="display: none;" data-tip="pt8SkillText"></div>
                <div id="divEditSkillText" style="">
                  <form method="post" id="editSkillTextForm" >                    
                    <input type="hidden" name="resumeId" value="-1207654033">
                    <input type="hidden" name="key" value="Skill">
                    <textarea rows="10" name="paragraphText" id="editSkillText" cols="40"></textarea>                    
                    <p class="pt10">
                      <input type="button" value="保存" class="submit_btn_pop"  data-tip="pt8SkillText" id="skillTextSave">
                      <input type="button" class="cancel_btn_pop cancel_detail" data-tip="SkillText" value="取消">
                    </p>
                  </form>                
                </div>
              </div>
              
              <!-- 证书信息 -->
              <h3 style="" id="showCertification" class="tit_blue nobd">证书信息
                <a id="btnEditCertification"  data-tip="Certification" class="editdetail edit_resume" style="display: none;">编辑</a>&nbsp;&nbsp;&nbsp;
                 <a   data-tip="SelfEvaluation" class="editdetail dels" >删除</a>            
              </h3>
              <div style="" id="Certification" class="bd_c8e4f1 work_exp grayBg same">
                <div id="viewCertification" class="pt8" style="display: none;" data-tip="pt8Certification"> </div>
                <div id="divEditCertification" style="">
                  <form method="post" id="editCertificationForm">                    
                    <input type="hidden" name="resumeId" value="-1279075866">
                    <input type="hidden" name="key" value="Certification">
                    <textarea rows="10" name="paragraphText" id="editCertification" cols="40"></textarea>                   
                    <p class="pt10">
                      <input type="button" value="保存" class="submit_btn_pop" data-tip="pt8Certification" id="certificationSave">
                      <input type="button" class="cancel_btn_pop cancel_detail" data-tip="Certification" value="取消">
                    </p>
                  </form>              
                </div>
              </div>
              
              <!--爱好信息  -->
              <h3 style="" id="showHobbies" class="tit_blue nobd">兴趣爱好
                <a id="btnEditHobbies" data-tip="Hobbies" class="editdetail edit_resume" >编辑</a>&nbsp;&nbsp;&nbsp;
                 <a   data-tip="SelfEvaluation" class="editdetail dels" >删除</a>
              </h3>
              <div style="" id="Hobbies" class="bd_c8e4f1 work_exp grayBg same">
                <div id="viewHobbies" class="pt8" style="display: none;" data-tip="pt8Hobbies"></div>
                <div id="divEditHobbies" style="">
                  <form method="post" id="editHobbiesForm" >                    
                    <input type="hidden" name="resumeId" value="-1207654033">
                    <input type="hidden" name="key" value="Hobby">
                    <textarea rows="10" name="paragraphText" id="editHobbies" cols="40"></textarea>                    
                    <p class="pt10">
                      <input type="button" value="保存" class="submit_btn_pop" data-tip="pt8Hobbies" id="hobbiesSave">
                      <input type="button" class="cancel_btn_pop cancel_detail" data-tip="Hobbies" value="取消">
                    </p>
                  </form>               
                </div>
              </div>
              <br><br>
           </div>
           
           <!-- 更多简历信息 -->
           <div class="moreOparte same bd_c8e4f1">
             <h3 class="tit_blue"> 填写更多简历信息</h3>
             <div class=" work_exp ">
               <ul id="moreItems">
                 <li>+<a href="#showSelfEvaluation" id="showSelfEvaluationItem">背景概要</a></li>
                 <li>+<a href="#showCareerObject" id="showCareerObjectItem">求职意向</a></li>
                 <li>+<a href="#showWork" id="showWorkItem">工作经历</a></li>
                 <li>+<a href="#showProjectExperience" id="showProjectExperienceItem">项目经验</a></li>
                 <li>+<a href="#showEdu" id="showEduItem">教育经历</a></li>
                 <li>+<a href="#showTrainingInfo" id="showTrainingInfoItem">培训信息</a></li>
                 <li>+<a href="#showLang" id="showLangItem">语言</a></li>
                 <li>+<a href="#showLanguageSkill" id="showLanguageSkillItem">语言描述</a></li>
                 <li>+<a href="#showRewards" id="showRewardsItem">奖励信息</a></li>
                 <li>+<a href="#showSkill" id="showSkillItem">技能</a></li>
                 <li>+<a href="#showCertification" id="showCertificationItem">证书信息</a></li>
                 <li>+<a href="#showHobbies" id="showHobbiesItem">爱好信息</a></li>
               </ul>
             </div>
           </div>
           <br>
           
           <!-- footer -->
           <div id="footer">
            <p id="footernav">
              <a title="关于我们" href="/Html/aboutus.html">关于我们</a> | 
              <a title="问题反馈" href="/Home/AddNewQuestion">问题反馈</a> | 
              <a title="常见问题" href="/Home/FaqPage">常见问题</a>| 
              <a title="联系我们" href="/Html/contact.html">联系我们</a> | 
              <a title="加入我们" target="_blank" href="http://8aza.hirede.com">加入我们</a>
            </p>
            <p id="copy">Copyright &copy; 2008-2014 8AZA Network Technology Co.,ltd.经营许可证编号：<a href="http://gdca.gov.cn/promise/p201101.asp" target="_blank">粤B2-20110130号</a>  ICP备案：<a href="http://www.miitbeian.gov.cn" target="_blank">粤ICP备10043629号</a></p>
          </div>
           
       </div>
       </div>
       
       <div id="startUploadPicter">
         <input type="file" name="file_upload" id="file_upload" style="display:none" onchange="ajaxFileUpload()">
       </div>
</body>

<link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/public/jquery.validator.css"/>
<link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/addResume.css"/>
    <style type="text/css">
    .dels {
    font-size: 13px;
    font-weight: normal;
    line-height: 17px;
    position: relative;
    right: 30px;
    top: 9px;
    float: right;
}
    </style>
<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.js"></script>
<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.zh_cn.js"></script>
<script type="text/javascript" src="${webRoot}/resources/js/resume/ajaxfileupload.js"></script>
<script type="text/javascript" src="${webRoot}/resources/js/public/areaData.js"></script>
<script type="text/javascript" src="${webRoot}/resources/js/public/industryAutoComplete.js"></script>
<script type="text/javascript" src="${webRoot}/resources/js/resume/addResumeData.js"></script>
<script type="text/javascript" src="${webRoot}/resources/js/resume/skillData.js"></script>
<script type="text/javascript" src="${webRoot}/resources/js/public/schoolData.js"></script>
<script type="text/javascript" src="${webRoot}/resources/js/public/professionalCategory.js"></script>
<script type="text/javascript" src="${webRoot}/resources/js/resume/addResume.js"></script>
</html>