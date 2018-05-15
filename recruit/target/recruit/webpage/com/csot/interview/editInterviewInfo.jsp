<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<%@include file="/webpage/common.jsp"%>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/public/jquery.validator.css"/>
		<link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/interview/editInterviewInfo.css"/>
	  <title>面试信息录入</title>
  </head>
  <body onload="removeLoad();">
    <div class="co" style="padding-top: 50px;">
    	  <div class="position-path co-right-center">
          <input type="hidden" id="operatorType" value="${operatorType}">
    	  </div>
				<div class="co-right-main co-right-center">
					<div class="con-title">面试信息录入</div>
					<div class="main">
						<form id="editform" class="jobEdit-form">
                        <input type="hidden" id="id" name="id"  value="${basicInfo.id}">
                        <input type="hidden" id="personCode" name="personCode"  value="${basicInfo.personCode}">
                        <input type="hidden" id="recruiterNumber" name="recruiterNumber" value="${basicInfo.recruiterNumber}">
                        <input type="hidden" id="recruiterName" name="recruiterName" value="${basicInfo.recruiterName}">
							<div class="jobEdit-basic-infor blue radius">
								<table class="jobEdit-tab">
									<thead>
										<tr class="jobEdit-tr">
											<td><span><h4>基本信息</h4></span></td>
										</tr>
									</thead>
									<tbody>
										<tr class="jobEdit-tr">
											<td class="jobEdit-td" width="99%;">
                                               <div class="baseInfoLable-l">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">国籍：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <t:dictSelect labelClass="interview" type="select" id="nationality" field="nationality" typeGroupCode="nationality" defaultVal="${ basicInfo.nationality }" hasLabel="false"></t:dictSelect>
                                               </div>
                                               <div class="baseInfoLable-r">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">中文名：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input type="text" id="cnname" name="cnname" value="${ basicInfo.cnname }" class="radius1" onblur="makePinyin(this.value)">
                                               </div>
	                                           <div class="baseInfoLable-l" style="margin-left:10px;">
	                                              <font class="marker-color">*</font>
	                                              <font class="font-title">姓名拼音：</font>
	                                           </div>
	                                           <div class="baseInfoInput">
	                                              <input type="text" id="namepy" name="namepy" value="${ basicInfo.namepy }" class="radius1">
	                                              <select id="namepychk" style="display:none;width:150px;" onchange="makeNamePy()">

												  </select>
	                                           </div>
                                               <div class="baseInfoLable-l">
                                                  <font class="marker-color">&nbsp;&nbsp;</font>
                                                  <font class="font-title">英文名：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input type="text" id="enname" name="enname" value="${ basicInfo.enname }" class="radius1">
                                               </div>
											</td>
										</tr>
                                        <tr class="jobEdit-tr">
                                          <td class="jobEdit-td" width="99%;">
                                               <div class="baseInfoLable-l" style="width: 56px;">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">性别：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <t:dictSelect labelClass="interview" type="select" id="sex" field="sex" typeGroupCode="sex-interview" defaultVal="${ basicInfo.sex }" hasLabel="false"></t:dictSelect>
                                               </div>
                                               <div class="baseInfoLable-r">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">婚姻状况：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <t:dictSelect labelClass="interview" type="radio" field="maritalStatus" domClass="marital-status-interview" typeGroupCode="marital-status-interview" defaultVal="${ basicInfo.maritalStatus }" hasLabel="false"></t:dictSelect>
                                               </div>
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr">
                                          <td class="jobEdit-td" width="99%;">
                                             <div class="baseInfoLable-l" style="width: 56px;">
                                                <font class="marker-color">*</font>
                                                <font class="font-title">民族：</font>
                                             </div>
                                             <div class="baseInfoInput">
                                                <t:dictSelect labelClass="interview" type="select" id="nation" field="nation" typeGroupCode="nation" defaultVal="${ basicInfo.nation }" hasLabel="false"></t:dictSelect>
                                             </div>
                                             <div class="baseInfoLable-r">
                                                <font class="marker-color">*</font>
                                                <font class="font-title">政治面貌：</font>
                                             </div>
                                             <div class="baseInfoInput">
                                                <t:dictSelect labelClass="interview" type="select" id="politicalStatus" field="politicalStatus" typeGroupCode="political-status" defaultVal="${ basicInfo.politicalStatus }" hasLabel="false"></t:dictSelect>
                                             </div>
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr cnarea">
                                          <td class="jobEdit-td" width="99%;">
                                              <div class="baseInfoLable-l" style="width: 120px;">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">籍贯（省&市）：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input type="text" id="nativePlace" name="nativePlace" value="${ basicInfo.nativePlace }" class="radius1">
                                               </div>
                                               <div class="baseInfoLable-r">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">户口性质：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <t:dictSelect labelClass="interview" type="select" id="residenceProperty" field="residenceProperty" typeGroupCode="residence-property" defaultVal="${ basicInfo.residenceProperty }" hasLabel="false"></t:dictSelect>
                                               </div>
                                               <div class="baseInfoLable-r" style="width: 200px;">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">户籍地址（与身份证一致）：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input type="text" id="residence" name="residence" class="radius1" value="${ basicInfo.residence }" style="width: 220px;">
                                               </div>
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr">
                                          <td class="jobEdit-td" width="99%;">
                                               <div class="baseInfoLable-l">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">证件类型：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <t:dictSelect labelClass="interview" type="select" id="certificateType" field="certificateType" typeGroupCode="certificate-type" defaultVal="${ basicInfo.certificateType }" hasLabel="false"></t:dictSelect>
                                               </div>
                                               <div class="baseInfoLable-r">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">证件号码：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input type="text" id="certificateNum" name="certificateNum" value="${ basicInfo.certificateNum }" class="radius1">
                                               </div>
                                               <div class="baseInfoLable-r">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">证件姓名：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input type="text" id="certificateName" name="certificateName" value="${ basicInfo.certificateName }" class="radius1">
                                               </div>
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr">
                                          <td class="jobEdit-td" width="99%;">
                                               <div class="baseInfoLable-l">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">出生日期：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input id="birthdate" name="birthdate" class="radius1 mini-datepicker"
                                                    type="text" style="width: 110px" tabindex="7" value="${ basicInfo.birthdate }" format="yyyy-MM-dd" />
                                               </div>
                                               <div class="baseInfoLable-r">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">最高学历：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <t:dictSelect labelClass="interview" type="select" id="highestEducation" field="highestEducation" typeGroupCode="highest-education" defaultVal="${ basicInfo.highestEducation }" hasLabel="false"></t:dictSelect>
                                               </div>
                                               <div class="baseInfoLable-r">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">手机号码：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input type="text" id="phonenumber" name="phonenumber" value="${ basicInfo.phonenumber }" class="radius1">
                                               </div>
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr">
                                          <td class="jobEdit-td" width="99%;">
                                               <div class="baseInfoLable-l">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">电子邮箱：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input type="text" id="email" name="email" value="${ basicInfo.email }" class="radius1">
                                               </div>
                                               <div class="baseInfoLable-r">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">通信地址：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input type="text" id="address" name="address" value="${ basicInfo.address }" class="radius1">
                                               </div>
                                               <div class="baseInfoLable-r">
                                                  <font class="marker-color">&nbsp;&nbsp;</font>
                                                  <font class="font-title">邮编：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input type="text" id="postcodes" name="postcodes" value="${ basicInfo.postcodes }" class="radius1">
                                               </div>
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr">
                                          <td class="jobEdit-td" width="99%;">
                                               <div class="baseInfoLable-l" style="width: 320px;">
                                                  <font class="font-title">参加工作日期（毕业后第一份工作，没有可不填）：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input id="startworkingdate" name="startworkingdate" class="radius1 mini-datepicker"
                                                    type="text" style="width: 110px" tabindex="7" value="${ basicInfo.startworkingdate }"/>
                                               </div>
                                               <div class="baseInfoLable-r">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">应聘职位：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input type="text" id="positionName" name="positionName" class="radius1" value="${ basicInfo.positionName }" style="width: 160px;">
                                               </div>
                                               <div class="baseInfoLable-r" style="width: 108px;">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">可到岗时间：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input id="arriveDate" name="arriveDate" class="radius1 mini-datepicker"
                                                    type="text" style="width: 110px" tabindex="7" value="${ basicInfo.arriveDate }"/>
                                               </div>
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr">
                                          <td class="jobEdit-td" width="99%;">
                                               <div class="baseInfoLable-l" style="width: 150px;">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">期待待遇（税前）：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                                                                                                                                    月薪：&nbsp;<input type="text" id="expectedSalaryMonth" name="expectedSalaryMonth" value="${ basicInfo.expectedSalaryMonth }" class="radius1" style="width: 86px;">&nbsp;元；&nbsp;&nbsp;
                                                                                                                                                                    年薪：&nbsp;<input type="text" id="expectedSalaryYear" name="expectedSalaryYear" value="${ basicInfo.expectedSalaryYear }" class="radius1" style="width: 86px;">&nbsp;万元；&nbsp;&nbsp;
                                                                                                                                                                    其他：&nbsp;<input type="text" id="expectedSalaryOther" name="expectedSalaryOther" value="${ basicInfo.expectedSalaryOther }" class="radius1">
                                               </div>
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr">
                                          <td class="jobEdit-td" width="99%;">
                                               <div class="baseInfoLable-l" style="width: 190px;">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">您从何处得知公司招聘信息：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <t:dictSelect labelClass="interview" type="radio" field="recruitmentApproach" domClass="recruitment-approach" typeGroupCode="recruitment-approach" defaultVal="${ basicInfo.recruitmentApproach }" hasLabel="false"></t:dictSelect>
                                                  <span style="margin-left: 20px;display: none" id="refereeArea">
                                                    <font class="marker-color">*</font>
                                                    <font class="font-title">推荐人姓名：</font>
                                                    <input type="text" id="refereeName" name="refereeName" value="${ basicInfo.refereeName }" class="radius1">
                                                    <font class="font-title">工号：</font>
                                                    <input type="text" id="refereeWorkCode" name="refereeWorkCode" value="${ basicInfo.refereeWorkCode }" class="radius1">
                                                    <font class="font-title">联系方式：</font>
                                                    <input type="text" id="refereePhone" name="refereePhone" value="${ basicInfo.refereePhone }" class="radius1">
                                                  </span>
                                                  <span style="margin-left: 20px;display: none" id="otherWayArea">
                                                    <font class="marker-color">*</font>
                                                    <font class="font-title">其他途径：</font>
                                                    <input type="text" id="otherWay" name="otherWay" value="${ basicInfo.otherWay }" class="radius1">
                                                  </span>
                                               </div>
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr">
                                          <td class="jobEdit-td" width="99%;">
                                               <div class="baseInfoLable-l" style="width: 260px;">
                                                  <font class="marker-color">*</font>
                                                  <font class="font-title">是否有亲属在【华星】工作，如有请列明：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <t:dictSelect labelClass="interview" type="radio" field="relativesFlag" domClass="relatives-flag" typeGroupCode="relatives-flag" defaultVal="${ basicInfo.relativesFlag }" hasLabel="false"></t:dictSelect>
                                                  <span style="margin-left: 20px;" class="relativesArea">
                                                    <font class="marker-color">*</font>
                                                    <font class="font-title">姓名：</font>
                                                    <input type="text" id="relativesName" name="relativesName" value="${ basicInfo.relativesName }" class="radius1">
                                                  </span>
                                                  <span style="margin-left: 8px;" class="relativesArea">
                                                    <font class="marker-color">*</font>
                                                    <font class="font-title">关系：</font>
                                                    <input type="text" id="relativesShip" name="relativesShip" value="${ basicInfo.relativesShip }" class="radius1">
                                                  </span>
                                               </div>
                                          </td>
                                        </tr>
									</tbody>
								</table>
							</div>
							<div class="jobEdit-role  blue radius" style="height:180px;">
								<table class="jobEdit-tab">
									<thead>
										<tr class="jobEdit-tr">
											<td><span><h4>家庭成员<span style="color: red;">（点击表格进行编辑，至少填写一位）</span></h4></span></td>
										</tr>
									</thead>
									<tbody>
                                     <tr class="jobEdit-tr">
                                      <td class="jobEdit-td" width="99%;">
                                      <div id="datagrid-family" class="mini-datagrid" style="width:960px;height:140px;"
                                          data="${ fs }" idField="id" 
                                          allowResize="false" showPager="false" allowAlternating="true" pageSize="5"
                                          allowCellEdit="true" allowCellSelect="true" multiSelect="true" editNextRowCell="true" >
                                          <div property="columns">
                                              <div field="menberName" headerAlign="center" allowSort="false" width="150" >主要家庭成员（姓名）
                                                  <input property="editor" class="mini-textbox" style="width:100%;" />
                                              </div>
                                              <div type="comboboxcolumn" autoShowPopup="true" field="familyRelation" width="80" allowSort="false" >关系(请选择)
                                                  <input property="editor" class="mini-combobox" textField="text" valueField="code" style="width:96%;" data="familyRelations" />
                                              </div>
                                              <div type="comboboxcolumn" autoShowPopup="true" name="menberGender" field="menberGender" width="60" allowSort="false"  align="center" headerAlign="center">性别(请选择)
                                                  <input property="editor" class="mini-combobox" textField="text" valueField="code" style="width:86%;" data="Genders" />                
                                              </div>
                                              <div name="menberBirthday" field="menberBirthday" width="100" allowSort="false" dateFormat="yyyy-MM-dd">出生日期(请选择)
                                                  <input property="editor" class="mini-datepicker" format="yyyy-MM-dd" style="width:86%;"/>
                                              </div>
                                              <div field="menberAddress" width="120" headerAlign="center" allowSort="false">工作单位或居住地
                                                  <input property="editor" class="mini-textarea" style="width:120px;" minWidth="100" minHeight="50"/>
                                              </div>
                                              <div type="checkboxcolumn" field="emergentFlag" trueValue="1" falseValue="0" width="100" headerAlign="center" click="emergentEvent">是否是紧急联系人</div>                        
                                          </div>
                                      </div>
                                      </td>
                                      </tr>
									</tbody>
								</table>
							</div>
              
                            <div class="jobEdit-role  blue radius" style="height:100px;">
                              <table class="jobEdit-tab">
                                <thead>
                                  <tr class="jobEdit-tr">
                                    <td><span><h4>紧急联系人<span style="color: red;">（点击表格进行编辑，至少填写一位）</span></h4></span></td>
                                  </tr>
                                </thead>
                                <tbody>
                                   <tr class="jobEdit-tr">
                                    <td class="jobEdit-td" width="99%;">
                                    <div id="datagrid-emergent" class="mini-datagrid" style="width:960px;height:80px;"
                                         idField="id" 
                                        allowResize="false" showPager="false" allowAlternating="true" pageSize="5"
                                        allowCellEdit="true" allowCellSelect="true" multiSelect="true" editNextRowCell="true" >
                                        <div property="columns">
                                            <div field="emergentName" headerAlign="center" allowSort="false" width="150" >紧急联系人（姓名）
                                                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="200" />
                                            </div>
                                            <div type="comboboxcolumn" autoShowPopup="true" field="emergentRelation" width="100" allowSort="false" >关系(请选择)
                                                <input property="editor" class="mini-combobox" textField="text" valueField="code" style="width:100%;" data="emergentRelations" />
                                            </div> 
                                            <div field="emergentPhone" width="100" headerAlign="center" allowSort="false">电话号码
                                                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="200" />
                                            </div>
                                            <div field="emergentAddress" width="120" headerAlign="center" allowSort="false">工作单位或居住地
                                                <input property="editor" class="mini-textarea" style="width:200px;" minWidth="200" minHeight="50"/>
                                            </div>
                                        </div>
                                    </div>
                                    </td>
                                    </tr>
                                </tbody>
                              </table>
                            </div>
							<div class="jobEdit-role  blue radius">
								<table class="jobEdit-tab">
									<thead>
										<tr class="jobEdit-tr">
  										  <td>
                                            <span><h4>教育及培训（从最高学历开始）</h4></span></br>
                                            <span>
                                              <a class="mini-button" iconCls="icon-addnew" onClick="addEdus();">添加</a> 
                                              &nbsp;&nbsp;
                                              <a class="mini-button" iconCls="icon-remove" onClick="deleteEdus();">删减</a>
                                              </br>
                                            </span>
                                          </td>
										</tr>
                                    </thead>
                                    <tbody id="edutb">
                                    <c:forEach var="edu" items="${ edus }" varStatus="status">
                                        <c:set var="i" value="${status.count }"></c:set>  
                                        <tr class="jobEdit-tr" title="edutr${i}">
                                          <td class="jobEdit-td" width="99%;">
                                             <div class="baseInfoLable-l">
                                                <font class="marker-color">*</font>
                                                <font class="font-title">起止日期：</font>
                                             </div>
                                             <div class="baseInfoInput">
                                                <input id="eduStartDate${i}" name="eduStartDate" class="radius1 mini-datepicker"
                                                  type="text" style="width: 110px" tabindex="7" value="${ edu.eduStartDate }"/> ~ 
                                                <input id="eduEndDate${i}" name="eduEndDate" class="radius1 mini-datepicker" 
                                                type="text" style="width: 110px" tabindex="7" value="${ edu.eduEndDate }"/>
                                             </div>
                                             <div class="baseInfoLable-r">
                                                <font class="marker-color">*</font>
                                                <font class="font-title">学校：</font>
                                             </div>
                                             <div class="baseInfoInput">
                                                <input type="text" id="schoolName${i}" name="schoolName" value="${ edu.schoolName }" class="radius1">
                                             </div>
                                             <div class="baseInfoLable-r">
                                                <font class="marker-color">*</font>
                                                <font class="font-title">专业：</font>
                                             </div>
                                             <div class="baseInfoInput">
                                                <input type="text" id="major${i}" name="major" value="${ edu.major }" class="radius1">
                                             </div>
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr" title="edutr${i}">
                                          <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                             <div class="baseInfoLable-l">
                                                <font class="marker-color">*</font>
                                                <font class="font-title">学历：</font>
                                             </div>
                                             <div class="baseInfoInput">
                                                <t:dictSelect labelClass="interview" type="select" id="education${i}" field="education" typeGroupCode="educational-background" defaultVal="${ edu.education }" hasLabel="false"></t:dictSelect>
                                             </div>
                                             <div class="baseInfoLable-r">
                                                <font class="marker-color">*</font>
                                                <font class="font-title">性质：</font>
                                             </div>
                                             <div class="baseInfoInput">
                                                <t:dictSelect labelClass="interview" type="select" id="eduType${i}" field="eduType" domClass="educationalType" typeGroupCode="educational-type" defaultVal="${ edu.eduType }" hasLabel="false"></t:dictSelect>
                                             </div>
                                             <div class="baseInfoLable-r">
                                                <font class="marker-color">*</font>
                                                <font class="font-title">取得证书：</font>
                                             </div>
                                             <div class="baseInfoInput">
                                                <t:dictSelect labelClass="interview" type="checkbox" id="certificate${i}" field="certificate" domClass="certificate${i}" typeGroupCode="get-certificate" defaultVal="${ edu.certificate }" hasLabel="false"></t:dictSelect>
                                             </div>
                                             <div class="baseInfoLable-r">
                                                <font class="marker-color">*</font>
                                                <font class="font-title">国家代码：</font>
                                             </div>
                                             <div class="baseInfoInput">
                                                <t:dictSelect labelClass="interview" type="select" id="certNationality${i}" field="certNationality" domClass="certNationality${i}" typeGroupCode="nationality" defaultVal="${ edu.certNationality }" hasLabel="false"></t:dictSelect>
                                             </div>
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr" title="edutr${i}">
                                          <td height="10px;"></td>
                                        </tr>
                                    </c:forEach>
                                  </tbody>
                          </table>
                          <table class="jobEdit-tab">
                            <tbody>        
                              <c:forEach var="certification" items="${ certifications }" begin="0" end="1" varStatus="status">
                                    <c:set var="i" value="${status.count }"></c:set> 
                                          <tr class="jobEdit-tr">
                                            <td class="jobEdit-td" width="99%;" style="border-top: 1px solid #AEBED7;">
                                               <div class="baseInfoLable-l" style="width: 120px;">
                                                  <font class="marker-color">&nbsp;&nbsp;</font>
                                                  <font class="font-title">资格证书类别：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <t:dictSelect labelClass="interview" type="select" id="diplomaType${i}" field="diplomaType" typeGroupCode="diploma-type" defaultVal="${ certification.type }" hasLabel="false"></t:dictSelect>
                                               </div>
                                               <div class="baseInfoLable-r" style="width: 120px;">
                                                  <font class="marker-color">&nbsp;&nbsp;</font>
                                                  <font class="font-title">资格证书名称：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input type="text" id="diplomaName${i}" name="diplomaName" value="${ certification.name }" class="radius1">
                                               </div>
                                               <div class="baseInfoLable-r">
                                                  <font class="marker-color">&nbsp;&nbsp;</font>
                                                  <font class="font-title">获得时间：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input id="diplomaDate${i}" name="diplomaDate" class="radius1 mini-datepicker"
                                                    type="text" style="width: 110px" tabindex="7" value="${ certification.receivingdate }"/>
                                               </div>
                                            </td>
                                          </tr>
                                          <tr class="jobEdit-tr">
                                            <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                               <div class="baseInfoLable-r">
                                                  <font class="marker-color">&nbsp;&nbsp;</font>
                                                  <font class="font-title">证书编号：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input type="text" id="diplomaNum${i}" name="diplomaNum" value="${ certification.num }" class="radius1">
                                               </div>
                                               <div class="baseInfoLable-r">
                                                  <font class="marker-color">&nbsp;&nbsp;</font>
                                                  <font class="font-title">发证机构：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  <input type="text" id="diplomaOrgan${i}" name="diplomaOrgan" value="${ certification.authorityOrg }" class="radius1">
                                               </div>
                                            </td>
                                          </tr>
                                   </c:forEach>      
									</tbody>
								</table>
							</div>
                            <div class="jobEdit-role  blue radius">
                              <table class="jobEdit-tab" border="1px solid #AEBED7;">
                                <thead>
                                    <span><h4>语言及计算机</h4></span>
                                    </thead>
                                    <tbody>
                                        <tr class="jobEdit-tr">
                                          <td class="infoTableTd-header">
                                              <font class="font-title">计算机技能</font>
                                          </td>
                                          <td class="infoTableTd-header">
                                              <font class="font-title">掌握程度 </font>
                                          </td>
                                          <td class="infoTableTd-header">
                                              <font class="font-title">证书名称 </font>
                                          </td>
                                          <td class="infoTableTd-header">
                                              <font class="font-title">语言能力</font>
                                          </td>
                                          <td class="infoTableTd-header">
                                              <font class="font-title">掌握程度</font>
                                          </td>
                                          <td class="infoTableTd-header">
                                              <font class="font-title">等级证书</font>
                                          </td>
                                        </tr>
                                        
                                        <tr class="jobEdit-tr">
                                          <td class="infoTableTd">
                                              <div id="officeFlag" name="officeFlag" class="mini-checkbox" readOnly="false" trueValue="1" falseValue="0" text="Office" value="${lans.officeFlag}" onvaluechanged="onValueChanged"></div>
                                          </td>
                                          <td class="infoTableTd">
                                              <t:dictSelect labelClass="interview" type="radio" id="officeSkilledLevel" field="officeSkilledLevel" domClass="officeSkilledLevel" typeGroupCode="skilled-level" hasLabel="false" defaultVal="${lans.officeSkilledLevel}"></t:dictSelect>
                                          </td>
                                          <td class="infoTableTd">
                                              <input type="text" id="officeDiploma" name="officeDiploma" value="${lans.officeDiploma}" class="radius1">
                                          </td>
                                          <td class="infoTableTd">
                                              <div id="englishFlag" name="englishFlag" class="mini-checkbox" readOnly="false" trueValue="1" falseValue="0" text="英语" value="${lans.englishFlag}" onvaluechanged="onValueChanged"></div>
                                          </td>
                                          <td class="infoTableTd">
                                          <div>
                                            <t:dictSelect labelClass="interview" type="radio" id="englishSkilledLevel" field="englishSkilledLevel" domClass="englishSkilledLevel" typeGroupCode="skilled-level" hasLabel="false" defaultVal="${lans.englishSkilledLevel}"></t:dictSelect>
                                          </div>
                                          </td>
                                          <td class="infoTableTd">
                                              <input type="text" id="englishDiploma" name="englishDiploma" value="${lans.englishDiploma}" class="radius1">
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr">
                                          <td class="infoTableTd">
                                              <div id="sapFlag" name="sapFlag" class="mini-checkbox" readOnly="false" trueValue="1" falseValue="0" text="SAP/ERP" value="${lans.sapFlag}" onvaluechanged="onValueChanged"></div>
                                          </td>
                                          <td class="infoTableTd">
                                              <t:dictSelect labelClass="interview" type="radio" id="sapSkilledLevel" field="sapSkilledLevel" domClass="sapSkilledLevel" typeGroupCode="skilled-level" hasLabel="false" defaultVal="${lans.sapSkilledLevel}"></t:dictSelect>
                                          </td>
                                          <td class="infoTableTd">
                                              <input type="text" id="sapDiploma" name="sapDiploma" value="${lans.sapDiploma}" class="radius1">
                                          </td>
                                          <td class="infoTableTd">
                                              <div id="koreanFlag" name="koreanFlag" class="mini-checkbox" readOnly="false" trueValue="1" falseValue="0" text="韩语" value="${lans.koreanFlag}" onvaluechanged="onValueChanged"></div>
                                          </td>
                                          <td class="infoTableTd">
                                          <div>
                                            <t:dictSelect labelClass="interview" type="radio" id="koreanSkilledLevel" field="koreanSkilledLevel" domClass="koreanSkilledLevel" typeGroupCode="skilled-level" hasLabel="false" defaultVal="${lans.koreanSkilledLevel}"></t:dictSelect>
                                          </div>
                                          </td>
                                          <td class="infoTableTd">
                                              <input type="text" id="koreanDiploma" name="koreanDiploma" value="${lans.koreanDiploma}" class="radius1">
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr">
                                          <td class="infoTableTd">
                                              <div id="vbaFlag" name="vbaFlag" class="mini-checkbox" readOnly="false" trueValue="1" falseValue="0" text="VBA/SQL" value="${lans.vbaFlag}" onvaluechanged="onValueChanged"></div>
                                          </td>
                                          <td class="infoTableTd">
                                              <t:dictSelect labelClass="interview" type="radio" id="vbaSkilledLevel" field="vbaSkilledLevel" domClass="skilled-level" typeGroupCode="skilled-level" hasLabel="false" defaultVal="${lans.vbaSkilledLevel}"></t:dictSelect>
                                          </td>
                                          <td class="infoTableTd">
                                              <input type="text" id="vbaDiploma" name="vbaDiploma" value="${lans.vbaDiploma}" class="radius1">
                                          </td>
                                          <td class="infoTableTd">
                                              <div id="japaneseFlag" name="japaneseFlag" class="mini-checkbox" readOnly="false" trueValue="1" falseValue="0" text="日语" value="${lans.japaneseFlag}" onvaluechanged="onValueChanged"></div>
                                          </td>
                                          <td class="infoTableTd">
                                          <div>
                                            <t:dictSelect labelClass="interview" type="radio" id="japaneseSkilledLevel" field="japaneseSkilledLevel" domClass="japaneseSkilledLevel" typeGroupCode="skilled-level" hasLabel="false" defaultVal="${lans.japaneseSkilledLevel}"></t:dictSelect>
                                          </div>
                                          </td>
                                          <td class="infoTableTd">
                                              <input type="text" id="japaneseDiploma" name="japaneseDiploma" value="${lans.japaneseDiploma}" class="radius1">
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr">
                                          <td class="infoTableTd">
                                              <div id="otheritFlag" name="otheritFlag" class="mini-checkbox" readOnly="false" trueValue="1" falseValue="0" text="其他" value="${lans.otheritFlag}" onvaluechanged="onValueChanged"></div>
                                          </td>
                                          <td class="infoTableTd-1">
                                              <t:dictSelect labelClass="interview" type="radio" id="otheritSkilledLevel" field="otheritSkilledLevel" domClass="otheritSkilledLevel" typeGroupCode="skilled-level" hasLabel="false" defaultVal="${lans.otheritSkilledLevel}"></t:dictSelect>
                                          </td>
                                          <td class="infoTableTd">
                                              <input type="text" id="otheritDiploma" name="otheritDiploma" value="${lans.otheritDiploma}" class="radius1">
                                          </td>
                                          <td class="infoTableTd">
                                              <div id="otherFlag" name="otherFlag" class="mini-checkbox" readOnly="false" trueValue="1" falseValue="0" text="其他" value="${lans.otherFlag}" onvaluechanged="onValueChanged"></div>
                                          </td>
                                          <td class="infoTableTd-1">
                                          <div>
                                            <t:dictSelect labelClass="interview" type="radio" id="otherSkilledLevel" field="otherSkilledLevel" domClass="otherSkilledLevel" typeGroupCode="skilled-level" hasLabel="false" defaultVal="${lans.otherSkilledLevel}"></t:dictSelect>
                                          </div>
                                          </td>
                                          <td class="infoTableTd">
                                              <input type="text" id="otherDiploma" name="otherDiploma" value="${lans.otherDiploma}" class="radius1">
                                          </td>
                                        </tr>
                                </tbody>
                              </table>
                            </div>
                            
                            <div class="jobEdit-role  blue radius">
                              <table class="jobEdit-tab">
                                <thead>
                                    <span>
                                      <h4>工作履历 <span style="color: red;">(请从全日制毕业后第一份工作开始完整填写，此项将影响您的社会工龄计算，没有可不用填)</span></h4>
                                    </span>
                                    <span>
                                      <a class="mini-button" iconCls="icon-addnew" onClick="addWorks();">添加</a> 
                                      &nbsp;&nbsp;
                                      <a class="mini-button" iconCls="icon-remove" onClick="deleteWorks();">删减</a>
                                    </span>
                                    </thead>
                                    <tbody id="worktb">
                                    <c:forEach var="work" items="${ works }" varStatus="status">
                                     <c:set var="i" value="${status.count }"></c:set>
                                        <tr class="jobEdit-tr" title="worktr${i}">
                                          <td class="job-td1">
                                              <font class="font-title">起止时间：</font></br>
                                              <input id="workstartdate${i}" name="workstartdate" class="radius1 mini-datepicker"
                                                type="text" style="width: 100px" tabindex="7" value="${ work.jobStartDate }"/> ~ 
                                              <input id="workenddate${i}" name="workenddate" class="radius1 mini-datepicker"
                                              type="text" style="width: 100px" tabindex="7" value="${ work.jobEndDate }"/>
                                          </td>
                                          <td class="job-td" colspan="2">
                                              <font class="font-title">公司名称： </font></br>
                                              <input type="text" id="companyName${i}" name="companyName" value="${ work.companyName }" class="radius1">
                                          </td>
                                          <td class="job-td" colspan="2">
                                              <font class="font-title">当前/最终薪水：</font>
                                              <input type="text" id="finalSalary${i}" name="salary" value="${ work.salary }" class="radius1">
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr" title="worktr${i}">
                                          <td class="job-td1">
                                              <font class="font-title">所在部门：</font></br>
                                              <input type="text" id="department${i}" name="department" value="${ work.department }" class="radius1">
                                          </td>
                                          <td class="job-td2">
                                              <font class="font-title">当前/最终职位： </font></br>
                                              <input type="text" id="finalPosition${i}" name="positionName" value="${ work.positionName }" class="radius1">
                                          </td>
                                          <td class="job-td2">
                                              <font class="font-title">汇报给：</font>
                                              <input type="text" id="reportTo${i}" name="debriefer" value="${ work.debriefer }" class="radius1">
                                          </td>
                                          <td class="job-td3">
                                              <font class="font-title">下属人数：</font>
                                              <input type="text" id="subordinates${i}" name="subordinate" value="${ work.subordinate }" class="radius1">
                                          </td>
                                          <td class="job-td3">
                                              <font class="font-title">服务年限：</font>
                                              <input type="text" id="seniority${i}" name="seniority" value="${ work.seniority }" class="radius1">
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr" title="worktr${i}">
                                          <td class="job-td" colspan="5">
                                              <font class="font-title">主要工作职责：</font></br>
                                              <textarea id="responsibilities${i}" name="jobDuty" class="radius2">${ work.jobDuty }</textarea>
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr" style="border-bottom: 2px solid #AEBED7;" title="worktr${i}">
                                          <td class="job-td" colspan="2">
                                              <font class="font-title">离职原因：</font></br>
                                              <input type="text" id="leaveReason${i}" name="leaveReason" value="${ work.leaveReason }" class="radius2">
                                          </td>
                                          <td class="job-td2">
                                              <font class="font-title">证明人：</font>
                                              <input type="text" id="reterence${i}" name="reterence" value="${ work.reterence }" class="radius1">
                                          </td>
                                          <td class="job-td3">
                                              <font class="font-title">关系：</font></br>
                                              <input type="text" id="relationship${i}" name="relationship" value="${ work.relationship }" class="radius1">
                                          </td>
                                          <td class="job-td3">
                                              <font class="font-title">证明人电话：</font>
                                              <input type="text" id="reterencePhone${i}" name="reterencePhone" value="${ work.reterencePhone }" class="radius1">
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr" title="worktr${i}">
                                          <td height="10px;"></td>
                                        </tr>
                                        </c:forEach>
                                        
                                </tbody>
                              </table>
                            </div>
                            
                            <div class="jobEdit-role  blue radius">
                                <table class="jobEdit-tab">
                                  <thead>
                                    <tr class="jobEdit-tr">
                                      <td><span><h4>奖励及特长</h4></span></td>
                                    </tr>
                                  </thead>
                                  <tbody>
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;">
                                           <div class="baseInfoLable-l">
                                              <font class="font-title">奖励名称：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              <input type="text" id="rewardName1" name="rewardName" value="${ rews.rewardName1 }" class="radius1">
                                           </div>
                                           <div class="baseInfoLable-r">
                                              <font class="font-title">获得时间：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              <input id="rewardDate1" name="rewardDate" class="radius1 mini-datepicker"
                                              type="text" style="width: 110px" tabindex="7" value="${ rews.rewardDate1 }"/>
                                           </div>
                                           <div class="baseInfoLable-r">
                                              <font class="font-title">颁发机构：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              <input type="text" id="authorities1" name="authorities" value="${ rews.authorities1 }" class="radius1">
                                           </div>
                                        </td>
                                      </tr>
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;">
                                           <div class="baseInfoLable-l">
                                              <font class="font-title">奖励名称：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              <input type="text" id="rewardName2" name="rewardName" value="${ rews.rewardName2 }" class="radius1">
                                           </div>
                                           <div class="baseInfoLable-r">
                                              <font class="font-title">获得时间：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              <input id="rewardDate2" name="rewardDate" class="radius1 mini-datepicker"
                                              type="text" style="width: 110px" tabindex="7" value="value="${ rews.rewardDate2 }""/>
                                           </div>
                                           <div class="baseInfoLable-r">
                                              <font class="font-title">颁发机构：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              <input type="text" id="authorities2" name="authorities" value="${ rews.authorities2 }" class="radius1">
                                           </div>
                                        </td>
                                      </tr>
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                           <div class="baseInfoLable-l">
                                              <font class="font-title">奖励名称：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              <input type="text" id="rewardName3" name="rewardName" value="${ rews.rewardName3 }" class="radius1">
                                           </div>
                                           <div class="baseInfoLable-r">
                                              <font class="font-title">获得时间：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              <input id="rewardDate3" name="rewardDate" class="radius1 mini-datepicker"
                                              type="text" style="width: 110px" tabindex="7" value="value="${ rews.rewardDate3 }""/>
                                           </div>
                                           <div class="baseInfoLable-r">
                                              <font class="font-title">颁发机构：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              <input type="text" id="authorities3" name="authorities" value="${ rews.authorities3 }" class="radius1">
                                           </div>
                                        </td>
                                      </tr>
                                      
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                           <div class="baseInfoLable-l">
                                              <font class="font-title">兴趣爱好：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              <input type="text" id="hobby" name="hobby" value="${ rews.hobby }" class="radius1">
                                           </div>
                                           <div class="baseInfoLable-r">
                                              <font class="font-title">特长：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              <input type="text" id="speciality" name="speciality" value="${ rews.speciality }" class="radius1">
                                           </div>
                                        </td>
                                      </tr>
                                  </tbody>
                                </table>
                              </div>
                              
                              <div class="jobEdit-role  blue radius" style="height:150px;">
                              <table class="jobEdit-tab">
                                <thead>
                                  <tr class="jobEdit-tr">
                                    <td><span><h4>推荐信息（*【华星】非常认同和重视招聘中的人脉资源，请向我们推荐您的三名同事或朋友。）(点击表格进行编辑)</h4></span></td>
                                  </tr>
                                </thead>
                                <tbody>
                                   <tr class="jobEdit-tr">
                                    <td class="jobEdit-td" width="99%;">
                                    <div id="datagrid-recommended" class="mini-datagrid" style="width:960px;height:110px;"
                                        url="" idField="id" 
                                        allowResize="false" showPager="false" allowAlternating="true" pageSize="5"
                                        allowCellEdit="true" allowCellSelect="true" multiSelect="true" editNextRowCell="true" >
                                        <div property="columns">
                                            <div field="recommended" headerAlign="center" allowSort="false" width="150" >被推荐人
                                                <input property="editor" class="mini-textbox" style="width:100%;" minWidth="200" />
                                            </div>
                                            <div field="recommendRelation" width="100" allowSort="false" >关系
                                                <input property="editor" class="mini-textbox"  value="25" style="width:100%;"/>
                                            </div>
                                            <div field="recommendPosition" width="100" allowSort="false" >推荐职位
                                                <input property="editor" class="mini-textbox"  value="25" style="width:100%;"/>
                                            </div>       
                                            <div field="recommendPhone" width="120" headerAlign="center" allowSort="false">电话号码
                                                <input property="editor" class="mini-textbox" style="width:200px;" />
                                            </div>
                                            <div field="recommendAddress" width="120" headerAlign="center" allowSort="false">工作单位或居住地
                                                <input property="editor" class="mini-textarea" style="width:200px;" minWidth="200" minHeight="50"/>
                                            </div>
                                        </div>
                                    </div>
                                    </td>
                                    </tr>
                                </tbody>
                              </table>
                            </div>

							<div class="security-settings  blue radius">
                            <input type="hidden" id="infectionId" name="infectionId"  value="${ill.id}">
								<table class="security-tab">
									<thead>
										<tr class="jobEdit-tr">
											<td class="jobEdit-td"><span>
										        <h4>声明</h4>
											</span></td>
										</tr>
									</thead>
									<tbody>
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                           <div class="illustrate-l">
                                              <font class="marker-color">*</font>
                                              <font class="font-title">您是否有家族遗传病史、传染病史或其它重大疾病史？如有请说明。</font>
                                           </div>
                                           <div class="illustrate-m">
                                              <div id="infectionFlag" name="infectionFlag" class="mini-radiobuttonlist" textField="text" valueField="code" value="${ ill.infectionFlag }" 
                                                data="[{'code':'1','text':'没有'},{'code':'2','text':'有'}]" ></div>
                                           </div>
                                           <div class="illustrate-r">
                                              <input type="text" id="infectionText" name="infectionText" value="${ ill.infectionText }" class="radius1">
                                           </div>
                                        </td>
                                      </tr>
                                      
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                           <div class="illustrate-l">
                                              <font class="marker-color">*</font>
                                              <font class="font-title">您是否有过刑事犯罪记录？如有请说明。</font>
                                           </div>
                                           <div class="illustrate-m">
                                              <div id="criminalFlag" name="criminalFlag" class="mini-radiobuttonlist" textField="text" valueField="code" value="${ ill.criminalFlag }" 
                                                data="[{'code':'1','text':'没有'},{'code':'2','text':'有'}]" ></div>
                                           </div>
                                           <div class="illustrate-r">
                                              <input type="text" id="criminalText" name="criminalText" value="${ ill.criminalText }" class="radius1">
                                           </div>
                                        </td>
                                      </tr>
                                      
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                           <div class="illustrate-l">
                                              <font class="marker-color">*</font>
                                              <font class="font-title">您是否仍与其他雇主存在雇佣关系吗？如有请说明。</font>
                                           </div>
                                           <div class="illustrate-m">
                                              <div id="employFlag" name="employFlag" class="mini-radiobuttonlist" textField="text" valueField="code" value="${ ill.employFlag }" 
                                                data="[{'code':'1','text':'没有'},{'code':'2','text':'有'}]" ></div>
                                           </div>
                                           <div class="illustrate-r">
                                              <input type="text" id="employText" name="employText" value="${ ill.employText }" class="radius1">
                                           </div>
                                        </td>
                                      </tr>
                                      
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                           <div class="illustrate-l">
                                              <font class="marker-color">*</font>
                                              <font class="font-title">您是否愿意配合我司做背景调查？如不愿意的，请说明。</font>
                                           </div>
                                           <div class="illustrate-m">
                                              <div id="investigateFlag" name="investigateFlag" class="mini-radiobuttonlist" textField="text" valueField="code" value="${ ill.investigateFlag }" 
                                                data="[{'code':'1','text':'愿意'},{'code':'2','text':'不愿意'}]" ></div>
                                           </div>
                                           <div class="illustrate-r">
                                              <input type="text" id="investigateText" name="investigateText" value="${ ill.investigateText }" class="radius1">
                                           </div>
                                        </td>
                                      </tr>
                                      
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;">
                                           <div class="illustrate-l">
                                              <font class="marker-color">*</font>
                                              <font class="font-title">您是否与其他单位签署了竞业禁止协议且尚在竞业限制期限内？</font>
                                           </div>
                                           <div class="illustrate-m">
                                              <div id="banFlag" name="banFlag" class="mini-radiobuttonlist" textField="text" valueField="code" value="${ ill.banFlag }" 
                                                data="[{'code':'1','text':'没有'},{'code':'2','text':'有'}]" ></div>
                                           </div>
                                        </td>
                                      </tr>
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                           <div class="illustrate-m">
                                              <font class="marker-color">&nbsp;&nbsp;</font>
                                              <font class="font-title">如有请补充以下信息：</font>
                                           </div>
                                           <div class="illustrate-l" style="width: 80%">
                                                                                                                                                签订期限：
                                           <input id="banStartdate" name="banStartdate" class="radius1 mini-datepicker"
                                              type="text" style="width: 100px" tabindex="7" value="${ ill.banStartdate }"/> ~ 
                                            <input id="banEnddate" name="banEnddate" class="radius1 mini-datepicker"
                                            type="text" style="width: 100px" tabindex="7" value="${ ill.banEnddate }"/>
                                            &nbsp;&nbsp;且补偿金金额：<input type="text" id="payment" name="payment" value="${ ill.payment }" class="radius1">&nbsp;万元
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
										  <c:if test="${not empty u_position_save }">
											  <a class="submit-button button btn radius" id="release">发布</a>
											</c:if>
											<a class="save-button button btn radius" id="saveData">提交</a>
											<a class="preview-button button btn radius" id="review">预览</a>
                                            <a class="preview-button button btn radius" style="display: none;" id="print">打印</a>
										</td>
									</tr>
								</table>
							</div>
						</form>
                        <form id="reviewForm" action="${ctx}/interviewController/toReview" method="post" target= _blank>
                          <input id="baseInfo" type="hidden" name="baseInfo" value="" />
                          <input id="family" type="hidden" name="family" value="" />
                          
                           <input id="emergent" type="hidden" name="emergent" value="" />
                          <input id="education" type="hidden" name="education" value="" />
                          <input id="certification" type="hidden" name="certification" value="" />
                          <input id="language" type="hidden" name="language" value="" />
                           <input id="work" type="hidden" name="work" value="" />
                            <input id="reward" type="hidden" name="reward" value="" />
                             <input id="recommended" type="hidden" name="recommended" value="" />
                              <input id="illustrate" type="hidden" name="illustrate" value="" />
                        </form>
					</div>
				</div>
	  
	  <!-- 选择招聘专员 -->
	  <jsp:include page="/webpage/com/csot/publicPage/choosePerson.jsp"></jsp:include>
    </div>
    <jsp:include page="/webpage/footer.jsp"></jsp:include>
	</body>
  <script type="text/javascript">
