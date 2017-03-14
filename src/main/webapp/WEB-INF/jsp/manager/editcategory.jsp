<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>修改出版社</title>	
  </head>  
  <body>
    	<form action="${pageContext.request.contextPath }/manager/category/update" method="post">
    		<input type="hidden" name="id" value="${category.id }" />
    		分类名称：<input type="text" name="name" value="${category.name }"><br>
    		分类描述：<textarea rows="5" cols="30" name="description">${category.description }</textarea><br>
    		<input type="submit" name="submit" value="修改" >
    	</form>
  </body>
</html>
