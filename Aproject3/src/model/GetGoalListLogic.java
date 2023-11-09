package model;

import java.util.List;

import dao.GoalDAO;

public class GetGoalListLogic {
    public List<Goal> execute(int accountId) {
        GoalDAO goalDAO = new GoalDAO();
        List<Goal> goalList = goalDAO.getGoalsByAccountId(accountId);
        return goalList;
    
	}
}
