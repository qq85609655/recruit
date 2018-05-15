<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/webpage/common.jsp"%>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/public/jquery.validator.css"/>
		<link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/position/positionEdit.css"/>
	  <title>职位发布</title>
  </head>
  <body onload="removeLoad();">
	  <jsp:include page="/webpage/header.jsp"><jsp:param name="currentPage" value="职位发布" /></jsp:include>
    <div class="co">
    	<div class="co-left">
    		<jsp:include page="/webpage/left-bar.jsp"></jsp:include>
    	</div>
    	<div class="co-right">
    	  <div class="position-path co-right-center">
    			<span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">易播职</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">职位发布</span>
    	  </div>
				<div class="co-right-main co-right-center">
					<div class="con-title">职位发布</div>
					<div class="main">
						<form id="editform" class="jobEdit-form">
							<div class="jobEdit-basic-infor blue radius">
								<table class="jobEdit-tab">
									<thead>
										<tr class="jobEdit-tr">
											<td colspan="2"><span><h4>职位基本信息</h4></span></td>
										</tr>
									</thead>
									<tbody>
										<tr class="jobEdit-tr">
											<td class="jobEdit-td">
												<font class="marker-color">*</font>
												<font class="font-title">职位名称：</font>
											</td>
											<td>
												<input type="text" id="positionName" name="positionName" class="jobEdit-name radius1">
											  <span class="font-icon icon-reply-all copy-posi" title="从其他职位复制"></span>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												<font class="marker-color">*</font>
												<font class="font-title">职位编码：</font>
											</td>
											<td>
												<span id="positionCode" class="jobEdit-font-size">000000</span>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												<font class="marker-color">*</font> 
												<font class="font-title">招聘对象：</font>
											</td>
											<td>
												<t:dictSelect type="checkbox" field="recruitObject" domClass="recruit-object"  typeGroupCode="recruit-obj" defaultVal="" hasLabel="false"></t:dictSelect>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												<font class="marker-color">*</font> 
												<font class="font-title">招聘类别：</font>
											</td>
											<td>
												<t:dictSelect type="checkbox" field="recruitType" domClass="recruit-type" typeGroupCode="recruit-type" defaultVal="" hasLabel="false"></t:dictSelect>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												<font class="marker-color">*</font> 
												<font class="font-title">职能类别：</font>
											</td>
											<td>
												<t:dictSelect type="select" id="positionType" field="position-type" typeGroupCode="position-type" defaultVal="0" hasLabel="false"></t:dictSelect>
											<c:if test="${ not empty u_datadictGroupController_config}" > 
													&nbsp;<a href="${webRoot}/datadictGroupController/config/position-type" target="_blank" class="path-item a-decoration sys-data-config">配置类别</a>
											  </c:if>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>&nbsp;&nbsp;&nbsp;<font class="font-title">职位级别：</font></td>
											<td>
												<t:dictSelect type="select" id="positionLevel" field="position-level" typeGroupCode="position-level" defaultVal="0" hasLabel="false"></t:dictSelect> 
												<c:if test="${not empty u_datadictGroupController_config}">
											  	&nbsp;<a href="${webRoot}/datadictGroupController/config/position-level" target="_blank" class="path-item a-decoration sys-data-config">配置级别</a>
											  </c:if>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												<font class="marker-color">*</font> 
												<font class="font-title">工作地区：</font>
											</td>
											<td>
										    <t:dictSelect type="select" id="workPlace1" field="workPlace" typeGroupCode="work-place" domClass="recruit-select" defaultVal="0" hasLabel="false"></t:dictSelect>
												<!-- <input type="hidden" id="workPlace" name="workPlace" value="选择地区" class="recruit-choosebtn areaSelect radius"/> -->
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												<font class="marker-color">*</font>
												<font class="font-title">职位类别：</font></td>
											<td>
												<input type="text" id="positionSimilar" name="positionSimilar" onclick="showAtPos('position-category-win','#positionSimilar',positionCategoryinit)" value="选择/修改" class="recruit-choosebtn radius"/>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												<font class="marker-color">*</font>
												<font class="font-title">招聘人数：</font>
											</td>
											<td>
												<input type="text" id="recruitNumbers" name="recruitNumbers" class="jobEdit-num radius1">
												&nbsp;&nbsp;<span class="jobEdit-font-size">(单位：个,必须为数字，0表示若干)</span>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												<font class="marker-color">*</font>
												<font class="font-title">有效期：</font>
											</td>
											<td>
												<t:dictSelect type="select" id="validaty" field="validaty" typeGroupCode="validity" defaultVal="2" hasLabel="false"></t:dictSelect>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												<font class="marker-color">*</font> 
												<font class="font-title">提供月薪：</font>
											</td>
											<td>
												<t:dictSelect type="select" id="salary" field="salary" domClass="recruit-select" typeGroupCode="salary" defaultVal="0" hasLabel="false"></t:dictSelect>
												&nbsp;<span class="jobEdit-font-size">(单位:元)</span>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												<font class="marker-color">*</font> 
												<font class="font-title">职位要求：</font>
											</td>
											<td>
												<input type="text" id="positionRequire" name="positionRequire" value="选择/修改" class="recruit-choosebtn radius" onclick="showAtPos('position-requirement-win','#positionRequire')" >
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												<font class="marker-color">*</font> 
												<font class="font-title">所属行业：</font>
											</td>
											<td>
												<t:dictSelect type="select" id="positionIndustry" field="positionIndustry" domClass="recruit-select" typeGroupCode="industry" defaultVal="0" hasLabel="false"></t:dictSelect>
												<c:if test="${not empty u_datadictGroupController_config}"> 
														&nbsp;<a href="${webRoot}/datadictGroupController/config/industry" target="_blank" class="path-item a-decoration sys-data-config">管理行业</a>
										    </c:if>
										    </td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												<font class="marker-color">*</font>
												<font class="font-title">职位描述 ：</font>
											</td>
											<td>
												<span class="jobEdit-font-size">请输入2000字以内的职位描述。(已输入 <font class="word_count" style="font-size: 18px;font-family: Constantia,Georgia;"></font> 字)</span>
											</td>
										</tr>
										<%-- <tr class="jobEdit-tr">
											<td><font class="font-title">专车职位:</font></td>
											<td><input type="checkbox"><label>提供面试专车</label></td>
										</tr> --%>
									</tbody>
								</table>
								<div>
									<textarea id="content_1" id="positionDescription" name="positionDescription" ></textarea>
								</div>
							</div>
							<div class="jobEdit-info  blue radius">
								<table class="requment-info">
									<thead>
										<tr class="jobEdit-tr">
											<td><span><h4>需求信息</h4></span></td>
										</tr>
									</thead>
									<tbody>
										<tr class="jobEdit-tr">
											<td class="jobEdit-td-l"><font class="marker-color">*</font>
												<font class="font-title">部门：</font>
											</td>
											<td>
												<input type="text" name="dept" value="请选择部门" class="recruit-choosebtn radius dep-choosebtn" id="depChoose"></input>
												<input type = "hidden" name="department" class="choose-department"></input>
												<c:if test="${not empty u_org_save }">
												  <span>&nbsp;<a class="path-item a-decoration" id="createDepartment" onclick="showAtPos('department-win','#createDepartment',cleanValidator('#orgAddForm'));">新建部门</a></span>
											  </c:if>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												&nbsp;&nbsp;&nbsp;<font class="font-title">内部编码：</font>
											</td>
											<td>
												<input type="text" name="innerCode" id="innerCode" class="jobEdit-text radius1"></input>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												<font class="marker-color">*</font> 
												<font class="font-title">职位生效日期：</font>
											</td>
											<td>
												<input type="text" name="effect-date" id="effectiveDate" class="jobEdit-text mini-datepicker"></input>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												<font class="marker-color">*</font> 
												<font class="font-title">需求人数：</font>
											</td>
											<td>
												<input type="text" name="reNum" id="depDemands" class="jobEdit-text radius1"></input>
												<span class="jobEdit-font-size">&nbsp;(范围:1-999)</span>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												<font class="marker-color">*</font> 
												<font class="font-title radius1">期望到岗日期：</font>
											</td>
											<td>
												<input type="text" name="expectDate" id="expectDate" class="jobEdit-text mini-datepicker"></input>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>
												<font class="marker-color">*</font> 
												<font class="font-title">需求类型：</font>
											</td>
											<td>
												<t:dictSelect type="select" id="operateType" field="operateType" domClass="recruit-select" typeGroupCode="operate-type" defaultVal="0" hasLabel="false"></t:dictSelect>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							
							<div class="jobEdit-role  blue radius">
								<table class="requment-role">
									<thead>
										<tr class="jobEdit-tr">
											<td colspan="2" class="jobEdit-td"><span><h4>招聘流程角色设置</h4></span></td>
										</tr>
									</thead>
									<tbody>
										<tr class="jobEdit-tr">
											<td class="jobEdit-td-l">
												<font class="marker-color">*</font>
												<font class="font-title">招聘专员：</font>
											</td>
											<td>
											  <input type="hidden" name="hidrecruiter2" id="hidrecruiter2" value="">
												<input type="text" name="recruiter" value="请选择招聘专员" id="recruiterChoose" class="recruit-choosebtn radius" onclick="openSelPost('#recruiterChoose','#hiddrecruiter','#hidrecruiter2')"> 
												<input type="hidden" name="hiddrecruiter"  id="hiddrecruiter"> 
												<c:if test="${not empty u_baseUserController_save }">
													&nbsp;<span><a class="path-item a-decoration" id="createAccount" onclick="showAtPos('recruit-assistant-win','#recruiterChoose',cleanValidator('#accountAddForm'))">新建账号</a></span>
										    </c:if>
										    </td>
										</tr>
										<tr class="jobEdit-tr">
											<td>&nbsp;&nbsp;&nbsp;<font class="font-title">其他招聘专员：</font></td>
											<td>
											  <input type="hidden" name="otherHidrecruiter2" id="otherHidrecruiter2" value="">
												<input type="text" name="otherRecruiter" value="请选择其他招聘专员" class="recruit-choosebtn radius" id="otherRecruiter" onclick="openSelPost('#otherRecruiter','#otherHiddrecruiter','#otherHidrecruiter2')">
												<input type="hidden" name="otherHiddrecruiter"  id="otherHiddrecruiter"> 
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td>&nbsp;&nbsp;&nbsp;<font class="font-title">用人部门主管：</font></td>
											<td>
												<input type="text" name="deptManager" id="deptManager" class="jobEdit-dept-text  radius1"/>
												&nbsp;<span><a class="path-item a-decoration">选择用人部门主管</a></span>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td><font class="marker-color">*</font> <font
												class="font-title">接收简历邮箱：</font></td>
											<td>
												<t:dictSelect type="select" id="receiveEmail" field="receiveEmail" domClass="recruit-select" typeGroupCode="receive-email" defaultVal="0" hasLabel="false"></t:dictSelect>
												  <c:if test="${not empty u_datadictGroupController_config}"> 
												   &nbsp;<span><a href="${webRoot}/datadictGroupController/config/receive-email" target="_blank" class="path-item a-decoration sys-data-config">邮箱管理</a></span>
											    </c:if>
											</td>
										</tr>
										<tr class="jobEdit-tr">
											<td><font class="marker-color">*</font> <font
												class="font-title">面试评估模板：</font></td>
											<td>
												<select name="modelManager" id="interviewTemplate" class="recruit-select">
													<option value="0">请选择面试评估模板</option>
												</select> 
												<c:if test="${not empty u_template_templateManage }">
												   &nbsp;<span><a href="${webRoot}/template/templateManage" target="_blank" class="path-item a-decoration sys-data-config">模板管理</a></span>
											  </c:if>
											</td>
										</tr>
									</tbody>
								</table>
							</div>

							<div class="security-settings  blue radius">
								<table class="security-tab">
									<thead>
										<tr class="jobEdit-tr">
											<td class="jobEdit-td"><span>
													<h4>保密设置</h4>
											</span></td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>
												<!-- <input type="radio" name="privacy" class="privacy" value="010-000"><label>公开</label>
												<input type="radio" name="privacy" class="privacy" value="010-001"><label>对内公开(不显示在招聘门户)</label>
												<input type="radio" name="privacy" class="privacy" value="010-002"><label>保密(仅流程参与人员可见)</label> -->
												<t:dictSelect type="radio" field="privacy" domClass="privacy" typeGroupCode="secrecy" hasLabel="false" defaultVal="0"></t:dictSelect>
											</td>
											</tr>
									</tbody>
								</table>
							</div>
							<div class="jobEdit-submit">
								<table>
									<tr>
										<td colspan="1" align="center">
										  <c:if test="${not empty u_position_save }">
											  <a class="submit-button button btn radius" id="release">发布</a>
											</c:if>
											<a class="save-button button btn radius" id="saveDraft">保存为草稿</a>
											<a class="preview-button button btn radius" id="review">预览</a>
										</td>
									</tr>
								</table>
							</div>
						</form>
					</div>
				</div>
			</div> 
		 
			<!--区域   -->
			<div id="popInner"  class="mini-window" style="width: 700px; display: none;" title="请选择区域 " showFooter="true">
	      <div class="pop-main">
	        <div class="main-city">
	          <h4 class="title">
	          	主要城市
	          	<input type="text" id="areaSearch" class="search-input radius" value="市.区(拼音首字母/中文/英文)"></input>
	          	<input id="hidQuickAreaId" type="hidden" value="">
	          </h4>
	          <div id="mainCities">
	          	<ul class="MainCityList"></ul>
	          </div>
	      	</div>
	      	<div class="pop-status city-list" id="cityList">
	      		<h4 class="title">全国各省</h4>
	        	<div id="allProv" class="allProv"></div>
	      	</div>
	      	<div property="footer" class="win-footer">
	        	<input type="button" class="win-footer-btn" value="取消" onclick="closeWin()">
	     	 	</div>
	    	</div>
    	</div>
    	<div id="sublist"></div>
			<div id="countyList"></div>
    
    <!-- 职位要求 -->
    <div id="position-requirement-win" class="mini-window" style="width: 570px;height: 260px; display: none;" title="职位要求设置" showFooter="true">
	  	<div class="position-requirement-div1" >
	      <table class="position-requirement-tab1">
	        <tbody class="position-requirement-tbody">
	          <tr>
	            <td ><span>&nbsp;&nbsp;&nbsp;年龄：</span></td>
	            <td>
	              <select class="valid" id="ageLower" name="ageLower"><option selected="selected" value="0">不限</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option><option value="31">31</option><option value="32">32</option><option value="33">33</option><option value="34">34</option><option value="35">35</option><option value="36">36</option><option value="37">37</option><option value="38">38</option><option value="39">39</option><option value="40">40</option><option value="41">41</option><option value="42">42</option><option value="43">43</option><option value="44">44</option><option value="45">45</option><option value="46">46</option><option value="47">47</option><option value="48">48</option><option value="49">49</option><option value="50">50</option><option value="51">51</option><option value="52">52</option><option value="53">53</option><option value="54">54</option><option value="55">55</option><option value="56">56</option><option value="57">57</option><option value="58">58</option><option value="59">59</option><option value="60">60</option><option value="61">61</option><option value="62">62</option><option value="63">63</option><option value="64">64</option><option value="65">65</option></select>
	              &nbsp;<span>至</span>&nbsp;
	              <select id="ageUpper" name="ageUpper"><option selected="selected" value="0">不限</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option><option value="31">31</option><option value="32">32</option><option value="33">33</option><option value="34">34</option><option value="35">35</option><option value="36">36</option><option value="37">37</option><option value="38">38</option><option value="39">39</option><option value="40">40</option><option value="41">41</option><option value="42">42</option><option value="43">43</option><option value="44">44</option><option value="45">45</option><option value="46">46</option><option value="47">47</option><option value="48">48</option><option value="49">49</option><option value="50">50</option><option value="51">51</option><option value="52">52</option><option value="53">53</option><option value="54">54</option><option value="55">55</option><option value="56">56</option><option value="57">57</option><option value="58">58</option><option value="59">59</option><option value="60">60</option><option value="61">61</option><option value="62">62</option><option value="63">63</option><option value="64">64</option><option value="65">65</option></select>
	            </td>
	            <td class="position-requirement-td"><span>不符合条件，则</span></td>
	            <td>
	            	<t:dictSelect type="radio" field="ageScheme" domClass="ageScheme" typeGroupCode="not-arrival-demand" hasLabel="false"></t:dictSelect>
	            </td>
	          </tr>
	          <tr>
	            <td ><span>&nbsp;&nbsp;&nbsp;工作年限：</span></td>
	            <td>
	              <select id="workYearLower" name="workYearLower"><option selected="selected" value="0">不限</option><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="15">15</option><option value="20">20</option><option value="25">25</option><option value="30">30</option></select>
	               &nbsp;<span>至</span>&nbsp;
	              <select id="workYearUpper" name="workYearUpper"><option selected="selected" value="0">不限</option><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="15">15</option><option value="20">20</option><option value="25">25</option><option value="30">30</option></select>
	            </td>
	            <td class="position-requirement-td"><span>不符合条件，则　</span></td>
	            <td><t:dictSelect type="radio" field="workYearScheme" domClass="workYearScheme" typeGroupCode="not-arrival-demand" hasLabel="false"></t:dictSelect>
	          </tr>
	          <tr>
	            <td><span>&nbsp;&nbsp;&nbsp;英语等级：</span></td>
	            <td>
	              <t:dictSelect type="select"  id="englishLevel" field="englishLevel" domClass="englishLevel" typeGroupCode="english-level" hasLabel="false"></t:dictSelect>
	              <span>&nbsp;<span>及以上</span></span>
	            </td>
	            <td class="position-requirement-td"><span>不符合条件，则　</span></td>
	            <td><t:dictSelect type="radio" field="englishLevelScheme" domClass="englishLevelScheme" typeGroupCode="not-arrival-demand" hasLabel="false"></t:dictSelect>
	          </tr>
	          <tr>
	            <td><span>&nbsp;&nbsp;&nbsp;学历要求：</span></td>
	            <td>
	              <t:dictSelect type="select" id="fromDegreeIdLower" field="fromDegreeIdLower" domClass="fromDegreeIdLower" typeGroupCode="education" hasLabel="false"></t:dictSelect>
	              &nbsp;<span>至</span>&nbsp;
	           		<t:dictSelect type="select" id="fromDegreeIdUpper" field="fromDegreeIdUpper" domClass="fromDegreeIdUpper" typeGroupCode="education" hasLabel="false"></t:dictSelect>
	            </td>
	            <td class="position-requirement-td"><span>不符合条件，则</span></td>
	            <td><t:dictSelect type="radio" field="degreeScheme" domClass="degreeScheme" typeGroupCode="not-arrival-demand" hasLabel="false"></t:dictSelect>
	          </tr>
	          <tr>
	            <td><span>&nbsp;&nbsp;&nbsp;性别：</span></td>
	            <td>
	              <select id="gender" name="gender"><option value="不限">不限</option><option value="001-000">男</option><option value="001-001">女</option></select>
	            </td>
	            <td class="position-requirement-td"><span>不符合条件，则</span></td>
	            <td><t:dictSelect type="radio" field="genderScheme" domClass="genderScheme" typeGroupCode="not-arrival-demand" hasLabel="false"></t:dictSelect>
	          </tr>
	        </tbody>
	      </table>
	    </div>
	    <div property="footer" class="win-footer">
	      <input type="button" class="win-footer-btn" value="确定" onclick="submitPRData()">
	      <input type="button" class="win-footer-btn" value="取消" onclick="hideWindow('position-requirement-win')">
	    </div>
	</div>
	  
	  <!-- 部门 -->
	    <div id="department-win" style="display:none;" class="mini-window department-win" title="添加部门" showFooter="true" >
	    <form class="position-dept-info" id="orgAddForm">
	      <table class="position-dept-tab">
	        <tr>
	          <td width="80px;"><span style="color:red">*</span><span>&nbsp;部门:</span></td>
	          <td><input type="text" id="orgName" name="orgName" class="radius"></td>
	        </tr>
	        <tr>
	          <td><!-- <span style="color:red">*</span> --><span>&nbsp;&nbsp;联系人:</span></td>
	          <td><input type="text" id="orglinkman" name="linkman" class="radius"></td>
	        </tr>
	        <tr>
	          <td><span>&nbsp;&nbsp;上级部门:</span></td>
	          <td><input type="button" name="orgParent" id="orgParentForAdd" class="pdept-btn dep-choosebtn recruit-choosebtn radius" value="选择部门"></td>
	        </tr>
	        <tr>
	          <td><span>&nbsp;&nbsp;联系电话:</span></td>
	          <td><input type="text" id="orgAddTel" name="tel" class="radius"></td>
	        </tr>
	        <tr>
	          <td><span>&nbsp;&nbsp;Email:</span></td>
	          <td><input type="text" id="orgAddEmail" name="email" class="radius"></td>
	        </tr>
	      </table>
	    </form>
	    <div property="footer" class="win-footer">
	      <input type="button" class="win-footer-btn" value="确定" id="orgAddOK">
	      <input type="button" class="win-footer-btn" value="取消" onclick="hideWindow('department-win')">
	    </div>
	  </div>
	  
	  <!-- 新建账号 -->
	  <div id="recruit-assistant-win" style="display:none;" class="mini-window recruit-assistant-win" title="选择招聘专员" showFooter="true"> 
	    <form id="accountAddForm" action="${webRoot}/baseUserController/save">
		    <div class="recruit-assistant-middle">
		      <table class="recruit-assistant-tab">
		        <tr>
		          <td width="100px"><span style="color:red">*</span><span>&nbsp;登陆账号:</span></td>
		          <td><input type="text" id="account" name="account" class="recruit-assistant-text radius"></td>
		        </tr>
		        <tr>
		          <td><span><span style="color:red">*</span>&nbsp;姓名:</span></td>
		          <td><input type="text" id="name" name="name" class="recruit-assistant-text radius"></td>
		        </tr>
		        <tr>
		          <td><span>&nbsp;&nbsp;联系电话:</span></td>
		          <td><input type="text" id="accountTel" name="tel" class="recruit-assistant-text radius"></td>
		        </tr>
		        <tr>
		          <td><span>&nbsp;&nbsp;手机：</span></td>
		          <td><input type="text" id="cellphone" name="cellphone" class="recruit-assistant-text radius"></td>
		        </tr>
		        <tr>
		        	<td></td>
		          <td><span id="cellphoneMsg" class="cellphone-msg"></span></td>
		        </tr>
		        <tr>
		          <td><span>&nbsp;&nbsp;是否启用:</span></td>
		          <td><input type="checkbox" id="accountStatu" name="status" checked></td>
		        </tr>
		        <tr>
		          <td><span>&nbsp;&nbsp;部门:</span></td>
		          <td><input type="button" name="" class="recruit-assistant-dept dep-choosebtn recruit-choosebtn radius" id="recruit-assistant-dept" value="选择部门"></td>
		        </tr>
		        <tr>
		          <td><span style="color:red">*</span><span>&nbsp;账号角色:</span></td>
		          <td>
		          <!-- 由动态的角色生成 -->
	            <select id="roleOperate" name="roleId">
	              <option selected>请选择</option>
	            </select>
		          </td>
		        </tr>
		        <tr>
		          <td><span>&nbsp;&nbsp;登陆配置:</span></td>
		          <td>
		            <select class="recruit-select">
		              <option>请选择</option>
		            </select>
		          </td>
		        </tr>
		      </table>
		    </div>
	    </form>
	    <div property="footer" class="win-footer">
	      <input type="button" class="win-footer-btn" value="确定" id="accountAddOK">
	      <input type="button" class="win-footer-btn" value="取消" onclick="hideWindow('recruit-assistant-win')">
	    </div>
	  </div>
	  
	   <!-- 选择职位类别 -->
	  <div id="position-category-win" class="mini-window" style="width: 608px; display: none;"title="选择职位类别" showFooter="true">
	    <div class="position-category-middle radius">
	      <div class="position-category-middle-inner">
	         <b>&nbsp;&nbsp;已选择职位</b>&nbsp;&nbsp;<span class="gray">最多选5个</span>&nbsp;&nbsp;<span class="position-category-prompt"></span>
	      </div>
	      <div class="choose-position-data">
	      </div>
	    </div>
	    <div class="choose-position-category">
	      <div class="choose-position-td radius"><span id="choose-position-span">浏览所有职位大类<span class="font-icon icon-down"></span></span></div>
	      <div class="choose-position-text"><input type="text" class="choose-position-input radius search-input" value="快速查找职位/中文/英文/拼音"></div>
	    </div>
	    <!-- 职位类别数据 -->
	  	<div class="position-category-pdata"></div> 
	    <div class="position-category-data"></div>
	    <div property="footer" class="win-footer">
	      <input type="button" class="win-footer-btn" value="确定" onclick="positionCategory.submitCategoryData()">
	      <input type="button" class="win-footer-btn" value="取消" onclick="hideWindow('position-category-win')">
	    </div>
	  </div>
	  
	  <!-- 华星光电部门树 -->
	  <div class="csot-department">
	     <div class="mini-tree mini-dept-tree radius" id="mini-dept-tree"  onnodeselect="onNodeSelect" textField="orgName" resultAsTree="false" allowSelect="true" showTreeIcon="false"></div>
	  </div>
	  
	  <!-- 选择招聘专员 -->
	  <jsp:include page="/webpage/com/csot/publicPage/choosePerson.jsp"></jsp:include>
	  
	    
	    <div class="mini-window" id="positionName-choose-win"  style="width: 607px; height: 380px; display: none;" title="请选择要复制的职位" showFooter="true">
	      <div id="datagrid1" class="mini-datagrid" url="/recruit/position/queryPositionManaList" 
			   idField="id" sizeList="[5]" pageSize="10" allowResize="false" ondrawcell="ondrawcell"
			   allowUnselect="true" style="height: 300px;">
					<div property="columns">
			    	<div type="indexcolumn" ></div>
			  		<div name="positionNameColumn" field="positionName" width="100" allowSort="true">职位名称</div>    
			  		<div name="workPlaceColumn" field="workPlace" width="100" align="center" headerAlign="center" allowSort="true">工作地点</div>                            
			  		<div name="statusColumn" field="status" width="100" align="center" headerAlign="center" allowSort="true">状态</div>
			  		<div name="releaseDateColumn" field="releaseDate" width="100" allowSort="true" align="center" headerAlign="center" dateFormat="yyyy-MM-dd">发布日期</div>                                
		    	</div>
				</div>
				<div property="footer" class="win-footer">
	      	<input type="button" class="win-footer-btn" value="确定" onclick="getPositionNameData()">
	      	<input type="button" class="win-footer-btn" value="取消" onclick="hideWindow('positionName-choose-win')">
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
  <script type="text/javascript" src="${webRoot}/resources/js/position/positionEdit.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/department.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/position/positionCategory.js"></script>
<html>
