package org.shenit.tutorial.accountbalance.web;

import java.util.List;

import org.shenit.tutorial.accountbalance.domains.UserAccount;
import org.shenit.tutorial.accountbalance.services.UserAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User account controller
 * @author jiangnan
 *
 */
@RestController
@RequestMapping("/accounts")
public class UserAccountController {
	@Autowired private UserAccountsService userAccountsService;
	/**
	 * GET /accounts/
	 * @return
	 */
	@RequestMapping("/")
	public List<UserAccount> index(){
		return userAccountsService.getAccounts();
	}
}
