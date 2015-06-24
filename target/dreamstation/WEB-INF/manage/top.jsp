<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>top</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected");
		$(this).addClass("selected");
	});
});
</script>


</head>

<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
   	<font style="font-size: 36px;font-weight: bolder;line-height: 88px;font-family: 楷体;" color="white">&emsp;梦之站管理平台</font>
    </div>
        
            
    <div class="topright">    
    <ul>
    <li><a href="" target="_top">返回首页</a></li>
    <li><a href="<%=basePath%>member/self/logout" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span><a href="<%=basePath%>member/self/selfInfo" style="color: white;font-weight: bolder;" target="rightFrame">${memberSession.name}</a></span>
    </div>    
    
    </div>

</body>
</html>
