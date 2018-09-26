package servlet;

import java.io.IOException;

import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import tool.Message;
import tool.PageInformation;
import tool.SearchTool;
import tool.Tool;
import bean.User;

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type=request.getParameter("type1");
		UserService userService=new UserService();
		Message message=new Message();
		if(type.equals("register")){
			User user=new User();
			user.setType(request.getParameter("type"));
			user.setName(request.getParameter("name"));
			user.setPassword(request.getParameter("password"));
			if(user.getType().equals("user"))
				user.setEnable("use");
			else
				user.setEnable("stop");			
			
			int result=userService.register(user);
			message.setResult(result);
			if(result==1){
				message.setMessage("注册成功！");
				message.setRedirectUrl("/news/user/login.html");
			}else if(result==0){
				message.setMessage("同名用户已存在，请改名重新注册！");
				message.setRedirectUrl("/news/user/register.html");
			}else{
				message.setMessage("注册失败！");
				message.setRedirectUrl("/news/user/register.html");
			}
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
		}else if(type.equals("login")){
			User user=new User();
			user.setName(request.getParameter("name"));
			user.setPassword(request.getParameter("password"));
			User user2=userService.login(user);
			if(user2!=null){
				request.getSession().setAttribute("user", user2);
				getServletContext().getRequestDispatcher("/index").forward(request,response);
				return;
			}else {
				message.setMessage("出现其它错误，请重新登录！");
				message.setRedirectUrl("/GoodGart/user/login.html");
			}
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
		}else if(type.equals("adminlogin")){
			User user=new User();
			user.setName(request.getParameter("name"));
			user.setPassword(request.getParameter("password"));
			User user2=userService.login(user);
			if(user2!=null&&user2.getType().equals("manager")){
				request.getSession().setAttribute("user", user2);
				getServletContext().getRequestDispatcher("/admin?type=show").forward(request,response);
				return;
			}else {
				message.setMessage("出现其它错误，请重新登录！");
				message.setRedirectUrl("/GoodGart/admin/login.html");
			}
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/message.jsp").forward(request,response);
		}else if(type.equals("showPage")){
			PageInformation pageInformation=new PageInformation();
			Tool.getPageInformation("user", request, pageInformation);
			List<User> users=userService.getOnePage(pageInformation);
			request.setAttribute("pageInformation", pageInformation);
			request.setAttribute("users", users);
			getServletContext().getRequestDispatcher("/manager/userShow.jsp").forward(request,response);
		}else if(type.equals("search")){
			PageInformation pageInformation=new PageInformation();
			Tool.getPageInformation("user", request, pageInformation);
			pageInformation.setSearchSql(SearchTool.user(request));
			List<User> users=userService.getOnePage(pageInformation);
			request.setAttribute("pageInformation", pageInformation);
			request.setAttribute("users", users);
			getServletContext().getRequestDispatcher("/manager/userShow.jsp").forward(request,response);
		}else if(type.equals("check")){
			PageInformation pageInformation=new PageInformation();
			Tool.getPageInformation("user", request, pageInformation);
			String id=pageInformation.getIds();
			pageInformation.setIds(null);
			List<User> users=userService.check(pageInformation, id);			
			if(users==null){
				message.setMessage("切换可用性失败，请联系管理员！");
				message.setRedirectUrl("/news/servlet/UserServlet?type1=check&page=1&pageSize=2");
			}else{
				request.setAttribute("pageInformation", pageInformation);
				request.setAttribute("users", users);
				getServletContext().getRequestDispatcher("/manager/userCheck.jsp").forward(request,response);
			}
		}else if(type.equals("delete")){
			PageInformation pageInformation=new PageInformation();
			Tool.getPageInformation("user", request, pageInformation);
			pageInformation.setSearchSql(" (type='user' or type='newsAuthor')");
			List<User> users=userService.deletes(pageInformation);
			request.setAttribute("pageInformation", pageInformation);
			request.setAttribute("users", users);
			getServletContext().getRequestDispatcher("/manager/userDelete.jsp").forward(request,response);
		}else if(type.equals("changePassword")){
			String oldPassword=request.getParameter("oldPassword");
			String newPassword=request.getParameter("newPassword");
			//List<User> users=userService.deletes(pageInformation);
			//request.setAttribute("pageInformation", pageInformation);
			//request.setAttribute("users", users);
			//getServletContext().getRequestDispatcher("/manager/userDelete.jsp").forward(request,response);
		}
			
	}
	
	

}
