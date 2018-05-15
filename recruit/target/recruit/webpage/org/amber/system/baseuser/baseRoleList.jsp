<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/webpage/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseRoleList.css"/>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>角色权限管理</title>
<style type="text/css">
</style>
</head>
<body onload="removeLoad();">
<jsp:include page="/webpage/header.jsp"></jsp:include>
	<div class="co">
  	<div class="co-left">
    	<jsp:include page="/webpage/left-bar.jsp"></jsp:include>
    </div>
   	<div class="co-right">
    	<div class="position-path co-right-center">
    		<span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">系统管理</span><em class="path-icon">&gt;&gt;</em><span class="path-leaf">角色权限管理</span>
      </div>
    	<div class="co-right-main co-right-center">
		  	<div class="con-title">权限角色管理</div>
		  	  <input type="hidden" name="updateRoleOperate" id="updateRoleOperate" value="${u_permission_permission }">
				  <input type="hidden" name="deleteRoleOperate" id="deleteRoleOperate" value="${u_baseRoleController_delete }">
				  <input type="hidden" name="rolePermission" id="rolePermission" value="${u_baseRoleController_addRole }">
		  	<div class="account-content  blue radius">
		  	  <div class="addRole">
		  	    <c:if test="${not empty u_baseRoleController_addRole }">
		  	      <input id="addRoleButton" class="button radius btn" type="button"  value="新增角色">
		  	    </c:if>
		  	  </div>
		  	
		  	  <!-- User dataGrid -->
		  	  <div id="accountDatagrid" class="mini-datagrid" url="/recruit/baseRoleController/datagrid" 
							idField="id" sizeList="[1,2,50,100]" pageSize="10" allowResize="false"  ondrawcell="ondrawcell" 
							multiSelect="true" style="height:400px;">
						    <div property="columns">
						    	<div type="indexcolumn"></div>
            				<div type="checkcolumn"></div>
            				<div field="id" name="id" width="0" allowSort="true" >Id</div>
						        <div name="roleNameColumn" field="name" width="200" showColumnsMenu="true" allowSort="true">角色</div>    
						        <div name="descriptionColumn" field="description" width="200"  allowSort="true">角色描述</div>                            
						        <div name="moreOperateColumn" field="moreOperate" width="300"  allowSort="true">操作</div>
						    </div>
						</div>
					  <div class="mini-window" id="role-win"  style="width: 707px; height: 300px; display: none;" title="角色权限管理" showFooter="true">
				      <form action="/recruit/baseRoleController/addRole" id="roleForm">
				        <input type="hidden" name="id" id="roleId">
				        <table>
				          <tr>
				            <td><span>*</span>角色名称：</td>
				            <td><input type="text" name="name" id="name"></td>
				          </tr>
				          <tr>
				            <td>&nbsp;角色描述：</td>
				            <td>
				              <textArea cols="85" rows="13" name="description" id="description"></textArea>
				            </td>
				          </tr>
				        </table>
				      </form>
							<div property="footer" class="win-footer">
				      	<input type="button" class="win-footer-btn" value="确定" onclick="roleSubmit()">
				      	<input type="button" class="win-footer-btn" value="取消" onclick="hideWindow('role-win')">
				    	</div>
	   			 </div> 
	   			 
	   			 <div class="mini-window" id="delete-win"  style="width: 300px; height: 150px; display: none;" title="删除角色" showFooter="true">
              <div class="delete-tip">
                <br>
                <span>确定要删除?</span>
              </div>							
							<div property="footer" class="win-footer">
							  <input type="hidden" id="deleteRoleId">
								<input type="button" class="win-footer-btn" value="确定" onclick="deleteRole()">
				      	<input type="button" class="win-footer-btn" value="取消" onclick="hideWindow('delete-win')">
				    	</div>
	   			 </div> 
		  	</div>
			</div>
		</div>
	</div>
   <jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
 <script type="text/javascript" src="${webRoot}/resources/js/system/baseRoleList.js"></script>
</html>