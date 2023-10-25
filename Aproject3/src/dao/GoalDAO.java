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

        try (Connection conn = getConnection();
             PreparedStatement pStmt = conn.prepareStatement("SELECT goalgenre1, goalgenre2, goalgenre3, goal1, goal2, goal3 FROM user_health WHERE accountId = ?")) {
            pStmt.setInt(1, accountId);

            try (ResultSet rs = pStmt.executeQuery()) {
                while (rs.next()) {
                	Goal goal = new Goal(
                		    accountId,  // accountId を引数として追加
                		    rs.getString("goal1"),
                		    rs.getString("goal2"),
                		    rs.getString("goal3"),
                		    rs.getString("goalgenre1"),
                		    rs.getString("goalgenre2"),
                		    rs.getString("goalgenre3")
                		);

                    goalList.add(goal);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goalList;
    }

    // 目標情報をデータベースに保存（新規挿入または更新）
    public boolean create(Goal goal, int accountId) {
        try (Connection conn = getConnection()) {
            // アカウントIDを使用して既存の行を検索
            String selectQuery = "SELECT COUNT(*) FROM user_health WHERE accountId = ?";
            PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
            selectStmt.setInt(1, accountId);
            ResultSet resultSet = selectStmt.executeQuery();
            resultSet.next();
            int rowCount = resultSet.getInt(1);

            if (rowCount > 0) {
                // 既存の行がある場合は更新
                String updateQuery = "UPDATE user_health SET goalgenre1 = ?, goalgenre2 = ?, goalgenre3 = ?, goal1 = ?, goal2 = ?, goal3 = ? WHERE accountId = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                updateStmt.setString(1, goal.getGoalgenre1());
                updateStmt.setString(2, goal.getGoalgenre2());
                updateStmt.setString(3, goal.getGoalgenre3());
                updateStmt.setString(4, goal.getGoal1());
                updateStmt.setString(5, goal.getGoal2());
                updateStmt.setString(6, goal.getGoal3());
                updateStmt.setInt(7, accountId);

                int result = updateStmt.executeUpdate();
                return result == 1;
            } else {
                // 既存の行がない場合は新規挿入
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
