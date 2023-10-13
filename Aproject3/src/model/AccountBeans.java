package model;

import java.io.Serializable;

public class AccountBeans implements Serializable {
	private static final long serialVersionUID = 1L;

	private int accountId;
	private String loginId;
	private String pass;
	private String name;
	private int roleId;
	private int genId;

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
}
