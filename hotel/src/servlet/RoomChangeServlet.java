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
 * Servlet implementation class RoomChangeServlet
 */
@WebServlet("/RoomChangeServlet")
public class RoomChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomChangeServlet() {
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
		String oldRoomId=request.getParameter("oldRoomId");
		String newRoomId=request.getParameter("newRoomId");
		String message="";
		try {
			AdministorDao admsDao=new AdministorDao();
			if(admsDao.alterroom(oldRoomId, newRoomId)) message="操作成功！";
			else message="操作失败！";
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}request.setAttribute("msg1", message);
		request.getRequestDispatcher("management.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
