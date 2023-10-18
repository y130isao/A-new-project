package model;

import java.io.Serializable;

public class Goal implements Serializable{
	private String goalgenre1;
	private String goalgenre2;
	private String goalgenre3;
	private String goal1;
	private String goal2;
	private String goal3;
	
	public Goal(){}
	public Goal(String goal1,String goal2,String goal3,String goalgenre1,String goalgenre2,String goalgenre3){
		this.goalgenre1=goalgenre1;
		this.goalgenre2=goalgenre2;
		this.goalgenre3=goalgenre3;
		this.goal1=goal1;
		this.goal2=goal2;
		this.goal3=goal3;
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
