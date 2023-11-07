package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import dao.AccountDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;
import model.PointLogic;

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

		// 検索したアカウント情報を取得
		AccountDAO ad = new AccountDAO();
		AccountBeans returnAb = ad.findAccount(ab);

		/** 最終更新日時の取得*/
		AccountBeans rBeans = ad.findTime(returnAb);
		Timestamp timeStamp = rBeans.getDateTime();
		if (timeStamp != null) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			long diff = timestamp.getTime() - timeStamp.getTime();
			TimeUnit time = TimeUnit.DAYS;
			long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);

			System.out.println("現在日時 : " + timestamp);
			System.out.println("最終更新日時 : " + timeStamp);
			System.out.println(diffrence);

			/**　更新無し時のpoint+level処理*/
			if (diffrence >= 10) {
				PointLogic ptLogic = new PointLogic();
				ptLogic.decreasePoint(returnAb);
				int charaPoint = returnAb.getCharaPoint();
				int charaLevel = returnAb.getCharaLevel();
				ad.setPram(returnAb);
			}
		} else {
			System.out.println("更新時間は未登録です");
		}

		if (returnAb.getName() != null) {
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
