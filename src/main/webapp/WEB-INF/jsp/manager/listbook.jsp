<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>列出所有书</title>	
    <script type="text/javascript">
    	
    	function dodelete(id){
    	
    		var b = window.confirm("您确定删除吗？");
    		if(b){
    		window.location.href="${pageContext.request.contextPath }/manager/book/delete/" + id;
    		}
    	}
    
    </script>
    
  </head>  
  <body style="text-align: center;">
   
   <h1>图书信息</h1>
   <table frame="border" width="80%" align="center">
   		<tr>
   			<td>书籍名称</td>
   			<td>作者</td>
   			<td>售价</td>
   			<td>图片</td>
   			<td>描述</td>
   			<td>操作</td>
   		</tr>
   		<c:if test="${! empty page.list && null != page }">
   		<c:forEach var="book" items="${page.list}">
   		<tr>
   			<td>${book.name }</td>
   			<td>${book.author }</td>
   			<td>${book.price }</td>
   			<td>
   				<a href="${pageContext.request.contextPath }/${book.image}">查看图片</a>
   			</td>
   			<td>${book.description }</td>
   			<td>
   				<a href="javascript:void(0)" onclick="dodelete('${book.id}')">删除</a>
   				<a href="${pageContext.request.contextPath }/manager/book/edit/${book.id}">修改</a>
   			</td>
   		</tr>
   		</c:forEach>
   		</c:if>
   </table>
   <br>
  	 当前为第[${page.pagenum }]页&nbsp;&nbsp;
	   <c:forEach var="pagenum" begin="${page.startPage}" end="${page.endPage}">
	   		[<a href="${pageContext.request.contextPath }/manager/book/list/?pagenum=${pagenum}">${pagenum }</a>]
	   </c:forEach>
		总共[${page.totalpage }]页&nbsp;&nbsp;  共[${page.totalrecord }]条记录
	
  </body>
</html>
