<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/webpage/common.jsp"%>
<title>招聘需求申请</title>
<style type="text/css">
.mianDiv {
  font-size: 20px;
  line-height: 30px;
  height: 30px;
}
</style>
</head>
<body>
  <div class="head" id="recruitHeader">
    <div class="logo">
      <img class="logo_img" src="${ctx}/resources/images/logo.png" />
      <!-- <span class="logo-dec">华星招聘</span> -->
    </div>
    <div class="nav">
      <ul class="models">
        <li class="models-item active"><a class="menu-resource" href="javascript:void(0);">招聘需求修改审核页面</a>
        </li>
      </ul>
    </div>

  </div>
  <div class="mianDiv" style="min-height: 80%; box-sizing: border-box; padding-top: 125px;">
    <form id="form1" class="" method="post" enctype="multipart/form-data">
      <input id="demandId" name="demandId" class="mini-hidden" value="${recruitDemand.id}" /> <input
        id="type" name="type" class="mini-hidden" value="1" />
      <div style="margin: 10px" align="center">
        <table class="form-table" border="0" cellpadding="10" cellspacing="10">
          <c:if test="${recruitDemandChange.isDeal eq '1'}">
            <c:if test="${recruitDemandChange.type eq '1'}">
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>${recruitDemand.theme}</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>${upUser}修改如下：</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td style="color: red;" align="left">&nbsp;&nbsp;&nbsp;原需求人数:${recruitDemandChange.oldStr}</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td style="color: red;" align="left">&nbsp;&nbsp;&nbsp;变更后的需求人数:${recruitDemandChange.newStr}</td>
              </tr>
            </c:if>
            <c:if test="${recruitDemandChange.type eq '2'}">
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>${recruitDemand.theme}</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>${upUser}修改如下：</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td style="color: red;" align="left">&nbsp;&nbsp;&nbsp;原期望到岗日期:${recruitDemandChange.oldStr}</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td style="color: red;" align="left">&nbsp;&nbsp;&nbsp;变更后的期望到岗位日期:${recruitDemandChange.newStr}</td>
              </tr>
            </c:if>
          </c:if>
          <c:if test="${recruitDemandChange.isDeal eq '2'}">
                                该请求已经审核完成，无需再次审核！
          </c:if>
        </table>
      </div>
      <c:if test="${recruitDemandChange.isDeal eq '1'}">
        <div style="text-align: center; padding: 10px;">
          <a class="mini-button" onclick="submitForm('2')" style="width: 80px; margin-right: 40px;">同意</a>
          <a id="rtnBtn" class="mini-button" onclick="submitForm('1')" style="width: 80px;">不同意</a>
        </div>
      </c:if>
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
              url : jsWebRoot
                  + "/visitor/recruitDemandChangeController/check/${recruitDemandChange.id}/"
                  + typeStr,
              type : 'post',
              dataType : "json",
              success : function(e) {
                mini.hideMessageBox(messageid); 
                if (e.success) {
                  //审批成功
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
              },
              error : function(jqXHR, textStatus, errorThrown) {
                mini.alert(jqXHR.responseText);
              }
            });
          }
        </script>
  </div>
  <jsp:include page="/webpage/footer.jsp"></jsp:include>

</body>
</html>