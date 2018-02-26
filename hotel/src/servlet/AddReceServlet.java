package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.Administor;
import sqlDao.AdministorDao;

/**
 * Servlet implementation class AddReceServlet
 */
@WebServlet("/AddReceServlet")
public class AddReceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReceServlet() {
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
		Administor adms=new Administor();
		String message="";
		adms.setUserId(request.getParameter("userId"));
		adms.setName(request.getParameter("name"));
		adms.setPassword(request.getParameter("password"));
		try {
			AdministorDao admsDao=new AdministorDao();
			if(admsDao.addRece(adms))message="OK!";
			else message="ERROR!";
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.setAttribute("msg7", message);
		request.getRequestDispatcher("ManaReceAccount.jsp").forward(request, response);
	
	}

}
