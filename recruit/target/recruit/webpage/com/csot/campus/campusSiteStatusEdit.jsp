<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" uri="/recruit-tags" %>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="/webpage/common.jsp" %>
  <link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css"/>
  <title>站点状态编辑</title>
  <style type="text/css">
  </style>
</head>
<body onload="removeLoad();">
  <div class="co-right">
    <div class="co-right-main co-right-center">
      <div class="con-title">站点状态编辑</div>
      <div class="account-content">
        <div class="blue radius">
          <div class="table-operate" style="padding: 10px">
            <table class="tblQuery2">
              <tbody>
              <tr>
                <th>&nbsp;站点名称：</th>
                <td><input style="width: 60px" class="mini-textbox" name="siteName" id="siteName" onenter="search()"></td>
                <td>&nbsp;&nbsp; <input type="submit" value="查询" tabindex="5"
                                        class="search_btn" id="btnRefresh" onclick="search()" name="btnRefresh">
                  &nbsp;&nbsp; <input type="button" class="button radius btn" id="changeStatus" value="更改状态" onclick="changeStatus()"/>
                </td>
              </tr>
              </tbody>
            </table>
          </div>
          <div id="datagrid1" class="mini-datagrid" url="/recruit/campusSiteController/datagrid?showPager=true"
               idField="id" sizeList="[15,30,50,100]" multiSelect="true" pageSize="15" allowResize="false" style="height: 420px;">
            <div property="columns">
              <div type="checkcolumn"></div>
              <div name="siteName" field="siteName" width="60" allowSort="true">站点名称</div>
              <div field="status" width="40" allowSort="true" renderer="onStatusRenderer">状态</div>
              <div name="remark" field="remark" width="80" allowSort="true">备注</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
<script>
  var Genders = [{ id: 1, text: '启用' }, { id: 0, text: '停用'}];
  mini.parse();
  var datagrid = mini.get("datagrid1");
  datagrid.load();

  function onStatusRenderer(e) {
    for (var i = 0, l = Genders.length; i < l; i++) {
      var g = Genders[i];
      if (g.id == e.value) return g.text;
    }
    return "";
  }

  function search() {
    var siteName = mini.get("siteName").getValue();
    datagrid.load({
      siteName: siteName
    });
  }

  function changeStatus() {
    var data = datagrid.getSelecteds();
    if (data) {
      var ids = "";
      for (var i=0; i < data.length; i++) {
        ids += data[i].id + ",";
      }
      mini.confirm("确定更改所选站点状态？<br>", "更改", function (action) {
        if (action == "ok") {
          SaveData("/recruit/campusSiteController/updateStatus/" + ids, "", function (e) {
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
