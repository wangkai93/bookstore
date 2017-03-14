<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'addpublisher.jsp' starting page</title>	
  </head>  
  <body>
   		<form action="${pageContext.request.contextPath }/manager/publisher/save" method = "post">
			出版社名称：<input type="text" name ="publisherName">   	<br/>
			出版社描述：<textarea cols="50" rows="5" name ="description"></textarea>   	<br/>
			<input type="submit" value="提交"/>	
   		</form>
  </body>
</html>
