<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>添加分类</title>	
  </head>  
  <body style="text-align: center;">
   <h1>添加分类</h1>
    	<form action="${pageContext.request.contextPath }/manager/category/save"  method="post">
    		分类名称：<input type="text" name="name"><br>
    		分类描述：<textarea rows="5" cols="30" name="description"></textarea><br>
    		<input type="submit" name="submit" value="提交" >
    	</form>
  </body>
</html>
