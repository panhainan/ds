<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>发布新闻</title>

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
			<li><a href="#">新闻管理</a></li>
			<li><a href="<%=basePath%>news/manage/go-add">发布新闻</a></li>
		</ul>
	</div>
	<div style="margin:30px 0 0 40px;">
		<form action="<%=basePath%>news/manage/add" method="post">
			新闻标题：<input name="title" type="text" class="dfinput"
				style="width:800px;" /><br /> <br />
			新闻概要：<br /> <br /> <textarea style="width:1000px;height: 80px;resize:none;" class="dfinput" name="summary"></textarea> <br /> <br />
			新闻内容：<br /> <br />
			<!-- 加载编辑器的容器 -->
			<script id="container" name="content" type="text/plain"></script>
			<!-- 实例化编辑器 -->
			<script type="text/javascript">
				var editor = UM.getEditor('container');
			</script>
			<br /> <input type="submit" class="btn" value="确定保存">&emsp;&emsp;<input type="button" class="btn" onclick="javascript:history.go(-1);" value="取消">
			<br /> <br /> 
		</form>
	</div>
</body>
</html>
