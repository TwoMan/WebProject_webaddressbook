<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="javabean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="classlist.css" >
<link rel="stylesheet" type="text/css" href="./extsrc/cssfiles/memberinfo.css">
</head>
<script type="text/javascript">
//提交表单:	
function submit(){
		document.form.submit();		
	}	
</script>
<body>
<div class="head"></div>
<div class="body">
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
<div class="linkguide"><a href="join_class_addressbook.jsp"><p>classlist 你要加入新的班级通讯录吗</p></a></div>
<%! ArrayList arraylist=null;int i,l=0; %>
<% 
arraylist=(ArrayList)request.getAttribute("schoolarraylist");
l=arraylist.size();
%>
加入的通讯组群数目:<%=l %>
<table border="1px #76aef0 solid"; class="classlisttable">
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
	<td><%=userschool.get_province() %></td>
	<td><%=userschool.get_city() %></td>
	<td><%=userschool.get_town() %></td>
	<td><%=userschool.get_school() %></td>
	<td><%=userschool.get_age() %></td>
	<td><%=userschool.get_class_and_grade() %></td>
	<td>
	<form id="form" action="MemberListAction" method="post">
	<input type="hidden" name="province" value="<%=userschool.get_province() %>">
	<input type="hidden" name="city" value="<%=userschool.get_city() %>">
	<input type="hidden" name="town" value="<%=userschool.get_town() %>">
	<input type="hidden" name="school" value="<%=userschool.get_school() %>">
	<input type="hidden" name="age" value="<%=userschool.get_age() %>">
	<input type="hidden" name="class_and_grade" value="<%=userschool.get_class_and_grade() %>">
	<!-- 这个和memberlist。jsp的问题相同 只要能顺利跳转就行 -->
	<input type="submit" value="进入">
	</form>	
	</td>	
</tr>
<%
}
%>
</table>
</div>
<div class="tail"></div>
</body>
</html>