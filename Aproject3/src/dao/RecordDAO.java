package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.RecordBeans;


public class RecordDAO {
	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://172.16.0.218:3306/health_management";
	private final String DB_USER = "sample_user";
	private final String DB_PASS = "";

	public boolean create(RecordBeans rb) {

		try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "INSERT INTO user_health(do_result1,do_result2,do_result3,memo_list1,memo_list2,memo_list3,) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setBoolean(1, rb.getDo_result1());
			ps.setBoolean(2, rb.getDo_result2());
			ps.setBoolean(3, rb.getDo_result3());
			ps.setString(4, rb.getMemo_list1());
			ps.setString(5, rb.getMemo_list2());
			ps.setString(5, rb.getMemo_list3());

			int r = ps.executeUpdate();

			if (r != 0) {
			} else {
		}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
