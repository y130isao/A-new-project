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

		RoomBeans rb = new RoomBeans();
		RoomDAO rd = new RoomDAO();
		rd.findRoom(rb);
		System.out.println(rb.getId() + rb.getChara_Level() + rb.getChara_Point());

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/room.jsp");
		dispatcher.forward(request, response);

	}
}