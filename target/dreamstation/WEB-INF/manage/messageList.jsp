<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>留言列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
		$(".removeBtn").click(function() {
			var checkBoxs = document.getElementsByName("messageInfoCheckBox");
			var j=0;
			for (var i = 0; i < checkBoxs.length; i++)         
			{               
			    if(checkBoxs[i].checked==true){
			    	j++;
			    };
			}
			if(j==0){
				$(".nulltip").fadeIn(200);
			}else{
				$("#removeRows").html(j);
				$(".tip").fadeIn(200);
			}
		});

		$(".sure").click(function() {
			var checkBoxs = document.getElementsByName("messageInfoCheckBox");
			var _ids=new Array();
			var j=0;
			for (var i = 0; i < checkBoxs.length; i++)         
			{               
			    if(checkBoxs[i].checked==true){
			    	_ids[j++]=checkBoxs[i].value;
			    };
			}
			$(".tip").fadeOut(100);
			window.location.href="<%=basePath%>message/manage/removes?ids="+ _ids;
		});
		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});
		$(".nulltipcancel").click(function() {
			$(".nulltip").fadeOut(100);
		});
		$(".auditingtipsure").click(function() {
			
			$(".auditingtip").fadeOut(100);
		});
		$(".auditingtipcancel").click(function() {
			$(".auditingtip").fadeOut(100);
		});
		document.getElementById("status${status}").checked=true;
	});
	function pitchOn(obj) {
		var s = obj.id;
		var clickRowCheckBox = "messageInfoCheckBox+"
				+ s.substring(s.indexOf('+') + 1, s.length);
		if (document.getElementById(clickRowCheckBox).checked == true) {
			document.getElementById(clickRowCheckBox).checked = false;
		} else {
			document.getElementById(clickRowCheckBox).checked = true;
		};
	}
	function pitchOnAll() {
		var checkBoxs = document.getElementsByName("messageInfoCheckBox");
		var obj = document.getElementsByName("selectIds");
		if (obj.checked == true) {
			obj.checked = false;
			for ( var i = 0; i < checkBoxs.length; i++) {
				checkBoxs[i].checked = false;
			};
		} else {
			obj.checked = true;
			for ( var i = 0; i < checkBoxs.length; i++) {
				checkBoxs[i].checked = true;
			};
		};
	}
	function changeStatus(obj){
		window.location.href="<%=basePath%>message/manage/list?status="
				+ obj.value;
	}
	function auditing(id, commentName, commentContent,replyContent) {
		$(".messageInfoName").html(commentName);
		$(".messageInfoCommentContent").html("“" + commentContent + "”");
		$(".messageInfoId").val(id);
		$(".messageInfoReplyContent").html(replyContent);
		$(".auditingtip").fadeIn(200);
	}
</script>

