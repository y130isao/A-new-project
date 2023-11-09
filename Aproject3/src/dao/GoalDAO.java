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

	private final String JDBC_URL = "jdbc:mysql://172.16.0.218:3306/health_management";
	private final String DB_USER = "sample_user";
	private final String DB_PASS = "";

	// データベース接続を確立
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
	}

	// アカウントIDを使用して目標情報を取得
	public List<Goal> getGoalsByAccountId(int accountId) {
		List<Goal> goalList = new ArrayList<>();

		//データベースへ接続
		try (Connection conn = getConnection();
				PreparedStatement pStmt = conn.prepareStatement("SELECT goalgenre1, goalgenre2, goalgenre3, goal1, goal2, goal3 FROM user_health WHERE accountId = ?")) {
			pStmt.setInt(1, accountId);

			//select文を実行し、結果表を取得
			try (ResultSet rs = pStmt.executeQuery()) {
				while (rs.next()) {
					//goalインスタンスに格納
					Goal goal = new Goal(
							accountId,  // accountId を引数として追加
							rs.getString("goal1"),
							rs.getString("goal2"),
							rs.getString("goal3"),
							rs.getString("goalgenre1"),
							rs.getString("goalgenre2"),
							rs.getString("goalgenre3")
							);
					
					//goalListインスタンスにgoalインスタンスを格納
					goalList.add(goal);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return goalList;
	}
	
	// 目標情報をデータベースに保存
		public boolean create(Goal goal, int accountId) {
			try (Connection conn = getConnection()) {

				// 新規挿入
				String insertQuery = "INSERT INTO user_health (accountId, goalgenre1, goalgenre2, goalgenre3, goal1, goal2, goal3) VALUES (?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
				insertStmt.setInt(1, accountId);
				insertStmt.setString(2, goal.getGoalgenre1());
				insertStmt.setString(3, goal.getGoalgenre2());
				insertStmt.setString(4, goal.getGoalgenre3());
				insertStmt.setString(5, goal.getGoal1());
				insertStmt.setString(6, goal.getGoal2());
				insertStmt.setString(7, goal.getGoal3());

				int result = insertStmt.executeUpdate();
				return result == 1;

			}catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}


	}