<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- head 部分 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="./extsrc/css/index.css">
</head>

<!-- body 部分 hh-->
<body>
	<div id="loginWindow" class="radius">
		<div class="wrapper">
			<form name="loginform" id="loginform" method="post"
				action="login_check_action">

				<h1>用户登录</h1>
				<!--注册大标题-->
				<p>
					<label for="id">身份证号:</label> <input name="id" id="username"
						type="text" onchange="onlyless19Num()"
						placeholder=" 如: 888888888888888888" />
				</p>

				<p>
					<label for="question">登录问题:</label> <input id="showQuestion"
						class="reducewidth" type="text">
				</p>

				<p>
					<label for="answer">问题答案:</label> <input name="questanswear"
						type="text" placeholder=" 如: 2013">
				</p>

				<!--可以链接到登录界面-->
				<p class="left10em">
					没有帐号?!&nbsp; <a href="register.jsp">马上注册</a>
				</p>

				<!--“马上注册”的按钮-->
				<input id="submit" name="submit" type="submit" value="马上登录">
			</form>

		</div>
		<button class="getQuestion" id="questionbutton"
			onclick="createxmlhttprequest()">获取问题</button>
	</div>

	<script language="javascript">
		function createxmlhttprequest() {
			var str;

			str = document.getElementById("username").value;

			if (str.length == 0) {
				document.getElementById("showQuestion").innerHTML = "";
				return;
			}
			if (window.XMLHttpRequest) {

				xmlhttprequest = new XMLHttpRequest();
				
			} else {
				xmlhttprequest = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttprequest.onreadystatechange = function() {
				if (xmlhttprequest.readyState == 4
						&& xmlhttprequest.status == 200) {

					document.getElementById("showQuestion").setAttribute(
							"Value", xmlhttprequest.responseText);
					//alert(xmlhttprequest.responseText);
					//document.getElementById("questiontd").value=xmlhttprequest.responseText;
				}

			}

			xmlhttprequest.open("GET", "GetLoginQuestion?id=" + str, true);
			//wlnstr=document.getElementById("username").toString();
			//alert(document.getElementById("username").value);
			//xmlhttprequest.setRequestHeader("Content-Typt","application/x-www-form-urlencoded");	
			xmlhttprequest.send();
		}
	</script>
	<!-- 验证注册身份证号码是否输入正确 -->
	<script language=javascript>
		function onlyless19Num() {
			var userId = document.loginform.id;
			var userIdVal =document.loginform.id.value;
			// 字符数不能超过18位
			if (userIdVal.length >= 19) {
				alert("你输入字符超过18个，请重新输入！");
				
				//清空用户所填的
				userId.value = "";  
				
				//重新获得输入框焦点
				userId.focus();
			}else{
			//考虑小键盘上的数字键，只能是数字
			var reg = /^[0-9]*$/i;    //正则表达式，表示数字
			if (!reg.test(userIdVal)) {
				alert("只能输入数字字符，请重新输入！");
				
				//清空用户所填的
				userId.value = "";
				
				//重新获得输入框焦点
				userId.focus();
			}
		}

		}
	</script>
</body>
</html>
