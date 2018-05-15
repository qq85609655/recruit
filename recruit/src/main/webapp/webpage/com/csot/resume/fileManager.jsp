<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@include file="/webpage/common.jsp"%>
<html>
  <head>
	  <title>简历管理-标准文档管理</title>
	  <link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/fileManager.css"/>
  </head>
  <body onload="removeLoad();">
	  <jsp:include page="/webpage/header.jsp"></jsp:include>
    <div class="co">
    	<div class="co-left">
    		<jsp:include page="/webpage/left-bar.jsp"></jsp:include>
    	</div>
    	<div class="co-right">
    	  <div class="position-path co-right-center">
    			<span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">易播职</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">标准文档管理</span>
    	  </div>
			<div class="co-right-main co-right-center">
				<div class="con-title">标准文档管理</div>
				<div class="main">
				  <div class="mainBg blue radius">
				    <div class="fileTitle">
				      <div class="fileTitleContent">
				      <c:if test="${not empty u_resume_validateFileName }">
				        <input type="button" value="上传文档" class="fileButton"><span>[已上传<span class="red" id="countUploadFile"></span>份标准文档,还可上传<span class="red" id="countSurplus"></span>份]</span>
				      </c:if>
				        <input type="file" name="file_upload" id="file_upload"  style="display:none" onchange="ajaxFileUpload()"> 
				      </div>
				    </div>
				    <div class="fileContent">
				      <table class="tGlobal mt10 " id="tGlobal">
	                    <tr>
	                        <th>文档名称</th>
	                        <th>文档地址</th>
	                        <th>创建人</th>
	                        <th>创建时间</th>
	                        <th>操作</th>
	                    </tr>
	                   <c:if test="${ not empty files }"> 
		                    <c:forEach items="${files }" var="file">
		                       <tr>
	                              <td>${file.fileName}</td>
	                              <td> <a href="${file.filePath }">${file.filePath }</a></td>
	                              <td>${file.uploader }</td>
	                              
	                              <td><fmt:formatDate type="both" value="${file.uploadTime }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
	                              <c:if test="${not empty u_resume_deleteFile }">
	                                <td> <a href="/recruit/resume/deleteFile?fileKey= ${file.id }" itemid=" ${file.id }" class="deleteDoc">删除</a> </td>
	                              </c:if>
	                          </tr>
		                    </c:forEach>
	                    </c:if>
               </table>
				    </div>
				  </div>
				  
				  <div>
				    <div id="file-win" class="mini-window" style="width: 520px;height:260px; display: none;"title="上传标准文档" showFooter="true">
	                  <form id="fileForm" method="post" enctype="multipart/form-data" >
				        <table>
				          <tr>
				            <td><span class="red">*</span><span>文档名称:&nbsp;</span></td>
				            <td><input type="text" name="fileName" class="w150" id="fileName" ></td>
				          </tr>
				          <tr>
				            <td><span class="red">*</span><span>选择上传文档:&nbsp;</span></td>
				            <td><input id="file" name="file" type="file" value="浏览" size="220" width="200" style="width: 218px;" onchange="ajaxFileUpload()"/></td>
				          </tr>
				          <tr>
				            <td></td>
				            <td><span class="grays">请上传html,htm,word,excel,rar,zip,jpg,png,gif格式，单<br>个文档不超过4M。 </span></td>
				          </tr>
				        </table>
				        <div class="tipMessage">
				          <span class="tipContent" style="font-size:15px;"></span>
				        </div>
				        <div property="footer" class="win-footer">
				          <input type="button" id="submitBtn" class="win-footer-btn" value="确定上传"/>
	                      <input type="button" class="win-footer-btn" value="取消" id="cancelBtn">
	                    </div>
				      </form>
	                </div>
				  </div>
				</div>
			</div>
	  </div>
	</div>
    <jsp:include page="/webpage/footer.jsp"></jsp:include>
  </body>
    <script type="text/javascript" src="${webRoot}/resources/js/jquery.form.js"></script>
	<script type="text/javascript" src="${webRoot}/resources/js/resume/fileManager.js"></script>
</html>









