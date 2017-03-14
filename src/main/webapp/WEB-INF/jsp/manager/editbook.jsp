<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>修改图书</title>	
  </head>  
  <body>
  
	<form action="${pageContext.request.contextPath }/manager/book/update" method="post" enctype="multipart/form-data"> 
		<input type="hidden" name = "id" value="${book.id }">  
   	<table frame="border" width="50%">
   		<tr>
   			<td>图书名称</td>
   			<td><input type="text" name="name" value="${book.name }"></td>
   		</tr>
   		<tr>
   			<td>作者</td>
   			<td><input type="text" name="author" value="${book.author}"></td>
   		</tr>
   		<tr>
   			<td>售价</td>
   			<td><input type="text" name="price" value="${book.price }"></td>
   		</tr>
   		<tr>
   			<td>图片</td>
   			<td><img name="image" src="${pageContext.request.contextPath }/${book.image }"></td>
   		</tr>
   		<tr>
   			<td>描述</td>
   			<td>
   				<textarea rows="5" cols="30" name="description">${book.description }</textarea>
   			</td>
   		</tr>
   		<tr>
   			<td>所属分类</td>
   			<td>
   				<select name="category_id">
   					<c:forEach var="c" items="${categories}">
   						<option value="${c.id }" ${book.category.id == c.id ? 'selected':'' }>${c.name }</option>
   					</c:forEach>
   				</select>
   			</td>
   		</tr>
   		
   		<tr>
				<td>出版社</td>
				<td><select name="publisher_id">
						<c:forEach var="p" items="${publishers}">
							<option value="${p.id }" ${book.publisher.id == p.id ? 'selected':'' } >${p.publisherName }</option>
						</c:forEach>
				</select></td>
			</tr>
   		<tr>
   			<td><input type="reset" value="重置"></td>
   			<td>
   				<input type="submit" value="添加">
   			</td>
   		</tr>
   	
   	</table>
   	</form>
  </body>
</html>
