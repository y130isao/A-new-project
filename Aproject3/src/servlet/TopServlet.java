package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/TopServlet")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		
		String jspPage = "top.jsp";
		
		RequestDispatcher dispatcher1 = request.getRequestDispatcher(jspPage);
        dispatcher1.forward(request, response);
        
        RequestDispatcher dispatcher2 = request.getRequestDispatcher("PastdataServlet");
        dispatcher2.forward(request, response);
        
        RequestDispatcher dispatcher3 = request.getRequestDispatcher("GoalServlet");
        dispatcher3.forward(request, response);
        
        RequestDispatcher dispatcher4 = request.getRequestDispatcher("AccountServlet");
        dispatcher4.forward(request, response);
        
        RequestDispatcher dispatcher5 = request.getRequestDispatcher("RecordServlet");
        dispatcher5.forward(request, response);
        
        RequestDispatcher dispatcher6 = request.getRequestDispatcher("RoomServlet");
        dispatcher6.forward(request, response);
	}
}
