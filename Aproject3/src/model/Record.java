package model;

public class Record {

	private int accountId;  // accountId フィールドを追加
    private boolean do_result1;
    private boolean do_result2;
    private boolean do_result3;
    private String memo_list1;
    private String memo_list2;
    private String memo_list3;
    
    public Record(int accountId, boolean do_result1, boolean do_result2, boolean do_result3, String memo_list1, String memo_list2, String memo_list3) {
        this.accountId = accountId;
        this.do_result1 = do_result1;
        this.do_result2 = do_result2;
        this.do_result3 = do_result3;
        this.memo_list1 = memo_list1;
        this.memo_list2 = memo_list2;
        this.memo_list3 = memo_list3;
    }
    
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public boolean getDo_result1() {
        return do_result1;
    }
    public void setDo_result1(boolean do_result1) {
        this.do_result1 = do_result1;
    }
    public boolean getDo_result2() {
        return do_result2;
    }
    public void setDo_result2(boolean do_result2) {
        this.do_result2 = do_result2;
    }
    public boolean getDo_result3() {
        return do_result3;
    }
    public void setDo_result3(boolean do_result3) {
        this.do_result3 = do_result3;
    }
    public String getMemo_list1() {
        return memo_list1;
    }
    public void setMemo_list1(String memo_list1) {
        this.memo_list1 = memo_list1;

    }
    public String getMemo_list2() {
        return memo_list2;
    }
    public void setMemo_list2(String memo_list2) {
        this.memo_list2 = memo_list2;

    }
    public String getMemo_list3() {
        return memo_list3;
    }
    public void setMemo_list3(String memo_list3) {
        this.memo_list3 = memo_list3;
         }
}