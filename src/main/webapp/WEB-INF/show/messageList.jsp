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
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=basePath%>js/jquery1.11.2.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
<title>梦之站 | 留言板</title>
<style rel="stylesheet">
body {
	background-color: #DBDBDB;
	font-family: 宋体;
}

p {
	font-size: 20px;
	font-weight: 200;
}

.send-word,.message-title {
	margin: 30px;
}

.iw_poi_title {
	color: #CC5522;
	font-size: 14px;
	font-weight: bold;
	overflow: hidden;
	padding-right: 13px;
	white-space: nowrap
}

.iw_poi_content {
	font: 12px arial, sans-serif;
	overflow: visible;
	padding-top: 4px;
	white-space: -moz-pre-wrap;
	word-wrap: break-word
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

	<!-- 留言框 留言列表 -->
	<div class="container"
		style="background-color: #ffffff;padding-bottom: 20px;">
		<div class="row">
			<ol class="breadcrumb container">
				<li class="first"><a href="<%=basePath%>">首页</a>
				</li>
				<li class="last"><a href="<%=basePath%>message/list" class="active">留言板</a>
				</li>
			</ol>
			<div class="send-word">
				<p>&emsp;&emsp;梦之站团队感谢您的到来，您点击了留言板进入了留言区，如果你有什么好的建议或者有什么想了解的欢迎下面留言，或者直接联系我们，联系方式如下，谢谢您的支持！</p>
			</div>
			<div class="col-md-12">
				<div class="col-md-5">
					<h3>联系方式</h3>
					<hr>
					<div class="text-left">
						<span style="font-size: 18px;">&emsp;&emsp;<abbr>电话:</abbr>18229961038(汤强)</span><br>
						<br> <span style="font-size: 18px;">&emsp;&emsp;<abbr>Q
								Q:</abbr>654315356</span><br> <br> <span style="font-size: 18px;">&emsp;&emsp;<abbr>邮箱:</abbr>654315356@qq.com</span><br>
						<br> <span style="font-size: 18px;">&emsp;&emsp;<abbr>地址:</abbr>长沙理工大学云塘校区</span><br>
						<br>
					</div>
				</div>
				<div class="col-md-6">
					<!--百度地图容器-->
					<div style="width:100%;height:300px;border:#ccc solid 1px;"
						id="dituContent"></div>
					<script type="text/javascript" src="<%=basePath%>js/map.js"
						charset="utf8"></script>
				</div>
			</div>
			<br>
			<div class="col-md-12">
				<div class="message-title">
					<h3>留言</h3>
					<hr>
				</div>
				<form class="form-horizontal" action="<%=basePath%>message/add"
					method="post">
					<div class="form-group">
						<label for="inputNickname" class="col-md-1 control-label">昵称</label>
						<div class="col-md-4">
							<input type="text" class="form-control" name="commentName"
								id="inputNickname" placeholder="取一个您喜欢的昵称吧" required>
						</div>
						<label for="inputEmail" class="col-md-1 control-label">邮箱</label>
						<div class="col-md-5">
							<input type="email" class="form-control" name="commentEmail"
								id="inputEmail" placeholder="填写一个您常用的邮箱吧，放心我们不会骚扰您的" required>
						</div>
					</div>
					<div class="form-group"></div>
					<div class="form-group">
						<label for="inputContent" class="col-md-1 control-label">内容</label>
						<div class="col-md-10">
							<textarea class="form-control" name="commentContent" rows="4"
								style="resize: none;" id="inputContent"
								placeholder="说说您的想法建议吧，谢谢" required></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="inputContent" class="col-md-1 control-label"></label>
						<div class="col-md-11">
							<button type="submit" class="btn btn-primary btn-lg">发表评论</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<c:forEach items="${listMessageInfo}" var="messageInfo">
			<div class="col-md-12">
				<hr>
				<div class="form-group">
					<div class="col-md-1"></div>
					<label for="inputContent" style="line-height: 30px;"
						class="col-md-2 control-label"><span
						class="glyphicon glyphicon-user" aria-hidden="true"></span>&emsp;${messageInfo.commentName}<br>
					</label>
					<div class="col-md-9" style="margin-top: 10px;">
						"${messageInfo.commentContent}"&emsp;&emsp;<span
							class="glyphicon glyphicon-time" aria-hidden="true"></span>&emsp;${messageInfo.commentTime}
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group">
					<div class="col-md-1"></div>
					<label for="inputContent" style="line-height: 30px;"
						class="col-md-2 control-label"><span><img alt="ds"
							src="<%=basePath%>img/icon/logo-small.png" style="width: 20px;">
					</span>&nbsp;${messageInfo.replyName}<br> </label>
					<div class="col-md-9" style="margin-top: 10px;">
						"${messageInfo.replyContent}"&emsp;&emsp;<span
							class="glyphicon glyphicon-time" aria-hidden="true"></span>&emsp;${messageInfo.replyTime}
					</div>
				</div>
			</div>
		</c:forEach>
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