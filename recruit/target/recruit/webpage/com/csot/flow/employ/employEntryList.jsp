<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<title>录用管理-入职</title>
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
          class="path-item a-decoration">招聘流程</a><em class="path-icon">&gt;&gt;</em><span
          class="path-leaf">录用管理-入职</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="con-title">录用管理-入职</div>
        <div class="main">
          <div class="position-import-main blue radius">
            <table class="position-import-tab1">
              <tr>
                <td>
                  <button class="posi-import-btn blue " id="task-button"
                    onclick="choseState('0',this)">
                    <span>录用</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button1"
                    onclick="choseState('1',this)">
                    <span>offer</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button2"
                    onclick="choseState('2',this)">
                    <span>拒绝offer</span>
                  </button>
                  <button class="posi-import-btn blue tab-up" id="detail-button3"
                    onclick="choseState('3',this)">
                    <span>入职</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button4"
                    onclick="choseState('4',this)">
                    <span>放弃入职</span>
                  </button>
                </td>
              </tr>
            </table>
            <div class="account-content">
              <div class="account-search">
                <table class="tblQuery2">
                  <tbody>
                    <tr style="font-size: 15px">
                      <th>&nbsp;职位名称:</th>
                      <td><input id="postName" class="mini-text" name="postName"
                        style="width: 120px;" onenter="search()"></td>
                      <th>&nbsp;候选人名称:</th>
                      <td><input id="candidateName" class="mini-text" name="candidateName"
                        style="width: 120px;" onenter="search()"></td>
                      <td>&nbsp;&nbsp; <input type="submit" value="查询" tabindex="5"
                        class="search_btn" id="btnRefresh" onclick="search()" name="btnRefresh">
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <div class="blue radius">
                <div class="table-operate">
                  <input type="button" class="button radius btn" id="tagAdd" value="标签"
                    onclick="addTag()" /> <input type="button" class="button radius btn" id="print"
                    value="黑名单" onclick="inBlacklist()" />
                </div>
                <div id="datagrid1" class="mini-datagrid" oncellclick="cellclick" showPager="true"
                  url="/recruit/employ/datagrid?showPager=true&stage=4" ondrawcell="ondrawcell"
                  idField="id" sizeList="[1,2,50,100]" pageSize="10" allowResize="false"
                  multiSelect="true">
                  <div property="columns">
                    <div type="checkcolumn"></div>
                    <div name="candidateName" field="candidateName" width="80" allowSort="true">候选人</div>
                    <div name="employPostName" field="employPostName" width="80" align="center"
                      headerAlign="center" allowSort="true" allowSort="false">职位名称</div>
                    <div name="employOrgName" field="employOrgName" width="80" align="center"
                      headerAlign="center" allowSort="false">应聘部门</div>
                    <div name="interviewForm" field="interviewForm" width="80" allowSort="false"
                      align="center" headerAlign="center">应聘申请表</div>
                    <div name=appraisalInterviewHr field="appraisalInterviewHr" width="100"
                      allowSort="false" align="center" headerAlign="center">HR面试评估</div>
                    <div name="appraisalInterview" field="appraisalInterview" width="60"
                      allowSort="false" align="center" headerAlign="center">面试官评估</div>
                    <div name="stage" field="stage" width="60" allowSort="false" align="center"
                      renderer="onStageRenderer" headerAlign="center">阶段</div>
                    <div name="flowState" field="flowState" width="60" allowSort="false"
                      renderer="onFlowStateRenderer" align="center" headerAlign="center">流程阶段</div>
                    <div name="simulationEntryDate" field="simulationEntryDate" width="80"
                      allowSort="true" align="center" headerAlign="center">拟入职时间</div>
                    <div name="entryDate" field="entryDate" width="80" allowSort="true"
                      align="center" headerAlign="center">入职时间</div>
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
  <jsp:include page="./tagSelect.jsp" />
</body>
<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.cookie.js"></script>
<script type="text/javascript">
  mini.parse();
  var grid = mini.get("datagrid1");
  grid.load();
</script>
<script type="text/javascript" src="${webRoot}/resources/js/flow/employ/employList.js?v=2"></script>
</html>









