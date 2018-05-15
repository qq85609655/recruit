<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<c:set var="webRoot" value="<%=basePath%>" />
<html>
  <body>
    <!-- 职位保密设置 -->
    <div id="position-security-win" class="mini-window"
	     style="width: 450px;height: 202px; display: none;"
	     borderStyle="border:5px solid #CCCCCC;"  headerStyle="background:
	     #E0EDFE;border-bottom:0px;height:30px;font-size:14px;" title="<b>保密设置<b>" 
	     bodyStyle="background-color: #F5F5F5;" showFooter="true">
	  <div class="position-security-div1" >
	      <table class="position-security-tab1">
	        <tbody class="tbody1">
	          <tr>
	          	<td width="40%">
                  <span><input name="secrecy" checked="checked" value="010-000" type="radio">&nbsp;公开</span>
                </td>
	          </tr>
	          <tr>
	          	<td>
                  <span><input name="secrecy" value="010-001" type="radio">&nbsp;对内公开</span>
                </td>
                <td><span>（不显示在招聘门户）</span>
                </td>
	          </tr>
	          <tr>
	            <td>
                  <span><input name="secrecy" value="010-002" type="radio">&nbsp;保密</span>
                </td>
                <td>
                   <span id="iconProjPeopleIntro" class="c999">（仅流程参与人员可见） <span class="messageTagPop"></span> </span>
                   <div id="projPeopleIntro" class="moreTags" style="display: none;">
                      <!-- <img src="http://s.hireye.com/images/tip_arrow.png" class="tipArrow" style="left: 80px;"> -->
                      <p>什么是流程参与人？</p>
                      <p>职位招聘专员；</p>
                      <p>职位的其他招聘专员；</p>
                      <p>特定流程中的参与人，如在被推荐阶段的Review Hiring Manager。</p>
               		</div>
                </td>
	          </tr>
	        </tbody>
	      </table>
	    </div>
	    <div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;">
	      <input type="button" value="确定" onclick="updateSetSecurity('position-security-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	      <input type="button" value="取消" onclick="hideWindow('position-security-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	    </div>
	</div>
	<!-- 职位重新发布 -->
    <div id="position-againRelease-win" class="mini-window"
	     style="width: 300px;height: 136px; display: none;"
	     borderStyle="border:5px solid #CCCCCC;"  headerStyle="background:
	     #E0EDFE;border-bottom:0px;height:30px;" title="<b>请选择职位有效期<b>" 
	     bodyStyle="background-color: #F5F5F5;" showFooter="true">
	  	<div class="position-requirement-div1" >
			<p>
          		有效期：<t:dictSelect type="select" id="validity" field="validaty" typeGroupCode="validity" defaultVal="2" hasLabel="false"></t:dictSelect>
         	</p>
	    </div>
	    <div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;">
	      <input type="button" value="确定" onclick="againRelease('position-againRelease-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	      <input type="button" value="取消" onclick="hideWindow('position-againRelease-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	    </div>
	</div>
    <!-- 职位启用设置 -->
    <div id="position-enable-win" class="mini-window"
	     style="width: 350px;height: 136px; display: none;"
	     borderStyle="border:5px solid #CCCCCC;"  headerStyle="background:
	     #E0EDFE;border-bottom:0px;height:30px;font-size:14px;" title="<b>启用职位<b>" 
	     bodyStyle="background-color: #F5F5F5;" showFooter="true">
	  	<div class="position-enable-div1" >
			<p>
          	  <span>职位生效日期：</span>
          	  <input class="mini-datepicker" id="effectiveDate" name="effectiveDate">
         	</p>
	    </div>
	    <div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;">
	      <input type="button" value="确定" onclick="enablePosition('position-enable-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	      <input type="button" value="取消" onclick="hideWindow('position-enable-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	    </div>
	</div>
	<!-- 职位招聘完成设置 -->
    <div id="position-complete-win" class="mini-window"
	     style="width: auto;height:auto;left: 557px;top:106px; z-index:1983; display: none;"
	     borderStyle="border:5px solid #CCCCCC;"  headerStyle="background:
	     #E0EDFE;border-bottom:0px;height:30px;" 
	     bodyStyle="background-color: #F5F5F5;" showFooter="true">
   	  <div class="position-complete-div1" >
	      <table class="position-complete-tab1">
	        <tbody class="tbody1">
	          <tr>
	          	<td style="width: auto; height: auto;" class="ui_main">
	          		<div style="padding: 20px 30px 20px 0px;" class="ui_content"><span>确认该职位已招聘完成吗？</span></div>
                </td>
	          </tr>
	        </tbody>
	      </table>
	    </div>
	    <div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;">
	      <input type="button" value="确定" onclick="updatePositionStatus('position-complete-win',1)" style="vertical-align:middle;width: 62px;height: 23px;">
	      <input type="button" value="取消" onclick="hideWindow('position-complete-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	    </div>
	</div>
	<!-- 职位招聘暂停设置 -->
    <div id="position-pause-win" class="mini-window"
	     style="width: auto;height:auto;left: 557px;top:106px; z-index:1983; display: none;"
	     borderStyle="border:5px solid #CCCCCC;"  headerStyle="background:
	     #E0EDFE;border-bottom:0px;height:30px;" 
	     bodyStyle="background-color: #F5F5F5;" showFooter="true">
   	  <div class="position-pause-div1" >
	      <table class="position-pause-tab1">
	        <tbody class="tbody1">
	          <tr>
	          	<td style="width: auto; height: auto;" class="ui_main">
	          		<div style="padding: 20px 30px 20px 0px;" class="ui_content"><span>确认要暂停招聘该职位吗？</span></div>
                </td>
	          </tr>
	        </tbody>
	      </table>
	    </div>
	    <div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;">
	      <input type="button" value="确定" onclick="updatePositionStatus('position-pause-win',5)" style="vertical-align:middle;width: 62px;height: 23px;">
	      <input type="button" value="取消" onclick="hideWindow('position-pause-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	    </div>
	</div>
	<!-- 职位招聘删除设置 -->
    <div id="position-del-win" class="mini-window"
	     style="width: auto;height:auto;left: 557px;top:106px; z-index:1983; display: none;"
	     borderStyle="border:5px solid #CCCCCC;"  headerStyle="background:
	     #E0EDFE;border-bottom:0px;height:30px;" 
	     bodyStyle="background-color: #F5F5F5;" showFooter="true">
   	  <div class="position-del-div1" >
	      <table class="position-del-tab1">
	        <tbody class="tbody1">
	          <tr>
	          	<td style="width: auto; height: auto;" class="ui_main">
	          		<div style="padding: 20px 30px 20px 0px;font-size: 13px;" class="ui_content"><span>确定删除后，所有与此职位相关的操作记录均会被删除。是否确认删除？</span></div>
                </td>
	          </tr>
	        </tbody>
	      </table>
	    </div>
	    <div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;">
	      <input type="button" value="确定" onclick="delPosition('position-del-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	      <input type="button" value="取消" onclick="hideWindow('position-del-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	    </div>
	</div>
	<!-- 职位添加标记设置 -->
    <div id="position-addlabels-win" class="mini-window"
	     style="width: 510;height:auto;left: 513px;top:106px; z-index:1983; display: none;"
	     borderStyle="border:5px solid #CCCCCC;"  headerStyle="background:
	     #E0EDFE;border-bottom:0px;height:30px;" title="<b>添加标记<b>"
	     bodyStyle="background-color: #F5F5F5;" showFooter="true">
        <div class="position-add-label">
          <div class="label-upper">
            <span style="font-size:13px;"> 新增标记：</span><input maxlength="20" id="txtTag" type="text">&nbsp;&nbsp;<input value="添加" id="btnAddTagConfirm" class="btn2" type="button"><span class="tipMessage" style="color:red">请添加标记</span>
          </div>
          <div id="addedWrap">
            <span id="addedTitle">已增加的标记：</span>
            <span id="addedTags">
              
            </span>
          </div>
          <div id="hotTags" style="min-height: 62px;">
              <h3 class="tagTitle">热门标记</h3>
              <div id="inner-hotTags"></div>
              <p><span class="hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">aa</span> &nbsp;&nbsp;<span class="hotLabel"><img alt="" src="${webRoot}/resources/images/plus.jpg">bb</span></p>
          </div>
        </div>
        <div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;">
	      <input type="button" id ="confirmLabel"value="确定" onclick="submitLabelValue('position-addlabels-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	      <input type="button" value="取消" onclick="closeWindow('position-addlabels-win')" style="vertical-align:middle;width: 62px;height: 23px;cursor: pointer;">
	    </div>
    </div>
    <!-- 简历删除设置 -->
    <div id="resume-del-win" class="mini-window"
	     style="width: auto;height:auto;left: 557px;top:106px; z-index:1983; display: none;"
	     borderStyle="border:5px solid #CCCCCC;"  headerStyle="background:
	     #E0EDFE;border-bottom:0px;height:30px;" 
	     bodyStyle="background-color: #F5F5F5;" showFooter="true">
   	  <div class="resume-del-div1" >
	      <table class="resume-del-tab1">
	        <tbody class="tbody1">
	          <tr>
	          	<td style="width: auto; height: auto;" class="ui_main">
	          		<div style="padding: 20px 30px 20px 0px;font-size: 13px;" class="ui_content"><span>真的删除简历吗?</span></div>
                </td>
	          </tr>
	        </tbody>
	      </table>
	    </div>
	    <div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;">
	      <input type="button" value="确定" onclick="deleteResume('resume-del-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	      <input type="button" value="取消" onclick="hideWindow('resume-del-win')" style="vertical-align:middle;width: 62px;height: 23px;">
	    </div>
	</div>
  </body>
   <link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/positionSet.css"/>
</html>
     