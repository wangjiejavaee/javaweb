<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/book/css/admin.css" />
<script  type="text/javascript">
    function btn() {
    var div1=document.getElementById("rightboxone");
    var div2=document.getElementById("rightboxtwo");
        div1.style.display="block";
        div2.style.display="none";
    }
    function btn1() {
    var div1=document.getElementById("rightboxone");
    var div2=document.getElementById("rightboxtwo");
        div1.style.display="none";
        div2.style.display="block";
     }
	</script>
  </head>
  
  <body>
     <div class="leftbox">
        <a  onclick="btn()">图书管理</a>
        <a  onclick="btn1()">订单管理</a>
    </div>
    <div class="rightbox" style="display: block" id="rightboxone">
        <table border="1"  cellpadding="70"  cellspacing="0" style="text-align: center">
        <tr>
            <td>id</td>
            <td>书名</td>
            <td>作者</td>
            <td>价格</td>
            <td>标题</td>
            <td>详细介绍</td>
            <td>添加操作</td>
            <td>修改操作</td>
            <td>删除操作</td>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
            <td>${book.bookid }</td>
            <td>${book.name }</td>
            <td>${book.author }</td>
            <td>${book.price }</td>
            <td>${book.title }</td>
            <td>${book.intro }</td>
            <td><a href="./admin/book.html">添加</a></td>
            <td><a href="./admin/book.jsp?bookid=${book.bookid}&name=${book.name}&author=${book.author}&price=${book.price}&title=${book.title}&intro=${book.intro}">修改</a></td>
            <td><a href="/GoodGart/admin?type=delete&bookid=${book.bookid }">删除</a></td>
        </tr>
        </c:forEach>
      </table>
    </div>
    <div class="rightbox" style="display: none" id="rightboxtwo">
    <table border="1"  cellpadding="70"  cellspacing="0" style="text-align: center" width="980px">
     <tr>
             <td>订单号</td>
            <td>购物车id</td>
            <td>用户id</td>
            <td>清算状态(0:未清算；1:已清算)</td>
            <td>下单时间</td>
            <td>修改操作</td>
            <td>删除操作</td>
          </tr>
        <c:forEach items="${orderLists}" var="order">
            <tr>
             <td>${order.orderId }</td>
            <td>${order.carId }</td>
            <td>${order.userId }</td>
            <td>${order.ordertype }</td>
            <td>${order.orderData }</td>
            <td><a href="./admin/order.jsp?orderId=${order.orderId}&carId=${order.carId}&userId=${order.userId}">修改</a></td>
            <td><a href="/GoodGart/admin?type=delete1&orderId=${order.orderId}">删除</a></td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>