$(document).ready(function() {
	
	// 初始化mini ui
	mini.parse();	
	var webRoot = "${webRoot}";
	var grid = mini.get("datagrid-family");
	var FamilyContacts = [{"menberName":""},{"menberName":""},{"menberName":""},{"menberName":""}];
	var emergentContact = [{"emergentName":""},{"emergentName":""}];
	var recommendedContact = [{"recommended":""},{"recommended":""},{"recommended":""}];

	if('${fs}'!=''){
	  grid.setData(${fs});
	}else{
	  grid.setData(FamilyContacts);
	}	    
    grid.on("cellclick",function(e){ 
      var field=e.field;
       if( field=="emergentFlag" ){
         emergentEvent();
      }
    });
    
    var grid2 = mini.get("datagrid-emergent");
    if('${egms}'!=''){
      grid2.setData(${egms});
	}else{
	  grid2.setData(emergentContact);
	}	
    
    var grid3 = mini.get("datagrid-recommended");
    if('${recs}'!=''){
      grid3.setData(${recs});
	}else{
	  grid3.setData(recommendedContact);
	}	
    
    //为页面元素添加绑定事件
    bindingEvent();
    
    //工作经验
    var wks = "${works}";
    wkcount = 0;
    if(wks){
      wkcount = wks.split(",").length;
    }
    //教育经历
    var eds = "${edus}";
    educount = 0;
    if(eds){
      educount = eds.split(",").length;
    }
    //证书
    var certs = "${certifications}";
    cetcount = 0;
    if(certs){
      cetcount = certs.split(",").length;
    }
    //学生id
    studentId = "${studentId}";
    if(studentId){
    }else{
      studentId="";
    }
});

