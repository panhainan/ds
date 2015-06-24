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

<title>${memberInfo.name}</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
table tr td {
	padding: 6px;
}
</style>
</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">成员管理</a></li>
			<li><a
				href="<%=basePath%>member/manage/look?id=${memberInfo.id}">${memberInfo.name}</a>
			</li>
		</ul>
	</div>
	<div
		style="margin:30px 0 0 40px;font-size: 16px;width: 50%;float: left;">
		<div style="width: 100%"><div style="width: 50%;float: left;">
		姓名：${memberInfo.name}<br /> <br /> 年级：${memberInfo.grade}<br /> <br />
		类别： ${memberInfo.category}<br /> <br /> 电话：${memberInfo.phone}<br />
		<br /> Q Q：${memberInfo.qq}<br /> <br />
		邮箱：${memberInfo.loginEmail}<br /> <br /></div>
		<div style="width: 50%;float: left;"><img width="60%" alt="" src="<%=basePath%>${memberInfo.picture}"></div></div>
		<div style="width: 100%;float: left;">简介：${memberInfo.introduction}<br /> <br /> 详细介绍：
		${memberInfo.details}<br /> <br /></div>
	</div>
	<div style="margin:30px 0 0 0;font-size: 16px;width: 40%;float: left;">
		<h1 style="font-size: 18px;">权限情况</h1>
		<br>
		<table cellpadding="1" cellspacing="1">
			<tr>
				<td width="120px"
					style="border: 1px solid silver;text-align: center;">新闻管理</td>
				<td width="180px" style="border: 1px solid silver">${memberInfo.userAuthority.publishNews}</td>
				<td width="180px" style="border: 1px solid silver">${memberInfo.userAuthority.manageNews}</td>
			</tr>
			<tr>
				<td style="border: 1px solid silver;text-align: center;">项目管理</td>
				<td style="border: 1px solid silver">${memberInfo.userAuthority.publishProject}</td>
				<td style="border: 1px solid silver">${memberInfo.userAuthority.manageProject}</td>
			</tr>
			<tr>
				<td style="border: 1px solid silver;text-align: center;">留言管理</td>
				<td style="border: 1px solid silver">${memberInfo.userAuthority.replyMessage}</td>
				<td style="border: 1px solid silver">${memberInfo.userAuthority.manageMessage}</td>
			</tr>
			<tr>
				<td style="border: 1px solid silver;text-align: center;">成员管理</td>
				<td style="border: 1px solid silver">${memberInfo.userAuthority.manageMember}</td>
				<td style="border: 1px solid silver">${memberInfo.userAuthority.publishNews}</td>
			</tr>
			<tr>
				<td style="border: 1px solid silver;text-align: center;">登录管理</td>
				<td colspan="2" style="border: 1px solid silver">${memberInfo.userAuthority.allowLogin}</td>
			</tr>
		</table>
		<br /> <br /> <br />
		<div align="center" style="width: 100%">
			<input type="button"
				onclick="window.location.href='<%=basePath%>member/manage/go-authoriting?id=${memberInfo.id}'"
				class="btn" value="审核">&emsp;&emsp; <input type="button"
				class="btn" onclick="window.location.href='<%=basePath%>member/manage/list'" value="返回列表">
		</div>
	</div>
</body>
</html>
