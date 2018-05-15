<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
  <%@ include file="/webpage/common.jsp" %>
  <title>岗位查看</title>
  <link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/importResume.css"/>
  <link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css"/>
  <style>
  .mini-datagrid{margin:20px 0;}
  </style>
</head>
<body onload="removeLoad();">
<jsp:include page="/webpage/header.jsp"></jsp:include>
<div class="co">
	<div class="co-right">
	  <div class="position-path co-right-center">
	    <span class="path-title">您的位置 :</span>
	    <a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a>
	    <em class="path-icon">&gt;&gt;</em>
	    <a class="path-item a-decoration">校园招聘</a>
	    <em class="path-icon">&gt;&gt;</em>
	    <span class="path-leaf">校招看板</span>
	  </div>
	  <div class="co-right-main co-right-center">
	    <div class="tab">
				<a class="tab-item" href="${ctx}/campusReportController/list4Site">站点查看</a>
				<a class="tab-item active">岗位查看</a>
			</div>
	    <div class="account-content">
	      <div class="account-search">
	        <table class="tblQuery2">
	          <tbody>
	          <tr>
	            <th>&nbsp;站点：</th>
	            <td><input class="mini-combobox" style="width: 90px;"
	                       textField="siteName" valueField="siteId" id="siteId"
	                       url="/recruit/campusSiteController/datagrid" value=""
	                       showNullItem="true" nullItemText="全部"
	                       allowInput="true" onitemclick="search()"/></td>
	            <th>&nbsp;年份：</th>
	            <td><input class="mini-combobox" style="width: 80px;" textField="yearth"
	                       id="yearth" nullItemText="全部"
	                       valueField="yearth" url="/recruit/campusTaskController/datagrid4Yearth"
	                       showNullItem="true" allowInput="true" onitemclick="search()"/></td>
	            <th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
	            <td>
	              <div id="organization" class="mini-radiobuttonlist" repeatLayout="table"
	                   repeatDirection="vertical"
	                   textField="typeName" valueField="typeId" onvaluechanged="search()"
	                   url="/recruit/datadictGroupTypeController/getDictsByCode/campus_company">
	              </div>
	            </td>
	            <td>
	              <input type="submit" value="导出" tabindex="5" class="search_btn" id="btnExport"
	                     onclick="exportReport4PostByTemplate()" name="btnExport">
	            </td>
	          </tr>
	          </tbody>
	        </table>
	      </div>
	      <div id="datagrid" class="mini-datagrid" showSummaryRow="true"
	           url="/recruit/campusReportController/datagrid4Post" idField="id"
	           allowResize="false" showPager="false" ondrawsummarycell="onDrawSummaryCell">
	        <div property="columns">
	          <div type="checkcolumn"></div>
	          <div field="postName" width="100" allowSort="true">岗位</div>
	          <div header="任务" headerAlign="center">
	            <div property="columns">
	              <div field="taskBa" summaryType="sum" width="70">本科</div>
	              <div field="taskMa" summaryType="sum" width="70">硕士</div>
	              <div field="taskDo" summaryType="sum" width="70">博士</div>
	              <div field="taskSum" summaryType="sum" width="70">合计</div>
	            </div>
	          </div>
	          <div header="已发offer" headerAlign="center">
	            <div property="columns">
	              <div field="offerBa" summaryType="sum" width="70">本科</div>
	              <div field="offerMa" summaryType="sum" width="70">硕士</div>
	              <div field="offerDo" summaryType="sum" width="70">博士</div>
	              <div field="offerSum" summaryType="sum" width="70">合计</div>
	            </div>
	          </div>
	          <div header="三方" headerAlign="center">
	            <div property="columns">
	              <div field="trilateralBa" summaryType="sum" width="70">本科</div>
	              <div field="trilateralMa" summaryType="sum" width="70">硕士</div>
	              <div field="trilateralDo" summaryType="sum" width="70">博士</div>
	              <div field="trilateralSum" summaryType="sum" width="70">合计</div>
	            </div>
	          </div>
	          <div header="违约" headerAlign="center">
	            <div property="columns">
	              <div field="breakOffBa" summaryType="sum" width="70">本科</div>
	              <div field="breakOffMa" summaryType="sum" width="70">硕士</div>
	              <div field="breakOffDo" summaryType="sum" width="70">博士</div>
	              <div field="breakOffSum" summaryType="sum" width="70">合计</div>
	            </div>
	          </div>
	          <div header="拟入职" headerAlign="center">
	            <div property="columns">
	              <div field="proposedEntryBa" summaryType="sum" width="70">本科</div>
	              <div field="proposedEntryMa" summaryType="sum" width="70">硕士</div>
	              <div field="proposedEntryDo" summaryType="sum" width="70">博士</div>
	              <div field="proposedEntrySum" summaryType="sum" width="70">合计</div>
	            </div>
	          </div>
	          <div header="offer率(offer/任务)" headerAlign="center">
	            <div property="columns">
	              <div field="achievementBa" width="70">本科</div>
	              <div field="achievementMa" width="70">硕士</div>
	              <div field="achievementDo" width="70">博士</div>
	              <div field="achievementSum" width="70">合计</div>
	            </div>
	          </div>
	          <div header="三方率(三方/任务)" headerAlign="center">
	            <div property="columns">
	              <div field="trilTaskBa" width="70">本科</div>
	              <div field="trilTaskMa" width="70">硕士</div>
	              <div field="trilTaskDo" width="70">博士</div>
	              <div field="trilTaskSum" width="70">合计</div>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
  </div>
</div>
<jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>

<script type="text/javascript" src="${webRoot}/resources/js/jquery.form.js"></script>
<script>
    mini.parse();

    var datagrid = mini.get("datagrid");
    var yearth = mini.get("yearth");
    var organization = mini.get("organization");
    var siteId = mini.get("siteId");
    yearth.select(0);
    search();

    function search() {
      datagrid.load({
          organizationId: organization.getValue(),
          siteId: siteId.getValue(),
          yearth: yearth.getValue()
      });
    }

    function exportReport4PostByTemplate() {
        window.location.href = '${ctx}/campusReportController/export4Post?siteId=' + siteId.getValue() + '&yearth=' + encodeURI(encodeURI(yearth.getValue())) + '&organizationId=' + organization.getValue();
    }

    function onDrawSummaryCell(e) {
      //客户端汇总计算
      if (e.field == "postName") {
        e.cellHtml = "总计: ";
      } else {
        e.cellHtml = e.cellHtml;
      }
    }

</script>

</html>