<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<c:set var="webRoot" value="<%=basePath%>" />
<style type="text/css">
  
.resume-transmit-tab1 tr{
	height: 30px;
}
.resume-transmit-tab1 td{
	font-size: 13px;
}
.resume-transmit-tab1 option{
	font-size:13px;
}
.c999{
	color: gray;
	font-size: 13px;
}
#candidateName1,.resume-transmit-tab1 a{
	color:blue;
}
.resume-add-candidate-tab1 tr{
	height: 30px;
}

.resume-add-candidate-tab1 td{
	font-size: 13px;
}

</style>
 <!-- 发送简历 -->
  	<div id="resume-transmit-win" class="mini-window" style="width: 660px;height: auto;display:none;" title="发送简历(邮件方式发送)" showFooter="true">
	  	<div class="resume-transmit-div1" >
	      <table class="resume-transmit-tab1">
	        <tbody class="tbody1">
	          <tr>
	          	<td width="20%" class="c999">&nbsp;候选人：</td>
              <td width="" id="candidateName1"></td>
	          </tr>
	          <tr>
	          	<td class="c999">&nbsp;相关资料：</td>
	          	<td><input type="radio"  checked="checked" name="sendResumeType" value="2">简历原文</td>
	          </tr>
	          <tr>
	          	<td></td>
	            <td><input type="radio"  name="sendResumeType" value="2">标准简历</td>
	          </tr>
	          <tr>
	          	<td></td>
	            <td><input type="checkbox" id="chbAddInterviewAssessment">面试评估</td>
	          </tr>
	          <tr>
	            <td></td>
	          	<td>
                <input type="checkbox" checked="checked" value="0" name="radRemarkType"> 操作记录
              </td>
	          </tr>
	          <tr>
	          	<td class="c999"><span class="red">*</span>收件人：</td>
              <td>
                <input type="text" class="c999" value='多个邮箱请用";"号隔开' maxlength="500" style="width: 312px; background-position: 0px -244px; border: 1px solid rgb(205, 205, 205); height: 22px; line-height: 22px; padding: 0px 2px; background-repeat: repeat-x;" name="txtSrEmail" id="txtSrEmail">
                <span class="red" id="txtSrEmailError"></span>
              </td>
	          </tr>
	          <tr>
	          	<td class="c999 left "><span class="red">*</span>邮件模版：</td>
              <td>
                <select name="sendResumeTemp" id="sendResumeTemp">
                	<option value="">请选择模版</option>
                    <c:forEach var="page" items="${sendResumeTempList}" varStatus="index">
                    	<c:if test="${page.type != 4}">
                    		<option value="${page.id}">${page.title}</option>
                    	</c:if>
                    </c:forEach>
                </select>
                <c:if test="${not empty u_template_previewTemplateById}">
                 <a id="btnViewMailTemplateOfficer" onclick="queryTemplate()">预览</a>
                </c:if>
                <c:if test="${not empty u_template_mailTemplateManage }">
                  <a id="manage" target="_blank" href="/recruit/template/templateManage">管理</a>
                </c:if> 
              </td>
	          </tr>
	          <tr>
	          	<td valign="top" class="c999">&nbsp;邮件附言：</td>
              <td>
                <textarea id="txtComment" cols="50" rows="3" style="whidth:400px;height:50px;">附言内容字数不能超过2000字</textarea><span class="red" id="txtCommentError"></span>
              </td>
	          </tr>
	          <tr>
	            <td></td>
	          	<td>
                <input type="checkbox" id="chbAddCommentToRemark"/>将附言加入到操作记录中
              </td>
	          </tr>
	          <tr>
	          	<td></td>
	          	<td>
                <input type="checkbox" value="true" id="chbSplitSend">多份简历分开发送
              </td>
	          </tr>
	        </tbody>
	      </table>
	    </div>
	    <div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;">
	      <input type="button" value="确定" onclick="transmitResume('resume-transmit-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	      <input type="button" value="取消" onclick="hideWindow('resume-transmit-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	    </div>
		</div>
  <%--  <link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/positionSet.css"/> --%>
   <script type="text/javascript" src="${webRoot}/resources/js/templateManage/sendResume.js"></script>
     