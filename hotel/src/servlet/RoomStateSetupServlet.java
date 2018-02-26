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
 * Servlet implementation class RoomStateSetupServlet
 */
@WebServlet("/RoomStateSetupServlet")
public class RoomStateSetupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomStateSetupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			AdministorDao admsDao=new AdministorDao();
			ArrayList<Room> list=admsDao.findAllRooms();
			request.getSession().setAttribute("allRoomsList", list);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.getRequestDispatcher("ManaRoomControl.jsp").forward(request, response);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String message="";
		String roomId=request.getParameter("roomId");
		String roomState=request.getParameter("roomState");
		try {
			AdministorDao admsDao=new AdministorDao();
			if(admsDao.roomStateSetup(roomId, roomState))message="OK!";
			else message="ERROR!";
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.setAttribute("msg9", message);
		request.getRequestDispatcher("ManaRoomControl.jsp").forward(request, response);
	}

}
