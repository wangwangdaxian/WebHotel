package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javaBean.AdvanceOrder;
import javaBean.Customer;
import javaBean.OrderForm;
import sqlDao.AdministorDao;

/**
 * Servlet implementation class CustTotalOrderServlet
 */
@WebServlet("/CustTotalOrderServlet")
public class CustTotalOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustTotalOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String orderType=request.getParameter("orderType");
		Customer cust=(Customer) request.getSession().getAttribute("cust");
		try {
			AdministorDao admsDao=new AdministorDao();
			if(orderType.equals("ao")) {
				ArrayList<AdvanceOrder> aoList=admsDao.searAllAo(cust.getUserId());
				request.setAttribute("OrderList",aoList);
				request.setAttribute("orderType", "ao");	
			}else {
				ArrayList<OrderForm> ofList=admsDao.searAllOf(cust.getUserId());
				request.setAttribute("OrderList", ofList);
				request.setAttribute("orderType", "of");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}request.getRequestDispatcher("Order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
