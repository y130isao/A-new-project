package model;


import java.util.List;

import dao.GoalDAO;

public class GetGoalListLogic {
  public List<Goal> execute() { 
    GoalDAO dao = new GoalDAO();
    List<Goal> goalList = dao.findAll();
    return goalList;
  }
}