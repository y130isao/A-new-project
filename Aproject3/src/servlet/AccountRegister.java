package servlet;

import java.io.IOException;

import dao.AccountRegisterDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;

/**
 * Servlet implementation class AccountRegister
 */
@WebServlet("/AccountRegister")
public class AccountRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String loginId = request.getParameter("loginId");
		String pass = request.getParameter("pass");
		int roleId = Integer.parseInt(request.getParameter("roleId"));
		int genId = Integer.parseInt(request.getParameter("genId"));
		// register.jspから受け取った値をビーンズにセット
		AccountBeans ab = new AccountBeans();
		ab.setName(name);
		ab.setLoginId(loginId);
		ab.setPass(pass);
		ab.setRoleId(roleId);
		ab.setGenId(genId);

		// セッションにアカウント情報を保存
		HttpSession session = request.getSession();
		session.setAttribute("account", ab);

		// アカウントをDBに登録
		AccountRegisterDAO ard = new AccountRegisterDAO();
		ard.create(ab);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/registerSuccess.jsp");
		rd.forward(request, response);

	}

	//    
}
