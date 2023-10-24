package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountBeans;

public class AccountDAO {
	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://172.16.0.218:3306/health_management";
	private final String DB_USER = "sample_user";
	private final String DB_PASS = "";

	// ログインアカウントを探す
	public AccountBeans findAccount(AccountBeans ab) {

		// 戻り値の用意
		AccountBeans returnAb = new AccountBeans();

		// データベースへ接続
		try (Connection con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT accountId, loginId, pass, name, roleId, genId, charaLevel, charaPoint FROM account WHERE loginId = ? AND pass = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, ab.getLoginId());
			ps.setString(2, ab.getPass());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// 見つかったアカウント情報を戻り値にセット
				returnAb.setAccountId(rs.getInt("accountId"));
				returnAb.setLoginId(rs.getString("loginId"));
				returnAb.setPass(rs.getString("pass"));
				returnAb.setName(rs.getString("name"));
				returnAb.setRoleId(rs.getInt("roleId"));
				returnAb.setGenId(rs.getInt("genId"));
				returnAb.setCharaLevel(rs.getInt("charaLevel"));
				returnAb.setCharaPoint(rs.getInt("charaPoint"));
			} else {
				// アカウントがなければnullを返す
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return returnAb;
	}
	
}
