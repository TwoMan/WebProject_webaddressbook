<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>

<body>
<%
	if(request.getSession().isNew() == false){
%>
<jsp:forward page="DisplayInfoAction"></jsp:forward>
<%
	}
%>
<center>

<form id="loginform"  method="post" action="login_check_action" >
	<input type="hidden" name="method" value="checkuser" >
	<table class="table" style="border:1px;" >
	<thead><p>登录</p></thead>
	<tr>
		<td>id号（身份证号或者学号）:</td>
		<td><input name="id" id="username" type="text" size="30" maxlength="50" ></td>
	</tr>
	<tr><td></td>		
		<td></td>
	</tr>
	<tr>
		<td>问题</td>
				
		<td id="questiontd"></td>
	</tr>
	<tr>
		<td>答案</td>		
		<td><input name="questanswear" type="text" size="30" maxlength="50" ></td>	
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="提交"></td>
	</tr>
	</table>
</form>
<a href="register.jsp">注册</a>
<button onclick="createxmlhttprequest()">获取问题</button>
</center>
</body>
<script  language="javascript">

function createxmlhttprequest()
{
	var str ;
	
	str = document.getElementById("username").value;
	
	if (str.length==0)
	  {
	  document.getElementById("questiontd").innerHTML="";
	  return;
	  }
	if(window.XMLHttpRequest)
		{
		
			xmlhttprequest= new XMLHttpRequest();
		}
	else
		{
			xmlhttprequest= new ActiveXObject("Microsoft.XMLHTTP");
		}
	xmlhttprequest.onreadystatechange=function(){
		if(xmlhttprequest.readyState==4&&xmlhttprequest.status==200)
			{
				
				document.getElementById("questiontd").innerHTML=xmlhttprequest.responseText;
				//document.getElementById("questiontd").value=xmlhttprequest.responseText;
			}
	
		}
	
	xmlhttprequest.open("GET","GetLoginQuestion?id="+str,true);
	//wlnstr=document.getElementById("username").toString();
	//alert(document.getElementById("username").value);
	//xmlhttprequest.setRequestHeader("Content-Typt","application/x-www-form-urlencoded");	
	xmlhttprequest.send();
	}


</script>
</html>