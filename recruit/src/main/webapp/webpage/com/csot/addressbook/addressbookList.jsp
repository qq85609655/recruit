<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="/webpage/common.jsp"%>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<title>通讯录</title>
<style type="text/css">
</style>
</head>
<body onload="removeLoad();">
  <jsp:include page="/webpage/header.jsp"></jsp:include>
  <div class="co">
    <div class="co-right">
      <div class="position-path co-right-center">
        <span class="path-title">您的位置 :</span><a class="path-item a-decoration"
          href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><span
          class="path-leaf">系统管理</span><em class="path-icon">&gt;&gt;</em><span class="path-leaf">通讯录</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="con-title">通讯录管理</div>
        <div class="account-content">
          <div class="account-search">
            <table class="tblQuery2">
              <tbody>
                <tr>
                  <th>&nbsp;姓名：</th>
                  <td><input style="width: 60px" class="mini-textbox" name="personName" id="personName" onenter="search()"></td>
                  <th>&nbsp;公司:</th>
                  <td><input style="width: 80px" class="mini-textbox" name="company" id="company" onenter="search()"></td>
                  <th>&nbsp;职能:</th>
                  <td><input style="width: 80px" class="mini-textbox" name="remark" id="remark" onenter="search()"></td>
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
              <input type="button" class="button radius btn" id="modify" value="修改" onclick="modify()" /> 
              <input type="button" class="button radius btn" id="remove" value="删除" onclick="removeaddressbook()" />
              <input type="button" class="button radius btn" id="create" value="新增" onclick="create()" />
            </div>
            <div id="datagrid1" class="mini-datagrid" url="/recruit/addressbookController/datagrid?showPager=true"
              idField="id" sizeList="[1,2,50,100]" pageSize="10" allowResize="true">
              <div property="columns">
                <div type="checkcolumn"></div>
                <div name="personName" field="personName" width="80" allowSort="true">姓名</div>
                <div name="company" field="company" width="80" allowSort="true">公司</div>
                <div name="organization" field="organization" width="80" align="center"
                  headerAlign="center" allowSort="true">组织</div>
                <div name="currentPosition" field="currentPosition" width="80" align="center"
                  headerAlign="center" allowSort="true">当前职位</div>
                <div name="remark" field="remark" width="80" align="center" headerAlign="center"
                  allowSort="true">职能</div>
                <div name="email" field="email" width="80" align="center" headerAlign="center"
                  allowSort="true">邮箱</div>
                <div name="phoneNo" field="phoneNo" width="80" align="center" headerAlign="center"
                  allowSort="true">手机</div>
                <div name="tellphoneNo" field="tellphoneNo" width="80" align="center"
                  headerAlign="center" allowSort="true">固话</div>
                <div name="createUserId" field="createUserId" width="60" allowSort="true"
                  align="center" headerAlign="center">创建人</div>
                <div name="createTime" field="createTime" width="80" allowSort="true" align="center"
                  headerAlign="center" renderer="onDateRenderer">创建时间</div>
                <div name="changeUserId" field="changeUserId" width="60" allowSort="true"
                  align="center" headerAlign="center">更新人</div>
                <div name="changeTime" field="changeTime" width="80" allowSort="true" align="center"
                  headerAlign="center" renderer="onDateRenderer">更新时间</div>
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
    var personName = mini.get("personName").getValue();
    var company = mini.get("company").getValue();
    var remark = mini.get("remark").getValue();
    datagrid.load({
      personName : personName,
      company : company,
      remark : remark
    });
  }
  
  function create() {
    OpenDialog("/recruit/addressbookController/create/", "新建", datagrid, 350, 380);
  }
  
  function modify() {
    var row = datagrid.getSelected();
    if (row) {
        OpenDialog("/recruit/addressbookController/modify/" + row.id, "编辑", datagrid);
    } else {
      ShowWarnTip("请选择一条记录");
    }
  }

  function removeaddressbook() {
    var data = datagrid.getSelected();
    if (data) {
      var id = data.id;
      mini.confirm("确定删除记录？<br>", "删除", function(action) {
        if (action == "ok") {
          SaveData("/recruit/addressbookController/remove/" + id, "", function(e) {
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
      url : "/recruit/addressbookController/importAddressbook",
      title : "导入通讯录",
      width : 400,
      height : 170,
      allowResize : false
    });
  }
  
  function onDateRenderer(e) {
    var value = e.value;
    if (value)
      return new Date(value).format("yyyy-MM-dd");
    return "";
  }
  
</script>
</html>
