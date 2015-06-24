<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=basePath%>js/jquery1.11.2.min.js"></script>


<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<title>梦之站 | 导师</title>
<style rel="stylesheet">
body {
	background-color: #DBDBDB;
	font-family: 宋体;
}

p {
	font-size: 18px;
	font-weight: 200;
}

.breadcrumb {
	margin-bottom: 0;
	height: 40px;
	line-height: 30px;
}

.teacher-list {
	padding: 10px 30px;
}
</style>
</head>
<body>
	<!-- 导航栏 -->
	<div class="container">
		<div class="row">
			<h3>
				<a href="<%=basePath%>" alt="主页"><img src="<%=basePath%>img/icon/logo.png"
					alt="DreamStation"> </a>
			</h3>
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-ex1-collapse">
						<span class="sr-only"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<%=basePath%>" title="首页">梦之站</a>
				</div>

				<div class="collapse navbar-collapse navbar-ex1-collapse">
					<ul id="main-menu-links" class="nav navbar-nav">
						<li><a href="<%=basePath%>introduction">团队介绍</a></li>
						<li><a href="<%=basePath%>member">成员风采</a></li>
						<li><a href="<%=basePath%>news/list">团队动态</a></li>
						<li><a href="<%=basePath%>project/list">科研成果</a></li>
						<li><a href="<%=basePath%>message/list">留言板</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<c:if test="${memberSession!=null}">
							<li><a href="<%=basePath%>manage/main">${memberSession.name}</a>
							</li>
						</c:if>
						<c:if test="${memberSession==null}">
							<li><a href="<%=basePath%>member/go-login">登录</a>
							</li>
							<li><a href="<%=basePath%>member/go-register">注册</a>
							</li>
						</c:if>
					</ul>
				</div>

			</nav>
		</div>
	</div>
	<!-- 导师列表 -->
	<div class="container"
		style="background-color: #ffffff;padding-bottom: 20px;">
		<div class="row">
			<ol class="breadcrumb container">
				<li class="first"><a href="<%=basePath%>">首页</a></li>
				<li><a href="<%=basePath%>member">成员风采</a></li>
				<li class="last"><a href="<%=basePath%>member/teacher/list"
					class="active">导师</a></li>
			</ol>
			<div class="teacher-list col-md-12">
				<c:forEach items="${listTeacherInfo}" var="teacherInfo">

					<div class="row">
						<div class="col-md-3">
							<div class="teacher-picture">
								<img src="<%=basePath%>${teacherInfo.picture}"   onerror="this.src='<%=basePath%>img/default.png'"  class="img-responsive">
							</div>
						</div>
						<div class="col-md-9">
							<div class="teacher-introduction">
								<h2>${teacherInfo.name}</h2>
								<br>
								<p>&emsp;&emsp;${teacherInfo.introduction}</p>
								<p>&emsp;&emsp;QQ：${teacherInfo.qq}</p>
								<p>&emsp;&emsp;手机：${teacherInfo.phone}</p>
							</div>
							<div class="pull-right">
								<a href="<%=basePath%>member/look?id=${teacherInfo.id}"><span
									class="glyphicon glyphicon-share-alt"></span>查看详细</a>&emsp;&emsp;
							</div>
						</div>

					</div>
					<hr>
				</c:forEach>
			</div>
			<div class="text-center">
				<ul class="pagination">
					<c:choose>
						<c:when test="${pageBean.currentPage==1}">
						</c:when>
						<c:otherwise>
							<li class="next last"><a
								href="<%=basePath%>member/teacher/list?current=${pageBean.currentPage-1}"
								title="去上一个页面" class="active">‹ 上一页 </a></li>
						</c:otherwise>
					</c:choose>
					<li class="next last"><a
						href="<%=basePath%>member/teacher/list?current=1" title="去首页"
						class="active first">首页</a></li>
					<li class="active first"><a
						href="<%=basePath%>member/teacher/list?current=${pageBean.currentPage}">${pageBean.currentPage}</a>
					</li>
					<li class="next last"><a
						href="<%=basePath%>member/teacher/list?current=${pageBean.totalPages}"
						title="去尾页" class="active first">尾页</a></li>
					<c:choose>
						<c:when test="${pageBean.currentPage==pageBean.totalPages}">
						</c:when>
						<c:otherwise>
							<li class="next last"><a
								href="<%=basePath%>member/teacher/list?current=${pageBean.currentPage+1}"
								title="去下一个页面" class="active">下一页 ›</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
	<!-- 底部版权声明 -->
	<div class="container text-center">
		<hr>
		<div class="row">
			<div class="col-md-12">
				<address>
					Copyright@<strong>梦之站</strong> &emsp;| &emsp;
					湖南省长沙市(雨花区)万家丽南路2段960号<br> <abbr title="Phone">电话:</abbr>
					0731-2309047 &emsp;&emsp; <abbr title="Email">邮箱:</abbr> <a
						href="mailto:#">dreamstationx.@sina.com</a>
				</address>
			</div>
		</div>
	</div>
</body>
</html>