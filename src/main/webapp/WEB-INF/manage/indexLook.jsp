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

<title>首页图片查看</title>

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
			<li><a href="<%=basePath%>index/manage/list">首页管理</a></li>
			<li>查看首页展示图片：${indexInfo.name}</li>
		</ul>
	</div>
	<div class="rightinfo">
		<h2>
			${indexInfo.name}
		</h2>
		<p>${indexInfo.introduction}</p>
		<p>${indexInfo.priority}</p>
		<span><img width="300px" src="<%=basePath%>${indexInfo.webSite}" /> </span>
		
	</div>
</body>