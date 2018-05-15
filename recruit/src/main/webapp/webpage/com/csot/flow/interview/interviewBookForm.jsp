<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<style>
.fileArea{
  width: 99%;
  height: 48px;
  overflow-y :auto;
}
.fileStyle{
  float: left;
  margin-top:7px;
  margin-left: 10px;
}
</style>
<html>
  <head>
    <%@include file="/webpage/common.jsp"%>
    <link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/public/jquery.validator.css"/>
    <link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/flow/interview/interviewBookForm.css"/>
    <script charset="utf-8" src="${webRoot}/resources/plugins/kindeditor-4.1.10/kindeditor-all.js"></script>
    <title>安排面试</title>
  </head>
  <body onload="removeLoad();">
    <jsp:include page="/webpage/header.jsp"></jsp:include>
    <div class="co">
      <div class="co-right">
        <div class="position-path co-right-center">
          <span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">易聘</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">招聘流程</span><em class="path-icon">&gt;&gt;</em><span class="path-leaf">安排面试</span>
        </div>
        <div class="co-right-main co-right-center">
          <div class="con-title">安排面试</div>
          <div class="main">
            <form id="editform" class="jobEdit-form">
              <div class="jobEdit-basic-infor blue radius">
                <table class="jobEdit-tab">
                  <tbody>
                    <tr class="jobEdit-tr">
                      <td class="jobEdit-td">
                        <font class="marker-color">*</font>
                        <font class="font-title">面试类型：</font>
                      </td>
                      <td>
                      <input id="id" type="hidden" name="id" value="" />
                        <input type="radio" name="interviewType" class="privacy" value="1" checked="checked"><label>现场面试</label>
                        <input type="radio" name="interviewType" class="privacy" value="2"><label>电话/视频面试</label>
                      </td>
                      </tr>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr">
                      <td>
                        <font class="font-title">候选人名字：</font>
                      </td>
                      <td>
                        <input id="positionId" type="hidden" name="positionId" value="${positionId}" />
                        <input id="interviewee" type="hidden" name="interviewee" value="${candidate.candidateId}" />
                        <input id="candidateName" type="hidden" name="candidateName" value="${candidate.name}" />
                        <span id="cname" class="jobEdit-font-size">${candidate.name}</span>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr">
                      <td>
                        <font class="marker-color">*</font> 
                        <font class="font-title">面试官：</font>
                      </td>
                      <td>
                          <input id="interviewers" type="hidden" name="interviewers" value="" />
                          <input id="addInterviewers0" class="mini-buttonedit" onbuttonclick="onButtonEdit"/>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr">
                   
                      <td> <font class="marker-color">*</font> <font class="font-title">面试时间：</font></td>
                      <td>
                      <input id="interviewBTime" type="hidden" name="interviewBTime" value="" />
                      <input id="interviewETime" type="hidden" name="interviewETime" value="" />
                      <input id="interviewDateStr" type="hidden" name="interviewDateStr" value="" />
                   <input type="text" name="interviewDateStr0" id="interviewDateStr0" format="yyyy-MM-dd" class="jobEdit-text mini-datepicker" ondrawdate="onDrawDate"></input>
                        <select id="start_hours0">
                          <option value="08">08</option>
                          <option value="09">09</option>
                          <option value="10">10</option>
                          <option value="11">11</option>
                          <option value="12">12</option>
                          <option value="13">13</option>
                          <option value="14">14</option>
                          <option value="15">15</option>
                          <option value="16">16</option>
                          <option value="17">17</option>
                          <option value="18">18</option>
                          <option value="19">19</option>
                        </select>
                                                                                     时
                         <select id="start_mins0">
                          <option value="00">00</option>
                          <option value="30">30</option>
                        </select>
                                                                          分至
                         <select id="end_hours0">
                          <option value="08">08</option>
                          <option value="09">09</option>
                          <option value="10">10</option>
                          <option value="11">11</option>
                          <option value="12">12</option>
                          <option value="13">13</option>
                          <option value="14">14</option>
                          <option value="15">15</option>
                          <option value="16">16</option>
                          <option value="17">17</option>
                          <option value="18">18</option>
                          <option value="19">19</option>
                        </select> 
                                                                                  时
                         <select id="end_mins0">
                          <option value="00">00</option>
                          <option value="30">30</option>
                        </select> 
                                                                                 分                                                
                      </td>
                    </tr>
                    <tr class="jobEdit-tr" id="interviewAddressTr">
                      <td>
                        <font class="marker-color">*</font>
                        <font class="font-title">面试地点：</font></td>
                      <td>
                        <input id="interviewAddress" type="hidden" name="interviewAddress" value="" />
                        <input type="text" name="interviewAddress0" id="interviewAddress0" class="jobEdit-text radius1"></input>
                                                                                添加多轮面试：<a onclick="addMuniInterviewBook();"><img alt="" src="${webRoot}/resources/images/bigplus.jpg"></a>
                                                                                 减少多轮面试：<a onclick="removeMuniInterviewBook();"><img alt="" src="${webRoot}/resources/images/x.jpg"></a>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr">
                      <td>
                        <font class="marker-color">*</font> 
                        <font class="font-title">面试联系人：</font>
                      </td>
                      <td>
                        <input id="linkman" type="hidden" name="linkman" value="" />
                        <input id="addLinkman" class="mini-buttonedit" onbuttonclick="onLinkmanButtonEdit"/>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr">
                      <td>
                        <font class="marker-color">*</font> 
                        <font class="font-title">联系电话：</font>
                      </td>
                      <td>
                        <input type="text" name="tel" id="tel" class="mini-textbox" vtype="rangeChar:10,11"></input>
                      </td>
                    </tr>
                    
                    <tr class="jobEdit-tr" id="waitAddressTr">
                      <td>
                        <font class="marker-color">*</font> 
                        <font class="font-title">面试等待地点：</font>
                      </td>
                      <td>
                       <input type="text" name="waitAddress" id="waitAddress" class="jobEdit-text radius1"></input>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr">
                      <td>
                         <font class="marker-color">*</font> 
                        <font class="font-title">通知候选人：</font>
                      </td>
                      <td>
                      <input id="isMessage" type="hidden" name="isMessage" value="" />
                       <input id="isMessageCheckbox" type="checkbox" name="isMessageCheckbox" value=""><label>发送短信（候选人可通过短信直接查看和响应面试）&nbsp;&nbsp;<a>预览</a></label>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr">
                      <td>
                        <font class="font-title"></font>
                      </td>
                      <td>
                        <input id="isEmail" type="hidden" name="isEmail" value="" />
                        <input id="isEmailCheckbox" type="checkbox" name="isEmailCheckbox" value="1"><label>发送邮件（候选人可通过邮件直接查看和响应面试）&nbsp;&nbsp;<a>预览</a></label>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr" id="email_model_tr">
                      <td>
                        <font class="font-title">邮件模板：</font>
                      </td>
                      <td>
                       <input id="modelId" type="hidden" name="modelId" value="" />
                        <input id="addEmailModel" class="mini-buttonedit" onbuttonclick="onEmailModelButtonEdit"/>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr" id="emailContent_tr">
                      <td>
                        <font class="font-title">邮件内容：</font>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                        <font class="marker-color">备注：邮件内容发送给候选人，发送给面试官邮件有固定模板</font> 
                      </td>
                      <td>
                      <input id="context" type="hidden" name="context" value="" />
                       <input id="emailContent" type="hidden" name="emailContent" value="" />
                       <textarea id="content" name="content" vtype="maxLength:4000"
              maxLengthErrorText="模板内容不能超过4000个字符"></textarea>
                      </td>
                    </tr>
                    <tr id="uploadFileTr" class="jobEdit-tr">
                      <td>上传附件：</td>
                      <td colspan="3">
                        <div>
                          <input type="file" name="attachment" id="attachment" /> &nbsp;&nbsp; <a
                            class="mini-button" onclick="onUpload">上传</a>
                        </div>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr" id="attchmentList">
                     <td><font class="font-title">附件列表：</font></td>
                     <td>
                       <input id="attchmentIds" type="hidden" name="attchmentIds" value="" />
                       <div id="fileArea" class="fileArea"><span id="span1"></span><span id="span2"></span></div>
                     </td>
                    <tr class="jobEdit-tr">
                      <td>
                        <font class="font-title">再次通知候选人：</font>
                      </td>
                      <td>
                        <input id="secondENotice" type="hidden" name="secondENotice" value="" />
                        <input id="secondENoticeCheckbox" type="checkbox" name="secondENoticeCheckbox" value="">
                         <input type="text" name="secondETimeStr" id="secondETimeStr" showTime="true" format="yyyy-MM-dd H:mm" class="jobEdit-text mini-datepicker" ondrawdate="onDrawDate"></input>
                        </td>
                    </tr>
                    <tr class="jobEdit-tr">
                      <td style="width:17%;">
                        <font class="font-title">再次提醒面试官:</font>
                      </td>
                      <td>
                        <input id="secondRNotice" type="hidden" name="secondRNotice" value="" />
                        <input id="secondRNoticeCheckbox" type="checkbox" name="secondRNoticeCheckbox" value="">
                        <input type="text" name="secondRTimeStr" id="secondRTimeStr" showTime="true" format="yyyy-MM-dd H:mm:ss" class="jobEdit-text mini-datepicker" ondrawdate="onDrawDate"></input>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr" id="isLinkTr">
                      <td>
                        <font class="font-title">发送应聘申请表链接:</font>
                      </td>
                      <td>
                        <input id="isLink" type="hidden" name="isLink" value="" />
                        <input id="isLinkCheckbox" type="checkbox" name="isLinkCheckbox" value="">
                      
                      </td>
                    </tr>
                      <tr class="jobEdit-tr">
                      <td>
                      </td>
                      <td>
                      <input id="saveType" type="hidden" name="saveType" value="" />
                        <a id="button1" class="mini-button" onclick="subMit('save')">提交</a>
                        <a id="button1" class="mini-button" onclick="draftSave('draft')">草稿保存</a>
                      </td>
                    </tr>
                    
                  </tbody>
                </table>
              </div>
            </form>
          </div>
        </div>
      </div> 
    <jsp:include page="/webpage/footer.jsp"></jsp:include>
  </body>
  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.zh_cn.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/resume/ajaxfileupload.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaAutoCompleteData.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaData.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/flow/interview/interviewBookForm.js"></script>
   <script type="text/javascript">
      mini.parse();
      var jsWebRoot = "${webRoot}";
    </script>
<html>
