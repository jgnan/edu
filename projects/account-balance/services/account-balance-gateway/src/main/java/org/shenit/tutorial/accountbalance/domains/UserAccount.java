package org.shenit.tutorial.accountbalance.domains;

import java.io.Serializable;

/**
 * User account domain object.
 * @author jiangnan
 *
 */
public class UserAccount implements Serializable {
	private static final long serialVersionUID = -4058510345604431965L;
	public Long id;
	public Long userId;
	public java.math.BigDecimal accountBalance;
	public String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public java.math.BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(java.math.BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