</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="<%=basePath%>message/manage/list?current=1">留言管理</a>
			</li>
		</ul>
	</div>
	<div class="rightinfo">

		<div class="tools">

			<ul class="toolbar">
				<li class="removeBtn"><span><img src="images/t03.png" />
				</span>批量删除</li>
				<li><span><img src="images/t05.png" /> </span>筛选 <input
					onclick="changeStatus(this)" style="cursor: pointer;" type="radio"
					name="status" value="0" id="status0" /><label
					style="cursor: pointer;" for="status0">待审核</label> &emsp; <input
					onclick="changeStatus(this)" style="cursor: pointer;" type="radio"
					name="status" value="1" id="status1" /><label
					style="cursor: pointer;" for="status1">审核通过</label> &emsp; <input
					onclick="changeStatus(this)" style="cursor: pointer;" type="radio"
					name="status" value="2" id="status2" /><label
					style="cursor: pointer;" for="status2">审核失败</label> &emsp; <input
					onclick="changeStatus(this)" style="cursor: pointer;" type="radio"
					name="status" value="3" id="status3" /><label
					style="cursor: pointer;" for="status3">默认：所有</label>
				</li>
			</ul>

		</div>

		<c:choose>
			<c:when test="${listMessageInfo!=null}">
				<div style="height: 400px;">
					<table class="tablelist">
						<thead>
							<tr>
								<th width="40px"><input name="selectIds" type="checkbox"
									onclick="pitchOnAll()" value="" /></th>
								<th width="60px">编号<i class="sort"><img
										src="images/px.gif" /> </i></th>
								<th>评论人</th>
								<th width="180px">邮箱</th>
								<th width="120px">评论时间</th>
								<th width="120px">审核状态</th>
								<th width="160px">操作</th>
							</tr>
						</thead>
						<tbody>
							<%
									com.ds.dreamstation.dto.Pages pageInfo = (com.ds.dreamstation.dto.Pages) request
													.getAttribute("pageBean");
											int i =1+ pageInfo.getPageSize() * (pageInfo.getCurrentPage()-1);
								%>
							<c:forEach items="${listMessageInfo}" var="messageInfo">
								<tr id="messageInfoTr+${messageInfo.id}" onclick="pitchOn(this)">
									<td><input name="messageInfoCheckBox"
										id="messageInfoCheckBox+${messageInfo.id}" type="checkbox"
										value="${messageInfo.id}" /></td>
									<td><%=i++%></td>
									<td>${messageInfo.commentName}</td>
									<td>${messageInfo.commentEmail}</td>
									<td>${messageInfo.commentTime}</td>
									<td>${messageInfo.status}(<label
										onclick="auditing('${messageInfo.id}','${messageInfo.commentName}','${messageInfo.commentContent}','${messageInfo.replyContent}')"
										style="cursor: pointer;"><img
											style="width: 14px;"  src="<%=basePath%>images/t04.png"  />审核</label> )</td>
									<td><a
										href="<%=basePath%>message/manage/remove?id=${messageInfo.id}"><img style="width: 14px;"
											src="images/t03.png" />删除</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<div class="pagin">
					<div class="message">
						共<i class="blue">${pageBean.allRecords}</i>条记录，当前显示第&nbsp;<i
							class="blue">${pageBean.currentPage}&nbsp;</i>页 ，
						共&nbsp;${pageBean.totalPages}&nbsp;页
					</div>
					<ul class="paginList">
						<c:choose>
							<c:when test="${1!=pageBean.currentPage}">
								<li class="paginItem"><a href="javascript:;"><span
										class="pagepre"></span> </a>
								</li>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
						<c:forEach begin="1" end="${pageBean.totalPages}" step="1"
							var="pageItem">
							<c:choose>
								<c:when test="${pageItem==pageBean.currentPage}">
									<li class="paginItem current"><a
										href="<%=basePath%>message/manage/list?current=${pageItem}">${pageItem}</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="paginItem"><a
										href="<%=basePath%>message/manage/list?current=${pageItem}">${pageItem}</a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${pageBean.totalPages!=pageBean.currentPage}">
								<li class="paginItem"><a
									href="<%=basePath%>message/manage/list?current=${pageBean.totalPages}"><span
										class="pagenxt"></span> </a>
								</li>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>


				<div class="tip">
					<div class="tiptop">
						<span>提示信息</span><a></a>
					</div>

					<div class="tipinfo">
						<span><img src="images/ticon.png" /> </span>
						<div class="tipright">
							<p>
								是否确认要删除这<label id="removeRows"></label>条留言吗？
							</p>
							<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
						</div>
					</div>

					<div class="tipbtn">
						<input name="" type="button" class="sure" value="确定" />&nbsp; <input
							name="" type="button" class="cancel" value="取消" />
					</div>
				</div>
				<div class="nulltip">
					<div class="tiptop">
						<span>提示信息</span><a></a>
					</div>

					<div class="tipinfo">
						<span><img src="images/ticon.png" /> </span>
						<div class="tipright">
							<p>没有选中记录，请选中记录后操作！</p>
						</div>
					</div>

					<div class="tipbtn">
						<input name="" type="button" class="nulltipcancel" value="确定" />
					</div>
				</div>
				<div class="auditingtip" style="width: 500px;height: 380px">
					<div class="tiptop">
						<span>审核留言</span>
					</div>
					<form action="<%=basePath%>message/manage/reply" method="post">
						<div class="tipinfo">
							<div class="tipright">
								<div style="float: left;width: 400px;"><p class="messageInfoName"></p>
								<p class="messageInfoCommentContent"></p>
								<input type="hidden" class="messageInfoId" name="id"> 
								 <br></div>
								<div  style="float: left;width: 400px;"><cite><input style="cursor: pointer;" type="radio" name="statusNumber" checked="checked" value="1" id="statusAuditing1" />
									<label style="cursor: pointer;" for="statusAuditing1">审核通过</label> </cite> 
								<cite><input style="cursor: pointer;" type="radio" name="statusNumber" value="2" id="statusAuditing2" /><label style="cursor: pointer;"
									for="statusAuditing2">审核失败</label> </cite><br><br>
									</div>
								<div  style="float: left;width: 400px;"><textarea rows="3" cols="60" style="border: 1px solid silver ;resize:none" name="replyContent" class="messageInfoReplyContent"></textarea><br><br></div>
							</div>
						</div>

						<div class="tipbtn">
						
							<input name="" type="submit" class="auditingtipsure" value="确定" />
							<input name="" type="button" class="auditingtipcancel" value="取消" />
						</div>
					</form>
				</div>


			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</div>

	<script type="text/javascript">
		$(".tablelist tbody tr:odd").addClass("odd");
	</script>
</body>