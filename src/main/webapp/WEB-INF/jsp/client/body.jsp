<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'body.jsp' starting page</title>
			<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css">
	</head>

	<body style="text-align: center;">

		<div id="content" style="width: 880px;  float: left; margin-left:200px;">
			<div id="category"
				style="width: 200px; height: 350px; border: 1px solid red; float: left; text-align: left; margin-left: 150px;">
				书籍分类列表：
				<ul>
					<c:forEach var="category" items="${categorys}">
						<li>
							<a
								href="${pageContext.request.contextPath }/client/index/category?categoryId=${category.id}">${category.name}</a>
						</li>
					</c:forEach>
				</ul>
			</div>

			<div id="bookandpage" style="float: left; margin-left: 50px">

				<div id="books">
					<c:forEach var="book" items="${page.list}">
						<div id="book">
							<div id="image" style="float: left">
								<img
									src="${pageContext.request.contextPath }/images/${book.image}">
							</div>

							<div id="bookinfo" style="text-align: left; float: left;">
								<ul>
									<li>
										${book.name }
									</li>
									<li>
										${book.author }
									</li>
									<li>
										${book.price }
									</li>
									<li>
										<a
											href="${pageContext.request.contextPath }/client/buy/book/${book.id}">购买</a>
									</li>
								</ul>
							</div>
							<div id="clear" style="clear: both"></div>
							<br />
						</div>
					</c:forEach>

				</div>
				<!-- 做div浮动后，为了不影响后续页面的显示，一定要记住使用下面的语句清除浮动效果 -->
				<div id="clear" style="clear: both"></div>
				<div id="page">
					<br>
					<ul class="pagination">
						<li class="disabled">
							<a href="#">&laquo;</a>
						</li>

						<c:forEach var="pagenum" begin="${page.startPage}"
							end="${page.endPage}">
							<li>
								<a
									href="${pageContext.request.contextPath }/client/index/getAll?pagenum=${pagenum}&categoryId=${param.categoryId}">${pagenum	}</a>
							</li>
						</c:forEach>
						<li class="disabled">
							<a href="#">&raquo;</a>
						</li>&nbsp;&nbsp;
					<li>	总共[${page.totalpage }]页</li>&nbsp;&nbsp; <li>共[${page.totalrecord }]条记录</li>
					</ul>
				</div>
			</div>
		</div>
	</body>
</html>


