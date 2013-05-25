<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,javabean.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="classlist.css">
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
<div class="pagetitle"><p id="pfront">member_list 选择 一个你要查看信息的成员</p></div>
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
<%! 
ArrayList<UserName> arraylist = null;
int i,l = 0;  %>
<%
arraylist = (ArrayList)request.getAttribute("arraylist");
l = arraylist.size();
%>
<table border=1; class="membertable">
<tr><td>成员列表:</td></tr>
<% 
for(i=0;i<l;i++){
	UserName username = (UserName)arraylist.get(i);
%>
<tr>
	<td width=150px;>
	<form id="form" action="DisplayInfoAction" method="post">
	<input type="hidden" name="kind" value="member">
	<input type="hidden" name="membername" value="<%=username.get_username() %>">
	<input type="hidden" name="memberid" value="<%=username.get_memberid() %>">
	<!-- 这个提交我本来用的 a标签然后调用 js函数的   不过，用a标签方式好像在ie浏览器不行，然后我就改为input了，如果你想修改的话，你看一下能不能解决那个ie跳转不了的问题 -->
	<input type="submit" value="<%=username.get_username() %>">
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