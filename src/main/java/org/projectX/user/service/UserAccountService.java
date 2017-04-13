package org.projectX.user.service;

import java.util.List;

import javax.persistence.NoResultException;

import org.projectX.user.model.UserAccount;

/*
 * 
 * We need to change UserAccount to UserAccountDTO later iks de
 *
 */
public interface UserAccountService {
	
	List<UserAccount> getAllUserAccounts();
	
	UserAccount getUserAccountById(Long id);
	
	UserAccount createUserAccount(UserAccount userAccount);
	
	UserAccount updateUserAccount(UserAccount userAccount) throws NoResultException;
	
	void deleteUserAccount(Long id) throws NoResultException;

	UserAccount loadUserByUsername(String username);
	
}
