package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MyCalendar;
import model.MyCalendarLogic;

@WebServlet("/PastdataServlet")
public class PastdataServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s_year = request.getParameter("year");
        String s_month = request.getParameter("month");
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

        request.setAttribute("mc", mc);

        // Retrieve the past data
       

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pastdata.jsp");
        rd.forward(request, response);
    }
}
