package servlet;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/GoalSendServlet")
public class GoalSendServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    // 目標リストを取得して、リクエストスコープに保存
    GetGoalListLogic getGoalListLogic =
        new GetGoalListLogic();
    List<Goal> goalList = getGoalListLogic.execute();
    request.setAttribute("goalList", goalList);

    // ログインしているか確認するため
    // セッションスコープからユーザー情報を取得
    HttpSession session = request.getSession();
    AccountBeans accountBeans = (AccountBeans) session.getAttribute("accountBeans");

    if (accountBeans == null) { // ログインしていない
    // リダイレクト
      response.sendRedirect("/Aproject3/");
    } else { // ログイン済み
    // フォワード
      RequestDispatcher dispatcher = request.
          getRequestDispatcher("/WEB-INF/jsp/goalsend.jsp");
      dispatcher.forward(request, response);
    }
  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    // リクエストパラメータの取得
    request.setCharacterEncoding("UTF-8");
//    String goalgenre1=request.getParameter("goalgenre1");
//	String goalgenre2=request.getParameter("goalgenre2");
//	String goalgenre3=request.getParameter("goalgenre3");
//	String goal1=request.getParameter("goal1");
//	String goal2=request.getParameter("goal2");
//	String goal3=request.getParameter("goal3");

     // 目標リストを取得して、リクエストスコープに保存
    GetGoalListLogic getGoalListLogic =
        new GetGoalListLogic();
    List<Goal> goalList = getGoalListLogic.execute();
    request.setAttribute("goalList", goalList);

    // フォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/WEB-INF/jsp/main.jsp");
    dispatcher.forward(request, response);
  }
}