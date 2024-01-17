package com.study.servlet_study.service;
	
import com.study.servlet_study.entity.Account;
import com.study.servlet_study.repository.AccountReposiitory;

public class AccountService {
	private static AccountService instance;
	private AccountReposiitory accountReposiitory;
	
	private AccountService() {
		accountReposiitory = AccountReposiitory.getInstance();
	}			
	
	public static AccountService getInstance() {
		if (instance == null) {
			instance = new AccountService();
		}
		return instance;
	}
	
	public int addAccount(Account account) {
		return accountReposiitory.saveAccount(account);
	}
	
	public Account getAccount(String username) {
		return accountReposiitory.findAccountByUsername(username);
	}
}
