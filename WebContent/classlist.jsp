<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="javabean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>已加入通讯录</title>
	<link rel="stylesheet" type="text/css" href="./extsrc/css/classlist.css"></head>

<body>
	<!--顶部固定导航条-->
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
					</a>
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
			<%! ArrayList arraylist=null;int i,l=0; %>
			<% 
arraylist=(ArrayList)request.getAttribute("schoolarraylist");
l=arraylist.size();
%>
			加入的通讯组群数目:
			<%=l %>
			<table cellspacing="0" border="1px #76aef0 solid";>
				<thead></thead>
				<tr>
					<td width=250px;>所在省份</td>
					<td width=250px;>所在城市</td>
					<td width=250px;>所在城镇</td>
					<td width=250px;>所在学校</td>
					<td width=250px;>所处年纪</td>
					<td width=250px;>所在班级</td>
					<td width=250px;>点击进入</td>
				</tr>
				<%
for(i=0;i<l;i++){
	UserSchool userschool=(UserSchool)arraylist.get(i);
%>
				<tr>
					<td>
						<%=userschool.get_province() %></td>
					<td>
						<%=userschool.get_city() %></td>
					<td>
						<%=userschool.get_town() %></td>
					<td>
						<%=userschool.get_school() %></td>
					<td>
						<%=userschool.get_age() %></td>
					<td>
						<%=userschool.get_class_and_grade() %></td>
					<td>
						<form id="form" action="MemberListAction" method="post">
							<input type="hidden" name="province" value="<%=userschool.get_province() %>
							">
							<input type="hidden" name="city" value="<%=userschool.get_city() %>
							">
							<input type="hidden" name="town" value="<%=userschool.get_town() %>
							">
							<input type="hidden" name="school" value="<%=userschool.get_school() %>
							">
							<input type="hidden" name="age" value="<%=userschool.get_age() %>
							">
							<input type="hidden" name="class_and_grade" value="<%=userschool.get_class_and_grade() %>
							">
							<!-- 这个和memberlist。jsp的问题相同 只要能顺利跳转就行 -->
							<input type="submit" value="进入"></form>
					</td>
				</tr>
				<%
}
%></table>
			<a href="join_class_addressbook.jsp">
				<p>classlist 你要加入新的班级通讯录吗</p>
			</a>

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
	</div>
	<div class="bottom">
		<img src="./extsrc/images/logo_MeWe.png">
		<p>
			&copy;&nbsp;2013 &nbsp; <strong>WeMe</strong>
			&nbsp;All Rights Reserved
		</p>

	</div>
	<script type="text/javascript">
//提交表单:	
function submit(){
		document.form.submit();		
	}	
</script>
</body>
</html>