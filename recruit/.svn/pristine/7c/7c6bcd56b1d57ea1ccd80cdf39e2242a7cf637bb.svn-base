<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<!DOCTYPE html>
<head>
<%@include file="/webpage/common.jsp"%>
<title>招聘需求管理</title>
<link rel="stylesheet" type="text/css"
  href="${webRoot}/resources/css/candidate/chooseDemandList.css" />
<link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/importResume.css" />
</head>
<body onload="removeLoad();">
        
                       <div class="table-operate">
                     <input type="button" class="button radius btn" id="ok" onclick="onOk()" value="确定" />
                     <input type="button" class="button radius btn" id="cancel" onclick="onCancel()" value="取消" />
                   </div>
                </div>     
                <div class="blue radius">
                  <div id="datagrid1" class="mini-datagrid" oncellclick="cellclick" showPager="true"
                    url="/recruit/demand/datagrid?showPager=true&demandState=${demandState}"
                    idField="id" sizeList="[1,2,50,100]" pageSize="10" allowResize="false"
                    multiSelect="true" style="height: 350px;">
                    <div property="columns">
                      <div type="checkcolumn"></div>
                      <div name="demandId" field="demandId" width="80" allowSort="true">需求流程ID</div>
                     
                      <div name="applyPostName" field="applyPostName" width="80" align="center"
                         headerAlign="center" allowSort="false">岗位名称</div>
                      <div name="applyPostId" field="applyPostId" width="80" allowSort="false"
                        align="center" headerAlign="center">岗位ID</div>
                      <div name="rankName" field="rankName" width="100" allowSort="false"
                        align="center" headerAlign="center">职级</div>
                     
                      <div name="deputyName" field="deputyName" width="80" allowSort="true"
                        align="center" headerAlign="center">招聘代表</div>
                      <div name="applyOrganizationName" field="applyOrganizationName" width="80"
                        allowSort="true" align="center" headerAlign="center">需求部门</div>
                    </div>
                  </div>
</body>
<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.cookie.js"></script>
<script type="text/javascript">
  mini.parse();
  var grid = mini.get("datagrid1");
  param = new Object();
  param.stateSelf = 6;
  grid.load();
  var candidateId = "${candidateId}";
  
</script>
<script type="text/javascript" src="${webRoot}/resources/js/candidate/addCandidatePostList.js"></script>
</html>









