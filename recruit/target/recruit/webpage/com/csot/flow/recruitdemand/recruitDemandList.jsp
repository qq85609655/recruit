<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<!DOCTYPE html>
<head>
<%@include file="/webpage/common.jsp"%>
<title>招聘需求管理-招聘代表</title>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/importResume.css" />
<style type="text/css">
.tblQuery2 th {
  font-size: 13px !important;
}

.mini-tree .mini-grid-rows-view {
  height: 100%;
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
          class="path-item a-decoration">招聘流程</a><em class="path-icon">&gt;&gt;</em><span
          class="path-leaf">招聘需求管理</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="con-title">招聘需求管理</div>
        <div class="main">
          <div class="position-import-main blue radius">
            <table class="position-import-tab1">
              <tr>
                <td>
                  <button class="posi-import-btn blue tab-up" id="task-button"
                    onclick="choseState('0',this)">
                    <span>全部</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button"
                    onclick="choseState('1',this)">
                    <span>草稿</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button"
                    onclick="choseState('2',this)">
                    <span>审批中需求</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button"
                    onclick="choseState('3',this)">
                    <span>审批通过需求</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button"
                    onclick="choseState('7',this)">
                    <span>审批不通过需求</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button"
                    onclick="choseState('4',this)">
                    <span>未完成需求</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button"
                    onclick="choseState('5',this)">
                    <span>已完成需求</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button"
                    onclick="choseState('8',this)">
                    <span>已取消需求</span>
                  </button>
                </td>
              </tr>
            </table>
            <div class="account-content">
              <div class="account-search">
                <table class="tblQuery2">
                  <tbody>
                    <tr style="font-size: 15px">
                      <th>&nbsp;岗位名称:</th>
                      <td><input id="postName" class="mini-textbox radius1" name="postName"
                        style="width: 120px;" onenter="search()"></td>
                      <th>&nbsp;职级:</th>
                      <td><input id="rankId" class="mini-combobox radius1" name="rankId"
                        valueField="typeId" onenter="search()" textField="typeName"
                        showNullItem="true" nullItemText="全部" emptyText="全部"
                        onvaluechanged="comboxChange"
                        url="/recruit/datadictGroupTypeController/getDictsByCode/rank_recruit_demand" /></td>
                      <th>&nbsp;流程状态:</th>
                      <td><input id="flowState" class="mini-combobox radius1" name="flowState"
                        valueField="typeId" onenter="search()" textField="typeName"
                        showNullItem="true" nullItemText="全部" emptyText="全部"
                        onvaluechanged="comboxChange"
                        data="[{typeId:1,typeName:'草稿'},{typeId:2,typeName:'审核中'},{typeId:3,typeName:'审核通过'},
                        {typeId:4,typeName:'废弃'}]" /></td>
                      <th>&nbsp;预计到岗日期:</th>
                      <td><input id="startDistributeDate" name="startDistributeDate"
                        class="jobKey radius1 mini-datepicker" type="text" style="width: 100px"
                        tabindex="7" value="" /> - <input id="endDistributeDate"
                        name="endDistributeDate" class="jobKey radius1 mini-datepicker" type="text"
                        style="width: 100px" value="" tabindex="8" />
                    </tr>
                    <tr style="font-size: 15px">
                      <th>&nbsp;是否共承:</th>
                      <td><input id="isShare" class="mini-combobox radius1" name="isShare"
                        valueField="typeId" onenter="search()" textField="typeName"
                        showNullItem="true" nullItemText="全部" emptyText="全部"
                        onvaluechanged="comboxChange"
                        data="[{typeId:1,typeName:'是'},{typeId:2,typeName:'否'}]" /></td>
                      <th>&nbsp;需求部门:</th>
                      <td><input id="orgCode" class="mini-treeselect" name="orgCode"
                        showClose="true" emptyText="全部" oncloseclick="onCloseClick"
                        url="/recruit/organizationController/datagrid" multiSelect="false"
                        textField="cOrgname" valueField="cOrgcode" parentField="cOrgparentcode"
                        popupWidth="300" /></td>
                      <td>&nbsp;&nbsp; <input type="submit" value="查询" tabindex="5"
                        class="search_btn" id="btnRefresh" onclick="search()" name="btnRefresh">
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <div class="blue radius">
                <div class="table-operate">
                  <input type="button" class="button radius btn" id="addRecruitDemand"
                    value="招聘需求申请" onclick="addRecruitDemand()" /> <input type="button"
                    class="button radius btn" id="viewDetail" value="修改需求"
                    onclick="updateRecruitDemand()" /> <input type="button"
                    class="button radius btn" id="editInfo" value="招聘岗位发布/修改" onclick="applyPost()" />
                  <input type="button" class="button radius btn" id="print" value="共承岗位"
                    onclick="sharePost()" /> <input type="button" class="button radius btn"
                    id="print" value="取消共承岗位" onclick="cancelSharePost()" /> <input type="button"
                    class="button radius btn" id="export" value="导出" onclick="exportDemand()" />
                </div>
                <div id="datagrid1" class="mini-datagrid" oncellclick="cellclick" showPager="true"
                  url="/recruit/demand/datagrid?showPager=true&demandState=${demandState}"
                  showEmptyText="true" emptyText="暂无匹配数据" ondrawcell="ondrawcell" idField="id"
                  sizeList="[1,2,50,100]" pageSize="10" allowResize="false" multiSelect="true">
                  <div property="columns">
                    <div type="checkcolumn"></div>
                    <div name="demandId" field="demandId" width="80" allowSort="true">需求流程ID</div>
                    <div name="flowState" field="flowState" width="80" align="center"
                      headerAlign="center" allowSort="true" allowSort="true"
                      renderer="onFlowStateRenderer">流程状态</div>
                    <div name="applyPostName" field="applyPostName" width="80" align="center"
                      cellCls="color-blue curpo updateAtag" headerAlign="center" allowSort="true">岗位名称</div>
                    <div name="applyPostId" field="applyPostId" width="80" allowSort="true"
                      align="center" headerAlign="center">岗位ID</div>
                    <div name="rankName" field="rankName" width="100" allowSort="true"
                      align="center" headerAlign="center">职级</div>
                    <div name="recruiterNumber" field="recruiterNumber" width="60" allowSort="false"
                      align="center" headerAlign="center">接收简历</div>
                    <div name="recruiterName" field="recruiterName" width="60" allowSort="false"
                      align="center" headerAlign="center">匹配简历</div>
                    <div name="deputyName" field="deputyName" width="80" allowSort="true"
                      align="center" headerAlign="center">招聘代表</div>
                    <div name="applyOrganizationName" field="applyOrganizationName" width="80"
                      allowSort="true" align="center" headerAlign="center">需求部门</div>
                    <div name="applyPersonNumber" field="applyPersonNumber" width="60"
                      allowSort="true" align="center" headerAlign="center">需求人数</div>
                    <div name="isFinish" field="isFinish" width="60" allowSort="true" align="center"
                      renderer="onIsFinishRenderer" headerAlign="center">需求状态</div>
                    <div name="websitePostName" field="websitePostName" width="120"
                      allowSort="false" align="center" headerAlign="center">网站发布岗位名称</div>
                    <div name="predictComeDate" field="predictComeDate" width="80" allowSort="true"
                      align="center" headerAlign="center">预计到岗日期</div>
                    <!-- <div name="infoState" field="infoState" width="60" allowSort="false"
                        align="center" headerAlign="center">编辑状态</div> -->
                    <div name="websiteTypes" field="websiteTypes" width="120" allowSort="false"
                      align="center" headerAlign="center">发布的网站</div>
                    <div name="releaseDate" field="releaseDate" width="100" allowSort="false"
                      align="center" headerAlign="center">最新发布日期</div>
                    <div name="offerNumber" field="offerNumber" width="80" allowSort="true"
                      align="center" headerAlign="center">拟入职数量</div>
                    <div name="entryNumber" field="entryNumber" width="80" allowSort="true"
                      align="center" headerAlign="center">已入职数量</div>
                    <div name="infoState" field="infoState" width="120" allowSort="true"
                      align="center" headerAlign="center" renderer="onInfoStateRenderer">岗位发布状态</div>

                    <div name="sharePerson" field="sharePerson" width="80" allowSort="false"
                      align="center" headerAlign="center">共承人</div>
                    <div name="shareRemark" field="shareRemark" width="80" allowSort="false"
                      align="center" headerAlign="center">共承描述</div>

                    <div name="logNum" field="logNum" width="80" allowSort="true"
                      cellCls="color-blue curpo" align="center" headerAlign="center">需求变更记录</div>
                    <div name="changeNum" field="changeNum" width="80" allowSort="true"
                      cellCls="color-blue curpo" align="center" headerAlign="center">需求变更申请记录</div>
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
  grid.load();
  var isHandler = false;
</script>
<script type="text/javascript"
  src="${webRoot}/resources/js/flow/recruitdemand/recruitDemandList.js?v=6"></script>
</html>








