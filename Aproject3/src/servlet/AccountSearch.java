package servlet;

import java.io.IOException;

import dao.AccountDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;

@WebServlet("/AccountSearch")
public class AccountSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String pass = request.getParameter("pass");

		// login.jspから受け取ったログインIDとpassをビーンズにセット
		AccountBeans ab = new AccountBeans();
		ab.setLoginId(loginId);
		ab.setPass(pass);

		// 最終登録日を取得
//		RecordBeans rBeans = new RecordBeans();
//		RecordCheckDAO dao =new RecordCheckDAO();
//		RecordBeans rb = dao.findRecordBeans(rBeans);
//		LocalDate now = LocalDate.now();
//		LocalDate recordDate = rb.getToday();
//		recordDate = now.plusDays(10);
//		if(now.isBefore(recordDate)) {
//			PointLogic pl = new PointLogic();
//			pl.decreasePoint();
//		}
		
		// 検索したアカウント情報を取得
		AccountDAO ad = new AccountDAO();
		AccountBeans returnAb = ad.findAccount(ab);
		int accountId = returnAb.getAccountId();
		AccountBeans rBeans = ad.findTime(accountId);
		System.out.println(rBeans.getDateTime());
			
		if (returnAb != null) {
			// セッションにアカウント情報を登録
			HttpSession session = request.getSession();
			session.setAttribute("account", returnAb);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			rd.forward(request, response);
		}
	}
}
