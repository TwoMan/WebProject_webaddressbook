<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帐号注册</title>
<link rel="stylesheet" type="text/css" href="./extsrc/cssfiles/register.css" >
</head>
<!--body部分-->
<body>
  <form name = "registerForm" action="RegisterAction" method="post">
    <div id="table" class="radius">
      <div class="wrapper">

        <h1>帐号注册</h1>   <!--注册大标题-->
        <p>
          <label for="id">身份证号:</label>
          <input name="userID" id="id" type="text" onchange="onlyless19Num()" placeholder=" 如: 888888888888888888"/>
        </p>

        <p>
          <label for="username">真实姓名:</label>
          <input name="username" type="text" onchange="onlyCh()" placeholder=" 如: 张三"></p>

        <p>
          <label for="phonenumber">手机号码:</label>
          <input name="phonenumber" type="text"  onchange="testPhoneNum()" placeholder=" 如: 11011912000"></p>

        <p>
          <label for="currentaddress">现居住地:</label>
          <input name="currentaddress" type="text" onchange="testcurrentAddress()" placeholder=" 如: 广州市 XX 区 XX 街道 XX 号"></p>

        <p>
          <label for="career">工作类型:</label>
          <input name="career" type="text" onchange="testCareer()" placeholder=" 如: Web前端开发"></p>

        <p>
          <label for="workt">现任职务:</label>
          <input name="workt" type="text" onchange="testworkt()" placeholder=" 如: XX 攻城师"></p>

        <p>
          <label for="question">登录问题:</label>
          <input name="question" type="text" placeholder=" 如: 我的学号是？"></p>

        <p>
          <label for="answer">问题答案:</label>
          <input name="answer" type="text" placeholder=" 如: 2013"></p>

        <input type="hidden" name="method" value="insertuser">

        <!--可以链接到登录界面-->
        <p class="left10em">已有帐号?!&nbsp;&nbsp;<a href="index.jsp">马上登录</a></p>

        <!--“马上注册”的按钮-->
        <input id="input" name="submit" type="submit" value="马上注册"></div>
    </div>
  </form>
  <!-- 验证注册身份证号码是否输入正确 -->
<script language=javascript>

	function onlyless19Num() {
		// 字符数不能超过18位
		var userID = document.registerForm.userID;
		var userIDVal = document.registerForm.userID.value;
		if ( userIDVal.length >= 19) {
			alert("你输入字符超过18个，请重新输入！");
			userID.focus();
		} else {
			//考虑小键盘上的数字键，只能是数字
			var reg = /^[0-9]*$/i; //正则表达式，表示数字
			if (!reg.test( userIDVal )) {
				alert("只能输入数字字符，请重新输入！");
				userID.focus();
			}
		}

	}
</script>

<!-- 验证真实姓名是否合法 -->
<script language=javascript>

	function onlyCh() {
		var userName = document.registerForm.username;
		var userNameVal = document.registerForm.username.value;
		// 字符数不能超过18位
		if (!( userNameVal.length <=15 )) {
			alert("你输入字符超过15个，请重新输入！");
			userName.focus();
		} else {
			//考虑小键盘上的数字键，只能是中文
			
			var reg = /^[\u4e00-\u9fa5]+$/g;  //正则表达式，表示只能输入中文，全部中文
			if (!reg.test( userNameVal )) {
				alert("只能输入中文字符，请重新输入！");
				userName.focus();
			}
		}

	}
</script>

<!-- 验证手机号码是个否正确 -->
<script type="text/javascript">
	function testPhoneNum() {
		var phoneNumber = document.registerForm.phonenumber;
		var phoneNumberVal = document.registerForm.phonenumber.value;
		
		//字符数不能超过11位
		var reg = /^[0-9]*$/i;  //正则表达式，表示只能输入11位数的号码
		if(!(phoneNumberVal.length == 11)) {
			alert("请正确输入手机号码！");
			phoneNumber.focus();
			
		}else{
			if(!reg.test(phoneNumberVal)){
			alert("请正确输入手机号码！");
			phoneNumber.focus();
		}
		} 
	}
</script>

<!-- 验证现居地址是个否正确 -->
<script type="text/javascript">
	function testcurrentAddress() {
		var currentAddress = document.registerForm.currentaddress;
		var currentAddressVal = document.registerForm.currentaddress.value;
		
		//字符数不能超过30位
		var reg = /[\u4e00-\u9fa5]/i;  //正则表达式，表示只能输入中文或者英文
		if(!(currentAddressVal.length <=30)) {
			alert("地址长度超过30，请重新输入！");
			currentAddress.focus();
			
		}else{
			if(!reg.test(currentAddressVal)){
			alert("只能输入中文或者英文！请正确输入现居地址~");
			currentAddress.focus();
		}
		} 
	}
</script>

<!-- 验证工作类型是个否正确 -->
<script type="text/javascript">
	function testCareer() {
		var career = document.registerForm.career;
		var careerVal = document.registerForm.career.value;
		
		//字符数不能超过30位
		var reg = /[\u4e00-\u9fa5]/i;  //正则表达式，表示只能输入中文或者英文
		if(!(careerVal.length <=30 )) {
			alert("工作类型长度超过30，请重新输入！");
			career.focus();
			
		}else{
			if(!reg.test(careerVal)){
			alert("只能输入中文或者英文，请正确输入工作类型~");
			career.focus();
		}
		} 
	}
</script>
<!-- 验证现任职务是个否正确 -->
<script type="text/javascript">
	function testworkt() {
		var workt = document.registerForm.workt;
		var worktVal = document.registerForm.workt.value;
		
		//字符数不能超过30位
		var reg = /[\u4e00-\u9fa5]/i;  //正则表达式，表示只能输入中文或者英文
		if(!(worktVal.length <= 30)) {
			alert("现任职务长度超过30，请重新输入！");
			workt.focus();
			
		}else{
			if(!reg.test(worktVal)){
			alert("只能输入中文或者英文，请正确输入现任职务~");
			workt.focus();
		}
		} 
	}
</script>
</body>

</html>