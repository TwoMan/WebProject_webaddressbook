<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="javabean.*" %>
<jsp:useBean id="schoolselect" class="javabean.SchoolSelectArray" ></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>choose the addressbook inside </title>
<link rel="stylesheet" type="text/css" href="./extsrc/cssfiles/memberinfo.css">
</head>
<%!
int i=0; 
ArrayList<String> selectarray_province,selectarray_city,selectarray_town,selectarray_school,selectarray_age,selectarray_classandgrade;
int state=1; 
%>
<%  
selectarray_province = (ArrayList)schoolselect.getSchoolArray_province();
selectarray_age = (ArrayList)schoolselect.getSchoolArray_age();
selectarray_city = (ArrayList)schoolselect.getSchoolArray_city();
selectarray_town = (ArrayList)schoolselect.getSchoolArray_town();
selectarray_school = (ArrayList)schoolselect.getSchoolArray_school();
selectarray_classandgrade = (ArrayList)schoolselect.getSchoolArray_classandgrade();
%>
<!-- 这个页面内容比较多，你可以把js提取出来，和放到css目录里面  -->
<body>
	<div class="pagehead"></div>
	<div>
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
	<div id="form_select" style="float:left;">
	<form id="select_form" action="JoinbookAction" method="post">
	<input type="hidden" name="create" id="create" value="old">
	<table>
	
	<tr>	<td>请选择省份：</td>
		<td><select name="province_select" id="province">
		<%--当从数据库中取得的列表数不为零时，自动生成多个选项 --%>
			<option value="" >
		<%for(i=0;i<selectarray_province.size();i++){  %>
			<option value="<%=selectarray_province.get(i) %>"><%=selectarray_province.get(i) %>
		<%} %>	
		</select></td>
	</tr>
		<td>请选择所在城市：</td>
		<td><select name="city_select" id="city">
		<option value="">
		<%--当从数据库中取得的列表数不为零时，自动生成多个选项 --%>
		<%for(i=0;i<selectarray_city.size();i++){  %>
			<option value="<%=selectarray_city.get(i) %>"><%=selectarray_city.get(i) %>
		<%} %>	
		</select></td>
	<tr>	
		<td>请选择所在县城：</td>
		<td><select name="town_select" id="town">
		<option value="">
		<%--当从数据库中取得的列表数不为零时，自动生成多个选项 --%>
		<%for(i=0;i<selectarray_town.size();i++){  %>
			<option value="<%=selectarray_town.get(i) %>"><%=selectarray_town.get(i) %>
		<%} %>	
		</select></td>
	</tr>
	<tr>	
		<td>请选择你的学校名：</td>
		<td><select name="school_select" id="school">
		<option value="">
		<%--当从数据库中取得的列表数不为零时，自动生成多个选项 --%>
		<%for(i=0;i<selectarray_school.size();i++){  %>
			<option value="<%=selectarray_school.get(i) %>"><%=selectarray_school.get(i) %>
		<%} %>	
		</select></td>
	</tr>
	<tr>	
		<td>请选择你当时的年届：</td>
		<td><select name="age_select" id="age">
		<option value="">
		<%--当从数据库中取得的列表数不为零时，自动生成多个选项 --%>
		<%for(i=0;i<selectarray_age.size();i++){  %>
			<option value="<%=selectarray_age.get(i) %>"><%=selectarray_age.get(i) %>
		<%} %>	
		</select></td>
	</tr>	
	<tr>
		<td>请选择你的年纪和班：</td>
		<td><select name="class_grade_select" id="classandgrade">
		<option value="">
		<%--当从数据库中取得的列表数不为零时，自动生成多个选项 --%>
		<%for(i=0;i<selectarray_classandgrade.size();i++){ %>
			<option value="<%=selectarray_classandgrade.get(i) %>"><%=selectarray_classandgrade.get(i) %>
		<%} %>	
		</select></td>
	</tr>
	
	<tr>
	<!-- 这几个id都比较重要，尽可能的不要修改它，当然，可以改变它的位置，你可以登录去尝试了解这些id是有什么作用的，如果你要定位的话，改用class来定位吧， -->
	<td id="questp"></td>
	<td><a id="quest"></a></td>
	</tr>
	<tr>
		<td id="answerp"></td>		
		<td><a id="answer"></a></td>
	</tr>	
	<tr>
	<td id="applyquestion"></td>
	<td><a id="oldquestanswer"></a></td>
	<td><input type="submit" id="submit" value="提交"></td>
	</tr>
	</table>	
	</form>
	</div>
	<div id="button" style="float:left;">
		<table>
			<tr><td><button class="but" onclick="check(1)">没有你想要的选择？请点击</button></td></tr>
			<tr><td><button class="but" onclick="check(2)" >没有你想要的选择？请点击</button></td></tr>
			<tr><td><button class="but"  onclick="check(3)">没有你想要的选择？请点击</button></td></tr>
			<tr><td><button class="but"  onclick="check(4)">没有你想要的选择？请点击</button></td></tr>
			<tr><td><button class="but"  onclick="check(5)">没有你想要的选择？请点击</button></td></tr>
			<tr><td><button class="but"  onclick="check(6)">没有你想要的选择？请点击</button></td></tr>
		</table>
	</div>
	</div>
	<button onclick="createnode()">检测</button>
