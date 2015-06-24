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
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="<%=basePath%>js/jquery1.11.2.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <title>梦之站 | 团队介绍</title>
    <style rel="stylesheet">
        body{
            background-color: #DBDBDB;
            font-family: 宋体;
        }
        p{
            font-size: 20px;
            font-weight: 200;
            
        }
        .intro{
            margin: 40px;
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
<!-- 动态列表 -->
<div class="container"  style="background-color: #ffffff;padding-bottom: 20px;">
    <div class="row">
        <ol class="breadcrumb container">
            <li class="first"><a href="<%=basePath%>">首页</a></li>
            <li class="last"><a href="<%=basePath%>introduction" class="active">团队介绍</a></li>
        </ol>
        <div class="intro">
            <p>&emsp;&emsp;梦之站团队(又名DreamStation)成立于2011年，原名企业信息系统快速开发团队。</p>
            <p>&emsp;&emsp;梦之站团队一直专注于java web和android开发。经过两年的成长与发展，现在团队中包含三名指导老师，40名正式成员。团队成立了管理委员会，建立了全面的奖惩制度和准确的学习方法、路线。基本形成了以学生自主学习为主，高年级学生指导为辅，老师统筹管理的团队学习生活氛围。团队精神是创新、奉献、拼搏、传承、合作。</p>
            <p>&emsp;&emsp;在过去的两年中，团队成员积极参加大大小小的比赛，例如：挑战杯，科技立项，ACM大赛。并且取得了很不错的成绩。团队主学习宗旨是让每个成员都融入到项目中去学习新的知识。团队会定期举行全体成员会议和户外活动，方便团队成员之间互相学习和交流。</p>
            <p>&emsp;&emsp;展望未来，梦之站团队的目标是成为长沙理工大学最优秀的web和android开发团队。</p>
        </div>
        <div class="intro">
            <h2>团队精神</h2>
            <p>&emsp;&emsp;<b>创新</b>——开创人生，拓新未来</p>
            <p>&emsp;&emsp;<b>拼搏</b>——拼人生，搏未来</p>
            <p>&emsp;&emsp;<b>奉献</b>——给予也是一种快乐</p>
            <p>&emsp;&emsp;<b>传承</b>——传文化，承精神；传经典，承创新</p>
            <p>&emsp;&emsp;<b>合作</b>——合作成就效益，合作体验温度，合作决定未来</p>
        </div>
        <div class="intro">
            <h2>团队文化</h2>
            <p>&emsp;&emsp;<b>学习</b>：自主学习、老成员带新成员学习指导模式，指导老师辅助指导监督的学习方式，不定期进行技术或项目讲座。</p>
            <p>&emsp;&emsp;<b>竞争</b>：以积分制驱动成员学习，定期评价成员积分情况，奖励积分靠前成员，评估积分靠后成员。不定期开展团队内部作品竞赛。</p>
            <p>&emsp;&emsp;<b>作品</b>：以作品为目标，提倡以通过完成优秀作品的方式锻炼成员实践技能。推荐优秀作品参加各种竞赛活动。</p>
            <p>&emsp;&emsp;<b>创新</b>：紧跟技术前沿，凝练新方向新技术新点子，为优秀作品提供创新源泉。</p>
            <p>&emsp;&emsp;<b>活动</b>：不定期开展团队活动，凝聚团队成员，提高成员集体荣誉感。</p>
        </div>
    </div>
</div>
<!-- 底部版权声明 -->
<div class="container text-center">
    <hr>
    <div class="row">
        <div class="col-md-12">
            <address>
                Copyright@<strong>梦之站</strong> &emsp;| &emsp; 湖南省长沙市(雨花区)万家丽南路2段960号<br>
                <abbr title="Phone">电话:</abbr> 0731-2309047 &emsp;&emsp;
                <abbr title="Email">邮箱:</abbr> <a href="mailto:#">dreamstationx.@sina.com</a>
            </address>
        </div>
    </div>
</div>
</body>
</html>