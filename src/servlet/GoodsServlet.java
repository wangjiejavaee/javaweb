package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.GoodsList;
import bean.addgoodcar;
import bean.Good;

@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
		 * Constructor of the object.
		 */
	public GoodsServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsList goodslist=null;
		Good good=null;
		String type=request.getParameter("types");
		if("showGoods".equals(type)){
			goodslist=(GoodsList)this.getServletContext().getAttribute("Goodslist");
			request.setAttribute("goods",goodslist);
			request.getRequestDispatcher("GoodsList.jsp").forward(request, response);
		}else if ("addCart".equals(type)) {	
			String nameString=request.getParameter("goodname");
			goodslist=(GoodsList)this.getServletContext().getAttribute("Goodslist");
			if((addgoodcar)this.getServletContext().getAttribute("GoodCars")==null){
				addgoodcar goodcar=new addgoodcar();
				for (int i = 0; i < goodslist.getgoodlist().size(); i++) {
					if(goodslist.getgoodlist().get(i).getName().equals(nameString))
					{	
						good=goodslist.getgoodlist().get(i);
						goodcar.addgood(good);
						int number=goodcar.getgoodlist().getgoodlist().get(i).getNumber();
						goodcar.getgoodlist().getgoodlist().get(i).setNumber(number+1);
					}
				}
				this.getServletContext().setAttribute("GoodCars", goodcar);	
			}else{
				int i=0;
				addgoodcar goodcar=null;
				goodcar=(addgoodcar)this.getServletContext().getAttribute("GoodCars");	
				for ( ; i < goodcar.getgoodlist().getgoodlist().size(); i++) {
					String name=goodcar.getgoodlist().getgoodlist().get(i).getName();
					if(name.equals(nameString))
					{	
						int number=goodcar.getgoodlist().getgoodlist().get(i).getNumber();
						goodcar.getgoodlist().getgoodlist().get(i).setNumber(number+1);
						break;
					}			
				}	
				if(i==(goodcar.getgoodlist().getgoodlist().size())){
					for ( i = 0; i < goodslist.getgoodlist().size(); i++) {
						if(goodslist.getgoodlist().get(i).getName().equals(nameString))
						{	
							good=goodslist.getgoodlist().get(i);
							goodcar.addgood(good);
							int number=goodcar.getgoodlist().getgoodlist().get(i).getNumber();
							goodcar.getgoodlist().getgoodlist().get(i).setNumber(number+1);
						}
					}
				}
			}	
			request.setAttribute("goods",goodslist);		
			request.getRequestDispatcher("GoodsList.jsp").forward(request, response);
		}else {
			PrintWriter out=response.getWriter();
			if((addgoodcar)this.getServletContext().getAttribute("GoodCars")==null){
				//addgoodcar goodcar=new addgoodcar();				
				out.print("购物车为空");	
				out.println("<br>"+"<a href='index.jsp?'>"+"返回"+"</a>");
			}else{
				addgoodcar goodcars=new addgoodcar();
				goodcars=(addgoodcar)this.getServletContext().getAttribute("GoodCars");
				goodslist=goodcars.getgoodlist();
				int sumprice=goodcars.getsumprice(goodslist);
				request.setAttribute("goods",goodslist);
				request.setAttribute("sumprices",sumprice);	
				request.getRequestDispatcher("GoodCarList.jsp").forward(request, response);			
			}
		}
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		GoodsList goodslist=new GoodsList();
		Good good=new Good(getServletContext().getInitParameter("GoodsOneName"),
				Integer.parseInt(getServletContext().getInitParameter("GoodsOnePrice")),
				Integer.parseInt(getServletContext().getInitParameter("GoodsOneNumber")));
		goodslist.addgoods(good);
		//good=goodslist.initGood(
		Good good1=new Good(getServletContext().getInitParameter("GoodsTwoName"),
				Integer.parseInt(getServletContext().getInitParameter("GoodsTwoPrice")),
				Integer.parseInt(getServletContext().getInitParameter("GoodsTwoNumber")));
		goodslist.addgoods(good1);
		Good good2=new Good(getServletContext().getInitParameter("GoodsThreeName"),
				Integer.parseInt(getServletContext().getInitParameter("GoodsThreePrice")),
				Integer.parseInt(getServletContext().getInitParameter("GoodsThreeNumber")));
		goodslist.addgoods(good2);
		this.getServletContext().setAttribute("Goodslist", goodslist);
	}
}

