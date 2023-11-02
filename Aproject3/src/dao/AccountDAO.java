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

	/**
	 * DBへ登録済みのアカウントを取得
	 * @param ab
	 * @return
	 */
	public AccountBeans findAccount(AccountBeans ab) {

		/** 戻り値の用意 */
		AccountBeans returnAb = new AccountBeans();

		/** データベースに接続 */
		try (Connection con = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT account.accountId, account.loginId,account.pass, "
					+ "account.name, account.genId, "
					+ "account.roleId, account.charaLevel, account.charaPoint "
					+ "FROM account "
					+ "WHERE account.loginId = ? AND account.pass = ? ";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, ab.getLoginId());
			ps.setString(2, ab.getPass());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// 見つかったアカウント情報を戻り値にセット
				returnAb.setAccountId(rs.getInt("account.accountId"));
				returnAb.setLoginId(rs.getString("account.loginId"));
				returnAb.setPass(rs.getString("account.pass"));
				returnAb.setName(rs.getString("account.name"));
				returnAb.setRoleId(rs.getInt("account.roleId"));
				returnAb.setGenId(rs.getInt("account.genId"));
				returnAb.setCharaLevel(rs.getInt("account.charaLevel"));
				returnAb.setCharaPoint(rs.getInt("account.charaPoint"));
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

	/**
	 * アカウントの最終更新日の取得
	 * @param accountId
	 * @return
	 */
	public AccountBeans findTime(int accountId) {
		AccountBeans returnAb = new AccountBeans();
		try (Connection con = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT user_health.date_time "
					+ "FROM user_health "
					+ "WHERE date_time = (SELECT max(date_time) FROM user_health) "
					+ "AND accountId = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				returnAb.setDateTime(rs.getTimestamp("user_health.date_time"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return returnAb;
	}

	/**
	 * アカウントのポイントとレベルの更新処理
	 * @param ab
	 * @return
	 */
	public AccountBeans setPram(AccountBeans ab) {
		AccountBeans returnAb = new AccountBeans();
		try (Connection con = DriverManager.getConnection(
				JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "UPDATE account SET charaLevel = ?, charaPoint = ? "
					+ "WHERE accountId = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, ab.getCharaLevel());
			ps.setInt(2, ab.getCharaPoint());
			ps.setInt(3, ab.getAccountId());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return returnAb;

	}
}
