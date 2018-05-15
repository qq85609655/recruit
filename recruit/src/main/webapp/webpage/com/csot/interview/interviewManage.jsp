<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
  <head>
  <%@include file="/webpage/common.jsp"%>
	  <title>面试管理</title>
	  <link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/position/positionManage.css"/>
  </head>
  <body onload="removeLoad();">
	  <jsp:include page="/webpage/header.jsp"></jsp:include>
    <div class="co">
    	  <div class="position-path co-right-center">
    			<span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">易聘</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">面试管理</span>
    	  </div>
			  <div class="co-right-main co-right-center">
                  <input id="isAdmin" type="hidden" <shiro:hasRole name="admin"> value="1" </shiro:hasRole> >
				  <div class="main">
					  <form id="searchPositionManage">
						  <div class="search-box blue radius">
							  <table>
								  <tbody>
										<tr>
											<td>
	                      <span class="search-item" style="width: 120px;">应聘者录入日期：</span>
												<input id="startDate" class="jobKey radius1 mini-datepicker"
													type="text" style="width: 100px" tabindex="7" value=""/> - 
												<input id="endDate" class="jobKey radius1 mini-datepicker" type="text"
													style="width: 100px" value="" tabindex="8"/>
												&nbsp;&nbsp;
												<input id="searchKey" class="jobKey input-l radius1" type="text" tabindex="2" maxlength="20" value="">
	                      &nbsp;&nbsp;
	                      <input id="btnSearchOK" class="search_btn radius1 btn" type="button" tabindex="11" value="搜索" name="btnSearchOK" onclick="search()" />
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</form>
					  <div class="blue radius">
						  <div class="table-operate">
				<input type="button" class="button radius btn" id="editInfo" value="编辑" onclick="editInfo()" />
              	<input type="button" class="button radius btn" id="print" value="导出信息数据" onclick="printResume()" />
                <input type="button" class="button radius btn" id="export" value="导出打印表格" onclick="exportData()" />
						</div>
						<div id="datagrid1" class="mini-datagrid" url="/recruit/interviewInfoController/queryInterviewListByPage?showPager=true" 
							idField="id" sizeList="[1,2,50,100]" pageSize="10" allowResize="false" multiSelect="true" >
						    <div property="columns">
	     				    <div type="checkcolumn"></div>
	     				    <div name="personCode" field="personCode" width="80" allowSort="true" >人员编码</div>
					        <div name="cnname" field="cnname" width="80" align="center" headerAlign="center" allowSort="true" allowSort="false">中文姓名</div>    
					        <div name="namepy" field="namepy" width="80" align="center" headerAlign="center" allowSort="false">姓名拼音</div>                            
					        <div name="enname" field="enname" width="80"  allowSort="false" align="center" headerAlign="center">英文姓名</div> 
	                <div name="phonenumber" field="phonenumber" width="100"  allowSort="false" align="center" headerAlign="center">手机号码</div>
	                <div name="recruiterNumber" field="recruiterNumber" width="60"  allowSort="false" align="center" headerAlign="center">招聘人员工号</div>
	                <div name="recruiterName" field="recruiterName" width="60"  allowSort="false" align="center" headerAlign="center">招聘人员姓名</div>
	                <div name="createtime" field="createtime" width="80" allowSort="true" align="center" headerAlign="center" renderer="onDateRenderer">应聘者录入时间</div>
	                <div name="updateTime" field="updateTime" width="80" allowSort="true" align="center" headerAlign="center" renderer="onDateRenderer">最后编辑时间</div>
	                <div name="editPerson" field="editPerson" width="60" allowSort="false" align="center" headerAlign="center">编辑人</div>
						    </div>
							</div>
						</div>
					</div>
				</div>
    </div>
    <jsp:include page="/webpage/footer.jsp"></jsp:include>
  </body>
	<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.cookie.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/interview/interviewManage.js"></script>
</html>








