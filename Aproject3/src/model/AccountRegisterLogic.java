package model;

import dao.AccountRegisterDAO;

public class AccountRegisterLogic {
	public void execute(AccountBeans ab) {
		AccountRegisterDAO dao = new AccountRegisterDAO();
		dao.create(ab);
	}
}
