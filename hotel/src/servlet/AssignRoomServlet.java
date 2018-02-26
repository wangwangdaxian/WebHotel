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
 * Servlet implementation class AssignRoomServlet
 */
@WebServlet("/AssignRoomServlet")
public class AssignRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignRoomServlet() {
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
		String orderID=request.getParameter("AdOrId");
		String roomID=request.getParameter("roomId");
		Administor adms=(Administor) request.getSession().getAttribute("rece");
		String admsID=adms.getUserId();
		String message="";
		try {
			AdministorDao admsDao=new AdministorDao();
			if(admsDao.assignRoom(orderID, roomID, admsID)) message="入住成功！";
			else message="入住失败请重试！";
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.setAttribute("msg3", message);
		request.getRequestDispatcher("check_in_pre.jsp").forward(request, response);
	}

}
