<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>订单显示</title>	
  </head>  
  <body style="text-align: center;">
  		<br>
  			<h2>订单列表</h2>
    	<table width="80%" frame="border" align="center">
    		<tr>
    			<td>订单号</td>
    			<td>订单人</td>
    			<td>订单时间</td>
    			<td>订单总价</td>
    			<td>订单状态</td>
    			<td>操作</td>
    		</tr>
    		<c:if test="${! empty page.list && null != page }">
   			<c:forEach var="order" items="${page.list}">
    			<tr>
    			<td>${order.id }</td>
    			<td>${order.user.nickname }</td>
    			<td>${order.ordertime }</td>
    			<td>${order.price }</td>
    			<td>${order.state==true?'已发货':'未发货' }</td>
    			<td>
    				<a href="${pageContext.request.contextPath }/manager/listorder/detail/${order.id}?status=${param.status }">查看明细</a>
    				<a href="${pageContext.request.contextPath }/manager/listorder/delete/${order.id}?status=${param.status }">删除</a>
    			</td>
    		</tr>
    		</c:forEach>
    		</c:if>
    	</table>
    	
    	 <br>
  	 当前为第[${page.pagenum }]页&nbsp;&nbsp;
	   <c:forEach var="pagenum" begin="${page.startPage}" end="${page.endPage}">
	   		[<a href="${pageContext.request.contextPath }/manager/listorder/list/?status=${param.status }&pagenum=${pagenum}">${pagenum }</a>]
	   </c:forEach>
		总共[${page.totalpage }]页&nbsp;&nbsp;  共[${page.totalrecord }]条记录
	
  </body>
  </body>
</html>
