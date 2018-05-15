<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
  String path = request.getContextPath();
  String basePath =
      request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
          + path + "/";
%>
<c:set var="basePath" value="<%=basePath%>" />
<!DOCTYPE html>
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Amber Platform</title>
</head>
<body>
  <p>
  <p>
  <h2>Amber&nbsp;Framework&nbsp;-&nbsp;Vulcan</h2>
  v0.2
  <br>
  <img alt="Amber" src="resources/images/amber.jpg" width="160">
  <p>
    Amber开发框架是基于
    SpringMVC&nbsp;&amp;&nbsp;Spring4&nbsp;和&nbsp;MyBatis3&nbsp;的&nbsp;Java&nbsp;Web&nbsp;开发框架.<br>
    此版本为非正式发布版（测试版本），用于先期应用.<br> Vulcan是罗马神话中的火神，同时也是工匠之神.他虽然生得丑陋，但是却心灵手巧，才智卓越，可以打造出各种神器.<br>
    所以Amber此版本代号为“Vulcan”，希望通过Amber framework可以构建出功能强大的Java Web 业务系统.<br>
  </p>
  <p>
    <i><q>伏尔甘（Vulcan）是天神朱庇特之子，是罗马神话中的火神，在希腊神话中的对应人物是赫菲斯托斯。<br>
        他是长得最丑陋的天神，而且是个瘸腿，但却娶了最最美丽的女神维纳斯。<br>
        他的灵魂和才智十分卓越，而且天生具有操控火的能力，所以他能够轻而易举地冶炼出各式各样威力无穷的武器。<br>
        诸神手中的神器几乎都是由他打造，比如阿波罗驾驶的太阳战车、爱神丘比特的金箭、铅箭和朱庇特的神盾等等，而且他还在奥林匹斯山上建筑了诸神的宫殿。<br>
        可以说是伏尔甘分配了诸神的职权，建立了诸神的统治结构。<br> 他冶炼出的神器代表了诸神的权力和职责，所以在西方，将伏尔甘视作为象征权力的权神。<br>
        摩羯座（Capricorn，12月22日-1月19日）的守护神。
    </q>&nbsp;——&nbsp;百度百科</i>
  </p>
  Core component version:
  <table border="1">
    <tbody>
      <tr>
        <td width="300">jdk</td>
        <td width="150"><div align="center">1.7</div></td>
        <td width="300">jst.web(Servlet)</td>
        <td width="150"><div align="center">3.0</div></td>
      </tr>
      <tr>
        <td>org.springframework</td>
        <td><div align="center">4.1.5.RELEASE</div></td>
        <td>org.mybatis</td>
        <td><div align="center">3.2.8</div></td>
      </tr>
      <tr>
        <td>Maven</td>
        <td><div align="center">3.2</div></td>
        <td>Tomcat</td>
        <td><div align="center">7.0</div></td>
      </tr>
    </tbody>
  </table>
</body>
</html>