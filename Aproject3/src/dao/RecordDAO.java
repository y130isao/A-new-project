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
				PreparedStatement pStmt = conn.prepareStatement("SELECT do_result1, do_result2, do_result3, memo_list1, memo_list2, memo_list3 FROM user_health WHERE accountId = ?")) {
			pStmt.setInt(1, accountId);

			try (ResultSet rs = pStmt.executeQuery()) {
				while (rs.next()) {
					Record record = new Record(
							accountId,  // accountId を引数として追加
							rs.getBoolean("do_result1"),
							rs.getBoolean("do_result2"),
							rs.getBoolean("do_result3"),
							rs.getString("memo_list1"),
							rs.getString("memo_list2"),
							rs.getString("memo_list3")
							);

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
			String insertQuery = "INSERT INTO user_health (accountId, do_result1, do_result2, "
					+ "do_result3, memo_list1, memo_list2, memo_list3) VALUES (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement insertStmt = conn.prepareStatement(insertQuery);

			insertStmt.setInt(1, accountId);
			insertStmt.setBoolean(2, record.getDo_result1());
			insertStmt.setBoolean(3, record.getDo_result2());
			insertStmt.setBoolean(4, record.getDo_result3());
			insertStmt.setString(5, record.getMemo_list1());
			insertStmt.setString(6, record.getMemo_list2());
			insertStmt.setString(7, record.getMemo_list3());


			int result = insertStmt.executeUpdate();
			return result == 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}

	}


}
			

//	public boolean create(Record record, int accountId) {
//		try (Connection conn = getConnection()) {
//			String checkQuery = "SELECT COUNT(*) AS count FROM user_health WHERE accountId = ?";
//			PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
//			checkStmt.setInt(1, accountId);
//			ResultSet rs = checkStmt.executeQuery();
//
//			if (rs.next() && rs.getInt("count") > 0) {
//				String updateQuery = "UPDATE user_health SET do_result1 = ?, do_result2 = ?, "
//						+ "do_result3 = ?, memo_list1 = ?, memo_list2 = ?, memo_list3 = ? WHERE accountId = ?";
//				PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
//				updateStmt.setBoolean(1, record.getDo_result1());
//				updateStmt.setBoolean(2, record.getDo_result2());
//				updateStmt.setBoolean(3, record.getDo_result3());
//				updateStmt.setString(4, record.getMemo_list1());
//				updateStmt.setString(5, record.getMemo_list2());
//				updateStmt.setString(6, record.getMemo_list3());
//				updateStmt.setInt(7, accountId);
//
//				int result = updateStmt.executeUpdate();
//				return result == 1;
//			} else {
//				// データが見つからなかった場合の処理
//				// 新規挿入ロジックをここに記述
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//		return false;
//	}
//}