</body>
<script	language="javascript">
	var check1=1,check2=1,check3=1,check4=1,check5=1,check6=1;
	function check(kind){
		
		switch(kind)
		{
			case 1:if(check1==1){var province = document.createElement("input");
					province.setAttribute("type","text");province.setAttribute("name","province_select_input");		
					var insert = document.getElementById("province");insert.parentNode.insertBefore(province,insert); check1=0;}break;
			case 2:if(check2==1){var city = document.createElement("input");
					city.setAttribute("type","text");city.setAttribute("name","city_select_input");		
					var insert = document.getElementById("city");insert.parentNode.insertBefore(city,insert);check2=0;}break;
			case 3:if(check3==1){var town = document.createElement("input");
					town.setAttribute("type","text");town.setAttribute("name","town_select_input");		
					var insert = document.getElementById("town");insert.parentNode.insertBefore(town,insert);check3=0;}break;
			case 4:if(check4==1){var school = document.createElement("input");
					school.setAttribute("type","text");school.setAttribute("name","school_select_input");		
					var insert = document.getElementById("school");insert.parentNode.insertBefore(school,insert);check4=0;}break;
			case 5:if(check5==1){var age = document.createElement("input");
					age.setAttribute("type","text");age.setAttribute("name","age_select_input");		
					var insert = document.getElementById("age");insert.parentNode.insertBefore(age,insert);check5=0;}break;
			case 6:if(check6==1){var classandgrade = document.createElement("input");
					classandgrade.setAttribute("type","text");classandgrade.setAttribute("name","classandgrade_select_input");		
					var insert = document.getElementById("classandgrade");insert.parentNode.insertBefore(classandgrade,insert);check6=0;}break;
		
		}
		
	}
	function createnode()
	{
		
		
		if(check1&&check2&&check3&&check4&&check5&&check6)
			{
				
				if(document.getElementById("city").value!=""&&document.getElementById("town").value!=""&&document.getElementById("school").value!=""
						&&document.getElementById("age").value!=""&&document.getElementById("classandgrade").value!=""&&document.getElementById("province").value!="")
					{
					
					if(window.XMLHttpRequest)
					{
					
						xmlhttprequest= new XMLHttpRequest();
					}
					else
					{
						xmlhttprequest= new ActiveXObject("Microsoft.XMLHTTP");
					}
					xmlhttprequest.onreadystatechange=function()
					{
						
					if(xmlhttprequest.readyState==4&&xmlhttprequest.status==200)
						{
							
							
						//alert(xmlhttprequest.responseText.length);
						if(xmlhttprequest.responseText.length<7)
							{
							var insertquest = document.createElement("input");
							insertquest.setAttribute("type","text"); insertquest.setAttribute("name","newapplyquestion");
							var insert = document.getElementById("quest"); insert.parentNode.insertBefore(insertquest,insert);
							//var remindquest = document.createElement("p");
							//remindquest.setAttribute("id","text"); 
							//document.getElementById("text").innerHTML="填入创建通讯录的问题!";			
							//var insertp = document.getElementById("quest"); insertp.parentNode.insertBefore(remindquest,insertp);
							document.getElementById("questp").innerHTML="填入创建通讯录的问题！";
							
							var insertquest = document.createElement("input");
							insertquest.setAttribute("type","text"); insertquest.setAttribute("name","newquestionanswer");
							var insert = document.getElementById("answer"); insert.parentNode.insertBefore(insertquest,insert);
							
							document.getElementById("answerp").innerHTML="问题的答案为:";
							
							document.getElementById("create").setAttribute("value","new");
							}
						else
						 {document.getElementById("applyquestion").innerText=xmlhttprequest.responseText;
						 //alert(xmlhttprequest.responseText);
						 //document.getElementById("applyquestion").innerHTML=xmlhttprequest.responseText;
						//document.getElementById("questiontd").value=xmlhttprequest.responseText;
						var insertquest = document.createElement("input");
						insertquest.setAttribute("type","text"); insertquest.setAttribute("name","oldquestanswer");
						var insert = document.getElementById("oldquestanswer"); insert.parentNode.insertBefore(insertquest,insert);
						//alert(xmlhttprequest.responseText);
						 }
					}
				
				}
					
					xmlhttprequest.open("get","JoinBookCheckServlet?province_select="+document.getElementById("province").value+
														"&city_select="+document.getElementById("city").value+
														"&town_select="+document.getElementById("town").value+
														"&school_select="+document.getElementById("school").value+
														"&age_select="+document.getElementById("age").value+
														"&classandgrade_select="+document.getElementById("classandgrade").value
						,true);
					//alert(document.getElementById("username").value);
					
					xmlhttprequest.send();
						
					
			
				}
			}
		else 
		{
			var insertquest = document.createElement("input");
			insertquest.setAttribute("type","text"); insertquest.setAttribute("name","newapplyquestion");
			var insert = document.getElementById("quest"); insert.parentNode.insertBefore(insertquest,insert);
			//var remindquest = document.createElement("p");
			//remindquest.setAttribute("id","text"); 
			//document.getElementById("text").innerHTML="填入创建通讯录的问题!";			
			//var insertp = document.getElementById("quest"); insertp.parentNode.insertBefore(remindquest,insertp);
			document.getElementById("questp").innerHTML="填入创建通讯录的问题！";
			
			var insertquest = document.createElement("input");
			insertquest.setAttribute("type","text"); insertquest.setAttribute("name","newquestionanswer");
			var insert = document.getElementById("answer"); insert.parentNode.insertBefore(insertquest,insert);
			
			document.getElementById("answerp").innerHTML="问题的答案为:";
			
			document.getElementById("create").setAttribute("value","new");
		}
		
	
		
		
	}
</script>
</body>
</html>
</html>