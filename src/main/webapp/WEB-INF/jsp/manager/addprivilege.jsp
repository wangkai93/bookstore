<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'addprivilege.jsp' starting page</title>	
  </head>  
  <body>
   		<form action="${pageContext.request.contextPath }/manager/privilege/save" method = "post">
			权限名称：<input type="text" name ="name">   	<br/>
			<input type="submit" value="提交"/>	
   		</form>
  </body>
</html>
