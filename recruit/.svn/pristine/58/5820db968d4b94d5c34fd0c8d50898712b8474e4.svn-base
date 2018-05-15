<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/webpage/common.jsp"%>
<title>招聘需求申请</title>
<link rel="stylesheet" type="text/css"
  href="${webRoot}/resources/css/flow/recruitdemand/recruitDemandEdit.css" />
</head>
<body>
  <form id="form1" class="" method="post" enctype="multipart/form-data">
    <input id="demandId" name="demandId" class="mini-hidden" value="${recruitDemand.id}" /> <input
      id="type" name="type" class="mini-hidden" value="1" />
    <div style="margin: 10px" align="center">
      <table class="form-table" border="0" cellpadding="10" cellspacing="10">
        <tr>
          <td class="">申请人数：</td>
          <td><input name="newStr" changeOnMousewheel="false" class="mini-spinner" minValue="0"
            maxValue="${recruitDemand.applyPersonNumber}" value="${recruitDemand.applyPersonNumber}"
            required="true" /></td>
        </tr>
        <tr>
          <td colspan="2" style="font-size: 12px; color: red;">只支持减少招聘人数，如需增加招聘人数请再次申请</td>
        </tr>
      </table>
    </div>
    <div style="text-align: center; padding: 10px;">
      <a class="mini-button" onclick="submitForm()" style="width: 80px; margin-right: 40px;">修改</a>
      <a id="rtnBtn" class="mini-button" onclick="onCancel()" style="width: 80px;">取消</a>
    </div>
  </form>
  <script type="text/javascript">
      mini.parse();
      var jsWebRoot = "${webRoot}";
      var form = new mini.Form("form1");

      // 取消按钮
      function onCancel(e) {
        CloseWindow("close", form);
      }

      // 提交新增需求表单
      function submitForm(typeStr) {
        form.validate();
        if (form.isValid() == false) {
          return;
        }
        var messageid = mini.loading("提交中请稍后......");
        $.ajax({
          url : "/recruit/recruitDemandChangeControllerLogin/save",
          type : 'post',
          data : $("#form1").serialize(),
          dataType : "json",
          success : function(e) {
            mini.hideMessageBox(messageid);
            if (e.success) {
              mini.showMessageBox({
                title: "提示",    
                message: e.msg,
                buttons: ["ok"],    
                iconCls: "mini-messagebox-info",
                callback: function(action){
                  CloseWindow("ok");
                }
              });
            } else {
              mini.alert(e.msg);
            }
          }
        });
      }
      function openCheck(e) {
        if (e.success) {
          /* mini.alert(e.msg, "", function() {
            CloseWindow("ok");
          }); */
          mini.showMessageBox({
            title: "提示",    
            message: e.msg,
            buttons: ["ok"],    
            iconCls: "mini-messagebox-info",
            callback: function(action){
              CloseWindow("ok");
            }
          });
          //window.open(jsWebRoot+"/visitor/recruitDemandChangeController/toCheck/" + e.attributes.id);
          /* $.ajax({
            url : "/recruit/visitor/recruitDemandChangeController/sendEmail",
            type : 'post',
            async : true,
            data : {
              'id' : e.attributes.id
            },
            dataType : "json",
            cache : false,
            success : function(e) {
            }
          }); */
        } else {
          mini.alert(e.msg);
        }
      }
    </script>
</body>
</html>
