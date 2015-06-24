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

<title>查看学习情况</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>umeditor/themes/default/css/umeditor.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="<%=basePath%>umeditor/jquery-1.10.2.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>umeditor/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>umeditor/umeditor.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>umeditor/lang/zh-cn/zh-cn.js"></script>
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="<%=basePath%>studies/manage/list">学习管理</a></li>
			<li><a href="<%=basePath%>studies/manage/look?id=${studiesInfo.id}">查看个人学习情况</a>
			</li>
		</ul>
	</div>
	<div class="formbody">
		阶段主题：${studiesInfo.periodTheme}<br/><br/>
		时间段：${studiesInfo.periodTime}<br/><br/>
		阶段学习内容：${studiesInfo.periodContent}<br/><br/>
	</div>
</body>