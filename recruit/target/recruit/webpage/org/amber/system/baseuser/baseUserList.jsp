<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css"/>
<title>系统用户列表</title>
<style type="text/css">
</style>
</head>
<body onload="removeLoad();">
<jsp:include page="/webpage/header.jsp"></jsp:include>
	<div class="co">
    	<div class="position-path co-right-center">
    		<span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">系统管理</span><em class="path-icon">&gt;&gt;</em><span class="path-leaf">账号管理</span>
      </div>
    	<div class="co-right-main co-right-center">
		  	<input type="hidden" name="userDelete" id="userDelete" <shiro:hasPermission name="auth:user:delete">value="1" </shiro:hasPermission>>
		  	<input type="hidden" name="userForbidden" id="userForbidden" <shiro:hasPermission name="auth:user:forbidden">value="1" </shiro:hasPermission>>
		  	<input type="hidden" name="userModify" id="userModify" <shiro:hasPermission name="auth:user:update">value="1" </shiro:hasPermission>">
		  	<input type="hidden" name="userPermission" id="userPermission">
		  	<div class="account-content">
		  	  <div class="account-search">
		  	    <table class="tblQuery2">
              <tbody>
                <tr>
                   <th>&nbsp;帐号：</th>
                   <td><input type="text" maxlength="60" style="width: 100px" tabindex="1" class="jobKey" name="account" id="txtAccount"></td>
                   <th>&nbsp;姓名：</th>
                   <td><input type="text" tabindex="2" style="width: 60px" class="jobKey" name="name" id="txtName"></td>
                   <th>&nbsp;电话:</th>
                   <td> <input type="text" maxlength="13" tabindex="3" style="width: 80px" class="jobKey" name="tel" id="txtTel"></td>
                   <th>&nbsp;帐号角色：</th>
                   <td>
                     <select tabindex="4" class="nameSelect" id="selRole" name="roleId">
                       <option value="">--全部--</option>
                     </select>
                   </td>
                   <th>&nbsp;部门:</th>
                   <td>
                     <input type="hidden" value="" name="deptId" id="selDeptTitle1">
                     <input type="button" class="recruit-assistant-dept dep-choosebtn recruit-choosebtn radius"  id="btnSelDeptTitle1" value="请选择部门">
                   </td>
                   <td>
                    &nbsp;&nbsp; <input type="submit" value="查询" tabindex="5" class="search_btn" id="btnRefresh" onclick="queryUserList()" name="btnRefresh">
                   </td>
                 </tr>
               </tbody>
             </table>
		  	  </div>
		  	  <div class="userContent blue radius">
			  	  <div class="serach-content">
			  	    <div id="jobFunc" class="dataOperate">
		            <p style="height: 20px;" class="btnPage">
			            <span class="innerBtn ">
				            <input type="button" style="vertical-align: bottom;" value="新建帐号"  class="btn4" id="btnNew" onclick="showAtPos('recruit-assistant-win','#btnNew',cleanValidator('#accountAddForm'))">
				            <a style="vertical-align: bottom; display:none;" href="/Account/ImportAccount" class="btn4" >导入帐号</a>
				            <a class="mini-button" iconCls="icon-edit" onclick="changePassword" plain="true">重置密码</a>
                            <a class="mini-button" iconCls="icon-edit" onclick="initAccount" plain="true">初始导入用户(根据4A)</a>
			            </span>                
		            </p>
		            <p></p>
		          </div>
			  	  </div>
			  	  <!-- User dataGrid -->
			  	  <div id="accountDatagrid" class="mini-datagrid" url="/recruit/baseUserController/datagrid" 
								idField="id" sizeList="[1,2,50,100]" pageSize="10" allowResize="false"  ondrawcell="ondrawcell" 
								multiSelect="true" style="height:350px;">
							    <div property="columns">
							    	<div type="indexcolumn"></div>
	            				<div type="checkcolumn"></div>
	            				<div field="id" name="id" width="0" allowSort="true" >Id</div>
							        <div name="accountColumn" field="account" width="100" showColumnsMenu="true" allowSort="true">登陆账号</div>    
							        <div name="nameColumn" field="name" width="100"  allowSort="true">姓名</div>                            
							        <div name="departmentColumn" field="deptName" width="100" >部门</div>
							        <div name="cellphoneColumn" field="cellphone" width="100" allowSort="true">联系电话</div>    
                                    <div name="emailColumn" field="email" width="100" allowSort="true">邮箱</div>                               
							        <div name="workCodeColumn" field="workCode" width="100" allowSort="true">工号</div>
							        <div name="registerDateColumn" field="time" width="100" allowSort="true">注册日期</div>
							        <div name="statusColumn" field="status" width="100" allowSort="true">状态</div>
							        <div name="moreOperateColumn" field="moreOperate" width="250"  allowSort="true">操作</div>
							    </div>
							</div>
						</div>
					  <!-- 华星光电部门树 -->
					  <div class="csot-department">
					     <div class="mini-tree mini-dept-tree radius" id="mini-dept-tree"  onnodeselect="onNodeSelect" textField="orgName" resultAsTree="false" allowSelect="true" showTreeIcon="false"></div>
					  </div>
						
						<!-- 新建账号 -->
					  <div id="recruit-assistant-win" style="display:none;" class="mini-window recruit-assistant-win" title="编辑用户信息" showFooter="true"> 
					    <form id="accountAddForm" action="${webRoot}/baseUserController/save">
					      <input type="hidden" name="id" id="userId">
						    <div class="recruit-assistant-middle">
						      <table class="recruit-assistant-tab">
						        <tr>
						          <td width="100px"><span style="color:red">*</span><span>&nbsp;登陆账号:</span></td>
						          <td><input type="text" id="account" name="account" class="recruit-assistant-text radius"></td>
						        </tr>
						        <tr>
						          <td><span><span style="color:red">*</span>&nbsp;姓名:</span></td>
						          <td><input type="text" id="name" name="name" class="recruit-assistant-text radius"></td>
						        </tr>
                                <tr>
                                  <td><span>&nbsp;&nbsp;工号:</span></td>
                                  <td><input type="text" id="workCode" name="workCode" class="recruit-assistant-text radius"></td>
                                </tr>
						        <tr>
						          <td><span>&nbsp;&nbsp;邮箱:</span></td>
						          <td><input type="text" id="email" name="email" class="recruit-assistant-text radius"></td>
						        </tr>
						        <tr>
						          <td><span>&nbsp;&nbsp;手机：</span></td>
						          <td><input type="text" id="cellphone" name="cellphone" class="recruit-assistant-text radius"></td>
						        </tr>
                    
						        <tr>
						          <td><span>&nbsp;&nbsp;是否启用:</span></td>
						          <td><input type="checkbox" id="accountStatu" name="status"></td>
						        </tr>
						      </table>
						    </div>
					    </form>
					    <div property="footer" class="win-footer">
					      <input type="button" class="win-footer-btn" value="确定" id="accountAddOK">
					      <input type="button" class="win-footer-btn" value="取消" onclick="hideWindow('recruit-assistant-win')">
					    </div>
					  </div>
		  	</div>
			</div>
	</div>
	<jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="${webRoot}/resources/plugins/jquery-autocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/areaAutoCompleteData.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.zh_cn.js"></script>
  <script type="text/javascript" src="${webRoot }/resources/js/system/baseUserList.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/department.js"></script>
</html>