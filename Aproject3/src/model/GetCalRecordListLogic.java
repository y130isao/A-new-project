package model;

import java.util.List;

import dao.CalRecordDAO;

public class GetCalRecordListLogic {

	public List<Record> executeR(String dayString, AccountBeans ab) {
		CalRecordDAO calrecordDAO = new CalRecordDAO();
		return calrecordDAO.getCalRecordsByAccountId(dayString, ab);
	}

	public List<Goal> executeG(String dayString, AccountBeans ab) {
		CalRecordDAO calrecordDAO = new CalRecordDAO();
		return calrecordDAO.getGoalByAccountId(dayString, ab);
	}
}
