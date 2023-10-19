package servlet;

import java.io.IOException;

import dao.RoomDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.RoomBeans;

@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		//ルーム情報の取得
		RoomDAO dao = new RoomDAO();
		RoomBeans room = new RoomBeans();
		room = dao.findRoom();
		request.setAttribute("room", room);
		System.out.println(room);

		//セッションにルーム情報を登録
		HttpSession session = request.getSession();
		session.setAttribute("room", room);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/room.jsp");
		dispatcher.forward(request, response);

	}
}