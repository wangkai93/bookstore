<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>列出所有用户</title>
<script type="text/javascript">
	function dodelete(id) {

		var b = window.confirm("您确定删除吗？");
		if (b) {
			window.location.href = "${pageContext.request.contextPath }/manager/user/delete/"
					+ id;
		}
	}
</script>

</head>
<body style="text-align: center;">

	<h1>用户信息</h1>
	<table frame="border" width="80%" align="center">
		<tr>
			<td>用户名</td>
			<td>昵称</td>
			<td>电话</td>
			<td>地址</td>
			<td>邮箱</td>
			<td>操作</td>
		</tr>
		<c:if test="${! empty page.list && null != page }">
			<c:forEach var="user" items="${page.list}">
				<tr>
					<td>${user.username }</td>
					<td>${user.nickname }</td>
					<td>${user.cellphone }</td>
					<td>${user.address }</td>
					<td>${user.email }</td>
					<td><a href="javascript:void(0)"
						onclick="dodelete('${user.id}')">删除</a> <a
						href="${pageContext.request.contextPath }/manager/account/edit/${user.id}">修改</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<br> 当前为第[${page.pagenum }]页&nbsp;&nbsp;
	<c:forEach var="pagenum" begin="${page.startPage}"
		end="${page.endPage}">
	   		[<a
			href="${pageContext.request.contextPath }/manager/account/list/?pagenum=${pagenum}">${pagenum }</a>]
	   </c:forEach>
	总共[${page.totalpage }]页&nbsp;&nbsp; 共[${page.totalrecord }]条记录

</body>
</html>
