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
			path = "/WEB-INF/jsp/recordcheck.jsp";
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

			// ここで Record オブジェクトを作成し accountId をセットして使用
			Record record = new Record (accountId, do_result1, do_result2, do_result3, memo_list1, memo_list2, memo_list3);

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
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/recordcheck.jsp");
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

