package model;

import java.util.List;

import dao.CalRecordDAO;

public class GetCalRecordListLogic {
    public List<Record> execute(int recordId) {
        CalRecordDAO calrecordDAO = new CalRecordDAO();
        return calrecordDAO.getCalRecordsByAccountId(recordId);
    }
}
