package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.RecordBeans;

public class RecordDAO {
  // データベース接続に使用する情報
	private final String JDBC_URL ="jdbc:mysql://172.16.0.218:3306/health_management";
	  private final String DB_USER = "sample_user";
	  private final String DB_PASS = "";
	  
  public ArrayList<RecordBeans> findAll() {
    ArrayList<RecordBeans> list = new ArrayList<RecordBeans>();

    // データベース接続
    try(Connection conn = DriverManager.getConnection(
          JDBC_URL, DB_USER, DB_PASS)) {

      // SELECT文の準備
      String sql =
          "SELECT do_result1,do_result2,do_result3,memo_list1,memo_list2,memo_list3,FROM ACCOUNT ORDER BY ID ASC";
      PreparedStatement pStmt = conn.prepareStatement(sql);

      // SELECTを実行
      ResultSet rs = pStmt.executeQuery();

      // SELECT文の結果をArrayListに格納
      while (rs.next()) {
        RecordBeans rb = new RecordBeans();
        rb.setDo_result1(rs.getString("do_result1"));
        rb.setDo_result2(rs.getString("do_result2"));
        rb.setDo_result3(rs.getString("do_result3"));
        rb.setMemo_list1(rs.getString("memo_list1"));
        rb.setMemo_list2(rs.getString("memo_list2"));
        rb.setMemo_list3(rs.getString("memo_list3"));
        //String  do_result2 = rs.getString("DO_RESULT2");
        //String  do_result3 = rs.getString("DO_RESULT3");
        //String  memo_list1 = rs.getString("MEMO_LIST1");
        //String  memo_list2 = rs.getString("MEMO_LIST2");
        //String  memo_list3 = rs.getString("MEMO_LIST3");

       list.add(rb);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return list;
  }
  public boolean create(RecordBeans rb) {
    // データベース接続
    try(Connection conn = DriverManager.getConnection(
          JDBC_URL, DB_USER, DB_PASS)) {

      // INSERT文の準備(idは自動連番なので指定しなくてよい）
      String sql = "INSERT INTO ACCOUNT(DO_RESULT1, DO_RESULT2, DO_RESULT3, MEMO_LIST1, MEMO_LIST2, MEMO_LIST3) VALUES(?, ?, ?, ?, ?, ?)";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      // INSERT文中の「?」に使用する値を設定しSQLを完成
      pStmt.setString(1, rb.getDo_result1());
      pStmt.setString(2, rb.getDo_result2());
      pStmt.setString(3, rb.getDo_result3());
      pStmt.setString(4, rb.getMemo_list1());
      pStmt.setString(5, rb.getMemo_list2());
      pStmt.setString(6, rb.getMemo_list3());

      // INSERT文を実行
      int result = pStmt.executeUpdate();

      if (result != 1) {
        return false;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }
}