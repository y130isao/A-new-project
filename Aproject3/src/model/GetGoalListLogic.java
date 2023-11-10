package model;

import java.util.List;

import dao.GoalDAO;

//public class GetGoalListLogic {
//    public List<Goal> execute(int accountId, String data_time) {
//        GoalDAO goalDAO = new GoalDAO();
//        List<Goal> goalList = goalDAO.getGoalsByAccountId(accountId, data_time);
//        return goalList;
//    
//	}
//}

public class GetGoalListLogic {
    public List<Goal> execute(int accountId, String data_time) {
        GoalDAO goalDAO = new GoalDAO();
        List<Goal> goalList = goalDAO.getGoalsByAccountId(accountId, data_time);
        return goalList; 
	}
}
