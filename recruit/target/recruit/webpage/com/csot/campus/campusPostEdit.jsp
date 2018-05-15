<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="/webpage/common.jsp" %>
  <title>Insert title here</title>
  <style>
    html, body {
      overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
    }

    fieldset {
      border: solid 1px #aaa;
      margin: 10px;
      font-size: 10px
    }

    .form-label {
      color: #888;
      display: inline-block;
      padding-left: 15px;
      font-size: 12px;
      font-family: 微软雅黑;
      width: 90px;
      align: left
    }

    .mini-textbox {
      width: 110px
    }

    table {
      line-height: 40px;
      position: relative;
    }
  </style>
</head>
<body>

<form id="form1" class="fieldset-body" method="post" enctype="multipart/form-data">
  <input id="id" name="id" class="mini-hidden" value="${campusPost.id}"/>
  <input id="postId" name="postId" class="mini-hidden" value="${campusPost.postId}"/>
  <input id="postName" name="postName" class="mini-hidden" value="${campusPost.postName}"/>
  <input id="jobFamily" name="jobFamily" class="mini-hidden" value="${campusPost.jobFamily}"/>
  <input id="organizationDesc" name="reserved1" class="mini-hidden" value="${campusPost.reserved1}"/>
  <input id="jobFamilyDesc" name="reserved2" class="mini-hidden" value="${campusPost.reserved2}"/>
  <div style="width: 700px; margin: 10px" align="center">
    <table class="form-table" border="0" align="center">
      <tr>
        <td class="form-label" style="width: 215px">职位族<span
                style="color: red">*</span>：${campusPost.reserved2}
        </td>
        <td class="form-label" style="width: 215px">岗位名称<span
                style="color: red">*</span>： ${campusPost.postName}
        </td>
        <td class="form-label" style="width: 215px">招聘数量： <input name="recruitQuantity"
                                                                 class="mini-spinner"
                                                                 style="width: 80px" minValue="0"
                                                                 maxValue="99999"
                                                                 value="${campusPost.recruitQuantity}"/>
        </td>
      </tr>
    </table>

    <fieldset class="fieldset" id="fd1"
              style="width: 700px; font-family: 微软雅黑; padding-bottom: 10px">
      <legend>
        <span style="font-size: 15px; align: center">基本信息</span>
      </legend>
      <table class="form-table" border="0" cellpadding="10" cellspacing="10">
        <tr>
          <td class="form-label">所属组织<span style="color: red">*</span>：
          </td>
          <td><input id="organization" class="mini-combobox" name="organization"
                     onvalidation="onComboValidation"
                     value="${campusPost.organization}" style="width: 120px;" valueField="typeId"
                     url="/recruit/datadictGroupTypeController/getDictsByCode/campus_company"
                     required="true" allowInput="true" textField="typeName" pinyinField="tag"
                     onvaluechanged="onOrganizationChanged()"></td>
          <td class="form-label">需求大中心<span style="color: red">*</span>：
          </td>
          <td><input name="bigCenter" class="mini-textbox" value="${campusPost.bigCenter}"
                     required="true"/></td>
          <td class="form-label">需求小中心<span style="color: red">*</span>：
          </td>
          <td><input name="smallCenter" class="mini-textbox" required="true"
                     value="${campusPost.smallCenter}"/></td>
        </tr>
        <tr>
          <td class="form-label">职位类<span style="color: red">*</span>：
          </td>
          <td><input id="jobClass" name="jobClass" class="mini-textbox" allowInput="false"
                     value="${campusPost.jobClass}" required="true"/></td>
          <td class="form-label">职位子类：</td>
          <td><input name="jobSubclass" class="mini-textbox"
                     value="${campusPost.jobSubclass}"/></td>
        </tr>
      </table>
    </fieldset>

    <fieldset class="fieldset" id="fd2"
              style="width: 700px; font-family: 微软雅黑; padding-bottom: 10px">
      <legend>
        <span style="font-size: 15px; align: center">招聘要求</span>
      </legend>
      <table class="form-table" border="0" cellpadding="10" cellspacing="10">
        <tr>
          <td class="form-label">学历建议<span style="color: red">*</span>：
          </td>
          <td><input name="educationAdvise" class="mini-textbox"
                     value="${campusPost.educationAdvise}" required="true"/></td>
          <td class="form-label">学校建议<span style="color: red">*</span>：
          </td>
          <td><input name="schoolAdvise" class="mini-textbox"
                     value="${campusPost.schoolAdvise}" required="true"/></td>
          <td class="form-label">性别建议：</td>
          <td><input name="sexAdvise" class="mini-textbox" value="${campusPost.sexAdvise}"/>
          </td>
        </tr>
        <tr>
          <td class="form-label">特殊要求：</td>
          <td><input name="otherDemand" class="mini-textbox"
                     value="${campusPost.otherDemand}"/></td>
          <td class="form-label">首选专业<span style="color: red">*</span>：
          </td>
          <td><input name="preferredMajor" class="mini-textbox"
                     value="${campusPost.preferredMajor}" required="true"/></td>
          <td class="form-label">备选专业<span style="color: red">*</span>：
          </td>
          <td><input name="alternativeMajor" class="mini-textbox"
                     value="${campusPost.alternativeMajor}" required="true"/></td>
        </tr>
      </table>
    </fieldset>
    <table style="line-height: 80px">
      <tr>
        <td class="form-label" style="width: 140px">职责描述：</td>
        <td><input name="postDescribe" class="mini-textarea"
                   value="${campusPost.postDescribe}" style="width: 400px; height: 60px;"/></td>
      </tr>
      <tr>
        <td class="form-label" style="width: 140px">特殊工作条件说明：</td>
        <td><input name="specialCondition" class="mini-textarea"
                   value="${campusPost.specialCondition}" style="width: 400px; height: 60px;"/></td>
      </tr>
    </table>
  </div>
  <div style="text-align: center; padding: 10px;">
    <a id="rtnBtn" class="mini-button" onclick="onCancel()"
       style="width: 80px; margin-right: 40px;">取消</a> <a class="mini-button" onclick="submitForm()"
                                                          style="width: 80px;">确定</a>
  </div>
</form>
<script type="text/javascript">
    mini.parse();
    var form = new mini.Form("form1");

    function submitForm() {
        form.validate();
        if (form.isValid() == false) {
            return;
        }
        SaveData("/recruit/campusPostController/save", $("#form1").serialize());
    }

    function onCancel(e) {
        CloseWindow("close", form);
    }

    function onOrganizationChanged() {
        var organizationDesc = mini.get("organization").getText();
        mini.get("organizationDesc").setValue(organizationDesc);
    }

    function onComboValidation(e) {
        var items = this.findItems(e.value);
        if (!items || items.length == 0) {
            e.isValid = false;
            e.errorText = "[" + e.value + "]" + "不在下拉数据中";
        }
    }
</script>

</body>
</html>