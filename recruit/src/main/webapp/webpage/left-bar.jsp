<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav" id="item_area">	
<c:if test="${not empty resource }">
  <c:forEach var="item" items="${resource }">
    <li>
  	  <a class="item"><span class="font-icon">${item.icon}</span><span class="title">${item.menuName }</span><span class="font-icon expand icon-up-open-mini"></span></a>
        <c:if test="${not empty item.resourceList }">
          <div>
	          <ul>
	            <c:forEach var="citem" items="${item.resourceList }"> 
	    	        <li><a class="leaf" url="${citem.url }">${citem.menuName }</a></li>
	            </c:forEach>
	          </ul>
          </div>
        </c:if>
      </li>
    </c:forEach>
</c:if>
</ul>

<script>

var url = window.location.href;
$(".nav .leaf").each(function() {
	if(url.indexOf($(this).attr("url")) > 0) {
		$(this).addClass("selected");
	};
});

</script>