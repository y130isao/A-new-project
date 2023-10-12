package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.AccountBeans;

public class AccountRegisterDAO {
	// データベース接続に使用する情報
	final String jdbcId = "root";
	final String jdbcPass = "adminadmin";
	final String jdbcUrl = "jdbc:mysql://localhost:3306/testdb";

	public boolean create(AccountBeans ab) {

		try (Connection con = DriverManager.getConnection(jdbcId, jdbcPass, jdbcUrl)) {

			String sql = "INSERT INTO account ( loginId, name, pass, roleId) VALUES ( ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, ab.getLoginId());
			ps.setString(2, ab.getPass());
			ps.setString(3, ab.getName());
			ps.setInt(4, ab.getRoleId());

			int r = ps.executeUpdate();

			if (r != 0) {
				System.out.println("新規登録成功！");
				return false;
			} else {
				System.out.println("新規登録失敗");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
