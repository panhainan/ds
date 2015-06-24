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

<title>编辑项目</title>

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
			<li><a href="<%=basePath%>project/manage/list">项目管理</a>
			</li>
			<li><a
				href="<%=basePath%>project/manage/go-edit?id=${projectInfo.id}">编辑项目</a>
			</li>
		</ul>
	</div>
	<div style="margin:30px 0 0 40px;">
		<form action="<%=basePath%>project/manage/edit" method="post"
			enctype="multipart/form-data">
			<input type="hidden" name="id" value="${projectInfo.id}">
			项&nbsp;&nbsp;目&nbsp;&nbsp;名&nbsp;&nbsp;称：<input name="name"
				type="text" class="dfinput" value="${projectInfo.name}"
				style="width:800px;" /><br /> <br /> 项&nbsp;&nbsp;目&nbsp;负责人：<input
				name="author" type="text" class="dfinput"
				value="${projectInfo.author}" style="width:800px;" /><br /> <br />
			项&nbsp;&nbsp;目&nbsp;&nbsp;组&nbsp;&nbsp;员：<input name="groupMember"
				type="text" class="dfinput" value="${projectInfo.groupMember}"
				style="width:800px;" /><br /> <br /> 项目展示图片：<input type="text"
				class="dfinput" style="width: 600px;" id="f_file">&emsp;&emsp;<input
				type="button" value="选择" class="btn" onClick="fu.click()"><input
				name="fileUpload" type="file" id="fu"
				onchange="f_file.value=this.value" style="display:none"><br>
				<input name="picture" type="hidden" 
				value="${projectInfo.picture}"  />
			<br> 项目访问地址：<input name="website" type="text" class="dfinput"
				value="${projectInfo.website}" style="width:800px;" /><br /> <br />
			项目简介：<br /> <br />
			<textarea
				style="width:1000px;height: 80px;resize:none;line-height: 26px;" 
				class="dfinput" name="summary">${projectInfo.summary}</textarea>
			<br /> <br /> 项目详细内容：<br /> <br />
			<!-- 加载编辑器的容器 -->
			<script id="container" name="details" type="text/plain">${projectInfo.details}</script>
			<!-- 实例化编辑器 -->
			<script type="text/javascript">
				var editor = UM.getEditor('container');
			</script>
			<br /> <input type="submit" class="btn" value="确定保存">&emsp;&emsp;<input
				type="button" class="btn" onclick="javascript:history.go(-1);"
				value="取消"> <br /> <br />
		</form>
	</div>
</body>
</html>
