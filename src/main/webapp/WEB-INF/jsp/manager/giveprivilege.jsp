<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'giveprivilege.jsp' starting page</title>	
  </head>  
  <body>
   		<form action="${pageContext.request.contextPath }/manager/privilege/grant" method="post">
   			
   			<c:if test="${! empty privileges }">
   			<c:forEach var="privilege" items="${privileges}">
   				<input type="checkbox" name="privilege" value="${privilege.id }"/>${privilege.name }<br/>
   				</vr>
   			</c:forEach>
   			</c:if>
   			<input type="submit" value="授权"/>
   		</form>
  </body>
</html>
