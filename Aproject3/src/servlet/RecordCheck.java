package servlet;

import java.io.IOException;
import java.util.List;

import dao.RecordDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;
import model.GetRecordListLogic;
import model.Record;

@WebServlet("/RecordCheck")
public class RecordCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = null;
		String mode = request.getParameter("mode");
		if (mode == null || mode.equals("back")) {
			path = "/WEB-INF/jsp/record.jsp";
		} else {
			path = "/WEB-INF/jsp/recordcomplete.jsp";
			HttpSession session = request.getSession();
			session.invalidate();
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");

		String doResult1Value = request.getParameter("do_result1");
		String doResult2Value = request.getParameter("do_result2");
		String doResult3Value = request.getParameter("do_result3");

		// 1がtrue、0がfalseに変換
		boolean do_result1 = "1".equals(doResult1Value);
		boolean do_result2 = "1".equals(doResult2Value);
		boolean do_result3 = "1".equals(doResult3Value);

		String memo_list1 = request.getParameter("memo_list1");
		String memo_list2 = request.getParameter("memo_list2");
		String memo_list3 = request.getParameter("memo_list3");
		
		
//		String goalgenre1 = request.getParameter("goalList.get(0).getGoalgenre1()");
//		String goalgenre2 = request.getParameter("goalList.get(0).getGoalgenre2()");
//		String goalgenre3 = request.getParameter("goalList.get(0).getGoalgenre3()");
//		String goal1 = request.getParameter("goalList.get(0).getGoal1()");
//		String goal2 = request.getParameter("goalList.get(0).getGoal2()");
//		String goal3 = request.getParameter("goalList.get(0).getGoal3()");		

		//セッションスコープに保存されたアカウント情報を取得(AccountCheck.java)
		HttpSession session = request.getSession();
		AccountBeans account = (AccountBeans) session.getAttribute("account");
		
		List<model.Goal> goalList = (List<model.Goal>) session.getAttribute("goalList");


		// アカウントがnullでなく、goalListもnullでない場合
		if (account != null) {
			//アカウントIDを取得
			int accountId = account.getAccountId();
			
			//目標リストを取得
			String goalgenre1 = goalList.get(0).getGoalgenre2();
			String goalgenre2 = goalList.get(0).getGoalgenre2();
			String goalgenre3 = goalList.get(0).getGoalgenre3();
			String goal1 = goalList.get(0).getGoal1();
			String goal2 = goalList.get(0).getGoal2();
			String goal3 = goalList.get(0).getGoal3();
			

			// ここで Record オブジェクトを作成し accountId をセットして使用
			Record record = new Record (accountId, do_result1, do_result2, do_result3, memo_list1, memo_list2, memo_list3,goalgenre1, goalgenre2, goalgenre3, goal1, goal2, goal3);

			// Record オブジェクトを使用してデータベースに保存
			RecordDAO recordDAO = new RecordDAO();
			boolean success = recordDAO.create(record, accountId);

			if (success) {
				// データベースへの保存が成功した場合の処理

				//記録リストを取得して、セッションコープに保存
				GetRecordListLogic getRecordListLogic = new GetRecordListLogic();
				List<Record> recordList = getRecordListLogic.execute(accountId);
				session.setAttribute("recordList", recordList);

				// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recordcomplete.jsp");
				dispatcher.forward(request, response);
			}
			else {
				// データベースへの保存が失敗した場合のエラーハンドリング
			}
		} else {
			// ログインしていない場合のエラーハンドリング
			// リダイレクトなど適切な処理を行う
			// (仮)
		}
	}
}

	

//		//リクエストパラメータの取得
//		request.setCharacterEncoding("UTF-8");
//		
//		String doResult1Value = request.getParameter("do_result1");
//	    String doResult2Value = request.getParameter("do_result2");
//	    String doResult3Value = request.getParameter("do_result3");
//
//	    // 1がtrue、0がfalseに変換
//	    boolean do_result1 = "1".equals(doResult1Value);
//	    boolean do_result2 = "1".equals(doResult2Value);
//	    boolean do_result3 = "1".equals(doResult3Value);
//	    
//		String memo_list1 = request.getParameter("memo_list1");
//		String memo_list2 = request.getParameter("memo_list2");
//		String memo_list3 = request.getParameter("memo_list3");
//
//		//セッションスコープに保存されたアカウント情報を取得(AccountCheck.java)
//		HttpSession session = request.getSession();
//		AccountBeans account = (AccountBeans) session.getAttribute("account");
//
//		//アカウントがnullでなければ
//		if (account != null) {
//			//アカウントIDを取得
//			int accountId = account.getAccountId();
//
//			// ここで Record オブジェクトを作成し accountId をセットして使用
//			Record record = new Record (accountId, do_result1, do_result2, do_result3, memo_list1, memo_list2, memo_list3);
//
//			// Record オブジェクトを使用してデータベースに保存
//			RecordDAO recordDAO = new RecordDAO();
//			boolean success = recordDAO.create(record, accountId);
//
//			if (success) {
//				// データベースへの保存が成功した場合の処理
//
//				//記録リストを取得して、セッションコープに保存
//				GetRecordListLogic getRecordListLogic = new GetRecordListLogic();
//				List<Record> recordList = getRecordListLogic.execute(accountId);
//				session.setAttribute("recordList", recordList);
//
//				// フォワード
//				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recordcomplete.jsp");
//				dispatcher.forward(request, response);
//			}
//			else {
//				// データベースへの保存が失敗した場合のエラーハンドリング
//			}
//		} else {
//			// ログインしていない場合のエラーハンドリング
//			// リダイレクトなど適切な処理を行う
//			// (仮)
//		}
//	}
//}
//
