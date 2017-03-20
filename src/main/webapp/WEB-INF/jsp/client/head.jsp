<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>首页头</title>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	/**
		搜索图书js
	 */
	function searchBook() {

		var bookName = $("#searchBook").val();
		if ($.trim(bookName) == "") {
			return;
		}
		$("#iframe", window.parent.document).attr(
				"src",
				"${pageContext.request.contextPath}/client/index/findBook?bookName="
						+ bookName)
	}

	/**
		登出js
	 */
	function doLogout() {

		console.log("logout");
		$
				.ajax({
					url : "${pageContext.request.contextPath }/client/login/logout",
					type : "post",
					success : function(data) {
						// 刷新body页面和head页面
						window.location.reload();//刷新当前页面.
						$("#iframe", window.parent.document)
								.attr("src",
										"${pageContext.request.contextPath}/client/index/getAll")
					},
					error : function(e) {
						console.log(e);
					}
				});
	}

	/**
		登陆js
	 */
	function doLogin() {

		var username = $("#username").val();
		var password = $("#password").val();

		if (username == "" || password == "") {
			$("#loginPmt").html("用户名密码不能为空");
			return;
		}

		$
				.ajax({
					url : "${pageContext.request.contextPath}/client/login/login",
					type : "post",
					data : {
						username : username,
						password : password
					},
					success : function(data) {
						console.log(data);
						if (data.code == 10002) {
							$("#loginPmt").html("用户名密码不能为空");
						}
						if (data.code == 10003) {
							// 刷新body页面和head页面
							window.location.reload();//刷新当前页面.
							$("#iframe", window.parent.document)
									.attr("src",
											"${pageContext.request.contextPath}/client/index/getAll")
						}
					},
					error : function(e) {
						console.log(e);
					}
				});
	}
</script>
</head>

<body style="text-align: center">
	<!--导航条  -->

	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand"
			href="${pageContext.request.contextPath }/client/index/getAll"
			target="body">望记书店</a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li class="active"><a
				href="${pageContext.request.contextPath }/client/index/getAll"
				target="body">首页</a></li>
			<li><a
				href="${pageContext.request.contextPath }/client/buy/listcart"
				target="body">购物车</a></li>
			<li><a
				href="${pageContext.request.contextPath }/client/order/list"
				target="body">订单</a></li>
		</ul>
		<div class="col-lg-6" style="width: 400px;">
			<div class="input-group">
				<input id="searchBook" type="text" class="form-control"
					placeholder="搜索书籍"> <span class="input-group-btn"> <a
					class="btn btn-default" target="body" onclick="searchBook()">搜索</a>
				</span>
			</div>
			<!-- /input-group -->
		</div>
		<!-- /.col-lg-6 -->
		<c:if test="${user==null}">
			<form action="" method="post" class="navbar-form navbar-right"
				role="form">
				<span id="loginPmt" style="color: red;"></span>
				<div class="form-group">
					<input placeholder="用户名" name="username" id="username"
						class="form-control" type="text">
				</div>
				<div class="form-group">
					<input placeholder="密码" name="password" id="password"
						class="form-control" type="password">
				</div>
				<div class="btn-group">
					<button type="button" class="btn btn-success" onclick="doLogin()">
						登陆</button>
					<button type="button" class="btn btn-success"
						onclick="javascript:window.parent.location.href='${pageContext.request.contextPath}/client/user/register'">
						注册</button>
				</div>
			</form>
		</c:if>
		<c:if test="${user!=null}">

			<div class="btn-group navbar-right navbar-btn">
				<button type="button" class="btn btn-default dropdown-toggle"
					data-toggle="dropdown">
					<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;${user.nickname
						}&nbsp;
					<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a
						href="${pageContext.request.contextPath }/client/user/edit/${user.id}"
						target="parent"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;&nbsp;修改信息</a>
					</li>

					<li><a
						href="${pageContext.request.contextPath }/client/collect/list"
						target="body"><span class="glyphicon glyphicon-envelope"></span>&nbsp;&nbsp;收藏夹</a>
					</li>
					<li class="divider"></li>
					<li><a href="javascript:doLogout()"><span
							class="glyphicon glyphicon-off" ></span>&nbsp;&nbsp;退出登陆</a>
					</li>
				</ul>
			</div>

		</c:if>
	</div>
	<!-- /.navbar-collapse --> </nav>

	<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>

</body>
</html>
