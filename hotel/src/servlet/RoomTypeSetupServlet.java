package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.Room;
import sqlDao.AdministorDao;

/**
 * Servlet implementation class RoomTypeSetupServlet
 */
@WebServlet("/RoomTypeSetupServlet")
public class RoomTypeSetupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomTypeSetupServlet() {
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
		Room room=new Room();
		String message="";
		room.setRoomType(request.getParameter("roomType"));
		room.setRoomPrice(request.getParameter("roomPrice"));
		try {
			AdministorDao admsDao=new AdministorDao();
			if(admsDao.roomTypeSetup(room)) message="OK!";
			else message="ERROR!";
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.setAttribute("msg3", message);
		request.getRequestDispatcher("ManaIndex.jsp").forward(request, response);
	}

}
