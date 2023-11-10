package model;

import java.util.List;

import dao.RecordDAO;

public class GetRecordListLogic {
    public List<Record> execute(int accountId) {
    	RecordDAO recordDAO = new RecordDAO();
        return recordDAO.getRecordsByAccountId(accountId);
    }
}
