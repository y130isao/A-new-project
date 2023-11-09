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
import model.GetCalRecordListLogic;
import model.MyCalendar;
import model.MyCalendarLogic;
import model.Record;

@WebServlet("/PastdataServlet")
public class PastdataServlet extends HttpServlet {
	/**
	 * カレンダーの日付選択で履歴を参照
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s_year = request.getParameter("year");
		String s_month = request.getParameter("month");
		String s_day = request.getParameter("day");
		MyCalendarLogic logic = new MyCalendarLogic();
		MyCalendar mc = null;

		if (s_year != null && s_month != null) {
			int year = Integer.parseInt(s_year);
			int month = Integer.parseInt(s_month);
			if (month == 0) {
				month = 12;
				year--;
			}
			if (month == 13) {
				month = 1;
				year++;
			}

			mc = logic.createMyCalendar(year, month);
		} else {
			mc = logic.createMyCalendar();
		}
		String str = s_year + "-" + s_month + "-" + s_day;
		System.out.println(str);
		HttpSession session = request.getSession();
		AccountBeans account = (AccountBeans) session.getAttribute("account");
		GetCalRecordListLogic grl = new GetCalRecordListLogic();
		List<Record> list = grl.execute(str, account);
		session.setAttribute("list", list);

		request.setAttribute("mc", mc);

		// Retrieve the past data

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pastdata.jsp");
		rd.forward(request, response);
	}
}
