<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>后台左侧导航</title>	
  </head> 
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/left.css">
  <script>
		function hiddendiv(div){
			div.style.display = (div.style.display =='none'?'block':'none');
		}
		
	</script>
		
	<body>
		<div class="container">
			<div class="styleimage1">
			
			</div>
				<div class="styleleft">
				
					<div class="styleleft1">
					
						<div class="styleimage2">
							<div > <a href="javascript:void(0)" onClick="hiddendiv(document.getElementById('d1'))">分类管理</a></div>
						</div>
						<div class="styletext" id="d1">
							<ul>
								<li><a href="${pageContext.request.contextPath }/manager/category/add" target="body">添加分类</a></li>
								<li><a href="${pageContext.request.contextPath }/manager/category/list" target="body">查看分类</a></li>
							</ul>
						</div>
					</div>
					
					
					<div class="styleleft1">
					
						<div class="styleimage2">
							<div > <a href="javascript:void(0)" onClick="hiddendiv(document.getElementById('d2'))">图书管理</a></div>
						</div>
						<div class="styletext" id="d2">
							<ul>
								<li><a href="${pageContext.request.contextPath }/manager/book/add" target="body">添加图书</a></li>
								<li><a href="${pageContext.request.contextPath }/manager/book/list" target="body">查看图书</a></li>
							</ul>
						</div>
					</div>
					
					
					<div class="styleleft1">
					
						<div class="styleimage2">
							<div > <a href="javascript:void(0)" onClick="hiddendiv(document.getElementById('d3'))">订单管理</a></div>
						</div>
						<div class="styletext" id="d3">
							<ul>
								<li><a href="${pageContext.request.contextPath }/manager/listorder/list?status=true" target="body">已发订单</a></li>
								<li><a href="${pageContext.request.contextPath }/manager/listorder/list?status=false" target="body">未发订单</a></li>
							</ul>
						</div>
					</div>
					
					<div class="styleleft1">
					
						<div class="styleimage2">
							<div > <a href="javascript:void(0)" onClick="hiddendiv(document.getElementById('d4'))">出版社管理</a></div>
						</div>
						<div class="styletext" id="d4">
							<ul>
								<li><a href="${pageContext.request.contextPath }/manager/publisher/add" target="body">添加出版社</a></li>
								<li><a href="${pageContext.request.contextPath }/manager/publisher/list" target="body">查看出版社</a></li>
							</ul>
						</div>
					</div>
					
					<div class="styleleft1">
					
						<div class="styleimage2">
							<div > <a href="javascript:void(0)" onClick="hiddendiv(document.getElementById('d5'))">用户管理</a></div>
						</div>
						<div class="styletext" id="d5">
							<ul>
								<li><a href="${pageContext.request.contextPath }/manager/account/add" target="body">添加用户</a></li>
								<li><a href="${pageContext.request.contextPath }/manager/account/list" target="body">查看用户</a></li>
							</ul>
						</div>
					</div>
						
						
					<%-- 	<div class="styleleft1">
					
						<div class="styleimage2">
							<div > <a href="javascript:void(0)" onClick="hiddendiv(document.getElementById('d4'))">权限管理</a></div>
						</div>
						<div class="styletext" id="d4">
							<ul>
								<li><a href="${pageContext.request.contextPath }/manager/privilege/add" target="body">添加权限</a></li>
								<li><a href="${pageContext.request.contextPath }/manager/privilege/grant" target="body">授予权限</a></li>
							</ul>
						</div>
					</div> --%>
				</div>
			
			</div>
		
	</body>
  
  
  
  
</html>
