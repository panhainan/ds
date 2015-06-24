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
<title>梦之站 | ${memberInfo.category} | ${memberInfo.name}</title>
<style rel="stylesheet">
body {
	background-color: #DBDBDB;
	font-family: 宋体;
}

p {
	font-size: 16px;
	line-height: 1.5;
}

.content img {
	max-width: 100%;
	height: auto;
	-ms-interpolation-mode: bicubic;
}

.content img,.content object {
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
		style="background-color: #ffffff;padding-bottom: 20px;min-height: 450px;">
		<div class="row">
			<ol class="breadcrumb container">
				<li class="first"><a href="<%=basePath%>">首页</a>
				</li>
				<li><a href="<%=basePath%>member">成员风采</a>
				</li>
				<li class="last"><a
					href="<%=basePath%>member/look?id=${memberInfo.id}" class="active">${memberInfo.category}:${memberInfo.name}</a>
				</li>
			</ol>
			<div id="content" class="content">
				<div class="col-md-12">
					<div class="col-md-1"></div>
					<div class="col-md-6">
						<h1 style="text-align: center;">${memberInfo.name}</h1>
						<br>
						<p>&emsp;&emsp;${memberInfo.introduction}</p>
					</div>
					<div class="col-md-4" style="text-align: center;" align="center">
						<img src="<%=basePath%>${memberInfo.picture}"  onerror="this.src='<%=basePath%>img/default.png'"  class="img-responsive">
					</div>
				</div>
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<br>
					<div>${memberInfo.details}</div>
				</div>
				<div class="col-md-1"></div>
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