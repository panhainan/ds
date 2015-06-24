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

<title>成员历史学习情况</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>


</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="<%=basePath%>studies/manage/list">学习管理</a></li>
			<li><a href="<%=basePath%>studies/manage/list-member?id=${id}">成员历史学习情况</a>
			</li>
		</ul>
	</div>
	<div class="rightinfo">

		<div>
			<c:choose>
				<c:when test="${listStudiesInfo!=null}">
					<c:forEach items="${listStudiesInfo}" var="studiesInfo">
						<br />
						<div style="width: 800px;border:1px solid silver;padding:20px;">
							<p>
								学习主题：<b>${studiesInfo.periodTheme}</b>&emsp;(${studiesInfo.memberName})&emsp;&emsp;&emsp;&emsp;${studiesInfo.periodTime}
							</p>
							<br /> ${studiesInfo.periodContent} <br />
							<p style="text-align: right;width: 100%">${studiesInfo.publishTime}</p>
						</div>
						<br />
					</c:forEach>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>