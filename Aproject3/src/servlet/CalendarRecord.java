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
import model.GetRecordListLogic;
import model.Goal;
import model.Record;

@WebServlet("/CalendarRecord")
public class CalendarRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッションスコープに保存されたアカウント情報を取得(AccountCheck.java)
		HttpSession session = request.getSession();
		AccountBeans account = (AccountBeans) session.getAttribute("account");

		//アカウントがnullでなければ
		if (account != null) {
			//アカウントIDを取得
			int accountId = account.getAccountId();
		
				// 目標リストを取得して、セッションコープに保存
            	GetGoalListLogic getGoalListLogic = new GetGoalListLogic();
            	List<Goal> goalList = getGoalListLogic.execute(accountId);
				session.setAttribute("CalendarList", goalList);
				
				//記録リストを取得して、セッションコープに保存
				GetRecordListLogic getRecordListLogic = new GetRecordListLogic();
				List<Record> recordList = getRecordListLogic.execute(accountId);
				session.setAttribute("CalendarList", recordList);

				// リクエストパラメータから日付を取得
				request.setCharacterEncoding("UTF-8");
				String clickDate = request.getParameter("clickDate"); 

				// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recordcheck.jsp");
				dispatcher.forward(request, response);
			}
		}
}