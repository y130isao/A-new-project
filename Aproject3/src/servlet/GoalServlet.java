package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GoalServlet")

public class GoalServlet extends HttpServlet {
	  private static final long serialVersionUID = 1L;

	  protected void doGet(HttpServletRequest request,
	      HttpServletResponse response)
	      throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(
	        "/WEB-INF/jsp/goal.jsp");
	    dispatcher.forward(request, response);
	  }
	}