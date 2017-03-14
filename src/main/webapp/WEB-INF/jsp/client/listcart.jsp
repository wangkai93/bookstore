<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>购物车显示列表</title>	
    <script type="text/javascript">
    
    	function dodelete(id){
    	
    		var b = window.confirm("您确定删除吗？");
    		if(b){
    		window.location.href="${pageContext.request.contextPath }/client/buy/delete/"+ id;
    		}
    	}
    	function clearcart(){
    	
    		var b = window.confirm("您确定要请空吗？");
    		if(b){
    			window.location.href="${pageContext.request.contextPath}/client/buy/clear";
    		}
    	}
    </script>
  </head>  
 
  <body style="text-align: center;">
  
    <c:if test="${empty(cart.map)}">
  	您没有购买任何商品！！！
  </c:if>
  <c:if test="${!empty(cart.map)}">
  		<br>
  			<h2>购物列表</h2>
    	<table width="80%" frame="border">
    		<tr>
    			<td>书名</td>
    			<td>作者</td>
    			<td>单价</td>
    			<td>数量</td>
    			<td>小记</td>
    			<td>操作</td>
    		</tr>
    		
    		<c:forEach var="me" items="${cart.map}">
    			
    			<tr>
    			<td>${me.value.book.name }</td>
    			<td>${me.value.book.author }</td>
    			<td>${me.value.book.price }</td>
    			<td>${me.value.quantity }</td>
    			<td>${me.value.price }</td>
    			<td>
    				<a href ="javascript:void(0)" onclick="dodelete('${me.value.book.id}')">删除</a>
    			</td>
    		</tr>
    		</c:forEach>
    		
    		<tr>
  				<td colspan="3">总价</td>
  				<td colspan="2">${cart.price }元</td>
  				<td colspan="1">
  				<a href="javascript:void(0)" onclick="clearcart()">清空购物车</a>
  				<a href="${pageContext.request.contextPath }/client/order/confirm">下订单</a>
  				</td>  				
  				</tr> 	
    	</table>
    	</c:if>
  </body>
</html>
