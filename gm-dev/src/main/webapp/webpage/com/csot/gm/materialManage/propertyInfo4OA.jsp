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
</style>
</head>
<body>
  <form id="form1" class="fieldset-body" method="post" enctype="multipart/form-data">
    <div style="width: 700px; margin: 10px" align="center">
      <table style="width: 100%;" align="center">
        <tr align="center">
          <td><input style="width: 375px;" align="center" id="level" class="mini-textbox" " allowInput="false" /></td>
        </tr>
        <tr>
          <td><input id="partNoId" class="mini-hidden" value="${partNoId}" /></td>
        </tr>
      </table>
      <fieldset class="fieldset" id="fd3" style="width: 650px; font-family: 微软雅黑;">
        <legend>
          <span>属性信息</span>
        </legend>
        <div id="propertyGrid" class="mini-datagrid" style="width: 98%; height: 250px"
          allowCellSelect="true" idField="id" url="propertyValue/proValuedatagrid"
          allowResize="true" showPager="false" expanded="true" allowCellWrap="true">
          <div property="columns">
            <div field="propertyDisName" width="40" headerAlign="center" allowSort="true">属性名</div>
            <div field="propertyValue" width="40" headerAlign="center" allowSort="true">真实值</div>
            <div field="propertyValueText" width="40" headerAlign="center" allowSort="true">显示值</div>
            <div field="propertyType" width="20" headerAlign="center" allowSort="true">唯一性</div>
          </div>
        </div>
      </fieldset>
    </div>
  </form>
  <script>
      mini.parse();
      var partNoId = mini.get("partNoId").getValue();
      var propertyGrid = mini.get("propertyGrid");
      propertyGrid.load({
        partNoId : partNoId,
        sortField : "propertyName",
        sortOrder : "asc",
        success : function selectLevelInfo() {
          // 显示料号所在分类
          var level = mini.get("level");
          $.ajax({
            url : "partNo/getlevelByPartNoId/" + partNoId,
            type : "post",
            dataType : 'json',
            success : function(data) {
              level.setValue(data.msg);
            },
            error : function(msg) {
              mini.alert(msg, "error", CloseWindow);
            }
          });
        }
      });
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>