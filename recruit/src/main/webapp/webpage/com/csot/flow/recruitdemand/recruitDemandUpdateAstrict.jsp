<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/webpage/common.jsp"%>
<title>招聘需求申请</title>
<link rel="stylesheet" type="text/css"
  href="${webRoot}/resources/css/flow/recruitdemand/recruitDemandEdit.css?v=3" />
</head>
<body>
  <form id="form1" class="fieldset-body" method="post" enctype="multipart/form-data">
    <input id="id" name="id" class="mini-hidden" value="${recruitDemand.id}" title="申请岗位ID" /> <input
      id="applyPostId" name="applyPostId" class="mini-hidden" value="${recruitDemand.applyPostId}"
      title="申请岗位ID" /> <input id="applyOrganizationId" name="applyOrganizationId"
      class="mini-hidden" value="${recruitDemand.applyOrganizationId}" title="申请部门ID" />
    <div style="margin: 10px" align="center">
      <fieldset class="fieldset" id="fd1" style="font-family: 微软雅黑; padding-bottom: 10px">
        <legend>
          <span style="font-size: 15px; align: center">基本信息</span>
        </legend>
        <table class="form-table" border="0" cellpadding="10" cellspacing="10">
          <tr>
            <td class="form-label">主题<span style="color: red">*</span>：
            </td>
            <td><input id="theme" name="theme" class="mini-textbox"
              value="${recruitDemand.theme}" required="true" /></td>
            <td class="form-label">申请岗位<span style="color: red">*</span>：</td>
            <td><input name="applyPostName" id="applyPostName" class="mini-textbox"
              value="${recruitDemand.applyPostName}" required="true" readonly="readonly" /></td>
            <td class="form-label">申请部门<span style="color: red">*</span>：</td>
            <td><input name="applyOrganizationName" id="applyOrganizationName"
              class="mini-textbox" value="${recruitDemand.applyOrganizationName}" required="true"
              readonly="readonly" /></td>

          </tr>
          <tr>
            <td class="form-label">员工类别<span style="color: red">*</span>：
            </td>
            <td style="width: 140px;"><input class="mini-radiobuttonlist" textField="typeName"
              valueField="typeCode" name="employeeType" value="${recruitDemand.employeeType}"
              required="true" requiredErrorText="员工类别不能为空"
              url="/recruit/datadictGroupTypeController/getDictsByCode/employee_type_recruit_demand" /></td>
            <td class="form-label">境内境外<span style="color: red">*</span>：</td>
            <td><input class="mini-radiobuttonlist" textField="typeName" valueField="typeCode"
              name="district" value="${recruitDemand.district}" required="true"
              url="/recruit/datadictGroupTypeController/getDictsByCode/district_recruit_demand" /></td>
            <td class="form-label">招聘需求原因<span style="color: red">*</span>：
            </td>
            <td><input id="recruitDemandReason" class="mini-combobox"
              name="recruitDemandReason" value="${recruitDemand.recruitDemandReason}"
              valueField="typeCode"
              url="/recruit/datadictGroupTypeController/getDictsByCode/recruit_demand_reason"
              required="true" allowInput="true" textField="typeName" pinyinField="tag"
              onvaluechanged="onOrganizationChanged()" /></td>
          </tr>
          <tr>
            <td class="form-label">离职/转调人：
            </td>
            <td><input id="dimissionChangePerson" name="dimissionChangePerson"
              class="mini-textbox" value="${recruitDemand.dimissionChangePerson}" /></td>
            <td class="form-label">申请人数<span style="color: red">*</span>：</td>
            <td><input name="applyPersonNumber" changeOnMousewheel="false" class="mini-spinner"
              minValue="0" maxValue="100" onvaluechanged="onValueChanged"
              value="${recruitDemand.applyPersonNumber}" required="true" /><span class="copy-posi"
              onclick="updateApplyPersonNum('${recruitDemand.id}')"><span
                class="font-icon icon-edit-1 " title="修改申请人数"></span>修改</span></td>
            <td class="form-label">申请日期<span style="color: red">*</span>：</td>
            <td><input name="applyDate" value="${recruitDemand.applyDate}" readonly="readonly"
              id="applyDate" class="mini-datepicker"></input></td>
          </tr>
          <tr>
            <td class="form-label">职级<span style="color: red">*</span>：
            </td>
            <c:if test="${recruitDemand.employeeType ne '048-000' }">
              <td><input id="rankId" class="mini-combobox" name="rankId" valueField="typeCode"
                required="true" textField="typeName" onvaluechanged="getDateByRank"
                value="${recruitDemand.rankId}"
                url="/recruit/datadictGroupTypeController/getDictsByCode/rank_recruit_demand" /></td>
            </c:if>
            <c:if test="${recruitDemand.employeeType eq '048-000' }">
              <td><input id="rankId" class="mini-combobox" name="rankId" valueField="typeCode"
                required="true" textField="typeName" value="${recruitDemand.rankId}"
                url="/recruit/datadictGroupTypeController/getDictsByCode/siterank_recruit_demand" /></td>
            </c:if>
            <td class="form-label">预计到岗时间<span style="color: red">*</span>：</td>
            <td><input name="predictComeDate" id="predictComeDate" class="mini-textbox"
              value="${recruitDemand.predictComeDate}" required="true" readonly="readonly" /></td>
            <td class="form-label">期望到岗时间<span style="color: red">*</span>：</td>
            <td><input name="wantComeDate" class="mini-datepicker" ondrawdate="onDrawDate"
              value="${recruitDemand.wantComeDate}" required="true"></input><span class="copy-posi"
              onclick="updateWantTime('${recruitDemand.id}')"><span
                class="font-icon icon-edit-1 " title="修改期望到岗时间"></span>修改</span></td>
          </tr>
          <tr>
            <td class="form-label">岗位工作描述<span style="color: red">*</span>：
            </td>
            <td colspan="5"><input name="workRemark" id="workRemark" class="mini-textarea"
              value="${recruitDemand.workRemark}" style="width: 400px; height: 60px;"
              required="true" /><span class="copy-posi" onclick="choseHistory(1)"><span
                class="font-icon icon-list" title="历史工作描述"></span>选择</span></td>
          </tr>
        </table>
      </fieldset>
      <fieldset class="fieldset" id="fd2" style="font-family: 微软雅黑; padding-bottom: 10px">
        <legend>
          <span style="font-size: 15px; align: center">岗位任职条件</span>
        </legend>
        <table class="form-table" border="0" cellpadding="30" cellspacing="30">
          <tr>
            <td class="form-label">性别<span style="color: red">*</span>：
            </td>
            <td><input class="mini-radiobuttonlist" textField="typeName" valueField="typeCode"
              name="gender" required="true" requiredErrorText="员工类别不能为空"
              value="${recruitDemand.gender}"
              url="/recruit/datadictGroupTypeController/getDictsByCode/sex_recruit_demand" /></td>
            <td class="form-label">学历<span style="color: red">*</span>：</td>
            <td><input name="education" class="mini-textbox" required="true"
              value="${recruitDemand.education}" /></td>
            <td class="form-label">专业<span style="color: red">*</span>：</td>
            <td><input name="profession" class="mini-textbox" required="true"
              value="${recruitDemand.profession}" /></td>
          </tr>
          <tr>
            <td class="form-label">英语等级<span style="color: red">*</span>：</td>
            <td><input name="englishLevel" textField="typeName" valueField="typeName"
              class="mini-combobox" required="true" value="${recruitDemand.englishLevel}"
              url="/recruit/datadictGroupTypeController/getDictsByCode/english-level" /></td>
            <td class="form-label">年龄段<span style="color: red">*</span>：</td>
            <td colspan="3" style="display: none;"><input name="ageStart"
              changeOnMousewheel="false" class="mini-spinner" minValue="18"
              value="${recruitDemand.ageStart}" required="true" />-<input name="ageEnd"
              changeOnMousewheel="false" class="mini-spinner" minValue="18"
              value="${recruitDemand.ageEnd}" required="true" /></td>
            <td colspan="3">${recruitDemand.ageStart}~ ${recruitDemand.ageEnd}</td>
          </tr>
          <tr>
            <td class="form-label">工作经验<span style="color: red">*</span>：
            </td>
            <td colspan="5"><input name="workExperience" id="workExperience"
              class="mini-textarea" value="${recruitDemand.workExperience}"
              style="width: 400px; height: 60px;" required="true" /><span class="copy-posi"
              onclick="choseHistory(2)"><span class="font-icon icon-list" title="历史工作描述"></span>选择</span></td>
          </tr>
          <tr style="margin-top: 10px;">
            <td class="form-label">必备技能<span style="color: red">*</span>：
            </td>
            <td colspan="5"><input name="requiredSkill" id="requiredSkill"
              class="mini-textarea" value="${recruitDemand.requiredSkill}"
              style="width: 400px; height: 60px;" required="true" /><span class="copy-posi"
              onclick="choseHistory(3)"><span class="font-icon icon-list" title="历史工作描述"></span>选择</span></td>
          </tr>
          <tr style="margin-top: 10px;">
            <td class="form-label">素质及能力要求<span style="color: red">*</span>：
            </td>
            <td colspan="5"><input name="abilityDemanded" id="abilityDemanded"
              class="mini-textarea" value="${recruitDemand.abilityDemanded}"
              style="width: 400px; height: 60px;" required="true" /><span class="copy-posi"
              onclick="choseHistory(4)"><span class="font-icon icon-list" title="历史工作描述"></span>选择</span></td>
          </tr>
          <!--  <tr style="margin-top: 10px;">
            <td class="form-label">上传附件<span style="color: red">*</span>：
            </td>
            <td colspan="5"><input type="file" name="attachment" id="attachment" />
              &nbsp;&nbsp; <input type="button" onclick="uploadDemandFile()" class="button"
              style="padding: 5px;" value="上传" /></td>
          </tr> -->
          <tr style="margin-top: 10px;">
            <td class="form-label"></td>
            <td colspan="5"><input id="attchmentIds" type="hidden" name="attchmentIds" value="" />
              <div id="fileArea" class="fileArea">
                <span id="span1"></span><span id="span2"> <c:forEach items="${attachments}"
                    var="attachment">
                    <div id="div_${attachment.id}" class="fileStyle">
                      <%--   <input id="${attachment.id}" type="button"
                        onclick="delAttach('${attachment.id}',this)" value="删除" /> --%>
                      &nbsp;&nbsp;<a href="javascript:downloadAttach('${attachment.id}')"><span>
                          ${attachment.showName}</span></a>
                    </div>

                  </c:forEach>
                </span>
              </div></td>
          </tr>
        </table>
      </fieldset>
    </div>
    <div style="text-align: center; padding: 10px;">
      <a class="mini-button" onclick="submitForm('XG')" style="width: 80px; margin-right: 40px;">提交修改</a>
      <!--      <a class="mini-button" onclick="submitForm('TJ')" style="width: 80px; margin-right: 40px;">提交</a> -->
      <a id="rtnBtn" class="mini-button" onclick="onCancel()" style="width: 80px;">取消</a>
    </div>
  </form>



  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.zh_cn.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/resume/ajaxfileupload.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaAutoCompleteData.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaData.js"></script>
  <script type="text/javascript"
    src="${webRoot}/resources/js/flow/recruitdemand/recruitDemandEdit.js?v=1"></script>
  <script type="text/javascript">
      mini.parse();
      var form = new mini.Form("form1");
      var jsWebRoot = "${webRoot}";
      $(function() {
        labelModel();
      });
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
    </script>
</body>
</html>