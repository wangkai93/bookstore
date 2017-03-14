<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>首页头</title>
		<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css">
	</head>

	<body style="text-align: center">
		<!--导航条  -->

		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath }/client/index/getAll" target="body">图书网</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active">
					<a href="${pageContext.request.contextPath }/client/index/getAll" target="body">首页</a>
				</li>
				<li>
					<a
						href="${pageContext.request.contextPath }/client/buy/listcart"
						target="body">购物车</a>
				</li>
				<li>
					<a
						href="${pageContext.request.contextPath }/client/order/list"
						target="body">订单</a>
				</li>
			</ul>
			<c:if test="${user==null}">
				<form
					action="${pageContext.request.contextPath}/client/login/login "
					method="post" class="navbar-form navbar-right" role="form">
					<div class="form-group">
						<input placeholder="用户名" name="username" class="form-control"
							type="text">
					</div>
					<div class="form-group">
						<input placeholder="密码" name="password" class="form-control"
							type="password">
					</div>
					<div class="btn-group">
						<button type="submit" class="btn btn-success">
							登陆
						</button>
						<button type="button" class="btn btn-success"
							onclick="javascript:window.parent.location.href='${pageContext.request.contextPath}/client/user/register'"  >
							注册
						</button>
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
						<li>
							<a href="${pageContext.request.contextPath }/client/user/edit/${user.id}" target="parent"><span class="glyphicon glyphicon-info-sign"></span>&nbsp;&nbsp;修改信息</a>
						</li>
						
						<li>
							<a href="#"><span class="glyphicon glyphicon-envelope"></span>&nbsp;&nbsp;消息中心</a>
						</li>
						<li class="divider"></li>
						<li>
							<a
								href="${pageContext.request.contextPath }/client/login/logout"><span
								class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;退出登陆</a>
						</li>
					</ul>
				</div>

			</c:if>
		</div>
		<!-- /.navbar-collapse -->
		</nav>
		
		    <script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
    
	</body>
</html>
