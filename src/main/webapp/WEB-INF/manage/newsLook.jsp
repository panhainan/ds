<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>${newsInfo.title}</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />


</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">新闻管理</a>
			</li>
			<li><a href="<%=basePath%>news/manage/look?id=${newsInfo.id}">${newsInfo.title}</a>
			</li>
		</ul>
	</div>
	<div style="margin:30px 0 0 40px;">
			新闻标题：${newsInfo.title}<br /> <br /> 
			新闻作者：${newsInfo.author}<br /> <br /> 
			发布时间：${newsInfo.publishTime}<br /> <br /> 
			审核状态：${newsInfo.status}<br /> <br />
			新闻概要：${newsInfo.summary}<br /> <br />  
			新闻内容：<br /> <br /> 
			${newsInfo.content}
	</div>
	<br />
</body>
</html>
