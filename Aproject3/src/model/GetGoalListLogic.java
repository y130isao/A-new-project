package model;

import java.util.List;

import dao.GoalDAO;

public class GetGoalListLogic {
    public List<Goal> execute(int accountId) {
        GoalDAO goalDAO = new GoalDAO();
        return goalDAO.getGoalsByAccountId(accountId);
    }
}
