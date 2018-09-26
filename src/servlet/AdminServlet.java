package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.Order;
import bean.OrderList;
import bean.User;
import service.BookService;
import service.OrderService;
import tool.Message;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService=new BookService();
		OrderService orderService=new OrderService();
		Message message=new Message();
		User user=(User)request.getSession().getAttribute("user");
		String type=request.getParameter("type");
		if(type.equals("show")){
		if(user==null){
			getServletContext().getRequestDispatcher("/admin/login.html").forward(request,response);
		}else {
			List<Book> books=bookService.Bookshow();
			List<Order> orderLists=orderService.orders();
			request.setAttribute("orderLists", orderLists);
			request.setAttribute("books", books);
			if(orderLists==null){
				message.setMessage("列表订单为空！");
				message.setRedirectUrl("/index");
			}else{
				getServletContext().getRequestDispatcher("/admin/admin.jsp").forward(request,response);
			}
		 }
		}
		if(type.equals("delete")){
			int result=bookService.delete(Integer.parseInt(request.getParameter("bookid")));
			message.setResult(result);
			if(result==1){
				message.setMessage("删除成功！");
			}else{
				message.setMessage("删除失败！");
			}
			message.setRedirectUrl("/GoodGart/servlet/admin?type=show");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
		}
		if(type.equals("insert")){
			Book book=new Book();
			book.setName(request.getParameter("name"));
			book.setAuthor(request.getParameter("author"));
			book.setPrice(request.getParameter("price"));
			book.setTitle(request.getParameter("title"));
			book.setIntro(request.getParameter("intro"));
			bookService.insert(book);
			getServletContext().getRequestDispatcher("/admin?type=show").forward(request,response);
		}
		if(type.equals("update")){
			int result=bookService.update(Integer.parseInt(request.getParameter("bookid")),
					(request.getParameter("name")),
		    (request.getParameter("author")),
			(request.getParameter("price")),
			(request.getParameter("title")),
		    (request.getParameter("intro")));
			if(result==1){
				message.setMessage("修改成功！");
				getServletContext().getRequestDispatcher("/admin?type=show").forward(request,response);
				return;
			}else{
				message.setMessage("修改失败！");
			}
			message.setRedirectUrl("/GoodGart/servlet/admin?type=show");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
		}
		if(type.equals("update1")){
			int result=orderService.update1(request.getParameter("orderId"),
					(Integer.parseInt(request.getParameter("userId"))),
		    (Integer.parseInt(request.getParameter("carId"))),
			(Integer.parseInt(request.getParameter("ordertype"))));
			if(result==1){
				message.setMessage("修改成功！");
				getServletContext().getRequestDispatcher("/admin?type=show").forward(request,response);
				return;
			}else{
				message.setMessage("修改失败！");
			}
			message.setRedirectUrl("/GoodGart/servlet/admin?type=show");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
		}
		if(type.equals("delete1")){
			int result=orderService.delete(request.getParameter("orderId"));
			message.setResult(result);
			if(result==1){
				message.setMessage("删除成功！");
				getServletContext().getRequestDispatcher("/admin?type=show").forward(request,response);
				return;
			}else{
				message.setMessage("删除失败！");
			}
			message.setRedirectUrl("/GoodGart/servlet/admin?type=show");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
	    }
	}

}
