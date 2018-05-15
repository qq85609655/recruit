<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Insert title here</title>

<style>
html, body {
  overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}

.form-table {
  font-size: 10px
}

fieldset {
  border: solid 1px #aaa;
  margin: 10px;
  font-size: 10px
}
</style>
</head>
<body>

  <h3 style="font-family: 微软雅黑">level 1：${class1Name}&nbsp;&nbsp;&nbsp;&nbsp;level
    2：${class2Name} &nbsp;&nbsp;&nbsp;&nbsp;level
    3：${partName}&nbsp;&nbsp;&nbsp;&nbsp;料号代码：${preCode}</h3>
  <input name="preCode" class="mini-hidden" value="${preCode}" />
  <input name="partId" class="mini-hidden" value="${partId}" />
  <input name="classId" class="mini-hidden" value="${classId}" />
  <input name="uid" id="uid" class="mini-hidden" value="${uid}" />
  <input name="partType" id="partType" class="mini-hidden" value="${partType}" />

  <fieldset class="fieldset" id="fd1" style="width: 650px; font-family: 微软雅黑;">
    <legend>
      <span style="font-size: 10px; align: center" align="center">创建人信息</span>
    </legend>
    <table class="form-table" border="0" cellpadding="3" cellspacing="0">
      <tr>
        <!--  <td class="form-label" style="width: 100px;">厂别：
        <input name="userInfo.plant" class="mini-textbox" style="width:60px" required="true"/></td>
      -->
        <td class="form-label" style="width: 230px;">部门： <input id="department" requiredErrorText="部门不能为空"
          name="userInfo.department" class="mini-textbox" value="${department}" style="width: 190px"
          required="true" allowInput="false" /></td>

        <td class="form-label" style="width: 90px;">工号： <input id="userCode" vtype="int" requiredErrorText="工号不能为空"
          name="userInfo.userCode" class="mini-textbox" value="${userCode}" style="width: 50px"
          required="true" onvaluechanged="onValueChanged()" /></td>

        <td class="form-label" style="width: 100px;">姓名： <input id="userName" requiredErrorText="姓名不能为空"
          name="userInfo.userName" class="mini-textbox" value="${userName}" style="width: 60px"
          required="true" allowInput="false" /></td>

        <td class="form-label" style="width: 170px;">联系电话： <input id="telephone" requiredErrorText="联系电话不能为空,请填入工号带出信息"
          name="userInfo.telephone" class="mini-textbox" value="${telephone}" style="width: 100px"
          required="true" allowInput="false" /></td>
      </tr>

    </table>
  </fieldset>

  <script>
      mini.parse();

      var department = mini.get("department");
      var userCode = mini.get("userCode");
      var userName = mini.get("userName");
      var telephone = mini.get("telephone");

      // 手动更改工号，自动带出创建人信息
      function onValueChanged() {
        var code = userCode.getValue();
        if (null == code || "" == code) return;
        
        $.ajax({
          url : "userInfo/getUserInfo/" + code,
          type : "post",
          dataType : 'json', //数据格式为json
          success : function(data) {
            department.setValue(data.attributes.department);
            userName.setValue(data.attributes.userName);
            telephone.setValue(data.attributes.telephone);
            //默认情况下部门、姓名、联系电话不可编辑,输入工号后这些信息可编辑
            department.setAllowInput("true");
            userName.setAllowInput("true");
            telephone.setAllowInput("true");
          },
          error : function(msg) {
            //mini.alert(msg, "error", CloseWindow);
            return;
          }
        });
      }
    </script>

</body>
</html>