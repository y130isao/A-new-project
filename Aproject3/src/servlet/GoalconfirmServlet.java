package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Goal;

@WebServlet("/GoalconfirmServlet")

public class GoalconfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//�t�H���[�h��
		String path=null;

		//�T�[�u���b�g�̓�������肷��umode�v�̒l�����N�G�X�g�p�����[�^����擾
		String mode=request.getParameter("mode");
		if(mode == null || mode.equals("back")){
			path="/WEB-INF/jsp/goal.jsp";
		}else {
			path="/WEB-INF/jsp/goalsend.jsp";
			HttpSession session=request.getSession();
			session.invalidate();
		}

		//�ݒ肳�ꂽ�t�H���[�h��Ƀt�H���[�h
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {


		//���N�G�X�g�p�����[�^�[���擾
		request.setCharacterEncoding("UTF-8");
		String goalgenre1=request.getParameter("goalgenre1");
		String goalgenre2=request.getParameter("goalgenre2");
		String goalgenre3=request.getParameter("goalgenre3");
		String goal1=request.getParameter("goal1");
		String goal2=request.getParameter("goal2");
		String goal3=request.getParameter("goal3");

		//�Z�b�V�����X�R�[�v�ɕۑ�����C���X�^���X�̐���
		Goal goal=new Goal(goal1,goal2,goal3,goalgenre1,goalgenre2,goalgenre3);

		//�C���X�^���X�̎擾
		HttpSession session=request.getSession();

		//�Z�b�V�����X�R�[�v�ɃC���X�^���X��ۑ�
		session.setAttribute("goal", goal);

		// goalconfirm.jsp�Ƀt�H���[�h
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/goalconfirm.jsp");
		rd.forward(request, response);


		//		// ���N�G�X�g�p�����[�^�̎擾
		//		request.setCharacterEncoding("UTF-8");
		//		String goalgenre1=request.getParameter("goalgenre1");
		//		String goalgenre2=request.getParameter("goalgenre2");
		//		String goalgenre3=request.getParameter("goalgenre3");
		//		String goal1=request.getParameter("goal1");
		//		String goal2=request.getParameter("goal2");
		//		String goal3=request.getParameter("goal3");
		//
		//		//�Z�b�V�����X�R�[�v�ɕۑ�����C���X�^���X�̐���
		//		Goal goal=new Goal(goal1,goal2,goal3,goalgenre1,goalgenre2,goalgenre3);
		//		//�C���X�^���X�̎擾
		//		HttpSession session=request.getSession();
		//		//�Z�b�V�����X�R�[�v�ɃC���X�^���X��ۑ�
		//		session.setAttribute("goal", goal);
		//
		//		// goalconfirm.jsp�Ƀt�H���[�h
		//		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/jsp/goalsend.jsp");
		//		rd.forward(request, response);
		//
		//		// �Ԃ₫���Ԃ₫���X�g�ɒǉ�
		//		Goal goal = new Goal(.getGoal(), goal);
		//		PostGoalLogic postGoalLogic = new PostGoalLogic();
		//		postGoalLogic.execute(goal);
		//
		//		// �Ԃ₫���X�g���擾���āA���N�G�X�g�X�R�[�v�ɕۑ�
		//		GetGoalListLogic getGoalListLogic =
		//				new GetGoalListLogic();
		//		List<Goal> goalList = getGoalListLogic.execute();
		//		request.setAttribute("goalList", goalList);
		//
		//		// �t�H���[�h
		//		RequestDispatcher dispatcher = request.getRequestDispatcher(
		//				"/WEB-INF/jsp/goalsend.jsp");
		//		dispatcher.forward(request, response);
	}

}