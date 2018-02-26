package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.AdvanceOrder;
import javaBean.Customer;
import sqlDao.CustomerDao;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String inDate=request.getParameter("inDate");
		String outDate=request.getParameter("outDate");
		String roomType=request.getParameter("roomType");
		String message="";
		boolean flag=false;
		Customer cust=(Customer)request.getSession().getAttribute("cust");
		String custId=cust.getUserId();
		AdvanceOrder ao=new AdvanceOrder();
		ao.setCustId(custId);
		ao.setInDate(inDate);
		ao.setOutDate(outDate);
		ao.setRoomType(roomType);
		try {
			CustomerDao custDao=new CustomerDao();
			flag=custDao.book(ao);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(flag) message="Booking Success!";
		else message="Booking Error!";
		request.setAttribute("msg3", message);
		request.getRequestDispatcher("Booking.jsp").forward(request, response);
	}

}
