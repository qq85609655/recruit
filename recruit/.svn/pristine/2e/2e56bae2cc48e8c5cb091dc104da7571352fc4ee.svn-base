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
    <link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/candidate/candidateRecommendForm.css"/>
    <script charset="utf-8" src="${webRoot}/resources/plugins/kindeditor-4.1.10/kindeditor-all.js"></script>
    <title>推荐候选人</title>
  </head>
  <body onload="removeLoad();">
      <div class="co-right">
        <div class="co-right-main co-right-center">
          <div class="con-title">推荐候选人</div>
          <div class="main">
            <form id="editform" class="jobEdit-form">
              <div class="jobEdit-basic-infor blue radius">
                <table class="jobEdit-tab">
                  <tbody>
                    <tr class="jobEdit-tr">
                      <td>
                        <font class="marker-color">*</font><font class="font-title">推荐给面试官：</font>
                      </td>
                      <td>
                       <input id="candidateId" type="hidden" name="candidateId" value="${candidateId }" />
                         <input id="candidatePostId" type="hidden" name="candidatePostId" value="${candidatePostId }" />
                         <input id="interviewer" type="hidden" name="interviewer" value="" />
                         <input id="addInterviewers0" class="mini-buttonedit" onbuttonclick="onButtonEdit"/>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr"></tr>
                      <tr class="jobEdit-tr">
                      <td colspan="2">
                        <font class="marker-color">*</font><font class="font-title">选择简历为面试简历（说明：此简历会应用于入职存档）</font>
                      </td>
                    </tr>
                 <%--    <tr class="jobEdit-tr">
                    
                    
                       <c:choose>
                       <c:when test="${status.index%2==0 }">
                            <td>
                              <input type="radio" name="resume" class="privacy" value="${item.id}"><label>简历${status.index + 1}(更新${item.storageDate})</label>
                       </c:when>
                       <c:otherwise>
                             <input type="radio" name="resume" class="privacy" value="${item.id}"><label>简历${status.index + 1}(更新${item.storageDate})</label>
                              </td>
                       </c:otherwise>
                       </c:choose>
                     
                    </tr> --%>
                    <c:forEach items="${list}" var="item" varStatus="status">
                      <tr class="jobEdit-tr">
                      <td>
                         <input type="radio" name="resumeId" class="privacy" value="${item.id}"><label>简历${status.index + 1}(更新${item.storageDate})</label>
                      </td>
                    </tr>
                    </c:forEach>
                        <tr class="jobEdit-tr"></tr>
                      <tr class="jobEdit-tr">
                      <td>
                        <font class="font-title">提醒面试官：</font>
                      </td>
                      <td>
                      <input id="isEmail" type="hidden" name="isEmail" value="" />
                       <input id="isEmailCheckbox" type="checkbox" name="isEmailCheckbox" value=""><label>发送邮件</label>
                       </td>
                    </tr>
                     <tr class="jobEdit-tr" id="emailContent_tr">
                      <td>
                        <font class="font-title">添加评论：</font>
                      </td>
                      <td>
                       <textarea rows="3" cols="40" name="comments" id="comments"></textarea>
                      </td>
                    </tr>
                    <tr class="jobEdit-tr"></tr>
                      <tr class="jobEdit-tr">
                      <td>
                      </td>
                      <td>
                        <a id="button1" class="mini-button" onclick="subMit()">推荐</a>
                      </td>
                    </tr>
                    
                  </tbody>
                </table>
              </div>
            </form>
          </div>
        </div>
      </div> 
  </body>
  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.zh_cn.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/resume/ajaxfileupload.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaAutoCompleteData.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaData.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/candidate/candidateRecommendForm.js"></script>
   <script type="text/javascript">
      mini.parse();
      var jsWebRoot = "${webRoot}";
    </script>
<html>
