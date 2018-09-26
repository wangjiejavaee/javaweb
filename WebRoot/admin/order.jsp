<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String carId=request.getParameter("carId");
String userId=request.getParameter("userId");
String orderId=request.getParameter("orderId");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改订单</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/book/css/admin.css" />
  </head>
  
  <body>
       <form action="/GoodGart/admin?type=update1" method="post" >
        <table width="425px" height="121" border="0"   cellpadding="0" cellspacing="0">
            <tbody>
            <tr>
                <td></td><td>修改订单</td>
            </tr>
            <tr>
                <td width="684" align="left"><input type="hidden" text=""  name="orderId" value='<%=orderId %>'></td>
            </tr>
            <tr>
                <td width="116" align="right">购物车id：</td>
                <td width="684" align="left"><input text="" placeholder="书名" name="carId" value='<%=carId %>'></td>
            </tr>
            <tr>
                <td align="right">用户id：</td>
                <td align="left"><input text="" placeholder="作者" name="userId" value="<%=userId %>"></td>
            </tr>
            <tr>
                <td align="right">清算状态(0:未清算；1:已清算)：</td>
                <td align="left"><label for="select">Select:</label>
					<select name="ordertype">
						<option value="0">0</option>
						<option value="1">1</option>						
				</select></td>
            <tr>
                <td></td><td><input type="submit" value="submit"/></td>
            </tr>
            </tbody>
        </table>
    </form>
  </body>
</html>
