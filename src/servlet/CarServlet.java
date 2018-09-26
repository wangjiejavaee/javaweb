package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.Car;
import bean.CarList;
import bean.User;
import service.BookService;
import service.CarService;
import tool.Message;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		Message message=new Message();
		CarService carService=new CarService();
		User user=(User)request.getSession().getAttribute("user");
		if(type.equals("attendcar")){
		Car car=new Car();
		car.setBookid(request.getParameter("bookid"));
		car.setNumber(request.getParameter("number"));
		car.setUserId(user.getUserId());
		carService.attendCar(car);
		getServletContext().getRequestDispatcher("/index").forward(request,response);
		}
		if(type.equals("carshow")){
			List<CarList> carLists=carService.Carshow(user.getUserId());
			request.setAttribute("carLists", carLists);
			if(carLists==null){
				message.setMessage("购物车为空！");
				message.setRedirectUrl("/index");
			}else{
				getServletContext().getRequestDispatcher("/book/car.jsp").forward(request,response);
			}
	    }
		if(type.equals("delete")){
			int result=carService.delete(Integer.parseInt(request.getParameter("carid")));
			message.setResult(result);
			if(result==1){
				message.setMessage("删除成功！");
			}else{
				message.setMessage("删除失败！");
			}
			message.setRedirectUrl("/GoodGart/servlet/CarServlet?type=carshow");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
	    }
		if(type.equals("update")){
			int result=carService.update(Integer.parseInt(request.getParameter("carid")),Integer.parseInt(request.getParameter("number")));
			message.setResult(result);
			if(result==1){
				message.setMessage("修改成功！");
			}else{
				message.setMessage("修改失败！");
			}
			message.setRedirectUrl("/GoodGart/servlet/CarServlet?type=carshow");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
	    }
		if(type.equals("deletes")){
			int result=carService.deletes(user.getUserId());
			message.setResult(result);
			if(result!=-1){
				message.setMessage("删除成功！");
			}else{
				message.setMessage("删除失败！");
			}
			message.setRedirectUrl("/GoodGart/servlet/CarServlet?type=carshow");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
	    }
	}
}
