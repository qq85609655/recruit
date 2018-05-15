<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="/webpage/common.jsp" %>
  <link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css"/>
  <title>初版任务</title>
  <style type="text/css">
  </style>
</head>
<body onload="removeLoad();">
<jsp:include page="/webpage/header.jsp"></jsp:include>
<div class="co">
  <div class="co-right">
    <div class="position-path co-right-center">
      <span class="path-title">您的位置 :</span><a class="path-item a-decoration"
                                               href="${webRoot}/loginController/main">我的首页</a><em
            class="path-icon">&gt;&gt;</em><span
            class="path-leaf">校园招聘</span><em class="path-icon">&gt;&gt;</em><span class="path-leaf">初版任务</span>
    </div>
    <div class="co-right-main co-right-center">
      <div class="con-title">初版任务</div>
      <div class="main">
        <div class="position-import-main blue radius">
          <div class="account-content">
            <div class="account-search">
              <table class="tblQuery2">
                <tbody>
                <tr>
                  <th>&nbsp;年份：</th>
                  <td><input class="mini-combobox" style="width: 80px;" textField="yearth"
                             id="yearth" disabled="disabled" onitemclick="search()" value="${yearth}"
                             valueField="yearth" url="/recruit/campusTaskController/datagrid4Yearth"
                             allowInput="false"/></td>
                  <th>&nbsp;组织:</th>
                  <td>
                    <input
                            id="organizationId" class="mini-combobox" name="organizationId"
                            style="width: 120px;" valueField="typeId" showNullItem="true" nullItemText="全部"
                            url="/recruit/datadictGroupTypeController/getDictsByCode/campus_company"
                            allowInput="true" textField="typeName" pinyinField="tag"
                            onitemclick="search()">
                  </td>
                  <th>&nbsp;站点:</th>
                  <td>
                    <input
                            id="siteId" class="mini-combobox" name="siteId"
                            style="width: 120px;" valueField="siteId" showNullItem="true"
                            url="/recruit/campusSiteController/datagrid" nullItemText="全部"
                            allowInput="true" textField="siteName" pinyinField="tag"
                            onitemclick="search()">
                  </td>
                  <th>&nbsp;岗位:</th>
                  <td>
                    <input
                            id="postId" class="mini-combobox" name="postId" nullItemText="全部"
                            style="width: 120px;" valueField="typeId" showNullItem="true"
                            url="/recruit/datadictGroupTypeController/getDictsByCode/pose_type"
                            allowInput="true" textField="typeName" pinyinField="tag"
                            onitemclick="search()">
                  </td>
                </tr>
                </tbody>
              </table>
            </div>
            <div class="blue radius">
              <div class="table-operate" style="padding: 10px">
                <input type="button" class="button radius btn" id="uploadButton" value="excel导入"
                       onclick="onImport()"/>
                <input type="button" class="button radius btn" id="exportTaskFirst" value="导出"
                       onclick="exportTaskFirst()" />
                <input type="button" class="button radius btn" id="removeTaskFirst" value="删除"
                       onclick="removeTaskFirst()" />
              </div>
              <div id="datagrid" class="mini-datagrid" url="/recruit/campusTaskFirstController/datagrid?showPager=true"
                   idField="id" sizeList="[10,20,50,100]" pageSize="10" allowResize="false" multiSelect="true"
                   style="padding-top: 20px;">
                <div property="columns">
                  <div type="checkcolumn"></div>
                  <div field="yearth" width="80" allowSort="true">年份</div>
                  <div field="orgName" width="80" allowSort="true">所属组织</div>
                  <div field="siteName" width="60" allowSort="true">站点名称</div>
                  <div field="jobFamily" width="80" allowSort="true">职位族</div>
                  <div field="jobClass" width="120" allowSort="true">职位类</div>
                  <div field="jobSubclass" width="120" allowSort="true">职位子类</div>
                  <div field="bigCenter" width="80" allowSort="true">大中心</div>
                  <div field="smallCenter" width="120" allowSort="true">厂/小中心</div>
                  <div field="department" width="120" allowSort="true">部门</div>
                  <div field="branch" width="120" allowSort="true">科室</div>
                  <div field="reserved1" width="60" allowSort="true">学历</div>
                  <div header="任务" headerAlign="center">
                    <div property="columns">
                      <div field="taskNumberMail" width="60">男</div>
                      <div field="taskNumberFemail" width="60">女</div>
                      <div field="taskNumberSum" width="60">总人数</div>
                    </div>
                  </div>
                  <div field="jobDescribe" width="120" allowSort="true">职责描述</div>
                  <div field="nightShift" width="120" allowSort="true">夜班频率</div>
                  <div field="dustFree" width="120" allowSort="true">无尘室频率</div>
                  <div field="specialRequire" width="120" allowSort="true">特殊要求</div>
                  <div field="preferredMajor" width="120" allowSort="true">首选专业</div>
                  <div field="alternativeMajor" width="120" allowSort="true">备选专业</div>
                  <div field="remark" width="120" allowSort="true">备注</div>
                </div>
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
<script>
  mini.parse();
  var datagrid = mini.get("datagrid");

  search();
  function search() {
    var yearth = mini.get("yearth").getValue();
    if (null == yearth || "" == yearth) {
      mini.get("yearth").select(0);
      yearth = mini.get("yearth").getValue();
    }
    var organizationId = mini.get("organizationId").getValue();
    var siteId = mini.get("siteId").getValue();
    var postId = mini.get("postId").getValue();
    datagrid.load({
      yearth: yearth,
      organizationId: organizationId,
      siteId: siteId,
      postId: postId
    });
  }

  function onImport() {
    mini.open({
      url: "/recruit/campusTaskFirstController/importCampusTaskFirst",
      title: "导入任务",
      width: 400,
      height: 170,
      allowResize: false
    });
  }

  function exportTaskFirst() {
    var yearth = mini.get("yearth").getValue();
    var yearthValue = encodeURI(encodeURI(yearth));
    var organizationId = mini.get("organizationId").getValue();
    var siteId = mini.get("siteId").getValue();
    var postId = mini.get("postId").getValue();
    window.location.href = '/recruit/campusTaskFirstController/exportTaskFirst?yearth=' + yearthValue + '&organizationId='
        + organizationId + '&siteId=' + siteId + '&postId=' + postId;
  }

  function removeTaskFirst() {
    var data = datagrid.getSelecteds();
    if (data) {
      var ids = "";
      for (var i=0; i < data.length; i++) {
        ids += data[i].id + ",";
      }
      mini.confirm("确定删除记录？<br>", "删除", function (action) {
        if (action == "ok") {
          SaveData("${ctx}/campusTaskFirstController/remove/" + ids, "", function (e) {
            ShowActionTip(e);
            datagrid.reload();
          });
        }
      });
    } else {
      ShowWarnTip("请选择至少一条记录");
    }
  }

</script>
</html>
