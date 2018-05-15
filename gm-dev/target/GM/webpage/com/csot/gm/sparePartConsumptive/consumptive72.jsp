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

  <form id="form1" class="fieldset-body" method="post" enctype="multipart/form-data">
    <div style="width: 700px; margin: 10px" align="center">

      <h3 style="font-family: 微软雅黑">创建72耗材料号</h3>
      <input name="preCode" class="mini-hidden" value="${preCode}" /> <input name="partId"
        class="mini-hidden" value="${partId}" /> <input name="classId" class="mini-hidden"
        value="${classId}" /> <input name="uid" id="uid" class="mini-hidden" value="${uid}" /> <input
        name="partType" id="partType" class="mini-hidden" value="${partType}" />

      <fieldset class="fieldset" id="fd1" style="width: 650px; font-family: 微软雅黑;">
        <legend>
          <span style="font-size: 10px; align: center" align="center">创建人信息</span>
        </legend>
        <table class="form-table" border="0" cellpadding="3" cellspacing="0">
          <tr>
            <!--  <td class="form-label" style="width: 100px;">厂别：
        <input name="userInfo.plant" class="mini-textbox" style="width:60px" required="true"/></td>
      -->
            <td class="form-label" style="width: 230px;">部门： <input id="department"
              name="userInfo.department" class="mini-textbox" value="${department}"
              style="width: 190px" required="true" requiredErrorText="部门不能为空" /></td>

            <td class="form-label" style="width: 90px;">工号： <input id="userCode"
              name="userInfo.userCode" class="mini-textbox" value="${userCode}" style="width: 50px"
              required="true" requiredErrorText="工号不能为空" onvaluechanged="onValueChanged()" /></td>

            <td class="form-label" style="width: 100px;">姓名： <input id="userName"
              name="userInfo.userName" class="mini-textbox" value="${userName}" style="width: 60px"
              required="true" requiredErrorText="姓名不能为空" /></td>

            <td class="form-label" style="width: 170px;">联系电话： <input id="telephone"
              name="userInfo.telephone" class="mini-textbox" value="${telephone}"
              style="width: 100px" required="true" requiredErrorText="联系电话不能为空,请填入工号带出信息" /></td>
          </tr>

        </table>
      </fieldset>

      <fieldset class="fieldset" id="fd2" style="width: 650px; font-family: 微软雅黑;">
        <legend>
          <span>料号生成属性（料号规则-耗材-适用于72）</span>
        </legend>
        <table class="form-table" border="0" cellpadding="13" cellspacing="2">
          <tr>
            <td class="form-label" style="width: 160px;">大分类码： <input id="combobigClass"
              class="mini-combobox" name="properties['bigClassId']" style="width: 80px;"
              valueField="id" url="rawMaterial/getComboData?enumTypeId=${bigClassEnumTypeId}"
              required="" allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">厂别码： <input id="combo3"
              class="mini-combobox" name="properties['plantCodeId']" style="width: 90px;"
              valueField="id" url="rawMaterial/getComboData?enumTypeId=${plantCodeEnumTypeId}"
              required="" allowInput="false" onvalidation="onComboValidation" textField="text"
              pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">中类： <input id="combo4"
              class="mini-combobox" name="properties['mediumClassId']" style="width: 90px;"
              valueField="id" url="rawMaterial/getComboData?enumTypeId=${mediumClassEnumTypeId}"
              required="" allowInput="false" textField="text" pinyinField="tag"></td>
          </tr>
          <tr>
            <td class="form-label" style="width: 160px;">小类： <input id="combo5"
              class="mini-combobox" name="properties['miniClassId']" style="width: 105px;"
              valueField="id" url="rawMaterial/getComboData?enumTypeId=${miniClassEnumTypeId}"
              required="" allowInput="false" textField="text" pinyinField="tag"></td>
            <td class="form-label" style="width: 160px;">维修区别码： <input
              name="properties['maintainCodeId']" id="0" value="0" class="mini-textbox"
              style="width: 65px" allowInput="false" /></td>
            <td class="form-label" style="width: 160px;">流水码： <input
              name="properties['flowNoId']" value="XXXXXX" class="mini-textbox" style="width: 80px"
              allowInput="false" /></td>
          </tr>
        </table>
      </fieldset>
    </div>
    <div style="text-align: center; padding: 10px;">
      <a id="rtnBtn" class="mini-button" onclick="onRtn()" style="width: 60px; margin-right: 20px;">返回</a>
      <a class="mini-button" onclick="submitForm()" style="width: 80px;">生成料号</a>
    </div>
  </form>
  <%@ include file="/resources/context/lazyResource.jsp"%>
  <script type="text/javascript">
      mini.parse();

      /* 默认选中值，联动选择等简单js */
      var comb5 = mini.get("combo5");
      comb5.select(0);
      var comb4 = mini.get("combo4");
      comb4.select(0);
      var combobigClass = mini.get("combobigClass");
      combobigClass.select(0);

      var department = mini.get("department");
      var userCode = mini.get("userCode");
      var userName = mini.get("userName");
      var telephone = mini.get("telephone");

      // 手动更改工号，自动带出创建人信息
      function onValueChanged() {
        var code = userCode.getValue();

        $.ajax({
          url : "userInfo/getUserInfo/" + code,
          type : "post",
          dataType : 'json', //数据格式为json
          success : function(data) {
            department.setValue(data.attributes.department);
            userName.setValue(data.attributes.userName);
            telephone.setValue(data.attributes.telephone);
          },
          error : function(msg) {
            //mini.alert(msg, "error", CloseWindow);
            return;
          }
        });
      }

      var base = document.getElementsByTagName("base")[0].getAttribute("href"); //IE下base标签不兼容
      var uid = mini.get("uid").getValue();
      var partType = mini.get("partType").getValue();

      function onComboValidation(e) {
        //如果下拉框值为空时，则提示如下
        if (null == e.value || e.value == "") {
          e.isValid = false;
          e.errorText = "请完成必选项下拉值选择";
        } else {
          //若有值且值不在下拉值中，则显示如下提示
          var items = this.findItems(e.value);
          if (!items || items.length == 0) {
            e.isValid = false;
            e.errorText = "[" + e.value + "]" + "不在下拉数据中";
          }
        }

      }

      function onRtn() {
        window.location.href = base + "rawMaterial/rawMaterial?uid=" + uid + "&partType="
            + partType;
      }

      function submitForm() {
        var form = new mini.Form("form1");
        form.validate();
        if (form.isValid() == false) {
          var errorTexts = form.getErrorTexts();
          showErrorTexts(errorTexts);

          return;
        }

        var dd = $("#form1").serialize();

        $.ajax({
          url : "rawMaterial/createConsumptive72",
          type : "post",
          async : false,
          data : dd,
          dataType : 'json', //数据格式为json
          success : function(data) {
            var partNoId = data.attributes.partNoId;
            var success = data.attributes.success;
            // 物料类型检查不通过
            if (success == "falseType" || success == "false") {
              mini.alert(data.attributes.message);
            } else if (success == "true") {
              window.location.href = base + "rawMaterial/createComplete";
            }
          },
          error : function(msg) {
            mini.alert(msg, "error", CloseWindow);
          }
        });
      }

      function showErrorTexts(errorTexts) {
        var s = errorTexts.join('<br/>');

        var win = window
            .open(
                '',
                "",
                'height=200,width=450,top=200,left=400,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no, titlebar=no');
        win.document.open('text/html', 'replace');
        win.document.write(s);
        win.document.close();
      }
    </script>

</body>
</html>