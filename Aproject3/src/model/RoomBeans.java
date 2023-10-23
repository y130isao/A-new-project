package model;

import java.io.Serializable;

public class RoomBeans implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String chara_level;
	private String chara_point;
	
	public RoomBeans() {}
	public RoomBeans(String id, String chara_level, String chara_point) {
		this.id = id;
		this.chara_level = chara_level;
		this.chara_point = chara_point;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChara_Level() {
		return chara_level;
	}

	public void setChara_Level(String chara_level) {
		this.chara_level = chara_level;
	}

	public String getChara_Point() {
		return chara_point;
	}

	public void setChara_Point(String chara_point) {
		this.chara_point = chara_point;
	}

}