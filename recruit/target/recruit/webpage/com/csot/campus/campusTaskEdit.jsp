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

    .fieldset {
      border: solid 1px #aaa;
      margin: 10px;
      font-size: 10px;
      width: 700px;
      font-family: 微软雅黑;
      padding-bottom: 10px
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

    .mini-combobox {
      width: 110px;
    }

    .mini-spinner {
      width: 110px;
    }

    .mini-textarea {
      height: 40px;
      width: 540px;
    }

    table {
      line-height: 40px;
      position: relative;
    }

  </style>
</head>
<body>
<form id="form1" class="fieldset-body" method="post" enctype="multipart/form-data">
  <input id="id" name="id" class="mini-hidden" value="${campusTask.id}"/>
  <input id="postId" name="postId" class="mini-hidden" value="${campusTask.postId}"/>
  <input id="postName" name="postName" class="mini-hidden" value="${campusTask.postName}"/>
  <input id="siteId" name="siteId" class="mini-hidden" value="${campusTask.siteId}"/>
  <input id="siteName" name="siteName" class="mini-hidden" value="${campusTask.siteName}"/>
  <input id="organization" name="organization" class="mini-hidden" value="${campusTask.organization}"/>
  <input id="orgName" name="orgName" class="mini-hidden" value="${campusTask.orgName}"/>
  <input id="jobFamily" name="jobFamily" class="mini-hidden" value="${campusTask.jobFamily}"/>
  <input id="jobClass" name="jobClass" class="mini-hidden" value="${campusTask.jobClass}"/>
  <input id="bigCenter" name="bigCenter" class="mini-hidden" value="${campusTask.bigCenter}"/>
  <input id="smallCenter" name="smallCenter" class="mini-hidden" value="${campusTask.smallCenter}"/>
  <input id="department" name="department" class="mini-hidden" value="${campusTask.department}"/>
  <input id="branch" name="branch" class="mini-hidden" value="${campusTask.branch}"/>
  <input id="jobSubclass" name="jobSubclass" class="mini-hidden" value="${campusTask.jobSubclass}"/>
  <div style="width: 700px; margin: 10px" align="center">
    <fieldset class="fieldset" id="fd1">
      <legend>
        <span style="font-size: 15px; align: center">基本信息</span>
      </legend>
      <table class="form-table" border="0" cellpadding="10" cellspacing="10">
        <tr>
          <td class="form-label">站点<span style="color: red">*</span>：
          </td>
          <td><span style="font-size: 13px; font-family: 微软雅黑">${campusTask.siteName}</span></td>
          <td class="form-label">所属组织<span style="color: red">*</span>：
          </td>
          <td><span style="font-size: 13px; font-family: 微软雅黑">${campusTask.orgName}</span></td>
          <td class="form-label">大中心<span style="color: red">*</span>：
          </td>
          <td><span style="font-size: 13px; font-family: 微软雅黑">${campusTask.bigCenter}</span></td>
        </tr>
        <tr>
          <td class="form-label">厂/小中心<span style="color: red">*</span>：
          </td>
          <td><span style="font-size: 13px; font-family: 微软雅黑">${campusTask.smallCenter}</span></td>
          <td class="form-label">部门<span style="color: red">*</span>：
          </td>
          <td><span style="font-size: 13px; font-family: 微软雅黑">${campusTask.department}</span></td>
          <td class="form-label">科室<span style="color: red">*</span>：
          </td>
          <td><span style="font-size: 13px; font-family: 微软雅黑">${campusTask.branch}</span></td>
        </tr>
        <tr>
          <td class="form-label">职位族<span style="color: red">*</span>：</td>
          <td><span style="font-size: 13px; font-family: 微软雅黑">${campusTask.jobFamily}</span></td>
          <td class="form-label">职位类<span style="color: red">*</span>：</td>
          <td><span style="font-size: 13px; font-family: 微软雅黑">${campusTask.postName}</span></td>
          <td class="form-label">职位子类：</td>
          <td><span style="font-size: 13px; font-family: 微软雅黑">${campusTask.jobSubclass}</span></td>
        </tr>
        <tr>
          <td class="form-label">职责描述：</td>
          <td colspan="5"><input name="jobDescribe" class="mini-textarea"
                                 value="${campusTask.jobDescribe}"/></td>
        </tr>
      </table>
    </fieldset>

    <fieldset class="fieldset" id="fd2">
      <legend>
        <span style="font-size: 15px; align: center">任务要求</span>
      </legend>
      <table class="form-table" border="0" cellpadding="10" cellspacing="10">
        <tr>
          <td class="form-label">总人数<span style="color: red">*</span>：</td>
          <td><input id="taskNumberSum" class="mini-spinner" value="${campusTask.taskNumberSum}" name="taskNumberSum"
                     minValue="0" maxValue="99999"/></td>
          <td class="form-label">最高学历<span style="color: red">*</span>：</td>
          <td><span style="font-size: 13px; font-family: 微软雅黑">${campusTask.reserved1}</span></td>
          <td class="form-label">夜班频率<span style="color: red">*</span>：</td>
          <td><input name="nightShift" class="mini-textbox"
                     value="${campusTask.nightShift}" required="true"/></td>
        </tr>
        <tr>
          <td class="form-label">无尘室频率<span style="color: red">*</span>：</td>
          <td><input name="dustFree" class="mini-textbox"
                     value="${campusTask.dustFree}" required="true"/></td>
          <td class="form-label">首选专业<span style="color: red">*</span>：</td>
          <td><input name="preferredMajor" class="mini-textbox"
                     value="${campusTask.preferredMajor}" required="true"/></td>
          <td class="form-label">备选专业<span style="color: red">*</span>：</td>
          <td><input name="alternativeMajor" class="mini-textbox"
                     value="${campusTask.alternativeMajor}" required="true"/></td>
        </tr>
        <tr>
          <td class="form-label">特殊要求：</td>
          <td><input name="specialRequire" class="mini-textbox"
                     value="${campusTask.specialRequire}"/></td>
          <td class="form-label">男（可选）：</td>
          <td><input id="taskNumberMail" class="mini-spinner" value="${campusTask.taskNumberMail}" name="taskNumberMail"
                     minValue="0" maxValue="99999"/></td>
          <td class="form-label">女（可选）：</td>
          <td><input id="taskNumberFemail" class="mini-spinner" value="${campusTask.taskNumberFemail}"
                     name="taskNumberFemail" minValue="0" maxValue="99999"/>
          </td>
        </tr>
        <tr>
          <td class="form-label">备注：</td>
          <td colspan="5"><input name="remark" class="mini-textarea" value="${campusTask.remark}"/>
          </td>
        </tr>
      </table>
    </fieldset>
  </div>
  <div style="text-align: center; padding: 10px;">
    <a id="rtnBtn" class="mini-button" onclick="onCancel()"
       style="width: 70px; margin-right: 40px;">取消</a> <a class="mini-button" onclick="submitForm()"
                                                          style="width: 70px;">确定</a>
  </div>
</form>
<script type="text/javascript">
  mini.parse();
  var form = new mini.Form("form1");
  function submitForm() {
    // 校验总人数>=男+女
    var sum = mini.get("taskNumberSum").getValue();
    var femail = mini.get("taskNumberFemail").getValue();
    var mail = mini.get("taskNumberMail").getValue();
    if (sum < femail + mail) {
      mini.alert("男女之和不能大于总数！");
      return;
    }
    form.validate();
    if (form.isValid() == false) {
      return;
    }
    SaveData("/recruit/campusTaskController/save", $("#form1").serialize());
  }

  function onCancel(e) {
    CloseWindow("close", form);
  }
</script>

</body>
</html>
