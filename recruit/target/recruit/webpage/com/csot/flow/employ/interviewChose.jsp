<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<title>招聘需求管理</title>
</head>
<body onload="removeLoad();">
  <div class="account-search" style="padding: 5px;">
    <form id="searchPositionManage">
      <div class="search-box blue radius">
        <table>
          <tbody>
            <tr>
              <td><span class="search-item" style="width: 120px;">应聘者录入日期：</span> <input
                id="startDate" class="jobKey radius1 mini-datepicker" type="text"
                style="width: 100px" tabindex="7" value="" /> - <input id="endDate"
                class="jobKey radius1 mini-datepicker" type="text" style="width: 100px" value=""
                tabindex="8" /> &nbsp;&nbsp; <input id="searchKey" class="jobKey input-l radius1"
                type="text" tabindex="2" maxlength="20" value=""> &nbsp;&nbsp; <input
                id="btnSearchOK" class="search_btn radius1 btn" type="button" tabindex="11"
                value="搜索" name="btnSearchOK" onclick="search()" /></td>
            </tr>
          </tbody>
        </table>
      </div>
    </form>
    <div class="blue radius">
      <div class="table-operate" style="padding-top: 0px;">
        <input type="button" class="button radius btn" id="addRecruitDemand" value="确认"
          onclick="onOk()" onclick="addRecruitDemand()" /> <input type="button"
          class="button radius btn" id="addRecruitDemand" value="取消" onclick="onCancel()"
          onclick="addRecruitDemand()" />
      </div>
      <div id="datagrid1" class="mini-datagrid"
        url="/recruit/interviewController/queryInterviewListByPage?showPager=true" idField="id"
        sizeList="[1,2,50,100]" pageSize="10" allowResize="false" multiSelect="true"
        style="height: 400px;">
        <div property="columns">
          <div type="checkcolumn"></div>
          <div name="personCode" field="personCode" width="80" allowSort="true">人员编码</div>
          <div name="cnname" field="cnname" width="80" align="center" headerAlign="center"
            allowSort="true" allowSort="false">中文姓名</div>
          <div name="namepy" field="namepy" width="80" align="center" headerAlign="center"
            allowSort="false">姓名拼音</div>
          <div name="enname" field="enname" width="80" allowSort="false" align="center"
            headerAlign="center">英文姓名</div>
          <div name="phonenumber" field="phonenumber" width="100" allowSort="false" align="center"
            headerAlign="center">手机号码</div>
          <div name="recruiterNumber" field="recruiterNumber" width="60" allowSort="false"
            align="center" headerAlign="center">招聘人员工号</div>
          <div name="recruiterName" field="recruiterName" width="60" allowSort="false"
            align="center" headerAlign="center">招聘人员姓名</div>
          <div name="createtime" field="createtime" width="80" allowSort="true" align="center"
            headerAlign="center" renderer="onDateRenderer">应聘者录入时间</div>
          <div name="updateTime" field="updateTime" width="80" allowSort="true" align="center"
            headerAlign="center" renderer="onDateRenderer">最后编辑时间</div>
          <div name="editPerson" field="editPerson" width="60" allowSort="false" align="center"
            headerAlign="center">编辑人</div>
        </div>
      </div>
    </div>
  </div>
</body>
<script type="text/javascript">
  mini.parse();
  var grid = mini.get("datagrid1");
  param = new Object();
  param.stateSelf = 6;
  grid.load(param);

  function GetData() {
    var rows = grid.getSelecteds();
    return rows[0];
  }
  //取消按钮
  function onCancel(e) {
    CloseWindow("close");
  }

  function search() {
    var startDate = mini.get("startDate").getFormValue();
    var endDate = mini.get("endDate").getFormValue();
    var searchKey = $("#searchKey").val();
    var grid = mini.get("datagrid1");
    grid.load({
      startDate : startDate,
      endDate : endDate,
      searchKey : searchKey
    });
  }

  function onKeyEnter(e) {
    search();
  }

  function onDateRenderer(e) {
    var value = e.value;
    if (value)
      return new Date(value).format("yyyy-MM-dd");
    return "";
  }
  //确认按钮
  function onOk() {
    //确保选中一条数据
    var rows = grid.getSelecteds();
    if (rows.length > 0) {
      CloseWindow("ok");
    } else {
      ShowWarnTip("请选择一条记录");
    }
  }
</script>
</html>









