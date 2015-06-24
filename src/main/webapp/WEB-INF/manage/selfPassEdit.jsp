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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>密码修改</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
p {
	font-size: 16px;
	line-height: 2;
	font-weight: 200;
}
</style>
</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>个人中心</li>
			<li><a href="<%=basePath%>member/self/go-edit-pass">修改密码</a>
			</li>
		</ul>
	</div>

	<div class="mainindex" style="margin-left:30px;">
		
		<c:if test="${message!=null}"><p style="color: red">${message}</p></c:if>
		<form action="<%=basePath%>member/self/edit-pass" method="post" >
			原&emsp;密&emsp;码：<input type="password" name="oldPass" class="dfinput"
				style="width:800px;"><br> <br> 新&emsp;密&emsp;码：<input
				type="password" name="newPass" class="dfinput" style="width:800px;"><br>
			<br> 重复新密码：<input type="password" name="repeatNewPass"
				class="dfinput" style="width:800px;"><br> <br> <br>
			<br>
			<div style="width: 100%">
				<input type="submit" class="btn" value="确定保存">&emsp;&emsp;<input
					type="button" class="btn" onclick="javascript:history.go(-1);"
					value="取消">
			</div>
		</form>
	</div>



</body>

</html>
