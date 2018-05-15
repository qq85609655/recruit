<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/context/jspBase.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Insert title here</title>
<%@ include file="/resources/context/headResource.jsp"%>
<script>
  var enabledEnum = [ {
    id : 1,
    text : '启用'
  }, {
    id : 0,
    text : '停用'
  } ];
</script>
<style>
html, body {
  overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}
</style>
</head>
<body>
  <div class="mini-fit">
    <form id="mainForm" class="mainform" method="post">
      <input name="id" class="mini-hidden" value="${sysRole.id }" />
      <table class="formTable" style="table-layout: fixed;">
        <tr>
          <td class="formLabel">角色名称:</td>
          <td class="formContent"><input name="name" class="mini-textbox" required="true"
            vtype="maxLength:60" emptyText="请输入角色名称" onvalidation="ValidErrorText"
            value="${sysRole.name}" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">角色编码:</td>
          <td class="formContent"><input name="role" class="mini-textbox" required="true"
            vtype="maxLength:60" emptyText="请输入角色编码" onvalidation="roleCodeValidation"
            value="${sysRole.role}" /><label id="role_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">角色描述:</td>
          <td class="formContent"><input name="description" class="mini-textbox"
            vtype="maxLength:240" emptyText="请输入角色描述" onvalidation="ValidErrorText"
            value="${sysRole.description}" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">状态:</td>
          <td class="formContent"><div id="enabled" name="enabled" class="mini-radiobuttonlist"
              repeatItems="1" repeatLayout="table" repeatDirection="vertical" textField="text"
              valueField="id"
              value="<c:choose><c:when test="${!empty sysRole.enabled}">${sysRole.enabled}</c:when><c:otherwise>1</c:otherwise></c:choose>"
              data="enabledEnum"></div> <label id="enabled_error" class="errorText"></label></td>
        </tr>
      </table>
    </form>
  </div>
  <div class="mini-toolbar dialogFooter">
    <a class="mini-button" style="width: 60px;" onclick="onOk()">确定</a> <span
      style="display: inline-block; width: 25px;"></span> <a class="mini-button"
      style="width: 60px;" onclick="onCancel()">取消</a>
  </div>
  <script>
      mini.parse();
      var form = new mini.Form("#mainForm");

      function onOk(e) {
        form.validate();
        if (form.isValid() == false) {
          return;
        }

        SaveData("auth/role/sysRole/save", $("#mainForm").serialize());
      }

      function onCancel(e) {
        CloseWindow("close", form);
      }

      function roleCodeValidation(e) {
        if (e.isValid) {
          var re = new RegExp("^[0-9a-zA-Z\_]+$");
          if (re.test(e.value) == false) {
            e.errorText = "账号只能包含字母、数字或下划线这几种字符";
            e.isValid = false;
          }
        }
        ValidErrorText(e);
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>