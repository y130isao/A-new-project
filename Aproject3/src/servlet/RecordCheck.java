package servlet;

import java.io.IOException;

import dao.RecordDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.RecordBeans;

@WebServlet("/RecordCheck")
public class RecordCheck extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String do_result1 = request.getParameter("do_result1");
		String do_result2 = request.getParameter("do_result2");
		String do_result3 = request.getParameter("do_result3");
		String memo_list1 = request.getParameter("memo_list1");
		String memo_list2 = request.getParameter("memo_list2");
		String memo_list3 = request.getParameter("memo_list3");

		// register.jspから受け取った値をビーンズにセット
		RecordBeans rb = new RecordBeans();
		rb.setDo_result1(do_result1);
		rb.setDo_result2(do_result2);
		rb.setDo_result3(do_result3);
		rb.setMemo_list1(memo_list1);
		rb.setMemo_list2(memo_list2);
		rb.setMemo_list3(memo_list3);

//		セッションにアカウント情報を保存
		HttpSession session = request.getSession();
		session.setAttribute("Record", rb);

		// アカウントをDBに登録
		RecordDAO rd = new RecordDAO();
		rd.create(rb);

		RequestDispatcher rdr = request.getRequestDispatcher("/WEB-INF/jsp/recordcheck.jsp");
		rdr.forward(request, response);

	}
}