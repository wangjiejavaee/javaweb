<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   		<a href="/GoodGart/user/register.html" target='_blank'>注册</a><br><br>
  <a href="/GoodGart/user/login.html" target='_blank'>登录</a><br><br>
  <a href="/GoodGart/servlet/UserServlet?type1=showPage&page=1&pageSize=2" target='_blank'>浏览用户</a><br><br>
  <a href="/GoodGart/servlet/UserServlet?type1=check&page=1&pageSize=2" target='_blank'>审查用户</a><br><br>
  <a href="/GoodGart/manager/userSearch.jsp" target='_blank'>查询用户</a><br><br>    
  <a href="/GoodGart/servlet/UserServlet?type1=delete&page=1&pageSize=2" target='_blank'>删除用户</a><br><br>
用户<br>
  <a href="/GoodGart/user/manage/changePassword.jsp" target='_blank'>查询用户</a><br><br> 
  </body>
</html>
<!--   <h1>购物车展示</h1>
     <a href="GoodsServlet?types=showGoods">展示所有商品</a>
     <!--<a href="GoodsServlet?types=addCart">加入购物车</a> 
     <a href="GoodsServlet?types=showCart">展示购物车</a> -->
     
