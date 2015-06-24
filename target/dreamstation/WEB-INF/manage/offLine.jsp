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
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>未登录或者登录已失效</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<style type="text/css">
p {
	font-size: 16px;
	line-height: 2;
	font-weight: 200;
}
</style>
<script type="text/javascript">
	function countDown(secs, surl) {
		//alert(surl);     
		var jumpTo = document.getElementById('jumpTo');
		jumpTo.innerHTML = secs;
		if (--secs >= 0) {
			setTimeout("countDown(" + secs + ",'" + surl + "')", 1000);
		} else {
			top.location.href = surl;
		}
	}
</script>
</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>未登录或者登录已失效</li>
		</ul>
	</div>

	<div class="mainindex" style="margin-left:30px;text-align: center;">
		<h2 style="font-size: 30px;font-weight: bolder;color:red">未登录或者登录已失效</h2>
		<p>
			请稍等<span id="jumpTo"
				style="font-size: 20px;font-weight: bolder;color:#6699CC">5</span>秒后自动跳转到登录界面
		</p>
		<script type="text/javascript">
				countDown(4, '<%=basePath%>member/go-login');
		</script>
		<p align="center" style="font-size: 16px;">
			如果您的浏览器不支持跳转,请点击<a href="<%=basePath%>member/go-login"
				style="color:red;" target="_top">前往登录</a>.
		</p>

	</div>

</body>

</html>
