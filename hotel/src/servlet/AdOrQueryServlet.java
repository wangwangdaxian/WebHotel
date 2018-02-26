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
import sqlDao.AdministorDao;

/**
 * Servlet implementation class AdOrQueryServlet
 */
@WebServlet("/AdOrQueryServlet")
public class AdOrQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdOrQueryServlet() {
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
		String userId=request.getParameter("userId");
		String message="";
		try {
			AdministorDao admsDao=new AdministorDao();
			ArrayList<AdvanceOrder> list=admsDao.findAdOr(userId);
			if(list.size()>0) {
				request.getSession().setAttribute("AdOrList", list);
			}else {
				message="未找到该用户今日的预订单！";
			}
				
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.setAttribute("msg1", message);
		request.getRequestDispatcher("check_in_pre.jsp").forward(request, response);	
	}

}
