package model;

import dao.GoalDAO;

public class PostGoalLogic {
  public void execute(Goal goal) { 
    GoalDAO dao = new GoalDAO();
    dao.create(goal);
  }
}