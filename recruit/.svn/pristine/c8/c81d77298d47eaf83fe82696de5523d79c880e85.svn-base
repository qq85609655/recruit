<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/webpage/common.jsp"%>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/public/jquery.validator.css"/>
		<link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/interview/editInterviewInfo.css"/>
	  <title>面试信息录入</title>
  </head>
  <body onload="removeLoad();">
    <div class="co">
    	<div class="co-right">
    	  <div class="position-path co-right-center">
    			<span class="path-title">您的位置 :</span><span class="path-leaf">面试信息录入</span>
    	  </div>
				<div class="co-right-main co-right-center">
					<div class="con-title">面试信息录入</div>
					<div class="main">
						<form id="editform" class="jobEdit-form">
                            <input type="hidden" id="studentId" value="${studentId}">
							<div class="jobEdit-basic-infor blue radius">
								<table class="jobEdit-tab">
									<thead>
										<tr class="jobEdit-tr">
											<td height="86px;"><span><h4>入职深圳华星、深圳华星半导体、惠州华星的同学“招聘人员工号”请填写<span style="color: red;">16851</span><br><br>入职武汉华星、武汉华星半导体的同学“招聘人员工号”请填写 <span style="color: red;">35982</span></h4></span></td>
										</tr>
									</thead>
									<tbody>
										<tr class="jobEdit-tr">
											<td class="jobEdit-td" width="99%;">
                                               <div class="baseInfoLable-l" style="width: 160px;">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">招聘人员工号：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input type="text" id="recruiterNumber" name="recruiterNumber" class="radius1" onblur="getUserName">
                                               </div>
											</td>
										</tr>
                                        <tr class="jobEdit-tr">
                                          <td class="jobEdit-td" width="99%;">
                                               <div class="baseInfoLable-l" style="width: 160px;">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">招聘人员姓名：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input type="text" id="recruiterName" name="recruiterName" readonly="readonly" class="radius1">
                                               </div>
                                        </td>
                                      </tr>
									</tbody>
								</table>
							</div>
							
							<div class="jobEdit-submit">
								<table>
									<tr>
										<td colspan="1" align="center">
										  <a class="preview-button button btn radius" id="toEdit">下一步</a>
										</td>
									</tr>
								</table>
							</div>
						</form>
					</div>
				</div>
			</div> 
	  
    </div>
    <jsp:include page="/webpage/footer.jsp"></jsp:include>
	</body>
	<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.zh_cn.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/areaAutoCompleteData.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/areaData.js"></script>
  <script type="text/javascript"  charset="utf-8"  src="${webRoot}/resources/plugins/kindeditor-4.1.10/kindeditor.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/interview/toInterview.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/department.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/position/positionCategory.js"></script>
<html>
