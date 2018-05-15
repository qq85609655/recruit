<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%--
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://"
      + request.getServerName() + ":" + request.getServerPort()
      + path + "/";
 --%>
<%-- 在用户登录后会将项目web的basePath放入session中，只需要通过下面的方式便可以取出使用.
                如果是不需要登录成功就可以查看的网页，还需要现去request中获取basePath，如上面注释的代码.  --%>
<c:set var="basePath" value="${sessionScope.basePath }" />
<!DOCTYPE html>
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Amber Platform</title>
<script src="resources/plugins/miniui/boot.js"></script>
<style type="text/css">
html, body {
  margin: 0;
  padding: 0;
  border: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
}

.logo {
  font-family: "微软雅黑", "Helvetica Neue", ​Helvetica, ​Arial, ​sans-serif;
  font-size: 28px;
  font-weight: bold;
  color: #444;
  cursor: default;
  position: absolute;
  top: 16px;
  left: 16px;
  line-height: 28px;
}

.topNav {
  position: absolute;
  right: 20px;
  top: 10px;
  font-size: 12px;
  line-height: 25px;
}

.topNav a {
  text-decoration: none;
  color: #222;
  font-weight: normal;
  font-size: 12px;
  line-height: 25px;
  margin-left: 3px;
  margin-right: 3px;
}

.topNav a:hover {
  text-decoration: underline;
  color: Blue;
}

.skinSelect {
  position: absolute;
  right: 20px;
  bottom: 6px;
  font-size: 12px;
  line-height: 25px;
  font-weight: normal;
}

.mini-layout-region-south img {
  vertical-align: top;
}

#mainframe {
  width: 100%;
  height: 100%;
  border: 0px;
}
</style>
</head>
<body>
  <div id="mainLayout" class="mini-layout" style="width: 100%; height: 100%;">
    <div title="north" region="north" class="app-header" bodyStyle="overflow:hidden;" height="60"
      showHeader="false" showSplit="false">
      <div class="logo">Amber</div>
      <div class="topNav">
        Welcome,&nbsp;<shiro:principal type="java.lang.String"/>&nbsp;&nbsp;&nbsp;
        <a href="sys/auth/main">首页</a>&nbsp;|&nbsp;
        <a href="javascript:changePassword();">修改密码</a>&nbsp;|&nbsp;
        <a href="sys/auth/logout">注销</a>&nbsp;&nbsp;
      <!-- /div>
      <div class="skinSelect"-->
        <span>选择皮肤:&nbsp;</span> <select id="selectSkin" onchange="onSkinChange(this.value)">
          <option value="">Default</option>
          <option value="csot">CSOT</option>
          <option value="blue">Blue</option>
          <option value="gray">Gray</option>
          <option value="olive2003">Olive2003</option>
          <option value="blue2003">Blue2003</option>
          <option value="blue2010">Blue2010</option>
          <option value="bootstrap">Bootstrap</option>
          <option value="metro">metro</option>
          <option value="metro-green">metro-green</option>
          <option value="metro-orange">metro-orange</option>
        </select>&nbsp;&nbsp;
      </div>
    </div>
    <div title="south" region="south" showSplit="false" showHeader="false" height="30">
      <div style="line-height: 28px; text-align: center; cursor: default">Copyright&nbsp;&copy;&nbsp;WANGYU&nbsp;版权所有</div>
    </div>
    <div showHeader="false" region="west" width="180" maxWidth="250" minWidth="120">
      <div id="leftTree" class="mini-outlooktree" url="sys/auth/menu"
        onnodeclick="onNodeClick" idField="id" parentField="parentId" textField="menuName"
        borderStyle="border:0" resultAsTree="false"></div>
    </div>
    <div title="center" region="center" bodyStyle="overflow:hidden;" 
      showHeader="true" showSplit="false" showCollapseButton="false" showCloseButton="false">
      <iframe id="mainframe" frameborder="0" name="mainframe"></iframe>
    </div>
  </div>
  <script type="text/javascript">
      mini.parse();
      
      var mainlayout = mini.get("mainLayout");
      mainlayout.updateRegion("center", { title: "首页" });

      //init iframe src
      var iframe = document.getElementById("mainframe");
      iframe.src = "webpage/index.jsp";

      function onSkinChange(skin) {
        mini.Cookie.set('miniuiSkin', skin);
        //mini.Cookie.set('miniuiSkin', skin, 100);//100天过期的话，可以保持皮肤切换
        window.location.reload();
      }

      function onNodeClick(e) {
        var node = e.node;
        if (node.url != null) {
          iframe.src = node.url;
          mainlayout.updateRegion("center", { title: node.menuName });
        }
      }
      
      function loadIframePage(url, title, menuId) {
        iframe.src = url;
        // title和menuId留做备用，一定会用上的。在显示导航标签栏的时候用
        if (title != null) {
          mainlayout.updateRegion("center", { title: title });
        }
      }
      
      function changePassword() {
        OpenDialog("auth/user/sysUser/changeSelfPasswd", "修改密码");
      }
    </script>
    <script src="${basePath}resources/js/common.js"></script>
</body>
</html>