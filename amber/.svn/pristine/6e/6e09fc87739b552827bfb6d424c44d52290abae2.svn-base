<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
  String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			String going_to_url = (String) session
					.getAttribute("__GOING_TO_URL");
			if (going_to_url == null || going_to_url.equals("")) {
				going_to_url = "index.jsp";
			}
%>
<c:set var="basePath" value="<%=basePath%>" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="${basePath}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="description" content="Login" />
<title>Welcome to Amber platform</title>
<script type="text/javascript" src="resources/plugins/jquery/jquery-1.6.2.min.js"></script>
<style type="text/css">
body {
  background-color: #fff;
  margin: 0px;
  font-family: Arial, Helvetica, sans-serif, "宋体";
  color: #333;
  font-size: 14px;
  text-align: center;
}

#outform {
  position: absolute;
  width: 576px;
  height: 600px;
  left: 50%;
  top: 50%;
  margin-left: -288px;
  margin-top: -300px;
  border: 0px;
}

td {
  margin: 0px;
  padding: 0px;
  border: 0px;
}

img {
  margin: 0px;
  padding: 0px;
  border: 0px;
}

.tlbg {
  background-image: url(resources/plugins/login/image/loading-2_03.jpg);
  background-repeat: no-repeat;
  width: 287px;
  height: 137px;
}

.trbg {
  background-image: url(resources/plugins/login/image/loading-2_04.jpg);
  background-repeat: no-repeat;
  width: 289px;
  height: 137px;
}

.bg {
  background-image: url(resources/plugins/login/image/loading-2_06.jpg);
  background-repeat: no-repeat;
  height: 187px;
}

.bbg {
  background-image: url(resources/plugins/login/image/loading-2_07.jpg);
  background-repeat: no-repeat;
  width: 576px;
  height: 80px;
}

.t1 {
  font-family: Arial, Helvetica, sans-serif, "宋体";
  color: #315371;
  font-size: 14px;
  font-weight: bold;
}

.t2 {
  font-family: Arial, Helvetica, sans-serif, "宋体";
  color: #656565;
  font-size: 14px;
  font-weight: bold;
}

.srk {
  border-bottom: #9ab3da 1px solid;
  border-left: #9ab3da 1px solid;
  line-height: 21px;
  width: 200px;
  font-family: Arial, Helvetica, sans-serif, "宋体";
  height: 23px;
  color: #3e3e3e;
  font-size: 12px;
  border-top: #9ab3da 1px solid;
  border-right: #9ab3da 1px solid;
}
</style>
<!-- link rel="stylesheet" type="text/css" href="plugin/login/css/login.css" / -->
<script type="text/javascript">

  // 进入页面时，先判断是否已经登录，如果登录直接跳转到首页
  $.ajax({
    url : 'sys/auth/authenticated',
    type : 'post',
    async : false,
    cache : false,
    success : function(e) {
      if (e == 'true') {
        window.location.href='${basePath}sys/auth/main';                                                                                
      }
    },
    error : function(jqXHR, textStatus, errorThrown) {
    }
  });

  function onLoginSubmit() {
    var loginInput = "请输入用户名和密码";
    if (document.forms[0].username.value == "") {
      alert(loginInput)
      document.forms[0].username.focus();
      return false;
    }
    if (document.forms[0].password.value == "") {
      alert(loginInput);
      document.forms[0].password.focus();
      return false;
    }
    document.getElementsByName("btn_submit")[0].disabled = true;
    return true;
  }

  function clickSubmit() {
    <%-- $("#loginForm").submit(); --%>
    <%-- 改为Ajax提交 --%>
    if (onLoginSubmit()) {
      ajaxSubmit();
    }
  }

  function isIE() { //ie?
    if (!!window.ActiveXObject || "ActiveXObject" in window)
      return true;
    else
      return false;
  }

  window.onload = function() {
    var j_username = document.getElementsByName("username")[0].value;
    if (j_username == "") {
      document.getElementsByName("username")[0].focus();
    } else {
      document.getElementsByName("password")[0].focus();
    }

    if (isIE()) {
<%-- 判断是否为IE浏览器，如果是IE则需要监听enter按下 --%>
  
<%-- 因为IE浏览器中display:none的span会使其中的submit按钮相应enter功能失效，所以需要监听enter --%>
  
<%-- 但是在其他浏览器中，不需要监听，监听会出现重复提交的情况 --%>
  $(document).keydown(function(e) {
        if (e.keyCode == 13) {
          clickSubmit();
        }
      });
    } else {
      $("#btn_submit").css("display", "none");
    }
  }
  
  function ajaxSubmit() {
    
    $.ajax({
      url : "sys/auth/ajaxlogin",
      type : 'post',
      async : false,
      data : $("#loginForm").serialize(),
      dataType : "json",
      cache : false,
      success : function(e) {
        if (e.success) {
          if (e.msg) {
            window.location.href='${basePath}' + e.msg;
          } else {
            window.location.href='${basePath}sys/auth/main';
          }
        } else {
          alert(e.msg);
        }
      },
      error : function(jqXHR, textStatus, errorThrown) {
        var exceptionMessage = "";
        var responseJson = StringToJson(jqXHR.responseText);
        if (responseJson.exception) {
          exceptionMessage = responseJson.exception;
        } else {
          exceptionMessage = jqXHR.responseText;
        }
        
        alert(exceptionMessage);
      }
    });
  }
