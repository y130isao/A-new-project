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
  private final String JDBC_URL =
      "jdbc:mysql://localhost/Aproject3";
  private final String DB_USER = "root";
  private final String DB_PASS = "adminadmin";

  public List<Goal> findAll() {
    List<Goal> goalList = new ArrayList<Goal>();

    // データベース接続
    try(Connection conn = DriverManager.getConnection(
          JDBC_URL, DB_USER, DB_PASS)) {

      // SELECT文の準備
      String sql =
          "SELECT EXERCISE,MEAL,SLEEP FROM GOAL ORDER BY ID DESC";
      PreparedStatement pStmt = conn.prepareStatement(sql);

      // SELECTを実行
      ResultSet rs = pStmt.executeQuery();

      // SELECT文の結果をArrayListに格納
      while (rs.next()) {
        String exercise = rs.getString("EXERCISE");
        String meal = rs.getString("MEAL");
        String sleep = rs.getString("SLEEP");
        Goal goal = new Goal(exercise, meal, sleep);
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
      String sql = "INSERT INTO GOAL(EXERCISE, MEAL, SLEEP) VALUES(?, ?)";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      // INSERT文中の「?」に使用する値を設定しSQLを完成
      pStmt.setString(1, goal.getExercise());
      pStmt.setString(2, goal.getMeal());
      pStmt.setString(2, goal.getSleep());

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