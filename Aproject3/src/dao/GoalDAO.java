package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Goal;

public class GoalDAO {
  // データベース接続に使用する情報
  private final String JDBC_URL ="jdbc:mysql://172.16.0.218:3306/health_management";
  private final String DB_USER = "";
  private final String DB_PASS = "";

  public List<Goal> findAll() {
    List<Goal> goalList = new ArrayList<Goal>();

    // データベース接続
    try(Connection conn = DriverManager.getConnection(
          JDBC_URL, DB_USER, DB_PASS)) {

      // SELECT文の準備
      String sql =
          "SELECT GOAL1,GOAL2,GOAL3 FROM ACCOUNT ORDER BY ID DESC";
      PreparedStatement pStmt = conn.prepareStatement(sql);

      // SELECTを実行
      ResultSet rs = pStmt.executeQuery();

      // SELECT文の結果をArrayListに格納
      while (rs.next()) {
    	String goalgenre1 = rs.getString("GOALGENRE1");
    	String goalgenre2 = rs.getString("GOALGENRE2");
    	String goalgenre3 = rs.getString("GOALGENRE3");
        String goal1 = rs.getString("GOAL1");
        String goal2 = rs.getString("GOAL2");
        String goal3 = rs.getString("GOAL3");
        Goal goal = new Goal(goal1, goal2, goal3, goalgenre1, goalgenre2, goalgenre3);
        goalList.add(goal);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return goalList;
  }
  public boolean create(Goal goal) {
    // データベース接続
    try(Connection conn = DriverManager.getConnection(
          JDBC_URL, DB_USER, DB_PASS)) {

      // INSERT文の準備(idは自動連番なので指定しなくてよい）
      String sql = "INSERT INTO ACCOUNT(GOAL1, GOAL2, GOAL3, GOALGENRE1, GOALGENRE2, GOALGENRE3) VALUES(?, ?, ?, ?, ?, ?)";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      // INSERT文中の「?」に使用する値を設定しSQLを完成
      pStmt.setString(1, goal.getGoalgenre1());
      pStmt.setString(2, goal.getGoalgenre2());
      pStmt.setString(3, goal.getGoalgenre3());
      pStmt.setString(1, goal.getGoal1());
      pStmt.setString(2, goal.getGoal2());
      pStmt.setString(3, goal.getGoal3());

      // INSERT文を実行
      int result = pStmt.executeUpdate();

      if (result != 1) {
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }
}