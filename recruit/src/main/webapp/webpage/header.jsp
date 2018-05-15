<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<div class="head" id="recruitHeader">
	<div class="logo">
    <img class="logo_img" src="${ctx}/resources/images/logo.png" /><!-- <span class="logo-dec">华星招聘</span> -->
  </div>
  <div class="nav">
    <ul class="models">
    	<li class="line"></li>
   	</ul>
  </div>
  <div class="user">
    <span class="cur_user">当前用户:<shiro:principal type="java.lang.String"/></span><span class="mainpage click-can"><a href="${ctx}/sys/auth/main">首页</a></span>|<span class="logout click-can"><a href="${ctx}/sys/auth/logout">注销</a></span>
  </div>
  <script>var currentPage = "${param.currentPage}";</script>
  <script type="text/javascript" src="${ctx}/resources/js/public/header.js"></script>
	<script>new Header({id:"recruitHeader"});</script>
</div>


    <!-- <ul class="models">
   	  <li class="models-item">
   	  	<a>招聘需求</a>
   	  	<ul class="models-item-sub">
   				<li class="models-item-sub-item"><a>需求列表</a></li>
   				<li class="models-item-sub-item"><a>发布/修改</a></li>
   			</ul>
   	  </li>
   		<li class="models-item">
   			<a>招聘流程</a>
   			<ul class="models-item-sub">
   				<li class="models-item-sub-item"><a>筛选</a></li>
   				<li class="models-item-sub-item"><a>面试列表</a></li>
   				<li class="models-item-sub-item"><a>录入&amp;入职</a></li>
   				<li class="models-item-sub-item"><a>淘汰</a></li>
   			</ul>
   		</li>
   		<li class="models-item"><a>简历库</a>
   			<ul class="models-item-sub">
   				<li class="models-item-sub-item"><a>简历清洗</a></li>
   				<li class="models-item-sub-item"><a>公共简历库</a></li>
   				<li class="models-item-sub-item"><a>通讯录</a></li>
   				<li class="models-item-sub-item"><a>简历导入</a></li>
   				<li class="models-item-sub-item"><a>简历录入</a></li>
   				<li class="models-item-sub-item"><a>未清洗简历库</a></li>
   				<li class="models-item-sub-item"><a>无联系方式简历库</a></li>
   			</ul>
   		</li>
   		<li class="models-item"><a>猎聘</a>
   			<ul class="models-item-sub">
   				<li class="models-item-sub-item"><a>供应商简历库</a></li>
   				<li class="models-item-sub-item"><a>供应商简历导入</a></li>
   				<li class="models-item-sub-item"><a>猎聘</a></li>
   				<li class="models-item-sub-item"><a>供应商人才库</a></li>
   			</ul>
   		</li>
   		<li class="models-item"><a>招聘支持</a>
   			<ul class="models-item-sub">
   				<li class="models-item-sub-item"><a>应聘申请</a></li>
   				<li class="models-item-sub-item"><a>模板管理</a></li>
   				<li class="models-item-sub-item"><a>网上需求发布</a></li>
   				<li class="models-item-sub-item"><a>社招入职资料管理</a></li>
   				<li class="models-item-sub-item"><a>校招入职资料管理</a></li>
   				<li class="models-item-sub-item"><a>设置</a></li>
   			</ul>
   		</li>
   		<li class="models-item"><a>供应商管理</a>
   			<ul class="models-item-sub"></ul>
   		</li>
   		<li class="models-item"><a>自助</a>
   			<ul class="models-item-sub">
   				<li class="models-item-sub-item"><a>经理人自助</a></li>
   				<li class="models-item-sub-item"><a>候选人自助</a></li>
   				<li class="models-item-sub-item"><a>猎头自助</a></li>
   			</ul>
   		</li>
   		<li class="models-item"><a>报表</a>
   			<ul class="models-item-sub"></ul>
   		</li>
   		<li class="models-item"><a>系统设置</a>
   			<ul class="models-item-sub">
   				<li class="models-item-sub-item"><a>面试室管理</a></li>
   				<li class="models-item-sub-item"><a>面试官管理</a></li>
   				<li class="models-item-sub-item"><a>交接管理</a></li>
   				<li class="models-item-sub-item"><a>职位体系管理</a></li>
   				<li class="models-item-sub-item"><a>简历设置</a></li>
   				<li class="models-item-sub-item"><a>标签设置</a></li>
   				<li class="models-item-sub-menu">
   					<a class="models-item-sub-menu-text">权限管理</a>
   					<ul class="models-item-sub-menu-sub">
   						<li class="models-item-sub-menu-sub-item"><a>角色管理</a></li>
   						<li class="models-item-sub-menu-sub-item"><a>权限设置</a></li>
   					</ul>
   				</li>
   			</ul>
   		</li>
    	<li class="line"></li>
   	</ul> -->