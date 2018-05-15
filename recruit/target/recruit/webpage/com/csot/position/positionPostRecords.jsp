<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/common.jsp"%>
<html>
  <head>
	  <title>职位分发记录</title>
	  <link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/position/positionPostRecords.css"/>
  </head>
  <body onload="removeLoad();">
	  <jsp:include page="/webpage/header.jsp"></jsp:include>
    <div class="co">
    	<div class="co-left">
    		<jsp:include page="/webpage/left-bar.jsp"></jsp:include>
    	</div>
    	<div class="co-right">
    	  <div class="position-path co-right-center">
    			<span class="path-title">您的位置 :</span>
    			<a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a>
    			<em class="path-icon">&gt;&gt;</em>
    			<a class="path-item a-decoration">易播职</a>
    			<em class="path-icon">&gt;&gt;</em>
    			<span class="path-leaf">职位分发记录</span>、
    	  </div>
			<div class="co-right-main co-right-center">
				<div class="con-title">职位分发记录</div>
				<div class="main">
					<div class="jobPost-record">
						<form action="" method="post">
							<div class="jobPost-form blue radius">
								<table class="jobPost-tab">
									<tbody>
										<tr class="jobPost-tr">
											<td class="jobPost-td"><font>聘用部们:</font></td>
											<td class="jobPost-td-l">
												<input id="department1" class="choose_btn radius1 dep-choosebtn" type="text" readonly value="请选择部门">
												<input id="hidDeptId" type="hidden" value="" name="DeptId"> 
												<input id="hid_DeptName" type="hidden" id="department2" name="department2" value="选择部门">
											</td>
											<td class="jobPost-td"><font>发布人:</font></td>
											<td class="jobPost-td-l">
												<input id="publisher1" class="choose_btn radius1" type="text" name="poster" readonly value="${w_Login_Client.user.name }" onclick="openSelPost('#publisher1','#hidrecruiter','#publisher2')"/> 
												<input id="hidrecruiter" type="hidden" value="${w_Login_Client.user.id}" name="hidrecruiter"/>
												<input id="publisher2" name="publisher2" type="hidden" value="${w_Login_Client.user.name}"/> 
											</td>
										</tr>
										<tr class="jobPost-tr">
											<td><font>分发站点:</font></td>
											<td>
												<select class="jobPost-select" id="publishSite1">
													<option value="">请选择</option>
													<option value="前程无忧" id="Job51">前程无忧</option>
													<option value="中华英才网" id="Chinahr">中华英才网</option>
													<option value="中国人才热线" id="Cjol">中国人才热线</option>
													<option value="智联招聘" id="Zhaopin">智联招聘</option>
													<option value="猎聘网" id="Liepin">猎聘网</option>
													<option value="赶集网" id="Ganji">赶集网</option>
													<option value="一览英才网" id="Job1001">一览英才网</option>
												</select>
											</td>
											<td><font>分发结果:</font></td>
											<td>
												<select class="jobPost-select" id="publishResult1">
													<option value="">全部</option>
													<option value="成功">成功</option>
													<option value="失败">失败</option>
												</select>
											</td>
										</tr>
										<tr class="jobPost-tr">
											<td><font>职位:</font></td>
											<td><input type="text" name="positionName1" id="positionName1" class="jobPost-input radius1"/></td>
										</tr>
										<tr class="jobPost-tr">
											<td><font>分发日期:</font></td>
											<td colspan="3">
												<input class="mini-datepicker" id="startDistributeDate" name="startDistributeDate" width="100px"/>
												<span class="date-split">--</span>
												<input class="mini-datepicker" id="endDistributeDate" width="100px" name="endDistributeDate"/>
											</td>
										</tr>
										<tr class="jobPost-tr">
											<td><font>到期日期:</font></td>
											<td colspan="3">
												<input class="mini-datepicker" id="startExpireDate" name="startExpireDate" width="100px" height="24px"/>
												<span class="date-split">--</span>
												<input class="mini-datepicker" id="endExpireDate" width="100px" height="24px"name="endExpireDate"/>
											</td>
										</tr>
										<tr>
											<td class="jobPost-post">
												<input type="button" id="query" name="query" class="jobPost-query search_btn btn radius1" value="查询"  onclick="search()"/>
											</td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
						</form>
						<div class="jobPost-table blue radius">
							<div class="table-operate">
								<input class="jobPost-b-distribute button btn radius" id="posi_publish_btn" type="button" name="distribute" value="分发"/>
							</div>
							<div id="datagrid1" class="mini-datagrid" url="/recruit/position/queryPositionDistributeList" 
								idField="id" sizeList="[10,20,50,100]" pageSize="10" allowResize="false" multiSelect="true" style="height:350px;" onrowclick="onrowclick" ondrawcell="ondrawcell">
						    <div property="columns">
							    <div type="indexcolumn"></div>
							    <div field="positionName" width="120" allowSort="true">职位名称</div> 
							    <div field="positionCode" width="60" headerAlign="center" align="center" allowSort="true">职位编码</div>
							    <!-- <div field="departmentCode" width="100" renderer="onGenderRenderer">内部编码</div> -->
							    <div field="workPlace" width="100" headerAlign="center" allowSort="true">地区</div> 
							    <div field="publisher" width="60" allowSort="true">发布人</div>  
							    <div field="publishSite" width="80" allowSort="true">分发站点</div>                                
							    <div field="releaseDate" width="80" allowSort="true" headerAlign="center" align="center">发布日期</div>  
							    <div field="distributeDate" width="80" allowSort="true" headerAlign="center" align="center">分发日期</div>
							    <div field="expireDate" width="80" allowSort="true" headerAlign="center" align="center">到期日期</div>
							    <div field="publishResult" width="60" align="center" allowSort="true">分发结果</div>      
							    <div field="errorMessage" width="250" allowSort="true">错误信息</div>
							    <div field="publishUrl" width="100" allowSort="true">分发结果网址</div>  
							  </div>
							</div>
						</div>
					</div>
					&nbsp;
				</div>
			</div>
		</div>   	  
    </div>
    <div class="csot-department">
	    <div class="mini-tree mini-dept-tree radius" id="mini-dept-tree" onnodeselect="onNodeSelect" textField="orgName"  resultAsTree="false" allowSelect="true"  showTreeIcon="false"></div>
	  </div>
	  <jsp:include page="/webpage/com/csot/publicPage/choosePerson.jsp"></jsp:include>
    <jsp:include page="/webpage/footer.jsp"></jsp:include>
  </body>
  <script type="text/javascript" src="${webRoot}/resources/js/public/department.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/position/positionPostRecords.js"></script>
</html>