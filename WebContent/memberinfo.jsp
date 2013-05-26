<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javabean.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- head 部分  -->
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户首页</title>
	<link rel="stylesheet" type="text/css" href="./extsrc/css/memberinfo.css"></head>
	<%! MemberInfomation memberinfo=null; %>
	<% memberinfo=(MemberInfomation)request.getAttribute("memberinfo"); %>
</head>

<!-- part of body -->
<body>
	<%
		if(session.isNew())
			response.sendRedirect("index.jsp");
		else
		{
	%>
	<div><a href="" > 安全退出？</a></div>
	<%} %>
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
					<a href="#" ><img src="./extsrc/images/me.jpg" height="20" width="20" style="margin-top:2px;"></a>
				</li>
				<li>
					<a href="#" >&nbsp;<%=memberinfo.get_name()%></a>
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
			<div id="left_card_front" class = "left_up">
				<h1><%=memberinfo.get_name()%></h1>
				<p><%=memberinfo.get_career() %></p>
				<ul>
					<li>工作类型:<%=memberinfo.get_workt() %></li>
					<li>联系号码:<%=memberinfo.get_phonenumber() %></li>
					<li>个人邮箱:</li>
					<li>现居住地:<%=memberinfo.get_currentaddress() %></li>
				</ul>
			</div>

			<div id="left_card_back" class = "left_down">
				<h1>wjj474957860</h1>
				<p>Web前端工程师</p>
				<ul>
					<li>工作类型:</li>
					<li>联系号码:</li>
					<li>个人邮箱:</li>
					<li>现居住地:</li>
				</ul>
			</div>
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
			2013 &nbsp; <strong>WeMe</strong>
			&nbsp;All Rights Reserved
		</p>

	</div>
	
	<script type="text/javascript" src="./extsrc/js/getID.js"></script>
	<script type="text/javascript">
		var card_front = getID("left_card_front");
		var card_back = getID("left_card_back");
		
		//把count定义为全局变量，用来判断用户的点击哪个名片
		//才做出正确的行为
		var count = 1;
		
		card_front.onclick=function(){
			if( count % 2 == 1){
			//改变名片的位置，添加交互性
			card_front.style.cssText = "margin-top :0px";
			card_back.style.cssText = "display :block";
			count++;
			}else{
				//也可以这样写card_front.style.margin-top="200px";
				card_front.style.cssText = "margin-top :200px";
				card_back.style.cssText = "display :none";
				count++;
			}
		};
		card_back.onclick = function() {
			card_front.style.cssText = "margin-top :200px";
			card_back.style.cssText = "display :none";
			count = 1;
		};
	</script>
</body>
</html>