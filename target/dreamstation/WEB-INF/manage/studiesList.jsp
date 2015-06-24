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

<title>所有成员学习情况</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>


</head>

<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="<%=basePath%>studies/manage/list">学习管理</a></li>
		</ul>
	</div>
	<div class="rightinfo">

		<div>
			<c:choose>
				<c:when test="${listStudiesInfo!=null}">
					<div style="height: 400px;">
						<table class="tablelist">
							<thead>
								<tr>
									<th width="60px">编号<i class="sort"><img
											src="images/px.gif" /> </i></th>
									<th width="80px">发布人</th>
									<th>阶段学习主题</th>
									<th width="180px">阶段学习时间</th>
									<th width="140px">发布时间</th>
									<th width="120px">操作</th>
								</tr>
							</thead>
							<tbody>
								<%
									com.ds.dreamstation.dto.Pages pageInfo = (com.ds.dreamstation.dto.Pages) request
													.getAttribute("pageBean");
											int i = 1 + pageInfo.getPageSize()
													* (pageInfo.getCurrentPage() - 1);
								%>
								<c:forEach items="${listStudiesInfo}" var="studiesInfo">
									<tr>
										<td><%=i++%></td>
										<td><a title="查看成员${studiesInfo.memberName}的历史学习情况"
											href="<%=basePath%>studies/manage/list-member?id=${studiesInfo.memberId}"
											class="tablelink">${studiesInfo.memberName}</a>
										</td>
										<td>${studiesInfo.periodTheme}</td>
										<td>${studiesInfo.periodTime}</td>
										<td>${studiesInfo.publishTime}</td>
										<td><a
											href="<%=basePath%>studies/manage/look?id=${studiesInfo.id}"
											class="tablelink"><img style="width: 14px;"
												src="images/ico06.png" />查看</a> <c:if
												test="${memberSession.manageMember==true}">
												<a
													href="<%=basePath%>studies/manage/remove?id=${studiesInfo.id}"
													class="tablelink"><img style="width: 14px;"
													src="images/t03.png" />删除</a>
											</c:if></td>
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
											href="<%=basePath%>studies/manage/list?current=${pageItem}">${pageItem}</a>
										</li>
									</c:when>
									<c:otherwise>
										<li class="paginItem"><a
											href="<%=basePath%>studies/manage/list?current=${pageItem}">${pageItem}</a>
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when test="${pageBean.totalPages!=pageBean.currentPage}">
									<li class="paginItem"><a
										href="<%=basePath%>studies/manage/list?current=${pageBean.totalPages}"><span
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
									是否确认要删除这<label id="removeRows"></label>条项目吗？
								</p>
								<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
							</div>
						</div>

						<div class="tipbtn">
							<input name="" type="button" class="sure" value="确定" />&nbsp; <input
								name="" type="button" class="cancel" value="取消" />
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
	</div>
</body>