package org.shenit.tutorial.accountbalance.domains;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAccountsMapper {
	List<UserAccount> findAll();
}
