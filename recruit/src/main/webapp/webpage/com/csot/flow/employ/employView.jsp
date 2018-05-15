<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/webpage/common.jsp"%>
<title>录用信息</title>
<link rel="stylesheet" type="text/css"
  href="${webRoot}/resources/css/flow/recruitdemand/recruitDemandEdit.css" />
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<style type="text/css">
.fileArea {
  width: 99%;
  height: 48px;
  overflow-y: auto;
}

.fileStyle {
  float: left;
  margin-top: 7px;
  margin-left: 10px;
}

hr {
  border: solid 1px !important;
  height: 0px !important;
}

.mini-datepicker .mini-buttonedit-border {
  border: none !important;
}
</style>
</head>
<body onload="removeLoad();">
  <jsp:include page="/webpage/header.jsp"></jsp:include>
  <div class="co">
    <div class="co-right">
      <div class="position-path co-right-center">
        <span class="path-title">您的位置 :</span><a class="path-item a-decoration"
          href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a
          class="path-item a-decoration">招聘流程</a><em class="path-icon">&gt;&gt;</em><span
          class="path-leaf">录用信息</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="con-title">录用信息</div>
        <div class="main">
          <form id="form1" class="fieldset-body" method="post" enctype="multipart/form-data">
            <div style="margin: 10px" align="center">
              <fieldset class="fieldset" id="fd1" style="font-family: 微软雅黑; padding-bottom: 10px">
                <legend>
                  <span style="font-size: 15px; align: center">招聘申请信息</span>
                </legend>
                <table class="form-table" border="0" cellpadding="10" cellspacing="10">
                  <tr>
                    <td class="form-label">招聘需求单号<span style="color: red">*</span>：
                    </td>
                    <td style="width: 240px;"><input id="demandId" name="demandId"
                      readonly="readonly" class="mini-textbox" value="${employ.demandId}"
                      required="true" /></td>
                    <td class="form-label">员工类别<span style="color: red">*</span>：
                    </td>
                    <td style="width: 140px;"><input class="mini-radiobuttonlist"
                      readonly="readonly" textField="typeName" valueField="typeCode"
                      name="employeeType" id="employeeType" value="${employDemand.employeeType}"
                      required="true" requiredErrorText="员工类别不能为空"
                      url="/recruit/datadictGroupTypeController/getDictsByCode/employee_type_recruit_demand" /></td>
                    <td class="form-label">境内境外<span style="color: red">*</span>：
                    </td>
                    <td><input class="mini-radiobuttonlist" textField="typeName" id="district"
                      valueField="typeCode" name="district" value="${employDemand.district}"
                      required="true" readonly="readonly"
                      url="/recruit/datadictGroupTypeController/getDictsByCode/district_recruit_demand" /></td>
                  </tr>
                  <tr>
                    <td class="form-label">申请部门<span style="color: red">*</span>：
                    </td>
                    <td><input name="applyOrganizationName" id="applyOrganizationName"
                      readonly="readonly" class="mini-textbox"
                      value="${employDemand.applyOrganizationName}" required="true"
                      readonly="readonly" /></td>
                    <td class="form-label">申请岗位<span style="color: red">*</span>：
                    </td>
                    <td><input name="applyPostName" id="applyPostName" class="mini-textbox"
                      value="${employDemand.applyPostName}" required="true" readonly="readonly" /></td>
                    <td class="form-label">职级<span style="color: red">*</span>：
                    </td>
                    <td><input id="rankId" class="mini-combobox" name="rankId"
                      valueField="typeCode" required="true" textField="typeName" readonly="readonly"
                      onvaluechanged="getDateByRank" value="${employDemand.rankId}"
                      url="/recruit/datadictGroupTypeController/getDictsByCode/rank_recruit_demand" /></td>
                  </tr>
                  <tr>
                    <td class="form-label">招聘需求原因<span style="color: red">*</span>：
                    </td>
                    <td><input id="recruitDemandReason" class="mini-combobox"
                      readonly="readonly" name="recruitDemandReason"
                      value="${employDemand.recruitDemandReason}" valueField="typeCode"
                      url="/recruit/datadictGroupTypeController/getDictsByCode/recruit_demand_reason"
                      required="true" allowInput="true" textField="typeName" pinyinField="tag"
                      onvaluechanged="onOrganizationChanged()" /></td>
                  </tr>
                </table>
              </fieldset>
              <fieldset class="fieldset" id="fd2" style="font-family: 微软雅黑; padding-bottom: 10px">
                <legend>
                  <span style="font-size: 15px; align: center">候选人信息</span>
                </legend>
                <table class="form-table" border="0" cellpadding="30" cellspacing="30">
                  <tr>
                    <td class="form-label">应聘申请单号<span style="color: red">*</span>：
                    </td>
                    <td style="width: 250px;"><input id="employmentForm" name="employmentForm"
                      readonly="readonly" class="mini-textbox" value="${employ.employmentForm}" /></td>
                    <td class="form-label">姓名<span style="color: red">*</span>：
                    </td>
                    <td><input id="name" name="name" class="mini-textbox" required="true"
                      value="${employCandidate.name}" /></td>
                    <td class="form-label">拼音<span style="color: red">*</span>：
                    </td>
                    <td><input name="pinyin" id="pinyin" class="mini-textbox" required="true"
                      value="${employCandidate.pinyin}" /></td>
                  </tr>
                  <tr>
                    <td class="form-label">英文名<span style="color: red">*</span>：
                    </td>
                    <td><input name="englishName" id="englishName" class="mini-textbox"
                      required="true" value="${employCandidate.englishName}" /></td>
                    <td class="form-label">是否竞业<span style="color: red">*</span>：
                    </td>
                    <td><input class="mini-radiobuttonlist" textField="typeName"
                      onvaluechanged="typeNameChange" valueField="typeCode" name="isDevote"
                      id="isDevote" required="true" requiredErrorText="员工类别不能为空"
                      value="${employCandidate.isDevote}"
                      data="[{typeCode:1,typeName:'是'},{typeCode:2,typeName:'否'}]" /></td>
                    <td class="form-label emailName">邮件名<span style="color: red">*</span>：
                    </td>
                    <td class="emailName"><input name="emailName" id="emailName"
                      class="mini-textbox" required="true" value="${employCandidate.emailName}" /></td>
                  </tr>
                  <tr>
                    <td class="form-label">性别<span style="color: red">*</span>：
                    </td>
                    <td><input class="mini-radiobuttonlist" textField="typeName"
                      valueField="typeCode" name="gender" id="gender" required="true"
                      requiredErrorText="性别不能为空" value="${employCandidate.gender}"
                      data="[{typeCode:0,typeName:'男'},{typeCode:1,typeName:'女'}]" /></td>
                    <td class="form-label">境内境外<span style="color: red">*</span>：
                    </td>
                    <td><input class="mini-radiobuttonlist" textField="typeName" id="abroad"
                      valueField="typeCode" name="abroad" value="${employCandidate.abroad}"
                      required="true"
                      url="/recruit/datadictGroupTypeController/getDictsByCode/district_recruit_demand" /></td>
                  </tr>
                  <tr>
                    <td class="form-label">出生年月<span style="color: red">*</span>：
                    </td>
                    <td><input name="birthday" id="birthday" class="mini-datepicker"
                      required="true" value="${employCandidate.birthday}" /></td>
                    <td class="form-label">电话<span style="color: red">*</span>：
                    </td>
                    <td><input name="phone" id="phone" class="mini-textbox" required="true"
                      value="${employCandidate.phone}" /></td>
                    <td class="form-label">邮箱<span style="color: red">*</span>：
                    </td>
                    <td><input name="email" id="email" class="mini-textbox" required="true"
                      value="${employCandidate.email}" /></td>
                  </tr>
                  <tr>
                    <td class="form-label">候选人类别<span style="color: red">*</span>：
                    </td>
                    <td style="width: 140px;"><input class="mini-radiobuttonlist"
                      textField="typeName" valueField="typeCode" name="candidateType"
                      id="candidateType" value="${employCandidate.candidateType}" required="true"
                      requiredErrorText="候选人类别不能为空" onvaluechanged="reloadRank"
                      url="/recruit/datadictGroupTypeController/getDictsByCode/employee_type_recruit_demand" /></td>
                    <td class="form-label">职级<span style="color: red">*</span>：
                    </td>

                    <c:if test="${employCandidate.candidateType ne '048-000' }">
                      <td><input id="employRankId" class="mini-combobox" name="employRankId"
                        valueField="typeCode" required="true" textField="typeName"
                        value="${employCandidate.employRankId}"
                        url="/recruit/datadictGroupTypeController/getDictsByCode/rank_recruit_demand" /></td>
                    </c:if>

                    <c:if test="${employCandidate.candidateType eq '048-000' }">
                      <td><input id="employRankId" class="mini-combobox" name="employRankId"
                        valueField="typeCode" required="true" textField="typeName"
                        value="${employCandidate.employRankId}"
                        url="/recruit/datadictGroupTypeController/getDictsByCode/siterank_recruit_demand" /></td>
                    </c:if>

                    <td class="form-label">候选人职等<span style="color: red">*</span>：
                    </td>
                    <td><input id="grade" class="mini-combobox" name="grade"
                      valueField="typeCode" required="true" textField="typeName"
                      value="${employCandidate.grade}"
                      url="/recruit/datadictGroupTypeController/getDictsByCode/employ_grade" /></td>
                  </tr>
                  <tr>
                    <td class="form-label">候选人岗位<span style="color: red">*</span>：
                    </td>
                    <td><input name="candidatePostName" id="candidatePostName"
                      readonly="readonly" class="mini-textbox" required="true"
                      value="${employCandidate.candidatePostName}" /></td>
                    <td class="form-label">岗位编码<span style="color: red">*</span>：
                    </td>
                    <td><input name="candidatePostId" id="candidatePostId" class="mini-textbox"
                      readonly="readonly" required="true" value="${employCandidate.candidatePostId}" /></td>
                    <td class="form-label">候选人部门<span style="color: red">*</span>：
                    </td>
                    <td><input name="candidateOrgName" id="candidateOrgName"
                      readonly="readonly" class="mini-textbox" required="true"
                      value="${employCandidate.candidateOrgName}" /></td>
                  </tr>
                  <tr>
                    <td class="form-label">推荐人工号：</td>
                    <td><input name="referrerId" id="referrerId" class="mini-textbox"
                      required="true" value="${employCandidate.referrerId}" /></td>
                    <td style="width: 130px" class="form-label">推荐人姓名&部门：</td>
                    <td><input name="referrerName" id="referrerName" class="mini-textbox"
                      required="true" value="${employCandidate.referrerName}" /></td>
                    <td class="form-label">招聘来源<span style="color: red">*</span>：
                    </td>
                    <td><input id="recruitSource" name="recruitSource" class="mini-treeselect"
                      value="${employCandidate.recruitSource}"
                      url="/recruit/resumeSourceController/datagrid" multiSelect="false"
                      textField="sourceName" valueField="id" parentField="parentId" /></td>
                  </tr>
                  <tr>
                    <td class="form-label">是否背调<span style="color: red">*</span>：
                    </td>
                    <td><input class="mini-radiobuttonlist" textField="typeName"
                      valueField="typeCode" name="isBeidiao" id="isBeidiao" required="true"
                      requiredErrorText="员工类别不能为空" value="${employCandidate.isBeidiao}"
                      data="[{typeCode:1,typeName:'是'},{typeCode:2,typeName:'否'}]" /></td>
                    <td class="form-label">是否测评<span style="color: red">*</span>：
                    </td>
                    <td><input class="mini-radiobuttonlist" textField="typeName"
                      valueField="typeCode" name="isEvaluating" id="isEvaluating" required="true"
                      requiredErrorText="员工类别不能为空" value="${employCandidate.isEvaluating}"
                      data="[{typeCode:1,typeName:'是'},{typeCode:2,typeName:'否'}]" /></td>

                    <td class="form-label">拟入职时间<span style="color: red">*</span>：
                    </td>
                    <td><input name="simulationEntryDate" id="simulationEntryDate"
                      class="mini-datepicker" required="true" value="${employ.simulationEntryDate}" /></td>
                  </tr>
                  <%--  <tr style="margin-top: 10px;">
                    <td class="form-label">上传附件<span style="color: red">*</span>：
                    </td>
                    <td colspan="5"><input type="file" name="attachment" id="attachment" />
                      &nbsp;&nbsp; <input type="button" onclick="uploadDemandFile()" class="button"
                      style="padding: 5px;" value="上传" /></td>
                  </tr> --%>
                  <tr style="margin-top: 10px;">
                    <td class="form-label">
                      <!-- 附件列表<span style="color: red">*</span>： -->
                    </td>
                    <td colspan="5"><input id="attchmentIds" type="hidden" name="attchmentIds" />
                      <div id="fileArea" class="fileArea">
                        <span id="span1"></span><span id="span2"> <c:forEach
                            items="${attachments}" var="attachment">
                            <div id="div_${attachment.id}" class="fileStyle">
                              <input id="${attachment.id}" type="button"
                                onclick="delAttach('${attachment.id}',this)" value="删除" />&nbsp;&nbsp;<a
                                href="javascript:downloadAttach('${attachment.id}')"><span>
                                  ${attachment.showName}</span></a>
                            </div>
                          </c:forEach>
                        </span>
                      </div></td>
                  </tr>
                </table>
              </fieldset>
              <fieldset class="fieldset" id="fd3" style="font-family: 微软雅黑; padding-bottom: 10px">
                <legend>

                  <span style="font-size: 15px; align: center">教育经历(从高到低填写)<c:if
                      test="${empty employ.employmentForm}">
                      <span id="addEducation" class="copy-posi" onclick="addJiaoYu()">&nbsp;&nbsp;
                        <span class="font-icon icon-add-new" title="添加教育经历"></span>添加
                      </span>
                    </c:if></span> <input id="jiaoyu" type="hidden" name="jiaoyu" value="" />
                </legend>
                <c:if test="${not empty employEducations}">
                  <c:forEach var="edu" items="${ employEducations }" varStatus="status">
                    <c:set var="i" value="${status.index }"></c:set>
                    <table class="form-table jiaoYuTable jiaoYuTable${i}" border="0"
                      cellpadding="10" cellspacing="10">
                      <tr>
                        <td class="form-label">开始时间<span style="color: red">*</span>：
                        </td>
                        <td><input class="mini-datepicker" name="startDate" id="startDate${i}"
                          value="${ edu.startDate }" /></td>
                        <td class="form-label">结束时间<span style="color: red">*</span>：
                        </td>
                        <td><input class="mini-datepicker" name="endDate" id="endDate${i}"
                          value="${ edu.endDate }" /></td>
                        <td class="form-label">毕业院校<span style="color: red">*</span>：
                        </td>
                        <td><input class="mini-textbox" name="school" id="school${i}"
                          value="${ edu.school }" /></td>
                      </tr>
                      <tr>
                        <td class="form-label">专业<span style="color: red">*</span>：
                        </td>
                        <td><input class="mini-textbox" name="major" id="major${i}"
                          value="${ edu.major }" /></td>
                        <td class="form-label">学历<span style="color: red">*</span>：
                        </td>
                        <td><t:dictSelect labelClass="interview" type="select"
                            id="education${i}" field="education" defaultVal="${ edu.education}"
                            typeGroupCode="educational-background" hasLabel="false"></t:dictSelect></td>
                        <td class="form-label">学历性质<span style="color: red">*</span>：
                        </td>
                        <td><t:dictSelect labelClass="interview" type="select"
                            defaultVal="${ edu.educationType }" id="educationType${i}"
                            field="eduType" domClass="educationalType"
                            typeGroupCode="educational-type" hasLabel="false"></t:dictSelect></td>
                      </tr>
                      <c:if test="${empty employ.employmentForm}">
                        <tr>
                          <td class="form-label"><span class="copy-posi"
                            onclick="removeTableJy(${i})"> <span
                              class="font-icon icon-remove-new" title="移除"></span>移除
                          </span></td>
                        </tr>
                      </c:if>
                    </table>
                  </c:forEach>
                </c:if>
                <c:if test="${ empty employEducations}">
                  <table class="form-table jiaoYuTable jiaoYuTable0" border="0" cellpadding="10"
                    cellspacing="10">
                    <tr>
                      <td class="form-label">开始时间<span style="color: red">*</span>：
                      </td>
                      <td><input class="mini-datepicker" name="startDate" id="startDate0" /></td>
                      <td class="form-label">结束时间<span style="color: red">*</span>：
                      </td>
                      <td><input class="mini-datepicker" name="endDate" id="endDate0" /></td>
                      <td class="form-label">毕业院校<span style="color: red">*</span>：
                      </td>
                      <td><input class="mini-textbox" name="school" id="school0" /></td>
                    </tr>
                    <tr>
                      <td class="form-label">专业<span style="color: red">*</span>：
                      </td>
                      <td><input class="mini-textbox" name="major" id="major0" /></td>
                      <td class="form-label">学历<span style="color: red">*</span>：
                      </td>
                      <td><t:dictSelect labelClass="interview" type="select" id="education0"
                          field="education" typeGroupCode="educational-background" hasLabel="false"></t:dictSelect></td>
                      <td class="form-label">学历性质<span style="color: red">*</span>：
                      </td>
                      <td><t:dictSelect labelClass="interview" type="select"
                          id="educationType0" field="eduType" domClass="educationalType"
                          typeGroupCode="educational-type" hasLabel="false"></t:dictSelect></td>
                    </tr>
                    <c:if test="${empty employ.employmentForm}">
                      <tr>
                        <td class="form-label"><span class="copy-posi"
                          onclick="removeTableJy(0)"> <span class="font-icon icon-remove-new"
                            title="移除"></span>移除
                        </span></td>
                      </tr>
                    </c:if>
                  </table>
                </c:if>


              </fieldset>
              <fieldset class="fieldset" id="fd4" style="font-family: 微软雅黑; padding-bottom: 10px">
                <legend>
                  <span style="font-size: 15px; align: center">工作经历(请从最近工作填写2-3份)<c:if
                      test="${empty employ.employmentForm}">
                      <span id="addWork" class="copy-posi" onclick="addGz()">&nbsp;&nbsp;<span
                        class="font-icon icon-add-new" title="添加工作经历"></span>添加
                      </span>
                    </c:if></span> <input id="work" type="hidden" name="work" value="" />
                </legend>
                <c:if test="${not empty employWorks}">
                  <c:forEach var="work" items="${ employWorks }" varStatus="status">
                    <c:set var="i" value="${status.index }"></c:set>
                    <table class="form-table gzTable gzTable${i}" border="0" cellpadding="10"
                      cellspacing="10">
                      <tr>
                        <td class="form-label">开始时间<span style="color: red">*</span>：
                        </td>
                        <td><input class="mini-datepicker" name="tstartDate"
                          value="${work.startDate}" id="tstartDate${i}" /></td>
                        <td class="form-label">结束时间<span style="color: red">*</span>：
                        </td>
                        <td><input class="mini-datepicker" name="tendDate" id="tendDate${i}"
                          value="${work.endDate}" /></td>
                        <td class="form-label">任职公司<span style="color: red">*</span>：
                        </td>
                        <td><input class="mini-textbox" name="company" id="company${i}"
                          value="${work.company}" /></td>
                      </tr>
                      <tr>
                        <td class="form-label">职位<span style="color: red">*</span>：
                        </td>
                        <td><input class="mini-textbox" name="post" id="post${i}"
                          value="${work.post}" /></td>
                        <c:if test="${empty employ.employmentForm}">
                          <td class="form-label"><span class="copy-posi"
                            onclick="removeTableGz(${i})"> <span
                              class="font-icon icon-remove-new" title="移除"></span>移除
                          </span></td>
                        </c:if>
                      </tr>
                    </table>
                  </c:forEach>
                </c:if>
                <c:if test="${empty employWorks}">
                  <table class="form-table gzTable gzTable0" border="0" cellpadding="10"
                    cellspacing="10">
                    <tr>
                      <td class="form-label">开始时间<span style="color: red">*</span>：
                      </td>
                      <td><input class="mini-datepicker" name="tstartDate" id="tstartDate0" /></td>
                      <td class="form-label">结束时间<span style="color: red">*</span>：
                      </td>
                      <td><input class="mini-datepicker" name="tendDate" id="tendDate0" /></td>
                      <td class="form-label">任职公司<span style="color: red">*</span>：
                      </td>
                      <td><input class="mini-textbox" name="company" id="company0" /></td>
                    </tr>
                    <tr>
                      <td class="form-label">职位<span style="color: red">*</span>：
                      </td>
                      <td><input class="mini-textbox" name="post" id="post0" /></td>
                      <c:if test="${empty employ.employmentForm}">
                        <td class="form-label"><span class="copy-posi"
                          onclick="removeTableGz(0)"> <span class="font-icon icon-remove-new"
                            title="移除"></span>移除
                        </span></td>
                      </c:if>
                    </tr>
                  </table>
                </c:if>

              </fieldset>
            </div>
            <div style="text-align: center; padding: 10px;">
              <c:if test="${employ.flowState eq '1'}">
                <a class="mini-button" onclick="submitForm('ZC')"
                  style="width: 80px; margin-right: 40px;">暂存</a>
                <a class="mini-button" onclick="submitForm('TJ')"
                  style="width: 80px; margin-right: 40px;">提交</a>
              </c:if>
              <a id="rtnBtn" class="mini-button" onclick="onCancel()" style="width: 100px;">返回录用列表</a>
            </div>
            <input id="id" name="id" class="mini-hidden" value="${employCandidate.id}" /> <input
              id="employDemandId" name="employDemandId" class="mini-hidden"
              value="${employDemand.id}" /><input id="employId" name="employId" class="mini-hidden"
              value="${employ.id}" /><input id="candidateOrgId" name="candidateOrgId"
              class="mini-hidden" value="${employCandidate.candidateOrgId}" title="申请部门ID" />
          </form>
        </div>
      </div>
    </div>
  </div>
  <jsp:include page="/webpage/footer.jsp"></jsp:include>
  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.zh_cn.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/resume/ajaxfileupload.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaAutoCompleteData.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaData.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/flow/employ/employEdit.js"></script>

  <script type="text/javascript">
      mini.parse();
      var jsWebRoot = "${webRoot}";
      var educationSize="${employEducationsSize}";
      var worksSize="${employWorksSize}";
      
      var form = new mini.Form("form1");
      function labelModel() {
        var fields = form.getFields();
        for (var i = 0, l = fields.length; i < l; i++) {
          var c = fields[i];
          if (c.name != "workExperience" && c.name != "requiredSkill"
              && c.name != "abilityDemanded" && c.name != "workRemark") {
            if (c.setReadOnly) {
              c.setReadOnly(true); //只读
            }
            if (c.setIsValid) {
              c.setIsValid(true); //去除错误提示
            }
            if (c.addCls) {
              c.addCls("asLabel"); //增加asLabel外观
            }
          }

        }
      }

      // 添加教育经历项
      function addJiaoYu() {
        var eduHTML = '<table class="form-table jiaoYuTable jiaoYuTable'+_jiaoyuindex+'" border="0" cellpadding="10" cellspacing="10">'
            + '<tr><td class="form-label">开始时间<span style="color: red">*</span>： </td><td><input class="mini-datepicker" name="startDate" id="startDate'+_jiaoyuindex+'" /></td>'
            + '<td class="form-label">结束时间<span style="color: red">*</span>： </td> <td><input class="mini-datepicker"/ name="endDate" id="endDate'+_jiaoyuindex+'"></td>'
            + '<td class="form-label">毕业院校<span style="color: red">*</span>：</td> <td><input class="mini-textbox" name="school" id="school'+_jiaoyuindex+'"/></td> </tr><tr> '
            + '<td class="form-label">专业<span style="color: red">*</span>：</td> <td><input class="mini-textbox" name="major" id="major'+_jiaoyuindex+'" /></td>'
            + '<td class="form-label">学历<span style="color: red">*</span>：</td> <td><t:dictSelect labelClass="interview" type="select" id="education'
            + _jiaoyuindex
            + '" field="education" typeGroupCode="educational-background" defaultVal="${ edu.education }" hasLabel="false"></t:dictSelect></td>'
            + '<td class="form-label">学历性质<span style="color: red">*</span>：</td><td><t:dictSelect labelClass="interview" type="select" id="educationType'
            + _jiaoyuindex
            + '" field="eduType" domClass="educationalType" typeGroupCode="educational-type" defaultVal="${ edu.eduType }" hasLabel="false"></t:dictSelect></td></tr> <tr> <td class="form-label"><span class="copy-posi" onclick="removeTableJy('
            + _jiaoyuindex
            + ')"> <span class="font-icon icon-remove-new" title="移除"></span>移除</span></td> </tr> </table>';
        $("#fd3").append(eduHTML);
        _jiaoyuindexs.push(_jiaoyuindex);
        _jiaoyuindex++;
        mini.parse();
      }

      // 添加工作经历项
      function addGz() {
        /* $("#fd4").append($("#gzTable").html().replace(/_gzindex/g, _gzindex));
        _gzindex++; */
        var eduHTML = '<table class="form-table gzTable gzTable'+_gzindex+'" border="0" cellpadding="10" cellspacing="10">'
            + ' <tr><td class="form-label">开始时间<span style="color: red">*</span>： </td> <td><input class="mini-datepicker" name="tstartDate" id="tstartDate'+_gzindex+'" /></td>'
            + '<td class="form-label">结束时间<span style="color: red">*</span>：</td><td><input class="mini-datepicker" name="tendDate" id="tendDate'+_gzindex+'" /></td>'
            + '<td class="form-label">任职公司<span style="color: red">*</span>：</td><td><input class="mini-textbox" name="company" id="company'+_gzindex+'" /></td></tr>'
            + '<tr><td class="form-label">职位<span style="color: red">*</span>：</td><td><input class="mini-textbox" name="post" id="post'+_gzindex+'" /></td>'
            + '<td class="form-label"><span class="copy-posi" onclick="removeTableGz('
            + _gzindex
            + ')"><span class="font-icon icon-remove-new" title="移除"></span>移除</span></td></tr></table>';

        $("#fd4").append(eduHTML);
        _gzindexs.push(_gzindex);
        _gzindex++;
        mini.parse();
      }
      

   // 获取应聘申请教育经历和工作经历
   function getEduAndWorkBy(e) {
     $("#addEducation").hide();
     $("#addWork").hide();
     $(".jiaoYuTable").remove();
     $(".gzTable").remove();
     _jiaoyuindex = 0; // 教育经历id
     _gzindex = 0;// 工作经历id
     _jiaoyuindexs = new Array();
     _gzindexs = new Array();
     for(var i=0;i<e.edus.length;i++){
       var eduHTML = '<table class="form-table jiaoYuTable jiaoYuTable'+_jiaoyuindex+'" border="0" cellpadding="10" cellspacing="10">'
       + '<tr><td class="form-label">开始时间<span style="color: red">*</span>： </td><td><input class="mini-datepicker" value="'+e.edus[i].startDate+'" name="startDate" id="startDate'+_jiaoyuindex+'" /></td>'
       + '<td class="form-label">结束时间<span style="color: red">*</span>： </td> <td><input class="mini-datepicker"  value="'+e.edus[i].endDate+'" name="endDate" id="endDate'+_jiaoyuindex+'"></td>'
       + '<td class="form-label">毕业院校：</td> <td><input class="mini-textbox" name="school"  value="'+e.edus[i].school+'" id="school'+_jiaoyuindex+'"/></td> </tr><tr> '
       + '<td class="form-label">专业<span style="color: red">*</span>：</td> <td><input class="mini-textbox" name="major" value="'+e.edus[i].major+'" id="major'+_jiaoyuindex+'" /></td>'
       + '<td class="form-label">学历<span style="color: red">*</span>：</td> <td><t:dictSelect labelClass="interview" type="select" id="education'
       + _jiaoyuindex
       + '" field="education" typeGroupCode="educational-background" defaultVal="'+e.edus[i].education+'" hasLabel="false"></t:dictSelect></td>'
       + '<td class="form-label">学历性质：</td><td><t:dictSelect labelClass="interview" type="select" id="educationType'
       + _jiaoyuindex
       + '" field="eduType" domClass="educationalType" typeGroupCode="educational-type" defaultVal="'+e.edus[i].educationType+'" hasLabel="false"></t:dictSelect></td></tr> <tr> <td class="form-label"></td> </tr> </table>';
   	   $("#fd3").append(eduHTML);
   	   _jiaoyuindexs.push(_jiaoyuindex);
   	   _jiaoyuindex++;
     }
     for(var i=0;i<e.works.length;i++){
       var eduHTML = '<table class="form-table gzTable gzTable'+_gzindex+'" border="0" cellpadding="10" cellspacing="10">'
       + ' <tr><td class="form-label">开始时间<span style="color: red">*</span>： </td> <td><input class="mini-datepicker" value="'+e.works[i].startDate+'" name="tstartDate" id="tstartDate'+_gzindex+'" /></td>'
       + '<td class="form-label">结束时间<span style="color: red">*</span>：</td><td><input class="mini-datepicker" value="'+e.works[i].endDate+'" name="tendDate" id="tendDate'+_gzindex+'" /></td>'
       + '<td class="form-label">任职公司<span style="color: red">*</span>：</td><td><input class="mini-textbox" value="'+e.works[i].company+'" name="company" id="company'+_gzindex+'" /></td></tr>'
       + '<tr><td class="form-label">职位<span style="color: red">*</span>：</td><td><input class="mini-textbox" value="'+e.works[i].post+'" name="post" id="post'+_gzindex+'" /></td>'
       + '<td class="form-label"></td></tr></table>';

       $("#fd4").append(eduHTML);
       _gzindexs.push(_gzindex);
       _gzindex++;
     }
     mini.parse();
   }
   
   $(function(){
     labelModel();
   });
   
    </script>
</body>
</html>
