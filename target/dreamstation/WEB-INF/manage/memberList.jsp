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

<title>成员列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
	function pitchOn(obj) {
		var s = obj.id;
		var clickRowCheckBox = "memberInfoCheckBox+"
				+ s.substring(s.indexOf('+') + 1, s.length);
		if (document.getElementById(clickRowCheckBox).checked == true) {
			document.getElementById(clickRowCheckBox).checked = false;
		} else {
			document.getElementById(clickRowCheckBox).checked = true;
		}
		;
	}
	function pitchOnAll() {
		var checkBoxs = document.getElementsByName("memberInfoCheckBox");
		var obj = document.getElementsByName("selectIds");
		if (obj.checked == true) {
			obj.checked = false;
			for ( var i = 0; i < checkBoxs.length; i++) {
				checkBoxs[i].checked = false;
			}
			;
		} else {
			obj.checked = true;
			for ( var i = 0; i < checkBoxs.length; i++) {
				checkBoxs[i].checked = true;
			}
			;
		}
		;
	}
</script>

</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="<%=basePath%>member/manage/list?current=1">成员管理</a>
			</li>
		</ul>
	</div>
	<div class="rightinfo">


		<%-- <div
			style="border: 1px solid #EBEBEB ;padding: 10px;margin-bottom: 10px;height: 30px;width: 100%">
			<form action="<%=basePath%>member/manage/search" method="post">
				<div style="width: 60%;float: left;">
					年级&emsp;<select name="gradeNumber"
						style="width: 100px;border: 1px solid silver ;">
						<option value="-1" style="height: 25px;line-height: 25px;">不确定</option>
						<option value="1" style="height: 25px;line-height: 25px;">大一</option>
						<option value="2" style="height: 25px;line-height: 25px;">大二</option>
						<option value="3" style="height: 25px;line-height: 25px;">大三</option>
						<option value="4" style="height: 25px;line-height: 25px;">大四</option>
						<option value="5" style="height: 25px;line-height: 25px;">毕业</option>
						<option value="6" style="height: 25px;line-height: 25px;">老师</option>
						<option value="0" style="height: 25px;line-height: 25px;">其他</option>
					</select> &emsp;&emsp;类别&emsp;<select name="categoryNumber"
						style="width: 100px;border: 1px solid silver ;">
						<option value="-1" style="height: 25px;line-height: 25px;">不确定</option>
						<option value="1" style="height: 25px;line-height: 25px;">程序员</option>
						<option value="2" style="height: 25px;line-height: 25px;">设计师</option>
						<option value="3" style="height: 25px;line-height: 25px;">导师</option>
					</select> &emsp;&emsp;姓名&emsp;<input type="text" name="memberName"
						style="width: 180px;height: 28px;border: 1px solid silver ;">
				</div>
				<div style="width: 20%;float: left;margin-top: -6px;">
					<input type="submit" value="确认筛选" class="enter">
				</div>
			</form>
		</div> --%>
		<c:choose>
			<c:when test="${listMemberInfo!=null}">
				<div style="min-height: 600px;">

					<ul class="classlist">
						<c:forEach items="${listMemberInfo}" var="memberInfo">
							<li><span><img width="160px"
									src="<%=basePath%>${memberInfo.picture}" /> </span>
								<div class="lright">
									<h2>${memberInfo.name}</h2>
									<p>
										年级：${memberInfo.grade}<br />类别：${memberInfo.category}<br />电话：${memberInfo.phone}<br />Q
										Q：${memberInfo.qq}<br />权限：${memberInfo.userAuthority.allowLogin}<a
											href="<%=basePath%>member/manage/go-authoriting?id=${memberInfo.id}"
											class="tablelink"><img style="width: 14px;"
											src="<%=basePath%>images/t04.png" />权限设置</a>
									</p>
									<a class="enter"
										href="<%=basePath%>member/manage/look?id=${memberInfo.id}">查看详情</a>
								</div>
							</li>
						</c:forEach>
					</ul>
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
										href="<%=basePath%>member/manage/list?current=${pageItem}">${pageItem}</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="paginItem"><a
										href="<%=basePath%>member/manage/list?current=${pageItem}">${pageItem}</a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${pageBean.totalPages!=pageBean.currentPage}">
								<li class="paginItem"><a
									href="<%=basePath%>member/manage/list?current=${pageBean.totalPages}"><span
										class="pagenxt"></span> </a>
								</li>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
					</ul>
					<br/><br/>
				</div>


				<div class="tip">
					<div class="tiptop">
						<span>提示信息</span><a></a>
					</div>

					<div class="tipinfo">
						<span><img src="images/ticon.png" /> </span>
						<div class="tipright">
							<p>
								是否确认要删除这<label id="removeRows"></label>位成员吗？
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
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</div>

	<script type="text/javascript">
		$(".tablelist tbody tr:odd").addClass("odd");
	</script>
</body>