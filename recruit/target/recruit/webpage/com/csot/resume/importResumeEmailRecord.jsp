<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/webpage/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>本地上传</title>
	<link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/importResume.css" />
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
				<em class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">人才库</a>
				<em class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">人才数据导入</a>
				<em class="path-icon">&gt;&gt;</em><span class="path-leaf">邮件导入记录</span>
			</div>
			<div class="co-right-main co-right-center">
				<div class="con-title">邮件导入记录</div>
				<div class="main">
				  <div class="position-import-main blue radius">
            <table class="position-import-tab1">
              <tr>
                <td>
                  <button class="posi-import-btn blue" id="position-import-button1"><span>本地上传</span></button>
                  <button class="posi-import-btn blue tab-up" id="position-import-button2"><span>邮件导入</span></button>
                </td>
              </tr>
            </table>
			  		<div id="datagrid1" class="mini-datagrid" url="/recruit/position/queryPositionManaList" 
							idField="id" sizeList="[1,2,50,100]" pageSize="10" allowResize="false" 
							multiSelect="true" style="height:400px;" ondrawcell="ondrawcell" onbeforeload="loadData">
			    		<div property="columns">
			    			<div type="indexcolumn"></div>
			    			<div name="positionNameColumn" field="positionName" width="100" showColumnsMenu="true" allowSort="true">发起人</div>    
			    			<div name="positionCodeColumn" field="positionCode" width="100"  allowSort="true">简历来源</div>                            
			    			<div name="modifyDateColumn" field="modifyDate" width="100" allowSort="true" dateFormat="yyyy-MM-dd">开始时间</div>
			    			<div name="expireDateColumn" field="expireDate" width="100" allowSort="true" dateFormat="yyyy-MM-dd">结束时间</div>                            
			    			<div name="publisherColumn" field="publisher" width="100" allowSort="true">是否结束</div>
			    			<div name="receiveEmailColumn" field="receiveEmail" width="100" allowSort="true">上传数量</div>      
			    			<div name="labelColumn" field="label" width="100" allowSort="true">成功数量</div>
			    			<div name="departmentColumn" field="department" width="100" allowSort="true">失败数量</div>  
			    			<div name="departmentManagerColumn" field="departmentManager" width="100" allowSort="true">未关联职位</div>
			    			<div name="secrecyColumn" field="secrecy" width="100"  allowSort="true">备注</div>
			  			</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="${webRoot}/resources/js/importResumeEmailRecord.js"></script>
</html>