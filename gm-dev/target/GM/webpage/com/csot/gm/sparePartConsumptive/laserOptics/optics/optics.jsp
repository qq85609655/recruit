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
</style>
</head>
<body>
  <form id="form1" class="fieldset-body" method="post" enctype="multipart/form-data">
    <div style="width: 700px; margin: 10px" align="center">

      <%@ include file="/webpage/com/csot/gm/rawMaterial/classAndUserInfo.jsp"%>
      <fieldset class="fieldset" id="fd2" style="width: 650px; font-family: 微软雅黑;">
        <legend>
          <span>唯一性属性</span>
        </legend>
        <%@ include file="/webpage/com/csot/gm/sparePartConsumptive/brandSpec.jsp"%>

        <!-- 在下面的table里面新增除了品牌和规格以外的唯一性属性 -->
        <table class="form-table" border="0" cellpadding="13" cellspacing="2">
        </table>

      </fieldset>
      <%@ include file="/webpage/com/csot/gm/sparePartConsumptive/spareGenerate.jsp"%>
    </div>
  </form>

  <script type="text/javascript">
      mini.parse();
      /* 默认选中值，联动选择等简单js */
      var comb4 = mini.get("combo4");
      comb4.select(0);
      var comb5 = mini.get("combo5");
      comb5.select(0);
      var comb6 = mini.get("combo6");
      comb6.select(0);
      var combobigClass = mini.get("combobigClass");
      combobigClass.select(0);
    </script>

</body>
</html>