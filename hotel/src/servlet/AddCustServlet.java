package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.Customer;
import sqlDao.AdministorDao;

/**
 * Servlet implementation class AddCustServlet
 */
@WebServlet("/AddCustServlet")
public class AddCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustServlet() {
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
		Customer cust=new Customer();
		String message="";
		cust.setUserId(request.getParameter("userId"));
		cust.setName(request.getParameter("name"));
		cust.setPassword(request.getParameter("password"));
		cust.setPhone(request.getParameter("phone"));
		try {
			AdministorDao admsDao=new AdministorDao();
			if(admsDao.addCust(cust)) message="OK!";
			else message="ERROR";
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.setAttribute("msg5", message);
		request.getRequestDispatcher("ManaCustAccount.jsp").forward(request, response);
	}

}
