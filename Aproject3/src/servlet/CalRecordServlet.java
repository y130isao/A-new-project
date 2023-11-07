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
import model.GetRecordListLogic;

@WebServlet("/CalRecordServlet")
public class CalRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	       request.setCharacterEncoding("UTF-8");
	        String goalgenre1 = request.getParameter("goalgenre1");
	        String goalgenre2 = request.getParameter("goalgenre2");
	        String goalgenre3 = request.getParameter("goalgenre3");
	        String goal1 = request.getParameter("goal1");
	        String goal2 = request.getParameter("goal2");
	        String goal3 = request.getParameter("goal3");
			boolean do_result1 = request.getParameter("do_result1") != null;
			boolean do_result2 = request.getParameter("do_result2") != null;
			boolean do_result3 = request.getParameter("do_result3") != null;
			String memo_list1 = request.getParameter("memo_list1");
			String memo_list2 = request.getParameter("memo_list2");
			String memo_list3 = request.getParameter("memo_list3");

		//セッションスコープに保存されたアカウント情報を取得(AccountCheck.java)
		HttpSession session = request.getSession();
		AccountBeans account = (AccountBeans) session.getAttribute("account");

		//アカウントがnullでなければ
		if (account != null) {
			//アカウントIDを取得
			int accountId = account.getAccountId();
			
			// ここで CalRecord オブジェクトを作成し accountId をセットして使用
			CalRecord calrecord = new CalRecord (accountId, goalgenre1, goalgenre2, goalgenre3, goal1, goal2, goal3, do_result1, do_result2, do_result3, memo_list1, memo_list2, memo_list3);
		
				// カレンダー記録リストを取得して、セッションコープに保存
			GetRecordListLogic getCalRecordListtLogic = new GetRecordListLogic();
            	List<CalRecord> calrecordList = getCalRecordListtLogic.execute(accountId);
				session.setAttribute("CalRecordList", calrecordList);

				// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calrecord.jsp");
				dispatcher.forward(request, response);
			}
		}
}