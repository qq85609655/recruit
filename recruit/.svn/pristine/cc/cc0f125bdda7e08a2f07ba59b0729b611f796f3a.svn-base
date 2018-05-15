<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/webpage/common.jsp"%>
<title>日程提醒</title>
<link rel="stylesheet" type="text/css"
  href="${webRoot}/resources/css/flow/recruitdemand/recruitDemandEdit.css" />
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
</head>
<body onload="removeLoad();">
  <div class="">
    <div class="co-right">
      <div class="co-right-main co-right-center">
        <div class="con-title">日程提醒</div>
        <div class="main">
          <form id="form1" class="fieldset-body" method="post" enctype="multipart/form-data">
            <div>
              <fieldset class="fieldset" id="fd1" style="font-family: 微软雅黑; padding-bottom: 10px">
                <legend>
                  <span style="font-size: 15px; align: center">日程提醒设置</span>
                </legend>
                <table class="form-table" border="0" cellpadding="10" cellspacing="10">

                  <tr>
                    <td class="form-label">提醒时间：</td>
                    <td><input name="remindDate" id="remindDate" class="mini-datepicker"
                      required="true" /></td>
                  </tr>
                  <tr>
                    <td class="form-label">内容：</td>
                    <td><input name="remindContent" class="mini-textarea" id="remindContent"
                      style="width: 300px; height: 160px;" required="true" /></td>
                  </tr>
                </table>
              </fieldset>
            </div>
            <div style="text-align: center; padding: 10px;">
              <a class="mini-button" onclick="submitForm()" style="width: 80px; margin-right: 40px;">提交</a>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.zh_cn.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/resume/ajaxfileupload.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaAutoCompleteData.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaData.js"></script>

  <script type="text/javascript">
      mini.parse();
      var jsWebRoot = "${webRoot}";
      var form = new mini.Form("form1");
      // 提交新增需求表单
      function submitForm(typeStr) {
        form.validate();
        if (form.isValid() == false) {
          mini.alert("请完整填写表单", "提示");
          return;
        }

        SaveData("/recruit/remind/save", $("#form1").serialize());

      }
      function submitFormCall() {

      }
    </script>
</body>
</html>
