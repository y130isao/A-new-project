package servlet;

import java.io.IOException;
import java.util.List;

import dao.GoalDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccountBeans;
import model.GetGoalListLogic;
import model.Goal;

@WebServlet("/GoalconfirmServlet")
public class GoalconfirmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = null;
        String mode = request.getParameter("mode");
        if (mode == null || mode.equals("back")) {
            path = "/WEB-INF/jsp/goal.jsp";
        } else {
            path = "/WEB-INF/jsp/goalsend.jsp";
            HttpSession session = request.getSession();
            session.invalidate();
        }

        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//���N�G�X�g�p�����[�^�̎擾
        request.setCharacterEncoding("UTF-8");
        String goalgenre1 = request.getParameter("goalgenre1");
        String goalgenre2 = request.getParameter("goalgenre2");
        String goalgenre3 = request.getParameter("goalgenre3");
        String goal1 = request.getParameter("goal1");
        String goal2 = request.getParameter("goal2");
        String goal3 = request.getParameter("goal3");
        
//        Goal goal = new Goal(goalgenre1, goalgenre2, goalgenre3, goal1, goal2, goal3);
//        HttpSession session = request.getSession();
//        session.setAttribute("goal", goal);
//        
        //�Z�b�V�����X�R�[�v�ɕۑ����ꂽ�A�J�E���g�����擾
        HttpSession session = request.getSession();
        AccountBeans account = (AccountBeans) session.getAttribute("account");
        
//        session.removeAttribute("account");
     

        if (account != null) {
            int accountId = account.getAccountId();

            // ������ Goal �I�u�W�F�N�g���쐬�� accountId ���Z�b�g���Ďg�p
            Goal goal = new Goal(accountId, goal1, goal2, goal3, goalgenre1, goalgenre2, goalgenre3);

            // Goal �I�u�W�F�N�g���g�p���ĉ��炩�̑�����s��
            // ��: �f�[�^�x�[�X�ɕۑ�����ꍇ
            GoalDAO goalDAO = new GoalDAO();
            boolean success = goalDAO.create(goal, accountId);

            if (success) {
                // �f�[�^�x�[�X�ւ̕ۑ������������ꍇ�̏���

                // �ڕW���X�g���擾���āA���N�G�X�g�X�R�[�v�ɕۑ�
                GetGoalListLogic getGoalListLogic = new GetGoalListLogic();
                List<Goal> goalList = getGoalListLogic.execute(accountId);
                request.setAttribute("goalList", goalList);
//                HttpSession session = request.getSession();
//                session.setAttribute("goalList", goalList);

                // �t�H���[�h
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/goalconfirm.jsp");
                dispatcher.forward(request, response);
            } else {
                // �f�[�^�x�[�X�ւ̕ۑ������s�����ꍇ�̃G���[�n���h�����O
            }
        } else {
            // ���O�C�����Ă��Ȃ��ꍇ�̃G���[�n���h�����O
            // ���_�C���N�g�ȂǓK�؂ȏ������s��
        }
    }


}
