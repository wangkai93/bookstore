<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户注册</title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/WebCalendar.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/ShowCalendar.js"></script>
		<script type="text/javascript">
			function ImageChange(img){
					img.src = img.src + "?" + new Date().getTime();
				}
		</script>
		<style>
body {
	background-color:#32a8cf;
	margin: 0px;
	overflow: hidden;
	font-size: 14px;
	color: #ffffff;
}

#main {
	margin-left: 50px;
	margin-top: 30px;
}
#notice {
	width: 70%;
	line-height: 25px;
}

#formatable {
	font-size: 15px
}

.td1 {
	width: 100px;
}

#formsubmit {
	width: 300px;
	text-align: center;
	margin-top: 15px;
	margin-left: 50px;
}

.userinput {
	width: 210px;
	height: 25px;
	background-color: #ffffff;
	border: solid 1px #7dbad7
}

.btn {
	background-image: url(../imgs/dl.gif);
	background-position: center;
	font: bold 12px;
	width: 80px;
	cursor: hand;
	height: 25px;
	border-width: 0;
	color:red;
}
</style>
	</head>
	<body style="text-align: left;">
	<h2>添加用户</h2>
	<div id="main">
		<form	action="${pageContext.request.contextPath }/manager/account/save"
			method="post">
			<table id="formtable">
				<tr>
					<td class="td1">用户名</td>
					<td>
						<input class="userinput" type="text" name="username" value=${form.username }>
						<span class="message">${form.errors.username }</span>
					</td>
				</tr>

				<tr>
					<td class="td1">密码</td>
					<td><input class="userinput" type="password" name="password" value=${form.password }>
					<span class="message">${form.errors.password }</span>
					</td>
				</tr>

				<tr>
					<td class="td1">确认密码	</td>
					<td><input class="userinput" type="password" name="password2" value=${form.password2 }>
					<span class="message">${form.errors.password2 }</span>
					</td>
				</tr>
				
				<tr>
					<td class="td1">生日</td>																		 
					<td><input class="userinput" type="text" name="birthday" id="birthday" title="点击选择" onclick="showCalendar(this.id)" value=${form.birthday }>
					<span class="message">${form.errors.birthday }</span>
					</td>
				</tr>
		

				<tr>
					<td class="td1">联系电话	</td>
					<td><input class="userinput" type="text" name="cellphone" value=${form.cellphone }>
					<span class="message">${form.errors.cellphone }</span>
					</td>
				</tr>
				
				<tr>
					<td class="td1">地址	</td>
					<td><input class="userinput" type="text" name="address" value=${form.address }>
					<span class="message">${form.errors.address }</span>
					</td>
				</tr>
				<tr>
					<td class="td1">邮箱	</td>
					<td><input class="userinput" type="text" name="email" value=${form.email }>
					<span class="message">${form.errors.email }</span>
					</td>
				</tr>
				
				<tr>
					<td class="td1">昵称</td>
					<td><input class="userinput" type="text" name="nickname" value=${form.nickname }>
					<span class="message">${form.errors.nickname }</span>
					</td>
				</tr>
				<tr>
					<td class="td1">验证码</td>
					<td><input class="userinput" type="text" name="checkcode" }>
					<IMG id="checkNumImage" src="${pageContext.request.contextPath }/image.jsp" border=0 height="19" withd="80px" align="absmiddle" onClick="ImageChange(this)" 
			  	           title="点击换一张" style="cursor:hand">
					<span class="message">${form.errors.checkcode }</span>
					</td>
				</tr>
				
				</table>
					<div id="formsubmit">
						<span><input class="btn" type="reset" name="reset" value="清空"></span>
					&nbsp;&nbsp;
						<span><input class="btn" type="submit" name="submit" value="注册"></span>
					</td>
				</div>	
		</form>
		</div>
	</body>
</html>



