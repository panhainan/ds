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

<title>汇报学习情况</title>

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
			<li><a href="<%=basePath%>studies/manage/list">学习情况</a></li>
			<li><a href="<%=basePath%>studies/manage/go-add">发布个人学习情况</a>
			</li>
		</ul>
	</div>
	<div class="formbody">

		<form action="<%=basePath%>studies/manage/add" method="post" >
			阶&nbsp;&nbsp;段&nbsp;&nbsp;主&nbsp;&nbsp;题：<input type="text" name="periodTheme" class="dfinput"
				style="width:800px;"><br> <br>时&emsp;&nbsp;间&nbsp;&emsp;&nbsp;段：<input
				type="text" name="periodTime" class="dfinput" style="width:800px;"><br>
			<br> 阶段学习内容：<br><br>
			<!-- 加载编辑器的容器 -->
			<script id="container" name="periodContent" type="text/plain"></script>
			<!-- 实例化编辑器 -->
			<script type="text/javascript">
				var editor = UM.getEditor('container');
			</script>
			<br> <br> <input
				type="submit" class="btn" value="确定保存">&emsp;&emsp;<input
				type="button" class="btn" onclick="javascript:history.go(-1);"
				value="取消">
		</form>
	</div>
</body>