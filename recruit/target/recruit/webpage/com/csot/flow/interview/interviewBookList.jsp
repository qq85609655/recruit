<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />

<title>面试列表</title>
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
        <span class="path-title">您的位置 :</span><a class="path-item a-decoration"
          href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><span
          class="path-leaf">招聘流程</span><em class="path-icon">&gt;&gt;</em><span class="path-leaf">面试列表</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="con-title">面试列表</div>
        <div class="account-content">
          <div class="account-search">
            <table class="tblQuery2">
              <tbody>
                <tr>
                  <td><input emptyText="请输入姓名" style="width: 150px" class="mini-textbox"
                    id="key"></td>
                  <td>&nbsp;&nbsp; <input type="submit" value="查询" tabindex="5"
                    class="search_btn" id="btnRefresh" onclick="search()" name="btnRefresh">
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="blue radius">
            <div class="table-operate">
               <input type="button" class="button radius btn" id="bookInterview" value="安排面试" onclick="bookInterview()" />
              <input type="button" class="button radius btn" id="uploadButton" value="导入" onclick="onImport()" /> 
              <input type="button" class="button radius btn" id="create" value="导出" onclick="onExport()" />
            </div>
            <div id="datagrid1" class="mini-datagrid"
              url="${ctx}/candidateController/datagrid?showPager=true" idField="id" showPager="true" multiSelect="true"
              sizeList="[10,20,50,100]" pageSize="15" allowResize="true" style="height: 460px;">
              <div property="columns">
                <div type="checkcolumn" width="30"></div>
                <div name="id" field="id" width="80" allowSort="true">编号</div>
                <div name="name" field="name" width="80">姓名</div>
                <div name="sex" field="sex" width="80">性别</div>
                <div name="age" field="age" width="80">年龄</div>
                <div name="positionid" field="positionid" width="80">应聘岗位</div>
                <div name="workExperience" field="workExperience" width="80" allowSort="false">工作年限</div>
                <div name="currentCompany" field="currentCompany" width="80" allowSort="false">当前公司</div>
                <div name="currentPosition" field="currentPosition" width="80" allowSort="false">当前职位</div>
                <div name="highestEducation" field="highestEducation" width="80" allowSort="false">学历</div>
                <div name="graduationSchool" field="graduationSchool" width="80" allowSort="false">毕业学校</div>
                <div name="channel" field="channel" width="80" allowSort="false">电话</div>
                <div name="phone" field="phone" width="80" allowSort="false">来源</div>
                <div name="email" field="email" width="80" allowSort="false">邮箱</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
<script>
  mini.parse();
  var datagrid = mini.get("datagrid1");
  datagrid.load();
  
</script>
<script type="text/javascript" src="${webRoot }/resources/js/candidate/candidateList.js"></script>
</html>