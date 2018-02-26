package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sqlDao.AdministorDao;

/**
 * Servlet implementation class DelReceServlet
 */
@WebServlet("/DelReceServlet")
public class DelReceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelReceServlet() {
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
		String userId=request.getParameter("userId");
		try {
			AdministorDao admsDao=new AdministorDao();
			if(admsDao.delRece(userId))message="OK!";
			else message="ERROR!";
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.setAttribute("msg8", message);
		request.getRequestDispatcher("ManaReceAccount.jsp").forward(request, response);
	}

}
