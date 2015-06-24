<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>菜单栏</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
	$(function() {
		//导航切换
		$(".menuson li").click(function() {
			$(".menuson li.active").removeClass("active");
			$(this).addClass("active");
		});

		$('.title').click(function() {
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if ($ul.is(':visible')) {
				$(this).next('ul').slideUp();
			} else {
				$(this).next('ul').slideDown();
			}
		});
	});
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop">
		<span></span>菜单栏
	</div>

	<dl class="leftmenu">
		<dd>
			<div class="title">
				<span><img src="images/leftico01.png" /> </span>个人中心
			</div>
			<ul class="menuson">
				<li class="active"><cite></cite><a
					href="<%=basePath%>member/self/selfInfo" target="rightFrame">基本资料</a><i></i>
				</li>
				<li><cite></cite><a href="<%=basePath%>member/self/go-edit-pic"
					target="rightFrame">修改头像</a><i></i>
				</li>
				<li><cite></cite><a
					href="<%=basePath%>member/self/go-edit-pass" target="rightFrame">修改密码</a><i></i>
				</li>
				<li><cite></cite><a href="<%=basePath%>news/manage/go-add"
					target="rightFrame">发布新闻</a><i></i>
				</li>
				<li><cite></cite><a href="<%=basePath%>project/manage/go-add"
					target="rightFrame">发布项目</a><i></i>
				</li>
				<li><cite></cite><a href="<%=basePath%>message/manage/go-reply"
					target="rightFrame">回复留言</a><i></i></li>
				<li><cite></cite><a href="<%=basePath%>studies/manage/go-add"
					target="rightFrame">汇报学习情况</a><i></i></li>
				<li><cite></cite><a
					href="<%=basePath%>studies/manage/list-self" target="rightFrame">历史学习情况</a><i></i>
				</li>
			</ul>
		</dd>
		<c:if test="${memberSession.manageMember==true}">
			<dd>
				<div class="title">
					<span><img src="images/leftico01.png" /> </span>首页管理
				</div>
				<ul class="menuson">
					<li><cite></cite><a href="<%=basePath%>index/manage/list"
						target="rightFrame">图片轮换</a><i></i>
					</li>

				</ul>
			</dd>

			<dd>
				<div class="title">
					<span><img src="images/leftico01.png" /> </span>成员管理
				</div>
				<ul class="menuson">
					<li><cite></cite><a href="<%=basePath%>member/manage/list"
						target="rightFrame">成员列表</a><i></i></li>
				</ul>
			</dd>
			<dd>
				<div class="title">
					<span><img src="images/leftico01.png" /> </span>邮件管理
				</div>
				<ul class="menuson">
					<li><cite></cite><a href="<%=basePath%>manage/mail" target="rightFrame" >管理邮件</a><i></i></li>
				</ul>
			</dd>
		</c:if>
		<c:if test="${memberSession.manageNews==true}">
			<dd>
				<div class="title">
					<span><img src="images/leftico01.png" /> </span>新闻管理
				</div>
				<ul class="menuson">
					<li><cite></cite><a href="<%=basePath%>news/manage/list"
						target="rightFrame">新闻列表</a><i></i></li>
				</ul>
			</dd>
		</c:if>
		<c:if test="${memberSession.manageProject==true}">
			<dd>
				<div class="title">
					<span><img src="images/leftico01.png" /> </span>项目管理
				</div>
				<ul class="menuson">
					<li><cite></cite><a href="<%=basePath%>project/manage/list"
						target="rightFrame">项目列表</a><i></i></li>
				</ul>
			</dd>
		</c:if>
		<c:if test="${memberSession.manageMessage==true}">
			<dd>
				<div class="title">
					<span><img src="images/leftico02.png" /> </span>留言管理
				</div>
				<ul class="menuson">
					<li><cite></cite><a href="<%=basePath%>message/manage/list"
						target="rightFrame">留言列表</a><i></i></li>
				</ul>
			</dd>
		</c:if>
		<dd>
			<div class="title">
				<span><img src="images/leftico01.png" /> </span>学习管理
			</div>
			<ul class="menuson">
				<li><cite></cite><a href="<%=basePath%>studies/manage/list"
					target="rightFrame">成员学习情况</a><i></i></li>
			</ul>
		</dd>
	</dl>

</body>
</html>