function addWorks(){
  var workArea = $("#worktb");
  wkcount++;
  var workHTML = '<tr class="jobEdit-tr" title="worktr'+wkcount+'"> <td class="job-td1"> <font class="font-title">起止时间：</font></br> <input id="workstartdate'+wkcount+'" name="workstartdate" class="radius1 mini-datepicker" type="text" style="width: 100px" tabindex="7" /> ~ <input id="workenddate'+wkcount+'" name="workenddate" class="radius1 mini-datepicker" 	type="text" style="width: 100px" tabindex="7" /> </td> <td class="job-td" colspan="2"> <font class="font-title">公司名称： </font></br> <input type="text" id="companyName'+wkcount+'" name="companyName" class="radius1"> </td> <td class="job-td" colspan="2"> <font class="font-title">当前/最终薪水：</font> <input type="text" id="finalSalary'+wkcount+'" name="salary" class="radius1"> </td></tr><tr class="jobEdit-tr" title="worktr'+wkcount+'"> <td class="job-td1"> <font class="font-title">所在部门：</font></br> <input type="text" id="department'+wkcount+'" name="department" class="radius1"> </td> <td class="job-td2"> <font class="font-title">当前/最终职位： </font></br> <input type="text" id="finalPosition'+wkcount+'" name="positionName" class="radius1"> </td> <td class="job-td2"> <font class="font-title">汇报给：</font> <input type="text" id="reportTo'+wkcount+'" name="debriefer" class="radius1"> </td> <td class="job-td3"> <font class="font-title">下属人数：</font> <input type="text" id="subordinates'+wkcount+'" name="subordinate" value="0" class="radius1"> </td> <td class="job-td3"> <font class="font-title">服务年限：</font> <input type="text" id="seniority'+wkcount+'" name="seniority" class="radius1"> </td></tr><tr class="jobEdit-tr" title="worktr'+wkcount+'"> <td class="job-td" colspan="5"> <font class="font-title">主要工作职责：</font></br> <textArea id="responsibilities'+wkcount+'" name="jobDuty" class="radius2"></textArea> </td></tr><tr class="jobEdit-tr" style="border-bottom: 2px solid #AEBED7;" title="worktr'+wkcount+'"> <td class="job-td" colspan="2"> <font class="font-title">离职原因：</font></br> <input type="text" id="leaveReason'+wkcount+'" name="leaveReason" class="radius2"> </td> <td class="job-td2"> <font class="font-title">证明人：</font> <input type="text" id="reterence'+wkcount+'" name="reterence" class="radius1"> </td> <td class="job-td3"> <font class="font-title">关系：</font> <input type="text" id="relationship'+wkcount+'" name="relationship" class="radius1"> </td> <td class="job-td3"> <font class="font-title">证明人电话：</font> <input type="text" id="reterencePhone'+wkcount+'" name="reterencePhone" value="${ work.reterencePhone }" class="radius1"> </td></tr><tr class="jobEdit-tr" title="worktr'+wkcount+'"> <td height="10px;"></td></tr>';
  workArea.append(workHTML);
  mini.parse();
}

