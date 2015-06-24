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
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<%-- <link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css"> --%>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=basePath%>js/jquery1.11.2.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<title>梦之站 | 团队动态 | ${newsInfo.title}</title>
<style rel="stylesheet">
body {
	background-color: #DBDBDB;
	font-family: 宋体;
}

p {
	font-size: 16px;
	line-height: 1.5;
}

.news-content img {
	height: auto;
	max-width: 100%;
	-ms-interpolation-mode: bicubic;
}

.news-content img,.news-content object {
	max-width: 100%;
	height: auto;
}
</style>
</head>
<body>
	<!-- 导航栏 -->
	<div class="container">
		<div class="row">
			<h3>
				<a href="<%=basePath%>" alt="主页"><img
					src="<%=basePath%>img/icon/logo.png" alt="DreamStation"> </a>
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
						<li><a href="<%=basePath%>introduction">团队介绍</a>
						</li>
						<li><a href="<%=basePath%>member">成员风采</a>
						</li>
						<li><a href="<%=basePath%>news/list">团队动态</a>
						</li>
						<li><a href="<%=basePath%>project/list">科研成果</a>
						</li>
						<li><a href="<%=basePath%>message/list">留言板</a>
						</li>
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
	<!-- 动态列表 -->
	<div class="container"
		style="background-color: #ffffff;padding-bottom: 20px;">
		<div class="row">
			<ol class="breadcrumb container">
				<li class="first"><a href="<%=basePath%>">首页</a>
				</li>
				<li><a href="<%=basePath%>news/list">团队动态</a>
				</li>
				<li class="last"><a
					href="<%=basePath%>news/look?id=${newsInfo.id}" class="active">${newsInfo.title}</a>
				</li>
			</ol>
			<div id="content" style="margin: 40px;">
				<h1 style="text-align: center;">${newsInfo.title}</h1>
				<p>
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>&nbsp;${newsInfo.author}&nbsp;&nbsp;
					<span class="glyphicon glyphicon-time" aria-hidden="true"></span>&nbsp;${newsInfo.publishTime}&nbsp;&nbsp;
				</p>
				<br>
				<h3>简介：</h3>
				<p>&emsp;&emsp;${newsInfo.summary}</p>
				<br/><br/>
				<h3>详细情况：</h3>
				<div class="news-content ">${newsInfo.content}</div>
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