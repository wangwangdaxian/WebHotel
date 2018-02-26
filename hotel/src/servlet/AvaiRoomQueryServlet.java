package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.Room;
import sqlDao.AdministorDao;

/**
 * Servlet implementation class AvaiRoomQueryServlet
 */
@WebServlet("/AvaiRoomQueryServlet")
public class AvaiRoomQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AvaiRoomQueryServlet() {
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
		String roomType=request.getParameter("roomType");
		String message="";
		try {
			AdministorDao admsDao=new AdministorDao();
			ArrayList<Room> roomList=admsDao.findAvaiRoom(roomType);
			if(roomList.size()>0)
				request.getSession().setAttribute("roomList", roomList);
			else message="当前没有可用房间！";
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.setAttribute("msg2", message);
		request.getRequestDispatcher("check_in_pre.jsp").forward(request, response);
		
	}

}
