package servlet;

import java.io.IOException;

import dao.RecordCheckDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.RecordBeans;

@WebServlet("/RecordComplete")
public class RecordComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean do_result1 = request.getParameter("do_result1") != null;
		boolean do_result2 = request.getParameter("do_result2") != null;
		boolean do_result3 = request.getParameter("do_result3") != null;
		String memo_list1 = request.getParameter("memo_list1");
		String memo_list2 = request.getParameter("memo_list2");
		String memo_list3 = request.getParameter("memo_list3");

		// recordcheck.jspから受け取った記録をビーンズにセット
		RecordBeans rb = new RecordBeans();
		rb.setDo_result1(do_result1);
		rb.setDo_result2(do_result2);
		rb.setDo_result3(do_result3);
		rb.setMemo_list1(memo_list1);
		rb.setMemo_list2(memo_list2);
		rb.setMemo_list3(memo_list3);

		// 記録の有無を検索
		// 検索した記録情報を取得
		RecordCheckDAO rcd = new RecordCheckDAO();
		RecordBeans returnrb = rcd.findRecordBeans(rb);

		if ( returnrb != null) {
			// セッションに記録情報を登録
			HttpSession session = request.getSession();
			session.setAttribute("record",  returnrb);

			RequestDispatcher rdc = request.getRequestDispatcher("/WEB-INF/jsp/recordcomplete.jsp");
			rdc.forward(request, response);
		}
	}
}
