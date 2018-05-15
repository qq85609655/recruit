<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@include file="/webpage/common.jsp"%>
<html>
  <head>
	  <title>职位管理</title>
	  <link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/position/positionManage.css"/>
  </head>
  <body onload="removeLoad();">
	  <jsp:include page="/webpage/header.jsp"></jsp:include>
    <div class="co">
    	<div class="co-left">
    		<jsp:include page="/webpage/left-bar.jsp"></jsp:include>
    	</div>
    	<div class="co-right">
    	  <div class="position-path co-right-center">
    			<span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">易播职</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">职位管理</span>
    	  </div>
			  <div class="co-right-main co-right-center">
				  <div class="con-title">职位管理</div>
				  <div class="main">
					  <form id="searchPositionManage">
						  <div class="search-box blue radius">
							  <table>
								  <tbody>
									<tr>
										<td width="110"><span class="search-item">职位名称：</span></td>
										<td width="255">
											<input id="positionName1" class="jobKey input-l radius1" type="text" tabindex="1" maxlength="20"  name="positionName1">
										</td>
										<td width="120"><span class="search-item" style="width: 85px;">职位发布者：</span></td>
										<td>
											<input id="selPostBy" class="choose_btn radius1 input-l" type="text" readonly value="请选择人员" name="selPostBy" onclick="openSelPost('#selPostBy','#hidPostBy','#publisher1')"/> 
											<input id="hidPostBy" type="hidden" value="" name="postby"/>
											<input id="publisher1" type="hidden" name="publisher1" value=""/> 
										</td>
									</tr>
									<tr>
										<td><span class="search-item" style="width: 75px;">招聘专员：</span></td>
										<td>
											<input id="selrecruiter" class="choose_btn radius1 input-l" type="text" readonly value="请选择人员" name="selrecruiter" onclick="openSelPost('#selrecruiter','#hidrecruiter','#recruiter1')"/> 
											<input id="hidrecruiter" type="hidden" value="" name="recruiter"/>
											<input id="recruiter1" name="recruiter1" class="choose_btn" type="hidden" value=""/> 
										</td>
										<td><span class="search-item">职位标记：</span></td>
										<td>
											<input id="label1" class="jobKey input-l radius1" type="text" tabindex="1" maxlength="20" value="" name="label1">
										</td>
									</tr>
									<tr>
										<td><span class="search-item">发布日期：</span></td>
										<td>
											<input id="startDistributeDate"name="startDistributeDate" class="jobKey radius1 mini-datepicker"
												type="text" style="width: 100px" tabindex="7" value=""/> - 
											<input id="endDistributeDate" name="endDistributeDate" class="jobKey radius1 mini-datepicker" type="text"
												style="width: 100px" value="" tabindex="8"/>
										</td>
										<td><span class="search-item">部门：</span></td>
										<td>
											<input id="hidDeptId" type="hidden" value="" name="DeptId"> 
											<input id="department1" class="choose_btn radius1 dep-choosebtn input-l" type="text" readonly value="请选择部门">
											<input id="hid_DeptName" type="hidden" id="department2" name="department2" value="选择部门">
										</td>
									</tr>
								</tbody>
							</table>

							<table class="more-search">
								<tbody>
									<tr>
										<td width="110"><span class="search-item">职位编码：</span></td>
										<td width="255">
											<input id="positionCode1" name="positionCode1" class="jobKey input-l radius1" type="text" tabindex="2" maxlength="20" value="">
										</td>
										<td width="120"><span class="search-item">内部编码：</span></td>
										<td>
											<input  id="departmentCode1" name="departmentCode1" class="jobKey input-l radius1" type="text" tabindex="2" maxlength="50" value="">
										</td>
									</tr>
									<tr>
										<td><span class="search-item">状态：</span></td>
										<td><t:dictSelect type="select" id="status1" field="status" typeGroupCode="position-status" defaultVal="2" hasLabel="false"></t:dictSelect></td>
										<td><span class="search-item">地区：</span></td>
										<td><t:dictSelect type="select" id="workPlace1" field="workPlace" typeGroupCode="work-place" defaultVal="0" hasLabel="false"></t:dictSelect></td>
									</tr>
									<tr>
										<td><span class="search-item">截止日期：</span></td>
										<td><input id="startExpireDate" name="startExpireDate" class="jobKey radius1 mini-datepicker"
											type="text" style="width: 100px" tabindex="9" bj="cBj"
											value=""> - <input
											id="endExpireDate" name="endExpireDate" class="jobKey radius1 mini-datepicker" type="text"
											style="width: 100px" value=""
											tabindex="10" bj="cBj"></td>
										<td><span class="search-item">招聘类别：</span></td>
										<td>
											<div id="recruitType1" class="inline">
												<input type="checkbox" value="009-000" name="recruitType1" /> 
												<label id="recruitType_0_Label" for="recruitType_0" class="checkbox-item">社招</label> 
												<input type="checkbox" value="009-001" name="recruitType1" /> 
												<label id="recruitType_0_Label" for="recruitType_0" class="checkbox-item">校招</label> 
												<input type="checkbox" value="009-002" name="recruitType1"> 
												<label id="recruitType_1_Label" for="recruitType_1" class="checkbox-item">内荐</label>
												<input type="checkbox" value="009-003" name="recruitType1"> 
												<label id="recruitType_1_Label" for="recruitType_1" class="checkbox-item">内部招聘</label>
											</div>
										</td>
									</tr>
									<tr>
										<td><span class="search-item">职能类别：</span></td>
										<td><t:dictSelect type="select" id="positionType1" field="position-type" typeGroupCode="position-type" defaultVal="0" hasLabel="false"></t:dictSelect></td>
										<td><span class="search-item">职位级别：</span></td>
										<td><t:dictSelect type="select" id="positionLevel1" field="position-level" typeGroupCode="position-level" defaultVal="0" hasLabel="false"></t:dictSelect></td>
									</tr>
								</tbody>
							</table>
							<div class="search-box-last">
								<input id="btnSearchOK" class="search_btn radius1 btn" type="button" tabindex="11" value="搜索" name="btnSearchOK" onclick="search()" /> 
								<span class="more-expand"><span class="font-icon more-expand-icon icon-angle-double-down"></span></span>
							</div>
						</div>
					</form>
        	  <div class="phone_no" id="validateChecked" style="display:none;">
              <div class="phone-info_tanchu">
                <div class="tanchujiantou"></div>
                <div class="tanchu_nr">请选择职位</div>                        
              </div>
            </div>
					  <div class="position-table blue radius">
						  <div class="table-operate">
							    <input type="button" class="button radius btn" id="distributionPosition" value="分发" onclick="distributionPosition()"></input> 
							<input type="button" class="button radius btn" value="匹配设置"></input> 
							  <input type="button" class="button radius btn" id="setSecurity" value="保密设置" onclick="setSecurity('#validateChecked','position-security-win','#setSecurity')"></input> 
							<input type="button" class="button radius btn" value="刷新"></input> 
						    <input type="button" class="button radius btn" value="重新发布" id="againRelease" onclick="setSecurity('#validateChecked','position-againRelease-win','#againRelease')"></input> 
						    <input type="button" class="button radius btn" id="enablePosition" value="启用" onclick="setSecurity('#validateChecked','position-enable-win','#enablePosition')"></input> 
							  <input type="button" class="button radius btn" id="completePosition" value="招聘完成" onclick="setSecurity('#validateChecked','position-complete-win','#completePosition')"></input> 
						    <input type="button" class="button radius btn" id="pausePosition" value="招聘暂停" onclick="setSecurity('#validateChecked','position-pause-win','#pausePosition')"></input> 
							  <input type="button" class="button radius btn" value="删除" id="delPosition" onclick="setSecurity('#validateChecked','position-del-win','#delPosition')"></input> 
							  <input type="button" class="button radius btn" value="标记" id="addLabels" onclick="openLabel('#validateChecked','position-addlabels-win','#addLabels')"></input> 
							  <input type="button" class="button radius btn" value="导出" id="exportPosition" onclick="exportPosition()"></input>&nbsp;&nbsp;
							<input type="button" class="button radius btn" value="显示设置" id="isShow"></input>
								
						</div>
						<div id="datagrid1" class="mini-datagrid" url="/recruit/position/queryPositionManaList" 
							idField="id" sizeList="[1,2,50,100]" pageSize="10" allowResize="false" 
							multiSelect="true" style="height:350px;" ondrawcell="ondrawcell" onbeforeload="loadData">
						    <div property="columns">
						    	<div type="indexcolumn"></div>
            				<div type="checkcolumn"></div>
            				<div field="recruitPositionId" name="recruitPositionId" width="0" allowSort="true" >职位Id</div>
						        <div name="positionNameColumn" field="positionName" width="150" showColumnsMenu="true" allowSort="true">职位名称</div>    
						        <div name="positionCodeColumn" field="positionCode" width="60" align="center" headerAlign="center" allowSort="true">职位编码</div>                            
						        <!-- <div name="departmentCodeColumn" field="departmentCode" width="100" renderer="onGenderRenderer">内部编码</div> -->
						        <div name="recruiterNameColumn" field="recruiterName" width="60" allowSort="true">招聘专员</div>                                
						        <div name="publisherNameColumn" field="publisherName" width="60" allowSort="true">发布者</div>
						        <div name="receiveEmailColumn" field="receiveEmail" width="120" allowSort="true">接收简历邮箱</div>      
						        <div name="labelColumn" field="label" width="100" allowSort="true">标记</div>
						        <div name="departmentColumn" field="departmentName" width="80" allowSort="true">部门</div>  
						        <div name="departmentManagerColumn" field="departmentManager" width="80" allowSort="true">用人部门主管</div>
						        <div name="secrecyColumn" field="secrecy" width="60" allowSort="true" align="center" headerAlign="center">保密设置</div>
						        <!-- <div field="positionDescription" width="100" allowSort="true">匹配设置</div> -->  
						        <div name="recruitNumbersColumn" field="recruitNumbers" width="100" allowSort="true" align="center" headerAlign="center">招聘数量</div>  
						        <div name="workPlaceColumn" field="workPlace" width="100" allowSort="true" align="center" headerAlign="center">地区</div>
						        <div name="statusColumn" field="status" width="60" allowSort="true" align="center" headerAlign="center">状态</div>
						        <div name="positionTypeColumn" field="positionType" width="80" allowSort="true">职能类别</div>    
						        <div name="positionLevelColumn" field="positionLevel" width="80" allowSort="true">职位级别</div>  
						        <div name="demandsColumn" field="demands" width="60" allowSort="true" align="center" headerAlign="center">需求人数</div>
						        <div name="releaseDateColumn" field="releaseDate" width="80"  allowSort="true" align="center" headerAlign="center" dateFormat="yyyy-MM-dd">发布日期</div>  
						        <div name="effectiveDateColumn" field="effectiveDate" width="80" allowSort="true" align="center" headerAlign="center" dateFormat="yyyy-MM-dd">职位生效日期</div>
						        <div name="expectDateColumn" field="expectDate" width="80" allowSort="true" align="center" headerAlign="center" dateFormat="yyyy-MM-dd">期望到岗日期</div>    
						        <div name="expireDateColumn" field="expireDate" width="80" allowSort="true" align="center" headerAlign="center" dateFormat="yyyy-MM-dd">截止日期</div>
						        <div name="modifyDateColumn" field="modifyDate" width="80" allowSort="true" align="center" headerAlign="center" dateFormat="yyyy-MM-dd">修改日期</div>
						    </div>
						</div>
					</div>
					</div>
				</div>
				<div class="showPosition-choose">
			   <table class="showPosition-choose-tab">
			      <tr>
			        <td width="30px"><input type="checkbox" value="" checked="checked" disabled="disabled"></td>
			        <td width="120px"><span>职位名称</span></td>
			        <td width="30px"><input type="checkbox" class="position-checkbox" id="positionCode" value="positionCodeColumn" ></td>
			        <td width="190px"><span>职位编码</span></td>
			      </tr>
			       <tr>
			        <td><input type="checkbox" class="position-checkbox" id="departmentCode" value="departmentCodeColumn"></td>
			        <td><span>内部编码</span></td>
			        <td><input type="checkbox" checked="checked" class="position-checkbox" id="publisherName" value="publisherNameColumn"></td>
			        <td><span>发布者</span></td>
			      </tr>
			       <tr>
			        <td><input type="checkbox" checked="checked" class="position-checkbox" id="recruiterName" value="recruiterNameColumn"></td>
			        <td><span>招聘专员</span></td>
			        <td><input type="checkbox" checked="checked" class="position-checkbox" id="receiveEmail" value="receiveEmailColumn"></td>
			        <td><span>接收简历邮箱</span></td>
			      </tr>
			      <tr>
			        <td><input type="checkbox" checked="checked" class="position-checkbox" id="label" value="labelColumn"></td>
			        <td><span>标记</span></td>
			        <td><input type="checkbox" checked="checked" class="position-checkbox" id="department" value="departmentColumn"></td>
			        <td><span>部门</span></td>
			      </tr>
			      <tr>
			        <td><input type="checkbox" class="position-checkbox" id="departmentManager" value="departmentManagerColumn"></td>
			        <td><span>用人部门主管</span></td>
			        <td><input type="checkbox" value=""></td>
			        <td><span>匹配设置</span></td>
			      </tr>
			      <tr>
			        <td><input type="checkbox" class="position-checkbox" id="secrecy" value="secrecyColumn"></td>
			        <td><span>保密设置</span></td>
			        <td><input type="checkbox" checked="checked" class="position-checkbox" id="recruitNumbers" value="recruitNumbersColumn"></td>
			        <td><span>招聘数量</span></td>
			      </tr>
			      <tr>
			        <td><input type="checkbox" class="position-checkbox" id="workPlace" value="workPlaceColumn"></td>
			        <td><span>地区</span></td>
			        <td><input type="checkbox" class="position-checkbox" id="status" value="statusColumn"></td>
			        <td><span>状态</span></td>
			      </tr> 
			      <tr>
			        <td><input type="checkbox" checked="checked" class="position-checkbox" id="positionType" value="positionTypeColumn"></td>
			        <td><span>职位类别</span></td>
			        <td><input type="checkbox" checked="checked" class="position-checkbox" id="positionLevel" value="positionLevelColumn"></td>
			        <td><span>职位级别</span></td>
			      </tr>
			      <tr>
			        <td><input type="checkbox"  checked="checked" class="position-checkbox" id="effectiveDate" value="effectiveDateColumn"></td>
			        <td><span>职位生效日期</span></td>
			        <td><input type="checkbox" class="position-checkbox" id="demands" value="demandsColumn"></td>
			        <td><span>需求人数</span></td>
			      </tr>
			      <tr>
			        <td><input type="checkbox" class="position-checkbox" id="expectDate" value="expectDateColumn"></td>
			        <td><span>期望到岗日期</span></td>
			        <td><input type="checkbox" class="position-checkbox" id="releaseDate" value="releaseDateColumn"></td>
			        <td><span>发布日期</span></td>
			      </tr>
			      <tr>
			        <td><input type="checkbox" class="position-checkbox" id="modifyDate" value="modifyDateColumn"></td>
			        <td><span>修改日期</span></td>
			        <td><input type="checkbox" class="position-checkbox" id="expireDate" value="expireDateColumn"></td>
			        <td><span>截至日期</span></td>
			      </tr>
			      <tr>
			        <td><input type="checkbox" class="position-checkbox" id="departmentCode" value="departmentCodeColumn"></td>
			        <td><span>内部编码</span></td>
			      </tr>
			    </table>
			</div>
				<jsp:include page="/webpage/com/csot/publicPage/choosePerson.jsp"></jsp:include>
		  </div>  
		
			<!-- 华星光电部门树 -->
	    <div class="csot-department">
	      <div class="mini-tree mini-dept-tree radius" id="mini-dept-tree" onnodeselect="onNodeSelect" textField="orgName"  resultAsTree="false" allowSelect="true"  showTreeIcon="false"></div>
	    </div> 	
		
    </div>
    
    <!-- 职位的相关设置 -->
   	<jsp:include page="/webpage/com/csot/publicPage/positionSet.jsp"></jsp:include>
	
		<!-- 职位的分发,修改和预览 -->
		<div class="position-operate">
	  	<div class="position-operate-left">
	    	<table class="position-operate-ltable">
	      	<tr>
	        	<td width="25px;"><img alt="" style="width:20px;" src="${webRoot}/resources/images/search.jpg"></td>
	        	<td><a class="position-operate-preview" id="positionView" target="_Blank" style="color:blue">预览</a></td>
	      	</tr>
	      	<c:if test="${not empty u_position_positionEdit }">
	      	<tr>
	        	<td><img alt="" style="width:20px;" src="${webRoot}/resources/images/editor.jpg"></td>
	        	<td><a id="positionEdit" style="color:blue;">修改</a></td>
	      	</tr>
	       	</c:if>
	      	<c:if test="${not empty u_position_distribute }">
	      	<tr>
	        	<td><img alt="" style="width:20px;" src="${webRoot}/resources/images/distribute.jpg"></td>
	        	<td><a id="positionDistribute" target="_Blank">分发</a></td>
	      	</tr>
	      	</c:if>
	    	</table>
	  	</div>
	  	<div class="position-operate-right">
	    	<table class="position-operate-rtable">
	      	<tr>
	        	<td><span>分发与刷新结果</span></td>
	      	</tr>
	      	<tr>
	        	<td><img alt="" src="${webRoot}/resources/images/lenDashed.jpg"></td>
	      	</tr>
	      	<tr>
	        	<td><span>该职位暂时还没进行分发</span></td>
	      	</tr>
	    	</table>
	  	</div>
		</div>
    <jsp:include page="/webpage/footer.jsp"></jsp:include>
  </body>
	<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.cookie.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/department.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/position/positionManage.js"></script>
</html>








