package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;

@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		AccountBeans ab = (AccountBeans) session.getAttribute("account");

		int accountId = ab.getAccountId();
		int charaLevel = ab.getCharaLevel();
		int charaPoint = ab.getCharaPoint();
		System.out.println(accountId + ":" + charaLevel + ":" + charaPoint);

		request.setAttribute("roomlist", ab);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/room.jsp");
		dispatcher.forward(request, response);
	}
}