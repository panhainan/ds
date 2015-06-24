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
<title>梦之站 | 登录</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<%-- <link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css"> --%>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=basePath%>js/jquery1.11.2.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<style rel="stylesheet">
body {
	background-color: #DBDBDB;
	font-family: 宋体;
}
</style>
</head>
<body>
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
							<li><a href="<%=basePath%>member/go-login">登录</a></li>
							<li><a href="<%=basePath%>member/go-register">注册</a></li>
						</c:if>
					</ul>
				</div>

			</nav>
		</div>
	</div>
	<div class="container"
		style="background-color: #ffffff;padding-bottom: 20px;">
		<div class="row">
			<ol class="breadcrumb container">
				<li class="first"><a href="<%=basePath%>">首页</a>
				</li>
				<li class="last"><a href="<%=basePath%>member/go-login" class="active">登录</a>
				</li>
			</ol>
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form class="form-signin" role="form"
					action="<%=basePath%>member/login" method="post"
					id="user-login-form" accept-charset="UTF-8">
					<input type="hidden" name="form_build_id"
						value="form-dBav1gIi8-NktMOVDC7HBMpIDOvfIyFi3Rfc1kTrrXk">
					<input type="hidden" name="form_id" value="user_login_block">
					<p style="color: red">${message}</p>
					<h2 class="text-center">Welcome</h2>
					<div class="form-item form-type-textfield form-item-name">
						<input placeholder="用户登录邮箱"
							class="form-control form-control required" type="email"
							id="edit-email" name="loginEmail" value="" size="15"
							maxlength="60" required>
					</div>
					<br />
					<div class="form-item form-type-password form-item-pass">
						<input placeholder="密码" class="form-control form-control required"
							type="password" id="edit-pass" name="loginPass" size="15"
							maxlength="128" required>
					</div>
					<br /> <input class="btn-primary btn-block btn btn form-submit"
						type="submit" id="edit-submit--2" name="op" value="登录"> <br />
					<ul class="list-inline text-center">
						<li><a href="/user/register" title="创建新用户帐号">申请加入我们</a>
						</li>
						<li>|</li>
						<li><a href="/user/password" title="通过电子邮件重设密码。">忘记密码</a>
						</li>
					</ul>
				</form>
				<br>
				<br>
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
