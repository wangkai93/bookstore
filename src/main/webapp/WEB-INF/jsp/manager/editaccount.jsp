<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>修改信息界面</title>
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
	<body style="text-align: center;">
	<h2>编辑用户</h2>
	<div id="main">
		<form	action="${pageContext.request.contextPath }/manager/account/update"
			method="post">
			<table id="formtable">
			<input type="hidden" name="id" value="${user.id }">
				<tr>
					<td class="td1">用户名</td>
					<td>
						<input class="userinput" type="text" readonly="readonly" name="username" value=${user.username }>
						<span class="message">${form.errors.username }</span>
					</td>
				</tr>

				<tr>
					<td class="td1">密码</td>
					<td><input class="userinput" type="password" name="password" value=${user.password }>
					<span class="message">${form.errors.password }</span>
					</td>
				</tr>

				<tr>
					<td class="td1">确认密码	</td>
					<td><input class="userinput" type="password" name="password2" }>
					<span class="message">${form.errors.password2 }</span>
					</td>
				</tr>
				
				<tr>
					<td class="td1">生日</td>
					<td><input class="userinput" type="text" name="birthday" id="birthday" title="点击选择" onclick="showCalendar(this.id)" value=${user.birthday }>
					<span class="message">${form.errors.birthday }</span>
					</td>
				</tr>

				<tr>
					<td class="td1">联系电话	</td>
					<td><input class="userinput" type="text" name="cellphone" value=${user.cellphone }>
					<span class="message">${form.errors.cellphone }</span>
					</td>
				</tr>
				
				<tr>
					<td class="td1">地址	</td>
					<td><input class="userinput" type="text" name="address" value=${user.address }>
					<span class="message">${form.errors.address }</span>
					</td>
				</tr>
				<tr>
					<td class="td1">邮箱	</td>
					<td><input class="userinput" type="text" name="email" value=${user.email }>
					<span class="message">${form.errors.email }</span>
					</td>
				</tr>
				
				<tr>
					<td class="td1">昵称</td>
					<td><input class="userinput" type="text" name="nickname" value=${user.nickname }>
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
					&nbsp;&nbsp;
						<span><input class="btn" type="submit" name="submit" value="更新"></span>
					</td>
				</div>	
		</form>
		</div>
					<script type="text/javascript" src="${pageContext.request.contextPath }/js/ShowCalendar.js"></script>
					<script type="text/javascript" src="${pageContext.request.contextPath }/js/WebCalendar.js"></script>
	</body>
</html>
