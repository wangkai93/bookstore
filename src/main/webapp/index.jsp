<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>网站首页 </title>
  </head>
  
  <frameset rows="98,*">
  		<frame src="${pageContext.request.contextPath}/client/index/head"  name="head">
  		<frame src="${pageContext.request.contextPath}/client/index/getAll" name="body">
  </frameset>
</html>

