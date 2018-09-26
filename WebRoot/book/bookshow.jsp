<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page language="java" import="bean.Book"%>
<%@ page language="java" import="bean.User"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	User user=(User)request.getSession().getAttribute("user");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/book/css/mian.css" />
	<script  type="text/javascript">
		function inputone(bookid,price) {
		if(bookid==2){
			var div = document.getElementById("attendcar");
			}else if(bookid==9)
			{
		     div = document.getElementById("attendcar1");
			}else if(bookid==10)
			{
		     div = document.getElementById("attendcar2");
			}else if(bookid==11)
			{
		     div = document.getElementById("attendcar3");
			}else if(bookid==12)
			{
		     div = document.getElementById("attendcar4");
			}
			var input = div.getElementsByTagName("input");
			var span = div.getElementsByTagName("span");
			if (span[0].innerHTML != "" && input[1].value != "") {
				var str = "总价:" + parseInt(input[1].value) * price;
				span[0].innerHTML = str;
			} else {
				span[0].innerHTML = "总价:";
			}
		}
	
		function btn(bookid) {
		if(bookid==2){
			var div = document.getElementById("attendcar");
			}else if(bookid==9)
			{
		     div = document.getElementById("attendcar1");
			}else if(bookid==10)
			{
		     div = document.getElementById("attendcar2");
			}else if(bookid==11)
			{
		     div = document.getElementById("attendcar3");
			}else if(bookid==12)
			{
		     div = document.getElementById("attendcar4");
			}
			if (div.style.display == 'block') {
				div.style.display = 'none';
			} else {
				div.style.display = 'block';
			}
	}
		function del(bookid) {
			if(bookid==2){
			var div = document.getElementById("attendcar");
			}else if(bookid==9)
			{
		     div = document.getElementById("attendcar1");
			}else if(bookid==10)
			{
		     div = document.getElementById("attendcar2");
			}else if(bookid==11)
			{
		     div = document.getElementById("attendcar3");
			}else if(bookid==12)
			{
		     div = document.getElementById("attendcar4");
			}
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
   </div>
   <% if(user==null){%>
    <ul class="regist">
        <li><a href="/GoodGart/user/login.html" >登录</a></li>
        <li><a href="/GoodGart/user/register.html" >注册</a></li>
        <li><a href="/GoodGart/admin?type=show">登录后台</a></li>
    </ul>
      <%} %>
      <% if(user!=null){%>
    <ul class="regist">
        <li><a href="/GoodGart/servlet/CarServlet?type=carshow">我的购物车</a></li>
        <li><a href="/GoodGart/servlet/OrderServlet?type=ordershow">我的订单</a></li>
    </ul>
      <%} %>
    <div class="mian">
        <ul>
         <c:forEach items="${books}" var="book">
            <li>
                <a href="#"><img src="<%=basePath%>/book/images/book1.jpg" width="150" height="150"></a>
                <div class="mian_book">
                    <div class="mian_book_intro" >
                        <div class="name">${book.name}</div>
                        <div class="wirte">${book.author}</div>
                        <div class="price">${book.price}</div>
                        <div class="attend"><input type="button" onclick="btn('${book.bookid}');" value="加入购物车" ></div>
                        <div class="book_content" >                   
                            <h3>${book.title}</h3>
                            <span>${book.intro}</span>
                        </div>
                    </div>
                </div>         
            </li>
            
			</c:forEach>
        </ul>
    </div>
</div>
<form action="/GoodGart/servlet/CarServlet?type=attendcar" method="post">
 <div class="attendcar" id="attendcar" style="display: none">
        <img src="<%=basePath%>/book/images/book1.jpg" width="120" height="120" >
        <div class="attendcar_content" >
            <a>加入购物车</a>
            <input type="hidden" value="${books[0].bookid}" name="bookid">
            数量：<input type="text" onchange="inputone('${books[0].bookid}','${books[0].price}')" name="number"><br>
            <span>总价：</span>
            <button onclick="del('${books[0].bookid}')" class="submit">取消</button>
            <input type="submit" value="确认" class="submit submitone"/>
        </div>
        <dl>
            <dt>${books[0].name }</dt>
            <dd>${books[0].author }</dd>
            <dd>${books[0].price }</dd>
        </dl>
     </div>
</form>
<form action="/GoodGart/servlet/CarServlet?type=attendcar" method="post">
        <div class="attendcar" id="attendcar1" style="display: none">
        <img src="<%=basePath%>/book/images/book1.jpg" width="120" height="120" >
        <div class="attendcar_content" >
            <a>加入购物车</a>
            <input type="hidden" value="${books[1].bookid}" name="bookid">
            数量：<input type="text" onchange="inputone('${books[1].bookid}','${books[1].price}')" name="number"><br>
            <span>总价：</span>
            <button onclick="del('${books[1].bookid}')" class="submit">取消</button>
             <input type="submit" class="submit" value="确认" />
        </div>
        <dl>
            <dt>${books[1].name }</dt>
            <dd>${books[1].author }</dd>
             <dd>${books[1].price }</dd>
        </dl>
</div>
</form>
<form action="/GoodGart/servlet/CarServlet?type=attendcar" method="post">
        <div class="attendcar" id="attendcar4" style="display: none">
        <img src="<%=basePath%>/book/images/book1.jpg" width="120" height="120" >
        <div class="attendcar_content" >
            <a>加入购物车</a>
            <input type="hidden" value="${books[4].bookid}" name="bookid">
            数量：<input type="text" onchange="inputone('${books[4].bookid}','${books[4].price}')" name="number"><br>
            <span>总价：</span>
            <button onclick="del('${books[4].bookid}')" class="submit">取消</button>
             <input type="submit" class="submit" value="确认" />
        </div>
        <dl>
            <dt>${books[4].name }</dt>
            <dd>${books[4].author }</dd>
             <dd>${books[4].price }</dd>
        </dl>
</div>
</form>
<form action="/GoodGart/servlet/CarServlet?type=attendcar" method="post">
        <div class="attendcar" id="attendcar2" style="display: none">
        <img src="<%=basePath%>/book/images/book1.jpg" width="120" height="120" >
        <div class="attendcar_content" >
            <a>加入购物车</a>
            <input type="hidden" value="${books[2].bookid}" name="bookid">
            数量：<input type="text" onchange="inputone('${books[2].bookid}','${books[2].price}')" name="number"><br>
            <span>总价：</span>
            <button onclick="del('${books[2].bookid}')" class="submit">取消</button>
             <input type="submit" class="submit" value="确认" />
        </div>
        <dl>
            <dt>${books[2].name }</dt>
            <dd>${books[2].author }</dd>
             <dd>${books[2].price }</dd>
        </dl>
</div>
</form>
<form action="/GoodGart/servlet/CarServlet?type=attendcar" method="post">
        <div class="attendcar" id="attendcar3" style="display: none">
        <img src="<%=basePath%>/book/images/book1.jpg" width="120" height="120" >
        <div class="attendcar_content" >
            <a>加入购物车</a>
            <input type="hidden" value="${books[3].bookid}" name="bookid">
            数量：<input type="text" onchange="inputone('${books[3].bookid}','${books[3].price}')" name="number"><br>
            <span>总价：</span>
            <button onclick="del('${books[3].bookid}')" class="submit">取消</button>
             <input type="submit" class="submit" value="确认" />
        </div>
        <dl>
            <dt>${books[3].name }</dt>
            <dd>${books[3].author }</dd>
             <dd>${books[3].price }</dd>
        </dl>
</div>
</form>
  </body>
</html>

