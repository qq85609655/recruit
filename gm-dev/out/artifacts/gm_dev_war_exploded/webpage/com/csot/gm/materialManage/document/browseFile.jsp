<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/context/jspBase.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>文件预览</title>
<%@ include file="/resources/context/headResource.jsp"%>
<link rel="stylesheet" type="text/css" href="resources/plugins/FlexPaper/css/flexpaper.css" />
<script src="resources/plugins/FlexPaper/js/flexpaper.js"></script>
<script src="resources/plugins/FlexPaper/js/flexpaper_handlers.js"></script>
<style>
html, body {
  overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}
</style>
</head>

<script>
  $(function() {
    $('#viewerPlaceHolder').FlexPaperViewer({
      config : {
        SWFFile : escape('${fileUrl}'),
        jsDirectory : 'resources/plugins/FlexPaper/js/',
        cssDirectory : 'resources/plugins/FlexPaper/css/',

        Scale : 0.6,
        ZoomTransition : 'easeOut',
        ZoomTime : 0.5,
        ZoomInterval : 0.2,
        FitPageOnLoad : true,
        FitWidthOnLoad : false,
        FullScreenAsMaxWindow : true,
        ProgressiveLoading : false,
        MinZoomSize : 0.2,
        MaxZoomSize : 5,
        SearchMatchAll : false,
        InitViewMode : 'Portrait',
        RenderingOrder : 'flash,html',
        StartAtPage : '',

        ProgressiveLoading : true,
        ViewModeToolsVisible : true,
        ZoomToolsVisible : true,
        NavToolsVisible : true,
        CursorToolsVisible : true,
        SearchToolsVisible : true,
        WMode : 'window',
        localeChain : 'zh_CN'
      }
    });
  });
</script>

<body style="font-size: 12px; padding: 5px; background-color: #f6f6f6; height: 100%;">

  <div id="swfplay" style="width: 100%; height: 100%; z-index: 50;">
    <div id="viewerPlaceHolder" class="flexpaper_viewer"></div>
  </div>

  <%@include file="/resources/context/lazyResource.jsp"%>

</body>
</html>