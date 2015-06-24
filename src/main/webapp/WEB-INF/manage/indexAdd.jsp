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

<title>添加首页图片</title>

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
			<li><a href="<%=basePath%>index/manage/go-add">添加首页图片</a>
			</li>
		</ul>
	</div>
	<div class="formbody">

		<br>注意：图片宽度800px和高度400px比要求严格保持为2:1再上传，这样才能在首页取得更好地效果<br>
		<br>
		<form action="<%=basePath%>index/manage/add" method="post"
			enctype="multipart/form-data">
			图片&emsp;名称：<input type="text" name="name" class="dfinput"
				style="width:800px;"><br> <br> 图片&emsp;简介：<input
				type="text" name="introduction" class="dfinput" style="width:800px;"><br>
			<br> 图片&emsp;地址：<input type="text" class="dfinput"
				style="width: 600px;" id="f_file">&emsp;&emsp;<input
				type="button" value="选择" class="btn" onClick="fu.click()"><input
				name="fileUpload" type="file" id="fu"
				onchange="f_file.value=this.value" style="display:none"><br>
			<br> 图片优先级：<input type="text" name="priority" class="dfinput"
				style="width:800px;"><br> <br> <input
				type="submit" class="btn" value="确定保存">&emsp;&emsp;<input
				type="button" class="btn" onclick="javascript:history.go(-1);"
				value="取消">
		</form>
	</div>
</body>