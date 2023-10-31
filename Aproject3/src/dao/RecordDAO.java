package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
				PreparedStatement pStmt = conn.prepareStatement("SELECT do_result1, do_result1, do_result1, memo_list1, memo_list1, memo_list1 FROM user_health WHERE accountId = ?")) {
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

	// 目標情報をデータベースに保存（新規挿入）
	public boolean create(Record record, int accountId) {
		try (Connection conn = getConnection()) {

			// 新規挿入
			String insertQuery = "INSERT INTO user_health (accountId, do_result1, do_result1, do_result1, memo_list1, memo_list1, memo_list1) VALUES (?, ?, ?, ?, ?, ?, ?)";
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


//public class RecordDAO {
//	// データベース接続に使用する情報
//	private final String JDBC_URL = "jdbc:mysql://172.16.0.218:3306/health_management";
//	private final String DB_USER = "sample_user";
//	private final String DB_PASS = "";
//
//	public boolean create(RecordBeans rb) {
//
//		try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
//
//			String sql = "INSERT INTO user_health(do_result1,do_result2,do_result3,memo_list1,memo_list2,memo_list3,) VALUES(?, ?, ?, ?, ?, ?)";
//			PreparedStatement ps = con.prepareStatement(sql);
//
//			ps.setBoolean(2, rb.getDo_result1());
//			ps.setBoolean(3, rb.getDo_result2());
//			ps.setBoolean(4, rb.getDo_result3());
//			ps.setString(5, rb.getMemo_list1());
//			ps.setString(6, rb.getMemo_list2());
//			ps.setString(7, rb.getMemo_list3());
//
//			int r = ps.executeUpdate();
//
//			if (r != 0) {
//			} else {
//		}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}
//}