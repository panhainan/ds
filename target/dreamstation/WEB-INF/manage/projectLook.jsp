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

<title>${projectInfo.name}</title>

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
			<li><a href="#">项目管理</a>
			</li>
			<li><a href="<%=basePath%>project/manage/look?id=${projectInfo.id}">${projectInfo.name}</a>
			</li>
		</ul>
	</div>
	<div style="margin:30px 0 0 40px;">
			项目名称：${projectInfo.name}<br /> <br /> 
			项目负责人：${projectInfo.author}<br /> <br />
			项目组员：${projectInfo.groupMember}<br /> <br /> 
			项目展示图片：<img alt="" src="<%=basePath%>${projectInfo.picture}"> <br /> <br /> 
			项目访问地址：${projectInfo.website}<br /> <br /> 
			项目详细内容：<br /> <br />
			${projectInfo.details}
	</div>
	<br />
</body>
</html>
