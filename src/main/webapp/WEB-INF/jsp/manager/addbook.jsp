<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加图书</title>
</head>
<body style="text-align: center;">
	<h1>添加图书</h1>
	<form action="${pageContext.request.contextPath }/manager/book/save"
		method="post" enctype="multipart/form-data">
		<font color="#ff0000">${bookError }</font>
		<table frame="border" width="50%" align="center">
			<tr>
				<td>图书名称</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>作者</td>
				<td><input type="text" name="author"></td>
			</tr>
			<tr>
				<td>售价</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>图片</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td>描述</td>
				<td><textarea rows="5" cols="30" name="description"></textarea>
				</td>
			</tr>
			<tr>
				<td>所属分类</td>
				<td><select name="category_id">
						<c:forEach var="c" items="${categories}">
							<option value="${c.id }">${c.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>出版社</td>
				<td><select name="publisher_id">
						<c:forEach var="p" items="${publishers}">
							<option value="${p.id }">${p.publisherName }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="reset" value="重置"></td>
				<td><input type="submit" value="添加"></td>
			</tr>

		</table>
	</form>
</body>
</html>
