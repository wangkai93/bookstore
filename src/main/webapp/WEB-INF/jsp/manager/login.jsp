<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<HEAD id=Head1>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<script type="text/javascript">
/**
 * 改变验证码
 */
function changeCheckNum() {
	var checkNumImage_ = document.getElementById("checkNumImage");
	checkNumImage_.src = "${pageContext.request.contextPath}/image.jsp?timeStamp="
			+ new Date().getTime();
}</script>
<STYLE type=text/css>
BODY {
	FONT-SIZE: 12px;
	COLOR: #ffffff;
	FONT-FAMILY: 宋体
}

TD {
	FONT-SIZE: 12px;
	COLOR: #ffffff;
	FONT-FAMILY: 宋体
}
</STYLE>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/backend"
		method=post>
		<DIV id=UpdatePanel1>
			<DIV id=div1
				style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
			<DIV id=div2
				style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
			<SCRIPT language=JavaScript>
				var speed = 20;
				var temp = new Array();
				var clipright = document.body.clientWidth / 2, clipleft = 0
				for (i = 1; i <= 2; i++) {
					temp[i] = eval("document.all.div" + i + ".style");
					temp[i].width = document.body.clientWidth / 2;
					temp[i].height = document.body.clientHeight;
					temp[i].left = (i - 1) * parseInt(temp[i].width);
				}
				function openit() {
					clipright -= speed;
					temp[1].clip = "rect(0 " + clipright + " auto 0)";
					clipleft += speed;
					temp[2].clip = "rect(0 auto auto " + clipleft + ")";
					if (clipright <= 0)
						clearInterval(tim);
				}
				tim = setInterval("openit()", 100);
			</SCRIPT>

			<DIV>&nbsp;&nbsp;</DIV>
			<DIV>
				<TABLE cellSpacing=0 cellPadding=0 width=900 align=center border=0>
					<TBODY>
						<TR>
							<TD style="HEIGHT: 105px"><IMG src="${pageContext.request.contextPath}/imgs/login_1.png"
								border=0></TD>
						</TR>
						<TR>
							<TD background=${pageContext.request.contextPath}/imgs/login_2.jpg height=300>
								<TABLE height=300 cellPadding=0 width=900 border=0>
									<TBODY>
										<TR>
											<TD colSpan=2 height=35></TD>
										</TR>
										<TR>
											<TD width=360></TD>
											<TD>
												<TABLE cellSpacing=0 cellPadding=2 border=0>
													<TBODY>
														<TR>
														<font color="#ff0000">${loginError }</font>
															<TD style="HEIGHT: 28px" width=80>登 录 名：</TD>
															<TD style="HEIGHT: 28px" width=150><INPUT id=txtName
																style="WIDTH: 130px" name=username></TD>
															<TD style="HEIGHT: 28px" width=370><SPAN
																id=RequiredFieldValidator3
																style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入登录名</SPAN></TD>
														</TR>
														<TR>
															<TD style="HEIGHT: 28px">登录密码：</TD>
															<TD style="HEIGHT: 28px"><INPUT id=txtPwd
																style="WIDTH: 130px" type=password name=password></TD>
															<TD style="HEIGHT: 28px"><SPAN
																id=RequiredFieldValidator4
																style="FONT-WEIGHT: bold; VISIBILITY: hidden; COLOR: white">请输入密码</SPAN></TD>
														</TR>
														<TR>
															<TD style="HEIGHT: 28px">验证码：</TD>
															<TD style="HEIGHT: 28px"><INPUT id=txtcode
																style="WIDTH: 70px" name=checkcode>
																<IMG id="checkNumImage" src="${pageContext.request.contextPath }/image.jsp" border=0 height="19" align="absmiddle" onClick="changeCheckNum()" 
			  	           title="点击换一张" style="cursor:hand"><font color="#ff0000">${codeError }</font></TD>
															<TD style="HEIGHT: 28px">&nbsp;</TD>
														</TR>
														<TR>
															<TD style="HEIGHT: 18px"></TD>
															<TD style="HEIGHT: 18px"></TD>
															<TD style="HEIGHT: 18px"></TD>
														</TR>
														<TR>
															<TD></TD>
															<TD><INPUT id=btn
																style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px"
																onclick='javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions("btn", "", true, "", "", false, false))'
																type=image src="${pageContext.request.contextPath}/imgs/login_button.gif" name=btn>
															</TD>
														</TR>
													</TBODY>
												</TABLE>
											</TD>
										</TR>
									</TBODY>
								</TABLE>
							</TD>
						</TR>
						<TR>
							<TD><IMG src="${pageContext.request.contextPath}/imgs/login_3.jpg" border=0></TD>
						</TR>
					</TBODY>
				</TABLE>
			</DIV>
		</DIV>
	</FORM>
</BODY>
</html>