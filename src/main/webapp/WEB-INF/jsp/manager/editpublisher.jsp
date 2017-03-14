<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改分类</title>
</head>
<body>
	
	<form action="${pageContext.request.contextPath }/manager/publisher/update" method = "post">
	<input type="hidden" name="id" value="${publisher.id }" /> 
			出版社名称：<input type="text" name ="publisherName" value="${publisher.publisherName }">   	<br/>
			出版社描述：<textarea cols="50" rows="5" name ="description">${publisher.description }</textarea>   	<br/>
			<input type="submit" value="修改"/>	
   	</form>

</body>
</html>
