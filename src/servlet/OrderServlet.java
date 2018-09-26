package servlet;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CarList;
import bean.Order;
import bean.OrderList;
import bean.User;
import service.OrderService;
import tool.Message;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	public static String getOrderIdByUUId() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
//         0 代表前面补充0     
//         4 代表长度为4     
//         d 代表参数为正数型
        return  machineId+ String.format("%015d", hashCodeV);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		Message message=new Message();
		OrderService orderService=new OrderService();
		User user=(User)request.getSession().getAttribute("user");
		if(type.equals("attendorder")){
			Order order=new Order();
			order.setOrdertype(0);
			order.setOrderId(getOrderIdByUUId());
			order.setCarId(Integer.parseInt(request.getParameter("carid")));
			order.setUserId(user.getUserId());
			orderService.attendOrder(order);
			getServletContext().getRequestDispatcher("/servlet/CarServlet?type=carshow").forward(request,response);
		}
		if(type.equals("ordershow")){
			List<OrderList> orderLists=orderService.Ordershow(user.getUserId());
			request.setAttribute("orderLists", orderLists);
			if(orderLists==null){
				message.setMessage("列表订单为空！");
				message.setRedirectUrl("/index");
			}else{
				getServletContext().getRequestDispatcher("/book/order.jsp").forward(request,response);
			}
	}
		if(type.equals("update")){
			int result=orderService.update(request.getParameter("orderId"));
			message.setResult(result);
			if(result==1){
				message.setMessage("付款成功！");
			}else{
				message.setMessage("付款失败！");
			}
			message.setRedirectUrl("/GoodGart/servlet/OrderServlet?type=ordershow");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
	    }
		if(type.equals("delete")){
			int result=orderService.delete(request.getParameter("orderId"));
			message.setResult(result);
			if(result==1){
				message.setMessage("删除成功！");
			}else{
				message.setMessage("删除失败！");
			}
			message.setRedirectUrl("/GoodGart/servlet/OrderServlet?type=ordershow");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
	    }
	}
}
