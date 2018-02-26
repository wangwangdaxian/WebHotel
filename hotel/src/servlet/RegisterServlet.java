package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.Customer;
import sqlDao.CustomerDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String message="";
		Customer cust=new Customer();
		cust.setName(request.getParameter("username"));
		cust.setUserId(request.getParameter("userId"));
		cust.setPassword(request.getParameter("password"));
		cust.setPhone(request.getParameter("phone"));
		try {
			CustomerDao custDao = new CustomerDao();
			if(custDao.isNew(cust.getUserId())) {
				if(custDao.register(cust)) {
					message="Register Success!Please Login!";
					request.setAttribute("msg", message);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}else {
					message="Register Error!";
					request.setAttribute("msg2", message);
					request.getRequestDispatcher("Register.jsp").forward(request, response);
				}
			}else {
				message="Acount Repetition!";
				request.setAttribute("msg2", message);
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
