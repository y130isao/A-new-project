//package dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import model.RecordBeans;
//
//public class RecordDAO {
//	// データベース接続に使用する情報
//	final String jdbcId = "root";
//	final String jdbcPass = "adminadmin";
//	final String jdbcUrl = "jdbc:mysql://localhost:3306/testdb";
//	
//	public RecordBeans create(RecordBeans rb) {
//		
//
//	// データベースへ接続
//	try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass)) {
//		
//		//インサート文の用意
//		String sql = "insert into RecordBeans(do_result,memo_list) VALUE(?, ?)";
//		PreparedStatement ps = con.prepareStatement(sql);
//		
//		ps.setString(1, rb.getDo_result());
//		ps.setString(2, rb.getMemo_list());
//		
//		// SELECTを実行
//		int result = ps.executeUpdate();
//		if (result != 1) {
//			return false;
//		}
//
//	}catch (SQLException e) {
//		e.printStackTrace();
//		return false;
//	}
//	return true;
//	}
//}