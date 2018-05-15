<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/webpage/common.jsp"%>
<style type="text/css">
.asLabel .mini-textbox-border, .asLabel .mini-textbox-input, .asLabel .mini-buttonedit-border,
  .asLabel .mini-buttonedit-input, .asLabel .mini-textboxlist-border {
  border: 0;
  background: none;
  cursor: default;
}

.asLabel .mini-buttonedit-button, .asLabel .mini-textboxlist-close {
  display: none;
}

.asLabel .mini-textboxlist-item {
  padding-right: 8px;
}
</style>

<title>招聘需求申请</title>
<link rel="stylesheet" type="text/css"
  href="${webRoot}/resources/css/flow/recruitdemand/recruitDemandEdit.css" />
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
            <td class="form-label">申请部门：</td>
            <td><input name="applyOrganizationName" id="applyOrganizationName"
              class="mini-textbox" value="${recruitDemand.applyOrganizationName}" required="true"
              readonly="readonly" /></td>
            <td class="form-label">申请岗位：</td>
            <td><input name="applyPostName" id="applyPostName" class="mini-textbox"
              value="${recruitDemand.applyPostName}" required="true" readonly="readonly" /><a
              style="width: 10px;" href="javascript:void(0)" class="form-label-span"
              onclick="choseJob()"><span class="font-icon icon-reply-all copy-posi" title="选择岗位"></span></a></td>
          </tr>
          <tr>
            <td class="form-label">员工类别<span style="color: red">*</span>：
            </td>
            <td style="width: 140px;"><input class="mini-radiobuttonlist" textField="typeName"
              valueField="typeId" name="employeeType" value="${recruitDemand.employeeType}"
              required="true" requiredErrorText="员工类别不能为空"
              url="/recruit/datadictGroupTypeController/getDictsByCode/employee_type_recruit_demand" /></td>
            <td class="form-label">境内境外：</td>
            <td><input class="mini-radiobuttonlist" textField="typeName" valueField="typeId"
              name="district" value="${recruitDemand.district}" required="true"
              url="/recruit/datadictGroupTypeController/getDictsByCode/district_recruit_demand" /></td>
            <td class="form-label">招聘需求原因<span style="color: red">*</span>：
            </td>
            <td><input id="recruitDemandReason" class="mini-combobox"
              name="recruitDemandReason" onvalidation="onComboValidation"
              value="${recruitDemand.recruitDemandReason}" valueField="typeId"
              url="/recruit/datadictGroupTypeController/getDictsByCode/recruit_demand_reason"
              required="true" allowInput="true" textField="typeName" pinyinField="tag"
              onvaluechanged="onOrganizationChanged()" /></td>
          </tr>
          <tr>
            <td class="form-label">离职/转调人<span style="color: red">*</span>：
            </td>
            <td><input id="dimissionChangePerson" name="dimissionChangePerson"
              class="mini-textbox" value="${recruitDemand.dimissionChangePerson}" /></td>
            <td class="form-label">申请人数：</td>
            <td><input name="applyPersonNumber" changeOnMousewheel="false" class="mini-spinner"
              minValue="1" maxValue="100" onvaluechanged="onValueChanged"
              value="${recruitDemand.applyPersonNumber}" required="true" /></td>
            <td class="form-label">申请日期：</td>
            <td><input name="applyDate" value="${recruitDemand.applyDate}" id="applyDate"  readonly="readonly"
              class="mini-datepicker"></input></td>
          </tr>
          <tr>
            <td class="form-label">职级<span style="color: red">*</span>：
            </td>
            <td><input id="rankId" class="mini-combobox" name="rankId" valueField="typeId"
              required="true" textField="typeName" onvaluechanged="getDateByRank"
              value="${recruitDemand.rankId}"
              url="/recruit/datadictGroupTypeController/getDictsByCode/rank_recruit_demand" /></td>
            <td class="form-label">预计到岗时间：</td>
            <td><input name="predictComeDate" id="predictComeDate" class="mini-textbox"
              value="${recruitDemand.predictComeDate}" required="true" readonly="readonly" /></td>
            <td class="form-label">期望到岗时间：</td>
            <td><input name="wantComeDate" class="mini-datepicker"
              value="${recruitDemand.wantComeDate}" required="true"></input></td>
          </tr>
          <tr>
            <td class="form-label">岗位工作描述<span style="color: red">*</span>：
            </td>
            <td colspan="5"><input name="workRemark" class="mini-textarea"
              value="${recruitDemand.workRemark}" style="width: 400px; height: 60px;"
              required="true" /></td>
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
            <td><input class="mini-radiobuttonlist" textField="typeName" valueField="typeId"
              name="gender" required="true" requiredErrorText="员工类别不能为空"
              value="${recruitDemand.gender}"
              url="/recruit/datadictGroupTypeController/getDictsByCode/sex_recruit_demand" /></td>
            <td class="form-label">学历：</td>
            <td><input name="education" class="mini-textbox" required="true"
              value="${recruitDemand.education}" /></td>
            <td class="form-label">专业：</td>
            <td><input name="profession" class="mini-textbox" required="true"
              value="${recruitDemand.profession}" /></td>
          </tr>
          <tr>
            <td class="form-label">工作经验<span style="color: red">*</span>：
            </td>
            <td colspan="5"><input name="workExperience" class="mini-textarea"
              value="${recruitDemand.workExperience}" style="width: 400px; height: 60px;"
              required="true" /></td>
          </tr>
          <tr style="margin-top: 10px;">
            <td class="form-label">必备技能<span style="color: red">*</span>：
            </td>
            <td colspan="5"><input name="requiredSkill" class="mini-textarea"
              value="${recruitDemand.requiredSkill}" style="width: 400px; height: 60px;"
              required="true" /></td>
          </tr>
          <tr style="margin-top: 10px;">
            <td class="form-label">素质及能力要求<span style="color: red">*</span>：
            </td>
            <td colspan="5"><input name="abilityDemanded" class="mini-textarea"
              value="${recruitDemand.abilityDemanded}" style="width: 400px; height: 60px;"
              required="true" /></td>
          </tr>
        </table>
      </fieldset>
    </div>
    <div style="text-align: center; padding: 10px;">
      <a class="mini-button" onclick="submitForm('ZC')" style="width: 80px; margin-right: 40px;">暂存</a>
      <a class="mini-button" onclick="submitForm('TJ')" style="width: 80px; margin-right: 40px;">提交</a>
      <a id="rtnBtn" class="mini-button" onclick="onCancel()" style="width: 80px;">取消</a> <a
        id="rtnBtn" class="mini-button" onclick="labelModel()" style="width: 80px;">只读</a>
    </div>
  </form>

  <script type="text/javascript">
      mini.parse();
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
    </script>
  <script type="text/javascript"
    src="${webRoot}/resources/js/flow/recruitdemand/recruitDemandEdit.js?v=1"></script>
</body>
</html>