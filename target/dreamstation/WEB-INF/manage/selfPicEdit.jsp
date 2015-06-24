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
<title>头像修改</title>
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
			<li><a href="<%=basePath%>member/self/go-edit-pic">修改头像</a>
			</li>
		</ul>
	</div>

	<div class="mainindex" style="margin-left:30px;">
		<form action="<%=basePath%>member/self/edit-pic" method="post" enctype="multipart/form-data">
			图片&emsp;地址：<input type="text" class="dfinput" style="width: 600px;"
				id="f_file">&emsp;&emsp;<input type="button" value="选择"
				class="btn" onClick="fu.click()"><input name="fileUpload"
				type="file" id="fu" onchange="f_file.value=this.value"
				style="display:none"><br><br><br>
			<div style="width: 100%">
				<input type="submit" class="btn" value="确定保存">&emsp;&emsp;<input
					type="button" class="btn" onclick="javascript:history.go(-1);"
					value="取消">
			</div>
		</form>
	</div>



</body>

</html>
