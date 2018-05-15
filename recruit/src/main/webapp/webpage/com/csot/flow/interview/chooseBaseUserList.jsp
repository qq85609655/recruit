<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/flow/interview/chooseBaseUserList.css"/>
<title>系统用户列表</title>
<style type="text/css">
</style>
</head>
<body onload="removeLoad();">
	<div>
   	<div class="">
    	<div class="co-right-main co-right-center">
		  	<div class="account-content">
		  	  <div class="account-search">
		  	    <table class="tblQuery2">
              <tbody>
                <tr>
                   <th>&nbsp;帐号：</th>
                   <td><input type="text" maxlength="60" style="width: 100px" tabindex="1" class="jobKey" name="account" id="txtAccount"></td>
                   <th>&nbsp;姓名：</th>
                   <td><input type="text" tabindex="2" style="width: 100px" class="jobKey" name="name" id="txtName"></td>
                    <td>&nbsp;&nbsp;<input type="submit" value="查询" tabindex="5" class="search_btn" id="btnRefresh" onclick="queryUserList()" name="btnRefresh">
                   </td>
                   <td>
                   <div class="table-operate">
                     <input type="button" class="button radius btn" id="ok" onclick="onOk()" value="确定" />
                     <input type="button" class="button radius btn" id="cancel" onclick="onCancel()" value="取消" />
                   </div>
                   </td>
                 </tr>
               </tbody>
             </table>
		  	  </div>
          <div class="blue radius">
			  	  <!-- User dataGrid -->
			  	  <div id="accountDatagrid" class="mini-datagrid" url="/recruit/baseUserController/datagrid" 
								idField="id" sizeList="[1,2,50,100]" pageSize="10" allowResize="false"  ondrawcell="ondrawcell" 
								multiSelect="true" style="height:320px;">
							    <div property="columns">
							    	<div type="indexcolumn"></div>
	            				<div type="checkcolumn"></div>
	            				<div field="id" name="id" width="0" allowSort="true" >Id</div>
							        <div name="accountColumn" field="account" width="80" showColumnsMenu="true" allowSort="true">登陆账号</div>    
							        <div name="nameColumn" field="name" width="80"  allowSort="true">姓名</div>   
                                    <div name="workCodeColumn" field="workCode" width="100" allowSort="true">工号</div>                      
							        <div name="departmentColumn" field="deptName" width="80" >部门</div>
							        <div name="statusColumn" field="status" width="80" allowSort="true">状态</div>
							    </div>
							</div>
						</div>
		  	</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="${webRoot}/resources/plugins/jquery-autocomplete/jquery.autocomplete.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/areaAutoCompleteData.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.zh_cn.js"></script>
  <script type="text/javascript" src="${webRoot }/resources/js/flow/interview/chooseBaseUserList.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/department.js"></script>
</html>