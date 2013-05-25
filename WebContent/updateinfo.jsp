<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javabean.MemberInfomation "%>
<jsp:useBean id="member" class="javabean.UserName" scope="page"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息修改</title>
<link rel="stylesheet" type="text/css" href="./extsrc/cssfiles/memberinfo.css">
</head>
<body>
<div class="guide">

</div>
<div class="right">
			<ul>
				<li>
					<p>
						<a href="UpdateMemberInfoAction">管理个人名片</a>
					</p>
				</li>
				<li>
					<p>
						<a href="ClassListAction">已加入通讯录</a>
					</p>
				</li>
				<li>
					<p>
						<a href="join_class_addressbook.jsp">去加入通讯录</a>
					</p>
				</li>
				<li>
					<p>
						<a href="ClassListAction">去管理通讯录</a>
					</p>
				</li>
			</ul>
		</div>
<%!
HttpSession session = null; 
MemberInfomation memberinfo = null;
%>
<% 
//从request中取得session，判断session是否为新的，如果是，则说明session过期，应重新登录；
session = request.getSession();
if(session.isNew()){
	response.sendRedirect("index.jsp");
}
else{
	if(request.getAttribute("memberinfo") != null ){
		memberinfo = (MemberInfomation)request.getAttribute("memberinfo");
%>
	<form action="OnUpdate" method="post">
	<table>
	<tr>
		<td>姓名:</td><td><input name="username" type="text" size="50" value="<%=memberinfo.get_name() %>" ></td>
	</tr>
	<tr>
		<td>电话号码:</td><td><input name="phonenumber" type="text" size="50" value="<%=memberinfo.get_phonenumber() %>" ></td>
	</tr>	
	<tr>
		<td>地址:</td><td><input name="currentaddress" type="text" size="50" value="<%=memberinfo.get_currentaddress() %>" ></td>
	</tr>		
	<tr>
		<td>职业:</td><td><input name="career" type="text" size="50" value="<%=memberinfo.get_career() %>" ></td>
	</tr>	
	<tr>
		<td>工作类型:</td><td><input name="workt" type="text" size="50" value="<%=memberinfo.get_workt() %>" ></td>
	</tr>	
	<tr>
		<td>是否确认提交？</td><td><input type="submit" value="提交修改"></td>
	</tr>	
		
	</table>
	</form>
<%
	}
	else
		out.println("没有找到对象");
}
%>
</body>
</html>