<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<c:set var="webRoot" value="<%=basePath%>" />
<!-- 选择人员 -->
<div class="showPosition-choose">
  <table class="showPosition-choose-tab">
    <tr>
      <td width="30px"><input type="checkbox" value="" checked="checked" disabled="disabled"></td>
      <td width="120px"><span>姓名</span></td>
      <td width="30px"><input type="checkbox" class="position-Checkbox" id="positionCode" value="positionCodeColumn" ></td>
      <td width="190px"><span>甄选状态</span></td>
    </tr>
    <tr>
      <td><input type="checkbox" class="position-checkbox" id="departmentCode" value="departmentCodeColumn"></td>
      <td><span>关联职位</span></td>
      <td><input type="checkbox" checked="checked" class="position-checkbox" id="publisher" value="publisherColumn"></td>
      <td><span>年龄</span></td>
    </tr>
    <tr>
      <td><input type="checkbox" checked="checked" class="position-checkbox" id="recruiter" value="recruiterColumn"></td>
      <td><span>标签</span></td>
      <td><input type="checkbox" checked="checked" class="position-checkbox" id="receiveEmail" value="receiveEmailColumn"></td>
      <td><span>就职公司</span></td>
    </tr>
    <tr>
      <td><input type="checkbox" checked="checked" class="position-checkbox" id="label" value="labelColumn"></td>
      <td><span>当前所在</span></td>
      <td><input type="checkbox" checked="checked" class="position-checkbox" id="department" value="departmentColumn"></td>
      <td><span>工作经验</span></td>
    </tr>
    <tr>
      <td><input type="checkbox" class="position-checkbox" id="departmentManager" value="departmentManagerColumn"></td>
      <td><span>简历来源</span></td>
      <td><input type="checkbox" value=""></td>
      <td><span>期望薪资</span></td>
    </tr>
    <tr>
      <td><input type="checkbox" class="position-checkbox" id="secrecy" value="secrecyColumn"></td>
      <td><span>匹配设置</span></td>
      <td><input type="checkbox" checked="checked" class="position-checkbox" id="recruitNumbers" value="recruitNumbersColumn"></td>
      <td><span>招聘渠道</span></td>
    </tr>
    <tr>
      <td><input type="checkbox" class="position-checkbox" id="workPlace" value="workPlaceColumn"></td>
      <td><span>更新日期</span></td>
      <td><input type="checkbox" class="position-checkbox" id="status" value="statusColumn"></td>
      <td><span>操作</span></td>
    </tr> 
  </table>
</div>