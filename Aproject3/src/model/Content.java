package model;

import java.io.Serializable;

public class Content implements Serializable{
	private String exercise;
	private String eat;
	private String sleep;
	public Content(){}
	public Content(String exercise,String eat,String sleep){
		this.exercise=exercise;
		this.eat=eat;
		this.sleep=sleep;
	}
	public String getExercise() {
		return exercise;
	}
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}
	public String getEat() {
		return eat;
	}
	public void setEat(String eat) {
		this.eat = eat;
	}
	public String getSleep() {
		return sleep;
	}
	public void setSleep(String sleep) {
		this.sleep = sleep;
	}

}
