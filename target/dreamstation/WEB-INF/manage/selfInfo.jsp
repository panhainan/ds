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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>基本资料</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<style type="text/css">
p {
	line-height: 2;
}
table tr td{
	padding:4px;
}
</style>
</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>个人中心</li>
			<li><a href="<%=basePath%>member/self/selfInfo">基本资料</a>
			</li>
		</ul>
	</div>

	<div class="mainindex" style="margin-left:30px;">
		<div style="float: left;width: 100%; ">
			<div style="float: left;width: 40%;height: 300px;">
				<p>姓名：${selfInfo.name}</p>
				<p>邮箱：${selfInfo.loginEmail}</p>
				<p>Q Q：${selfInfo.qq}</p>
				<p>电话：${selfInfo.phone}</p>
				<p>年级：${selfInfo.grade}</p>
				<p>类别：${selfInfo.category}</p>
				<p>
					权限： <br>
				<table cellpadding="1" cellspacing="1">
					<tr>
						<td width="60px"
							style="border: 1px solid silver;text-align: center;">新闻管理</td>
						<td width="150px" style="border: 1px solid silver">${selfInfo.userAuthority.publishNews}</td>
						<td width="150px" style="border: 1px solid silver">${selfInfo.userAuthority.manageNews}</td>
					</tr>
					<tr>
						<td style="border: 1px solid silver;text-align: center;">项目管理</td>
						<td style="border: 1px solid silver">${selfInfo.userAuthority.publishProject}</td>
						<td style="border: 1px solid silver">${selfInfo.userAuthority.manageProject}</td>
					</tr>
					<tr>
						<td style="border: 1px solid silver;text-align: center;">留言管理</td>
						<td style="border: 1px solid silver">${selfInfo.userAuthority.replyMessage}</td>
						<td style="border: 1px solid silver">${selfInfo.userAuthority.manageMessage}</td>
					</tr>
					<tr>
						<td style="border: 1px solid silver;text-align: center;">成员管理</td>
						<td style="border: 1px solid silver">${selfInfo.userAuthority.manageMember}</td>
						<td style="border: 1px solid silver">${selfInfo.userAuthority.publishNews}</td>
					</tr>
					<tr>
						<td style="border: 1px solid silver;text-align: center;">登录管理</td>
						<td colspan="2" style="border: 1px solid silver">${selfInfo.userAuthority.allowLogin}</td>
					</tr>
				</table> <br>
				</p>
				<p>简介：${selfInfo.introduction}</p>
			</div>
			<div style="float: left;width: 50%;height:500px;">
				<img width="70%" height="90%" alt="" src="<%=basePath%>${selfInfo.picture}"><br /><br />
				<input type="button"
				onclick="window.location.href='<%=basePath%>member/self/go-edit-pic?id=${selfInfo.id}'"
				class="btn" value="修改图片">
			</div>
		</div>
		<div
			style="float: left;width: 100%;font-size: 16px;min-height:300px; ">详细介绍：${selfInfo.details}</div>
		<br /> <br /> <br />
		<div style="width: 100%;float: left;">
			<input type="button"
				onclick="window.location.href='<%=basePath%>member/self/go-edit-info?id=${selfInfo.id}'"
				class="btn" value="编辑资料">
		</div>
	</div>



</body>

</html>
