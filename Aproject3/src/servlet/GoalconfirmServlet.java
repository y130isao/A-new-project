package servlet;

import java.io.IOException;
import java.util.List;

import dao.GoalDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;
import model.GetGoalListLogic;
import model.Goal;

@WebServlet("/GoalconfirmServlet")
public class GoalconfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = null;
        String mode = request.getParameter("mode");
        if (mode == null || mode.equals("back")) {
            path = "/WEB-INF/jsp/goal.jsp";
        } else {
            path = "/WEB-INF/jsp/goalsend.jsp";
            HttpSession session = request.getSession();
            session.invalidate();
        }

        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String goalgenre1 = request.getParameter("goalgenre1");
        String goalgenre2 = request.getParameter("goalgenre2");
        String goalgenre3 = request.getParameter("goalgenre3");
        String goal1 = request.getParameter("goal1");
        String goal2 = request.getParameter("goal2");
        String goal3 = request.getParameter("goal3");

        //セッションスコープに保存されたアカウント情報を取得(AccountCheck.java)
        HttpSession session = request.getSession();
        AccountBeans account = (AccountBeans) session.getAttribute("account");
        
        //アカウントがnullでなければ
        if (account != null) {
        	//アカウントIDを取得
            int accountId = account.getAccountId();

            // ここで Goal オブジェクトを作成し accountId をセットして使用
            Goal goal = new Goal(accountId, goal1, goal2, goal3, goalgenre1, goalgenre2, goalgenre3);

            // Goal オブジェクトを使用してデータベースに保存
            GoalDAO goalDAO = new GoalDAO();
            boolean success = goalDAO.create(goal, accountId);

            if (success) {
                // データベースへの保存が成功した場合の処理

                // 目標リストを取得して、セッションコープに保存
                GetGoalListLogic getGoalListLogic = new GetGoalListLogic();
                List<Goal> goalList = getGoalListLogic.execute(accountId);
                session.setAttribute("goalList", goalList);

                // フォワード
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/goalconfirm.jsp");
                dispatcher.forward(request, response);
            } else {
                // データベースへの保存が失敗した場合のエラーハンドリング
            }
        } else {
            // ログインしていない場合のエラーハンドリング
            // リダイレクトなど適切な処理を行う
        	 // (仮)
        }
    }


}
