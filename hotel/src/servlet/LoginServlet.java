package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.*;
import sqlDao.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String usertype=request.getParameter("usertype");
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		String message="";
		if(usertype.equals("customer")) {
			try {
				CustomerDao custDao = new CustomerDao();
				if(custDao.verify(userId,password)) {
					//用户登陆成功
					Customer cust=custDao.findCust(userId);
					request.getSession().setAttribute("cust", cust);
					response.sendRedirect("/hotel/index.jsp");
					}
				else {
					message="Password Error!Please Try Again!";
					request.setAttribute("msg", message);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}else {
			try {
				AdministorDao admsDao = new AdministorDao();
				if(admsDao.verify(userId,password)) {
					//管理员登陆成功
					Administor adms=admsDao.findAdms(userId);
					if(usertype.equals("manager")) {
						if(adms.getUserId().equals("330501199603167224")) {
							request.getSession().setAttribute("mana", adms);
							response.sendRedirect("/hotel/ManaIndex.jsp");
						}else {
							message="Password Error!Please Try Again!";
							request.setAttribute("msg", message);
							request.getRequestDispatcher("index.jsp").forward(request, response);
						}
					}else { 
						request.getSession().setAttribute("rece", adms);
						response.sendRedirect("/hotel/Receindex.jsp");
					}
				}else {
					message="Password Error!Please Try Again!";
					request.setAttribute("msg", message);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

}
