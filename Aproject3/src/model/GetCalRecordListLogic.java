package model;

import java.util.List;

import dao.CalRecordDAO;

public class GetCalRecordListLogic {
    public List<Record> execute(String dayString, AccountBeans ab) {
        CalRecordDAO calrecordDAO = new CalRecordDAO();
        return calrecordDAO.getCalRecordsByAccountId(dayString , ab);
    }
}
