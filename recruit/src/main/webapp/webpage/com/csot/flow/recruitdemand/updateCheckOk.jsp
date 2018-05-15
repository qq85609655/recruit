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
    审批成功！</div>
  <jsp:include page="/webpage/footer.jsp"></jsp:include>

</body>
</html>
