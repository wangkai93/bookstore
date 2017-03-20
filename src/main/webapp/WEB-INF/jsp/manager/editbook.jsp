<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
  <SCRIPT src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></SCRIPT>
    <title>修改图书</title>	
    <script type="text/javascript">
    /**
	选择图片
	*/
	function changeCover() {
	
		$("#coverFile").click();
	}
    </script>
  </head>  
  <body>
  
	<form action="${pageContext.request.contextPath }/manager/book/update" method="post" enctype="multipart/form-data"> 
		<input type="hidden" name = "id" value="${book.id }">  
		<input type="hidden" name = "sort" value="${book.sort }">  
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
   			<td><img name="cover" onclick="changeCover()" src="${pageContext.request.contextPath }/${book.image }">
   			<input id="image" name="image" type="hidden" value="${book.image }" />
   			<input style="display: none"
			id="coverFile" accept="image/png,image/gif" name="coverFile"
			type="file" />
   			
   			</td>
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
   			<td></td>
   			<td>
   				<input type="submit" value="更新">
   			</td>
   		</tr>
   	
   	</table>
   	</form>
  </body>
</html>
