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

@WebServlet("/AccountCheck")
public class AccountCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッションからログイン情報を取得
		HttpSession session = request.getSession();
		AccountBeans ab = (AccountBeans) session.getAttribute("account");

		// ロールでフォワード先を振り分ける
		if (ab.getRoleId() == 1) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
			rd.forward(request, response);
		} else if (ab.getRoleId() == 2) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
