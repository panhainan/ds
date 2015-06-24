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
<base href="<%=basePath%>">
<head lang="en">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=basePath%>js/jquery1.11.2.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<title>梦之站 | 成员风采</title>
<style rel="stylesheet">
body {
	background-color: #DBDBDB;
	font-family: 宋体;
}

.col-md-3 {
	margin: 10px 48px;
	padding: 0px;
}

p {
	font-size: 20px;
	font-weight: 200;
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
							<li><a href="<%=basePath%>member/go-login">登录</a></li>
							<li><a href="<%=basePath%>member/go-register">注册</a></li>
						</c:if>
					</ul>
				</div>

			</nav>
		</div>
	</div>
	<!-- 导师 程序员 美工 -->
	<div class="container"
		style="background-color: #ffffff;padding-bottom: 20px;">
		<div class="row">
			<ol class="breadcrumb container">
				<li class="first"><a href="<%=basePath%>">首页</a></li>
				<li class="last"><a href="<%=basePath%>member" class="active">成员风采</a>
				</li>
			</ol>
			<p>&emsp;&emsp;梦之站的成员主要分为程序员、设计师和导师三大类。</p>
			<br>
			<div class="col-md-3">
				<div class="jumbotron">
					<h2>导师</h2>
					<p></p>
					<p>
						<a class="btn btn-primary btn-lg"
							href="<%=basePath%>member/teacher/list" role="button">Let's
							look !</a>
					</p>
				</div>
			</div>
			<div class="col-md-3">
				<div class="jumbotron">
					<h2>程序员</h2>
					<p></p>
					<p>
						<a class="btn btn-primary btn-lg"
							href="<%=basePath%>member/programmer/list" role="button">Let's
							look !</a>
					</p>
				</div>
			</div>
			<div class="col-md-3">
				<div class="jumbotron">
					<h2>设计师</h2>
					<p></p>
					<p>
						<a class="btn btn-primary btn-lg"
							href="<%=basePath%>member/designer/list" role="button">Let's
							look !</a>
					</p>
				</div>
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