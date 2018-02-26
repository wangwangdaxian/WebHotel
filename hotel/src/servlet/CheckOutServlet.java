package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.Administor;
import javaBean.Check;
import sqlDao.AdministorDao;

/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOutServlet() {
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
		Administor adms=(Administor) request.getSession().getAttribute("rece");
		String roomId=request.getParameter("roomId");
		try {
			AdministorDao admsDao=new AdministorDao();
			Check ch=admsDao.checkOut(roomId);
			ch.setAdmsName(adms.getName());
			request.setAttribute("check",ch );
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}request.getRequestDispatcher("check_out.jsp").forward(request, response);
	}

}
