<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css">
<title>收藏列表</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	function cancelCollect(bookId) {

		$.ajax({

			url : "${pageContext.request.contextPath}/client/collect/delete",
			type : "POST",
			data : {
				bookId : bookId
			},
			success : function(data) {
				// 刷新页面	
				window.location.reload();
			},
			error : function(e) {
				$("#collectMsg").html("取消收藏失败");
			}
		});

	}
</script>
</head>
<body style="text-align: center;">

	<h1>收藏信息</h1>
	<table frame="border" width="80%" align="center">
		<tr>
			<td>书籍名称</td>
			<td>作者</td>
			<td>售价</td>
			<td>图片</td>
			<td>描述</td>
			<td>操作</td>
		</tr>
		<c:if test="${! empty page.list && null != page }">
			<c:forEach var="book" items="${page.list}">
				<tr>
					<td>${book.name }</td>
					<td>${book.author }</td>
					<td>${book.price }</td>
					<td><a
						href="${pageContext.request.contextPath }/${book.image}">查看图片</a>
					</td>
					<td>${book.description }</td>
					<td><a href="#" onclick="cancelCollect('${book.id}')">取消收藏</a>
						<a
						href="${pageContext.request.contextPath }/client/buy/book/${book.id}">购买</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>


	<div id="page">
		<br>
		<ul class="pagination">
			<li class="disabled"><a href="#">&laquo;</a></li>

			<c:forEach var="pagenum" begin="${page.startPage}"
				end="${page.endPage}">
				<li><a
					href="${pageContext.request.contextPath }/client/collect/list?pagenum=${pagenum}">${pagenum	}</a>
				</li>
			</c:forEach>
			<li class="disabled"><a href="#">&raquo;</a></li>&nbsp;&nbsp;
			<li>总共[${page.totalpage }]页</li>&nbsp;&nbsp;
			<li>共[${page.totalrecord }]条记录</li>
		</ul>
	</div>
</body>