function deleteWorks(){
  if(!wkcount || wkcount<=1){
    return;
  }
  var workArea = $("#worktb tr");
  workArea.remove("tr[title=worktr"+wkcount+"]");
  wkcount--;
}

function addEdus(){
  var eduArea = $("#edutb");
  educount++;
  var eduHTML = '<tr class="jobEdit-tr" title="edutr'+educount+'"> <td class="jobEdit-td" width="99%;"> <div class="baseInfoLable-l"> <font class="marker-color">*</font> <font class="font-title">起止日期：</font> </div> <div class="baseInfoInput"> <input id="eduStartDate'+educount+'" name="eduStartDate" class="radius1 mini-datepicker" type="text" style="width: 110px" tabindex="7"/> ~ <input id="eduEndDate'+educount+'" name="eduEndDate" class="radius1 mini-datepicker" type="text" style="width: 110px" tabindex="7"/> </div> <div class="baseInfoLable-r"> <font class="marker-color">*</font> <font class="font-title">学校：</font> </div> <div class="baseInfoInput"> <input type="text" id="schoolName'+educount+'" name="schoolName" class="radius1"> </div> <div class="baseInfoLable-r"> <font class="marker-color">*</font> <font class="font-title">专业：</font> </div> <div class="baseInfoInput"> <input type="text" id="major'+educount+'" name="major" class="radius1"> </div> </td></tr> <tr class="jobEdit-tr" title="edutr'+educount+'"> <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;"> <div class="baseInfoLable-l"> <font class="marker-color">*</font> <font class="font-title">学历：</font> </div> <div class="baseInfoInput"> <t:dictSelect labelClass="interview" type="select" id="education'+educount+'" field="education" typeGroupCode="educational-background" defaultVal="${ edu.education }" hasLabel="false"></t:dictSelect> </div> <div class="baseInfoLable-r"> <font class="marker-color">*</font> <font class="font-title">性质：</font> </div> <div class="baseInfoInput"> <t:dictSelect labelClass="interview" type="select" id="eduType'+educount+'" field="eduType" domClass="educationalType" typeGroupCode="educational-type" defaultVal="${ edu.eduType }" hasLabel="false"></t:dictSelect> </div> <div class="baseInfoLable-r"> <font class="marker-color">*</font> <font class="font-title">取得证书：</font> </div> <div class="baseInfoInput"> <t:dictSelect labelClass="interview" type="checkbox" id="certificate'+educount+'" field="certificate" domClass="certificate'+educount+'" typeGroupCode="get-certificate" defaultVal="${ edu.certificate }" hasLabel="false"></t:dictSelect> </div> <div class="baseInfoLable-r"> <font class="marker-color">*</font> <font class="font-title">国家代码：</font> </div> <div class="baseInfoInput"> <t:dictSelect labelClass="interview" type="select" id="certNationality'+educount+'" field="certNationality" domClass="certNationality'+educount+'" typeGroupCode="nationality" defaultVal="1" hasLabel="false"></t:dictSelect> </div> </td></tr> <tr class="jobEdit-tr" title="edutr'+educount+'"> <td height="10px;"></td></tr>';
  eduArea.append(eduHTML);
  mini.parse();
}

