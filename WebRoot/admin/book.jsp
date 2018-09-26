<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String bookid=request.getParameter("bookid");
String name=request.getParameter("name");
String author=request.getParameter("author");
String intro=request.getParameter("intro");
String title=request.getParameter("title");
String price=request.getParameter("price");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改图书</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/book/css/admin.css" />
  </head>
  
  <body>
       <form action="/GoodGart/admin?type=update" method="post" >
        <table width="425px" height="121" border="0"   cellpadding="0" cellspacing="0">
            <tbody>
            <tr>
                <td></td><td>修改图书</td>
            </tr>
            <tr>
                <td width="684" align="left"><input type="hidden" text=""  name="bookid" value='<%=bookid %>'></td>
            </tr>
            <tr>
                <td width="116" align="right">书名：</td>
                <td width="684" align="left"><input text="" placeholder="书名" name="name" value='<%=name %>'></td>
            </tr>
            <tr>
                <td align="right">作者：</td>
                <td align="left"><input text="" placeholder="作者" name="author" value="<%=author %>"></td>
            </tr>
            <tr>
                <td align="right">价格：</td>
                <td align="left"><input text="" placeholder="价格" name="price" value="<%=price %>"></td>
            </tr>
            <tr>
                <td align="right">标题：</td>
                <td align="left"><input text="" placeholder="标题" name="title" value="<%=title %>"></td>
            </tr>
            <tr>
                <td align="right">介绍：</td>
                <td align="left"><textarea placeholder="介绍" name="intro">
                <%=intro%>
                </textarea>
            </tr>
            <tr>
                <td></td><td><input type="submit" value="submit"/></td>
            </tr>
            </tbody>
        </table>
    </form>
  </body>
</html>
