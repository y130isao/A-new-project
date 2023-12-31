package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Record;

public class RecordDAO {

	private final String JDBC_URL = "jdbc:mysql://172.16.0.218:3306/health_management";
	private final String DB_USER = "sample_user";
	private final String DB_PASS = "";

	// データベース接続を確立
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
	}

	// アカウントIDを使用して目標情報を取得
	public List<Record> getRecordsByAccountId(int accountId) {
		List<Record> recordList = new ArrayList<>();

		try (Connection conn = getConnection();
				PreparedStatement pStmt = conn.prepareStatement(
						"SELECT do_result1, do_result1, do_result1, memo_list1, memo_list1, memo_list1 FROM user_health WHERE accountId = ?")) {
			pStmt.setInt(1, accountId);

			try (ResultSet rs = pStmt.executeQuery()) {
				while (rs.next()) {
					Record record = new Record(
							accountId, // accountId を引数として追加
							rs.getBoolean("do_result1"),
							rs.getBoolean("do_result2"),
							rs.getBoolean("do_result3"),
							rs.getString("memo_list1"),
							rs.getString("memo_list2"),
							rs.getString("memo_list3"));
					recordList.add(record);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recordList;
	}

	//記録情報をデータベースに保存（新規挿入）
	public boolean create(Record record, int accountId) {
		try (Connection conn = getConnection()) {

			// 新規挿入
			String insertQuery = "INSERT INTO user_health "
					+ "(accountId, goalgenre1, goalgenre2, goalgenre3, "
					+ "goal1, goal2, goal3, do_result1, do_result2, "
					+ "do_result3, memo_list1, memo_list2, memo_list3) "
					+ "SELECT accountId, goalgenre1, goalgenre2, goalgenre3, "
					+ "goal1, goal2, goal3, "
					+ "?, ?, ?, ?, ?, ? "
					+ "FROM user_health WHERE accountId = ? "
					+ "AND date_time = (SELECT max(date_time) FROM user_health)";

			PreparedStatement insertStmt = conn.prepareStatement(insertQuery);

			insertStmt.setBoolean(1, record.getDo_result1());
			insertStmt.setBoolean(2, record.getDo_result2());
			insertStmt.setBoolean(3, record.getDo_result3());
			insertStmt.setString(4, record.getMemo_list1());
			insertStmt.setString(5, record.getMemo_list2());
			insertStmt.setString(6, record.getMemo_list3());
			insertStmt.setInt(7, accountId);

			int result = insertStmt.executeUpdate();
			return result == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}

	}

	public boolean update(Record record, int accountId) {
		try (Connection con = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "UPDATE user_health SET "
					+ "do_result1 = ?, do_result2 = ?, do_result3 = ?,  "
					+ "memo_list1 = ?, memo_list2 = ?, memo_list3 = ? "
					+ "WHERE accountId = ? "
					+ "AND CAST(date_time AS DATE) = CURRENT_DATE";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setBoolean(1, record.getDo_result1());
			ps.setBoolean(2, record.getDo_result2());
			ps.setBoolean(3, record.getDo_result3());
			ps.setString(4, record.getMemo_list1());
			ps.setString(5, record.getMemo_list2());
			ps.setString(6, record.getMemo_list3());
			ps.setInt(7, accountId);

			int rs = ps.executeUpdate();

			if (rs != 0) {

			} else {
				return false;
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean existence(int accountId) {
		int count = 0;
		try (Connection con = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT count(*) cnt FROM user_health "
					+ "WHERE accountId = ? "
					+ "AND CAST(date_time AS DATE) = CURRENT_DATE";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountId);

			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt("cnt");
			System.out.println(count);
			if(count != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}

