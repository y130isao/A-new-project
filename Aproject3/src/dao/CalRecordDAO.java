package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AccountBeans;
import model.Goal;
import model.Record;

public class CalRecordDAO {

	private final String JDBC_URL = "jdbc:mysql://172.16.0.218:3306/health_management";
	private final String DB_USER = "sample_user";
	private final String DB_PASS = "";

	// データベース接続を確立
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
	}

	// アカウントIDを使用してカレンダー記録情報を取得
	public List<Record> getCalRecordsByAccountId(String daystString, AccountBeans ab) {
		List<Record> calrecordList = new ArrayList<>();
		try (Connection con = getConnection();
				PreparedStatement pStmt = con.prepareStatement(
						"SELECT DISTINCT "
								+ "do_result1, do_result2, do_result3, "
								+ "memo_list1, memo_list2, memo_list3 "
								+ "FROM user_health "
								+ "WHERE date_time  BETWEEN ? AND ?"
								+ "AND accountId = ?")) {
			pStmt.setString(1, daystString + " 00:00:00");
			pStmt.setString(2, daystString + " 23:59:59");
			pStmt.setInt(3, ab.getAccountId());

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				Record record = new Record(
						ab.getAccountId(), // recordId を引数として追加
						rs.getBoolean("do_result1"),
						rs.getBoolean("do_result2"),
						rs.getBoolean("do_result3"),
						rs.getString("memo_list1"),
						rs.getString("memo_list2"),
						rs.getString("memo_list3"));
				calrecordList.add(record);

				System.out.println(record.getDo_result1()
						+ ":" + record.getMemo_list1());

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return calrecordList;
	}

	public List<Goal> getGoalByAccountId(String daystString, AccountBeans ab) {
		List<Goal> goalList = new ArrayList<>();
		try (Connection con = getConnection();
				PreparedStatement pStmt = con.prepareStatement(
						"SELECT DISTINCT goalgenre1, goalgenre2, goalgenre3, "
								+ "goal1, goal2, goal3 "
								+ "FROM user_health "
								+ "WHERE date_time  BETWEEN ? AND ?"
								+ "AND accountId = ?")) {
			pStmt.setString(1, daystString + " 00:00:00");
			pStmt.setString(2, daystString + " 23:59:59");
			pStmt.setInt(3, ab.getAccountId());

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				Goal goal = new Goal(
						ab.getAccountId(), // accountId を引数として追加
						rs.getString("goal1"),
						rs.getString("goal2"),
						rs.getString("goal3"),
						rs.getString("goalgenre1"),
						rs.getString("goalgenre2"),
						rs.getString("goalgenre3"));
				goalList.add(goal);

				System.out.println(goal.getGoal1()
						+ ":" + goal.getGoalgenre1());

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goalList;
	}

}
