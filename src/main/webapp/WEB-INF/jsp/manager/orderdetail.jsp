<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>订单明细</title>	
  </head>  
  <body style="text-align: center;">
  		<h2>订单明细</h2>
  		<table frame="border" width="80%" align="center">
  			<tr>
  				<td>书名</td>
  				<td>数量</td>
  				<td>售价</td>
  				<td>应收货款</td>
  			</tr>
  			
  			<c:forEach var="orderitem" items="${order.orderitems}"> 
  				<tr>
	  				<td>${orderitem.book.name }</td>
	  				<td>${orderitem.quantity }</td>
	  				<td>${orderitem.book.price }</td>
	  				<td>${orderitem.price }</td>
  				</tr>
  			</c:forEach>
  				<tr>
  					<td colspan="2">订单总价</td>
  					<td colspan="2">${order.price }元</td>
  				</tr>
  		</table>
  		<br/><br/>
  		<h2>收货人详细信息</h2>
  		<table frame="border" width="80%" align="center">
  			<tr>
  				<td>用户</td>
  				<td>地址</td>
  				<td>手机</td>
  				<td>邮箱</td>
  				<td>昵称</td>
  			</tr>
  			<tr>
  				<td>${order.user.username }</td>  				
  				<td>${order.user.address }</td>
  				<td>${order.user.cellphone }</td>
  				<td>${order.user.email }</td>
  				<td>${order.user.nickname }</td>
  			</tr>
  		</table>
  		<c:if test="${param.status == false }">
		    <a href="${pageContext.request.contextPath }/manager/listorder/send/${order.id}">确认发货</a>
  		</c:if>
  </body>
</html>
