<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<title>梦之站</title>
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

.block-title {
	border-bottom: 1px solid #ccc;
	padding: 10px 0 8px 5px;
	margin: 0;
	font-weight: 800;
}

bs-docs-sidebar .nav>li>a {
	display: block;
	font-size: 13px;
	font-weight: 500;
	color: #999;
	padding: 2px;
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
							<!-- <li><a href="#" data-toggle="modal"
								data-target="#user-sign-in-block">登录</a>
							</li> -->
							<li><a href="<%=basePath%>member/go-login" >登录</a>
							</li>
							<li><a href="<%=basePath%>member/go-register">注册</a>
							</li>
						</c:if>
					</ul>
				</div>

			</nav>
		</div>
	</div>
	<!-- 图片轮换 最新新闻 -->
	<div class="container"
		style="background-color: #ffffff;padding-bottom: 20px">
		<div class="row">
			<ol class="breadcrumb container">
				<li class="first"><a href="<%=basePath%>">首页</a>
				</li>
			</ol>
			<div class="col-md-8">
				<div id="carousel-generic" class="carousel slide"
					data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<c:choose>
							<c:when test="${fn:length(listIndexInfo)>0}">
								<c:forEach var="num" step="1" begin="0"
									end="${fn:length(listIndexInfo)-1}" varStatus="status">
									<c:if test="${num == 0}">
										<li data-target="#carousel-generic" data-slide-to="0"
											class="active"></li>
									</c:if>
									<c:if test="${num!= 0}">
									<li data-target="#carousel-generic" data-slide-to="${num}"
										class=""></li></c:if>
								</c:forEach>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
					</ol>
					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<c:choose>
							<c:when test="${listIndexInfo!=null}">
								<c:forEach items="${listIndexInfo}" var="indexInfo"
									varStatus="status">
									<c:if test="${status.count == 1}">
										<div class="item active">
											<img src="<%=basePath%>${indexInfo.webSite}"
												class="img-responsive" alt="${indexInfo.name}">
											<div class="carousel-caption">
												<h3>${indexInfo.name}</h3>
												<p>${indexInfo.introduction}</p>
											</div>
										</div>
									</c:if>
									<c:if test="${status.count != 1}">
										<div class="item">
											<img src="<%=basePath%>${indexInfo.webSite}"
												class="img-responsive" alt="${indexInfo.name}">
											<div class="carousel-caption">
												<h3>${indexInfo.name}</h3>
												<p>${indexInfo.introduction}</p>
											</div>
										</div>
									</c:if>
								</c:forEach>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
					</div>
					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-generic"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> </a> <a
						class="right carousel-control" href="#carousel-generic"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> </a>
				</div>
			</div>
			<div class="col-md-4" style="padding-top:10px;padding-bottom:10px; ">
				<h4 class="block-title">
					<a href="<%=basePath%>news/list" class="block-title-link">最新动态</a>
					<small>Newest news</small>
				</h4>
				<ul class="nav bs-sidenav">
					<c:if test="${newsInfos!=null}">
						<c:forEach items="${newsInfos}" var="newsInfo">
							<li class=""><a
								href="<%=basePath%>news/look?id=${newsInfo.id}">${newsInfo.title} <c:if test="${newsInfo.theLast==true}"><SUP><font color="red" >new</font><SUP></c:if> </a>
							</li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
			<br>
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
	<!-- 登录模态框（Modal） -->
	<%-- <div class="modal fade" id="user-sign-in-block" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">登录</h4>
				</div>
				<div class="row">
					<div class="modal-body col-md-2"></div>
					<div class="modal-body col-md-8">
						<form class="form-signin" role="form"
							action="<%=basePath%>member/login" method="post"
							id="user-login-form" accept-charset="UTF-8">
							<input type="hidden" name="form_build_id"
								value="form-dBav1gIi8-NktMOVDC7HBMpIDOvfIyFi3Rfc1kTrrXk">
							<input type="hidden" name="form_id" value="user_login_block">
							<h2 class="text-center">Welcome</h2>
							<div class="form-item form-type-textfield form-item-name">
								<input placeholder="用户登录邮箱"
									class="form-control form-control required" type="email"
									id="edit-email" name="loginEmail" value="" size="15"
									maxlength="60" required>
							</div>
							<br />
							<div class="form-item form-type-password form-item-pass">
								<input placeholder="密码"
									class="form-control form-control required" type="password"
									id="edit-pass" name="loginPass" size="15" maxlength="128"
									required>
							</div>
							<br /> <input class="btn-primary btn-block btn btn form-submit"
								type="submit" id="edit-submit--2" name="op" value="登录">
							<br />
							<ul class="list-inline text-center">
								<li><a href="/user/register" title="创建新用户帐号">申请加入我们</a>
								</li>
								<li>|</li>
								<li><a href="/user/password" title="通过电子邮件重设密码。">忘记密码</a>
								</li>
							</ul>
						</form>
					</div>
					<div class="modal-body col-md-2"></div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div> --%>
</body>
</html>