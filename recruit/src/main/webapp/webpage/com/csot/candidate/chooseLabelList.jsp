<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/flow/interview/chooseBaseUserList.css"/>
<title>标签列表</title>
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
            <div id="accountDatagrid" class="mini-datagrid" url="${ctx}/category/labelDatagrid?showPager=true" 
                idField="id" sizeList="[1,2,50,100]" showPager="true" pageSize="10" allowResize="false"  ondrawcell="ondrawcell" 
                multiSelect="true" style="height:320px;">
                  <div property="columns">
                      <div type="checkcolumn"></div>
                      <div field="id" name="id" width="0" allowSort="true" >Id</div>
                      <div name="nameColumn" field="name" width="80"  allowSort="true">标签名称</div>                            
                      <div name="departmentColumn" field="categoryId" width="80" >类别ID</div>
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
  <script type="text/javascript" src="${webRoot }/resources/js/candidate/chooseLabelList.js"></script>
</html>