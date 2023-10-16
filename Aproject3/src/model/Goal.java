package model;

import java.io.Serializable;

public class Goal implements Serializable{
	private String exercise;
	private String meal;
	private String sleep;
	public Goal(){}
	public Goal(String exercise,String meal,String sleep){
		this.exercise=exercise;
		this.meal=meal;
		this.sleep=sleep;
	}
	public String getExercise() {
		return exercise;
	}
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getSleep() {
		return sleep;
	}
	public void setSleep(String sleep) {
		this.sleep = sleep;
	}

}