function deleteEdus(){
  if(!educount || educount<=1){
    return;
  }
  var eduArea = $("#edutb tr");
  eduArea.remove("tr[title=edutr"+educount+"]");
  educount--;
}


function makePinyin(value) {
    var res = $.ajax({
    	type:'post',       	
    	url:'${webRoot}/interviewController/getPinyin',
    	data: { str:value },
    	async:false
    }).responseText;
    
    var resArr = res.split(',');
    if(resArr.length > 1) {
      	$('#namepy').css('display','none');
    	$('#namepychk').css('display','block');
    	$('#namepychk').empty();
    	var objSelect = document.getElementById("namepychk");
    	for(var i=0; i<resArr.length; i++) {
        	var new_opt = new Option(resArr[i], resArr[i]);      
        	objSelect.options.add(new_opt);
    	}
    	$('#namepy').val(resArr[0]);
    	alert("姓名存在多音字，请选择正确的拼音！");
    } else {
    	$('#namepy').val(res);
    	$('#namepy').css('display','block');
    	$('#namepychk').css('display','none');
    }
}

function makeNamePy() {
	var objSelect = document.getElementById("namepychk");
	$('#namepy').val(objSelect.options[objSelect.selectedIndex].text);
}

  </script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.zh_cn.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/areaAutoCompleteData.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/areaData.js"></script>
  <script type="text/javascript"  charset="utf-8"  src="${webRoot}/resources/plugins/kindeditor-4.1.10/kindeditor.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/interview/editInterviewInfo.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/department.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/position/positionCategory.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/pinyin.js"></script>
<html>
