package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.Administor;
import javaBean.AdvanceOrder;
import javaBean.Customer;
import sqlDao.AdministorDao;
import sqlDao.CustomerDao;

/**
 * Servlet implementation class IndividualCustServlet
 */
@WebServlet("/IndividualCustServlet")
public class IndividualCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndividualCustServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userId=request.getParameter("userId");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String inDate=request.getParameter("inDate");
		String outDate=request.getParameter("outDate");
		String roomType=request.getParameter("roomType");
		String roomId=request.getParameter("roomId");
		Customer cust=new Customer();
		cust.setUserId(userId);
		cust.setName(username);
		cust.setPassword(password);
		cust.setPhone(phone);
		Administor adms=(Administor) request.getSession().getAttribute("rece");
		String admsID=adms.getUserId();
		String message="";
		try {
			CustomerDao custDao=new CustomerDao();
			if(custDao.isNew(userId)){
				custDao.register(cust);
				AdvanceOrder ao=new AdvanceOrder();
				ao.setCustId(userId);
				ao.setInDate(inDate);
				ao.setOutDate(outDate);
				ao.setRoomType(roomType);
				custDao.book(ao);
				SimpleDateFormat ft=new SimpleDateFormat("yyyyMMdd");
				String date=ft.format(new Date());
				String N=custDao.aoNum(date);
				int n=Integer.parseInt(N)-1;
				String orderId=date+String.format("%03d",n);
				AdministorDao admsDao=new AdministorDao();
				if(admsDao.assignRoom(orderId, roomId, admsID))
					message="入住成功！";
				else message="入住失败!";
			}else message="账号已存在！";
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}request.setAttribute("message", message);
		request.getRequestDispatcher("check_in_cur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
