<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="javabean.MemberInfomation "%>
<jsp:useBean id="member" class="javabean.UserName" scope="page"></jsp:useBean>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>用户信息修改</title>
	<link rel="stylesheet" type="text/css" href="./extsrc/css/updateinfo.css"></head>
<body>
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
	if(request.getAttribute("memberinfo") != null )
		memberinfo = (MemberInfomation)request.getAttribute("memberinfo");
	
%>
	<div class="top_nav">

		<!--顶部固定导航条左侧导航-->
		<div class="container">

			<!--左侧水平导航条-->
			<ul class="nav">
				<li>
					<a href="#" >首页</a>
				</li>
				<li>
					<a href="#" >关于</a>
				</li>
				<li>
					<a href="#" >新闻</a>
				</li>
				<li>
					<a href="#" >产品</a>
				</li>
				<li>
					<a href="#" >服务</a>
				</li>

				<!--这里的用户名应该放在右侧的，暂时放在这里先-->
				<li>
					<a href="#" >
						<img src="./extsrc/images/me.jpg" height="20" width="20" style="margin-top:2px;"></a>
				</li>
				<li>
					<a href="#" >
						&nbsp;
						<%=memberinfo.get_name()%></a>
				</li>
				<li>
					<a href="index.jsp">安全退出</a>
				</li>
			</ul>

		</div>
	</div>

	<!--logo和横标banner-->
	<div id="logo_banner">
		<img src="./extsrc/images/banner.png"/>
	</div>
	<div id="main_content">
		<div class="left">
			<form action="OnUpdate" method="post">
				<div id="table" class="radius">
					<div class="wrapper">
						<p>
							<label for="username">真实姓名:</label>
							<input name="username" type="text" value="<%=memberinfo.get_name()%>"></p>

						<p>
							<label for="phonenumber">手机号码:</label>
							<input name="phonenumber" type="text"   value="<%=memberinfo.get_phonenumber() %>"></p>

						<p>
							<label for="currentaddress">现居住地:</label>
							<input name="currentaddress" type="text" value="<%=memberinfo.get_currentaddress() %>"></p>

						<p>
							<label for="career">工作类型:</label>
							<input name="career" type="text" value="<%=memberinfo.get_career() %>"></p>

						<p>
							<label for="workt">现任职务:</label>
							<input name="workt" type="text" value="<%=memberinfo.get_workt() %>"></p>

						<!--“马上注册”的按钮-->
						<label class="modify">确认提交修改?</label>
						<input id="input" name="submit" type="submit" value="提交修改"></div>
				</div>
			</form>
			<%
}
%></div>
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
	</div>
	<div class="bottom">
		<img src="./extsrc/images/logo_MeWe.png">
		<p>
			&copy;&nbsp;2013 &nbsp; <strong>WeMe</strong>
			&nbsp;All Rights Reserved
		</p>

	</div>
</body>
</html>