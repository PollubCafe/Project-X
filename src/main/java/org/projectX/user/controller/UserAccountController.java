package org.projectX.user.controller;


import java.util.List;

import org.projectX.user.model.UserAccount;
import org.projectX.user.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserAccountController {

	@Autowired
	private UserAccountService userAccountService;
	
	/**
	 * 
	 * @return all user accounts
	 */
	@RequestMapping( value="/all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserAccount>> getUserAccounts(){
		List<UserAccount> userAccounts = userAccountService.getAllUserAccounts();
		return new ResponseEntity<>(userAccounts,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param id - id of user account
	 * @return	user specified by id
	 */
	@RequestMapping(value="/account/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserAccount> getUserAccountById(@PathVariable("id") Long id ){
		UserAccount userAccount = userAccountService.getUserAccountById(id);
		return new ResponseEntity<>(userAccount,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param userAccount new user account info
	 * @return new user
	 */
	@RequestMapping(value="/create",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserAccount> createUserAccount(@RequestBody UserAccount userAccount){
		UserAccount createdUserAccount = userAccountService.createUserAccount(userAccount);
		return new ResponseEntity<>(createdUserAccount,HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param userAccount - data to update
	 * @return updated account information
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserAccount> updateUserAccount(@RequestBody UserAccount userAccount){
		UserAccount updatedUserAccount = userAccountService.updateUserAccount(userAccount);
		return new ResponseEntity<>(updatedUserAccount,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param id - id of deleting account
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public ResponseEntity deleteUserAccount(@PathVariable("id") Long id){
		userAccountService.deleteUserAccount(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
