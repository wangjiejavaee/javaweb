<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="bean.GoodsList"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'GoodCarList.jsp' starting page</title>
    
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
    <% 
    response.setContentType("text/html");
    response.setCharacterEncoding("utf-8");
    GoodsList goodslist=null;
   String [] name = new String [20];
   goodslist=(GoodsList)request.getAttribute("goods");
   for(int i=0;i<goodslist.getgoodlist().size();i++){
   name[i]=goodslist.getgoodlist().get(i).getName();
   out.print("商品名字 :"+name[i]);
   out.print("商品数量 :"+goodslist.getgoodlist().get(i).getNumber());
   out.println("商品价格 :"+goodslist.getgoodlist().get(i).getPrice());
   out.println("<br>"); 
   }
   out.println("商品总价格 :"+request.getAttribute("sumprices"));
    %>
    <a href="index.jsp">返回</a>
  </body>
</html>
