package model;

import java.io.Serializable;

public class RoomBeans implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private int chara_level;
	private int chara_point;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChara_Level() {
		return chara_level;
	}

	public void setChara_Level(int chara_level) {
		this.chara_level = chara_level;
	}

	public int getChara_Point() {
		return chara_point;
	}

	public void setChara_Point(int chara_point) {
		this.chara_point = chara_point;
	}

}