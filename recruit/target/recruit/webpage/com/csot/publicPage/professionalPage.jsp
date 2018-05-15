<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@include file="/webpage/common.jsp"%>
<link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/choosePerson.css"/>
<!-- 选择专业类别 -->
	        <div id="professional-category-win" class="mini-window"
				 style="width: 608px; display: none;"
				 borderStyle="border:5px solid #CCCCCC;"  
				 headerStyle="background:#E0EDFE;border-bottom:0px;height:30px;"  title="<b>选择职位类别<b>" 
				 bodyStyle="background-color: #F5F5F5;" showFooter="true">
		      <div class="professional-category-middle">
			    <div class="professional-category-middle-inner">
			      <b>&nbsp;&nbsp;已选择专业</b>&nbsp;&nbsp;
			      <span class="gray">最多选5个</span>&nbsp;&nbsp;
			      <span class="professional-category-prompt"></span>
			    </div>
			    <div class="choose-professional-data"></div>
			  </div>
			  <div class="choose-professional-category">
			    <div class="choose-professional-td"><span id="choose-professional-span">请选择专业</span></div>
			    <div class="choose-professional-text"><input type="text" class="choose-professional-input"></div>
			    <div class="choose-professional-panel"><b>&nbsp;&nbsp;请选择专业</b></div>
			  </div>
			  <div >
			    <div class="professional-category-data"></div>
			  </div>
			  <div property="footer" style="text-align:right; padding:3px;padding-right:10px;height: 28px; background-color: #F5F5F5;border: white;">
			    <input type="button" value="确定" onclick="submitCategoryData()"  style="vertical-align:middle;width: 62px;height: 23px;">
			    <input type="button" value="取消" onclick="hideWindow('professional-category-win')" style="vertical-align:middle;width: 62px;height: 23px;">
			  </div>
			</div>