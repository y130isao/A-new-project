package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.RecordBeans;


@WebServlet("/RecordServlet")
public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
		    HttpServletResponse response)
		    throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
		    
			
//		  //セッションスコープに保存された項目情報を取得
//		    HttpSession session = request.getSession();
//		    Goal goal = (Goal) session.getAttribute("goal");
//		    
//			 String E = goal.getExercise();
//			 System.out.println(E);
		    
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("/WEB-INF/jsp/record.jsp");
						dispatcher.forward(request, response);
		    }

	
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
	
		 // リクエストパラメータを取得
	    String do_result1 = request.getParameter("do_result1"); 
	    String do_result2 = request.getParameter("do_result2"); 
	    String do_result3 = request.getParameter("do_result3"); 
	    String memo_list1 = request.getParameter("memo_list1");
	    String memo_list2 = request.getParameter("memo_list2");
	    String memo_list3 = request.getParameter("memo_list3");
	   
	    // 入力値をプロパティに設定
	    RecordBeans rb  = new RecordBeans();
	    rb.setDo_result1(do_result1);
	    rb.setDo_result2(do_result2);
	    rb.setDo_result3(do_result3);
	    rb.setMemo_list1(memo_list1);
	    rb.setMemo_list2(memo_list2);
	    rb.setMemo_list3(memo_list3);
	    
	    //セッションスコープに保存
		HttpSession session = request.getSession();
	    session.setAttribute("recordbeans", rb);
	
	RequestDispatcher dispatcher =
		request.getRequestDispatcher("/WEB-INF/jsp/recordcheck.jsp");
		dispatcher.forward(request, response);
		}
}
