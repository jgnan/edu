package org.shenit.tutorial.accountbalance.services;

import java.util.List;

import org.shenit.tutorial.accountbalance.domains.UserAccount;

/**
 * User account services.
 * @author jiangnan
 *
 */
public interface UserAccountsService {
	/**
	 * Get all accounts
	 * @return
	 */
	List<UserAccount> getAccounts();
}
