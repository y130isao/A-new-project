package model;

import dao.GoalDAO;

public class PostGoalLogic {
    public void execute(Goal goal, int accountId) {
        GoalDAO dao = new GoalDAO();
        dao.create(goal, accountId); 
    }
}
