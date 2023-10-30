package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.RecordBeans;

public class RecordCheckDAO {
	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://172.16.0.218:3306/health_management";
	private final String DB_USER = "sample_user";
	private final String DB_PASS = "";

	// 記録情報を探す
	public RecordBeans findRecordBeans(RecordBeans rb) {

		// 戻り値の用意
		RecordBeans returnrb = new RecordBeans();

		// データベースへ接続
		try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT do_result1,do_result2,do_result3,memo_list1,memo_list2,memo_list3, FROM user_health";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				// 見つかった記録情報を戻り値にセット
				returnrb.setDo_result1(rs.getBoolean("do_result1"));
				returnrb.setDo_result2(rs.getBoolean("do_result1"));
				returnrb.setDo_result3(rs.getBoolean("do_result1"));
				returnrb.setMemo_list1(rs.getString("memo_list1"));
				returnrb.setMemo_list2(rs.getString("memo_list2"));
				returnrb.setMemo_list3(rs.getString("memo_list3"));

			} else {
				// 記録がなければnullを返す
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return returnrb;
		
		}
}