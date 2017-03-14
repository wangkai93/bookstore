<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>购物列表</title>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css">
<script type="text/javascript">
	function dodelete(id) {

		var b = window.confirm("您确定删除吗？");
		if (b) {
			window.location.href = "${pageContext.request.contextPath }/client/order/delete/"+ id;
		}
	}
</script>
</head>
<body style="text-align: center;">
	<br>
	<h2>订单列表</h2>
	<table width="80%" frame="border">
		<tr>
			<td>订单号</td>
			<td>订单人</td>
			<td>订单时间</td>
			<td>订单总价</td>
			<td>订单状态</td>
			<td>操作</td>
		</tr>

		<c:forEach var="order" items="${page.list}">

			<tr>
				<td>${order.id }</td>
				<td>${order.user.nickname }</td>
				<td>${order.ordertime }</td>
				<td>${order.price }</td>
				<td>${order.state==true?'已发货':'未发货' }</td>
				<td><a
					href="${pageContext.request.contextPath }/client/order/detail/${order.id}">查看明细</a>
					<a href="javascript:void(0)" onclick="dodelete('${order.id}')">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div id="page">
		<br>
		<ul class="pagination">
			<li class="disabled"><a href="#">&laquo;</a></li>

			<c:forEach var="pagenum" begin="${page.startPage}"
				end="${page.endPage}">
				<li><a
					href="${pageContext.request.contextPath }/client/order/list?pagenum=${pagenum}">${pagenum	}</a>
				</li>
			</c:forEach>
			<li class="disabled"><a href="#">&raquo;</a></li>&nbsp;&nbsp;
			<li>总共[${page.totalpage }]页</li>&nbsp;&nbsp;
			<li>共[${page.totalrecord }]条记录</li>
		</ul>
	</div>
</body>
</html>
