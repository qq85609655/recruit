<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<title>共承岗位</title>
</head>
<body onload="removeLoad();">

  <div class="" style="padding: 5px;">
    <div class="account-search">
      <table class="tblQuery2">
        <tbody>
          <tr style="font-size: 15px">
            <th>&nbsp;姓名:</th>
            <td><input id="name" class="mini-textbox radius1" name="name" style="width: 120px;"
              onenter="search()"></td>
            <th>&nbsp;工号:</th>
            <td><input id="workCode" class="mini-textbox radius1" name="workCode"
              style="width: 120px;" onenter="search()"></td>
            <td>&nbsp;&nbsp; <input type="submit" value="查询" tabindex="5" class="search_btn"
              id="btnRefresh" onclick="search()" name="btnRefresh">
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <form id="form1" class="fieldset-body" method="post" enctype="multipart/form-data">
      <div class="blue radius" style="margin: 20px;">
        <div id="datagrid1" class="mini-datagrid" oncellclick="cellclick" showPager="true"
          url="/recruit/baseUserController/datagridRecruit?showPager=true" showEmptyText="true"
          emptyText="暂无匹配数据" ondrawcell="ondrawcell" idField="id" sizeList="[1,2,50,100]"
          pageSize="10" allowResize="false" multiSelect="true">
          <div property="columns">
            <div type="checkcolumn"></div>
            <div field="account" width="60" headerAlign="center" allowSort="true">帐号</div>
            <div field="name" width="40" headerAlign="center">姓名</div>
            <div field="workCode" width="40" headerAlign="center">工号</div>
          </div>
        </div>
        <br />
        <div class="table-operate">
          共承描述： <input class="mini-textarea" style="width: 86%; height: 56px;" required="true"
            name="remark" id="remark" />
        </div>
        <div class="table-operate" style="text-align: center; margin-top: 20px;">
          <input type="button" class="button radius btn" id="addRecruitDemand" value="确认"
            onclick="onOk()" onclick="addRecruitDemand()" /> <input type="button"
            class="button radius btn" id="addRecruitDemand" value="取消" onclick="onCancel()"
            onclick="addRecruitDemand()" />
        </div>
      </div>
    </form>
  </div>
</body>
<script type="text/javascript">
  mini.parse();
  var type = "${param.type}";
  var form = new mini.Form("form1");
  var param = new Object();
  param.groupId = 43; //43为招聘代表组
  var grid = mini.get("datagrid1");
  grid.load(param);
  //查询
  function search() {
    var grid = mini.get("datagrid1");
    param.name = mini.get("name").getValue();
    param.workCode = mini.get("workCode").getValue();
    grid.load(param);
  }

  //渲染列表数据
  function ondrawcell(e) {
    var row = e.row, column = e.column, field = e.field, value = e.value;
    if (field == "updateDate" && row.updateDate != null) {
      //修改时间格式化
      e.cellHtml = new Date(row.updateDate).format("yyyy-MM-dd hh:mm:ss");
    }
  }

  //取消按钮
  function onCancel(e) {
    CloseWindow("close");
  }
  //确认按钮
  function onOk() {
    //确保选中一条数据
    var rows = grid.getSelecteds();
    if (rows.length > 0) {
      form.validate();
      if (form.isValid() == false) {
        return;
      }
      //新增共承岗位记录数据
      var param = new Object();
      param.shaerPersonId = rows[0].workCode;
      param.recruitDemandId = "${param.id}";
      param.remark = mini.get("remark").getValue();
      param.shaerPersonName = rows[0].name;
      SaveData("/recruit/recruitDemandShareController/save", param);
      //CloseWindow("ok");
    } else {
      ShowWarnTip("请选择一个共承人");
    }
  }
</script>
</html>









