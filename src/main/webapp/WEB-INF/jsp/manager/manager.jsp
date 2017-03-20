<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>后台首页</title>
	</head>

	<frameset rows="98,*,8">
			<frame src="${pageContext.request.contextPath}/manager/menu/top" id="top" frameBorder=0 noResize name="head">
			
		<frameset cols="20%,*">
			<frame src="${pageContext.request.contextPath}/manager/menu/left" frameBorder=0 noResize name="left">
			<frame src="${pageContext.request.contextPath}/manager/menu/main/" frameBorder=0 noResize  name="body">
		</frameset>
	</frameset>
</html>


