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
    
    <title>My JSP 'order.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/book/css/mian.css" />
	<script  type="text/javascript">
	window.onload=function (){
	    var div=document.getElementById("liList");
		var ul=div.getElementsByTagName("ul")
		for(var i=1;i<ul.length;i=i+2){
		var li=ul[i].getElementsByTagName("li")
		var a=li[6].getElementsByTagName("a")
		if(li[5].innerHTML=="已结算"){
			a[0].style.backgroundColor="grey";
			a[0].innerHTML="已付款"
		}else{
		    a[0].style.backgroundColor="darkorange";
		}
		}
		}
	</script>
  </head>
  
  <body>
     <div class="content" style="width:1105px">
    <div class="header head_li">
        <img src="<%=basePath%>/book/images/index1.jpg" width="470" height="60">
        <ul >
            <li>订单号</li>
            <li>书名</li>
            <li>总价</li>
            <li>下单时间</li>
            <li>姓名</li>
            <li>订单状态</li>
            <li>点击付款</li>
        </ul>
    </div>
    <div class="mian" id="liList">
    <c:forEach items="${orderLists}" var="orderlist">
        <ul>
            <li style="width:100%">
                <div class="car_nav else">
                    <ul>
                        <li>${orderlist.orderId}</li>
                        <li>${orderlist.bookname}</li>
                        <li>${orderlist.sum}</li>
                        <li>${orderlist.orderData}</li>
                        <li>${orderlist.username}</li>
                        <li>${orderlist.ordertype}</li>
                        <li class="orderlist"><a href="/GoodGart/servlet/OrderServlet?type=update&orderId=${orderlist.orderId}" style="background-color:darkorange">付款</a>
                        <a href="/GoodGart/servlet/OrderServlet?type=delete&orderId=${orderlist.orderId}">删除订单</a></li>
                    </ul>
                </div>
            </li>
        </ul>
        </c:forEach>
    </div>
</div>
  </body>
</html>
