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
    <link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/flow/interview/interviewBookEdit.css"/>
    <script charset="utf-8" src="${webRoot}/resources/plugins/kindeditor-4.1.10/kindeditor-all.js"></script>
    <title>编辑面试</title>
  </head>
  <body onload="removeLoad();">
    <jsp:include page="/webpage/header.jsp"></jsp:include>
    <div class="co">
      <div class="co-right">
        <div class="position-path co-right-center">
          <span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">易聘</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">招聘流程</span><em class="path-icon">&gt;&gt;</em><span class="path-leaf">编辑面试</span>
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
                       <input id="id" type="hidden" name="id" value="${interviewBook.id}" />
                        <input id="positionId" type="hidden" name="positionId" value="${interviewBook.positionId}" />
                        <input id="interviewee" type="hidden" name="interviewee" value="${interviewBook.interviewee}" />
                        <input id="candidateName" type="hidden" name="candidateName" value="${interviewBook.candidateName}" />
                        <span id="cname" class="jobEdit-font-size">${interviewBook.candidateName}</span>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr">
                      <td>
                        <font class="marker-color">*</font> 
                        <font class="font-title">面试官：</font>
                      </td>
                      <td>
                          <input id="interviewers" type="hidden" name="interviewers" value="${interviewBook.interviewers }" />
                          <input id="addInterviewers0" text="${addInterviewers0}" value="${interviewBook.interviewers }" class="mini-buttonedit" onbuttonclick="onButtonEdit"/>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr">
                   
                      <td> <font class="marker-color">*</font> <font class="font-title">面试时间：</font></td>
                      <td>
                      <input id="interviewBTime" type="hidden" name="interviewBTime" value="${interviewBook.interviewBTime }" />
                      <input id="interviewETime" type="hidden" name="interviewETime" value="${interviewBook.interviewETime }" />
                      <input id="interviewDateStr" type="hidden" name="interviewDateStr" value="${interviewBook.interviewDate }" />
                   <input type="text" name="interviewDateStr0" value="${interviewBook.interviewDate }" id="interviewDateStr0" format="yyyy-MM-dd" class="jobEdit-text mini-datepicker"></input>
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
                        <input id="interviewAddress" type="hidden" name="interviewAddress" value="${interviewBook.interviewAddress }" />
                        <input type="text" name="interviewAddress0" id="interviewAddress0" value="${interviewBook.interviewAddress }" class="jobEdit-text radius1"></input>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr">
                      <td>
                        <font class="marker-color">*</font> 
                        <font class="font-title">面试联系人：</font>
                      </td>
                      <td>
                        <input id="linkman" type="hidden" name="linkman" value="${interviewBook.linkman }" />
                        <input id="addLinkman" class="mini-buttonedit" value="${interviewBook.linkman }" text="${linkmanName}" onbuttonclick="onLinkmanButtonEdit"/>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr">
                      <td>
                        <font class="marker-color">*</font> 
                        <font class="font-title">联系电话：</font>
                      </td>
                      <td>
                        <input type="text" name="tel" id="tel" value="${interviewBook.tel }" class="mini-textbox" vtype="rangeChar:11,11"></input>
                      </td>
                    </tr>
                    
                    <tr class="jobEdit-tr" id="waitAddressTr">
                      <td>
                        <font class="marker-color">*</font> 
                        <font class="font-title">面试等待地点：</font>
                      </td>
                      <td>
                       <input type="text" name="waitAddress" id="waitAddress" value="${interviewBook.waitAddress }" class="jobEdit-text radius1"></input>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr">
                      <td>
                         <font class="marker-color">*</font> 
                        <font class="font-title">通知候选人：</font>
                      </td>
                      <td>
                      <input id="isMessage" type="hidden" name="isMessage" value="${interviewBook.isMessage }" />
                       <input id="isMessageCheckbox" type="checkbox" name="isMessageCheckbox" value=""><label>发送短信（候选人可通过短信直接查看和响应面试）&nbsp;&nbsp;<a>预览</a></label>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr">
                      <td>
                        <font class="font-title"></font>
                      </td>
                      <td>
                        <input id="isEmail" type="hidden" name="isEmail" value="${interviewBook.isEmail }" />
                        <input id="isEmailCheckbox" type="checkbox" name="isEmailCheckbox" value="1"><label>发送邮件（候选人可通过邮件直接查看和响应面试）&nbsp;&nbsp;<a>预览</a></label>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr" id="email_model_tr">
                      <td>
                        <font class="font-title">邮件模板：</font>
                      </td>
                      <td>
                       <input id="modelId" type="hidden" name="modelId" value="${interviewBook.modelId }" />
                        <input id="addEmailModel" class="mini-buttonedit" text="${modelName}" onbuttonclick="onEmailModelButtonEdit"/>
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
                       <input id="emailContent" type="hidden" name="emailContent" value="${interviewBook.emailContent }" />
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
                       <div id="fileArea" class="fileArea">
                       <span id="span1">
                            <c:forEach items="${attachmentList}" var="item">
                              <div id="div_${item.id}" class="fileStyle">
                                <input id="${item.id}" type="button" onclick="delAttach('${item.id}')" value="删除" />
                                &nbsp;&nbsp;
                                <a href="javascript:downloadAttach('${item.id}')"><span>${item.showName }</span></a>
                              </div>
                           </c:forEach>
                       </span><span id="span2"></span></div>
                     </td>
                    <tr class="jobEdit-tr">
                      <td>
                        <font class="font-title">再次通知候选人：</font>
                      </td>
                      <td>
                        <input id="secondENotice" type="hidden" name="secondENotice" value="${interviewBook.secondENotice }" />
                        <input id="secondENoticeCheckbox" type="checkbox" name="secondENoticeCheckbox" value="">
                         <input type="text" name="secondETimeStr" id="secondETimeStr" value="${secondETimeStr }"  text="${secondETimeStr }" showTime="true" format="yyyy-MM-dd H:mm" class="jobEdit-text mini-datepicker"></input>
                        </td>
                    </tr>
                    <tr class="jobEdit-tr">
                      <td style="width:17%;">
                        <font class="font-title">再次提醒面试官:</font>
                      </td>
                      <td>
                        <input id="secondRNotice" type="hidden" name="secondRNotice" value="${interviewBook.secondRNotice }" />
                        <input id="secondRNoticeCheckbox" type="checkbox" name="secondRNoticeCheckbox" value="">
                        <input type="text" name="secondRTimeStr" id="secondRTimeStr" value="${secondRTimeStr }"  text="${secondRTimeStr }" showTime="true" format="yyyy-MM-dd H:mm" class="jobEdit-text mini-datepicker"></input>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr" id="isLinkTr">
                      <td>
                        <font class="font-title">发送应聘申请表链接:</font>
                      </td>
                      <td>
                        <input id="isLink" type="hidden" name="isLink" value="${interviewBook.isLink }" />
                        <input id="isLinkCheckbox" type="checkbox" name="isLinkCheckbox" value="">
                      
                      </td>
                    </tr>
                      <tr class="jobEdit-tr">
                      <td>
                      </td>
                      <td>
                      <input id="saveType" type="hidden" name="saveType" value="" />
                        <a id="button1" class="mini-button" onclick="subMit('save')">保存</a>
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
  <script type="text/javascript" src="${webRoot}/resources/js/flow/interview/interviewBookEdit.js"></script>
   <script type="text/javascript">
      mini.parse();
      var jsWebRoot = "${webRoot}";
      $("#start_hours0").val("${bHours}");
      $("#start_mins0").val("${bMins}");
      $("#end_hours0").val("${eHours}");
      $("#end_mins0").val("${eMins}");
      
      if("${interviewBook.interviewType}" == 1){
        $("input[name='interviewType']").get(0).checked=true; 
      }
      if("${interviewBook.interviewType}" == 2){
        $("input[name='interviewType']").get(1).checked=true; 
        $("#waitAddressTr").hide();
        $("#interviewAddressTr").hide();
      } 
      
      if("${interviewBook.isMessage}" == 1){
        $("#isMessageCheckbox").prop('checked',true);
      }
      if("${interviewBook.isEmail }" == 1){
        $("#isEmailCheckbox").prop('checked',true);
        $("#email_model_tr").show();
        $("#emailContent_tr").show();
        $("#uploadFileTr").show();
        $("#attchmentList").show();
        $("#isLinkTr").show();
      }else{
        $("#email_model_tr").hide();
        $("#emailContent_tr").hide();
        $("#uploadFileTr").hide();
        $("#attchmentList").hide();
        $("#isLinkTr").hide();
      }
      
      if("${interviewBook.secondENotice }" == 1){
        $("#secondENoticeCheckbox").prop('checked',true);
        $("#secondETimeStr").show();
      }else{
        $("#secondETimeStr").hide();
      }
      
      if("${interviewBook.secondRNotice }" == 1){
        $("#secondRNoticeCheckbox").prop('checked',true);
        $("#secondRTimeStr").show();
      }else{
        $("#secondRTimeStr").hide();
      }
      
      if("${interviewBook.isLink }" == 1){
        $("#isLinkCheckbox").prop('checked',true);
      }
      
      
    </script>
<html>