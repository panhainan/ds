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
<title>基本资料修改</title>
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
			<li><a href="<%=basePath%>member/manage/go-edit-info?id=${selfInfo.id}">修改基本资料</a></li>
		</ul>
	</div>

	<div class="mainindex" style="margin-left:30px;">
		<form action="<%=basePath%>member/self/edit-info" method="post">
			<p>姓名：${selfInfo.name}</p>
			<p>邮箱：${selfInfo.loginEmail}</p>
			<p>
				Q Q：<input type="text" value="${selfInfo.qq}"
					style="font-size: 16px;" class="dfinput" name="qq">
			</p>
			<p>
				电话：<input type="text" value="${selfInfo.phone}"
					style="font-size: 16px;" class="dfinput" name="phone">
			</p>
			<p>
				年级：<select name="gradeNumber" class="dfinput"
					style="font-size: 16px;">
					<option value="1" style="height: 25px;line-height: 25px;">大一</option>
					<option value="2" style="height: 25px;line-height: 25px;">大二</option>
					<option value="3" style="height: 25px;line-height: 25px;">大三</option>
					<option value="4" style="height: 25px;line-height: 25px;">大四</option>
					<option value="5" style="height: 25px;line-height: 25px;">毕业</option>
					<option value="6" style="height: 25px;line-height: 25px;">老师</option>
					<option value="0" style="height: 25px;line-height: 25px;">其他</option>
				</select>
			</p>
			<p>
				类别：<select name="categoryNumber" class="dfinput"
					style="font-size: 16px;">
					<option value="1" style="height: 25px;line-height: 25px;">程序员</option>
					<option value="2" style="height: 25px;line-height: 25px;">设计师</option>
					<option value="3" style="height: 25px;line-height: 25px;">导师</option>
				</select>
			</p>
			<p>
				简介：<br>
				<textarea rows="4" name="introduction" cols="80"
					style="font-size: 16px;resize:none;border: 1px solid silver ;line-height: 1.5">${selfInfo.introduction}</textarea>
			</p>
			<p style="font-size: 16px;">详细介绍：</p>
			<!-- 加载编辑器的容器 -->
			<script id="container" name="details" type="text/plain"
				class="dfinput" style="font-size: 16px;">${selfInfo.details}</script>
			<!-- 实例化编辑器 -->
			<script type="text/javascript">
				var editor = UM.getEditor('container');
			</script>
			<br /> <br /> <br />
			<div style="width: 100%">
				<input type="submit" class="btn" value="确定保存">&emsp;&emsp;<input type="button" class="btn" onclick="javascript:history.go(-1);" value="取消">
			</div>
		</form>
	</div>



</body>

</html>
