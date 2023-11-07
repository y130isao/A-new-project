package model;

import java.util.List;

import dao.CalRecordDAO;

public class GetCalRecordListLogic {
    public List<CalRecord> execute(int accountId) {
        CalRecordDAO calrecordDAO = new CalRecordDAO();
        return calrecordDAO.getCalRecordsByAccountId(accountId);
    }
}
