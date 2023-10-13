package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.RecordBeans;



@WebServlet("/RecordServlet")
public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

	RequestDispatcher dispatcher =
		request.getRequestDispatcher("/WEB-INF/jsp/record.jsp");
	dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
	
		 // リクエストパラメータを取得
	    String example_list = request.getParameter("example_list"); // 
	    String do_result = request.getParameter("do_result"); // 
	    String memo_list = request.getParameter("memo_list");
	   
	    // 入力値をプロパティに設定
	    RecordBeans rb  = new RecordBeans();
	    rb.setExample_list(example_list);
	    rb.setDo_result(do_result);
	    rb.setMemo_list(memo_list);
	    // 健康診断を実行し結果を設定

	    // リクエストスコープに保存
	    request.setAttribute("recordbeans", rb);
	    
	    System.out.println(example_list);
	    System.out.println(do_result);
	    System.out.println(memo_list);

		    // フォワード
	RequestDispatcher dispatcher =
		request.getRequestDispatcher("/WEB-INF/jsp/recordcheck.jsp");
	dispatcher.forward(request, response);
	}
}