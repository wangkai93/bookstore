<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>列出所有出版社</title>	
  </head>  
  <body style="text-align: center;">
  
 	<br/> <br/>
 	<h1>出版社信息</h1>
    <table frame="border" width="60%" align="center">
    	<tr>
    		<td>出版社名称</td>
    		<td>出版社描述</td>
    		<td>操作</td>
    	</tr>
    	<div style="float: left; margin-left: 100px;">
    		<c:if test="${! empty publishers }">
	    	<c:forEach var="p" items="${publishers}">
	    		<tr>
		    		<td>${p.publisherName }</td>
		    		<td>${p.description }</td>
		    		<td>
		    			<a href="${pageContext.request.contextPath }/manager/publisher/delete/${p.id}">删除</a>
		    			<a href="${pageContext.request.contextPath }/manager/publisher/edit/${p.id}">修改</a>
		    		</td>
		    		</tr>
	    	</c:forEach>
    		</c:if>
	    	</div>
    </table>
  </body>
</html>
