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
 * Servlet implementation class RoomInfoSetupServlet
 */
@WebServlet("/RoomInfoSetupServlet")
public class RoomInfoSetupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomInfoSetupServlet() {
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
		Room r=new Room();
		String message="";
		r.setRoomId(request.getParameter("roomId"));
		r.setRoomType(request.getParameter("roomType"));
		r.setFeature(request.getParameter("feature"));
		r.setOrientation(request.getParameter("orientation"));
		r.setRoomFloor(request.getParameter("roomFloor"));
		r.setRoomState(request.getParameter("roomState"));
		try {
			AdministorDao admsDao=new AdministorDao();
			if(admsDao.roomInfoSetup(r)) message="OK!";
			else message="ERROR!";
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.setAttribute("msg4", message);
		request.getRequestDispatcher("ManaIndex.jsp").forward(request, response);
	}

}