</script>
<%-- 以下这个注释是为了给SSO判断是否要自动代填及提交用的，当SSO提交失败的时候，则不会显示此注释，防止死循环提交 --%>
<c:if test="${shiroLoginFailure eq null}">
<!-- This comment is the mark for SSO -->
</c:if>
</head>
<body>
  <div id="outform">
    <form onsubmit="return onLoginSubmit();" action="" method="post"
      name="loginForm" id="loginForm">
      <table id="loginPage" style="height: 100%; border: 0;" cellpadding="0" cellspacing="0"
        width="100%">
        <tbody>
          <tr>
            <td><input id="sooInput" type="hidden" /></td>
          </tr>
          <tr style="height: 600px">
            <td>
              <table cellpadding="0" cellspacing="0" align="center" width="576" border="0">
                <tbody>
                  <tr>
                    <td class="tlbg" valign="bottom" align="left"></td>
                    <td class="trbg" valign="bottom" align="left"></td>
                  </tr>
                  <tr>
                    <td class="bg" valign="top" colspan="2" align="left">
                      <table border="0" cellspacing="0" cellpadding="0" width="90%" align="left">
                        <tbody>
                          <tr>
                            <td height="32" colspan="3"></td>
                          </tr>
                          <tr>
                            <td height="33" valign="top" align="center">&nbsp;</td>
                            <td class="t1" height="33" valign="top" colspan="2" align="left">
                              <c:choose>
                                <c:when test="${shiroLoginFailure ne null}">
                                  ${shiroLoginFailure}
                                </c:when>
                                <c:otherwise>
                                                                                                      欢迎登录，请输入用户名和密码
                                </c:otherwise>
                              </c:choose>
                            </td>
                          </tr>
                          <tr>
                            <td height="30" width="106">&nbsp;</td>
                            <td class="t2" valign="middle" width="69" align="right">用户名：&nbsp;</td>
                            <td valign="middle" width="343" align="left"><input type="text"
                              class="srk" onfocus="select();"
                              onmouseover="this.style.borderColor='#9ab3da';this.style.backgroundColor='#eaf3fc';"
                              onmouseout="this.style.borderColor='#9ab3da';this.style.backgroundColor='#ffffff';"
                              name="username" value="" /></td>
                          </tr>
                          <tr>
                            <td height="30">&nbsp;</td>
                            <td class="t2" valign="bottom" align="right">密码：&nbsp;</td>
                            <td valign="bottom" align="left"><input class="srk"
                              onfocus="select();"
                              onmouseover="this.style.borderColor='#9ab3da';this.style.backgroundColor='#eaf3fc'"
                              onmouseout="this.style.borderColor='#9ab3da';this.style.backgroundColor='#ffffff'"
                              type="password" name="password" /> <input id="goto_url"
                              name="goto_url" type="hidden" value="<%=going_to_url%>" /> <span
                              style="display: none"> <input style="width: 0px; height: 0px"
                                value="登录" type="submit" name="btn_submit" id="btn_submit" />
                            </span></td>
                          </tr>
                          <tr>
                            <td valign="bottom" align="center">&nbsp;</td>
                            <td height="60" valign="bottom" colspan="2" align="center">
                              <table border="0" cellspacing="0" cellpadding="0" width="50%"
                                align="right">
                                <tbody>
                                  <tr>
                                    <td style="cursor: pointer" valign="bottom"><img
                                      src="resources/plugins/login/image/but_1.png" width="80"
                                      height="29" onclick="clickSubmit();" alt="提交" /></td>
                                    <td><img src="resources/plugins/login/image/but_2.png"
                                      width="80" height="29" onclick="window.close();" alt="关闭" /></td>
                                  </tr>
                                </tbody>
                              </table>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                    </td>
                  </tr>
                  <tr>
                    <td class="bbg" valign="top" colspan="2" align="left"></td>
                  </tr>
                </tbody>
              </table>
            </td>
          </tr>
          <tr>
            <td></td>
          </tr>
        </tbody>
      </table>
    </form>
  </div>
</body>
</html>