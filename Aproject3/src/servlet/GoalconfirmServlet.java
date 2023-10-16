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
			String exercise=request.getParameter("exercise");
			String meal=request.getParameter("meal");
			String sleep=request.getParameter("sleep");
			Goal goal=new Goal(exercise,meal,sleep);
			HttpSession session=request.getSession();
			session.setAttribute("goal", goal);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/goalconfirm.jsp");
			rd.forward(request, response);
		}

	}