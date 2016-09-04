package org.shenit.tutorial.accountbalance.services;

import java.util.List;

import org.shenit.tutorial.accountbalance.domains.UserAccount;
import org.shenit.tutorial.accountbalance.domains.UserAccountsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation to UserAccountsService
 * @author jiangnan
 *
 */
@Service
public class UserAccountsServiceImpl implements UserAccountsService {
	@Autowired private UserAccountsMapper userAccountsMapper;

	@Override
	public List<UserAccount> getAccounts() {
		return userAccountsMapper.findAll();
	}

}
