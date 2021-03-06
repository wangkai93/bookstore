<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'body.jsp' starting page</title>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	/**
		加入购物车js
	 */
	function addCart(bookId) {

		if ("" == bookId) {
			return;
		}

		$.ajax({
			url : "${pageContext.request.contextPath}/client/buy/addCart/"
					+ bookId,
			type : "POST",
			data : {
				bookId : bookId
			},
			success : function(data) {

				if (null != data) {

					if (data.code == 20001) {

						$("#collectMsg").html("添加成功");

					} else {
						$("#collectMsg").html("添加失败");
					}
				}
			},
			error : function(e) {
				$("#collectMsg").html("添加失败");
			}
		});

	}

	/**
		收藏和取消收藏js
	 */
	function collect(bookId) {

		var result = $("#" + bookId + "").text();
		console.log(result);
		var url;
		if (result == "收藏")
			url = "${pageContext.request.contextPath}/client/collect/save";
		else
			url = "${pageContext.request.contextPath}/client/collect/delete";

		$.ajax({

			url : url,
			type : "POST",
			data : {
				bookId : bookId
			},
			success : function(data) {

				if (null != data) {

					if (data.code == 10005) {

						$("#collectMsg").html("请先登录");

					} else {
						if (result == "收藏")
							$("#" + bookId + "").text("取消收藏");
						else
							$("#" + bookId + "").text("收藏");
					}
				}
			},
			error : function(e) {
				$("#collectMsg").html("收藏失败");
			}
		});
	}
</script>
</head>

<body style="text-align: center;">

	<div id="content"
		style="width: 880px; float: left; margin-left: 200px;">
		<div id="category"
			style="width: 200px; height: 350px; border: 1px solid red; float: left; text-align: left; margin-left: 150px;">
			书籍分类列表：
			<ul>
				<c:forEach var="category" items="${categorys}">
					<li><a
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
							<img src="${pageContext.request.contextPath }/${book.image}">
						</div>

						<div id="bookinfo" style="text-align: left; float: left;">
							<ul>
								<li>${book.name }</li>
								<li>${book.author }</li>
								<li>${book.price }</li>
								<li><a
									href="${pageContext.request.contextPath }/client/buy/book/${book.id}">购买</a>&nbsp;
									<img alt="加入购物车" title="加入购物车"
									src="${pageContext.request.contextPath }/imgs/cart.png"
									onclick="addCart('${book.id}')">&nbsp; <c:if
										test="${! empty collects }">
										<c:forEach items="${ collects }" var="collect">

											<c:if test="${collect.id.bookId == book.id }">
												<c:set scope="page" value="1" var="xx"></c:set>
											</c:if>

										</c:forEach>
									</c:if> <a id="${book.id}" href="#" onclick="collect('${book.id}')">${xx == 1 ? '取消收藏':'收藏' }</a>&nbsp;&nbsp;<span
									id="collectMsg" style="color: red;"></span> <c:remove var="xx"
										scope="page" /></li>
								<c:if test="${book.isNew == true }">
									<li><img alt="新书上架"
										src="${pageContext.request.contextPath }/imgs/new_3.gif"></li>
								</c:if>
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
					<li class="disabled"><a href="#">&laquo;</a></li>

					<c:forEach var="pagenum" begin="${page.startPage}"
						end="${page.endPage}">
						<li><a
							href="${pageContext.request.contextPath }/client/index/getAll?pagenum=${pagenum}&categoryId=${param.categoryId}">${pagenum	}</a>
						</li>
					</c:forEach>
					<li class="disabled"><a href="#">&raquo;</a></li>&nbsp;&nbsp;
					<li>总共[${page.totalpage }]页</li>&nbsp;&nbsp;
					<li>共[${page.totalrecord }]条记录</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>


