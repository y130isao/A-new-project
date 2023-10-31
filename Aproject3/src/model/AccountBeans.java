package model;

import java.io.Serializable;
import java.util.Date;

public class AccountBeans implements Serializable {
	private static final long serialVersionUID = 1L;

	private int accountId;
	private String loginId;
	private String pass;
	private String name;
	private int roleId;
	private int genId;
	private int charaLevel;
	private int charaPoint;
	public Date dateTime;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accuountId) {
		this.accountId = accuountId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getGenId() {
		return genId;
	}

	public void setGenId(int genId) {
		this.genId = genId;
	}

	public int getCharaLevel() {
		return charaLevel;
	}

	public void setCharaLevel(int charaLevel) {
		if (charaLevel < 1) {
			charaLevel = 1;
		}
		if (charaLevel > 5) {
			charaLevel = 5;
		}
		this.charaLevel = charaLevel;
	}

	public int getCharaPoint() {
		return charaPoint;
	}

	public void setCharaPoint(int charaPoint) {
		if (charaPoint < 0) {
			charaPoint = 0;
		}
		if (charaPoint > 450) {
			charaPoint = 450;
		}
		this.charaPoint = charaPoint;
	}
	
	public Date getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
}
