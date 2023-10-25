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

		//フォワード先
		String path=null;

		//サーブレットの動作を決定する「mode」の値をリクエストパラメータから取得
		String mode=request.getParameter("mode");
		if(mode == null || mode.equals("back")){
			path="/WEB-INF/jsp/goal.jsp";
		}else {
			path="/WEB-INF/jsp/goalsend.jsp";
			HttpSession session=request.getSession();
			session.invalidate();
		}

		//設定されたフォワード先にフォワード
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {


		//リクエストパラメーターを取得
		request.setCharacterEncoding("UTF-8");
		String goalgenre1=request.getParameter("goalgenre1");
		String goalgenre2=request.getParameter("goalgenre2");
		String goalgenre3=request.getParameter("goalgenre3");
		String goal1=request.getParameter("goal1");
		String goal2=request.getParameter("goal2");
		String goal3=request.getParameter("goal3");

		//セッションスコープに保存するインスタンスの生成
		Goal goal=new Goal(goal1,goal2,goal3,goalgenre1,goalgenre2,goalgenre3);

		//インスタンスの取得
		HttpSession session=request.getSession();

		//セッションスコープにインスタンスを保存
		session.setAttribute("goal", goal);

		// goalconfirm.jspにフォワード
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/goalconfirm.jsp");
		rd.forward(request, response);


		//		// リクエストパラメータの取得
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
		//		//インスタンスの取得
		//		HttpSession session=request.getSession();
		//		//セッションスコープにインスタンスを保存
		//		session.setAttribute("goal", goal);
		//
		//		// goalconfirm.jspにフォワード
		//		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/goalsend.jsp");
		//		rd.forward(request, response);
		//
		//		// つぶやきをつぶやきリストに追加
		//		Goal goal = new Goal(.getGoal(), goal);
		//		PostGoalLogic postGoalLogic = new PostGoalLogic();
		//		postGoalLogic.execute(goal);
		//
		//		// つぶやきリストを取得して、リクエストスコープに保存
		//		GetGoalListLogic getGoalListLogic =
		//				new GetGoalListLogic();
		//		List<Goal> goalList = getGoalListLogic.execute();
		//		request.setAttribute("goalList", goalList);
		//
		//		// フォワード
		//		RequestDispatcher dispatcher = request.getRequestDispatcher(
		//				"/WEB-INF/jsp/goalsend.jsp");
		//		dispatcher.forward(request, response);
	}

}