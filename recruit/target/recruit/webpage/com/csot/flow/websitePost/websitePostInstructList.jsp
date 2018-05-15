<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<title>日程安排</title>
<link rel="stylesheet" type="text/css"
  href="${webRoot}/resources/css/flow/recruitdemand/recruitDemandList.css" />
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/importResume.css" />
<style type="text/css">
.tblQuery2 th {
  font-size: 13px !important;
}
</style>
</head>
<body onload="removeLoad();">
  <jsp:include page="/webpage/header.jsp"></jsp:include>
  <div class="co">
    <div class="co-right">
      <div class="position-path co-right-center">
        <span class="path-title">您的位置 :</span><a class="path-item a-decoration"
          href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a
          class="path-item a-decoration">招聘支持</a><em class="path-icon">&gt;&gt;</em><span
          class="path-leaf">日程安排</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="con-title">日程安排</div>
        <div class="main">
          <div class="position-import-main blue radius">
            <table class="position-import-tab1">
              <tr>
                <td>
                  <button class="posi-import-btn blue tab-up" id="task-button"
                    onclick="choseState('',this)">
                    <span>全部 </span>
                  </button>
                  <button class="posi-import-btn blue" id="task-button"
                    onclick="choseState('1',this)">
                    <span>前程无忧 </span>
                  </button>
                  <button class="posi-import-btn blue" id="detail-button"
                    onclick="choseState('2',this)">
                    <span>智联</span>
                  </button>
                  <button class="posi-import-btn blue" id="detail-button"
                    onclick="choseState('3',this)">
                    <span>猎聘</span>
                  </button>
                  <button class="posi-import-btn blue" id="detail-button"
                    onclick="choseState('4',this)">
                    <span>人才热线</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button"
                    onclick="choseState('5',this)">
                    <span>官网</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button"
                    onclick="choseState('6',this)">
                    <span>荐客</span>
                  </button>
                </td>
              </tr>
            </table>
            <div class="account-content">
              <div class="account-search">
                <table class="tblQuery2">
                  <tbody>
                    <tr style="font-size: 15px">
                      <th>&nbsp;操作前状态:</th>
                      <td><input id="bState" class="mini-combobox" name="bState"
                        valueField="typeId" onenter="search()" textField="typeName"
                        showNullItem="true" nullItemText="全部"
                        data="[{typeId:1,typeName:'发布中'},{typeId:2,typeName:'暂停'},{typeId:3,typeName:'未发布'}]" /></td>

                      <th>&nbsp;操作后状态:</th>
                      <td><input id="aState" class="mini-combobox" name="aState"
                        valueField="typeId" onenter="search()" textField="typeName"
                        showNullItem="true" nullItemText="全部"
                        data="[{typeId:1,typeName:'发布中'},{typeId:2,typeName:'暂停'},{typeId:3,typeName:'未发布'}]" /></td>

                      <th>&nbsp;指令类型:</th>
                      <td><input id="instructType" class="mini-combobox" name="instructType"
                        valueField="typeId" onenter="search()" textField="typeName"
                        showNullItem="true" nullItemText="全部"
                        data="[{typeId:1,typeName:'发布'},{typeId:2,typeName:'修改'},{typeId:3,typeName:'暂停'},{typeId:4,typeName:'重启'}]" /></td>
                    </tr>
                    <tr style="font-size: 15px">
                      <th>&nbsp;操作情况:</th>
                      <td><input id="isDeal" class="mini-combobox" name="isDeal"
                        valueField="typeId" onenter="search()" textField="typeName"
                        showNullItem="true" nullItemText="全部"
                        data="[{typeId:1,typeName:'已操作'},{typeId:2,typeName:'未操作'}]" /></td>
                      <th>&nbsp;岗位名称:</th>
                      <td><input id="postNameStr" class="mini-textbox" name="postNameStr"
                        style="width: 120px;" onenter="search()"></td>
                      <th>&nbsp;网站发布岗位名称:</th>
                      <td><input id="webpostName" class="mini-textbox" name="webpostName"
                        style="width: 120px;" onenter="search()"></td>
                      <td>&nbsp;&nbsp; <input type="submit" value="查询" tabindex="5"
                        class="search_btn" id="btnRefresh" onclick="search()" name="btnRefresh">
                      </td>
                    </tr>


                  </tbody>
                </table>
              </div>
              </form>
              <div class="blue radius">
                <div class="table-operate">
                  <input type="button" class="button radius btn" id="editInfo" value="已操作"
                    onclick="dealInstruct()" /> <input type="button" class="button radius btn"
                    id="export" value="导出" onclick="exportData()" />
                </div>
                <div id="datagrid1" class="mini-datagrid" oncellclick="cellclick" showPager="true"
                  url="/recruit/instruct/datagrid?showPager=true&demandState=${demandState}"
                  idField="id" sizeList="[1,2,50,100]" pageSize="10" allowResize="false"
                  ondrawcell="ondrawcell" multiSelect="true">
                  <div property="columns">
                    <div type="checkcolumn"></div>
                    <div name="postId" field="postId" width="100" allowSort="true">岗位ID</div>
                    <div name="postName" field="postName" width="100" align="center"
                      headerAlign="center" allowSort="true" allowSort="true"
                      cellCls="color-blue curpo updateAtag" renderer="onFlowStateRenderer">岗位名称</div>
                    <div name="deputyName" field="deputyName" width="100" align="center"
                      headerAlign="center" allowSort="true">招聘代表</div>
                    <div name="createDate" field="createDate" width="80" allowSort="true"
                      align="center" headerAlign="center">指令时间</div>
                    <div name="websiteType" field="websiteType" width="100" allowSort="true"
                      align="center" headerAlign="center">招聘渠道</div>
                    <div name="websitePostName" field="websitePostName" width="100"
                      allowSort="true" align="center" headerAlign="center">网站发布岗位名称</div>
                    <div name="beforeState" field="beforeState" width="100" allowSort="true"
                      align="center" headerAlign="center">操作前发布状态</div>
                    <div name="instructType" field="instructType" width="80" allowSort="true"
                      align="center" headerAlign="center">指令类型</div>
                    <div name="change" field="change" width="80"
                      cellCls="color-blue curpo updateAtag" allowSort="true" align="center"
                      headerAlign="center">修改点</div>
                    <div name="isDeal" field="isDeal" width="80" allowSort="true" align="center"
                      headerAlign="center">操作情况</div>
                    <div name="afterState" field="afterState" width="80" allowSort="true"
                      align="center" headerAlign="center">现发布状态</div>
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
<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.cookie.js"></script>
<script type="text/javascript">
  mini.parse();
  var grid = mini.get("datagrid1");
  $(function(){
    $(".posi-import-btn").eq(0).click();
  });
</script>
<script type="text/javascript"
  src="${webRoot}/resources/js/flow/websitePost/websitePostInstructList.js"></script>
</html>









