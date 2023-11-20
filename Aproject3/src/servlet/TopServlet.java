package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/TopServlet")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("bool");
		
		
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/top.jsp");
		rd.forward(request, response);
        
        RequestDispatcher dispatcher2 = request.getRequestDispatcher("/Aproject3/PastdataServlet");
        dispatcher2.forward(request, response);
        
        RequestDispatcher dispatcher3 = request.getRequestDispatcher("/Aproject3/GoalServlet");
        dispatcher3.forward(request, response);
        
        RequestDispatcher dispatcher5 = request.getRequestDispatcher("/Aproject3/RecordServlet");
        dispatcher5.forward(request, response);
        
        RequestDispatcher dispatcher6 = request.getRequestDispatcher("/Aproject3/RoomServlet");
        dispatcher6.forward(request, response);
        
        session.removeAttribute("bool");
	}
}
