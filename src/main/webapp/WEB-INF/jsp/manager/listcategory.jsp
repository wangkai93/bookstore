<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>列出所有分类</title>	
  </head>  
  <body style="text-align: center;">
  
 	<br/> <br/>
 	<h1>分类信息</h1>
    <table frame="border" width="60%" align="center">
    	<tr>
    		<td>分类名称</td>
    		<td>分类描述</td>
    		<td>操作</td>
    	</tr>
    	<div style="float: left; margin-left: 100px;">
    		<c:if test="${! empty categories }">
	    	<c:forEach var="c" items="${categories}">
	    		<tr>
		    		<td>${c.name }</td>
		    		<td>${c.description }</td>
		    		<td>
		    			<a href="${pageContext.request.contextPath }/manager/category/delete/${c.id}">删除</a>
		    			<a href="${pageContext.request.contextPath }/manager/category/edit/${c.id}">修改</a>
		    		</td>
		    		</tr>
	    	</c:forEach>
    		</c:if>
	    	</div>
    </table>
  </body>
</html>
