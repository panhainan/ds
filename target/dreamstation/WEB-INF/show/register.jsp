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
<title>梦之站 | 注册</title>
<style rel="stylesheet">
body {
	background-color: #DBDBDB;
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
				<a href="<%=basePath%>" alt="主页"><img src="<%=basePath%>img/icon/logo.png"
					alt="DreamStation"> </a>
			</h3>
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-ex1-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html" title="首页">梦之站</a>
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
	<div class="container"
		style="background-color: #ffffff;padding-bottom: 20px;">
		<div class="row">
			<ol class="breadcrumb container">
				<li class="first"><a href="<%=basePath%>">首页</a>
				</li>
				<li class="last"><a href="<%=basePath%>manage/go-register"
					class="active">注册</a>
				</li>
			</ol>
			<p style="margin: 20px;">&emsp;&emsp;欢迎您的到来，请认真填写以下信息，填写完成后点击确认注册，然后等待梦之站的确定，谢谢！</p>
			<p style="margin: 20px;">&emsp;&emsp;注意此页面主要是为已加入梦之站的成员服务，其他游客注册无效！</p>
			<div style="margin: 20px;">
				<form class="form-horizontal" action="<%=basePath%>member/register" method="post" role="form">

					<div class="form-group">
						<label for="truename" class="col-sm-4 control-label">真实姓名</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="truename" name="name"
								placeholder="请输入真实姓名" required>
						</div>
					</div>
					<div class="form-group">
						<label for="grade" class="col-sm-4 control-label">目前情况</label> 
						<select name="gradeNumber"
							class="col-sm-3  input-sm" id="grade" style="margin-left: 15px;">
							<option value="1" style="height: 25px;line-height: 25px;">大一</option>
							<option value="2" style="height: 25px;line-height: 25px;">大二</option>
							<option value="3" style="height: 25px;line-height: 25px;">大三</option>
							<option value="4" style="height: 25px;line-height: 25px;">大四</option>
							<option value="5" style="height: 25px;line-height: 25px;">毕业</option>
							<option value="6" style="height: 25px;line-height: 25px;">老师</option>
							<option value="0" style="height: 25px;line-height: 25px;">其他</option>
						</select>
					</div>
					<div class="form-group">
						<label for="categoryNumber" class="col-sm-4 control-label">所属类别</label>
						<select class="col-sm-3  input-sm" id="category" name="categoryNumber"
							style="margin-left: 15px;">
							<option value="1" style="height: 25px;line-height: 25px;">程序员</option>
							<option value="2" style="height: 25px;line-height: 25px;">设计师</option>
							<option value="3" style="height: 25px;line-height: 25px;">导师</option>
						</select>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-4 control-label">常用邮箱</label>
						<div class="col-sm-4">
							<input type="email" name="loginEmail" class="form-control"
								id="email" placeholder="请输入常用邮箱，用来进行登录和其他操作" required>
						</div>
					</div>
					<div class="form-group">
						<label for="loginpass" class="col-sm-4 control-label">登录密码</label>
						<div class="col-sm-4">
							<input type="password" class="form-control" name="loginPass" id="loginpass"
								placeholder="请输入登录密码" required>
						</div>
					</div>
					<div class="form-group">
						<label for="phone" class="col-sm-4 control-label">联系电话</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="phone" id="phone"
								placeholder="请输入联系电话" required>
						</div>
					</div>
					<div class="form-group">
						<label for="qq" class="col-sm-4 control-label">Q Q 号码</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="qq" id="qq"
								placeholder="请输入Q Q 号码" required>
						</div>
					</div>
					<div class="form-group">
						<label for="introduction" class="col-sm-4 control-label">个人简介</label>
						<div class="col-sm-6">
							<textarea style="resize:none" name="introduction" class="form-control" id="qq"
								placeholder="请输入150字以内的个人介绍" required></textarea>
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-4">
							<button type="submit" class="btn btn-primary btn-lg">确认注册</button>
						</div>
					</div>
				</form>
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
