package servlet;

import java.io.IOException;

import dao.RoomDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.RoomBeans;

@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		//ルーム情報の取得
		RoomBeans rb = new RoomBeans();
		RoomDAO dao = new RoomDAO();
		rb = dao.findRoom();
		String id = rb.getId();
		String chara_level = rb.getChara_Level();
		String chara_point = rb.getChara_Point();
		System.out.println(id + chara_level + chara_point);
		

		request.setAttribute("roomlist", rb);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/room.jsp");
		dispatcher.forward(request, response);

	}
}