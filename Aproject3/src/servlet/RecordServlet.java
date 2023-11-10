package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;
import model.GetGoalListLogic;
import model.Goal;

@WebServlet("/RecordServlet")
public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		//セッションスコープに保存されたアカウント情報を取得(AccountCheck.java)
		HttpSession session = request.getSession();
		AccountBeans account = (AccountBeans) session.getAttribute("account");
		//アカウントがnullでなければ
		if (account != null) {

			//アカウントIDを取得
			int accountId = account.getAccountId();

			//データベースから目標リストを取得
			GetGoalListLogic getGoalListLogic = new GetGoalListLogic();
			List<Goal> goalList = getGoalListLogic.execute(accountId);

			//セッションコープに保存
			session.setAttribute("goalList", goalList);

			//フォワード
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/record.jsp");
			rd.forward(request, response);

		} else {

		}
	}

}
