package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.RoomBeans;

public class RoomDAO {
	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://172.16.0.218:3306/health_management";
	private final String DB_USER = "sample_user";
	private final String DB_PASS = "";

	public RoomBeans findRoom() {
		RoomBeans rb = new RoomBeans();
		try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT id, chara_level, chara_point FROM chara WHERE id = 1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			// 見つかったroom情報を戻り値にセット
			// リストroom情報を追加
			while (rs.next()) {
				rb.setId(rs.getInt("id"));
				rb.setId(rs.getInt("chara_level"));
				rb.setId(rs.getInt("chara_point"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rb;
	}
}
