package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalRecordDAO {

	private final String JDBC_URL = "jdbc:mysql://172.16.0.218:3306/health_management";
	private final String DB_USER = "sample_user";
	private final String DB_PASS = "";

	// データベース接続を確立
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
	}

	// アカウントIDを使用してカレンダー記録情報を取得
	public List<CalRecord> getCalRecordsByAccountId(int accountId) {
		List<CalRecord> calrecordList = new ArrayList<>();

		try (Connection conn = getConnection();
				PreparedStatement pStmt = conn.prepareStatement("SELECT goalgenre1, goalgenre2, goalgenre3, goal1, goal2, goal3, do_result1, do_result2, do_result3, memo_list1, memo_list2, memo_list3 FROM user_health WHERE accountId = ?")) {
			pStmt.setInt(1, accountId);

			try (ResultSet rs = pStmt.executeQuery()) {
				while (rs.next()) {
					CalRecord calrecord = new CalRecord()
							accountId,  // accountId を引数として追加
							rs.getString("goal1"),
							rs.getString("goal2"),
							rs.getString("goal3"),
							rs.getString("goalgenre1"),
							rs.getString("goalgenre2"),
							rs.getString("goalgenre3"),
							rs.getBoolean("do_result1"),
							rs.getBoolean("do_result2"),
							rs.getBoolean("do_result3"),
							rs.getString("memo_list1"),
							rs.getString("memo_list2"),
							rs.getString("memo_list3")
							);

					calrecordList.add(calrecord);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return calrecordList;
	}
}
