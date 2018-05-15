<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="/recruit-tags" %>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="/webpage/common.jsp" %>
  <link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/system/baseUserList.css"/>
  <title>原始需求管理</title>
  <style type="text/css">
    .mini-datagrid{margin-bottom:40px;}
  </style>
</head>
<body onload="removeLoad();">
<jsp:include page="/webpage/header.jsp"></jsp:include>
<div class="co">
  <div class="co-right">
    <div class="position-path co-right-center">
      <span class="path-title">您的位置 :</span><a class="path-item a-decoration"
                                               href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><span
            class="path-leaf">校园招聘</span><em class="path-icon">&gt;&gt;</em><span class="path-leaf">原始需求管理</span>
    </div>
    <div class="co-right-main co-right-center">
      <div class="con-title">原始需求管理</div>
      <div class="account-content">
        <div class="account-search">
          <table class="tblQuery2">
            <tbody>
            <tr>
              <th>&nbsp;所属组织:</th>
              <td>
                <input
                        id="organization" class="mini-combobox" name="organization"
                        style="width: 120px;" valueField="typeId" showNullItem="true" nullItemText="全部"
                        url="${webRoot}/datadictGroupTypeController/getDictsByCode/campus_company"
                        allowInput="true" textField="typeName" pinyinField="tag" onenter="search()">
              </td>
              <th>&nbsp;职位族:</th>
              <td>
                <input
                        id="jobFamily" class="mini-combobox" name="jobFamily"
                        style="width: 120px;" valueField="typeId" showNullItem="true" nullItemText="全部"
                        url="${webRoot}/datadictGroupTypeController/getDictsByCode/post_family"
                        allowInput="true" textField="typeName" pinyinField="tag" onenter="search()">
              </td>
              <th>&nbsp;岗位:</th>
              <td>
                <input
                        id="postId" class="mini-combobox" name="postId"
                        style="width: 120px;" valueField="typeId" showNullItem="true" nullItemText="全部"
                        url="${webRoot}/datadictGroupTypeController/getDictsByCode/pose_type"
                        allowInput="true" textField="typeName" pinyinField="tag" onenter="search()">
              </td>
              <td>&nbsp;&nbsp; <input type="submit" value="查询" tabindex="5"
                                      class="search_btn" id="btnRefresh" onclick="search()" name="btnRefresh">
              </td>
            </tr>
            </tbody>
          </table>
        </div>
        <div class="blue radius">
          <div class="table-operate" style="padding: 10px">
            <input type="button" class="button radius btn" id="uploadButton" value="excel导入" onclick="onImport()"/>
            <input type="button" class="button radius btn" id="modify" value="修改" onclick="modify()"/>
            <input type="button" class="button radius btn" id="remove" value="删除" onclick="removePost()"/>
            <input type="button" class="button radius btn" id="create" value="新增" onclick="create()"/>
            <input type="button" class="button radius btn" id="view" value="详细信息" onclick="view()"/>
            <input type="button" class="button radius btn" id="exportPost" value="导出" onclick="exportPost()"/>
          </div>
          <div id="datagrid1" class="mini-datagrid" url="/recruit/campusPostController/datagrid?showPager=true"
               idField="id" sizeList="[15,30,50,100]" pageSize="15" allowResize="false" style="height: 420px;">
            <div property="columns">
              <div type="checkcolumn"></div>
              <div name="postName" field="postName" width="80" allowSort="true">岗位名称</div>
              <div name="reserved1" field="reserved1" width="80" align="center"
                   headerAlign="center" allowSort="true">所属组织
              </div>
              <div name="bigCenter" field="bigCenter" width="80" align="center"
                   headerAlign="center" allowSort="true">需求大中心
              </div>
              <div name="smallCenter" field="smallCenter" width="80" align="center" headerAlign="center"
                   allowSort="true">需求厂/小中心
              </div>
              <div name="recruitQuantity" field="recruitQuantity" width="80" align="center" headerAlign="center"
                   allowSort="true">招聘数量
              </div>
              <div name="reserved2" field="reserved2" width="80" align="center" headerAlign="center"
                   allowSort="true">职位族
              </div>
              <div name="jobClass" field="jobClass" width="80" align="center"
                   headerAlign="center" allowSort="true">职位类
              </div>
              <div name="jobSubclass" field="jobSubclass" width="60" allowSort="true"
                   align="center" headerAlign="center">职位子类
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
    var datagrid = mini.get("datagrid1");
    datagrid.load();

    function search() {
        var postId = mini.get("postId").getValue();
        var jobFamily = mini.get("jobFamily").getValue();
        var organization = mini.get("organization").getValue();
        datagrid.load({
            postId: postId,
            jobFamily: jobFamily,
            organization: organization
        });
    }

    function create() {
        OpenDialog("/recruit/campusPostController/create/", "新增岗位", datagrid, 750, 600);
    }

    function modify() {
        var row = datagrid.getSelected();
        if (row) {
            OpenDialog("/recruit/campusPostController/modify/" + row.id, "编辑岗位", datagrid, 750, 600);
        } else {
            ShowWarnTip("请选择一条记录");
        }
    }

    function view() {
        var row = datagrid.getSelected();
        if (row) {
            OpenDialog("/recruit/campusPostController/view/" + row.id, "详细信息", datagrid, 750, 600);
        } else {
            ShowWarnTip("请选择一条记录");
        }
    }

    function removePost() {
        var data = datagrid.getSelected();
        if (data) {
            var id = data.id;
            mini.confirm("确定删除记录？<br>", "删除", function (action) {
                if (action == "ok") {
                    SaveData("/recruit/campusPostController/remove/" + id, "", function (e) {
                        ShowActionTip(e);
                        datagrid.reload();
                    });
                }
            });
        } else {
            ShowWarnTip("请选择一条记录");
        }
    }

    function onImport() {
        mini.open({
            url: "/recruit/campusPostController/importCampusPost",
            title: "导入岗位",
            width: 400,
            height: 170,
            allowResize: false
        });
    }

    function onDateRenderer(e) {
        var value = e.value;
        if (value)
            return new Date(value).format("yyyy-MM-dd");
        return "";
    }

    function exportPost() {
      var postId = mini.get("postId").getValue();
      var jobFamilyId = mini.get("jobFamily").getValue();
      var organizationId = mini.get("organization").getValue();
      window.location.href = "/recruit/campusPostController/exportPost?postId=" + postId +
          "&jobFamilyId=" + jobFamilyId + "&organizationId=" + organizationId;
    }

</script>
</html>