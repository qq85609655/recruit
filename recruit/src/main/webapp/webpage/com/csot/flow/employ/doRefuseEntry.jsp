<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<title>拒绝offer原因</title>
</head>
<body onload="removeLoad();">
  <div class="account-search" style="padding: 5px;">
    <div class="blue radius">
      <form id="form1" class="fieldset-body" method="post" enctype="multipart/form-data">
        <input id="employId" name="employId" class="mini-hidden" value="${employ.id}" />
        <div style="margin: 10px" align="center">
          <table class="form-table" border="0" cellpadding="20" cellspacing="20">
            <tr>

              <td><label><input name="reason" type="checkbox" value="1"
                  <c:if test="${fn:contains(employRefuseOffer.reason, '1')}">checked="checked"</c:if> />薪酬不匹配:
              </label></td>
              <td><input class="mini-radiobuttonlist" textField="typeName" valueField="typeId"
                name="salary" value="${employRefuseOffer.salary}" required="true"
                requiredErrorText="员工类别不能为空"
                data="[{'typeId':1,typeName:'年收入差距2万以内'},{'typeId':2,typeName:'年收入差距2-5万'},
                {'typeId':3,typeName:'年收入差距5-10万'},
                {'typeId':4,typeName:'年收入差距10万以上'}]" /></td>
            </tr>
            <tr>
              <td><label><input name="reason" type="checkbox" value="2"
                  <c:if test="${fn:contains(employRefuseOffer.reason, '2')}">checked="checked"</c:if> />原公司挽留:
              </label></td>
              <td><input class="mini-checkboxlist" textField="typeName" valueField="typeId"
                name="oldcompany" value="${employRefuseOffer.oldcompany}" required="true"
                requiredErrorText="员工类别不能为空"
                data="[{'typeId':1,typeName:'加薪'},{'typeId':2,typeName:'晋升'},
                {'typeId':3,typeName:'换岗'}]" />
              </td>
            </tr>
            <tr>
              <td><label><input name="reason" type="checkbox" value="3"
                  <c:if test="${fn:contains(employRefuseOffer.reason, '3')}">checked="checked"</c:if> />交通:
              </label></td>
              <td><input name="traffic" class="mini-textarea" id="requiredSkill"
                value="${employRefuseOffer.traffic}" style="width: 400px; height: 80px;"
                required="true" /> </textarea></td>
            </tr>
            <tr>
              <td><label><input name="reason" type="checkbox" value="4"
                  <c:if test="${fn:contains(employRefuseOffer.reason, '4')}">checked="checked"</c:if> />接受其他OFFER:</label></td>
              <td><input name="otherOffer" class="mini-textarea" id="requiredSkill"
                value="${employRefuseOffer.otherOffer}" style="width: 400px; height: 80px;"
                required="true" /> </textarea></td>
            </tr>
            <tr>
              <td><label><input name="reason" type="checkbox" value="4" />其它:</label></td>
              <td><input name="other" class="mini-textarea" id="requiredSkill"
                value="${employRefuseOffer.other}" style="width: 400px; height: 80px;"
                required="true" /></td>
            </tr>
          </table>
          <div style="text-align: center; padding: 10px;">
            <c:if test="${empty employRefuseOffer.id}">
              <a class="mini-button" onclick="submitForm()" style="width: 80px; margin-right: 40px;">提交</a>
            </c:if>
            <a id="rtnBtn" class="mini-button" onclick="onCancel()" style="width: 80px;">取消</a>
          </div>
        </div>

      </form>
    </div>
  </div>
</body>
<script type="text/javascript">
  mini.parse();
  function GetData() {
    return "";
  }
  //取消按钮
  function onCancel(e) {
    CloseWindow("close");
  }
  //提交新增需求表单
  function submitForm() {
    var obj = document.getElementsByName('reason');
    var s = false;
    for (var i = 0; i < obj.length; i++) {
      if (obj[i].checked) {
        s = true;
      }
    }
    if (s) {
      SaveData("/recruit/employRefuseOfferController/refuseEntry", $("#form1").serialize());
    } else {
      mini.alert("请至少选择一个原因");
    }
  }
</script>
</html>









