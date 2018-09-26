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
    
    <title>购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/book/css/mian.css" />
	<script  type="text/javascript">
		function inputone(price) {
			var div = document.getElementById("attendcar");
			var input = div.getElementsByTagName("input");
			var span = div.getElementsByTagName("span");
			if (span[0].innerHTML != "" && input[1].value != "") {
				var str = "总价:" + parseInt(input[1].value) * price;
				span[0].innerHTML = str;
			} else {
				span[0].innerHTML = "总价:";
			}
		}
	
		function btn() {
			var div = document.getElementById("attendcar");
			if (div.style.display == 'block') {
				div.style.display = 'none';
			} else {
				div.style.display = 'block';
			}
	   }
		function del() {
			var div = document.getElementById("attendcar");
			if (div.style.display == 'block') {
				div.style.display = 'none';
			} else {
				div.style.display = 'block';
			}
		}
	</script>

  </head>
  
  <body>
    <div class="content">
    <div class="header">
        <img src="<%=basePath%>/book/images/index1.jpg" width="470" height="60">
        <ul >
            <li>书籍</li>
            <li>书名</li>
            <li>价格</li>
            <li>数量</li>
            <li>总价</li>
            <li>姓名</li>
            <li>订单详情</li>
        </ul>
    </div>
    <ul class="regist" style="margin-top:-30px">
        <li><a href="/GoodGart/servlet/OrderServlet?type=ordershow" >订单列表</a></li>
        <li><a href="/GoodGart/servlet/CarServlet?type=deletes" >全部清除</a></li>
    </ul>
    <div class="mian">
    <c:forEach items="${carLists}" var="carlist">
        <ul>
            <li ><img src="<%=basePath%>/book/images/book1.jpg" width="120" height="120">
                <div class="car_nav">
                    <ul>
                        <li>${carlist.bookname}</li>
                        <li>${carlist.price}</li>
                        <li>${carlist.number}</li>
                        <li>${carlist.sum}</li>
                        <li>${carlist.username}</li>
                        <li style="border-right:none"><a href="/GoodGart/servlet/OrderServlet?type=attendorder&carid=${carlist.carid}">添加订单</a></li>
                    </ul>
                </div>
                 <div class="edit">
                 		<a onclick="btn()" style="margin-bottom:10px">修改订单</a>
                 		<a href="/GoodGart/servlet/CarServlet?type=delete&carid=${carlist.carid}">删除订单</a>
                 </div>
            </li>
        </ul>
 <form action="/GoodGart/servlet/CarServlet?type=update" method="post">
   <div class="attendcar" id="attendcar" style="display: none">
        <div class="attendcar_content" >
            <a>修改购物车</a>
            <input type="hidden" value="${carlist.carid}" name="carid">
            数量：<input type="text" onchange="inputone('${carlist.price}')" value="${carlist.number}" name="number"><br>
            <span>总价：</span>
            <button onclick="del()" class="submit">取消</button>
            <input type="submit" value="确认" class="submit submitone"/>
        </div>
     </div>
</form>
        </c:forEach>
    </div>
</div>

  </body>
</html>
