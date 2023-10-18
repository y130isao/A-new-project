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

	public RoomBeans findRoom(RoomBeans rb) {
		RoomBeans returnRb = new RoomBeans();

		try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT id, chara_level, chara_point FROM chara WHERE id = 1";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, rb.getId());
			ps.setInt(2, rb.getChara_Level());
			ps.setInt(3, rb.getChara_Point());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// 見つかったアカウント情報を戻り値にセット
				returnRb.setId(rs.getInt("id"));
				returnRb.setChara_Level(rs.getInt("chara_level"));
				returnRb.setChara_Point(rs.getInt("chara_point"));
			} else {
				// アカウントがなければnullを返す
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return returnRb;
	}
}
