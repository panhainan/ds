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

<title>首页图片列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
		$(".sure").click(function() {
			var _id = $(".removeId").html();;
			$(".tip").fadeOut(100);
			window.location.href="<%=basePath%>index/manage/remove?id="+ _id;
		});
		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});

	});
function removeConfirm(id,name){
$(".tip").fadeIn(200);
$(".removeId").html("");
$(".removeName").html("");
$(".removeId").html(id);
$(".removeName").html(name);
return false;
}

</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="<%=basePath%>index/manage/list">首页管理</a>
			</li>
		</ul>
	</div>
	<div class="rightinfo">
		<div class="tools">
			<ul class="toolbar">
				<li><a href="<%=basePath%>index/manage/go-add"><span><img
							src="images/t01.png" /> </span>添加</a>
				</li>
			</ul>
		</div>
		<c:choose>
			<c:when test="${listIndexInfo!=null}">
				<div style="height: 400px;">
					<ul class="imglist">
						<c:forEach items="${listIndexInfo}" var="indexInfo">
							<li><span><img width="300px" height="150px"
									src="<%=basePath%>${indexInfo.webSite}" /> </span>
								<h2>
									<b>${indexInfo.name}</b> : ${indexInfo.introduction}
								</h2>
								<p>
									<a href="<%=basePath%>index/manage/go-edit?id=${indexInfo.id}">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
										onclick="return removeConfirm('${indexInfo.id}','${indexInfo.name}')">删除</a>
								</p></li>
						</c:forEach>
					</ul>
				</div>

				<div class="tip">
					<div class="tiptop">
						<span>删除操作提示信息</span><a></a>
					</div>

					<div class="tipinfo">
						<span><img src="images/ticon.png" /> </span> <span
							class="removeId" style="display: none;"></span>
						<div class="tipright">
							<p>
								是否确认要删除"<font class="removeName"></font>"这张图片吗？
							</p>
							<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
						</div>
					</div>

					<div class="tipbtn">
						<input name="" type="button" class="sure" value="确定" />&nbsp; <input
							name="" type="button" class="cancel" value="取消" />
					</div>
				</div>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</div>

</body>