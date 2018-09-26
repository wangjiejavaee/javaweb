package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {//检查是否登录			
			System.out.println("已检查");
			chain.doFilter(request, response);	//传给下个filter处理		
		} else {//没登录
			String originalUrl=req.getRequestURI();//获取用户请求的原始网址
			req.getSession().setAttribute("originalUrl", originalUrl);//保存原始网址到session
			String aa=(String)req.getSession().getAttribute("originalUrl");		
			res.sendRedirect("/user/login.html");//跳转到登录网页，至此中断了过滤链
		}
		System.out.println("after SecurityFilter");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
