package model;

public class Record {

	private int accountId; // accountId フィールドを追加
	private boolean do_result1;
	private boolean do_result2;
	private boolean do_result3;
	private String memo_list1;
	private String memo_list2;
	private String memo_list3;
	private String goalgenre1;
	private String goalgenre2;
	private String goalgenre3;
	private String goal1;
	private String goal2;
	private String goal3;


	public Record() {

	}

	public Record(int accountId, boolean do_result1, boolean do_result2, boolean do_result3, String memo_list1,
			String memo_list2, String memo_list3, String goalgenre1, String goalgenre2, String goalgenre3, String goal1, String goal2, String goal3) {
		this.accountId = accountId;
		this.do_result1 = do_result1;
		this.do_result2 = do_result2;
		this.do_result3 = do_result3;
		this.memo_list1 = memo_list1;
		this.memo_list2 = memo_list2;
		this.memo_list3 = memo_list3;
		this.goalgenre1 = goalgenre1;
		this.goalgenre2 = goalgenre2;
		this.goalgenre3 = goalgenre3;
		this.goal1 = goal1;
		this.goal2 = goal2;
		this.goal3 = goal3;
		
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
	
	public String getGoalgenre1() {
		return goalgenre1;
	}

	public void setGoalgenre1(String goalgenre1) {
		this.goalgenre1 = goalgenre1;
	}

	public String getGoalgenre2() {
		return goalgenre2;
	}

	public void setGoalgenre2(String goalgenre2) {
		this.goalgenre2 = goalgenre2;
	}

	public String getGoalgenre3() {
		return goalgenre3;
	}

	public void setGoalgenre3(String goalgenre3) {
		this.goalgenre3 = goalgenre3;
	}

	public String getGoal1() {
		return goal1;
	}

	public void setGoal1(String goal1) {
		this.goal1 = goal1;
	}

	public String getGoal2() {
		return goal2;
	}

	public void setGoal2(String goal2) {
		this.goal2 = goal2;
	}

	public String getGoal3() {
		return goal3;
	}

	public void setGoal3(String goal3) {
		this.goal3 = goal3;
	}

}

//package model;
//
//public class Record {
//
//	private int accountId; // accountId フィールドを追加
//	private boolean do_result1;
//	private boolean do_result2;
//	private boolean do_result3;
//	private String memo_list1;
//	private String memo_list2;
//	private String memo_list3;
//
//	public Record() {
//
//	}
//
//	public Record(int accountId, boolean do_result1, boolean do_result2, boolean do_result3, String memo_list1,
//			String memo_list2, String memo_list3) {
//		this.accountId = accountId;
//		this.do_result1 = do_result1;
//		this.do_result2 = do_result2;
//		this.do_result3 = do_result3;
//		this.memo_list1 = memo_list1;
//		this.memo_list2 = memo_list2;
//		this.memo_list3 = memo_list3;
//	}
//
//	public int getAccountId() {
//		return accountId;
//	}
//
//	public void setAccountId(int accountId) {
//		this.accountId = accountId;
//	}
//
//	public boolean getDo_result1() {
//		return do_result1;
//	}
//
//	public void setDo_result1(boolean do_result1) {
//		this.do_result1 = do_result1;
//	}
//
//	public boolean getDo_result2() {
//		return do_result2;
//	}
//
//	public void setDo_result2(boolean do_result2) {
//		this.do_result2 = do_result2;
//	}
//
//	public boolean getDo_result3() {
//		return do_result3;
//	}
//
//	public void setDo_result3(boolean do_result3) {
//		this.do_result3 = do_result3;
//	}
//
//	public String getMemo_list1() {
//		return memo_list1;
//	}
//
//	public void setMemo_list1(String memo_list1) {
//		this.memo_list1 = memo_list1;
//
//	}
//
//	public String getMemo_list2() {
//		return memo_list2;
//	}
//
//	public void setMemo_list2(String memo_list2) {
//		this.memo_list2 = memo_list2;
//
//	}
//
//	public String getMemo_list3() {
//		return memo_list3;
//	}
//
//	public void setMemo_list3(String memo_list3) {
//		this.memo_list3 = memo_list3;
//	}