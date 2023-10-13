package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/RecordComplete")
public class RecordComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

	RequestDispatcher dispatcher =
		request.getRequestDispatcher("/WEB-INF/jsp/recordcomplete.jsp");
	dispatcher.forward(request, response);
	}	
}