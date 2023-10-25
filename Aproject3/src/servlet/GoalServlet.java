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

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/goal.jsp");
		dispatcher.forward(request, response);
	}

//	//goal.jspのpostメソッドからの情報を取得
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		//リクエストパラメーターを取得
//		request.setCharacterEncoding("UTF-8");
//		String goalgenre1=request.getParameter("goalgenre1");
//		String goalgenre2=request.getParameter("goalgenre2");
//		String goalgenre3=request.getParameter("goalgenre3");
//		String goal1=request.getParameter("goal1");
//		String goal2=request.getParameter("goal2");
//		String goal3=request.getParameter("goal3");
//
//		//セッションスコープに保存するインスタンスの生成
//		Goal goal=new Goal(goal1,goal2,goal3,goalgenre1,goalgenre2,goalgenre3);
//
//		//インスタンスの取得
//		HttpSession session=request.getSession();
//
//		//セッションスコープにインスタンスを保存
//		session.setAttribute("goal", goal);
//
//		// goalconfirm.jspにフォワード
//		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/goalconfirm.jsp");
//		rd.forward(request, response);
//
//	}

}
