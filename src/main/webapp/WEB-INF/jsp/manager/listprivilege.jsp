<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>订单显示</title>	
  </head>  
  <body style="text-align: center;">
  		<br>
  			<h2>权限列表</h2>
    	<table width="80%" frame="border" align="center">
    		<tr>
    			<td>权限名称</td>
    			<td>权限模块</td>
    			<td>权限描述</td>
    			<td>操作</td>
    		</tr>
    		<c:if test="${! empty page.list && null != page }">
   			<c:forEach var="pri" items="${page.list}">
    			<tr>
    			<td>${pri.name }</td>
    			<td></td>
    			<td></td>
    			<td>
    				<a href="${pageContext.request.contextPath }/manager/privilege/edit/${pri.id}">修改</a>
    				<a href="${pageContext.request.contextPath }/manager/privilege/delete/${order.id}">删除</a>
    			</td>
    		</tr>
    		</c:forEach>
    		</c:if>
    	</table>
    	
    	 <br>
  	 当前为第[${page.pagenum }]页&nbsp;&nbsp;
	   <c:forEach var="pagenum" begin="${page.startPage}" end="${page.endPage}">
	   		[<a href="${pageContext.request.contextPath }/manager/privilege/list/?pagenum=${pagenum}">${pagenum }</a>]
	   </c:forEach>
		总共[${page.totalpage }]页&nbsp;&nbsp;  共[${page.totalrecord }]条记录
	
  </body>
  </body>
</html>
