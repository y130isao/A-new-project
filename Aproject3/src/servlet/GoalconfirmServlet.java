package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Goal;

@WebServlet("/GoalconfirmServlet")

public class GoalconfirmServlet extends HttpServlet {
	  private static final long serialVersionUID = 1L;

	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String path=null;
			String mode=request.getParameter("mode");
			if(mode == null || mode.equals("back")){
				path="/WEB-INF/jsp/goal.jsp";
			}else {
				path="/WEB-INF/jsp/goalsend.jsp";
				HttpSession session=request.getSession();
				session.invalidate();
			}
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request, response);		
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String goalgenre1=request.getParameter("goalgenre1");
			String goalgenre2=request.getParameter("goalgenre2");
			String goalgenre3=request.getParameter("goalgenre3");
			String goal1=request.getParameter("goal1");
			String goal2=request.getParameter("goal2");
			String goal3=request.getParameter("goal3");
			Goal goal=new Goal(goal1,goal2,goal3,goalgenre1,goalgenre2,goalgenre3);
			HttpSession session=request.getSession();
			session.setAttribute("goal", goal);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/goalconfirm.jsp");
			rd.forward(request, response);
		}

	}