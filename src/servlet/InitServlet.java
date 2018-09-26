package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import Dao.DBConnection;

public class InitServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
		//初始化数据库参数
		DBConnection.drv = this.getServletContext().getInitParameter("drv");
		DBConnection.url = this.getServletContext().getInitParameter("url");
		DBConnection.usr = this.getServletContext().getInitParameter("usr");
		DBConnection.pwd = this.getServletContext().getInitParameter("pwd");
	}

}
