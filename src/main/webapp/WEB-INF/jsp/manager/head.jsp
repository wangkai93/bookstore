<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>后台页头</title>
<script>
	src = "${pageContext.request.contextPath }/js/jquery-3.1.1.min.js" >
</script>
<script type="text/javascript">
	function logout() {
		var b = window.confirm("你确定退出吗？");
		if (b)
			window.parent.location = "${pageContext.request.contextPath}/backend/logout";
	}
</script>
</head>
<style>
body {
	margin: 0;
	padding: 0;
}

.head {
	float: left;
}

.logout {
	margin-top: 40px;
	margin-left: 300px;
}
</style>
<body background="${pageContext.request.contextPath }/imgs/header.png">
	<div class="logout">
		<img alt="退出" title="退出"
			src="${pageContext.request.contextPath }/imgs/logout.gif"
			onclick="logout()">
	</div>
</body>
</html>
